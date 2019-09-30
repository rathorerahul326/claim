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

<form action="MemberRegistration" method="post">
<div>
<div class="container">
<h3>${errormsg1}</h3>
<h1><b>Member Registration</b></h1>
First Name:<input type="text" name= "fname" id="fnameid" required><br><br>
Last Name:<input type="text" name= "lname" id="lnameid" required><br><br>
Age: <input type="number" name="age" id="ageid" required><span id="spmn"></span><br><br>
Gender: <select name="gender">
  <option value="male">Male</option>
  <option value="female">Female</option>
</select><br><br>
Contact Number:<input type="number" name= "contactnumber" id="contactnumberid" required><br><br>
Member Id:<input type="text" name= "member" id="memberid" required><br><br>
Password:<input type="text" name= "password" id="passwordid" required><br><br>
Email id:<input type="email" name= "email" id="emailid" required><br><br>
<button value="Register">Submit</button>



</div>
</div>
</form>
</body>
</html>