<%@page import="model.RangeEval"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Applicant"%>
<%@page import="java.util.List"%>
<% response.setHeader("Cache-Control","no-cache"); //HTTP 1.1 
 response.setHeader("Pragma","no-cache"); //HTTP 1.0 
 response.setHeader("Cache-Control","no-store");
 response.setDateHeader ("Expires", 0); //prevents caching at the proxy server  
%>

<%
	if(request.getSession().getAttribute("authority.userinfo") == null){
%>
		<jsp:forward page="OnlineApplicationLogin.jsp"></jsp:forward>
<%
	}
%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html"
	prefix="html"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean"
	prefix="bean"%>
<%@ page import = "model.CommitteeProgress"  %>





<html>
<head>


<link rel="stylesheet" type="text/css" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
<link rel="stylesheet" type="text/css" href="css/common.css">
<link rel="stylesheet" type="text/css" href="css/base.css">
<link rel="stylesheet" type="text/css" href="css/appl.css">
<script type="text/javascript" src="js/jquery-1.10.2.js"></script>



</head>

<jsp:include page="/include/header.jsp"></jsp:include>
<jsp:include page="/include/menubar.jsp"></jsp:include>

<body>


	<div id="container">
	<div id="logout"><a href="/admission/logout.do">Logout</a></div>
		<h2 style="text-align: center ; margin-top:50px;">
			Applicant Round Statistics
		</h2>
		
<%
	if(request.getAttribute("roundStatistics") != null){
		long 					noOfApplicants 					= 	(Long)request.getAttribute("noOfApplicants");
		List<Applicant> 		applicantList  					= 	(List<Applicant>)request.getAttribute("applicantList");
		long 					noOfMinorApplicants				= 	(Long)request.getAttribute("noOfMinorApplicants");
		List<Applicant>  		minorApplicants					= 	(List<Applicant> )request.getAttribute("minorApplicants");
		long 					noOfUsCitizenApplicants			= 	(Long)request.getAttribute("noOfUsCitizenApplicants");
		List<Applicant>  		applicantUsCitizen				= 	(List<Applicant> )request.getAttribute("applicantUsCitizen");
		long 					noOfWomenApplicants				= 	(Long)request.getAttribute("noOfWomenApplicants");
		List<Applicant> 		applicantWomen					= 	(List<Applicant> )request.getAttribute("applicantWomen");
		double 					avgGreVerbalScore				= 	(Double)request.getAttribute("avgGreVerbalScore");
		double 					avgGreQuantScore				= 	(Double)request.getAttribute("avgGreQuantScore");
		ArrayList<RangeEval>	rangeEval						= 	(ArrayList<RangeEval>)request.getAttribute("rangeEval");
%>
	<div id= "applicantList" class="popUpContent" style="display:none;">
	<h4 class="closeme" onClick="closePopUp()">X</h4>
	<h2 class="tableHeader">All applicants</h2>
			<table>
				<tr>
					<th> Last Name </th>
					<th> First Name </th>
					<th> EmailId </th>
					<th> Degree </th>
				</tr>
<%
	for(int i = 0 ; i < applicantList.size() ; i++){
		
%>
				<tr>
					<td>
						<%= applicantList.get(i).getNameLast() %>
					</td>
					<td>
						<%= applicantList.get(i).getNameFirst() %>
					</td>
					<td>
						<%= applicantList.get(i).getEmail() %>
					</td>
					<td>
						<%= applicantList.get(i).getDegreeSought() %>
					</td>
				</tr>
<%
	}
%>
			</table>
		</div>
		
		<div id= "usCitizenApplicantList"  class="popUpContent"  style="display:none;">
		<h4 class="closeme" onClick="closePopUp()">X</h4>
		<h2 class="tableHeader">US Citizen Applicants</h2>
	
			<table>
				<tr>
					<th> Last Name </th>
					<th> First Name </th>
					<th> EmailId </th>
					<th> Degree </th>
				</tr>
<%
	for(int i = 0 ; i < applicantUsCitizen.size() ; i++){
		
%>
				<tr>
					<td>
						<%= applicantUsCitizen.get(i).getNameLast() %>
					</td>
					<td>
						<%= applicantUsCitizen.get(i).getNameFirst() %>
					</td>
					<td>
						<%= applicantUsCitizen.get(i).getEmail() %>
					</td>
					<td>
						<%= applicantUsCitizen.get(i).getDegreeSought() %>
					</td>
				</tr>
<%
	}
%>
			</table>
		</div>
		
		<div id= "minorApplicantList"  class="popUpContent" style="display:none;">
		<h4 class="closeme" onClick="closePopUp()">X</h4>
		<h2 class="tableHeader">Minor Applicants</h2>
			
			<table>
				<tr>
					<th> Last Name </th>
					<th> First Name </th>
					<th> EmailId </th>
					<th> Country </th>
				</tr>
<%
	for(int i = 0 ; i < minorApplicants.size() ; i++){
		
%>
				<tr>
					<td>
						<%= minorApplicants.get(i).getNameLast() %>
					</td>
					<td>
						<%= minorApplicants.get(i).getNameFirst() %>
					</td>
					<td>
						<%= minorApplicants.get(i).getEmail() %>
					</td>
					<td>
						<%= minorApplicants.get(i).getCitizenCountry() %>
					</td>
				</tr>
<%
	}
%>
			</table>
		</div>
		
		<div id= "womenApplicantList"  class="popUpContent" style="display:none;">
		<h4 class="closeme" onClick="closePopUp()">X</h4>
		<h2 class="tableHeader">Women Applicants</h2>
			
			<table>
				<tr>
					<th> Last Name </th>
					<th> First Name </th>
					<th> EmailId </th>
					<th> Degree </th>
				</tr>
<%
	for(int i = 0 ; i < applicantWomen.size() ; i++){
		
%>
				<tr>
					<td>
						<%= applicantWomen.get(i).getNameLast() %>
					</td>
					<td>
						<%= applicantWomen.get(i).getNameFirst() %>
					</td>
					<td>
						<%= applicantWomen.get(i).getEmail() %>
					</td>
					<td>
						<%= applicantWomen.get(i).getDegreeSought() %>
					</td>
				</tr>
<%
	}
%>
			</table>
		</div>
		
		<table id="report">
			<tr>
				<th class="header-top">Item</th>
				<th class="header-top" colspan = "2">Report</th>
			</tr>
			<tr>
				<th class="header-left">Number Of Applicants</th>
				<td><%= noOfApplicants %></td> <td><a href="#" id="noOfApplicants">view</a></td>
			</tr>
			<tr>
				<th class="header-left">Number of US citizens Applicants</th>
				<td><%= noOfUsCitizenApplicants %></td><td><a href="#" id="noOfUsCitizenApplicants">view</a></td>
			</tr>
			<tr>
				<th class="header-left">Number of Minority Applicants</th>
				<td><%= noOfMinorApplicants %></td><td><a href="#" id="noOfMinorityApplicants">view</a></td>
			</tr>
			<tr>
				<th class="header-left">Number of Women Applicants</th>
				<td><%= noOfWomenApplicants %></td><td><a href="#" id="noOfWomenApplicants">view</a></td>
			</tr>
			<tr>
				<th class="header-left">Average GRE QUANT SCORE</th>
				<td><%= avgGreQuantScore %></td>
			</tr>
			<tr>
				<th class="header-left">Average GRE VERBAL SCORE</th>
				<td><%= avgGreVerbalScore %></td>
			</tr>
		</table>

	<table id="report">
		<tr>
			<th colspan="10"> Distribution of Average Evaluation Score </th>
		</tr>
		<tr>
			<th class="header-top">0-9</th>
			<th class="header-top">10-19</th>
			<th class="header-top">20-29</th>
			<th class="header-top">30-39</th>
			<th class="header-top">40-49</th>
			<th class="header-top">50-59</th>
			<th class="header-top">60-69</th>
			<th class="header-top">70-79</th>
			<th class="header-top">80-89</th>
			<th class="header-top">90-99</th>
		</tr>
		<tr>

<%
	for(int i = 0 ; i < rangeEval.size() ; i++){
%>
	<td><%= rangeEval.get(i).count %></td>
<%
	}
%>



		</tr>
	</table>
<%


}
		
%>
	</div>
	
<script type="text/javascript">

	$("a#noOfApplicants").click(function(){
		var blackout = "<div class= \"blackOut\" onClick = \" closePopUp()\"></div>";
		$("div#container").append(blackout);
		$("div#applicantList").css("display","").addClass("popup");
		
	});

	$("a#noOfUsCitizenApplicants").click(function(){
		var blackout = "<div class= \"blackOut\" onClick = \" closePopUp()\"></div>";
		$("div#container").append(blackout);
		$("div#usCitizenApplicantList").css("display","").addClass("popup");
		
	});

	$("a#noOfWomenApplicants").click(function(){
		var blackout = "<div class= \"blackOut\" onClick = \" closePopUp()\"></div>";
		$("div#container").append(blackout);
		$("div#womenApplicantList").css("display","").addClass("popup");
		
	});

	$("a#noOfMinorityApplicants").click(function(){
		var blackout = "<div class= \"blackOut\" onClick = \" closePopUp()\"></div>";
		$("div#container").append(blackout);
		$("div#minorApplicantList").css("display","").addClass("popup");
		
	});

	function closePopUp(){
		$("div.blackOut").remove();
		$("div.popup").removeClass("popup").css("display" , "none");
	
	}
	
	
		
		
		
		
</script>

</body>
<jsp:include page="/include/footer.jsp"></jsp:include>

</html>