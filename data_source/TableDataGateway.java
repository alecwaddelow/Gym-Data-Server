/** 
 *  
 */ 
package data_source; 
 
import java.util.ArrayList; 
 
import domain.TripDTO; 
 
/** 
 * @author Alec Waddelow 
 * 
 */ 
public interface TableDataGateway  
{ 
  public ArrayList<TripDTO> getAllRows(); 
} 