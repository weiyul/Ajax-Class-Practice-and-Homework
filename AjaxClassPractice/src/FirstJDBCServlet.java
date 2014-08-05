

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

import java.util.LinkedHashMap; 
import java.util.Map;  
import java.util.HashMap;
import java.util.LinkedList; 
import java.util.List;

import org.json.simple.JSONValue;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
/**
 * Servlet implementation class FirstJDBCServlet
 */
@WebServlet("/FirstJDBCServlet")
public class FirstJDBCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
/*       
    *//**
     * @see HttpServlet#HttpServlet()
     *//*
    public FirstJDBCServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	*//**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 *//*
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String url = "jdbc:sqlserver://localhost:1433;DatabaseName=Northwind";
		String query = "select ProductID,ProductName,UnitPrice from Products where CategoryID=1";
		try{
			DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
			conn = DriverManager.getConnection(url, "sa", "sa123456");
			
			stmt = conn.createStatement();
			
			 rs = stmt.executeQuery(query);
			 
			 //輸出HTML
//     		 out.println("<HTML><HEAD><TITLE>Products</TITLE></HEAD>");
//		      out.println("<BODY>");
//		      out.println("<table><tr><th>產品編號 </th><th>產品名稱</th><th>產品價格</th></tr>");
//
//			 while (rs.next()) {
//				 
//				 out.println("<tr><td>" + rs.getInt("ProductID") + "</td><td>"
//				            + rs.getString("ProductName") + "</td><td>" + rs.getDouble("UnitPrice") + "</td></tr>");
//			     
//			 }	
//			 out.println("</table>");
//		      out.println("</BODY></HTML>");
			 
			 //輸出JSON
			 List  l1 = new LinkedList();
			 while (rs.next()) {
				 Map m1 = new HashMap();     
				 m1.put("ProductID",rs.getInt("ProductID"));   
				 m1.put("ProductName", rs.getString("ProductName")); 
				 m1.put("UnitPrice",rs.getDouble("UnitPrice")); 
				 l1.add(m1);
			 }
			 String jsonString = JSONValue.toJSONString(l1);                    
			 out.println(jsonString);
			 
			 
		}
		catch(SQLException e){
			System.out.println("Error:" + e.getMessage());
		}
		finally{
			
		}
	}

	*//**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 *//*
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}
	
	private Document resultSet2Dom(ResultSet rs,String rootElementName){
	    Document myDocument = null;
	    try{
	      myDocument = ((DocumentBuilderFactory.newInstance()).newDocumentBuilder()).newDocument();
	    }catch(ParserConfigurationException pce){
	      //todo 
	    }
	    Element root = myDocument.createElement(rootElementName);
	    root.setAttribute("xmlns:xsi","http://www.w3.org/2001/XMLSchema-instance");
	    myDocument.appendChild(root);
	    ResultSetMetaData rsmd = rs.getMetaData();
	    Element element,row;
	    String value;
	    if(rs.next()){
	       rs.previous();//使用rs.next()来判断结果集是否有至少一条数据，如果有就将游标退回初始位置准备开始遍历。
	       while(rs.isLast() == false){
	        rs.next();
	        row = myDocument.createElement(ROW_ELEMENT_NAME);
	        root.appendChild(row);
	        for(int i=1;i<=rsmd.getColumnCount();i++){
	          element = myDocument.createElement(rsmd.getColumnLabel(i).toLowerCase());
	          int columnType = rsmd.getColumnType();//此处得到列类型是方便对特殊类型数据的处理，比如当数据是浮点型时四舍五入。本例略
	          value = rs.getString(i);
	          if(value == null){
	            element.setAttribute("xsi:nil","true");
	          }else{
	            element.appendChild(myDocument.createTextNode(value));
	          }
	          row.appendChild(element);
	       }
	    }
	    return myDocument;
	   }
	}*/

}
