import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.io.*;
import java.net.*;
public class Formlog extends HttpServlet{
	public final String USER_AGENT = "Mozilla/5.0";
public void service(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException   
 {  
	String death_no;
String Policyno=req.getParameter("Policy_no");        
String Password=req.getParameter("Password");        
//int course=Integer.parseInt(req.getParameter("ecourse")); 
//String email=req.getParameter("eemail");         
Connection con1=null;        
Statement stmt=null;        
PrintWriter out=res.getWriter();        
try       
{              
Class.forName("oracle.jdbc.driver.OracleDriver");              
con1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","kusuma","latha001" );              
stmt=con1.createStatement();              
ResultSet rs = stmt.executeQuery("select * from registration where policy='"+Policyno+"' and password='"+Password+"'");              
if(rs.next()) {
	
	//out.println("Successfully");  
	ResultSet rs1 = stmt.executeQuery("select certificate from registration where policy="+Policyno);
	if(rs1.next()){
	death_no = rs1.getString(1);
	System.out.println(death_no);
	try{
		String url = "http://localhost:7050/chaincode";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		//add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
	

		String urlParameters = "{\"jsonrpc\":\"2.0\",\"method\":\"query\",\"params\":{\"type\":1,\"chaincodeID\":{\"name\":\"SimpleSample\"},\"ctorMsg\":{\"function\":\"query\",\"args\":[\""+death_no+"\"]},\"secureContext\":\"WebAppAdmin\"},\"id\":0}";

		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		System.out.println(response.toString());
		out.println(response.toString());

	}
	catch(Exception e){
		e.printStackTrace();
	}
}
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
con1.close();
}catch(Exception ex){
ex.printStackTrace();
}
}
}
}