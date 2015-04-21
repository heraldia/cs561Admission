

package actionform;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import model.Applicant;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.validator.ValidatorForm;

import dao.ApplicantDAO;
import exception.PasswordErrorException;


public class ApplicationForm extends ValidatorForm{
	
	private  int applicantId;
	private String firstname;
	private String lastname;
	private  String middlename;
	private  Date dob;
	private  String email;
	private  String gender;
	private  String country;
	private  String ethnic;
	private  String reference1;
	private  String reference2;
	private  String reference3;
	private  String research_interest;
	private  String stmt_purpose;
	private  String citizen_country;
	private  int gre_verbal;
	private  int gre_quantitative;
	private  double gre_analytical;
	private  double ielts;
	private  int toefl;
	private  String degree;
	
	
	
	public int getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(int applicantId) {
		this.applicantId = applicantId;
	}

	public  String getStmt_purpose() {
		return stmt_purpose;
	}

	public  void setStmt_purpose(String stmt_purpose) {
		this.stmt_purpose = stmt_purpose;
	}
	
	public  String getCitizen_country() {
		return citizen_country;
	}

	public  void setCitizen_country(String citizen_country) {
		this.citizen_country = citizen_country;
	}
	
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public  Date getDob() {
		return dob;
	}

	public  String getEmail() {
		return email;
	}

	public  void setEmail(String email) {
		this.email = email;
	}

	public  String getGender() {
		return gender;
	}

	public  void setGender(String gender) {
		this.gender = gender;
	}

	public  String getCountry() {
		return country;
	}

	public  void setCountry(String country) {
		this.country = country;
	}

	public  String getEthnic() {
		return ethnic;
	}

	public  void setEthnic(String ethnic) {
		this.ethnic = ethnic;
	}

	public  String getReference1() {
		return reference1;
	}

	public  void setReference1(String reference1) {
		this.reference1 = reference1;
	}

	public  String getReference2() {
		return reference2;
	}

	public  void setReference2(String reference2) {
		this.reference2 = reference2;
	}

	public  String getReference3() {
		return reference3;
	}

	public  void setReference3(String reference3) {
		this.reference3 = reference3;
	}

	public  String getResearch_interest() {
		return research_interest;
	}

	public  void setResearch_interest(String research_interest) {
		this.research_interest = research_interest;
	}

	
	public  int getGre_verbal() {
		return gre_verbal;
	}

	public  void setGre_verbal(int gre_verbal) {
		this.gre_verbal = gre_verbal;
	}

	public  int getGre_quantitative() {
		return gre_quantitative;
	}

	public  void setGre_quantitative(int gre_quantitative) {
		this.gre_quantitative = gre_quantitative;
	}

	public  double getGre_analytical() {
		return gre_analytical;
	}

	public  void setGre_analytical(double gre_analytical) {
		this.gre_analytical = gre_analytical;
	}

	public  double getIelts() {
		return ielts;
	}

	public  void setIelts(double ielts) {
		this.ielts = ielts;
	}

	public  int getToefl() {
		return toefl;
	}

	public  void setToefl(int toefl) {
		this.toefl = toefl;
	}

	public  String getDegree() {
		return degree;
	}

	public  void setDegree(String degree) {
		this.degree = degree;
	}
 
	
	@Override
	/*
	 * validates the fields in the application form
	 * @param mapping, request
	 * @return errors 
	 */

	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		
		System.out.println("inside form validation");
		
		
		ActionErrors errors = new ActionErrors();
		
		//Verifying mandatory form fields ,
		//1. Last Name check , First Name check , Email id Check , check for null or empty values
		
				
		if	(this.lastname == null  || this.lastname.trim().equals("")) {
			
			 errors.add("errorLastName", new ActionMessage("errors.required.LastName"));
		}
		if	(this.firstname == null || this.firstname.trim().equals("")){
			errors.add("errorFirstName", new ActionMessage("errors.required.FirstName"));
		}
		// TO DO : The verification of email id is very basic , user regular expression for advanced verification
		if	(this.email == null 	|| this.email.trim().equals("")){
			
			errors.add("errorEmail", new ActionMessage("errors.required.Email"));
		}
		
		if (this.gre_verbal < 0 || this.gre_verbal > 170){
			
			errors.add("errorGreVerbal" , new ActionMessage("errors.invalid.GreVerbal"));
		}
		
		if (this.gre_quantitative < 0 || this.gre_quantitative > 170){
			
			errors.add("errorGreQuant" , new ActionMessage("errors.invalid.GreQuant"));
		}
		
		if (this.gre_analytical < 0 || this.gre_analytical > 4){
			
			errors.add("errorGreVerbal" , new ActionMessage("errors.invalid.GreAnalytical"));
		}
		
		if (this.toefl < 0 || this.toefl > 120){
			
			errors.add("errorGreVerbal" , new ActionMessage("errors.invalid.Toefl"));
		}
		
		if (this.ielts < 0 || this.ielts > 9){
				
			errors.add("errorGreVerbal" , new ActionMessage("errors.invalid.Ielts"));
		}
		
		if(this.stmt_purpose.length() > 255){
			errors.add("errorGreVerbal" , new ActionMessage("errors.invalid.StatementOfPuposeLength"));
		}
		
		// check is the email id already exists
		ApplicantDAO dao = new ApplicantDAO();  
		boolean isEmailIdExists = dao.isEmailIdExists(this.getEmail());
	    if(isEmailIdExists){
	    	errors.add("errorGreVerbal" , new ActionMessage("error.application.exists"));
	    }
		
		return errors;	
			
	}
	
	
		
}
