<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="menu.jsp" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Leads</title>
</head>
<body>
<a href="viewCreateLeadPage">new Lead</a>
<h2>All leads</h2>

<table>
   <tr>
      <th>FirstName</th>
      <th>LastName</th>
      <th>Email</th>
      <th>Mobile</th>
      <th>Source</th>
      <th>Delete</th>
      <th>update</th>
   
   </tr>
 
   <c:forEach var="lead" items="${leads}">
   <tr>
       <td><a href="leadInfo?id=${lead.id}">${lead.firstName}</a></td>
       <td>${lead.lastName}</td>
       <td>${lead.email}</td>
       <td>${lead.mobile}</td>
       <td>${lead.source}</td>
       <td><a href="delete?id=${lead.id}">delete</a></td>
       <td><a href="update?id=${lead.id}">update</a></td>
   </tr>
   </c:forEach>
   
</table>

</body>
</html>