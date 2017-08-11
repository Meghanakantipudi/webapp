import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.io.*;
import java.net.*;
public class ServletLoginExample extends HttpServlet{ 
public final String USER_AGENT = "Mozilla/5.0";   
public void service(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException   
 {        
        
String username=req.getParameter("id");        
String pass = (req.getParameter("id1"));          
Connection con=null;        
Statement stmt=null;        
PrintWriter out=res.getWriter();        
try       
{              
 String url = "http://localhost:7050/chaincode";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		//add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
	

		String urlParameters = "{ \"jsonrpc\": \"2.0\",\"method\": \"invoke\",\"params\": {\"type\": 1,\"chaincodeID\": {\"name\":\"SimpleSample\" },\"ctorMsg\": {\"function\": \"query\",\"args\":[\"username\", \"pass\"]},\"secureContext\": \"WebAppAdmin\"},\"id\": 0}";
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
