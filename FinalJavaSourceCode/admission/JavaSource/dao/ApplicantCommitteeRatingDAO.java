package dao;

import java.util.List;

public class ApplicantCommitteeRatingDAO extends HibernateDAO {

	/**
	 * get a list of results from applicants by Joining Committee members And Applicants
	 * @return List applicants 
	 */
	public List getCommitteeAndApplicantJoinResult(){
		
		String hql = "from Applicant a left join fetch a.rating r";
		
		return super.getObjects(hql);
		
	}
	
	
}
