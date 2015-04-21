
<!--[if lte IE 7]> <html lang="en-us" class="lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>     <html lang="en-us" class="lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <%@page import="servletsession.AuthorityUtil"%>
<%@page import="strutsaction.StudentLogoutAction"%>
<html lang="en-us"> <!--<![endif]-->
<head>
	<meta charset="utf-8">
	<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
	<title>Log out</title>
	<% 
String path = request.getContextPath(); 
%> 
<link href="<%=path%>/css/base.css" media="all" rel="stylesheet">
<link href="<%=path%>/css/base.min.css" media="all" rel="stylesheet">
</head>
<body>
	<jsp:include page="/include/header.jsp"></jsp:include> 
	<center>
		<br>
		<h1>
			<bean:message key="logonStudent.title" />
		</h1>
	<div id="container">
		<div class="grids clearfix">
			<div class="grid-20" id="content">
				<div class="header">
				<h1>Log Out</h1>
				</div>
				<div class="content">
<%        
                                out.print("<script>alert('Confirm to log out');window.location.href='OnlineApplicationLogin.jsp'</script>");
								new AuthorityUtil().removeStudentAccount(request);
                           %>
                </div>
			</div>
			</div>
	</div>
	
</body>
<jsp:include page="/include/footer.jsp"></jsp:include> 
</html>
