<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page import="servletsession.AuthorityUtil"%>

<html>
<link rel="stylesheet" href="/css/common.css">
<link rel="stylesheet" href="/css/base.css">


	 <jsp:include page="/include/header.jsp"></jsp:include>
	 <jsp:include page="/include/menubar.jsp"></jsp:include>



<body>
	<div id="container">
    <div class="grids clearfix">
        <div class="grid-40" id="content">
		<center>
		<h1> </h1>
			<br>
			<h1>
				<bean:message key="logon.title" />
			</h1>
			 <div id="logout">
            <html:link action="/logout">Logout</html:link><br>
        </div>
      <h1>  <font color="red"><%= request.getAttribute("ResultofQuery") %> </font> </h1>
   
   
</body>

<jsp:include page="/include/footer.jsp"></jsp:include>
</html>