package model;

import java.sql.Timestamp;
import java.util.Set;

public class Note extends BaseModel {

	/**
	 * The Generated SerialVersionUID
	 */
	private static final long serialVersionUID = -4991231957346558770L;

	
	private		int     applicantId;
	private		String	note;
	private		Timestamp date;
	
	public int getApplicantId() {
		return applicantId;
	}
	public void setApplicantId(int applicantId) {
		this.applicantId = applicantId;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	
}
