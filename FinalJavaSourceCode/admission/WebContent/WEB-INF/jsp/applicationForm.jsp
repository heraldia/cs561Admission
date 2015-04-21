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


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html"
	prefix="html"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean"
	prefix="bean"%>

<%@ page import="strutsaction.ApplicationFormAction" %>



<html>
<head>


<link rel="stylesheet" type="text/css" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
<link rel="stylesheet" type="text/css" href="css/common.css">
<link rel="stylesheet" type="text/css" href="css/base.css">
<link rel="stylesheet" type="text/css" href="css/appl.css">
<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
</head>

<jsp:include page="/include/header.jsp"></jsp:include>


<body>
	

	<div style="float: right; padding-right: 15px;">
		<html:link action="/studentLogout">
			Logout
		</html:link>
		|
		<html:link action="/studentReset">
			Change password
		</html:link>

	</div>
	<br/>

	<div id="AplicationFormErrorMessageDiv">	
		<html:errors />
	</div> 

	<html:form action="/applicationForm">
		<table id="applicationFormTable">
			<tr>
				<th colspan="2" id="applicationFormHeader">
					<bean:message key="logonStudent.title" />
				</th>
			</tr>
			<tr>
				<td colspan="2" id="mandatoryFieldNotification">
					Fields marked * are mandatory
				</td>
			</tr>
			<tr>
				<th><bean:message key="application.lastname" /><span class="mandatory"> *</span></th>
				<td><html:text property="lastname" /></td>
			</tr>
			<tr>
				<th><bean:message key="application.firstname" /><span class="mandatory"> *</span></th>
				<td><html:text property="firstname" /></td>
			</tr>
			<tr>
				<th><bean:message key="application.middlename" /></th>
				<td><html:text property="middlename" /></td>
			</tr>
			<tr>
				<th><bean:message key="application.email" /><span class="mandatory"> *</span></th>
				<td><input type="email" name="email" /></td>
			</tr>
			<tr>
				<th><bean:message key="application.country" /></th>
				<td>
					<html:text property="country" />
				</td>
			</tr>
			<tr>
				<th><bean:message key="application.gender" /></th>
				<td>
					<html:radio property="gender" value="M">Male</html:radio>
					<html:radio property="gender" value="F">Female</html:radio>
				</td>
			</tr>
			<tr>
				<th><bean:message key="application.citizen_country" /></th>
				<td>
					<html:text property="citizen_country" /> 
				</td>
			</tr>
			<tr>
				<th><bean:message key="application.ethnic" /></th>
				<td>
					<html:select property="ethnic">
							<option  selected="selected"></option>
							<option>Asian</option>
							<option>Hispanic</option>
							<option>Latino</option>
							<option>Native</option>
						</html:select>
				</td>
			</tr>
			<tr>
				<th><bean:message key="application.degree" /></th>
				<td>
					<html:select property="degree" >
						<option></option>>
						<option> MS </option>
						<option> PHD </option>
					</html:select>
				</td>
			</tr>
			<tr>
				<th><bean:message key="application.research_interest" /></th>
				<td>
					<html:text property="research_interest" />
				</td>
			</tr>
			<tr>
				<th><bean:message key="application.gre_verbal" /></th>
				<td>
					<html:text property="gre_verbal" />
				</td>
			</tr>
			<tr>
				<th><bean:message key="application.gre_quantitative" /></th>
				<td>
					<html:text property="gre_quantitative" />
				</td>
			</tr>
			<tr>
				<th><bean:message key="application.gre_analytical" /></th>
				<td>
					<html:text property="gre_analytical" />
				</td>
			</tr>
			<tr>
				<th><bean:message key="application.toefl" /></th>
				<td>
					<html:text property="toefl" />
				</td>
			</tr>
			<tr>
				<th><bean:message key="application.ielts" /></th>
				<td>
					<html:text property="ielts" />
				</td>
			</tr>
			<tr>
				<th><bean:message key="application.reference1" /></th>
				<td>
					<html:text property="reference1" />
				</td>
			</tr>
			<tr>
				<th><bean:message key="application.reference2" /></th>
				<td>
					<html:text property="reference2" />
				</td>
			</tr>
			<tr>
				<th><bean:message key="application.reference3" /></th>
				<td>
					<html:text property="reference3" />
				</td>
			</tr>
			<tr>
				<th><bean:message key="application.stmt_purpose" /></th>
				<td>
					<html:textarea property="stmt_purpose" cols="40" rows="10"></html:textarea>
				</td>
				<td>
					less than 255 chars
				</td>
			</tr>
			<tr>
				<td>
					<html:submit>
						<bean:message key="label.submit" />
					</html:submit>
					<html:reset>
						<bean:message key="label.reset" />
					</html:reset>
				</td>
			</tr>
		</table>
	</html:form>
	

</body>
<script type="text/javascript">
$("input[type=submit]").click(function(){
	return confirm("Do you want to Submit ? ");
});
</script>
<jsp:include page="/include/footer.jsp"></jsp:include>
</html>v