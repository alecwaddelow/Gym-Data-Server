package data_source; 

import java.sql.Connection; 
import java.sql.SQLException; 
import com.microsoft.sqlserver.jdbc.SQLServerDataSource; 
import com.microsoft.sqlserver.jdbc.SQLServerException; 

/** 
 * @author Drew rife and Alec Waddelow 
 * 
 * Handles the establishing of a connection, passing the connection and closing it 
 * 
 */ 
public class DBConnection 
{ 
	private Connection connection; 
	public SQLServerDataSource ds = new SQLServerDataSource(); 

	/** 
	 * Sets basic connection information to the database upon object creation
	 */ 
	public DBConnection() 
	{ 
		try { 
			// Establish the connection.  
			ds.setIntegratedSecurity(false); 
			ds.setServerName("waddelow.database.windows.net"); 
			ds.setPortNumber(1433);  
			ds.setDatabaseName("Gym_Data"); 
		} 
		// Handle any errors that may have occurred. 
		catch (Exception e) { 
			e.printStackTrace(); 
		}   
	} 
	
	/**
	 * Sets credentials to be able to create a connection
	 * 
	 * @param username
	 * @param password
	 */
	public void createConnection(String username, String password)
	{
		ds.setUser(username);
		ds.setPassword(password);
	}

	/** 
	 * Attempts to make the connection to the database 
	 *  
	 * @return the connection 
	 * @throws SQLServerException  
	 */ 
	public Connection getConnection() throws SQLServerException  
	{ 
		connection = ds.getConnection(); 
		return this.connection; 
	} 

	/** 
	 * Makes sure entered credentials are correct 
	 *  
	 * @return true or false 
	 * @throws SQLServerException 
	 */ 
	public boolean authenticate() throws SQLServerException 
	{ 
		connection = ds.getConnection(); 
		if(connection == null) 
		{ 
			return false; 
		} 
		else 
		{ 
			return true; 
		} 
	} 

	/** 
	 * @return closes the connection 
	 */ 
	public void close()  
	{ 
		try { 
			this.connection.close(); 
		} catch (SQLException e) { 
			e.printStackTrace(); 
		} 
	} 
} 
