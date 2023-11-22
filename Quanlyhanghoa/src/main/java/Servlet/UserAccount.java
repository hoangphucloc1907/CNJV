package Servlet;

public class UserAccount {
	public static final String GENDER_MALE = "M";
	public static final String GENDER_FEMALE = "F";
	
	private String username;
	private String password;
	private String gender;
	
	
	public UserAccount() {}

	public UserAccount(String username, String password, String gender) {
		this.username = username;
		this.password = password;
		this.gender = gender;
	}
	
	public UserAccount(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public UserAccount(UserAccount us) {
		this.username = us.username;
		this.password = us.password;
		this.gender = us.gender;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
}
