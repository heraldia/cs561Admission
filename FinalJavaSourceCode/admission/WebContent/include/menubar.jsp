 <%@page import="servletsession.AuthorityUtil"%>
 
<div class="" id="menubar">
    <div class="grids-24">
        <ul class="navigation">
            <% //int category = (Integer)session.getAttribute("category");
            int category =  AuthorityUtil.getUser(request).getCategory();
             //int category = (Integer)session.getAttribute("category");
            %>
              <%if (category > 0){ %>
            <li class=""><a href="listDecisions.do?method=all">Admission decision</a>
            <!--
            <ul>
                <li class=""><a
                    href="listDecisions.do?phdms=PHD">PHD
                    applicants</a></li>
                <li class=""><a
                    href="listDecision.do?phdms=MS">MS
                    applicants</a></li>
            </ul>
            -->
            </li>
            <%} %>
               <li class=""><a href="progress.do?method=getCP">Committee progress</a></li>
            
            <% if (category ==0 || category ==1 ){ %>
            <li class=""><a
                href="/admission/CMApplicantP.do?phdms=all">Applicants</a>
            <ul>
                <li class=""><a
                    href="/admission/CMApplicantP.do?phdms=PHD">PHD
                    applicants</a></li>
                <li class=""><a
                    href="/admission/CMApplicantP.do?phdms=MS">MS
                    applicants</a></li>
            </ul></li>

            <li class=""><a href="/admission/CMRatesC.do?phdms=all">Completed evaluations</a>
            <ul>
                <li class=""><a
                    href="/admission/CMRatesC.do?phdms=PHD">PHD
                    applicants</a></li>
                <li class=""><a
                    href="/admission/CMRatesC.do?phdms=MS">MS applicants</a>
                </li>
            </ul></li>
            
           
            <%}
            if (category > 0){
            %>
            <li class=""><a href="/admission/listAllApplicantsP.do?method=all">All
                applicants</a>
            <ul>
                <li class=""><a href="/admission/listAllApplicantsP.do?method=phd">PHD
                    applicants</a></li>
                <li class=""><a href="/admission/listAllApplicantsP.do?method=ms">MS
                    applicants</a></li>
            </ul></li>




            <li class=""><a href="/admission/EvalProg.do?phdms=all">Evaluation progress</a>
            <ul>
                <li class=""><a href="/admission/EvalProg.do?phdms=PHD">PHD
                    applicants</a></li>
                <li class=""><a href="/admission/EvalProg.do?phdms=MS">MS
                    applicants</a></li>
            </ul></li>
            
         

            <li class="">
            	<a href="report.do?method=getData">Report</a>
			<%
				if((category != 0)){
			%>
            	<ul>
            		<li><a href="importExport.do?method=displayImportExportForm">Export / Import</a></li>
            	</ul>
			 <%
				}
			 %>
            </li>
            
            
            <%} %>
            
          
            
            <%if (category > 0  ){ %>
            <li class=""><a href="listMails.do?method=all">Mail list</a>
            <ul>
                <li class=""><a href="listNotes.do?method=all">Notes</a>
                </li>
            </ul></li>
            <%} %>
        </ul>
		 
    </div>
</div>
