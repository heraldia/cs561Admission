package dao;


import java.util.List;

import exception.DAOException;
import model.User;


public class UserDAO extends HibernateDAO{

	/**
	 * save user
	 * @param user : an user object
	 * @return void
	 */
	public void saveUser(User user)
	{
		if (user == null)
			return;

		User u = getUser(user.getUsername());
		if (u != null)
			throw new DAOException("a");

		saveObject(user);
	}

	/**
	 * get an user by username
	 * @return user
	 */
	public User getUser(String username)
	{
		User u = (User) getObject("from User u where u.username = '" + username
				+ "'");
		return u;
	}

	/**
	 * get an user by object id
	 * @return user
	 */
	public User getUserById(Long id)
	{
		return (User) getObject(User.class, id);
	}

	
    /**
     * this method will update user 
     * @param user the user entity
     */
    public void updateUser(User user) {
        updateObject(user);
    }
    
	
	/**
	 * get all users
	 * @return List of all users
	 */
	public List getUserByList()
	{
		return super.getObjects("from User");
	}
	
	/**
	 * get all users between pages
	 * @return List of all users
	 */
	public List getUserByListPage()
	{
		return super.cutPage("from User", 0 ,4);
	}
	
	
}
