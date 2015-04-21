<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>

<jsp:directive.page contentType="text/html; charset=ISO-8859-1" 
		pageEncoding="ISO-8859-1" />

<html>
<head>
       
<link rel="stylesheet" href="/css/common.css">
<link rel="stylesheet" href="/css/base.css">
<link rel="stylesheet" href="/css/pswdReset.css">
    
    <script>
        function getBack1()
        {
            window.location = '<html:rewrite action="/getback1"/>';
        }
    </script>
 
</head>

<jsp:include page="/include/header.jsp"></jsp:include> 
 
<body>
<html:errors/>
<div id="container">
<div class="grids clearfix">
<div class="grid-40" id="content">

<center>
		<h1><bean:message key="password.reset" /></h1>
		
<table width="500">
    <html:form action="/studentResetPassword">
    <tr>
			<td colspan="2"> <html:errors/> </td>
		</tr>
        <tr>
            <td align="right">original password</td>
            <td><html:password property="originalPassword"/></td>
        </tr>
        <tr>
            <td align="right">new password</td>
            <td><html:password property="newPassword"/></td>
        </tr>
        <tr>
            <td align="right">confirm password</td>
            <td><html:password property="newRepassword"/></td>
        </tr>
        <br>
        <tr >
            <td align="center" colspan="2"><html:submit styleClass="btn btn-primary">Submit</html:submit>
            <html:button styleClass="btn btn-primary" property="getback1" onclick="getBack1();">Cancel</html:button></td>

        </tr>
       <br><br>
        <tr>
				<html:link action="/getback1"><h2>Back to Log in page</h2></html:link>
				<br>
		
		</tr>
    </html:form>
</table>
</center>
</div>
</div>
</div>
</body>
<jsp:include page="/include/footer.jsp"></jsp:include> 
</html>
