<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
           <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
<header  id="p1">
<br>

<h2 id="a1">Admin Home</h2>
<br>
<h3>${registered}</h3>
<br>
<a href="RegistrationRequest" id="a2">User Requests</a>
<br>
<a href="ClaimProcess" id="a2">Claims To Be Processed</a>
<br>
<a href="#" id="a2">Reports</a>
<br>
<a href="#" id="a2">Plan Codes</a>
<br>
<a href="#" id="a2">Processed Claims</a>
</header>

</body>
</html>