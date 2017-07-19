package data_source; 

import java.sql.SQLException;
import java.util.ArrayList;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import domain.TripDTO; 

/** 
 * @author Alec Waddelow 
 * 
 */ 
public interface TableDataGateway  
{ 
	public ArrayList<TripDTO> getAllRows() throws SQLServerException, SQLException; 
} 