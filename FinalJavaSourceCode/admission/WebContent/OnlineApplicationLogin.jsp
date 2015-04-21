<% response.setHeader("Cache-Control","no-cache"); //HTTP 1.1 
 response.setHeader("Pragma","no-cache"); //HTTP 1.0 
 response.setHeader("Cache-Control","no-store");
 response.setDateHeader ("Expires", 0); //prevents caching at the proxy server  
%>

<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html"
	prefix="html"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean"
	prefix="bean"%>

<html>
<head>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/base.css">

<script>
function studentRegister()
{
	window.location = '<html:rewrite action="/register"/>';
}
</script>
</head>
<jsp:include page="/include/header.jsp"></jsp:include>

<body>

	<center>
        
<br>
<h1><bean:message key="logonStudent.title"/></h1>
	<h2><bean:message key="logonStudent.welcome"/></h2>
	<hr>
	<br>
	<table width="500">
		<html:form action="/logonStudent">
		<tr>
			<td colspan="2"> <html:errors/> </td>
		</tr>
		<tr>
			<td align="right"><bean:message key="logonStudent.username"/></td>
			<td><html:text property="username"/> *</td>
		</tr>
		<tr>
			<td align="right"><bean:message key="logonStudent.password"/></td>
			<td><html:password property="password"/> *</td>
		</tr>
		<tr>
			<td align="center" colspan="2">
				<html:submit value="submit"><bean:message key="logonStudent.logon"/></html:submit>
				&nbsp;&nbsp;
				<html:button property="register" onclick="studentRegister();"><bean:message key="logonStudent.studentRegister"/></html:button>
			</td>
		</tr>
		<tr>
			<td align="right" colspan="2">
				<img height="100" src="img/welcome.jpg">
			</td>
		</tr>
		</html:form>
	</table>

	</center>

</body>
<br>
<jsp:include page="/include/footer.jsp"></jsp:include>
</html>
