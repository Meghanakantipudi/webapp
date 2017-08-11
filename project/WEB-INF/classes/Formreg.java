import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.io.*;
public class Formreg extends HttpServlet{    
public void service(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException   
 {        
String Iname = req.getParameter("Iname");        
String Iidentity = req.getParameter("Iaadharno");  
System.out.println(Iidentity);
String Ination = (req.getParameter("Ination")); 
String Ibirth = req.getParameter("Ibirth"); 
String Ideath = req.getParameter("Ideath"); 
String Iplace = req.getParameter("Iplace");
String Nname = req.getParameter("n_name");
String Nidentity = req.getParameter("n_aadhar");
String Nrelation = req.getParameter("n_relation");
String Nnation = req.getParameter("n_nation");
String Nbirth = req.getParameter("nbirth");
String Noccupation = req.getParameter("noccupation"); 
String Mobile = req.getParameter("mobile");
String Certificate1 = req.getParameter("certificateno");
String Policy1 = req.getParameter("policyno");
String Password = req.getParameter("password");
System.out.println(Policy1);
Connection con=null;        
Statement stmt=null;        
PrintWriter out=res.getWriter();        
try       
{              
Class.forName("oracle.jdbc.driver.OracleDriver");              
con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","kusuma","latha001" );              
stmt=con.createStatement(); 
ResultSet r = stmt.executeQuery("select adhar_no from insurance_database where policy_no="+Policy1);
if(r.next()){
	System.out.println(r.getString(1).toString());
	if(r.getString(1).equals(Iidentity)){
			int i = stmt.executeUpdate("insert into registration values('"+Iname+"', '"+Iidentity+"', '"+Ination+"','"+Ibirth+"','"+Ideath+"','"+Iplace+"','"+Nname+"', '"+Nidentity+"', '"+Nrelation+"', '"+Nnation+"', '"+Nbirth+"', '"+Noccupation+"', '"+Mobile+"', '"+Certificate1+"','"+Policy1+"','"+Password+"')");              
			if(i>0)  {              
				out.println("Registration Successful");   
				System.out.println("Registration Successful");
			}else                
				out.println("Registration Unsuccessful"); 
				System.out.println("Registration Unsuccessful");
		}
		else{
			out.println("Details are not valid");
			System.out.println("Details are not valid");
		}
		}
else{
			out.println("Details are not valid");
			System.out.println("Details are not valid");
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