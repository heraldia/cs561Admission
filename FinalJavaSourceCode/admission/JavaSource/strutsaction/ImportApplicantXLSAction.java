/* done by Kim Ni Wang */
 
package strutsaction;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;


import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Applicant;
import dao.ApplicantDAO;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionServlet;
import org.apache.struts.upload.FormFile;

import actionform.ImportApplicantXLSForm;

public class ImportApplicantXLSAction extends BaseAction {

	String tempLocation ;
	/*
	 * import the file and saves the filename in the temp folder, also checks if the applicants data eists in the database or not
	 * @param mapping, form, request, response
	 * @return to its respective jsp
	 */
	public ActionForward execute( ActionMapping mapping, ActionForm form, 
		HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ImportApplicantXLSForm xlsForm = (ImportApplicantXLSForm)form;
		FormFile xlsFormFile = xlsForm.getImportXLSFilename(); 
		String path = getServlet().getServletContext().getInitParameter("temp-folder") + "/" + xlsFormFile.getFileName();
		FileOutputStream fileOutputStream = new FileOutputStream(new File(path));
		try{
			fileOutputStream.write(xlsFormFile.getFileData());
		}catch(IOException exp){
			request.setAttribute("form processed", "true");
			addMessage(request, "errors.invalid.XLSUploadFailure");
			return mapping.findForward("notUploaded");
		}finally{
			if(fileOutputStream != null){
				fileOutputStream.close();
			}
		}
		
		ArrayList<Applicant> applicants = getApplicantListFromXLSFile(path , getServlet());
		if(applicants == null){
			request.setAttribute("form processed", "true");
			addMessage(request, "errors.invalid.ReadXLSFailed");
			return mapping.findForward("notUploaded");
		}
		
		ArrayList<String> duplicateEntries = new ArrayList<String>();
		
		ApplicantDAO dao = new ApplicantDAO();
		
		
		for(int i = 0 ; i < applicants.size() ; i++){
			boolean isEmailIdExists = dao.isEmailIdExists(applicants.get(i).getEmail());
		    if(isEmailIdExists){
		    	duplicateEntries.add(applicants.get(i).getEmail());
		    	applicants.remove(i);
		    	i--;
		    }
			
		}
		
		if(duplicateEntries.size() != 0){
			request.setAttribute("duplicateList", duplicateEntries);
		}
		
		for(Applicant applicant : applicants){
			applicant.setApplicantId(dao.getLastId() + 1);
			dao.saveApplicant(applicant);
		}
		request.setAttribute("form processed", "true");
		addMessage(request, "errors.success.XLSUploadSuccess");
		return mapping.findForward("uploadedSuccessfully");

}
	/*
	 * from the xls file, checks all the mandatory fields are present, verify the number of columns, sheets
	 * @param filepath, servlet
	 * @return applicants
	 */
	public ArrayList<Applicant> getApplicantListFromXLSFile(String filePath , ActionServlet servlet){
		
		File xlsFile = new File(filePath);
		Workbook workbook;
		Sheet sheet;
		
		ArrayList<String> columnName = new ArrayList<String>();
		ArrayList<String> type = new ArrayList<String>();
		ArrayList<Boolean> isMandatory = new ArrayList<Boolean>();
		
		ArrayList<Applicant> applicants = new ArrayList<Applicant>();
		
		try{
			workbook = Workbook.getWorkbook(xlsFile);
			int noOfSheets = workbook.getNumberOfSheets();
			
			for(int s = 0 ; s < noOfSheets ; s++){
				
				// get sheets
				sheet = workbook.getSheet(s);
				
				// get colums
				int noOfCols = sheet.getColumns();
				if(noOfCols == 0) continue;
				
				// verify no of columns
				
				if(noOfCols != Integer.parseInt(servlet.getServletContext().getInitParameter("XLS_NO_OF_COLS"))){
					return null;
				}
				
				// get the values of XLS fields defines in the web.xml
				if(!populateValuesFromServletContext(columnName , type , isMandatory , servlet))
					return null;
				
				Cell cell = null;
				CellType cellType = null;
				boolean isFieldNameCorrect = true;
				
				for(int row = 0 ; row < sheet.getRows() ; row++){
					boolean isRowEmpty = true;
					boolean isMandatoryFieldsSatisfied = true;
					Applicant applicant = new Applicant();
					//get rows
					for(int col = 0 ; col < sheet.getColumns() ; col++ ){
						cell = sheet.getCell(col, row);
						
						if(row == 0){
							// check for column header names in uploaded XLS file , whether they match XLS definition defined in web.xml
							if(!cell.getContents().equalsIgnoreCase(columnName.get(col))){
								// incorrect field name
								isFieldNameCorrect = false;
								return null;
							}
						}else{
							cellType = cell.getType();
							
							if(col == 0){
								
								if(cellType == CellType.LABEL && type.get(col).trim().equalsIgnoreCase("string")){
									isRowEmpty = false;
									if(cell.getContents().trim().equalsIgnoreCase("") || cell.getContents() == null){
										isMandatoryFieldsSatisfied = false;
									}
									applicant.setNameLast(cell.getContents());
								}else if(cellType == CellType.EMPTY){
									isMandatoryFieldsSatisfied = false;
								}else if(cellType == CellType.ERROR){
									isMandatoryFieldsSatisfied = false;
								}
								
							}else if(col == 1){
								
								if(cellType == CellType.LABEL && type.get(col).trim().equalsIgnoreCase("string")){
									isRowEmpty = false;
									if(cell.getContents().trim().equalsIgnoreCase("") || cell.getContents() == null){
										isMandatoryFieldsSatisfied = false;
									}
									applicant.setNameFirst(cell.getContents());
								}else if(cellType == CellType.EMPTY){
									isMandatoryFieldsSatisfied = false;
								}else if(cellType == CellType.ERROR){
									isMandatoryFieldsSatisfied = false;
								}
								
							}else if(col == 2){
								
								if(cellType == CellType.LABEL && type.get(col).trim().equalsIgnoreCase("string")){
									
									isRowEmpty = false;
									applicant.setNameMiddle(cell.getContents());
									
									
								}else if(cellType == CellType.EMPTY){
									
									
								}else if(cellType == CellType.ERROR){
									isRowEmpty = false;
									applicant.setNameFirst("");
									
								}
								
							}else if(col == 3){
								
								if(cellType == CellType.LABEL && type.get(col).trim().equalsIgnoreCase("string")){
									isRowEmpty = false;
									if(cell.getContents().trim().equalsIgnoreCase("") || cell.getContents() == null){
										isMandatoryFieldsSatisfied = false;
									}
									applicant.setEmail(cell.getContents());
								}else if(cellType == CellType.EMPTY){
									isMandatoryFieldsSatisfied = false;
								}else if(cellType == CellType.ERROR){
									isMandatoryFieldsSatisfied = false;
								}
								
							}else if(col == 4){
								
								if(cellType == CellType.LABEL && type.get(col).trim().equalsIgnoreCase("string")){
									isRowEmpty = false;
									applicant.setPermanentCountry(cell.getContents());
								}else if(cellType == CellType.EMPTY){
									
								}else if(cellType == CellType.ERROR){
									
								}
								
							}else if(col == 5){
								
								if(cellType == CellType.LABEL && type.get(col).trim().equalsIgnoreCase("string")){
									isRowEmpty = false;
									applicant.setCitizenCountry(cell.getContents());
								}else if(cellType == CellType.EMPTY){
									
								}else if(cellType == CellType.ERROR){
									
								}
								
							}else if(col == 6){
								if(cellType == CellType.LABEL && type.get(col).trim().equalsIgnoreCase("string")){
									isRowEmpty = false;
									applicant.setEthnic(cell.getContents());
								}else if(cellType == CellType.EMPTY){
									
								}else if(cellType == CellType.ERROR){
									
								}
							}else if(col == 7){
								if(cellType == CellType.LABEL && type.get(col).trim().equalsIgnoreCase("string")){
									isRowEmpty = false;
									applicant.setGender(cell.getContents());
								}else if(cellType == CellType.EMPTY){
									
								}else if(cellType == CellType.ERROR){
									
								}
							}else if(col == 8){
								if(cellType == CellType.NUMBER && type.get(col).trim().equalsIgnoreCase("number")){
									isRowEmpty = false;
									applicant.setGreVerbalScore(Integer.parseInt(cell.getContents()));
								}else if(cellType == CellType.EMPTY){
									
								}else if(cellType == CellType.ERROR){
									
								}
							}else if(col == 9){
								if(cellType == CellType.NUMBER && type.get(col).trim().equalsIgnoreCase("number")){
									isRowEmpty = false;
									applicant.setGreQuantitativeScore(Integer.parseInt(cell.getContents()));
								}else if(cellType == CellType.EMPTY){
									
								}else if(cellType == CellType.ERROR){
									
								}
							}else if(col == 10){
								if(cellType == CellType.NUMBER && type.get(col).trim().equalsIgnoreCase("number")){
									isRowEmpty = false;
									applicant.setGreWritingScore(Double.parseDouble(cell.getContents()));
								}else if(cellType == CellType.EMPTY){
									
								}else if(cellType == CellType.ERROR){
									
								}
							}else if(col == 11){
								if(cellType == CellType.NUMBER && type.get(col).trim().equalsIgnoreCase("number")){
									isRowEmpty = false;
									applicant.setToeflScore(Integer.parseInt(cell.getContents()));
								}else if(cellType == CellType.EMPTY){
									
								}else if(cellType == CellType.ERROR){
									
								}
							}else if(col == 12){
								if(cellType == CellType.NUMBER && type.get(col).trim().equalsIgnoreCase("number")){
									isRowEmpty = false;
									applicant.setIeltsScore(Double.parseDouble(cell.getContents()));
								}else if(cellType == CellType.EMPTY){
									
								}else if(cellType == CellType.ERROR){
									
								}
							}else if(col == 13){
								if(cellType == CellType.LABEL && type.get(col).trim().equalsIgnoreCase("string")){
									isRowEmpty = false;
									applicant.setDegreeSought(cell.getContents());
								}else if(cellType == CellType.EMPTY){
									
								}else if(cellType == CellType.ERROR){
									
								}
							}else if(col == 14){
								if(cellType == CellType.LABEL && type.get(col).trim().equalsIgnoreCase("string")){
									isRowEmpty = false;
									applicant.setResearchInterest(cell.getContents());
								}else if(cellType == CellType.EMPTY){
									
								}else if(cellType == CellType.ERROR){
									
								}
							}else if(col == 15){
								if(cellType == CellType.LABEL && type.get(col).trim().equalsIgnoreCase("string")){
									isRowEmpty = false;
									applicant.setStatement(cell.getContents());
								}else if(cellType == CellType.EMPTY){
									
								}else if(cellType == CellType.ERROR){
									
								}
							}else if(col == 16){
								if(cellType == CellType.LABEL && type.get(col).trim().equalsIgnoreCase("string")){
									isRowEmpty = false;
									applicant.setReferenceName1(cell.getContents());
								}else if(cellType == CellType.EMPTY){
									
								}else if(cellType == CellType.ERROR){
									
								}
							}else if(col == 17){
								if(cellType == CellType.LABEL && type.get(col).trim().equalsIgnoreCase("string")){
									isRowEmpty = false;
									applicant.setReferenceName2(cell.getContents());
								}else if(cellType == CellType.EMPTY){
									
								}else if(cellType == CellType.ERROR){
									
								}
							}else if(col == 18){
								if(cellType == CellType.LABEL && type.get(col).trim().equalsIgnoreCase("string")){
									isRowEmpty = false;
									applicant.setReferenceName3(cell.getContents());
								}else if(cellType == CellType.EMPTY){
									
								}else if(cellType == CellType.ERROR){
									
								}
							}
								
							
						}
						
					}
					if(row == 0) continue;
					if(!isRowEmpty && isMandatoryFieldsSatisfied){
						applicants.add(applicant);
					}else if(!isMandatoryFieldsSatisfied && !isRowEmpty){
						return null;
					}else if(isRowEmpty){
						break;
					}
				}
					
			}
			
		}catch(BiffException e){
			return null;
		}catch(IOException e){
			return null;
		}finally{
			
			
		}
		
		return (applicants.size() > 0) ? applicants : null;
	}
	
	/*
	 * This method fetches the definition of the XLS fields from
	 * web.xml 
	 * */
	boolean populateValuesFromServletContext(ArrayList<String> colName , ArrayList<String> colType ,
										  ArrayList<Boolean> isMandatory, ActionServlet servlet){
		
		int noOfXLSFields = Integer.parseInt(servlet.getServletContext().getInitParameter("XLS_NO_OF_COLS"));
		
		for(int i = 1 ; i <= noOfXLSFields ; i++){
			// field syntax defined in web.xml as COLUMN_NAME , COLUMN_TYPE , MANDATORY/OPTIONAL
			String field = servlet.getServletContext().getInitParameter("COL"+i);
			String[] colInfo = field.split(",");
			
			if(colInfo.length != 3)	// if incorrect field definition in web.xml
				return false;
			
			colName.add(colInfo[0].trim());
			colType.add(colInfo[1].trim());
			boolean temp = (colInfo[2].trim().equalsIgnoreCase("mandatory")) ? true :false; 
			isMandatory.add(temp);
				
			
		}
		
		return true;
		
	}
	
}
