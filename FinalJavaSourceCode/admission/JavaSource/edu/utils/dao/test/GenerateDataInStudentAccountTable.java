package edu.utils.dao.test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class GenerateDataInStudentAccountTable {

	public static void main(String[] args)  throws ClassNotFoundException,IOException {
		
		try {
           Class.forName("com.mysql.jdbc.Driver");
            
            String url = "jdbc:mysql://localhost/admission";
       
            Connection connection = DriverManager.getConnection(url,"root","12345");

        String qs1 = "INSERT INTO `StudentAccount` (`sid`, `username`, `password`, `email`, `firstname`, `lastname`) VALUES ('1', 'qwerty', 'a', 'qaz@iastate.edu', 'qwerty', 'fgjjlop');";


            Statement stmt = (Statement) connection.createStatement();
            stmt.executeUpdate(qs1);
            //System.out.println("Insertion is complete");

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



