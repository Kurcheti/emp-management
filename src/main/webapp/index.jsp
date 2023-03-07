<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login page</title>
	<%@ include file="common/common.jsp" %>
</head>
<body>
	<%@include file="common/navbar.jsp" %>
	
	
	<div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card paint-card">
					<span style="color: green;font-weight: bold">${empCreatedMessage}</span>
					<span style="color: red;font-weight: bold">${empCreationFailedMessage}</span>
					<div class="card-body">
						<p class="fs-4 text-center fw-bold" id="heading">Admin Login</p>
							<span style="color: red;font-weight: bold">${invalidUsernameOrPassword}</span>
							<span style="color: green;font-weight: bold">${sessionExpired}</span>
							<form  method="post" name="loginForm" id="login" onsubmit="formSubmit()">
								<div class="mb-3">
									<label class="form-label">User Name</label>
									<input type="text" name="userName" required="required" class="form-control"/>
								</div>
								<div class="mb-3">
									<label class="form-label">Password</label>
									<input type="password" name="password" required="required" class="form-control"/>
								</div>
								
								<button type="submit" class="btn bg-primary text-white col-md-12">login</button>
							</form>
							<br><span id="singUp" style="display: none">Do't you have an account? <a href="employee?operation=signup">signUp</a></span>
					</div> 
				</div>
			</div>
		</div>
	
	</div>
	
	<script type="text/javascript">
		var loginTypeValue = localStorage.getItem("loginType");
			if(loginTypeValue != null && loginTypeValue =='User Login'){
				document.getElementById("heading").innerHTML = loginTypeValue;
				document.getElementById("singUp").style = 'block';
			}
			
	function formSubmit() {
		 document.loginForm.action = 'admin';
		 document.loginForm.submit();
	}
	
	</script>
</body>
</html>