package model;

import java.sql.Timestamp;


public class Decision extends BaseModel {

	public Decision(int applicantId, String admit, Timestamp date) {
		super();
		this.applicantId = applicantId;
		this.admit = admit;
		this.date = date;
	}
	public Decision(int applicantId, String admit) {
		super();
		this.applicantId = applicantId;
		this.admit = admit;
	}
	public Decision(){
	}
	/**
	 * The Generated SerialVersionUID
	 */
	private static final long serialVersionUID = -4991231957346558770L;

	
	private		int	applicantId;
	private		String	admit;
	private		Timestamp date;

	public int getApplicantId() {
		return applicantId;
	}
	public void setApplicantId(int applicantId) {
		this.applicantId = applicantId;
	}
	public String getAdmit() {
		return admit;
	}
	public void setAdmit(String admit) {
		this.admit = admit;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	
}
