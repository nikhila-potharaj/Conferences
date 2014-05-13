/**
 * Class that communicates with the database to store/retrieve data.
 * 
 * @author Kirsten Grace
 * @version 5.12.14
 */

package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import model.AccessLevel;
import model.Conference;
import model.User;

public class ConferenceControl {

	private ConferenceControl() {
		// Do Nothing (stop trying to create me)
	}
	
	public static int createConference(Conference theConference) throws ClassNotFoundException {

		// WARNING: This code does not yet work so please don't try to use it.
		
		Class.forName("org.sqlite.JDBC");

		Connection connection = null;
		try {
			// create a database connection
			connection = DriverManager.getConnection("jdbc:sqlite:ConferenceDB.sqlite");
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);  // set timeout to 30 sec.

//			https://developer.salesforce.com/page/Secure_Coding_SQL_Injection
			PreparedStatement pstmt = connection.prepareStatement("INSERT INTO conferences "
					+ "(name, program_chair, description, accept_papers_start, accept_papers_end,"
					+ " conference_start, conference_end) VALUES (?, ?, ?, ?, ?, ?, ?)");
			pstmt.setString(1, theConference.getName());
			pstmt.setInt(2, theConference.getProgramChair().getId());  
			pstmt.setString(3, theConference.getDescription());
			pstmt.setDate(4, theConference.getPaperStart());
			pstmt.setDate(5, theConference.getPaperStart());
			pstmt.setDate(6, theConference.getConfStart());
			pstmt.setDate(7, theConference.getConfEnd());
			pstmt.executeQuery();

//			statement.executeUpdate("INSERT INTO conferences (name, email) VALUES (?, ?)");
//			statement.value(1, theName);
//			query.value(2, theEmail);

			ResultSet rs = statement.executeQuery("select last_insert_rowid()");
			return rs.getInt("select last_insert_rowid()");
			
		}
		catch(SQLException e)
		{
			// if the error message is "out of memory", 
			// it probably means no database file is found
			System.err.println(e.getMessage());
		}
		finally
		{
			try
			{
				if(connection != null)
					connection.close();
			}
			catch(SQLException e)
			{
				// connection close failed.
				System.err.println(e);
			}
		}

		return -1;
	}
	
	public static Boolean updateConference(Conference theConference){
		return false;
	}
	
	public static List<Conference> getConferences(){
		return null;
	}
	
	public static List<Conference> getConferences(User theUser){
		return null;
	}
	
	public static List<Conference> getConferences(User theUser, AccessLevel access){
		return null;
	}
	
	public static List<Conference> searchConferences(String searchString) {
		return null;
	}
	
	public static Map<Conference, AccessLevel> getAccessLevel(Conference theCon, User theUser){
		return null;
	}
	
	
	
	
}
