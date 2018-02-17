<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Include one of jTable styles. -->
<link href="<%=request.getContextPath()%>/resources/css/metro/crimson/jtable.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/resources/css/jquery-ui-1.10.3.custom.css" rel="stylesheet" type="text/css" />
<!-- Include jTable script file. -->
<script src="<%=request.getContextPath()%>/resources/js/jquery-1.8.2.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery-ui-1.10.3.custom.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery.jtable.js" type="text/javascript"></script>
<!-- Page level plugin CSS-->

<script type="text/javascript">
    $(document).ready(function () {
        $('#TableContainer').jtable({
        	tableId: 'TableId',
        	title: 'Manage Student',
        	
        	paging: true,
            actions: {
                listAction:'manageStudent?action=list',
                createAction:'manageStudent?action=create',
                updateAction: 'manageStudent?action=update',
                deleteAction: 'manageStudent?action=delete' 
             },
            fields: {
                username:
					{
                	title:'Username',
                    list: true,
                    edit:true,
                    width: '10%',
                    sorting: true,
                    columnResizable:true
					} ,               	
            	password: {
                	title:'Password',
                    list: true,
                    edit:true,
                    width: '10%',
                    columnResizable:true
                   
                },
                email: {
                    title: 'Email',
                    width: '20%',
                    list: true,
                    edit:true,
                    columnResizable:true
                },
                firstname: {
                    title: 'Firstname',
                    width: '20%',
                    list: true,
                    edit:true,
                    columnResizable:true
                },
                
                lastname: {
                    title: 'Lastname',
                    width: '20%',
                    list: true,
                    edit:true,
                    columnResizable:true
                }         
            }
        });
        $('#TableContainer').jtable('load');
    });
</script>
</head>
<body>
<div style="width:60%;margin-right:20%;margin-left:20%;text-align:center;">
<div>
	<input type="text" name="inputSearchFilter"  id="inputSearchFilterId" onkeyup="crudTableSearchFilter(this, document.getElementById('TableId'))" placeholder="Search..">
</div>
<div id="TableContainer">
</div>
    <script src="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css"></script>
    <script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/sb-admin.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/sb-admin-datatables.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/customJavaScript.js"></script>
</div>
<script type="text/javascript">
	function runSearch() {
		crudTableSearchFilter(document.getElementById('inputSearchFilterId'), document.getElementById('TableId'));
	}
</script>
</body>
</html>