package dao;

import java.util.List;

import model.StudentAccount;
import exception.DAOException;

public class StudentAccountDAO extends HibernateDAO {

	public void saveStudentAccount(StudentAccount st) {
		if (st == null)
			return;

		StudentAccount acc = getStudentAccount(st.getUsername());
		if (acc != null)
			throw new DAOException("a");

		saveObject(st);
	}

	public StudentAccount getStudentAccount(String username) {
		StudentAccount acc = (StudentAccount) getObject("from StudentAccount u where u.username = '"
				+ username + "'");
		return acc;
	}

	public StudentAccount getStudentAccountById(Long id) {
		return (StudentAccount) getObject(StudentAccount.class, id);
	}

	/**
	 * this method will update user info
	 * 
	 * @param user
	 *            the user entity
	 */
	public void updateUser(StudentAccount st) {
		updateObject(st);
	}

	/**
	 * ps
	 * 
	 * @return success
	 */
	public List getStudentAccountByList() {
		return super.getObjects("from StudentAccount");
	}

	/*
	 * public List getUserByListPage() { return
	 * super.cutPage("from StudentAccount", 0 ,4); }
	 */

}
