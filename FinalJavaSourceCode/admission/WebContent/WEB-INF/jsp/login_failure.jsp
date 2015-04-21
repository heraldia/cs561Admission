<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--[if lte IE 7]> <html lang="en-us" class="lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>     <html lang="en-us" class="lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html lang="en-us"> <!--<![endif]-->
<head>
	<meta charset="utf-8">
	<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
	<title>Login - Failure</title>
	<% 
String path = request.getContextPath(); 
%> 
<link href="<%=path%>/css/base.css" media="all" rel="stylesheet">
</head>
<body>
	<div class="skip"><a accesskey="2" href="#container">Skip Navigation</a></div>
	<div class="hwrapper" id="header">
		<div class="isu-dark-ribbon" id="top-strip">
			<div class="grid-fluid clearfix">
				<div class="grid-left">
					<ul class="isu-signons hlist borders left">
						<li class="first"><a href="http://cymail.iastate.edu/">CyMail</a></li>
						<li><a href="http://exchange.iastate.edu/">Outlook</a></li>
						<li><a href="http://webct.its.iastate.edu/">WebCT</a></li>
						<li><a href="http://bb.its.iastate.edu/">Blackboard</a></li>
						<li class="last"><a href="http://accessplus.iastate.edu/">AccessPlus</a></li>
					</ul>
				</div>
				<div class="grid-right">
					<ul class="isu-utilities hlist borders right">
						<li class="first"><a href="http://info.iastate.edu/">Directory</a></li>
						<li><a href="http://www.fpm.iastate.edu/maps/">Maps</a></li>
						<li class="last"><a href="http://www.iastate.edu/contact/">Contact Us</a></li>
					</ul>
					<ul class="isu-alpha-index hlist right">
						<li><a href="http://www.iastate.edu/index/A/">A</a></li><li><a href="http://www.iastate.edu/index/B/">B</a></li><li><a href="http://www.iastate.edu/index/C/">C</a></li><li><a href="http://www.iastate.edu/index/D/">D</a></li><li><a href="http://www.iastate.edu/index/E/">E</a></li><li><a href="http://www.iastate.edu/index/F/">F</a></li><li><a href="http://www.iastate.edu/index/G/">G</a></li><li><a href="http://www.iastate.edu/index/H/">H</a></li><li><a href="http://www.iastate.edu/index/I/">I</a></li><li><a href="http://www.iastate.edu/index/J/">J</a></li><li><a href="http://www.iastate.edu/index/K/">K</a></li><li><a href="http://www.iastate.edu/index/L/">L</a></li><li><a href="http://www.iastate.edu/index/M/">M</a></li><li><a href="http://www.iastate.edu/index/N/">N</a></li><li><a href="http://www.iastate.edu/index/O/">O</a></li><li><a href="http://www.iastate.edu/index/P/">P</a></li><li><a href="http://www.iastate.edu/index/Q/">Q</a></li><li><a href="http://www.iastate.edu/index/R/">R</a></li><li><a href="http://www.iastate.edu/index/S/">S</a></li><li><a href="http://www.iastate.edu/index/T/">T</a></li><li><a href="http://www.iastate.edu/index/U/">U</a></li><li><a href="http://www.iastate.edu/index/V/">V</a></li><li><a href="http://www.iastate.edu/index/W/">W</a></li><li><a href="http://www.iastate.edu/index/X/">X</a></li><li><a href="http://www.iastate.edu/index/Y/">Y</a></li><li><a href="http://www.iastate.edu/index/Z/">Z</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="isu-red-ribbon" id="ribbon">
			<div class="grid-fluid clearfix">
				<div class="grid-left">
					<a accesskey="1" class="nameplate" href="http://www.iastate.edu/">
						<img alt="Iowa State University" src="<%=path%>/img/sprite.png"/>
					</a>
				</div>
				<div class="grid-right">
					<form action="http://google.iastate.edu/search" class="isu-search-form" method="GET">
						<input name="output" type="hidden" value="xml_no_dtd"/>
						<input name="client" type="hidden" value="default_frontend"/>
						<input name="sitesearch" type="hidden" value=""/>
						<input name="proxystylesheet" type="hidden" value="default_frontend"/>
						<input accesskey="s" name="q" placeholder="Search" tabindex="1" type="text"/>
						<input name="btnG" title="Search" type="submit" value=""/>
					</form>
				</div>
			</div>
			<div class="grid-fluid clearfix">
				<div class="grid-left">
				<h2 class="site-title"><a href="http://www.las.iastate.edu/" target="blank">College of Liberal Arts & Sciences</a><br><font color="white">Department of Computer Science</font></h2>
                    <font size="-2" color="#FFCC00"><em><b>ALL SCIENCE IS COMPUTER SCIENCE</b></font></em>
				</div>
			</div>
			</div>
	</div>
	<div id="container">
		<div class="grids clearfix">
			<div class="grid-20" id="content">
				<div class="header">
				<h1>Login - Failure</h1>
				</div>
				<div class="content">
<hr><br>
	<h3>Wrong username and pin!</h3>
	
	 <% response.setHeader("refresh","2;URL=login.jsp") ;
	 %>
	<a href="login.jsp">Back to login page</a>
				</div>
			</div>
			</div>
	</div>
	<div class="fwrapper">
		<div class="grid-fluid clearfix" id="footer">
			<div class="grid-left first">
				<a class="nameplate" href="/"><img alt="Iowa State University" src="<%=path%>/img/sprite.png"></a>
			</div>
			<div class="grid-left last">
			  <p>Department of Computer Science, 226 Atanasoff Hall, Ames, IA  50011, Phone (515) 294-4377, <script>document.write('<a href="mailto:'+ ["csdept", "iastate.edu"].join('@') +'">'+ ["csdept", "iastate.edu"].join('@') +'</a>')</script><noscript>email (at) iastate (dot) edu</noscript>.</p>
				<p>
					Copyright &copy; 1995-2012, Iowa State University of Science and Technology.
					All rights reserved. 
				</p>
			</div>
		</div>
	</div>
	<div id="loading" style="display:none">Loading...</div>
</body>
</html>
