package edu.utils.dao.test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class GenerateDataInUserTable {

		public static void main(String[] args)  throws ClassNotFoundException,IOException {
		
			try {
	           Class.forName("com.mysql.jdbc.Driver");
	            
	            String url = "jdbc:mysql://localhost/admission";
	       
	            Connection connection = DriverManager.getConnection(url,"root","12345");

	        String qs1 = "INSERT INTO `user` (`uid`, `username`, `password`, `email`, `firstname`, `category`) VALUES ('1', 'pavan', 'a', 'pavan@iastate.edu', 'Pavan', '0');";
	        String qs2 = "INSERT INTO `user` (`uid`, `username`, `password`, `email`, `firstname`, `category`) VALUES ('2', 'jil', 'a', 'jil@iastate.edu', 'Jim', '0');";
	        String qs3 = "INSERT INTO `user` (`uid`, `username`, `password`, `email`, `firstname`, `category`) VALUES ('3', 'chaudhur', 'a', 'chaudhur@iastate.edu', 'Soma', '0');";
	        String qs4 = "INSERT INTO `user` (`uid`, `username`, `password`, `email`, `firstname`, `category`) VALUES ('4', 'tavanapo', 'a', 'tavanapo@iastate.edu', 'Wallapak', '0');";
	        String qs5 = "INSERT INTO `user` (`uid`, `username`, `password`, `email`, `firstname`, `category`) VALUES ('5', 'gsong', 'a', 'gsong@iastate.edu', 'Guang', '0');";
	        String qs6 = "INSERT INTO `user` (`uid`, `username`, `password`, `email`, `firstname`, `category`) VALUES ('6', 'jtian', 'a', 'jtian@iastate.edu', 'Jin', '0');";
	        String qs7 = "INSERT INTO `user` (`uid`, `username`, `password`, `email`, `firstname`, `category`) VALUES ('7', 'wzhang', 'a', 'wzhang@iastate.edu', 'Wensheng', '0');";
	        String qs8 = "INSERT INTO `user` (`uid`, `username`, `password`, `email`, `firstname`, `category`) VALUES ('8', 'yingcai', 'a', 'yingcai@iastate.edu', 'Ying', '1');";
	        String qs9 = "INSERT INTO `user` (`uid`, `username`, `password`, `email`, `firstname`, `category`) VALUES ('9', 'wong', 'a', 'wong@iastate.edu', 'Johnny', '2');";
	        String qs10 = "INSERT INTO `user` (`uid`, `username`, `password`, `email`, `firstname`, `category`) VALUES ('10', 'laurelt', 'a', 'laurelt@iastate.edu', 'Laurel', '3');";
	        String qs11 = "INSERT INTO `user` (`uid`, `username`, `password`, `email`, `firstname`, `category`) VALUES ('11', 'abigail2', 'a', 'abigail2@iastate.edu', 'Abigail', '3');";
	        String qs12 = "INSERT INTO `user` (`uid`, `username`, `password`, `email`, `firstname`, `category`) VALUES ('12', 'a', 'a', 'abigail2@iastate.edu', 'Abigail', '1');";

	            Statement stmt = (Statement) connection.createStatement();
	            stmt.executeUpdate(qs1);
	            stmt.executeUpdate(qs2);
	            stmt.executeUpdate(qs3);
	            stmt.executeUpdate(qs4);
	            stmt.executeUpdate(qs5);
	            stmt.executeUpdate(qs6);
	            stmt.executeUpdate(qs7);
	            stmt.executeUpdate(qs8);
	            stmt.executeUpdate(qs9);
	            stmt.executeUpdate(qs10);
	            stmt.executeUpdate(qs11);
	            stmt.executeUpdate(qs12);
	            System.out.println("Insertion is complete");

		    stmt.close();
		    connection.close();
			
		} catch (SQLException sqle){ 
				sqle.printStackTrace();
				
				while (sqle != null) {
					String logMessage = "\n SQL Error: "+
					  sqle.getMessage() + "\n\t\t"+
					  "Error code: "+sqle.getErrorCode() + 
	                                               "\n\t\t"+
					  "SQLState: "+sqle.getSQLState()+"\n";
			        System.out.println(logMessage);
			        sqle = sqle.getNextException();
				}
			}

		}
	}

