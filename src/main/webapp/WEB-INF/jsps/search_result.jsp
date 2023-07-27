<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>leads</title>
</head>
<body bgcolor="lightblue">
<h2>List of all leads</h2>
<table border='1'>
<tr>
<th>First Name</th>
<th>Last Name</th>
<th>Email</th>
<th>Mobile</th>
<th>Action</th>
<th>Action</th>
</tr>
<c:forEach var="lead" items="${leads}">  
   <tr>
   <td>${lead.firstName}</td> 
   <td>${lead.lastName}</td>
   <td>${lead.email}</td>  
   <td>${lead.mobile}</td> 
   <td><a href="delete?id=${lead.id}">Delete</a></td> 
   <td><a href="update?id=${lead.id}">Update</a></td> 
   </tr>
</c:forEach> 

</table>
${msg}
</body>
</html>