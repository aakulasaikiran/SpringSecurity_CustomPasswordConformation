<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Customer Saved Successfully</title>
</head>
<body>
	<h3 style="color: purple;" align="center">Customer Saved
		Successfully.</h3>
<h4 style="color: green;">This is Customer Details Stored in Db</h4>
	<strong>Customer ID:${customer.id}</strong>
	<br>
	<strong>Customer Name:${customer.name}</strong>
	<br>
	<strong>Customer Role:${customer.role}</strong>
	<br>

</body>
</html>
