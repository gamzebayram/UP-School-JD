package movieLibrary;


public class User {

	private final Long userId; 

	private String fullName;

	private String email;

	private String password;

	public User(Long userId, String fullName, String email, String password) {
		this.userId = userId;
		this.fullName = fullName;
		this.email = email;
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getUserId() {
		return userId;
	}

	@Override
	public String toString() {
		return "User[" + "userId=" + userId + ", fullName=" + fullName + ", email=" + email + ", password=" + password + "]"
				+ '\n';
	}

}
