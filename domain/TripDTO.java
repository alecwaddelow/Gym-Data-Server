package domain; 
 
import java.util.Date; 
 
/** 
 * @author Alec Waddelow 
 *  
 * Data Transfer Object for a Trip to the gym 
 * 
 */ 
public class TripDTO  
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
  public TripDTO(Date date, double lengthOfTrip, double lengthOfCardio, double lengthOfLifting, double lengthOfSauna, 
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
	 
	  public Date getDate() { 
	    return this.date; 
	  } 
	 
	  public void setDate(Date date) { 
	    this.date = date; 
	  } 
	 
	  public double getLengthOfTrip() { 
	    return this.lengthOfTrip; 
	  } 
	 
	  public void setLengthOfTrip(double lengthOfTrip) { 
	    this.lengthOfTrip = lengthOfTrip; 
	  } 
	 
	  public double getLengthOfCardio() { 
	    return this.lengthOfCardio; 
	  } 
	 
	  public void setLengthOfCardio(double lengthOfCardio) { 
	    this.lengthOfCardio = lengthOfCardio; 
	  } 
	 
	  public double getLengthOfLifting() { 
	    return this.lengthOfLifting; 
	  } 
	  

	  public void setLengthOfLifting(double lengthOfLifting) { 
	    this.lengthOfLifting = lengthOfLifting; 
	  } 
	 
	  public double getLengthOfSauna() { 
	    return this.lengthOfSauna; 
	  } 
	 
	  public void setLengthOfSauna(double lengthOfSauna) { 
	    this.lengthOfSauna = lengthOfSauna; 
	  } 
	 
	  public int getWeight() { 
	    return this.weight; 
	  } 
	 
	  public void setWeight(int weight) { 
	    this.weight = weight; 
	  } 
	 
	  public String getComment() { 
	    return this.comment; 
	  } 
	 
	  public void setComment(String comment) { 
	    this.comment = comment; 
	  } 
	   
} 