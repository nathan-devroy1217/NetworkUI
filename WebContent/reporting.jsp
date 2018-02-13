<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="main.css">
	<script src="https://code.jquery.com/jquery-1.12.3.js"></script>
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<link rel="stylesheet" href="/resources/demos/style.css">
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script>
	  $( function() {
		  $('.datepick').each(function(){
			    $(this).datepicker();
			});
	  } );
	</script>
	<title>Reporting</title>
</head>
<body>
	<div id="borderWall">
		<div id="wrapper">
		<%
		   Date date = new Date();
		   out.print( "<p>" + date.toString() + "</p>");
		%>
		</div>
		<h1 align="center">Network Reporting Tools</h1>
		<hr>
		<br>
		<div id="reportTable">
			<h5><u>Report Files</u></h5>
				<div id="reportTableRaw">
				<form action="/MySQLTesterPage/src/MainServlet.java" method="post">
				<table border=0 id="myTable2" width="75%">
					<tbody>
						<c:forEach items="${files}" var="file">
							<tr>							
								<td><a href="/MySQLTesterPage/downloadInbound.jsp?action=download&name=${file}" name="file"><c:out value="${file}" /></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				</form>
			</div>
		</div>
		<div id="formFields">
			<h5><u>Use the below fields to query the network database for data</u></h5>
			<label>Starting Date/Time:</label> 
			<span>
				<input type="text" name="startDate" class="datepick" id="datepicker1" />
			</span>
			<br>
			<label>Ending Date:</label> 
			<span><input type="text" name="endDate" class="datepick" id="datepicker2" /></span>
			<br>
			<input type="submit" value="Submit" name="submit" />
		</div>
	</div>
</body>
</html>