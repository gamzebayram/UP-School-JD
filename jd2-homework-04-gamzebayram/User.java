package musicStore;

public class User {
	
	 	private String userName;
	    private String email;
	    private String address;
	
		public User(String userName, String email, String address) {
			this.userName = userName;
			this.email = email;
			this.address = address;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}
		
		 public void printUserInfo(){
		        System.out.println("Kullanıcı Adı: " + userName);
		        System.out.println("E-posta: " + email);
		        System.out.println("Adres: " + address);
		        System.out.println();
		    }

}
