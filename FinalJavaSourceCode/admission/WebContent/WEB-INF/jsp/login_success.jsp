<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page import="servletsession.AuthorityUtil"%>
 
<html>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/base.css">
    <title>Login success</title>
    <% 
    String path = request.getContextPath(); 
    %> 

    <script type="text/javascript">
     
function confirmation() 
{ 
    var answer = confirm("Confirm to setup rates table?") ;
    if (answer){ 
        alert("OK!") ;
        window.location= "/RandomAssign";
    } 
    else{ 
        alert("Back then!");
    }
}

</script>

 
<jsp:include page="/include/header.jsp"></jsp:include> 
<jsp:include page="/include/menubar.jsp"></jsp:include> 


<div id="container">
    <div class="grids clearfix">
        <div class="grid-40" id="content">
        <center>
            <div class="header clearfix" >
            
                <h1>Login Success</h1>
            </div>
            <div id="logout">
            <html:link action="/logout">Logout</html:link><br>
            <html:link action="/reset">Change password</html:link>
            <!--  
                <a href="logout.jsp">Logout</a><br>
                <a href="changePin.jsp">Change password</a>
                -->
            </div>
            <div class="content">
                <hr>
                <br>
                <%
              //  if (request.getSession().getAttribute("uid") != null) {
                // log in already
              //  int category = (Integer)request.getSession().getAttribute("category");
             //   int uid = (Integer)request.getSession().getAttribute("uid");
                 int category =  AuthorityUtil.getUser(request).getCategory();
                 int uid =  AuthorityUtil.getUser(request).getUid();
                 String nameString = AuthorityUtil.getUser(request).getUsername();;
                 
                String categoryString = null;
                switch(category){
                case 0:
                categoryString = "Committee member"; break;
                case 1:
                categoryString = "Committee chair"; break;
                case 2:
                categoryString = "Department chair"; break;
                case 3:
                categoryString = "Staff"; break;
                }
                %>
                <h3>
                    Welcome <font color="red"> 
                       <!--  <%=categoryString%> --> 
                        <%=nameString%>
                        <br>
                        Your Id number is <%=uid %><br>
                    </font>
                </h3>
                </center>
                <% if (category != 0 ){ %>
                <br>
                <center>
                    <fieldset style="width:200px;background:gold" id = "setupFieldset"><legend>Instruction</legend>
                        Please "setup" the system after uploading or renewing the Applicants Table every time. By click   
                        <a onClick="confirmation()">Setup</a>. DO NOT TOUCH HERE AT OTHER TIME.
                    </fieldset>
                </center>

                <%  }%>
            </div>
        </div>
        <%
        /*} else {
        // not yet login in
        response.setHeader("refresh", "2;URL=index.jsp");
        */
        %>
       <!--   Not log in yet <br>  Return in 2 seconds <br> If not return, please
        click <a href="index.jsp"> here </a> !!!<br>-->
        <%
        //}
        %>
    </div>
</div>
            </body>
            <jsp:include page="/include/footer.jsp"></jsp:include>
        </html>
