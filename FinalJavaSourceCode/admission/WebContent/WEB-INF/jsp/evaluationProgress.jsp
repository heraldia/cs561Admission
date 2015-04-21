<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

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
			<hr>
			<table width="900" border="1">
             <tr>
             		<th>ID</th>
					<th>Last Name</th>
					<th>First Name</th>
					<th>Total_Score1</th>
					<th>Total_Score2</th>
					<th>Total_Score</th>
					<th>PHD/MS</th>
					<th>Email</th>
					<th>Done1</th>
					<th>Done2</th>
			 </tr>
				<c:forEach var="eProgress" items="${evalProgress}">
					<tr>
						<td>${eProgress[0]}</td>
						<td>${eProgress[1]}</td>
						<td>${eProgress[2]}</td>
						<td>${eProgress[3]}</td>
						<td>${eProgress[4]}</td>
						<td>${eProgress[5]}</td>
						<td>${eProgress[6]}</td>
						<td>${eProgress[7]}</td>
						<td>${eProgress[8]}</td>
						<td>${eProgress[9]}</td>
					</tr>
				</c:forEach>
			</table>
		</center>
		
		</div>
		</div>
		</div>
		
	</body>
	<jsp:include page="/include/footer.jsp"></jsp:include>
</html>