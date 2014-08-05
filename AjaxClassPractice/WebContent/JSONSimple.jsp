<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray" %>
 <%
//     JSONObject obj=new JSONObject();
//     obj.put("name","foo");
//     obj.put("num",new Integer(100));
//     obj.put("balance",new Double(1000.21));
//     obj.put("is_vip",new Boolean(true));
//     obj.put("nickname",null);
//     out.print(obj);
//     out.flush();
 JSONArray list = new JSONArray();
  list.add("foo");
  list.add(new Integer(100));
  list.add(new Double(1000.21));
  list.add(new Boolean(true));
  list.add(null);
  out.print(list);
  %>