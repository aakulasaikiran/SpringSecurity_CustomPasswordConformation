<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ page session="false"%>
<html>
<head>
<title>Employee Saved Successfully</title>
</head>
<body>
	<h3 style="color: red;" align="center">Employee Saved Successfully.</h3>
<h2 style="color: green;">Employee Details</h2>
	<strong>Employee Name:${employee.name}</strong>
	<br>
	<strong>Employee Email:${employee.email}</strong>
	<br>
	<strong>Employee Age:${employee.age}</strong>
	<br>
	<strong>Employee Gender:${employee.gender}</strong>
	<br>
	<strong>Employee Birthday:<fmt:formatDate
			value="${employee.birthday}" type="date" /></strong>
	<br>

</body>
</html>
