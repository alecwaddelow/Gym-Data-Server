package data_source; 
 
import java.sql.Date; 
import java.sql.SQLException; 
import domain.TripDTO; 
 
/** 
 *  
 * @author Alec Waddelow 
 *  
 * Interface for RowDataGateways 
 * 
 */ 
public interface RowDataGateway  
{ 
  /** 
   * Adds a row 
   *  
   * @throws SQLException 
   */ 
  public void addRow() throws SQLException; 
   
  /** 
   * Updates a row based on the date  
   *  
   * @param date 
   * @throws SQLException 
   */ 
  public void updateRow(Date date) throws SQLException; 
   
  /** 
   * Deletes a row based on the date  
   * @param date 
   * @throws SQLException  
   */ 
  public void deleteRow(Date date) throws SQLException; 
   
  /** 
   * Retrieves a row based on the date 
   * @param date 
   * @return TripDTO containing all of the information from that row 
   * @throws SQLException  
   */ 
  public TripDTO retrieveRow(Date date) throws SQLException; 
} 