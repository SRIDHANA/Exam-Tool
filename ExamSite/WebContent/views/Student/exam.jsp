<%@ page import="org.apache.commons.lang.StringUtils"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Insert title here</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    </head>

     <script language="javascript">

     alert("Starting");

     function customSubmit(someValue) {
         alert("triggering custom submit");
         document.questionForm.submit();
     }
     </script>

    <body> 
   <!-- onload="examTimer()"> -->

   <!--       <h1> this is exam page</h1>
        -->
<% // 	String timer = request.getParameter("timer"); %>

        <form action="exam" method="post" name="questionForm">
        	<input type="hidden" id="examId" name="examId" value="22" /> <!-- The examId will be set Dynamically later -->
        	
       <!--       <div id="showtime" style="position:absolute;left:800px;top:20px"></div>
  
            <label id="test"></label> -->
		<input type="text" name="minute" value="half" />   
		<input type="submit" name="action" value="previous" onclick="customSubmit()" />
     
     	<div id="timerDisplay">
     		Time: 0 mins: 0 secs
     	</div>
        </form>

	<script type="text/javascript">

	function getTimePassed(examId) {
		  var url = "./timetracker/getTimePassed?examId=" + examId;
		  var jqxhr = $.get(url, function( data ) {
			    //alert( "Data Loaded: " + data );
			    $("#timerDisplay").html(data);
		  });
	}

	function startTimeTracker(examId) {
		alert("Starting Time Tracker for Exam with Id : " + examId);
		  var url = "./timetracker/startTimeTracker?examId=" + examId;
		  var jqxhr = $.get( url, function() {
			  alert( "success" );
			});
	}
	
	function endTimeTracker(examId) {
		alert("Ending Time Tracker for Exam with Id : " + examId);
		  var url = "./timetracker/endTimeTracker?examId=" + examId;
		  var jqxhr = $.get( url, function() {
			  alert( "success" );
			});
	}
	
	startTimeTracker(22);
	/*setTimeout(function() {
		getTimePassed(22);
	}, 2000); // Sleeping for 2 seconds
	*/
	var i = 0, howManyTimes = 120;
	function f() {
	  
	    getTimePassed(22);
	    i++;
	    if( i < howManyTimes ){
	        setTimeout(f, 1000);
	    }
	}
	f();

</script>  


<form:form action="" method="post" modelAttribute="mcq"  >
<p> Hello Welcome Dear Student,
   <p>  Pleases click on the button to start assessment. </p>
    <br> <p>Exam will have 20 quesitons 3 marks each </p>
  </div>
	<input type="button" value="CREATE" onclick="" name="CREATE" />
	
</form:form>

 
</body>
</html>
    
    
    