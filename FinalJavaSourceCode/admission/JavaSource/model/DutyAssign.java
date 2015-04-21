package model;

import java.sql.Timestamp;
import java.util.Set;

public class DutyAssign extends BaseModel {

	/**
	 * The Generated SerialVersionUID
	 */
	private static final long serialVersionUID = -4991231957346558770L;

	private		int	    applicantId;
	private		int  	committee;
	private 	String	done;
	private		Timestamp date;
	private 	User 	user;
	private 	Applicant applicant;
	
	
	public int getApplicantId() {
		return applicantId;
	}
	public void setApplicantId(int applicantId) {
		this.applicantId = applicantId;
	}
	public int getCommittee() {
		return committee;
	}
	public void setCommittee(int committee) {
		this.committee = committee;
	}
	public String getDone() {
		return done;
	}
	public void setDone(String done) {
		this.done = done;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Applicant getApplicant() {
		return applicant;
	}
	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}
	
	
	
}
