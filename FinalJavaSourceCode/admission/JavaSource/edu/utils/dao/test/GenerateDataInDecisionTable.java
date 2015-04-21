package edu.utils.dao.test;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import model.Applicant;
import model.Decision;

import org.hibernate.Session;


import dao.ApplicantDAO;
import dao.HibernateUtil;
import edu.random.RandomString;
import edu.random.Randomx;
import edu.utils.FinalConstant;

public class GenerateDataInDecisionTable {
public static void main(String[] args) {
	Session session = null;
     
     int applicantId = 0;
     Random random = new Random();
	Decision decision = null;
	String admit = null;
	Timestamp date= null;
	
	for (int incrementid = 1; incrementid < FinalConstant.totalNumberApplicants; incrementid++) {
		 session = HibernateUtil.getSessionFactory().getCurrentSession();
	     session.beginTransaction();
	applicantId = incrementid;
	 admit = getAdmit(incrementid%3);
	 date= new Timestamp( System.currentTimeMillis() );
	decision = new Decision(applicantId, admit, date);
	
     session.save(decision);
     session.getTransaction().commit();
	}     
     System.out.println("GenerateApplicantsTable.main()");

//     session.close();
}

private static String getAdmit(int i ) {
	String xString = null;
	switch (i) {
	case 0:
		xString ="ADMIT";
		break;
	case 1:
		xString ="DENY";
		break;
	default:
//		xString ="DENY";
		break;
	}
	return xString;
}

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

public static synchronized String getDateYYYYMMDD(Date date) {
    DateFormat yyyyMMddFormat = new SimpleDateFormat("yyyy-MM-dd");
    return yyyyMMddFormat.format(date);
}
}
