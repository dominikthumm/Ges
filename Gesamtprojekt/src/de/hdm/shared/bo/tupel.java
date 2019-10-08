package de.hdm.shared.bo;

import java.io.Serializable;

public class tupel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	int id;
	String inhalt;
	String date;
	
	public tupel() {
		
	}
	
	public tupel (int id, String inhalt,String date) {
		this.id=id;
		this.inhalt=inhalt;
		this.date=date;
	}
	
	
	public int getId() {
		return id;
	}
	public String getInhalt() {
		return inhalt;
	}
	public void setInhalt(String inhalt) {
		this.inhalt = inhalt;
	}
	public String getDate() {
		return date;
	}
	
	

}
