package model;

import org.apache.lucene.search.TotalHitCountCollector;

public class CommitteeProgress extends BaseModel{

	private int totalNoOfReviewsNeeded;
	private int totalNoOfReviewsCompleted;
	private String committeeMemberName ;
	private String username;

	private int totalNoOfMastersStudentsAllotted;
	private int totalNoOfPHDStudentsAllotted;
	private int totalNoOfMastersStudentCompleted;
	private int totalNoOfPHDStudentCompleted;
	
	
	
	public CommitteeProgress(int totalNoOfReviewsNeeded ,int  totalNoOfReviewsCompleted , String committeeMember , 
							 int totalNoOfMastersStudentsAllotted , int  totalNoOfPHDStudentsAllotted , 
							 int totalNoOfMastersStudentCompleted , int totalNoOfPHDStudentCompleted){
		this.totalNoOfReviewsNeeded = totalNoOfReviewsNeeded;
		this.totalNoOfReviewsCompleted = totalNoOfReviewsCompleted;
		this.committeeMemberName = committeeMember;
		this.totalNoOfMastersStudentsAllotted = totalNoOfMastersStudentsAllotted;
		this.totalNoOfPHDStudentsAllotted = totalNoOfPHDStudentsAllotted;
		this.totalNoOfMastersStudentCompleted = totalNoOfMastersStudentCompleted;
		this.totalNoOfPHDStudentCompleted = totalNoOfPHDStudentCompleted;
	}
	
	public CommitteeProgress(){
	
	}
	
	public int getTotalNoOfReviewsNeeded() {
		return totalNoOfReviewsNeeded;
	}
	public void setTotalNoOfReviewsNeeded(int totalNoOfReviewsNeeded) {
		this.totalNoOfReviewsNeeded = totalNoOfReviewsNeeded;
	}
	public int getTotalNoOfReviewsCompleted() {
		return totalNoOfReviewsCompleted;
	}
	public void setTotalNoOfReviewsCompleted(int totalNoOfReviewsCompleted) {
		this.totalNoOfReviewsCompleted = totalNoOfReviewsCompleted;
	}
	public String getCommitteeMemberName() {
		return committeeMemberName;
	}
	public void setCommitteeMemberName(String committeeMemberName) {
		this.committeeMemberName = committeeMemberName;
	}
	public int getTotalNoOfMastersStudentsAllotted() {
		return totalNoOfMastersStudentsAllotted;
	}
	public void setTotalNoOfMastersStudentsAllotted(
			int totalNoOfMastersStudentsAllotted) {
		this.totalNoOfMastersStudentsAllotted = totalNoOfMastersStudentsAllotted;
	}
	public int getTotalNoOfPHDStudentsAllotted() {
		return totalNoOfPHDStudentsAllotted;
	}
	public void setTotalNoOfPHDStudentsAllotted(int totalNoOfPHDStudentsAllotted) {
		this.totalNoOfPHDStudentsAllotted = totalNoOfPHDStudentsAllotted;
	}
	public int getTotalNoOfMastersStudentCompleted() {
		return totalNoOfMastersStudentCompleted;
	}
	public void setTotalNoOfMastersStudentCompleted(
			int totalNoOfMastersStudentCompleted) {
		this.totalNoOfMastersStudentCompleted = totalNoOfMastersStudentCompleted;
	}
	public int getTotalNoOfPHDStudentCompleted() {
		return totalNoOfPHDStudentCompleted;
	}
	public void setTotalNoOfPHDStudentCompleted(int totalNoOfPHDStudentCompleted) {
		this.totalNoOfPHDStudentCompleted = totalNoOfPHDStudentCompleted;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
