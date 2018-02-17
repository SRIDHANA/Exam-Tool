<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author" content="">
	<title>Student Home Page</title>
	<jsp:include page="../includes/cssAndJavaScriptFileIncludes.jsp"/>
</head>
<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<jsp:include page="../includes/StudentNavigationBar.jsp"/>
	  <div class="content-wrapper" id ="concon">
 <p> Hello Welcome Dear Student,
   <p>  Students are required to take Exams of each course. </p>
    <br> <p>The corresponding links will be available on the left </p>
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