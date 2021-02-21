
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Transaction extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            try{
            Connection cn = dbConnection.getConnection();
                
            Statement smt = cn.createStatement();
            
            ResultSet res = smt.executeQuery("select * from Transactions");
            
            out.println("<html>\n" +
"    <head>\n" +
"        <meta charset=\"utf-8\">\n" +
"        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\n" +
"  		<title>Basic Banking System</title>\n" +
"\n" +
"        <meta name=\"description\" content=\"\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
"        <link rel=\"apple-touch-icon\" href=\"apple-touch-icon.png\">\n" +
"\n" +
"        <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">\n" +
"        <link rel=\"stylesheet\" href=\"css/bootstrap-theme.min.css\">\n" +
"        <link rel=\"stylesheet\" href=\"css/fontAwesome.css\">\n" +
"        <link rel=\"stylesheet\" href=\"css/light-box.css\">\n" +
"        <link rel=\"stylesheet\" href=\"css/templatemo-style.css\">\n" +
"\n" +
"        <link href=\"https://fonts.googleapis.com/css?family=Kanit:100,200,300,400,500,600,700,800,900\" rel=\"stylesheet\">\n" +
"\n" +
"        <script src=\"js/vendor/modernizr-2.8.3-respond-1.4.2.min.js\"></script>\n" +
"    </head>\n" +
"\n" +
"<body>\n" +
"\n" +
"    <nav>\n" +
"        <div class=\"logo\">\n" +
"            <a href=\"index.html\">The Sparks Foundation</a>\n" +
"        </div>\n" +
"        \n" +"<div style=\"float:right; font-size:22px ; margin-top:25px;\"><span style=color:white; class=\"glyphicon glyphicon-user\"></span><a href=index.html style=\" color:white ; text-decoration: none ;\">  HOME &nbsp;&nbsp;&nbsp;&nbsp;</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=color:white; class=\"glyphicon glyphicon-phone\"></span><a href=Serv style=\" color:white ; text-decoration: none ;\">  ALL CUSTOMERS &nbsp;&nbsp;&nbsp;&nbsp;</a></div>"+
"     \n" +
"    </nav>\n" +
"\n" +
"    <div id=\"video-container\">\n" +
"        <div class=\"video-overlay\"></div>\n" +
"        <div class=\"video-content\">\n" +
"            <div class=\"inner\">");
            out.println("<table class=table align=center border=2px style=\"color:whitesmoke ; opacity: 1 ;width:800px ; margin-top:0px ; cell-padding:20px ;\">");
            out.println("<caption><h1>All Transactions</h1></caption>");
            out.println("<thead><tr><th><center>Transaction id</center></th><th><center>Sender Name</center></th><th><center>Reciever Name</center></th><th><center>Transaction Amount</center></th><th><center>&nbsp;&nbsp;&nbsp;Transaction Time &nbsp;&nbsp;&nbsp;</center></th></tr></thead>");
            out.println("<tbody>");
            while(res.next()){
                String tid = res.getString(1);
                String s = res.getString(2);
                String r = res.getString(3);
                String a = res.getString(4);
                String t = res.getString(5);
                out.println("<tr><td><center>"+tid+"</center></td><td><center>"+s+"</center></td><td><center>"+r+"</center></td><td><center>"+a+"</center></td><td><center>"+t+"</center></td></tr>");
            }
            out.println("</tbody></table>");
            out.println("</div>\n" +
"        </div>\n" +
"        <video autoplay=\"\" loop=\"\" muted>\n" +
"        	<source src=\"highway-loop.mp4\" type=\"video/mp4\" />\n" +
"        </video>\n" +
"    </div>\n" +
"\n" +
"\n" +
"\n" +
"    <footer>\n" +
"        <div class=\"container-fluid\">\n" +
"            <div class=\"col-md-12\">\n" +
"                <p>Copyright &copy; 2021 The Sparks Foundation \n" +
"    \n" +
"    | Designed by Akshay Kumar Barya</p>\n" +
"            </div>\n" +
"        </div>\n" +
"    </footer>\n" +
"    \n" +
"    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js\"></script>\n" +
"    <script>window.jQuery || document.write('<script src=\"js/vendor/jquery-1.11.2.min.js\"><\\/script>')</script>\n" +
"\n" +
"    <script src=\"js/vendor/bootstrap.min.js\"></script>\n" +
"    \n" +
"    <script src=\"js/plugins.js\"></script>\n" +
"    <script src=\"js/main.js\"></script>\n" +
"\n" +
"    \n" +
"</body>\n" +
"</html>");
            }
            catch(Exception e){
                out.println(e);
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
