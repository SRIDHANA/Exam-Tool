<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page import="com.sridhana.model.Exam_Details"%>
<%@page import="com.sridhana.model.User"%>
<%@page import="com.sridhana.service.faculty.FacultyService"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author" content="">
	<title>Faculty Home Page</title>
	<jsp:include page="../includes/cssAndJavaScriptFileIncludes.jsp"/>
</head>
<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<jsp:include page="../includes/navigationBar.jsp"/>	
	<div class="content-wrapper" id="concon">
		
			
		<div> 
			<label>ExamId: </label> <input type="text" name="examId" value=""/>
		<a href="<c:url value='/CreateExam' />" >
		<input type="submit" value="CREATE"  /> </a>
		</div> 
		<div>
			<label> List of exams Available	</label>					
			<table >
				<tr>
					<th width="20" height="30">EXAM ID</th>
					<th width="20" height="30">EXAM NAME</th>
					<th width="30" height="30">TIMELIMIT</th>
					<th width="40" height="30">CREATED DATE</th>
					<th width="40" height="30">LAST UPDATED DATE</th>
					
					<th width="30" height="30">VIEW STUDENT GRADES</th>
					
					<th width="40" height="30">UPDATE</th>
					<th width="40" height="30">DELETE</th>
					
				</tr>
				<c:forEach items="${exam_Details_list}" var="exam_Details">
					<tr>
						<td>${exam_Details.examid}</td>
						<td>${exam_Details.examname}</td>
						<td>${exam_Details.timelimit}</td>
						<td>${exam_Details.creation_date}</td>
						<td>${exam_Details.last_updated_date}</td>
						<td><a href="<c:url value='/DisplayGrades/${exam_Details.classid}' />" >View Grades</a></td>
				    <td><input type="button" value="UPDATE" name="UPDATE" /></td>
	                <td><input type="button" value="DELETE" name="DELETE" /></td>
	                
					</tr>
				</c:forEach>
			</table>
		</div>
		
	</div>

	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fa fa-angle-up"></i>
	</a>	
</body>
</html>