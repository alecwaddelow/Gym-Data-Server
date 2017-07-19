package domain;

import java.sql.SQLException;
import java.util.ArrayList;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import data_source.TripTableDataGateway;

/** 
 *  
 * @author Alec Waddelow  
 * 
 */ 
public class TripManager  
{ 
	protected ArrayList<TripDTO> entries;
	private TripTableDataGateway gateway = new TripTableDataGateway();
	
	public ArrayList<TripDTO> getAllEntries() throws SQLServerException, SQLException
	{
		entries = gateway.getAllRows();
		return entries;
	}
} 