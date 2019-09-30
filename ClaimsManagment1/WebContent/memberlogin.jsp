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
<form action="MemberLogin" method="post">
<div>
<div class="container">
<h3>${errormsg1}</h3>

<h1><b>Member Login</b></h1>
Member id:<input type="text" name= "memberid" id="memberid" required><br><br>
Password:<input type="text" name= "password" id="passwordid" required><br><br>
<button value="Register">Member Login</button>



</div>
</div>
</form>
</body>
</html>