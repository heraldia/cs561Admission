package edu.utils.dao.test;

import java.io.IOException;
import java.util.List;

import model.Applicant;
import model.Decision;

import org.hibernate.Session;

import dao.ApplicantDAO;
import dao.HibernateDAO;
import dao.HibernateUtil;

public class DaoTest {
	public static void getApplicantsTest() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		HibernateDAO hiDao = new HibernateDAO();
		ApplicantDAO applicantDAO = new ApplicantDAO();
		List<Applicant> list = applicantDAO.getApplicants();
		for (Applicant applicant : list) {
			String xsString = applicant.getEmail();
			System.out.println(xsString);
		}
		session.close();
	}
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		GenerateDataInApplicantTable.main(null);
		GenerateDataInDecisionTable.main(null);
//		getApplicantsTest();
//		GenerateDataInStudentAccountTable.main(null);
		GenerateDataInUserTable.main(null);
		
	}
}
