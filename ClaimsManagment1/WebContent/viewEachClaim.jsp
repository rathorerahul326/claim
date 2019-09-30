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
<h2>Details of a Claim <c:out value="${x.getClaimid()}"></c:out></h2>
<form  enctype="multipart/form-data">
<table>
<tr> <td> Member Id: </td> <td> <c:out value="${x.getMemid()}"> </c:out> </td></tr>
<br>
<tr><td>Claim Status : <c:out  value="${x.getClaim_status()}"></c:out></td></tr>
<br>
<tr> <td> Work Accident: </td> <td> <c:out value="${x.getWork_acc()}"> </c:out></td></tr>
<br>
<tr> <td> Auto Accident: </td> <td> <c:out value="${x.getAuto_acc()}"> </c:out></td></tr>
<br>
 <fmt:formatDate pattern="YYYY-MM-dd" value="${x.getDoa()}" var="dateinformat"/>
<tr> <td> Date of Accident: </td> <td> <input type="date" value="${dateinformat}"/> </td></tr>
<br>
<tr> <td> Adhaar image </td> <td>  <img src="data:image/jpg;base64,${imm}" width="200" height="250"/></td></tr>
<tr> <td> Document image </td> <td>  <img src="data:image/jpg;base64,${imm1}" width="360" height="480"/></td></tr>
<tr><td>Total Amount asked for claim : <c:out value="${x.getClaim_amount()}"></c:out></td></tr>

<tr>
</tr>
</table>
<br><br>
<table>
<tr>
<td><input type="submit" name="Accept" value="Accept" onSubmit="AcceptClaimRequest?claim_id=${x.getClaimid()}"/></td>
<td><input type="submit" name="Reject"value="Reject" onSubmit="RejectClaimRequest?claim_id=${x.getClaimid()}"/></td>
</tr>
</table>

</form>



</body>
</html>