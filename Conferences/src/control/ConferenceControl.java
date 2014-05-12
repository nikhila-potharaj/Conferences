/**
 * Class that communicates with the database to store/retrieve data.
 * 
 * @author Kirsten Grace
 * @version 5.12.14
 */

package control;

import java.util.List;
import java.util.Map;

import model.AccessLevel;
import model.Conference;
import model.User;

public class ConferenceControl {

	private ConferenceControl() {
		// Do Nothing (stop trying to create me)
	}
	
	public static Boolean updateConference(Conference theConference){
		return false;
	}
	
	public static int createConference(Conference theConference){
		return 0;
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
