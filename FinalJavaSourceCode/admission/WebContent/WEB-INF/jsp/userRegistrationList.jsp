<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="/WEB-INF/struts-bean" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic" prefix="logic"%>

<html>
	<head>
		<title><bean:message key="user.list"/></title>
	</head>
	<body>
		<h1><bean:message key="user.list"/></h1>
		<table border="1">
			<tr>
				<td><bean:message key="logon.username" /></td>
			</tr>
			<logic:iterate id="user" name="users">
			<tr>
				<td><bean:write name="user" property="name" /></td>
			</tr>	
			</logic:iterate>
		</table>
	</body>
</html>