package dao;


import java.util.List;

import exception.DAOException;
import model.Decision;


public class DecisionDAO extends HibernateDAO{

	/**
	 * save an decisnion
	 * @return void
	 */
	public void saveDecision(Decision decision)
	{
		if (decision == null)
			return;

//		Decision u = getDecision(decision.getAdmit());
//		 if (u == null)
//			throw new DAOException("Decision should not be empty!");

		saveObject(decision);
	}

	/**
	 * get an applicant by decisnion
	 * @return an Decision
	 */
	public Decision getDecision(String decision)
	{
		Decision u = (Decision) getObject("from Decision u where u.admit = '" + decision
				+ "'");
		return u;
	}

	/**
	 * get an applicant (id)'s decision by object id
	 * @return an Decision
	 */
	public Decision getDecisionByApplicantId(int applicantId)
	{
		Decision u = (Decision) getObject("from Decision u where u.applicantId = '" + applicantId
				+ "'");
		return u;
	}

	/**
	 * get an decision by object id
	 * @return an Decision
	 */
	public Decision getDecisionById(Long id)
	{
		return (Decision) getObject(Decision.class, id);
	}

	
    /**
     * this method will update decision info
     * @param decision the decision entity
     */
    public void updateDecision(Decision decision) {
        updateObject(decision);
    }
    
	
	/**
	 * get all decisions
	 * @return List of all Decisions
	 */
	public List getDecisionByList()
	{
		return super.getObjects("from Decision");
	}
	
}
