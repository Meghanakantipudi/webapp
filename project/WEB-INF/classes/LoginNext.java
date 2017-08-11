import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.io.*;
public class LoginNext extends HttpServlet{    
public void service(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException   
 {        
String iden=req.getParameter("aadharno");   
System.out.println(iden);
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
ResultSet rs = stmt.executeQuery("select * from registration where iidentity='"+iden+"'");              
if(rs.next()) {
	String str = rs.getString(1);
	System.out.println(str);
	out.println("successful");  
}
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