<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="../common/common.jsp"%>

<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0.3)
}

select {
	width: 335px;
	color: #212529;
	background-color: #fff;
	background-clip: padding-box;
	border: 1px solid #ced4da;
}
</style>
</head>
<body>
	<%@include file="../common/navbar.jsp"%>
	<div class="container p-4">
		<div class="col-md-8 offset-md-2">
			<div class="card paint-card">
				<div class="card-body">
					<p class="fs-4 text-center fw-bold">Employee Register</p>
					<form action="employee" method="post">
						<div class="row">
							<div class="col-md-6 mb-3">
								<div class="form-outline">
									<label class="form-label">Name</label> 
									<input type="text" name="name" class="form-control" required="required">
								</div>
							</div>
							
							<div class="col-md-6 mb-3">
								<label class="form-label">Email Id</label> 
								<input type="email" name="email" class="form-control" required="required">
							</div>
							
						</div>
						<div class="row">
							
							<div class="col-md-6 mb-3">
								<label class="form-label">Mobile Number</label> 
								<input type="text" name="mobile" class="form-control required="required">
							</div>
							<div class="col-md-6 mb-3">
								<label class="form-label">Gender</label><br> 
								<input type="radio" class="form-check-input" name="gender"checked="checked">&nbsp;Male&nbsp; 
								<input type="radio" class="form-check-input" name="gender">&nbsp;FeMale&nbsp; 
								<input type="radio" class="form-check-input" name="gender">&nbsp;Others&nbsp;
							</div>
							
						</div>

						<div class="row">
							
							<div class="col-6 mb-3">
								<label class="form-label">Country</label><br> 
								<select name="country" class="form-control-lg">
									<option>--Select Country</option>
									<option value="IN">INDIA</option>
									<option value="US">United States</option>
									<option value="US">Indonesia</option>
								</select>
							</div>
							
							<div class="col-6 mb-3">
								<label class="form-label">State</label><br> 
								<select name="state"class="form-control-lg">
									<option>--Select State</option>
									<option value="AP">AndhraPradesh</option>
									<option value="TS">Telangana</option>
									<option value="RS">Royalaseema</option>
									<option value="ALSK">Alaska</option>
									<option value="CLFR">Califonia</option>
									<option value="NMX">New Mexico</option>
									<option value="BALI">Bali</option>
									<option value="JMB">Jambi</option>
									<option value="LMPNG">Lampung</option>
								</select>
							</div>
						</div>
						
						<div class="row">
							<div class="col-6 mb-3">
								<label class="form-label">Address</label><br>
								<textarea class="form-control" id="address" name="address" rows="1"></textarea>
							</div>
							<div class="col-6 mb-3">
								<label class="form-label">Password</label><br>
								<input type="password" name="password" class="form-control required="required"/>
							</div>
						</div>
						

						<div style="text-align: center;" class="mt-4">
							<button type="submit"
							 style="width: 300px"	class="btn btn-primary btn-lg">register</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>