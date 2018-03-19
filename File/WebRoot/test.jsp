<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML>
<html>
  <head>
    <title>el表达式获取数据</title>
    <meta charset="utf-8" />
  </head>
  
  <body>
    <% 
        request.setAttribute("name","信平");
    %>
<c:out value="jjjj"></c:out>
  </body>
</html>