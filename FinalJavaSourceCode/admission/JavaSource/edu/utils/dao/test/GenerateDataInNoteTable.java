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

public class GenerateDataInNoteTable {
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
	 date= new Timestamp( System.currentTimeMillis() );
	decision = new Decision(applicantId, admit, date);
	
     session.save(decision);
     session.getTransaction().commit();
	}     
     System.out.println("GenerateApplicantsTable.main()");

//     session.close();
}

}
