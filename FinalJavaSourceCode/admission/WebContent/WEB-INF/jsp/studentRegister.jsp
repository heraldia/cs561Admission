<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>

<html>


<link rel="stylesheet" href="css/common.css">
 
<jsp:include page="/include/header.jsp"></jsp:include>


<body>
<center>
<br>
<h2><h1><bean:message key="studentRegister.title"/></h1>
	<h2><bean:message key="studentRegister.welcome"/></h2>
	<hr>
	<br>
	
	<table width="500">
		<html:form method="post" action="/studentRegister" >
		
		<tr>
		<html:errors/>
			                <html:errors property="error.user.duplicate"/></td>
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
			<td align="right"><bean:message key="studentRegister.repassword"/></td>
			<td><html:password property="repassword"/> *</td>
		</tr>

			
		<tr>
			<td align="center" colspan="2">
				<html:submit><bean:message key="studentRegister.register"/></html:submit>
				&nbsp;&nbsp;
				<html:reset><bean:message key="register.reset"/></html:reset>
			</td>
		</tr>
		<tr>
			<td align="right" colspan="2">
				<img height="100" src="img/register.jpg">
			</td>
		</tr>
		<br>
		<tr>
		
		<html:link action="/getback1"><h2>Back to Log in page </h2></html:link>
		
		</tr>
		<br><br>
		</html:form>
	</table>
</center>
</body>
<jsp:include page="/include/footer.jsp"></jsp:include>

</html>
