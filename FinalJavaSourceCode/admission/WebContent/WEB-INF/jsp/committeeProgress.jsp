<%@page import="java.util.ArrayList"%>
<% response.setHeader("Cache-Control","no-cache"); //HTTP 1.1 
 response.setHeader("Pragma","no-cache"); //HTTP 1.0 
 response.setHeader("Cache-Control","no-store");
 response.setDateHeader ("Expires", 0); //prevents caching at the proxy server  
%>

<%
	if(request.getSession().getAttribute("authority.userinfo") == null){
%>
		<jsp:forward page="OnlineApplicationLogin.jsp"></jsp:forward>
<%
	}
%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html"
	prefix="html"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean"
	prefix="bean"%>
<%@ page import = "model.CommitteeProgress"  %>





<html>
<head>


<link rel="stylesheet" type="text/css" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
<link rel="stylesheet" type="text/css" href="css/common.css">
<link rel="stylesheet" type="text/css" href="css/base.css">
<link rel="stylesheet" type="text/css" href="css/appl.css">

</head>

<jsp:include page="/include/header.jsp"></jsp:include>
<jsp:include page="/include/menubar.jsp"></jsp:include>

<body>

<%
	if(	request.getAttribute("totalNoOfReviews") 	 != null && 
		request.getAttribute("totalNoOfReviewsDone") != null && 
		request.getAttribute("CommitteeReveiws") != null){
		ArrayList<CommitteeProgress> committeeProgresses = (ArrayList) request.getAttribute("CommitteeReveiws"); 
%>
	<div id="container">
		<div id="logout"><a href="/admission/logout.do">Logout</a></div>
		<table class="committeeProgressTable">
		<tr>
			<td>No Of reviews required to complete admission review process :</td> <td> <%= request.getAttribute("totalNoOfReviews") %></td>
		</tr>
		<tr>
			<td>No Of reviews completed by Committee : </td> <td><%= request.getAttribute("totalNoOfReviewsDone") %></td>
		</tr>
		</table>
		
		<table class="committeeProgressTable">
			<tr>
				<td></td>
				<th>MS</th>
				<th>PHD</th>
			</tr>

		
<%
	for(int i = 0 ; i < committeeProgresses.size() ; i++){
%>
			<tr>
				<th><%= committeeProgresses.get(i).getCommitteeMemberName() %></th>
				<td><%= committeeProgresses.get(i).getTotalNoOfMastersStudentCompleted() + "/" + committeeProgresses.get(i).getTotalNoOfMastersStudentsAllotted() %></td>
				<td><%= committeeProgresses.get(i).getTotalNoOfPHDStudentCompleted() + "/" + committeeProgresses.get(i).getTotalNoOfPHDStudentsAllotted() %></td>
			</tr> 
<%
	}
%>		
		</table>
	</div>
	
<%
	}
%>

</body>

<jsp:include page="/include/footer.jsp"></jsp:include>
</html>