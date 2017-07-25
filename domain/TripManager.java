package domain;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import data_source.TripRowDataGateway;
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
	private TripTableDataGateway tableGateway = new TripTableDataGateway();
	private TripRowDataGateway rowGateway;
	
	/**
	 * Gets all rows from database
	 * 
	 * @return ArrayList<TripDTO> all rows
	 * @throws SQLServerException
	 * @throws SQLException
	 */
	public ArrayList<TripDTO> getAllEntries() throws SQLServerException, SQLException
	{
		entries = tableGateway.getAllRows();
		return entries;
	}
	
	/**
	 * Adds a new row to the table 
	 * 
	 * @param date
	 * @param lengthOfTrip
	 * @param lengthOfCardio
	 * @param lengthOfLifting
	 * @param lengthOfSauna
	 * @param weight
	 * @param comment
	 * @throws SQLException 
	 */
	public void enterNewTrip(Date date, double lengthOfTrip, double lengthOfCardio, double lengthOfLifting, double lengthOfSauna, 
			int weight, String comment) throws SQLException
	{
		rowGateway = new TripRowDataGateway(date, lengthOfTrip, lengthOfCardio, lengthOfLifting, lengthOfSauna, weight, comment);
	}
	
	/**
	 * Deletes a trip based on the date
	 * 
	 * @param date
	 * @throws SQLException
	 */
	public void deleteTrip(Date date) throws SQLException
	{
		rowGateway = new TripRowDataGateway();
		rowGateway.deleteRow(date);
	}
} 