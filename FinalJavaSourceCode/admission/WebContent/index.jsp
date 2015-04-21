<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>

<html>
<head>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/base.css">

<% 
String path = request.getContextPath(); 
%> 

<script>
function regist()
{
	window.location = '<html:rewrite action="/registInput"/>';
}
</script>
</head>
<jsp:include page="/include/header.jsp"></jsp:include>

<body>
        
                <center>
        
<br>
<h2><bean:message key="logon.title"/></h2>
	<h2><bean:message key="logon.welcome"/></h2>
	<hr>
	<br>
	<table width="500">
		<html:form method="post" action="/logon" >
		<tr>
			<td colspan="2"> <html:errors/> </td>
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
			<td align="center" colspan="2">
				<html:submit><bean:message key="logon.logon"/></html:submit>
				&nbsp;&nbsp;
				<html:button property="register" onclick="regist();"><bean:message key="logon.regist"/></html:button>
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
<jsp:include page="/include/footer.jsp"></jsp:include>
</html>
