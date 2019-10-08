package de.hdm.server;

import de.hdm.client.GreetingService;
import de.hdm.shared.FieldVerifier;
import de.hdm.shared.bo.tupel;
import de.hdm.server.db.TextMapper;

import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements GreetingService {
public String greetServer(String input) throws IllegalArgumentException {
		
		try {
			TextMapper.textMapper().insert(input);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<tupel> getAllData(){
		return TextMapper.textMapper().getAllData();		
	}

	/**
	 * Escape an html string. Escaping data received from the client helps to
	 * prevent cross-site script vulnerabilities.
	 * 
	 * @param html the html string to escape
	 * @return the escaped string
	 */
}
