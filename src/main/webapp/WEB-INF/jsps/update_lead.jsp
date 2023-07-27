<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update</title>
</head>
<body bgcolor="lightblue">
<h2>Update Lead</h2>
<form action="updateLead" method="post">

<input type="hidden" name="id" value="${lead.id}"/>
First Name<input type="text" name="firstName" value="${lead.firstName}"/>
Last Name<input type="text" name="lastName" value="${lead.lastName}"/>
Email<input type="text" name="email" value="${lead.email}"/>
Mobile<input type="text" name="mobile" value="${lead.mobile}"/>

<input type="submit" value="update"/>
${msg}
</form>
</body>
</html>