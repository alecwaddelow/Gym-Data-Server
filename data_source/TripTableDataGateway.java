package data_source;

import java.sql.*;
import java.util.ArrayList;

import com.microsoft.sqlserver.jdbc.SQLServerException;

import domain.TripDTO;

/**
 * @author Alec Waddelow & Marty Sease
 *
 */
public class TripTableDataGateway implements TableDataGateway
{

	@Override
	public ArrayList<TripDTO> getAllRows() throws SQLServerException, SQLException 
	{
		ArrayList<TripDTO> entries = new ArrayList<TripDTO>();
		DBConnection connection = new DBConnection();
		String retrieveSql = "SELECT date, lengthOfTrip, lengthOfCardio, lengthOfLifting, lengthOfSauna, weight, comment FROM dbo.TripData;";
		PreparedStatement stmt = connection.getConnection().prepareStatement(retrieveSql);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next())
		{
			entries.add(new TripDTO(rs.getDate(1), rs.getDouble(2), rs.getDouble(3), rs.getDouble(4), rs.getDouble(5), rs.getInt(6), rs.getString(7)));
		}
		
		stmt.close();
		connection.close();
		return entries;
	}

}
