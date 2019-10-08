package de.hdm.server.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBConnection {


	/*
	 * Die Klasse DBConnection wird nur einmal instanziiert. Wegen der Singleton Eigenschaft
	 * Die Variable ist durch static nur einmal für sämtliche Instanzen vorhanden.
	 */

	private static Connection con = null;
	
	
//	private static String localUrl = "jdbc:mysql://localhost:3306/jakob2?user=root&password=password";
	private static String localUrl = "jdbc:mysql://localhost:3306/jakob2?user=root&password=password&useUnicode=true&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static String googleUrl = "";
	
//	private static String localUrl = "jdbc:mysql://localhost/ITProjekt?user=root&password=password&useUnicode=true&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	
	
	
	
	/*
	 * 
	 * Stellt die Verbindung zur Datenbank her.
	 * 
	 * @return con
	 * 
	 * Fazit: DBConnection sollte nicht mittels <code>new</code>
     * instantiiert werden, sondern stets durch Aufruf dieser statischen
     * Methode.
	 */

	
	public static Connection getConnection() {
		
		/*
		 * Herstellung einer DB Verbindung, wenn bisher keine Verbindung besteht
		 */

		if (con == null) {
			try {
				
				/*
				 * Neue Instanz mysl Konnektor (JDBC). Bisher nur localUrl, später durch googleUrl ersetzt.
				 */

				Class.forName("com.mysql.cj.jdbc.Driver"); // ladet den JDBC Driver Connector für mysql
				con = DriverManager.getConnection(localUrl);
				
				/*
				 * Die Verbindung zur Datenbank wird in der Variablen con mit
				 * den dazugehoerigen Informationen gespeichert
				 */
				 
				Statement s = con.createStatement();
				System.out.println("DB Connection!");
				
				/*
				 * Veranschaulichung ob die Datenbankverbindung zu stande gekommen ist
				 */

			} catch (Exception e) {
				con = null;
				// TODO: handle exception
				e.printStackTrace(); // throw new RuntimeException() nötig?
			}
			
			/*
			 * Verfolgt beim Debuggen den Fehler bis zum Ursprung
			 */

		}

		return con;
	}

}



