package edu.utils.dao.test;

import java.util.Random;

import model.Applicant;
import model.Decision;

import org.hibernate.Session;


import dao.ApplicantDAO;
import dao.DecisionDAO;
import dao.HibernateUtil;
import edu.random.RandomString;
import edu.random.Randomx;
import edu.utils.FinalConstant;

public class GenerateDataInApplicantTable {
public static void main(String[] args) {
	Session session = null;
     
     int applicantId = 0;
	String nameLast = null;
	String nameFirst = null;
	String nameMiddle = null;
	String email = null;
	String permanentCountry = null;
	String gender = null;
	String citizenCountry = null;
	int greVerbalScore = 0;
	int greQuantitativeScore = 0;
	double greWritingScore = 0;
	int toeflScore = 0;
	double ieltsScore = 0;
	String degreeSought = null;
	String researchInterest = null;
	String statement = null;
	String referenceName1 = null;
	String referenceName2 = null;
	String referenceName3 = null;
	String ethnic = null;
	Applicant applicant = null;
	
	 int Gremax=147;
     int Gremin=80;
     Random random = new Random();
//     int incrementid =3;
	for (int incrementid = 1; incrementid < FinalConstant.totalNumberApplicants; incrementid++) {
		 session = HibernateUtil.getSessionFactory().getCurrentSession();
	     session.beginTransaction();
	applicantId = incrementid;
	nameLast =RandomString.randomString1(6);
	nameFirst =RandomString.randomString1(6);
	nameMiddle =RandomString.randomString1(5);
	email = RandomString.randomString1(6)+"@"+RandomString.randomString1(4)+"."+RandomString.randomString1(3);
	permanentCountry = getCitizenCountry(applicantId%7) ;
	gender = applicantId%3==0 ? "M":"F";
	citizenCountry = getCitizenCountry(applicantId%7) ;
	greVerbalScore = random.nextInt(Gremax)%(Gremax-Gremin+1) + Gremin;
	greQuantitativeScore = random.nextInt(Gremax)%(Gremax-Gremin+1) + Gremin;
	greWritingScore = getGreWritingScore(incrementid%5);
	toeflScore = Randomx.getRandom(80, 120);
	ieltsScore = getIeltsScore(incrementid%5);
	degreeSought = applicantId%7==0 ? "PHD":"MS";
	researchInterest = getReseachIn(incrementid%5);
	statement = RandomString.randomString1(50);
	referenceName1 = RandomString.randomString1(9);
	referenceName2 = RandomString.randomString1(9);
	referenceName3 = RandomString.randomString1(9);
	ethnic = "".equals(citizenCountry)?"":String.valueOf(Randomx.getRandom(1, 7));
	
	Decision decision = new DecisionDAO().getDecisionById((long)applicantId);
	
	applicant = new Applicant(applicantId, nameLast, nameFirst, nameMiddle, email, 
			permanentCountry, gender, citizenCountry, greVerbalScore, greQuantitativeScore,
			greWritingScore, toeflScore, ieltsScore, degreeSought, researchInterest,
			statement, referenceName1, referenceName2, referenceName3, ethnic );
     applicant.setDecision(decision);
//     ApplicantDAO applicantDAO = new ApplicantDAO();
//     applicantDAO.saveApplicant(applicant);
     session.save(applicant);
     session.getTransaction().commit();
	}     
     System.out.println("GenerateApplicantsTable.main()");
//     session.close();

}

/*
public static Decision getDecision(Long applicantId) {
//	 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//     session.beginTransaction();
     
     Decision decision = (Decision)session 
     		.createQuery("select d from Decision d where d.id = :did")
             .setParameter("did", applicantId)
             .uniqueResult();

//     session.getTransaction().commit();
//     session.close();
	return decision;
}
*/

private static double getGreWritingScore(int i) {
	double x = 3.0;
	switch (i) {
	case 0:
		x = 2.0;
		break;
	case 1:
		x = 2.5;
		break;
	case 2:
		x = 3.0;
		break;
	case 3:
		x = 4.5;
		break;
	default:
		break;
	}
	return x;
}

private static String getCitizenCountry(int i) {
	String xString = "";
	switch (i) {
	case 1:
		xString = "Brazil";
		break;
	case 2:
		xString = "Russia";
		break;
	case 3:
		xString = "Afghanestan";
		break;
	case 4:
		xString = "Shqiperia";
		break;
	case 5:
		xString = "Cuba";
		break;
	case 6:
		xString = "India";
		break;
	default:
		break;
	}
	
	return xString;
}

private static String getReseachIn(int i) {
	String x = "NETWORK";
	switch (i) {
	case 1:
		x = "SOFTWARE";
		break;
	case 2:
		x = "ROBOT";
		break;
	case 3:
		x = "FIBRE";
		break;
	case 4:
		x = "TEST";
		break;
	default:
		break;
	}
	return x;
}

private static double getIeltsScore(int i) {
	double x = 7.0;
	switch (i) {
	case 0:
		x = 5.0;
		break;
	case 1:
		x = 5.5;
		break;
	case 2:
		x = 6.0;
		break;
	case 3:
		x = 6.5;
		break;
	default:
		break;
	}
	return x;
}
}
