<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page import="com.sridhana.model.Exam_Details"%>
<%@page import="com.sridhana.model.Exam_Grades"%>
<%@page import="com.sridhana.model.User"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>Student Home Page</title>
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
		<a class="navbar-brand" href="index.html">Welcome Student!</a>
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
					href="<%=request.getContextPath()%>/views/Student/StudentHomePage.jsp"><span
						class="nav-link-text"></span>Home</a></li>

				<li class="nav-item" data-toggle="tooltip" data-placement="right"
					title="Dashboard"><a class="nav-link text-white"
					id="ClassLinks"
					href="<%=request.getContextPath()%>/views/Student/StudentClassLinks.jsp"><span
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
<label> List of Exams </label>					
			
				<table >
					<tr>
						<th width="20" height="30">EXAM ID</th>
						<th width="20" height="30">EXAM NAME</th>
						<th width="30" height="30">TIMELIMIT</th>
						
						<th width="30" height="30">STATUS</th>
						<th width="30" height="30">WRITTEN DATE</th>
						<th width="30" height="30">TOTAL MARKS GRADED</th>
						<th width="30" height="30">TOTAL MARKS ALLOTED</th>
						<th width="30" height="30">GRADE</th>
						
						<th width="30" height="30">Start  Assessment</th>
						
					</tr>
					<c:forEach items="${exam_Details_list}" var="exam_Details">
						<tr>
                              <% int var = 0; %>   		

						<td>${exam_Details.examid}</td>
						<td>${exam_Details.examname}</td>
						<td>${exam_Details.timelimit}</td>
					<c:forEach items="${exam_Grades_list}" var="exam_Grades"  >
					      <c:if  test="${exam_Grades.examid eq exam_Details.examid}" >	
                              <% var = 2; %>   		
							<td>${exam_Grades.status}</td>
							<td>${exam_Grades.written_date}</td>
							<td>${exam_Grades.totalmarksalloted}</td>
							<td>${exam_Grades.totalmarksgraded}</td>
							<td>${exam_Grades.grade}</td>
							
						</c:if>	
					</c:forEach>
					     <% if (var != 2) {%>
					    	<td>--</td>
							<td>--</td>
							<td>--</td>
							<td>--</td>
							<td>--</td>
							
					    <td><a href="<c:url value='/startassessment/${exam_Details.examid}' />"><input type = "submit" value= 'Start Assessment' name = "Start Assessment"  >  </a></td>
                           <%}%>
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