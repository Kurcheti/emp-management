<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="../common/common.jsp"%>
</head>
<body>
	<%@include file="../common/navbar.jsp"%>

	<table border="1" class="table table-light table-striped">
		<thead>
			<tr>
				<th scope="col">Emp Id</th>
				<th scope="col">Emp Name</th>
				<th scope="col">Emp Mobile</th>
				<th scope="col">Emp Country</th>
				<th scope="col">update/delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="emp" items="${empList}">
			<tr>
				<th scope="row">${emp.empId}</th>
				<td>${emp.name}</td>
				<td>${emp.mobile}</td>
				<td>${emp.country}</td>
				<td><i class="fa-regular fa-pen-to-square" ></i>update &nbsp;
				    <i class="fa-solid fa-trash" onclick="deleteEmployee(${emp.empId})"></i>delete</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<span style="color: green;font-weight: bold">${empDeleteted}</span>
	<span style="red;font-weight: bold">${empNotDeleteted}</span>
	
	<script type="text/javascript">
		function deleteEmployee(empId) {
			window.location = 'employee?operation=delete&empId='+empId;
		}
	
	</script>
</body>
</html>