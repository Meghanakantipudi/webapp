import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.io.*;
public class Applicant_details extends HttpServlet{    
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
ResultSet rs = stmt.executeQuery("select iname,iidentity,ination,ibirth,ideath,iplace from Registration where iidentity='"+nomid+"'");              
while(rs.next())                
{
result=result+rs.getString(1) + ":" + rs.getString(2) + ":"+ rs.getString(3) + ":"+ rs.getString(4) + ":"+ rs.getString(5) + ":"+ rs.getString(6) + "$";
}	
System.out.println(result);
out.println(result);

       
}        
catch(Exception e)        
{          out.println(e);               
 }    
}}