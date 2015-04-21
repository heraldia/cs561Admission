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
					<th>Research Interest</th>
					<th>Country</th>
					<th># of Recomm Letter</th>
					<th>Done</th>
					 
				</tr>
				<c:forEach var="applicant" items="${applicants}">
					<tr>
						<td>
						
							${applicant[0]}
							
						</td>
						<td>
						 
					  	 <html:link action="/CMApplicantEval.do?aid=${applicant[0]}&alname=${applicant[1]}&afname=${applicant[2]}&atoefl=${applicant[3]}&averbal=${applicant[4]}&aquantitative=${applicant[5]}&awriting=${applicant[6]}&aielts=${applicant[7]}&adegree=${applicant[8]}&acountry=${applicant[11]}&aemail=${applicant[10]}&anote=${applicant[16]}">
					  	 ${applicant[1]}
					  	 </html:link><br>
				
				
					
						 
						</td>
						<td>
							${applicant[2]}
						</td>
						<td>
							${applicant[3]}
						</td>
						<td>
							${applicant[4]}
						</td>
						<td>
							${applicant[5]}
						</td>
						<td>
							${applicant[6]}
						</td>
						<td>
							${applicant[7]}
						</td>
						<td>
							${applicant[8]}
						</td>
						<td>
							${applicant[9]}
						</td>
						<td>
							${applicant[11]}
						</td>
						
					   <c:set var="numberReference" value="3" />
                       <c:if test="${applicant[12] == ''}">
                       <c:set var="numberReference" value="2" />
                       </c:if>
                        <c:if test="${applicant[13] == ''}">
                       <c:set var="numberReference" value="1" />
                        </c:if>
                         <c:if test="${applicant[14] == ''}">
                       <c:set var="numberReference" value="0" />
                        </c:if>
                        	<td>
                            ${numberReference}
						</td>
						<td>
							${applicant[15]}
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
