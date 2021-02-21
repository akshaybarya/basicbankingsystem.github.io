
import java.sql.Connection;
import java.sql.DriverManager;


public class dbConnection {
    static Connection cn;
    static Connection getConnection()
    {
        try
        {
      Class.forName("com.mysql.jdbc.Driver");
   
        cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","123");    
        }
        catch(Exception e){
            
        }
        return cn;
        }
}
