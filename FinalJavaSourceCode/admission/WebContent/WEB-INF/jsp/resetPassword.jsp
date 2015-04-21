<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>

<jsp:directive.page contentType="text/html; charset=ISO-8859-1" 
		pageEncoding="ISO-8859-1" />

<html>
    <head>
    <title>resetPassword</title>
    <script>
        function getBack()
        {
            window.location = '<html:rewrite action="/getback"/>';
        }
    </script>

    <style type="text/css">
        input[type="password"] {
            height: 30px;
        }
        input[type="text"] {
            height: 30px;
        }
        table{
            text-align: center;
        }
    </style>
<link rel="stylesheet" href="/css/common.css">
<link rel="stylesheet" href="/css/base.css">

    </head>
<jsp:include page="/include/header.jsp"></jsp:include> 
<jsp:include page="/include/menubar.jsp"></jsp:include> 

<body>
<html:errors/>
<div id="container">
<div class="grids clearfix">
<div class="grid-40" id="content">

<center>
<table>
<tr hight="25"><td></td></tr>
    <html:form action="/resetPassword">
        <tr>
            <td>original password</td>
            <td><html:password property="originalPassword"/></td>
        </tr>
        <tr>
            <td>new password</td>
            <td><html:password property="newPassword"/></td>
        </tr>
        <tr>
            <td>confirm password</td>
            <td><html:password property="newRepassword"/></td>
        </tr>
        <tr>
            <td><html:submit styleClass="btn btn-primary">Submit</html:submit></td>
            <td><html:button styleClass="btn btn-primary" property="back" onclick="getBack();">Cancel</html:button></td>

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
