<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>Administrator Home Page </title>
  <!-- Bootstrap core CSS-->
  <link href="<%=request.getContextPath()%>/resources/adminpage/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="<%=request.getContextPath()%>/resources/adminpage/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Custom styles for this template-->
  <link href="<%=request.getContextPath()%>/resources/adminpage/css/sb-admin.css" rel="stylesheet">
   <script type = "text/javascript" 
         src = "https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
   <script type = "text/javascript" >
         $(document).ready(function() {
             $('#concon').load('<%=request.getContextPath()%>/views/Admin/AdminHome.jsp');
        	 $("#Homepage").click(function(event){
                 $('#concon').load('<%=request.getContextPath()%>/views/Admin/AdminHome.jsp');
              });
        	 $("#Managecourse").click(function(event){
               $('#concon').load('<%=request.getContextPath()%>/views/Admin/ManageCourse.jsp');
            });
        	 $("#Managefaculty").click(function(event){
                 $('#concon').load('<%=request.getContextPath()%>/views/Admin/ManageFaculty.jsp');
              });
        	 $("#Managestudent").click(function(event){
                 $('#concon').load('<%=request.getContextPath()%>/views/Admin/ManageStudent.jsp');
              });
        	 $("#Manageclass").click(function(event){
                 $('#concon').load('<%=request.getContextPath()%>/views/Admin/ManageClass.jsp');
              });
        	 $("#Managestudentassignments").click(function(event){
                 $('#concon').load('<%=request.getContextPath()%>/views/Admin/ManageClassStudents.jsp');
              });
        	 $("#Settings").click(function(event){
                 $('#concon').load('<%=request.getContextPath()%>/views/Admin/Settings.jsp');
        	 });
         });
</script>
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
  <!-- Navigation-->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
    <a class="navbar-brand" href="index.html">Welcome Administrator!</a>
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation"> <span class="navbar-toggler-icon"></span> </button>
    <div class="collapse navbar-collapse" id="navbarResponsive">
    
      <ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Dashboard">
          <a class="nav-link text-white"  id="Homepage" ><span class="nav-link-text"></span>Home</a>
        </li>
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Dashboard">
          <a class="nav-link text-white"  id="Managecourse" ><span class="nav-link-text"></span>Manage Course</a>
        </li>
        
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Dashboard">
          <a class="nav-link text-white"  id="Managefaculty" ><span class="nav-link-text"></span>Manage Faculty</a>
        </li>
        
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Dashboard">
          <a class="nav-link text-white"  id="Managestudent" ><span class="nav-link-text"></span>Manage Student </a>
        </li>        
        
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Dashboard">
          <a class="nav-link text-white"  id="Manageclass" ><span class="nav-link-text"></span>Manage Class </a>
        </li>        
        
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Dashboard">
          <a class="nav-link text-white"  id="Managestudentassignments" ><span class="nav-link-text"></span>Manage Student Assignments </a>
        </li>        
        
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Dashboard">
          <a class="nav-link text-white"  id="Settings" ><span class="nav-link-text"></span>Settings </a>
        </li>        
        
      </ul>
      <ul class="navbar-nav ml-auto">
        <li class="nav-item">
          <a class="nav-link text-white" data-toggle="modal" data-target="#exampleModal"> <i class="fa fa-fw fa-sign-out"></i>Logout</a>
        </li>
      </ul>
    </div>
  </nav>
  <div class="content-wrapper" id ="concon">
  </div>
  <!-- /.container-fluid-->
  <!-- /.content-wrapper-->
  <!-- Scroll to Top Button-->
  <a class="scroll-to-top rounded" href="#page-top"> <i class="fa fa-angle-up"></i> </a>
  <!-- Logout Modal-->
  <!-- Bootstrap core JavaScript-->
  <script src="<%=request.getContextPath()%>/resources/adminpage/vendor/jquery/jquery.min.js"></script>
  <script src="<%=request.getContextPath()%>/resources/adminpage/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <!-- Core plugin JavaScript-->
  <script src="<%=request.getContextPath()%>/resources/adminpage/vendor/jquery-easing/jquery.easing.min.js"></script>
  <!-- Custom scripts for all pages-->
  <script src="<%=request.getContextPath()%>/resources/adminpage/js/sb-admin.min.js"></script>
  <!-- Custom scripts for this page-->
  <!-- Toggle between fixed and static navbar-->
</body>

</html>