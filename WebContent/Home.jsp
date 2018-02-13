<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css">
<link rel="stylesheet" type="text/css" href="main.css">
<script src="https://code.jquery.com/jquery-1.12.3.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
<title>Home Page</title>
</head>
<body>
	<div id="borderWall">
		<div id="wrapper">
		<%
		   Date date = new Date();
		   out.print( "<p>" +date.toString()+"</p>");
		%>
		</div>
		<h1 align="center">Devroy Family Network Stats</h1>
		<hr>
		<div id="tableHolder">
			<table border=1 id="myTable" width="75%">
				<thead>
					<tr>
						<th>Access Date</th>
						<th>Device</th>
						<th>Source IP</th>
						<th>Site Visited</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${packets}" var="packet">
						<tr>
							<td><c:out value="${packet.accessDttm}" /></td>
							<td><c:out value="${packet.deviceName}" /></td>
							<td><c:out value="${packet.srcIp}" /></td>
							<td><c:out value="${packet.resolvedUri}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<script>
		$(document).ready(function(){
	    		$('#myTable').dataTable({
	    			"lengthMenu": [ [10, 25, 50, 100, 500, -1], [10, 25, 50, 100, 500, "All"] ]
	    		});
	   	});
		</script>
		<div id="leftBar">
			<ul>
				<li><a href="http://192.168.1.1/Main_Login.asp">Router Gateway</a></li>
				<li><a href="/MySQLTesterPage/reportingInbound.jsp">Reporting Tools</a></li>
				<li><a href="">Cloud Storage</a></li>
			</ul>
		</div>
	</div>>
</body>
</html>