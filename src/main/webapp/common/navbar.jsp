<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
		<div class="container-fluid">
			<a class="navbar-brand" href="index.jsp"> <i
				class="fa-solid fa-user"></i> EMPLOYEE HOME
			</a>

			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav ms-auto mb-2 mb-lg-0">

					<li class="nav-item"><a class="nav-link active"
						aria-current="page" onclick="loadLoginPage('admin')"
						href="index.jsp"><i class="fa-solid fa-arrow-right-to-bracket"></i>
							ADMIN</a></li>

					<li class="nav-item"><a class="nav-link active"
						aria-current="page" onclick="loadLoginPage('user')"
						href="index.jsp"><i class="fa-solid fa-user"></i> USER</a></li>

					<li class="nav-item" id="logout" style="display: none"><a
						class="nav-link active" aria-current="page" href="admin">
						<!-- <i class="fa-solid fa-arrow-up-from-bracket" onclick="window.location = 'admin'"> -->
						<i class="fa-solid fa-arrow-up-from-bracket"></i>
							logout</a></li>

				</ul>

			</div>
		</div>
	</nav>
	
   <script type="text/javascript">
   function loadLoginPage(type) {
		if(type === 'admin'){
			localStorage.setItem("loginType", "Admin Login");
		}else{
			localStorage.setItem("loginType", "User Login");
		}
		
	}
   
   //for enabling logout button
   <c:if test="${requestScope.enableLogout eq true}">
	document.getElementById("logout").style = 'block';
   </c:if>
   
   </script>
</body>
</html>