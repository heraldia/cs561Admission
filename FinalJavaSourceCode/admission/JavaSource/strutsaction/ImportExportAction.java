/* done by Kim Ni Wang */

package strutsaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import edu.utils.ExportXLS;


public class ImportExportAction extends DispBaseAction {

	public ActionForward displayImportExportForm( ActionMapping mapping, ActionForm form, 
			  HttpServletRequest request, HttpServletResponse response) throws Exception {

		// display the upload download form page
		return mapping.findForward("displayForm");

	}
	
	/*
	 * export data by joining the applicant and committeeRating table
	 * @param mapping, form, request, response
	 * @return to its respective jsp
	 */
	public ActionForward exportRates( ActionMapping mapping, ActionForm form, 
			  HttpServletRequest request, HttpServletResponse response) throws Exception{
		
				ExportXLS exportXLS = new ExportXLS();
				String downloadLink = exportXLS.exportXLS(getServlet().getServletContext().getInitParameter("temp-folder"));
				
				if(downloadLink != null){
					
					String message = "<a href=\"temp/"+downloadLink  +"\">Download</a>";
					request.setAttribute("XLSDownloadLink", message);
					

				}else{
					addMessage(request, "error.failure.XLSExport");
					return mapping.findForward("exportFailure");
				}
				

				return mapping.findForward("exportedSuccessful");
	}

}
