package dao;

import model.User;

import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class HibernateDAO {


/**
 * get Current Session
 * @return Session
 */
	public Session getCurrentSession() {
		return HibernateUtil.getSessionFactory().getCurrentSession();
	}

	/**
	 * save Object
	 * @return void
	 */
	public void saveObject(Object obj) {
		getCurrentSession().save(obj);
	}

	/**
	 * update Object
	 * @return void
	 */
	public void updateObject(Object obj) {
		getCurrentSession().update(obj);
	}

	/**
	 * get Object
	 * @return List of result set
	 */
	public List getObjects(String hsql) {
		List result = getCurrentSession().createQuery(hsql).list();
		return result;
	}

	/**
	 * get Object
	 * @return single Object 
	 */
	public Object getObject(String hsql) {
		Object result = getCurrentSession().createQuery(hsql).uniqueResult();
		return result;
	}

	/**
	 * get Object
	 * @param cls : class name
	 * @param id : object id 
	 * @return single Object 
	 */
	public Object getObject(Class cls, Long id) {
		Object result = getCurrentSession().get(cls, id);
		return result;
	}

	/**
	 * delete Object
	 * @param obj : object 
	 * @return void  
	 */
	public void deleteObject(Object obj) {
		getCurrentSession().delete(obj);
	}

	/**
	 * delete Object
	 * @param obj : object 
	 * @return void  
	 */
	public int getTotalNumberRecords(String hsql) {
		return getCurrentSession().createQuery(hsql).list().size();
	}

	/**
	 * paging [N,N+M] M records per page
	 * 
	 * @param pageHql
	 *            dynamic hql
	 * @param firstResult
	 *            starting from 0
	 * @param MaxResults
	 *            M records per page
	 * @return LIST [N,N+M]
	 */
	public List cutPage(String pageHql, int firstResult, int MaxResults) {
		Query query = getCurrentSession().createQuery(pageHql);
		query.setFirstResult(firstResult);
		query.setMaxResults(MaxResults);
		return query.list();
	}

	/**
	 * total page number success
	 * 
	 * @param pageHql
	 *            dynamic hql
	 * @param MaxResults
	 * @return long total page number
	 */
	public long getCountPage(String pageHql, int MaxResults) {
		long count = 0;
		Query query = getCurrentSession().createQuery(pageHql);
		// System.out.println(query.iterate().next());
		count = (Long) query.iterate().next();
		// count = ((Integer)query.iterate().next()).intValue();
		double countPage = count / (MaxResults * 1.0);

		int countpage = (int) Math.ceil(countPage);
		System.out.println("There exists " + count + " records in total, "
				+ MaxResults + " records per page, " + countpage
				+ " pages in total");
		return countpage;

	}

	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		String hqlString = "select count(*) from User in class model.User";

		HibernateDAO hiDao = new HibernateDAO();
		long x = hiDao.getCountPage(hqlString, 4);
		System.out.println(x);
		String hql = "from User";
		List<User> list = hiDao.cutPage(hql, 0, 4);
		System.out.println(list.get(0).getUsername());
		System.out.println(list.get(1).getUsername());
		// System.out.println(list.get(2).getName());

		String hqlsString = "from User";
		int s = hiDao.getTotalNumberRecords(hqlsString);
		System.out.println(s);

		String hqlString1 = "select count(*) from StudentAccount in class model.StudentAccount";

		HibernateDAO hiDao1 = new HibernateDAO();
		long x1 = hiDao1.getCountPage(hqlString1, 4);
		System.out.println(x1);
		String hql1 = "from StudentAccount";
		List<User> list1 = hiDao1.cutPage(hql1, 0, 4);
		System.out.println(list.get(0).getUsername());
		System.out.println(list.get(1).getUsername());
		// System.out.println(list.get(2).getName());

		String hqlsString1 = "from StudentAccount";
		int s1 = hiDao.getTotalNumberRecords(hqlsString1);
		System.out.println(s1);
	}

}
