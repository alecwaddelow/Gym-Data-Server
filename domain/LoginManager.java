package domain; 
 
import com.microsoft.sqlserver.jdbc.SQLServerException; 
import data_source.DBConnection; 
 
/** 
 * @author Alec Waddelow 
 *  
 * Handles user entered credentials to establish connection to the database 
 */ 
public class LoginManager  
{ 
  private String username;  
  private String password;  
  private DBConnection server = new DBConnection(); 
   
  /** 
   * Constructor 
   *  
   * @param username 
   * @param password 
   */ 
  public LoginManager(String username, String password) 
  { 
    this.username = username; 
    this.password = password; 
  } 
   
 
  /** 
   * Attempts to make a connection to the database with user inputed credentials 
   *  
   * @param username 
   * @param password 
   * @throws SQLServerException  
   */ 
  public boolean login() throws SQLServerException 
  { 
	   	CredentialStore cred = new CredentialStore(this.username, this.password);
	   	server.createConnection(CredentialStore.getUsername(), CredentialStore.getPassword());
	    if(server.authenticate() == true) 
	    { 
	      return true; 
	    } 
	    else 
	    { 
	      return false; 
	    } 
	  } 
	 
	  /** 
	   * @return the username 
	   */ 
	  protected String getUsername() { 
	    return this.username; 
	  } 
	 
	  /** 
	   * @param username the username to set 
	   */ 
	  protected void setUsername(String username) { 
	    this.username = username; 
	  } 
	 
	  /** 
	   * @return the password 
	   */ 
	  protected String getPassword() { 
	    return this.password; 
	  } 
	 
	  /** 
	   * @param password the password to set 
	   */ 
	  protected void setPassword(String password) { 
	    this.password = password; 
	  } 
} 