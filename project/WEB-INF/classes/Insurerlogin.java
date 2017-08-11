import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.io.*;
public class Insurerlogin extends HttpServlet{    
public void service(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException   
 {        
String l_i_id=req.getParameter("l_i_id");        
String l_i_pwd=req.getParameter("l_i_pwd");               
Connection con=null;        
Statement stmt=null;        
PrintWriter out=res.getWriter();        
out.println("in servlet");
try       
{              
Class.forName("oracle.jdbc.driver.OracleDriver");              
con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","meghana" );              
stmt=con.createStatement();              
ResultSet rs = stmt.executeQuery("select * from insurer_registration where id='"+l_i_id+"' and pwd='"+l_i_pwd+"'");              
if(rs.next())  {              
out.println("Successfully"); 
System.out.println("Successfully"); 
}           
else {               
out.println("Unsuccessful");  
System.out.println("Unsuccessful");      
}        
}
catch(Exception e)        
{          out.println(e);               
 }   
} 
}