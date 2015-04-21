<% response.setHeader("Cache-Control","no-cache"); //HTTP 1.1 
 response.setHeader("Pragma","no-cache"); //HTTP 1.0 
 response.setHeader("Cache-Control","no-store");
 response.setDateHeader ("Expires", 0); //prevents caching at the proxy server  
%>

<%
	if(request.getSession().getAttribute("authority.studentinfo") == null){
%>
		<jsp:forward page="OnlineApplicationLogin.jsp"></jsp:forward>
<%
	}
%>

<%@page import="actionform.ApplicationForm"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean"
	prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html"
	prefix="html"%>


<html>
<head>
<link rel="stylesheet" href="css/appl.css">
</head>
<jsp:include page="/include/header.jsp"></jsp:include>

<body>
  <div id="container">
			<div style="float: right; padding-right: 15px;">
				<html:link action="/studentLogout"><h4>Logout</h4></html:link>
				<html:link action="/studentReset"><h4>Change password</h4></html:link>
		
			</div>
	
			<h1 style="text-align: center;padding-top:20px;">
				<bean:message key="applSubmitted.title" />
			</h1>
			<table id="submissionConfirmationTable">
				<tr>
					<th>
						Last Name : 
					</th>
					<td>
						<%=request.getParameter("lastname")%>
					</td>
				</tr>
				<tr>
					<th>
						First Name : 
					</th>
					<td>
						<%=request.getParameter("firstname")%>
					</td>
				</tr>
				<tr>
					<th>
						Middle Name : 
					</th>
					<td>
						<%=request.getParameter("middlename")%>
					</td>
				</tr>
				<tr>
					<th>
						Email id : 
					</th>
					<td>
						<%=request.getParameter("email")%>
					</td>
				</tr>
				<tr>
					<th>
						Country : 
					</th>
					<td>
						<%=request.getParameter("country")%>
					</td>
				</tr>
				<tr>
					<th>
						Gender : 
					</th>
					<td>
						<%=request.getParameter("gender")%>
					</td>
				</tr>
				<tr>
					<th>
						Ethnic : 
					</th>
					<td>
						<%=request.getParameter("ethnic")%>
					</td>
				</tr>
				<tr>
					<th>
						Citizen Country : 
					</th>
					<td>
						<%=request.getParameter("citizen_country")%>
					</td>
				</tr>
				<tr>
					<th>
					 	Degree :
					</th>
					<td>
						<%=request.getParameter("degree")%>
					</td>
				</tr>
				<tr>
					<th>
						Research Interest : 
					</th>
					<td>
						<%=request.getParameter("research_interest")%>
					</td>
				</tr>
				<tr>
					<th>
						Gre Verbal Score : 
					</th>
					<td>
						<%=request.getParameter("gre_verbal")%>
					</td>
				</tr>
				<tr>
					<th>
						Gre Quant Score : 
					</th>
					<td>
						<%=request.getParameter("gre_quantitative")%>
					</td>
				</tr>
				<tr>
					<th>
						Gre AWA Score : 
					</th>
					<td>
						<%=request.getParameter("gre_analytical")%>
					</td>
				</tr>
				<tr>
					<th>
						TOEFL : 
					</th>
					<td>
						<%=request.getParameter("toefl")%>
					</td>
				</tr>
				<tr>
					<th>
						IELTS : 
					</th>
					<td>
						<%=request.getParameter("ielts")%>
					</td>
				</tr>
				<tr>
					<th>
						Reference 1 :
					</th>
					<td>
						<%=request.getParameter("reference1")%>
					</td>
				</tr>
				<tr>
					<th>
						Reference 2 :
					</th>
					<td>
						<%=request.getParameter("reference2")%>
					</td>
				</tr>
				<tr>
					<th>
						Reference 3 :
					</th>
					<td>
						<%=request.getParameter("reference3")%>
					</td>
				</tr>
				<tr>
					<th>
						Statement Of Purpose : 
					</th>
					<td>
						<%=request.getParameter("stmt_purpose")%>
					</td>
				</tr>
			</table>
			
							
			
				
 </div>

</body>
<br>
<jsp:include page="/include/footer.jsp"></jsp:include>
</html>