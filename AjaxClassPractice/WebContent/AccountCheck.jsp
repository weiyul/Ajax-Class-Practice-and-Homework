<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*;" %>

<% 
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String url = "jdbc:sqlserver://localhost:1433;databaseName=Northwind";
		
		String query = "select * from Employees where FirstName=?";
		String name = request.getParameter("name");
		//String name = "Anne";
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			conn = DriverManager.getConnection(url, "sa", "passw0rd");
			//stmt = conn.createStatement();
			//stmt.setString(1, name);
			stmt = conn.prepareStatement(query);
			stmt.setString(1,name);
			System.out.println(name);
			rs = stmt.executeQuery();
			String strMsg = "帳號不存在";
			
			 //rs.next();
			 if(rs.next()){
				 strMsg =  "帳號已存在";
			 }
			 out.print(strMsg);//帳號不存在
		}
		catch(SQLException e){
			out.println("Error:" + e.getMessage());
		}
		finally{
			if(rs != null){
			   rs.close();
			}
			if(stmt != null){
			 stmt.close();
			}
			if(conn != null){
			}
		}
		 
		//}
%>