import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.io.*;
public class Nominee_details extends HttpServlet{    
public void service(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException   
 {        

//String policy=req.getParameter("policyid");
String nomid=(req.getParameter("nomid")); 
String result="";     
Connection con=null;        
Statement stmt=null;        
PrintWriter out=res.getWriter();        
try       
{              
Class.forName("oracle.jdbc.driver.OracleDriver");              
con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","meghana" );              
stmt=con.createStatement();              
ResultSet rs = stmt.executeQuery("select nname,nidentity,nrelation,nnation,nbirth,noccupation,mobile,policy from Registration where iidentity='"+nomid+"'");              
while(rs.next())                
{
result=result+rs.getString(7) + ":" + rs.getString(8) + ":"+ rs.getString(9) + ":"+ rs.getString(10) + ":"+ rs.getString(11) + ":"+ rs.getString(12) + rs.getString(14)+"$";
}	
System.out.println(result);
out.println(result);

       
}        
catch(Exception e)        
{          out.println(e);               
 }    
}}