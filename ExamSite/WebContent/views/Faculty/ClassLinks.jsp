<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page import="com.sridhana.bean.ClassBean"%>
<%@page import="com.sridhana.model.User"%>
<%@page import="com.sridhana.service.faculty.FacultyService"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>Faculty Home Page</title>
<!-- Bootstrap core CSS-->
<link
	href="<%=request.getContextPath()%>/resources/adminpage/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Custom fonts for this template-->
<link
	href="<%=request.getContextPath()%>/resources/adminpage/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<!-- Custom styles for this template-->
<link
	href="<%=request.getContextPath()%>/resources/adminpage/css/sb-admin.css"
	rel="stylesheet">

</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<!-- Navigation-->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top"
		id="mainNav">
		<a class="navbar-brand" href="index.html">Welcome Faculty!</a>
		<button class="navbar-toggler navbar-toggler-right" type="button"
			data-toggle="collapse" data-target="#navbarResponsive"
			aria-controls="navbarResponsive" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">

			<ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
				<li class="nav-item" data-toggle="tooltip" data-placement="right"
					title="Dashboard"><a class="nav-link text-white" id="Homepage"
					href="<%=request.getContextPath()%>/views/Faculty/FacultyHomePage.jsp"><span
						class="nav-link-text"></span>Home</a></li>

				<li class="nav-item" data-toggle="tooltip" data-placement="right"
					title="Dashboard"><a class="nav-link text-white"
					id="ClassLinks"
					href="<%=request.getContextPath()%>/views/Faculty/ClassLinks.jsp"><span
						class="nav-link-text"></span>Class Links</a></li>

				<li class="nav-item" data-toggle="tooltip" data-placement="right"
					title="Dashboard"><a class="nav-link text-white" id="Settings"
					href="<%=request.getContextPath()%>/views/Settings.jsp"><span
						class="nav-link-text"></span> Settings</a></li>

			</ul>
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link text-white"
					data-toggle="modal" data-target="#exampleModal"> <i	class="fa fa-fw fa-sign-out"></i>Logout
				</a></li>
			</ul>
		</div>
	</nav>
	
	<div class="content-wrapper" id="concon">
<label> List of Classes Available	</label>					
	
			
				<table >
					<tr>
						<th width="20" height="30">CLASS ID</th>
						<th width="20" height="30">COURSE ID</th>
						<th width="30" height="30">COURE NAME</th>
					</tr>
					<c:forEach items="${ClassBeanlist}" var="classBean">
						<tr>
							<td><a href="<c:url value='/classidlinks/${classBean.classid}' />" >${classBean.classid}</a></td>
							<td>${classBean.courseid}</td>
							<td>${classBean.coursename}</td>
						</tr>
					</c:forEach>
				</table>
	
	</div>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
	<!-- /.container-fluid-->
	<!-- /.content-wrapper-->
	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fa fa-angle-up"></i>
	</a>
	<!-- Logout Modal-->
	<!-- Bootstrap core JavaScript-->
	<script
		src="<%=request.getContextPath()%>/resources/adminpage/vendor/jquery/jquery.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/adminpage/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- Core plugin JavaScript-->
	<script
		src="<%=request.getContextPath()%>/resources/adminpage/vendor/jquery-easing/jquery.easing.min.js"></script>
	<!-- Custom scripts for all pages-->
	<script
		src="<%=request.getContextPath()%>/resources/adminpage/js/sb-admin.min.js"></script>
	<!-- Custom scripts for this page-->
	<!-- Toggle between fixed and static navbar-->
</body>

</html>