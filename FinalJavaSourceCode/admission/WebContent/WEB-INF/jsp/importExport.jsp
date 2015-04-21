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





<html>
<head>


<link rel="stylesheet" type="text/css" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
<link rel="stylesheet" type="text/css" href="css/common.css">
<link rel="stylesheet" type="text/css" href="css/base.css">
<link rel="stylesheet" type="text/css" href="css/appl.css">

<script type="text/javascript">
	function disableSubmit(){
		document.getElementById("importXLSFilenameSubmit").disabled = true;
		document.forms[0].submit();
		return true;
	}
	function enableSubmit(){
		if(document.getElementById("importXLSFilenameSubmit").disabled)
			document.getElementById("importXLSFilenameSubmit").disabled = false;
	}
</script>

<%
	if(request.getAttribute("form processed") != null && request.getAttribute("form processed") == "true"){
		
%>
		<script type="text/javascript">
			enableSubmit();
		</script>
<%
	}
%>

</head>

<jsp:include page="/include/header.jsp"></jsp:include>
<jsp:include page="/include/menubar.jsp"></jsp:include>

<body>
	<div id="container">
	<div id="logout"><a href="/admission/logout.do">Logout</a></div>
	<div id="importExportMsgs" style="text-align:center;">
		<html:errors/>
		<%
			if(request.getAttribute("duplicateList") != null){
				java.util.ArrayList<String> list = (java.util.ArrayList<String>)(request.getAttribute("duplicateList"));
		%>
				<div id="duplicateEntries">
				** The following entries already exists and can't be re-entered
		<%
				for(int i = 0 ; i < list.size() ; i++)
					out.println("<br/>" + list.get(i));
		%>
				</div>
		<%
			}
		%>
		</div>
	
	<div id="exportXLSDiv"><br/><br/>
		To Export The Rates Table as XLS Click <a href="exportRates.do?method=exportRates"> here </a>
		<%
			if(request.getAttribute("XLSDownloadLink") != null){
		
				String str = request.getAttribute("XLSDownloadLink").toString();	
		%>
				<br/>
				<%= str %> 
		<%
			}
		%>
	</div>
	
	<div>
	<html:form  method="post" action="/submitApplicantXLS" enctype="multipart/form-data">
		<table id="importXLSTable">
			<tr>
				<th colspan="2">Location of the Applicants' EXCEL file to upload</th>
			</tr>
			<tr>
				<td><input type="file" name = "importXLSFilename" id="importXLFFilename" accept="application/vnd.ms-excel"/></td>
			</tr>
			<tr>
				<td align="right"><input type= "submit" id = "importXLSFilenameSubmit" onClick = "return true ; disableSubmit();" name="importXLSFilenameSubmit" value="Upload XLS" /></td>
			</tr>
		</table>
	</html:form>
	</div>
	</div>
</body>

<jsp:include page="/include/footer.jsp"></jsp:include>
</html>