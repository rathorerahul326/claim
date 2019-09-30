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
<h2>Health Insurance Raise Claim Form</h2>
<hr>
<h3> Member's Information </h3>
<br>
<br>
<form action="ShowClaim?id=${x.getMemberid()}" method="post" enctype="multipart/form-data">
<table>
<tr> <td>Name: <c:out value='${x.getFname()}'></c:out> <c:out value='${x.getLname()}'></c:out></td>
</tr>
<tr> <td></td></tr>
<tr> <td></td></tr>
<tr> <td></td></tr>
<tr> <td> MemberId: <c:out value='${x.getMemberid()}'> </c:out></td></tr>
<tr> <td></td></tr>
<tr> <td></td></tr><tr> <td></td></tr><tr> <td></td></tr>
<tr>
<td>
Gender: <c:out value='${x.getGender()}'> </c:out>
</td>
</tr>
<tr> <td></td></tr><tr> <td></td></tr><tr> <td></td></tr>
<tr> <td> Age: <c:out value="${x.getAge()}"></c:out></td> <tr>
<tr> <td></td></tr><tr> <td></td></tr><tr> <td></td></tr>
<tr><td>Contact Number <c:out value='${x.getContactnumber()}'></c:out></td></tr>
<tr> <td></td></tr><tr> <td></td></tr><tr> <td></td></tr>
</table>
<hr>

<h3>Accident Details</h3>
<br>
<br>
<table cellpadding="5">
<tr> <th width='80px'> Work Accident</th> <th width='80px'> Auto Accident</th> <th width='80px'> Other</th></tr>
<tr>
<td><input type="radio" name="work_acc" value="Yes"> Yes
<input type="radio" name="work_acc" value="No"> No</td>

<td><input type="radio" name="auto_acc" value="Yes"/> Yes
<input type="radio" name="auto_acc" value="No"> No</td>

<td><input type="radio" name="other" value="Yes"> Yes
<input type="radio" name="other" value="No"> No </td>
</tr>
</table>
<br>
<br>
<table>
 <tr><th> Date Of Accident</th></tr> <tr><td> <input type="date" name="doA" placeholder="YYYY-MM-DD" required /></td>
</tr>
</table>
<hr>
<table>
<tr><th>
Claim Id:</th> 
</tr>
<tr><td><input type="text" name="claimid" required></td></tr>
<tr><th>
Amount to be Claimed:</th></tr>
<tr><td> <input type="number" name="amount" required></td></tr>
</table>
<hr>
<h3> Mandatory Documents To Be Uploaded </h3>
<br><br>Adhaar Card:<br><input type="file" name="adhar" size="50"/>
<br><br>
<br><br>Hospital Discharged Bills:<br><input type="file" name="file2"/>
<br><br>
<hr>
Remarks
<br> <textarea name="Text1" cols="40" rows="5"></textarea>
<hr>
<input type="submit" value="Submit" name="Submit"></input>
</form>
</body>
</html>