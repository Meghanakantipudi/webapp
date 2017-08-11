
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.io.*;
public class Hospitaldetails extends HttpServlet{    
public void service(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException   
 {        
String pid = req.getParameter("p_id");         
String prsn = (req.getParameter("p_rsn")); 
String pdt = req.getParameter("p_dt_tm"); 
Connection con=null;        
Statement stmt=null;        
PrintWriter out=res.getWriter();        
try       
{              
Class.forName("oracle.jdbc.driver.OracleDriver");              
con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","meghana" );              
stmt=con.createStatement(); 
stmt=con.createStatement(); 
String sql = "insert into hospital_details values('"+pid+"', '"+prsn+"', '"+pdt+"')";
int r = stmt.executeUpdate(sql);
if(r != 0){
	out.println("Insertion Successfull");
}
else{
out.println("Insertion Unsuccessfull");
}
		}

			catch(Exception e)        
			{          out.println(e);               
			 }
		finally{
			try{
			stmt.close();
			//con.close();
			}
			catch(Exception ex){
			ex.printStackTrace();
			}
		}
    
	}
}