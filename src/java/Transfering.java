
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Transfering extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String Amount = request.getParameter("amount");
            int amount = Integer.parseInt(Amount);
            String sender = request.getParameter("sender");
            String reciever = request.getParameter("reciever");
            
            if(sender.equals(reciever) || Amount.equals("0")){
                out.println("Selected wrong Benifficiary or wrong amount");
                RequestDispatcher rd = request.getRequestDispatcher("Transfer");
            rd.include(request, response);
            }
            else{
           // out.println(amount);
          //  out.println(reciever);
          //  out.println(sender);
            
            Connection cn = dbConnection.getConnection();
            
                try {
                    Statement smt = cn.createStatement();
                    
                    ResultSet res1 = smt.executeQuery("select balance  from customer where cid='"+sender+"'");
                    int senderbalance=0;
                    String sendername = "";
                    while(res1.next()){
                        senderbalance = Integer.parseInt(res1.getString(1));
                     //  
                    }
                    ResultSet res6 = smt.executeQuery("select cname from customer where cid='"+sender+"'");
                    while(res6.next()){
                         sendername = res6.getString(1);
                    }
                    ResultSet res2 = smt.executeQuery("select balance from customer where cid='"+reciever+"'");
                    int recieverbalance=0;
                    String recievername = "";
                    while(res2.next()){
                        recieverbalance = Integer.parseInt(res2.getString(1));
                        //recievername = res1.getString(2);
                    }
                    ResultSet res7 = smt.executeQuery("select cname from customer where cid='"+reciever+"'");
                    while(res7.next()){
                         recievername = res7.getString(1);
                    }
                    
                    if(amount>senderbalance){
                       out.println("<script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>");
                    out.println("<script>\n" +
"window.onload = function() {\n" +
"  popUp()}\n" +
"\n" +
"function popUp(){\n" +
"	swal(\"INSUFFICIENT BALANCE!\", \"TRANSACTION FAILED!\", \"error\");\n" +
"}\n" +
"</script>");
                       RequestDispatcher rd2 = request.getRequestDispatcher("Serv");
                       rd2.include(request, response); 
                    }else{
                    int b = senderbalance ;
                    senderbalance = b-amount;
                    recieverbalance = amount+recieverbalance ;
                    
                    
                                     
                    int x = smt.executeUpdate("update customer set balance='"+senderbalance+"'where cid='"+sender+"'");
                    //out.println("<br><br><a href=index.html>Home</a>");
                    
                    int y = smt.executeUpdate("update customer set balance='"+recieverbalance+"'where cid='"+reciever+"'");
                    
                    if(x>0){
                    
                    int z = smt.executeUpdate("insert into transactions(sender ,reciever , amount , time) value('"+sendername+"' , '"+recievername+"' , '"+Amount+"' ,'"+java.time.LocalDateTime.now()+"')");
                    
                    out.println("<script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>");
                    out.println("<script>\n" +
"window.onload = function() {\n" +
"  popUp()}\n" +
"\n" +
"function popUp(){\n" +
"	swal(\"SUCCESS!\", \"TRANSACTION SUCCESSFULL!\", \"success\");\n" +
"}\n" +
"</script>");
                    }else{
                    out.println("<script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>");
                    out.println("<script>\n" +
"window.onload = function() {\n" +
"  popUp()}\n" +
"\n" +
"function popUp(){\n" +
"	swal(\"FAIL!\", \"TRANSACTION FAILED!\", \"error\");\n" +
"}\n" +
"</script>");
                    }
                    RequestDispatcher rd = request.getRequestDispatcher("Serv");
                    rd.include(request,response);
                    }} catch (Exception ex) {
                    out.println(ex);
                }
                
            
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
