package movieLibrary;

import java.util.Arrays;

public class UserManagement {

	public User[] users = new User[] { new User(1L, "Ahmet Gültekin", "ahmetgltkn@", "pswrdAhmet"),
			new User(2L, "Asım Kılıç", "asımkilic@", "pswrdAsım"),
			new User(3L, "Gamze Bayram", "gamzebayram@", "pswrdGamze") };

	public boolean logIn(String userName, String userPassword) {
		for (User user : users) {
			if (user.getFullName().equalsIgnoreCase(userName) && user.getPassword().equalsIgnoreCase(userPassword)) {
				System.out.println("HOŞGELDİNİZ.!");
				return true;
			}
		}
		System.out.println("Kullanıcı adı veya şifre yanlış.");
		return false;

	}

	public void listUsers() {
		System.out.println(Arrays.toString(users));
	}

	public User findUser(String fullName) {
		User searchedUser = null;
		for (User user : users) {
			if (user.getFullName().equalsIgnoreCase(fullName)) {
				searchedUser = user;
				break;
			}
		}
		return searchedUser;
	}

	public void addUser(User newUser) {

		User[] newUsers = new User[users.length + 1];
		System.arraycopy(users, 0, newUsers, 0, users.length);
		newUsers[newUsers.length - 1] = newUser;
		users = newUsers;
		System.out.println("Kullanıcı başarılı şekilde eklendi: " + newUser.getFullName());
	}

	public boolean removeUser(String fullName) {
		boolean isDeleted = false;
		int index = 0;
		User[] newUsers = new User[users.length - 1];
		for (User user : users) {
			if (user != null && user.getFullName().equalsIgnoreCase(fullName)) {
				isDeleted = true;
			} else {
				newUsers[index] = user;
				index++;
			}
		}
		users = newUsers;
		if (isDeleted) {
			System.out.println("Kullanıcı başarılı şekilde silindi: " + fullName);
			return true;
		} else {
			System.out.println("Hata: Kullanıcı bulunamadı.");
			return false;
		}
	}

}
