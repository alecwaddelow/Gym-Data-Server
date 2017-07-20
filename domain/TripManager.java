package domain;

import java.sql.SQLException;
import java.util.ArrayList;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import data_source.TripTableDataGateway;

/** 
 *  
 * @author Alec Waddelow  
 * 
 * A class to manage CRUD operations for database within domain layer
 */ 
public class TripManager  
{ 
	protected ArrayList<TripDTO> entries;
	private TripTableDataGateway gateway = new TripTableDataGateway();
	
	/**
	 * Gets all rows from database
	 * 
	 * @return ArrayList<TripDTO> all rows
	 * @throws SQLServerException
	 * @throws SQLException
	 */
	public ArrayList<TripDTO> getAllEntries() throws SQLServerException, SQLException
	{
		entries = gateway.getAllRows();
		return entries;
	}
} 