package actionform;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;



public class CMEvalApplicantForm extends ActionForm {

	private int aid;
	private int totalScore=0;
	private String comments = null;
	private String ta = null;
	private String fe = null;
			
	
	
	public int getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getTa() {
		return ta;
	}
	public void setTa(String ta) {
		this.ta = ta;
	}
	public String getFe() {
		return fe;
	}
	public void setFe(String fe) {
		this.fe = fe;
	}
	
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ActionErrors errors = new ActionErrors(); 
		if(this.totalScore == 0 )
			errors.add("totalScore", new ActionMessage("error.score.empty","Score"));
		if(this.totalScore > 50 )
			errors.add("totalScore", new ActionMessage("error.score.invalid","Score"));
		return errors;
	}
	
	
	
	
}
