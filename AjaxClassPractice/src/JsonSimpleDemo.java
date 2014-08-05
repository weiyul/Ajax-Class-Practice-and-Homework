

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
/**
 * 
 * Servlet implementation class JsonSimpleDemo
 */
@WebServlet("/JsonSimpleDemo")
public class JsonSimpleDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JsonSimpleDemo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.setContentType("application/json");
		// Get the printwriter object from response to write the required json object to the output stream      
		PrintWriter out = response.getWriter();
		// Assuming your json object is **jsonObject**, perform the following, it will return your json object  
		
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
//		
//		String url = "jdbc:sqlserver://localhost:1433;DatabaseName=Northwind";
		String query = "select CustomerID from Customers where CustomerID like ?";
		//final String query = "SELECT * FROM Customers WHERE CustomerID = ?";
	    final String url = "jdbc:sqlserver://localhost:1433;DatabaseName=Northwind";
	    final String USER = "sa";
		final String PASSWORD = "passw0rd";
		String keyword = request.getParameter("term");
		keyword = keyword + "%";
		try{
			
			//DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
			// Load Microsoft JDBC Driver 1.0
		      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, USER, PASSWORD);
		
			stmt = conn.prepareStatement(query);
			stmt.setString(1, keyword);
			
			rs = stmt.executeQuery();
			JSONArray list = new JSONArray();
			 while (rs.next())
			 {
				 list.add(rs.getString(1));
			 }
			 out.print(list);
			
		}
		catch(SQLException e){
			out.println("Error:" + e.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			//if(rs != null){
			//   rs.close();
			//}
			//if(stmt != null){
			// stmt.close();
			//}
			//if(conn != null){
			//}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
