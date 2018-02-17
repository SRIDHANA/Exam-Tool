<%@ page language="java" pageEncoding="ISO-8859-1" session="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;  charset=ISO-8859-1">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
	type="text/css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/theme.css"
	type="text/css">
<title>UCM Online Examination</title>
</head>
<script
	src="${pageContext.request.contextPath}/resources/jquery/jquery.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/jquery/jquery.validate.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(document).ready(
			function() {

				$(".login").validate(
						{
							rules : {
								username : {
									required : true

								},
								password : {
									required : true,
									minlength : 5,
									maxlength : 30
								}
							},
							highlight : function(element) {
								$(element).closest('.form-group').removeClass(
										'has-success').addClass('has-error');

							},
							unhighlight : function(element) {
								$(element).closest('.form-group').removeClass(
										'has-error').addClass('has-success');

							}
						});

			});
</script>
<body background="<%=request.getContextPath()%>/resources/libimg.jpg">
	<div class="py-5">
		<div class="container">
			<div class="row">
				<div class="col-md-5">
					<div class="card text-white p-5 bg-dark">
						<div class="card-body">
							<h1 class="mb-4">Login&nbsp;</h1>
							<form:form id="loginform" name="Loginform"
								action="./loginprocess" method="post"
								enctype="multipart/form-data" modelAttribute="user"
								cssClass="login">
								<div class="form-group">
									<label>Username</label>
									<form:input type="text" class="form-control" path="username"
										placeholder="Enter Username" />
								</div>
								<label class="has-error"></label>

								<div class="form-group">
									<label>Password</label>
									<form:input type="password" path="password"
										class="form-control" placeholder="Enter Password" />
								</div>
								<label class="has-error"></label>
								<input type="submit" name="Login" class="btn btn-secondary"
									value="Login" />
								<c:if test="${not empty error}">
									<div class="error-message alert alert-danger"
										style="width: 300px; margin: 20px auto 0 auto">
										<a href="#" class="close" data-dismiss="alert"> &times; </a>
										${error}

									</div>
								</c:if>
							</form:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>