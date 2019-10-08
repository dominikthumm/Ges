package de.hdm.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import de.hdm.server.db.DBConnection;
import de.hdm.server.db.TextMapper;
import de.hdm.shared.bo.tupel;

public class TextMapper {

	protected TextMapper() {		
	}
	
	private static TextMapper textMapper;

	
	  public static TextMapper textMapper() {
		    if (textMapper == null) {
		    	textMapper = new TextMapper();
		    }

		    return textMapper;
		  }
	    
	
	
	

	public void insert(String l) throws SQLException {  // Inhalte einfügen in die Datenbank
		
		Connection con = DBConnection.getConnection();
		
		Statement stm = con.createStatement();
		
		stm.executeUpdate("INSERT INTO Inhaltsspalte (Inhalt) VALUES ('" + l + "')");	
	
	}
	
	public void delete (String s) throws SQLException{  // Inhalte aus der Dazenbank löschen
		
		Connection con = DBConnection.getConnection();
		
		Statement stm = con.createStatement();
		
		stm.executeUpdate("DELETE FROM Inhaltsspalte;" );
	}
	
	
	public ArrayList<tupel> getAllData(){  // Inhalte ausgeben aus der Datenbank
		ArrayList<tupel> liste = new ArrayList<tupel>();
		
		Connection con = DBConnection.getConnection();
		
		Statement stm;
		try {
			stm = con.createStatement();
			
			ResultSet rs = stm.executeQuery("SELECT * FROM Inhaltsspalte;");
			
			
			
			while(rs.next()) {
				liste.add(new tupel(rs.getInt("idtable1"), rs.getString("inhalt"), rs.getString("timestamp")));
			}
			
			return liste;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
	}
}

