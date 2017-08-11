import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.io.*;
public class State_health_login extends HttpServlet{    
public void service(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException   
 {        
String l_s_id=req.getParameter("eds1");  
String l_s_loc=req.getParameter("eds2");  
String l_s_pwd=req.getParameter("eds3");               
Connection con=null;        
Statement stmt=null;        
PrintWriter out=res.getWriter();        
try       
{              
Class.forName("oracle.jdbc.driver.OracleDriver");              
con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","meghana" );              
stmt=con.createStatement();              
ResultSet rs = stmt.executeQuery("select * from state_health_department where id='"+l_s_id+"' and password='"+l_s_pwd+"'");              
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