import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.io.*;
public class Hospitalreg extends HttpServlet{    
public void service(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException   
 {        
String hid = req.getParameter("h_id");         
String hname = req.getParameter("name"); 
String hadd = req.getParameter("address"); 
String hpwd = req.getParameter("password"); 
Connection con=null;        
Statement stmt=null;        
PrintWriter out=res.getWriter();        
try       
{              
Class.forName("oracle.jdbc.driver.OracleDriver");              
con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","meghana" );              
stmt=con.createStatement(); 
String sql = "insert into hospital_registration values('"+hid+"', '"+hname+"', '"+hadd+"', '"+hpwd+"')";
int r = stmt.executeUpdate(sql);
if(r != 0){
	out.println("Registration Successful");
	System.out.println("successfull");
}

else{
	out.println("Registration unsuccessful");

}
}

			catch(Exception e)        
			{          out.println(e);               
			 }
		finally{
			try{
			stmt.close();
			con.close();
			}
			catch(Exception ex){
			ex.printStackTrace();
			}
		}
    
	}
}


            