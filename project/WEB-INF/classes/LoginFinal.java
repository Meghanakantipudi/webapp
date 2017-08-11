import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.io.*;
public class LoginFinal extends HttpServlet{    
public void service(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException   
 {        
String username=req.getParameter("ename");        
String pass=req.getParameter("epassword");        
//int course=Integer.parseInt(req.getParameter("ecourse")); 
//String email=req.getParameter("eemail");         
Connection con=null;        
Statement stmt=null;        
PrintWriter out=res.getWriter();        
try       
{              
Class.forName("oracle.jdbc.driver.OracleDriver");              
con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","kusuma","latha001" );              
stmt=con.createStatement();              
ResultSet rs = stmt.executeQuery("select * from voters where name='"+username+"' and password='"+pass+"'");              
if(rs.next())                
out.println("Successfully");              
else                
out.println("Unsuccessful");        
}        
catch(Exception e)        
{          out.println(e);               
 }    
finally{
try{
stmt.close();
con.close();
}catch(Exception ex){
ex.printStackTrace();
}
}
}
}