package data_source; 
 
import java.sql.Date; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import domain.TripDTO; 
 
/** 
 * @author Alec Waddelow  
 *  
 * A row data gateway for a single trip to the gym  
 * 
 */ 
public class TripRowDataGateway implements RowDataGateway 
{ 
  protected Date date; 
  protected double lengthOfTrip; 
  protected double lengthOfCardio; 
  protected double lengthOfLifting; 
  protected double lengthOfSauna; 
  protected int weight; 
  protected String comment; 
   
  /** 
   * Standard constructor 
   *  
   * @param date 
   * @param lengthOfTrip 
   * @param lengthOfCardio 
   * @param lengthOfLifting 
   * @param lengthOfSauna 
   * @param weight 
   * @param comment 
   */ 
  public TripRowDataGateway(Date date, double lengthOfTrip, double lengthOfCardio, double lengthOfLifting, double lengthOfSauna, 
      int weight, String comment)  
  { 
	  this.date = date; 
	    this.lengthOfTrip = lengthOfTrip; 
	    this.lengthOfCardio = lengthOfCardio; 
	    this.lengthOfLifting = lengthOfLifting; 
	    this.lengthOfSauna = lengthOfSauna; 
	    this.weight = weight; 
	    this.comment = comment; 
	  } 
	   
	  /** 
	   * @throws SQLException  
	   * @see data_source.RowDataGateway#addRow(Date, double, double, double, double, int, java.lang.String) 
	   */ 
	  @Override 
	  public void addRow() throws SQLException  
	  { 
	    DBConnection connection = new DBConnection(); 
	    String addSql = "INSERT INTO dbo.TripData (date, lengthOfTrip, lengthOfCardio, lengthOfLifting, lengthOfSauna, weight, comment) VALUES (?, ?, ?, ?, ?, ?, ?);"; 
	     
	    PreparedStatement stmt = connection.getConnection().prepareStatement(addSql); 
	    stmt.setDate(1, this.date); 
	    stmt.setDouble(2, this.lengthOfTrip); 
	    stmt.setDouble(3, this.lengthOfCardio); 
	    stmt.setDouble(4, this.lengthOfLifting); 
	    stmt.setDouble(5, this.lengthOfSauna); 
	    stmt.setInt(6, this.weight); 
	    stmt.setString(7, this.comment); 
	    stmt.executeUpdate(); 
	    stmt.close(); 
	    connection.close(); 
	  } 
	 
	  /** 
	   * @throws SQLException  
	   * @see data_source.RowDataGateway#updateRow(java.util.Date, double, double, double, double, int, java.lang.String) 
	   */ 
	  @Override 
	  public void updateRow(Date date) throws SQLException  
	  { 
		    DBConnection connection = new DBConnection(); 
		    String updateSql = "UPDATE dbo.TripData SET lengthOfTrip = ?, lengthOfCardio = ?, lengthOfLifting = ?, lengthOfSauna = ?, weight = ?, comment = ? WHERE date = ?;"; 
		    PreparedStatement stmt = connection.getConnection().prepareStatement(updateSql); 
		    stmt.setDouble(1, this.lengthOfTrip); 
		    stmt.setDouble(2, this.lengthOfCardio); 
		    stmt.setDouble(3, this.lengthOfLifting); 
		    stmt.setDouble(4, this.lengthOfSauna); 
		    stmt.setInt(5, this.weight); 
		    stmt.setString(6, this.comment); 
		    stmt.setDate(7, date); 
		    stmt.executeUpdate(); 
		    stmt.close(); 
		    connection.close(); 
		  } 
		 
		  /** 
		   * @throws SQLException  
		   * @see data_source.RowDataGateway#deleteRow(java.util.Date) 
		   */ 
		  @Override 
		  public void deleteRow(Date date) throws SQLException 
		  { 
		    DBConnection connection = new DBConnection(); 
		    String deleteSql = "DELETE FROM dbo.TripData WHERE date = ?;"; 
		    PreparedStatement stmt = connection.getConnection().prepareStatement(deleteSql); 
		    stmt.setDate(1, date); 
		    stmt.executeUpdate(); 
		    stmt.close(); 
		    connection.close(); 
		  } 
		 
		  /** 
		   * @throws SQLException  
		   * @see data_source.RowDataGateway#retrieveRow(java.util.Date) 
		   */ 
		  @Override 
		  public TripDTO retrieveRow(Date date) throws SQLException  
		  { 
			    TripDTO dto = null; 
			    DBConnection connection = new DBConnection(); 
			    String retrieveSql = "SELECT date, lengthOfTrip, lengthOfCardio, lengthOfLifting, lengthOfSauna, weight, comment"; 
			    retrieveSql+= "FROM dbo.TripData WHERE date = ?;"; 
			    PreparedStatement stmt = connection.getConnection().prepareStatement(retrieveSql); 
			    stmt.setDate(1, date); 
			    ResultSet rs = stmt.executeQuery(); 
			     
			    while(rs.next()) 
			    { 
			      dto = new TripDTO(rs.getDate(1), rs.getDouble(2), rs.getDouble(3), rs.getDouble(4), rs.getDouble(5), rs.getInt(6), rs.getString(7)); 
			    } 
			    stmt.close(); 
			    rs.close(); 
			    connection.close(); 
			    return dto; 
			 } 
} 