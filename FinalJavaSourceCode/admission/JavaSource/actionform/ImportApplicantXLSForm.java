/* done by Kim Ni Wang  */

package actionform;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

import servletsession.AuthorityUtil;



public class ImportApplicantXLSForm extends ActionForm {
	
	private FormFile importXLSFilename;  
    private String importXLSFilenameSubmit;  
    
      
  
    public FormFile getImportXLSFilename() {  
        return importXLSFilename;  
    }  
  
    public void setImportXLSFilename(FormFile importXLSFilename) {  
        this.importXLSFilename = importXLSFilename;  
    }  

  
    @Override
    /*
     * validates the imported file
     * @param mapping, request
     * @return errors
     */
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		
		
		ActionErrors errors = new ActionErrors();
		
		int category =  AuthorityUtil.getUser(request).getCategory();
		
		if(category == 0){
			
			 errors.add("errorLastName", new ActionMessage("errors.invalid.InvalidAccess"));
		}else{
		
			// vertify that file extension is .xls check for null or empty fileName
			if	(this.importXLSFilename.getFileName() == null  || this.importXLSFilename.getFileName().trim().equals("") || 
				 !this.importXLSFilename.getFileName().substring(this.importXLSFilename.getFileName().lastIndexOf(".") + 1).equalsIgnoreCase("xls")) {
				
				 errors.add("errorLastName", new ActionMessage("errors.invalid.XLSFileName"));
			}
			// verify file size
			if(this.importXLSFilename.getFileSize() == 0){
				errors.add("errorLastName", new ActionMessage("errors.invalid.XLSFileSize"));
			}
			// verify filetype
			if(!this.importXLSFilename.getContentType().equals("application/vnd.ms-excel")){
				errors.add("errorLastName", new ActionMessage("errors.invalid.XLSFileType"));
			}
			
		}
		return errors;
    }
}
