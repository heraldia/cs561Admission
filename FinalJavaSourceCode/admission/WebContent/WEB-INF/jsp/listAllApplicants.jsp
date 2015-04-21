<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>
<head>
<style type="text/css" title="currentStyle">
            @import "css/demo_page.css";
			@import "css/demo_table.css";
        </style>
<link rel="stylesheet" href="/css/common.css">
<link rel="stylesheet" href="/css/base.css">

	 <jsp:include page="/include/header.jsp"></jsp:include>
	 <jsp:include page="/include/menubar.jsp"></jsp:include>
      
<script type="text/javascript" language="javascript" src="js/jquery-1.10.2.js"></script>
<script type="text/javascript" language="javascript" src="js/jquery.dataTables.js"></script>

		<script type="text/javascript" charset="utf-8">
			var oTable;
			
			$(document).ready(function() {
				/* Add a click handler to the rows - this could be used as a callback */
				$("#example tbody tr").click( function( e ) {
					if ( $(this).hasClass('row_selected') ) {
						$(this).removeClass('row_selected');
					}
					else {
						oTable.$('tr.row_selected').removeClass('row_selected');
						$(this).addClass('row_selected');
					}
				});
			} );
			
			
			/* Get the rows which are currently selected */
			function fnGetSelected( oTableLocal )
			{
				return oTableLocal.$('tr.row_selected');
			}
			
			$(document).ready( function () { 
			     $( '#example' ).dataTable( { 
			         //"bProcessing" : true , 
			         //"bServerSide" : true , 
			         //"sAjaxSource" : "list_mail.jsp" // DATA isn't JSON!
			     } ); 
			} );
		</script>
</head>
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
            <html:link action="/listAllApplicantsP.do?method=msPaging">MS</html:link><br>
            <html:link action="/listAllApplicantsP.do?method=phdPaging">PHD</html:link><br>
            <html:link action="/listAllApplicantsP.do?method=all">Full List</html:link><br>
            </div>
			<hr>
			<table class="display" id="example" width="900" border="1">
                <thead>
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
				</thead>
				<tbody>
				
				<c:forEach var="applicant" items="${applicants}">
					<tr>
						<td>
							${applicant.applicantId}
						</td>
						<td>
							${applicant.nameLast}
						</td>
						<td>
							${applicant.nameFirst}
						</td>
						<td>
							${applicant.toeflScore}
						</td>
						<td>
							${applicant.greVerbalScore}
						</td>
						<td>
							${applicant.greQuantitativeScore}
						</td>
						<td>
							${applicant.greWritingScore}
						</td>
						<td>
							${applicant.ieltsScore}
						</td>
						<td>
							${applicant.degreeSought}
						</td>
						<td>
							${applicant.permanentCountry}
						</td>
					   <c:set var="numberReference" value="3" />
                       <c:if test="${applicant.referenceName3 == ''}">
                       <c:set var="numberReference" value="2" />
                       </c:if>
                        <c:if test="${applicant.referenceName2 == ''}">
                       <c:set var="numberReference" value="1" />
                        </c:if>
                         <c:if test="${applicant.referenceName1 == ''}">
                       <c:set var="numberReference" value="0" />
                        </c:if>
                        	<td>
                            ${numberReference}
						</td>
					</tr>
				
				</c:forEach>
				</tbody>
			</table>
		</center>
		</div>
		</div>
		</div>
		
	</body>
	<jsp:include page="/include/footer.jsp"></jsp:include>
</html>
