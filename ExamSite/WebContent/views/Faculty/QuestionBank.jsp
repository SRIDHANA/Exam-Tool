<%@ page import="org.apache.commons.lang.StringUtils"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Include one of jTable styles. -->
<link
	href="<%=request.getContextPath()%>/resources/css/metro/crimson/jtable.css"
	rel="stylesheet" type="text/css" />
<link
	href="<%=request.getContextPath()%>/resources/css/jquery-ui-1.10.3.custom.css"
	rel="stylesheet" type="text/css" />
<!-- Include jTable script file. -->
<script src="<%=request.getContextPath()%>/resources/js/jquery-1.8.2.js"
	type="text/javascript"></script>
<script
	src="<%=request.getContextPath()%>/resources/js/jquery-ui-1.10.3.custom.js"
	type="text/javascript"></script>
<script
	src="<%=request.getContextPath()%>/resources/js/jquery.jtable.js"
	type="text/javascript"></script>

<!-- Page level plugin CSS-->

<script type="text/javascript">
	$(document).ready(function() {
		$('#TableContainer').jtable({
			tableId : 'TableId',
			title : 'Manage Multiple Choice',
			paging : true,
			actions : {
				listAction : 'manageMCQ?action=list',
				createAction : 'manageMCQ?action=create',
				updateAction : 'manageMCQ?action=update',
				deleteAction : 'manageMCQ?action=delete'
			},
			fields : {
				question : {
					title : 'question',
					width : '30%',
					list : true,
					edit : true,
					columnResizable : true

				},
				optiona : {
					title : 'optiona',
					width : '15%',
					list : true,
					edit : true,
					columnResizable : true
				},
				optionb : {
					title : 'optionb',
					width : '15%',
					list : true,
					edit : true,
					columnResizable : true
				},
				optionc : {
					title : 'optionc',
					width : '15%',
					list : true,
					edit : true,
					columnResizable : true
				},
				optiond : {
					title : 'optiond',
					width : '15%',
					list : true,
					edit : true,
					columnResizable : true
				},
				optione : {
					title : 'optione',
					width : '15%',
					list : true,
					edit : true,
					columnResizable : true
				},
				optionf : {
					title : 'optionf',
					width : '15%',
					list : true,
					edit : true,
					columnResizable : true
				},
				answer : {
					title : 'Answer',
					width : '15%',
					list : true,
					edit : true,
					columnResizable : true
				},
				
				marks_alloted : {
					title : 'Marks alloted',
					width : '15%',
					list : true,
					edit : true,
					columnResizable : true
				}
				
				
			}
		});
		$('#TableContainer').jtable('load');
	});
</script>
</head>
<body>
	
<%
String FilePath = StringUtils.defaultIfBlank(request.getParameter("FilePath"), "") ;%>
	<div>
		<form id="Question_Bank_Form" name="Question_Bank_Form" action="./QuestionBank" method="post" enctype="multipart/form-data">
	<input type="hidden" id="action" name="action" value="" />
	<label>Timelimit in minutes: </label> 
	<input type="text"  name="Timelimit" />
	<br>
	<br>
	<label>Browse and upload a file  </label> 
	
	<input type = "file" name="uploadedFile" value="<%= FilePath %>">
	<input type="submit" value="Upload" onclick="javascript: document.getElementById('action').value='UPLOAD_FILE';" />
	
	</div>
	<br>
	<br>
	
	<div
		style="width: 60%; margin-right: 20%; margin-left: 20%; text-align: center;">
		<div>
			<input type="text" name="inputSearchFilter" id="inputSearchFilterId"
				onkeyup="crudTableSearchFilter(this, document.getElementById('TableId'))"
				placeholder="Search..">
		</div>
		<div id="TableContainer"></div>
		<script
			src="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css"></script>
		<script
			src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
		<script
			src="<%=request.getContextPath()%>/resources/js/sb-admin.min.js"></script>
		<script
			src="<%=request.getContextPath()%>/resources/js/sb-admin-datatables.min.js"></script>
		<script
			src="<%=request.getContextPath()%>/resources/js/customJavaScript.js"></script>
	</form>
	</div>
	<script type="text/javascript">
		function runSearch() {
			crudTableSearchFilter(document
					.getElementById('inputSearchFilterId'), document
					.getElementById('TableId'));
		}
	</script>
</body>
</html>