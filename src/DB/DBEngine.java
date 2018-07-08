/**
 * Author: David Rivera
 * Course: CNT 4714 – Fall 2012
 * Assignment title: Program 3 – Java JDBC
 * Date: October 21, 2012
 */
package DB;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.MySQLConnection;

/**
 * Sets up connection to database.
 * 
 * @author david
 *
 */
public class DBEngine {
	private String URL;
	private String User;
	private String Password;
	private MySQLConnection Connection;

	/**
	 * Constructor to set the URL, Username, and Password for the DB.
	 * 
	 * @param URL
	 * @param Username
	 * @param Password
	 */
	public DBEngine(String URL, String Username, String Password) {
		this.URL = URL;
		this.User = Username;
		this.Password = Password;
	}

	/**
	 * Establishes the database connection.
	 * 
	 * @throws SQLException
	 */
	public void EstablishConnection() throws SQLException {
		Connection = (MySQLConnection) DriverManager.getConnection(this.URL, this.User, this.Password);
	}

	/**
	 * Closes the database connection.
	 * 
	 * @throws SQLException
	 */
	public void CloseConnection() throws SQLException {
		Connection.close();
	}

	/**
	 * Retrieves the current connection.
	 * 
	 * @return
	 */
	public MySQLConnection getConnection() {
		return this.Connection;
	}

}
