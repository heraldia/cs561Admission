package model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

public class Applicant extends BaseModel {

	public Applicant(int applicantId, String nameLast, String nameFirst,
			String nameMiddle, String email, String permanentCountry,
			String gender, String citizenCountry, int greVerbalScore,
			int greQuantitativeScore, double greWritingScore, int toeflScore,
			double ieltsScore, String degreeSought, String researchInterest,
			String statement, String referenceName1, String referenceName2,
			String referenceName3, String ethnic) {
		super();
		this.applicantId = applicantId;
		this.nameLast = nameLast;
		this.nameFirst = nameFirst;
		this.nameMiddle = nameMiddle;
		this.email = email;
		this.permanentCountry = permanentCountry;
		this.gender = gender;
		this.citizenCountry = citizenCountry;
		this.greVerbalScore = greVerbalScore;
		this.greQuantitativeScore = greQuantitativeScore;
		this.greWritingScore = greWritingScore;
		this.toeflScore = toeflScore;
		this.ieltsScore = ieltsScore;
		this.degreeSought = degreeSought;
		this.researchInterest = researchInterest;
		this.statement = statement;
		this.referenceName1 = referenceName1;
		this.referenceName2 = referenceName2;
		this.referenceName3 = referenceName3;
		this.ethnic = ethnic;
		
		
		
//		this.decision=decision;
	}
	public Applicant() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * The Generated SerialVersionUID
	 */
	private static final long serialVersionUID = -4991231957346558770L;

	
	private		int 	applicantId;
	private		String	nameLast;
	private		String	nameFirst;
	private		String	nameMiddle;
	private		String	email;
	private		String	permanentCountry;
	private		String	gender;
	private		String	citizenCountry;
	private		int	    greVerbalScore;
	private		int	    greQuantitativeScore;
	private		double   greWritingScore;
	private		int	    toeflScore;
	private		double   ieltsScore;
	private		String  degreeSought;
	private		String  researchInterest;
	private		String  statement;
	private		String  referenceName1;
	private		String  referenceName2;
	private		String  referenceName3;
	private		String  ethnic;
    private     Set committeeRating;
    private     Note note;
    private     Decision decision;
    private 	StudentAccount studentaccount;
    private 	Set<CommitteeRating> rating;
    private 	Set<DutyAssign> dutyAssign;
    private		Set<User> user;
    
	

	public int getApplicantId() {
		return applicantId;
	}
	public void setApplicantId(int applicantId) {
		this.applicantId = applicantId;
	}
	public String getNameLast() {
		return nameLast;
	}
	public void setNameLast(String nameLast) {
		this.nameLast = nameLast;
	}
	public String getNameFirst() {
		return nameFirst;
	}
	public void setNameFirst(String nameFirst) {
		this.nameFirst = nameFirst;
	}
	public String getNameMiddle() {
		return nameMiddle;
	}
	public void setNameMiddle(String nameMiddle) {
		this.nameMiddle = nameMiddle;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPermanentCountry() {
		return permanentCountry;
	}
	public void setPermanentCountry(String permanentCountry) {
		this.permanentCountry = permanentCountry;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCitizenCountry() {
		return citizenCountry;
	}
	public void setCitizenCountry(String citizenCountry) {
		this.citizenCountry = citizenCountry;
	}
	public int getGreVerbalScore() {
		return greVerbalScore;
	}
	public void setGreVerbalScore(int greVerbalScore) {
		this.greVerbalScore = greVerbalScore;
	}
	public int getGreQuantitativeScore() {
		return greQuantitativeScore;
	}
	public void setGreQuantitativeScore(int greQuantitativeScore) {
		this.greQuantitativeScore = greQuantitativeScore;
	}
	public double getGreWritingScore() {
		return greWritingScore;
	}
	public void setGreWritingScore(double greWritingScore) {
		this.greWritingScore = greWritingScore;
	}
	public int getToeflScore() {
		return toeflScore;
	}
	public void setToeflScore(int toeflScore) {
		this.toeflScore = toeflScore;
	}
	public double getIeltsScore() {
		return ieltsScore;
	}
	public void setIeltsScore(double ieltsScore) {
		this.ieltsScore = ieltsScore;
	}
	public String getDegreeSought() {
		return degreeSought;
	}
	public void setDegreeSought(String degreeSought) {
		this.degreeSought = degreeSought;
	}
	public String getResearchInterest() {
		return researchInterest;
	}
	public void setResearchInterest(String researchInterest) {
		this.researchInterest = researchInterest;
	}
	public String getStatement() {
		return statement;
	}
	public void setStatement(String statement) {
		this.statement = statement;
	}
	public String getReferenceName1() {
		return referenceName1;
	}
	public void setReferenceName1(String referenceName1) {
		this.referenceName1 = referenceName1;
	}
	public String getReferenceName2() {
		return referenceName2;
	}
	public void setReferenceName2(String referenceName2) {
		this.referenceName2 = referenceName2;
	}
	public String getReferenceName3() {
		return referenceName3;
	}
	public void setReferenceName3(String referenceName3) {
		this.referenceName3 = referenceName3;
	}
	public String getEthnic() {
		return ethnic;
	}
	public void setEthnic(String ethnic) {
		this.ethnic = ethnic;
	}
	
	public Set getCommitteeRating() {
		return committeeRating;
	}
	public void setCommitteeRating(Set committeeRating) {
		this.committeeRating = committeeRating;
	}
	 
	public Note getNote() {
		return note;
	}
	public void setNote(Note note) {
		this.note = note;
	}
	public Decision getDecision() {
		return decision;
	}
	public void setDecision(Decision decision) {
		this.decision = decision;
	}
	public StudentAccount getStudentaccount() {
		return studentaccount;
	}
	public void setStudentaccount(StudentAccount studentaccount) {
		this.studentaccount = studentaccount;
	}

	public Set<DutyAssign> getDutyAssign() {
		return dutyAssign;
	}
	public void setDutyAssign(Set<DutyAssign> dutyAssign) {
		this.dutyAssign = dutyAssign;
	}
	public Set<CommitteeRating> getRating() {
		return rating;
	}
	public void setRating(Set<CommitteeRating> rating) {
		this.rating = rating;
	}
	public Set<User> getUser() {
		return user;
	}
	public void setUser(Set<User> user) {
		this.user = user;
	}
	
	
	

}
