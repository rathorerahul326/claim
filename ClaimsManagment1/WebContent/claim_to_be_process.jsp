<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
<div>
<header  id="p1">
<br>

<p id="a1">Claims Management System 
<br><br>
<a href="RegistrationRequest" id="a2">User Request</a><br><br>
<a href="ClaimProcess" id="a2">Claims To Be Processed</a></p>
<br>
</header>
<h1><b>List of Claim</b></h1>
<table id="t1">
<tr>
  <th>Member Id</th>
  <th></th>
  <th></th>
  <th>Claim Id</th>
  <th></th>
  <th></th>
  <th>Open Claim</th>
 
  
</tr>
<c:forEach items="${claimListObj}" var="list" >
<tr>
  <td id="t11">${list.claimid}</td>
   <th></th>
  <th></th>
  <th></th>
  <th></th>
  <td id="t12">${list.memid}</td>
   <th></th>
  <th></th>
  <th></th>
  <th></th>
<td id="t17"><a href="ShowEachClaim?id=${list.claimid}">View</a></td> 
  
</tr>
</c:forEach>
</table>
</div>
</body>
</html>