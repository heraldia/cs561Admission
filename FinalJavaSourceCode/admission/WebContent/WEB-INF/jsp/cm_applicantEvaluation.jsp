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
	<html:form action="/cmevalApplicant.do">
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
				</tr>
				 <tr>
				
			<%    AuthorityUtil.saveEvalApplicant(request, Integer.parseInt(request.getParameter("aid"))); %>
			
				 	<td><%= request.getParameter("aid") %></td>
					<td><%= request.getParameter("alname") %></td>
					<td><%= request.getParameter("afname") %></td>
					<td><%= request.getParameter("atoefl") %></td>
					<td><%= request.getParameter("averbal") %></td>
					<td><%= request.getParameter("aquantitative") %></td>
					<td><%= request.getParameter("awriting") %></td>
					<td><%= request.getParameter("aielts") %></td>
					<td><%= request.getParameter("adegree") %></td>
				</tr>
				<tr>
					<th colspan="3" >Country</th>
					<th colspan="3" >Email</th>
					<th colspan="3"> <font color="red" >Notes</font></th>
				</tr>
				<tr>
				    <td colspan="3" align="center"><%= request.getParameter("acountry") %></th>
					<td colspan="3" align="center"><%= request.getParameter("aemail") %></th>
					<td colspan="3" align="center" ><%= request.getParameter("anote") %></th>
				</tr>
			</table width="900" border="1">
			<br>
			<br>
			<br>
			<table  width="700" border="1">
				<tr>
					<th>ID</th>
					<th colspan="1">Items</th>
					<th colspan="4" >Score(Integer 0~50)</th>
				</tr>
				<tr>
					<td>1</td>
					<td colspan="1" align="center">Score</td>
					<td colspan="4" align="center"> <html:text property="totalScore"/> </td>
				</tr>
				<tr>
					<td colspan="1">2</td>
					<td colspan="4" align="center" valign="center">Comments<html:textarea property="comments"/></td>
					
				</tr>
				
				<tr>
					<td rowspan = "2">3</td>
					<td colspan="2" align="center">Recommended for TA support <html:checkbox property="ta" /></td>
					<td  "right" rowspan = 2>
					
					<html:submit value="Submit"/>
					
					</td>
				</tr>
				<tr>
				 <td colspan="2" align="center">Recommended for Fellowship <html:checkbox property="fe" /></td>
			
				
				
				
			</table width="700" border="1">
		</center>
		
		</div>
		</div>
		</div>


		</html:form>



	</body>
	<jsp:include page="/include/footer.jsp"></jsp:include>
</html>
