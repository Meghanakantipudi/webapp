import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.io.*;
public class Hospitallogin extends HttpServlet{    
public void service(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException   
 {        
String l_h_id=req.getParameter("l_hid");        
String l_h_pwd=req.getParameter("l_hpwd");               
Connection con=null;        
Statement stmt=null;        
PrintWriter out=res.getWriter();        
try       
{              
Class.forName("oracle.jdbc.driver.OracleDriver");              
con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","meghana" );              
stmt=con.createStatement();              
ResultSet rs = stmt.executeQuery("select * from hospital_registration where id='"+l_h_id+"' and pwd='"+l_h_pwd+"'");              
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




       
            
           



