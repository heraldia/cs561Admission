<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>

<html>

<link rel="stylesheet" href="css/common.css">

<% 
String path = request.getContextPath(); 
%> 


<jsp:include page="/include/header.jsp"></jsp:include>


<body>
<center>
<br>
<h2><bean:message key="logon.title"/></h2>
	<h2><bean:message key="regist.welcome"/></h2>
	<hr>
	<br>
	
	<table width="500">
		<html:form method="post" action="/regist" >
		<tr>
			<!-- <td colspan="2"><html:errors property="username"/>
			                <html:errors property="password"/>
			                <html:errors property="repassword"/>
			                <html:errors property="firstname"/>
			                <html:errors property="category"/>
			                -->
		</tr>
		<tr>
		<html:errors/>
			                <html:errors property="error.user.duplicate"/></td>
		</tr>
		<tr>
			<td align="right"><bean:message key="logon.isuid"/></td>
			<td><html:text property="username"/> *</td>
		</tr>
		<tr>
			<td align="right"><bean:message key="logon.password"/></td>
			<td><html:password property="password"/> *</td>
		</tr>
		<tr>
			<td align="right"><bean:message key="regist.repassword"/></td>
			<td><html:password property="repassword"/> *</td>
		</tr>

		<tr>
			<td align="right"><bean:message key="regist.email"/></td>
			<td><html:text property="email"/> *</td>
		</tr>

		<tr>
			<td align="right"><bean:message key="regist.firstname"/></td>
			<td><html:text property="firstname"/> *</td>
		</tr>

		<tr>
			<td align="right"><bean:message key="regist.category"/></td>
            <td><html:select property="category"> *
            <option value="-1" selected="selected">Choose here</option>
            <option value="0">Committee member</option>
			<option value="1">Committee chair</option>
			<option value="2">Department chair</option>
			<option value="3">Staff</option>
                </html:select></td>
		</tr>
		<tr>
			<td align="center" colspan="2">
				<html:submit><bean:message key="logon.regist"/></html:submit>
				&nbsp;&nbsp;
				<html:reset><bean:message key="regist.reset"/></html:reset>
			</td>
		</tr>
		<tr>
			<td align="right" colspan="2">
				<img height="100" src="img/register.jpg">
			</td>
		</tr>
		<tr>
		<td>
		<html:link action="/getback">Back to Log in page</html:link>
		</td>
		</tr>
		</html:form>
	</table>
</center>
</body>
<jsp:include page="/include/footer.jsp"></jsp:include>

</html>
