/* done by Kim Ni Wang */

package dao;

import java.util.List;
import org.hibernate.Session;

public class CommitteeProgressDAO extends HibernateDAO {

	/*
	 * list the committee progress for MS applicants
	 * @return list of username and count the total number of MS for each committee member
	 */
	public List getCommitteeProgressMSTotal(){
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		String hql = "select u.username , count(a.degreeSought) "
				+ 	 "from DutyAssign d "
				+ 	 "right outer join  d.user u "
				+ 	 "left outer join d.applicant a with (a.degreeSought = 'MS') "
				+    "group by u.username "
				+ 	 "order by u.username asc" ; 
		return session.createQuery(hql).list();
	}

	/*
	 * list the committee progress for PhD applicants
	 * @return list of username and count the total number of PhD for each committee member
	 */
	public List getCommitteeProgressPHDTotal(){
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		String hql = "select u.username , count(a.degreeSought) "
				+ 	 "from DutyAssign d "
				+ 	 "right outer join  d.user u "
				+ 	 "left outer join d.applicant a with (a.degreeSought = 'PHD' ) "
				+    "group by u.username "
				+ 	 "order by u.username asc" ; 
		return session.createQuery(hql).list();
	}
	
	/*
	 * list the committee progress for MS applicants that are done with review
	 * @return list of username and count the total number of MS for each committee member
	 */
	public List getCommitteeProgressMSDone(){
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		String hql = "select u.username , count(a.degreeSought) "
				+ 	 "from DutyAssign d "
				+ 	 "right outer join  d.user u "
				+ 	 "left outer join d.applicant a "
				+	 "where d.done = 'Y' and a.degreeSought = 'MS' "
				+    "group by u.username "
				+ 	 "order by u.username asc" ; 
		return session.createQuery(hql).list();
	}
	
	/*
	 * list the committee progress for phd applicants that are done with review
	 * @return list of username and count the total number of phd for each committee member
	 */
	public List getCommitteeProgressPHDDone(){
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		String hql = "select u.username , count(a.degreeSought) "
				+ 	 "from DutyAssign d "
				+ 	 "right outer join  d.user u "
				+ 	 "left outer join d.applicant a "
				+	 "where d.done = 'Y' and a.degreeSought = 'PHD' "
				+    "group by u.username " 
				+ 	 "order by u.username asc" ; 
		return session.createQuery(hql).list();
	}
	
	/*
	 * retrieve all the committee members name from the database
	 * @return list of committee members name
	 */
	public List  getCommitteeMemberName(){
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		return (session.createQuery("select u.username , u.category from User u order by u.username asc")).list();
		
	}
}
