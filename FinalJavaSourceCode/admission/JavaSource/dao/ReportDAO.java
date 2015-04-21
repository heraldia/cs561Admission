package dao;

import model.Applicant;

import org.hibernate.Session;

import java.util.List;

public class ReportDAO extends HibernateDAO {
	
	
	public long getNumOfApplicants(){
		return (Long)getObject("select count(*) from Applicant");	
	}
	
	public List getAllApplicants(){
		return getObjects("from Applicant");	
	}
	
	
	public long getNumOfUSCitizen(){
		return (Long) getObject("select count(*) from Applicant as a where a.citizenCountry = 'US' or a.citizenCountry = 'United States' or a.citizenCountry = 'United States of America' or  a.citizenCountry = 'USA'");
	}
	
	public List getAllUSCitizen(){
		return  getObjects("from Applicant as a where a.citizenCountry = 'US' or a.citizenCountry = 'United States' or a.citizenCountry = 'United States of America' or  a.citizenCountry = 'USA'");
	}
	
	
	public long getNumOfMinorCitizens(){
		return (Long) getObject("select count(*) from Applicant as a where a.citizenCountry <> 'US' and a.citizenCountry <> 'United States' and a.citizenCountry <> 'United States of America' and a.citizenCountry <> 'USA'");
	}
	
	public List getAllMinorCitizens(){
		return  getObjects("from Applicant as a where a.citizenCountry <> 'US' and a.citizenCountry <> 'United States' and a.citizenCountry <> 'United States of America' and a.citizenCountry <> 'USA'");
	}
	
	
	public long getNumOfWomen(){
		return (Long) getObject("select count(*) from Applicant as a where a.gender = 'F' or a.gender = 'female'" );
	}
	public List getAllOfWomen(){
		return getObjects("from Applicant as a where a.gender = 'F' or a.gender = 'female'" );
	}
	
	
	public double getAvgGreVerbalScore(){
		return (Double) getObject("select  avg(a.greVerbalScore) from Applicant as a " );
	}
	
	
	public double getAvgGreQuantScore(){
		return (Double) getObject("select avg(a.greQuantitativeScore) from Applicant as a " );
	}
	
	
	public List getRangeEvalScores(){
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		return session.createQuery("select concat(10*floor(avg(c.totalScore)/10), '-', 10*floor(avg(c.totalScore)/10) + 9) as range,     count(*) as numberOfApplicants from CommitteeRating as c group by c.applicantId order by avg(c.totalScore) ").list();
		
	}
}
