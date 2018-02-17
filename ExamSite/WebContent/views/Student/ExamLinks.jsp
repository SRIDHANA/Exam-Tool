<%@page import="java.util.Collection"%>
<%@page import="com.sridhana.model.User"%>
<%@page import="com.sridhana.service.student.StudentService"%>
<%@page import="com.sridhana.model.ClassMap"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://pingendo.com/assets/bootstrap/bootstrap-4.0.0-beta.1.css"
	type="text/css">
</head>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
	type="text/css">
<h1>List of Classes Available</h1>
</head>
<body>
	<div class="py-5">
		<div class="container">
			<div class="row">
				<div class="col-md-5">
				<c:url var="addAction" value="studentclasslinks" ></c:url>
				<form:form action="" method="get" commandName="studentclasslinks">
						<c:if test="${!empty ClassMaplist}">
							<table class="table">
								<thead>
									<tr>
										<th>Classes</th>
									</tr>
								</thead>
								<tbody>
				<%
					User user = (User) session.getAttribute("User");
					StudentService service = new StudentService();
					Collection<ClassMap> list = service.getClassesList(user.getUsername());
					for(ClassMap map : list) {
				%>
									<c:forEach var="items" items="${ClassMaplist}">
										<tr>
											<td><a href="/classes/${items.classid}" onclick ="loadSubPage('container', this);" >${classMap.classid}"</a></td>
										</tr>
									</c:forEach>
				<%}%>
								</tbody>
							</table>
						</c:if>
					</form:form>
				</div>
			</div>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
<script type="text/javascript">
function loadSubPage(divIdToBeReplacedForSubPage, element) {
	alert("DivID: " + divIdToBeReplacedForSubPage + ", Link: " + element);
	$('#'+divIdToBeReplacedForSubPage).load(element.href);
}
</script>
</body>
</html>
