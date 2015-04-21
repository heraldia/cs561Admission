package edu.utils.dao.test;


import java.util.List;

import org.hibernate.Session;

import model.Applicant;
import model.User;

import dao.ApplicantDAO;
import dao.HibernateUtil;
import dao.UserDAO;



public class ReportTest {
public static void main(String[] args) throws Exception {
//	System.out.println(new ReportDAOImpl().totalNumberApplicant());
//	System.out.println(new ReportDAOImpl().numberUsCitizen());
//	System.out.println(new ReportDAOImpl().numberWomen());
//	System.out.println(new ReportDAOImpl().averageVerbalNew());
//	System.out.println(new ReportDAOImpl().averageVerbalOld());
//	System.out.println(new ReportDAOImpl().averageVerbal());
	
//	System.out.println(new ReportDAOImpl().averageQuant());
//	System.out.println(new ReportDAOImpl().distributionScore().get(0));
//	System.out.println(new ReportDAOImpl().numberPhdms("PHD"));
//	System.out.println(new ReportDAOImpl().numberPhdms("MS"));
	
//	System.out.println("1 "+ new ReportDAOImpl().distributionScore().get(1));
//	System.out.println("2 "+ new ReportDAOImpl().distributionScore().get(2));
//	System.out.println("3 "+ new ReportDAOImpl().distributionScore().get(3));
//	System.out.println("4 "+ new ReportDAOImpl().distributionScore().get(4));
//	System.out.println("5 "+ new ReportDAOImpl().distributionScore().get(5));
//	System.out.println("6 "+ new ReportDAOImpl().distributionScore().get(6));
//	System.out.println("7 "+ new ReportDAOImpl().distributionScore().get(7));
//	System.out.println("8 "+ new ReportDAOImpl().distributionScore().get(8));
//	System.out.println("9 "+ new ReportDAOImpl().distributionScore().get(9));
//	System.out.println("0 "+ new ReportDAOImpl().distributionScore().get(0));
//	System.out.println(new DAOFactory().getRateDAOInstance().queryAllDone());
	
	/*
	  String aString = null;
	
	String bString = null;
	String cString = null;
	String iString =null;
	int i = 0;
	if (aString == null)
	{
		i=0;
	}	
	if (bString == null)
	{
		i=1;
	}	
	if (cString == null)
	{
		i=2;
	}	
	System.out.println(String.valueOf(i));
	 */
/*	List<Applicant> all = DAOFactory.getApplicantDAOInstance().queryAll();
	System.out.println(all.get(1).getName_first());*/
	/*
	model.Applicant applicant = new model.Applicant();
    ApplicantDAO dao = new ApplicantDAO();
    dao.getApplicant("");
    */
	
	 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
     session.beginTransaction();
     /*
	UserDAO dao = new UserDAO();
	User user = dao.getUserById("9");
	System.out.println(user.getEmail());
	*/
     ApplicantDAO aDao = new ApplicantDAO();
//     List<Applicant> aList = aDao.getPhdApplicants();
     List<Applicant> aList = aDao.getMsApplicants();
     for (int i = 1; i < 100; i++) {
    	 System.out.println(aList.get(i).getDegreeSought());
	}
	session.close();
}
}
