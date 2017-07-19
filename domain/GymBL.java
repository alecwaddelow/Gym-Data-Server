package domain;

import java.sql.SQLException;
import java.util.ArrayList;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import data_source.TripTableDataGateway;

/**
 * @author Marty Sease
 *
 */
public class GymBL
{
	TripTableDataGateway tableGateway = new TripTableDataGateway();

	public ArrayList<TripDTO> getAllRows() throws SQLServerException, SQLException
	{
		return this.tableGateway.getAllRows();
	}
}