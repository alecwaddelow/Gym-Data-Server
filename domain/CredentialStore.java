package domain;

/**
 * @author Alec Waddelow
 * 
 * Stores entered credentials for runtime of the program
 *
 */
public class CredentialStore 
{
	protected static String username;
	protected static String password;
	
	/**
	 * Standard constructor
	 * 
	 * @param username
	 * @param password
	 */
	public CredentialStore(String username, String password)
	{
		CredentialStore.username = username;
		CredentialStore.password = password;
	}

	/**
	 * @return the username
	 */
	public static String getUsername() {
		return username;
	}

	/**
	 * @return the password
	 */
	public static String getPassword() {
		return password;
	}
}
