package edu.utils;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Locale;
import java.util.List;
import java.util.Set;
import java.sql.Timestamp;

import model.Applicant;
import model.CommitteeRating;
import jxl.CellType;
import jxl.CellView;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.UnderlineStyle;
import jxl.write.Formula;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import dao.ApplicantCommitteeRatingDAO;

public class ExportXLS {
	
	private WritableCellFormat timesBoldUnderline;
	private WritableCellFormat times;
	private String inputFile;
	
	public String exportXLS(String path){
		
		List joinResult = new ApplicantCommitteeRatingDAO().getCommitteeAndApplicantJoinResult();
		String fileName = System.currentTimeMillis() + ".xls";
		this.inputFile = path + "/" + fileName ;
		try{
			if (new ExportXLS().createXLSFromData(inputFile , joinResult)) return fileName;
		}catch(Exception exp){
			System.out.println("\n Error writing XLS file");
		}
		
		return null;
	}
	
	 private boolean createXLSFromData(String filePath , List xlsData) throws 
	 								   WriteException, RowsExceededException , IOException {
		 
		 /**
		  * Initialize the xlsFile , initialize work settings and workbook and sheets
		  */
		 File xlsFile = new File(filePath);
		 WorkbookSettings workbookSettings = new WorkbookSettings();
		 workbookSettings.setLocale(new Locale("en","EN"));
		 WritableWorkbook writableWorkbook = Workbook.createWorkbook(xlsFile,workbookSettings);
		 writableWorkbook.createSheet("Rates", 0);
		 WritableSheet xlsSheet = writableWorkbook.getSheet(0);
		 
		 createXLSHeader(xlsSheet); 		// The first row, The Join table headers
		 createContent(xlsSheet , xlsData);			// populates the table values
		 
		 writableWorkbook.write();			// commit to write
		 writableWorkbook.close();    		// close
		 
		 return true;
	
	 }
	
	  private void createXLSHeader(WritableSheet xlsSheet) throws WriteException{
		  
		  WritableFont times10pt = new WritableFont(WritableFont.TIMES, 10);   // TIMES font , 10px
		  times = new WritableCellFormat(times10pt);						   // Cell formatting
		  times.setWrap(false);												   // wrap cells
		  
		  // TIMES BOLD UNDERLINE FONT
		  WritableFont times10ptBoldUnderline = new WritableFont(WritableFont.TIMES, 10, WritableFont.BOLD, false,
				  											     UnderlineStyle.SINGLE);
		  timesBoldUnderline = new WritableCellFormat(times10ptBoldUnderline);
		  timesBoldUnderline.setWrap(false);
		  
		  CellView cellView = new CellView();
		  cellView.setFormat(times);
		  cellView.setFormat(timesBoldUnderline);
		  cellView.setAutosize(true);
		  
		  //Write headers 
		  addCaption(xlsSheet, 0,  0, "APPLICANT ID");	
		  
		  addCaption(xlsSheet, 1,  0, "LAST NAME");
		  addCaption(xlsSheet, 2,  0, "FIRST NAME ");
		  addCaption(xlsSheet, 3,  0, "MIDDLE NAME");
		  addCaption(xlsSheet, 4,  0, "EMAIL ID");
		  addCaption(xlsSheet, 5,  0, "COUNTRY");
		  addCaption(xlsSheet, 6,  0, "CITIZENSHIP");
		  addCaption(xlsSheet, 7,  0, "ETHNICITY");
		  addCaption(xlsSheet, 8,  0, "GENDER");
		  
		  addCaption(xlsSheet, 9,  0, "GRE VERBAL");
		  addCaption(xlsSheet, 10, 0, "GRE QUANT");
		  addCaption(xlsSheet, 11, 0, "GRE AWA");
		  addCaption(xlsSheet, 12, 0, "TOEFL");
		  addCaption(xlsSheet, 13, 0, "IELTS");
		  
		  addCaption(xlsSheet, 14, 0, "DEGREE SOUGHT");
		  addCaption(xlsSheet, 15, 0, "RESEARCH INTEREST");
		  addCaption(xlsSheet, 16, 0, "STATEMENT OF PURPOSE");
		  addCaption(xlsSheet, 17, 0, "REFEERNCE 1");
		  addCaption(xlsSheet, 18, 0, "REFEERNCE 2");
		  addCaption(xlsSheet, 19, 0, "REFEERNCE 3");
		  addCaption(xlsSheet, 20, 0, "TOTAL SCORE");
		  addCaption(xlsSheet, 21, 0, "COMMENTS");
		  addCaption(xlsSheet, 22, 0, "TA");
		  addCaption(xlsSheet, 23, 0, "FELLOWSHIP");
		  
		  
	  }
	  	
	  private void createContent(WritableSheet xlsSheet , List paramApplicants) throws
	  							 WriteException , RowsExceededException{
		  
		  //get the original list
		  
		  Iterator it = paramApplicants.iterator();
		  
		  int row = 0;
		  while(it.hasNext()){
			  ++row;
			  int col = 0;
			  Applicant applicant = (Applicant) it.next();
				  
			  addNumber(xlsSheet, col++, row, applicant.getApplicantId() );
			  
			  addLabel(xlsSheet, col++, row, applicant.getNameLast() );
			  addLabel(xlsSheet, col++, row, applicant.getNameFirst() );
			  addLabel(xlsSheet, col++, row, applicant.getNameMiddle() );
			  addLabel(xlsSheet, col++, row, applicant.getEmail());
			  addLabel(xlsSheet, col++, row, applicant.getPermanentCountry() );
			  addLabel(xlsSheet, col++, row, applicant.getCitizenCountry() );
			  addLabel(xlsSheet, col++, row, applicant.getEthnic() );
			  addLabel(xlsSheet, col++, row, applicant.getGender() );		  
			  addNumber(xlsSheet, col++, row, applicant.getGreVerbalScore());
			  addNumber(xlsSheet, col++, row, applicant.getGreQuantitativeScore() );
			  addNumber(xlsSheet, col++, row, applicant.getGreWritingScore() );
			  addNumber(xlsSheet, col++, row, applicant.getToeflScore() );
			  addNumber(xlsSheet, col++, row, applicant.getIeltsScore() );
			  
			  addLabel(xlsSheet, col++, row, applicant.getDegreeSought() );
			  addLabel(xlsSheet, col++, row, applicant.getResearchInterest() );
			  addLabel(xlsSheet, col++, row, applicant.getStatement() );
			  addLabel(xlsSheet, col++, row, applicant.getReferenceName1());
			  addLabel(xlsSheet, col++, row, applicant.getReferenceName2() );
			  addLabel(xlsSheet, col++, row, applicant.getReferenceName3() );
			  
			  
			  Set<CommitteeRating> committeeRatings =  applicant.getRating();
			  
			  Iterator<CommitteeRating> iterator = committeeRatings.iterator();
			  
			  if(!iterator.hasNext()) continue;
			  CommitteeRating committeeRating = iterator.next();
			  
			  addNumber(xlsSheet, col++, row, committeeRating.getTotalScore() );
			  addLabel(xlsSheet, col++, row, committeeRating.getComments());
			  addLabel(xlsSheet, col++, row, committeeRating.getTa());
			  addLabel(xlsSheet, col++, row, committeeRating.getFellowship());
		  }
		  
		  
		  
		  
	  }
	  
	  private void addCaption(WritableSheet sheet, int column, int row, String s)
			  				  throws RowsExceededException, WriteException {
		    Label label;
		    label = new Label(column, row, s, timesBoldUnderline);
		    sheet.addCell(label);
	  }
	  
	  private void addNumber(WritableSheet sheet, int column, int row,
		      				 double num) throws WriteException, RowsExceededException {
		    Number number;
		    number = new Number(column, row, num, times);
		    sheet.addCell(number);
	  }

	  private void addLabel(WritableSheet sheet, int column, int row, String s)
			  				throws WriteException, RowsExceededException {
		    Label label;
		    label = new Label(column, row, s, times);
		    sheet.addCell(label);
	 }
}
