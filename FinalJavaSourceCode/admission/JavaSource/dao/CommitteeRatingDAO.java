package dao;

import exception.DAOException;
import model.Applicant;
import model.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import paginate.PageModel;

public class CommitteeRatingDAO extends HibernateDAO {


	/**
	 * save applicant
	 * @return void
	 */
	public void saveApplicant(Applicant applicant)
	{
		super.saveObject(applicant);
	}

	/**ps
	 * @param applicant
	 */
	/*
	public void saveApplicant(Applicant applicant)
	{
		if (applicant == null)
			return;

		Applicant applicant2 = getApplicant(String.valueOf(applicant.getApplicantId()));
		if (applicant2 != null)
			throw new DAOException("Duplicated applicants");

		super.saveObject(applicant);
	}
*/
	public List getApplicants()
	{
		String hsql = "from Applicant";
		return super.getObjects(hsql);
	}

/*
	public void deleteApplicant(String id, String userId)
	{
		User user = (User)getObject( User.class, userId );
		if( user==null ) {
			throw new DAOException( "Couldn't user!" );
		}
		
		Applicant m = null;
		
		Iterator it = user.getApplicant().iterator();
		while( it.hasNext() ) {
			Applicant applicant = (Applicant)it.next();
			if( applicant.getId().equals( id ) ) {
				m = applicant;
			}
		}
		if( m!=null ) {
			deleteObject( m );
			user.getApplicants().remove( m );
		}
	}
*/

	/**
	 * get all applicants by Object id
	 * @return an applicant
	 */
	public Applicant getApplicant(Long id)
	{
		return (Applicant) getObject(Applicant.class, id);
	}

	/**
	 * update an applicant by Object 
	 * @return void
	 */
	public void updateApplicant(Applicant applicant)
	{
		updateObject(applicant);
	}

/*
	public void deleteReplyApplicant(String id, String userId) {
		ReplyApplicant reply = (ReplyApplicant)getObject( ReplyApplicant.class, id );
		if( reply==null ) {
			throw new DAOException("reply==null");
		}
		
		Applicant applicant = reply.getApplicant();
		Iterator it = applicant.getReplies().iterator();
		while( it.hasNext() ) {
			ReplyApplicant r = (ReplyApplicant)it.next();
			if( r.getId().equals( id ) ) {
				applicant.getReplies().remove( r );
			}
		}
	}
*/
  /* public PageModel findAllApplicant(String queryString, int pageNo, int pageSize){
		List applicantList = new ArrayList();
		if (queryString != null && !"".equals(queryString)) {
			applicantList = getHibernateTemplate().executeFind(new HibernateCallback(){

				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					return session.createQuery("from Applicant i where i.applicantNo like ? or i.applicantName like ? order by i.applicantNo")
								.setParameter(0, "%" + queryString + "%")
								.setParameter(1, "%" + queryString + "%")
								.setFirstResult((pageNo-1) * pageSize)
								.setMaxResults(pageSize)
								.list();
				}
			});
			
		}else {
			applicantList = getHibernateTemplate().executeFind(new HibernateCallback(){

				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					return session.createQuery("from Applicant i join fetch i.applicantCategory join fetch i.applicantUnit order by i.applicantNo")
								.setFirstResult((pageNo-1) * pageSize)
								.setMaxResults(pageSize)
								.list();
				}
			});
		}
		PageModel pageModel = new PageModel();
		pageModel.setPageNo(pageNo);
		pageModel.setPageSize(pageSize);
		pageModel.setList(applicantList);
		pageModel.setTotalRecords(getTotalRecords(queryString));
		return pageModel;
	}*/
   
	/**
	 * return the number of records
	 * @param conn
	 * @param queryStr
	 * @return
	 */
	/*public int getTotalRecords(String queryString){

		int count = 0;
		if (queryString != null && !"".equals(queryString)) {
			count = ((Long)getSession().createQuery("select count(*) from Item i where i.itemNo like ? or i.itemName like ?")
							.setParameter(0,  "%" + queryString + "%")
							.setParameter(1,  "%" + queryString + "%")
							.uniqueResult()).intValue();
		}else {
			count = ((Long)getSession().createQuery("select count(*) from Item i")
					.uniqueResult()).intValue();
		}
		return count;
	}*/
}
