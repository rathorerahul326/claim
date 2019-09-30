<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>
<header  id="p1">
<br>
<a href="RegistrationRequest" id="a2">Pending Request</a>
<br>
<a href="ClaimProcess" id="a2">Process Claim</a></p>

</header>
<h3><b>Claim Id's</b></h3>
<table id="t1">
<tr>
  <th>Claim Id</th>
 
  
</tr>
<c:forEach items="${claimIdObj}" var="list" >
<tr>
  <td id="t11">${list.claimid}</td>
  
</tr>
</c:forEach>
</table>
</div>
</body>
</html>