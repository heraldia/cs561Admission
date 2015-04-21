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
					<th>Toefl</th>
					<th>Gre Verbal</th>
					<th>Gre Quanti</th>
					<th>Gre Writing</th>
					<th>IELTS</th>
					<th>PHD/MS</th>
					<th>Country</th>
					<th># of Recomm Letter</th>
			 </tr>
				<c:forEach var="completedApp" items="${completedApplicants}">
					<tr>
						<td>
							${completedApp[0].applicantId}
						</td>
						<td>
						    ${completedApp[0].nameLast}
						</td>
						<td>
							${completedApp[0].nameFirst}
						</td>
						<td>
							${completedApp[0].toeflScore}
						</td>
						<td>
							${completedApp[0].greVerbalScore}
						</td>
						<td>
							${completedApp[0].greQuantitativeScore}
						</td>
						<td>
							${completedApp[0].greWritingScore}
						</td>
						<td>
							${completedApp[0].ieltsScore}
						</td>
						<td>
							${completedApp[0].degreeSought}
						</td>
						<td>
							${completedApp[0].permanentCountry}
						</td>
						
					   <c:set var="numberReference" value="3" />
                       <c:if test="${completedApp[0].referenceName3 == ''}">
                       <c:set var="numberReference" value="2" />
                       </c:if>
                        <c:if test="${completedApp[0].referenceName2 == ''}">
                       <c:set var="numberReference" value="1" />
                        </c:if>
                         <c:if test="${completedApp[0].referenceName1 == ''}">
                       <c:set var="numberReference" value="0" />
                        </c:if>
                        	<td>
                            ${numberReference}
						</td>
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
