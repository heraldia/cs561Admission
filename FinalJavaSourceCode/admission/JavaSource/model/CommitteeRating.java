package model;

import java.sql.Timestamp;
import java.util.Set;

public class CommitteeRating extends BaseModel {

	/**
	 * The Generated SerialVersionUID
	 */
	private static final long serialVersionUID = -4991231957346558770L;

	private		int  	committeeId;
	private 	int 	applicantId;
	private		int 	totalScore;
	private 	String	comments;
	private		String	ta;
	private		String	fellowship;
	private 	String	done;
	private		Timestamp date;
	
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
	public String getTa() {
		return ta;
	}
	public void setTa(String ta) {
		this.ta = ta;
	}
	public String getFellowship() {
		return fellowship;
	}
	public void setFellowship(String fellowship) {
		this.fellowship = fellowship;
	}
	/**
	 * @return the committeeId
	 */
	public int getCommitteeId() {
		return committeeId;
	}
	/**
	 * @param committeeId the committeeId to set
	 */
	public void setCommitteeId(int committeeId) {
		this.committeeId = committeeId;
	}
	/**
	 * @return the date
	 */
	public Timestamp getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Timestamp date) {
		this.date = date;
	}
	/**
	 * @return the done
	 */
	public String getDone() {
		return done;
	}
	/**
	 * @param done the done to set
	 */
	public void setDone(String done) {
		this.done = done;
	}
	
	public void setUnDone(){
		this.done = "N";
	}
	public void setDone(){
		this.done = "Y";
	}
	public int getApplicantId() {
		return applicantId;
	}
	public void setApplicantId(int applicantId) {
		this.applicantId = applicantId;
	}
	
	
	
}
