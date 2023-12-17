package movieLibrary;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		MovieManagement movieManagement = new MovieManagement();
		UserManagement userManagement = new UserManagement();
		int choice = 0;

	
		System.out.print("Giriş yapmak için kullanıcı adınızı giriniz: ");
		String userName = sc.nextLine();
		System.out.print("Şifrenizi giriniz: ");
		String userPassword = sc.nextLine();
		System.out.println("--------------------------------");


		if (userManagement.logIn(userName, userPassword)) {

			System.out.println("--------------------------------");
			printMenu();

			do {
				System.out.print("Seçiminiz: ");
				choice = sc.nextInt();
				switch (choice) {
				case 1: {
					System.out.println("--------------------------------");
					movieManagement.listMovies();
					System.out.println("--------------------------------");
					break;
				}
				case 2: {
					System.out.println("--------------------------------");
					userManagement.listUsers();
					System.out.println("--------------------------------");
					break;
				}
				case 3: {
					System.out.println("--------------------------------");
					System.out.print("Aranacak film adını giriniz: ");
					sc.nextLine();
					String name = sc.nextLine();
					Movie movie = movieManagement.findMovieByName(name);
					if (movie == null) {
						System.out.println("Film bulunamadı");
						break;
					}
					System.out.println(movie);
					System.out.println("--------------------------------");
					break;
				}
				case 4: {
					System.out.println("--------------------------------");
					System.out.print("Aranacak film ID giriniz: ");
					Long movieId = sc.nextLong();
					Movie movie = movieManagement.findMovieById(movieId);
					if (movie == null) {
						System.out.println("Film bulunamadı");
						break;
					}
					System.out.println(movie);
					System.out.println("--------------------------------");
					break;
				}
				case 5: {
					System.out.println("--------------------------------");
					System.out.print("Aramak istediğiniz kullanıcı adını giriniz: ");
					sc.nextLine();
					String fullName = sc.nextLine();
					User user = userManagement.findUser(fullName);
					if (user == null) {
						System.out.println("Kullanıcı bulunamadı");
						break;
					}
					System.out.println(user);
					System.out.println("--------------------------------");
					break;
				}
				case 6: {
					System.out.println("--------------------------------");
					System.out.print("Eklemek istediğiniz film ID giriniz: ");
					sc.nextLine();
					Long movieId = sc.nextLong();
					System.out.print("Eklemek istediğiniz film adı giriniz: ");
					sc.nextLine();
					String name = sc.nextLine();
					System.out.print("Eklemek istediğiniz film yönetmeni giriniz: ");
					String director = sc.nextLine();
					System.out.print("Eklemek istediğiniz film oyuncularını (aralarına boşluk koyarak) giriniz: ");
					String[] actors = sc.nextLine().split(" ");
					System.out.print("Eklemek istediğiniz film yılını giriniz: ");
					String releaseDate = sc.nextLine();
					System.out.print("Eklemek istediğiniz film türünü giriniz: ");
					String genre = sc.nextLine();

					Movie newMovie = new Movie(movieId, name, director, actors, releaseDate, genre);
					movieManagement.addMovie(newMovie);
					System.out.println("--------------------------------");
					break;
				}
				case 7: {
					sc.nextLine();
					System.out.println("--------------------------------");
					System.out.print("Silmek istediğiniz film adını giriniz: ");
					String name = sc.nextLine();
					movieManagement.removeMovie(name);
    				System.out.println("--------------------------------");
					break;
				}
				case 8: {
					System.out.println("--------------------------------");
					System.out.print("Eklemek istediğiniz kullanıcı ID giriniz: ");
					sc.nextLine();
					Long userId = sc.nextLong();
					System.out.print("Eklemek istediğiniz kullanıcı adını giriniz: ");
					sc.nextLine();
					String fullName = sc.nextLine();
					System.out.print("Eklemek istediğiniz kullanıcı e-posta giriniz: ");
					String email = sc.nextLine();
					System.out.print("Eklemek istediğiniz kullanıcı şifresini giriniz: ");
					String password = sc.nextLine();

					User newUser = new User(userId, fullName, email, password);
					userManagement.addUser(newUser);		
					System.out.println("--------------------------------");
					break;
				}
				case 9: {
					sc.nextLine();
					System.out.println("--------------------------------");
					System.out.print("Silmek istediğiniz kullanıcı adını giriniz: ");
					String fullName = sc.nextLine();
					userManagement.removeUser(fullName);
					System.out.println("--------------------------------");
					break;
				}
				case -1: {
					System.out.println("--------------------------------");
					System.out.println("HOŞÇAKALIN.!");
					System.out.println("--------------------------------");
					break;
				}
				default:
					printMenu();
				}
			} while (choice != -1);

		}
	}

	private static void printMenu() {
		System.out.println("##### Film Kütüphanesi #####");
		System.out.println("1: Filmleri listele");
		System.out.println("2: Kullanıcıları listele");
		System.out.println("3: Film ara - İsim ile");
		System.out.println("4: Film ara - ID ile");
		System.out.println("5: Kullanıcı ara");
		System.out.println("6: Film Ekle");
		System.out.println("7: Film Çıkart");
		System.out.println("8: Kullanıcı Ekle");
		System.out.println("9: Kullanıcı Çıkart");
		System.out.println("-1: Çıkış \n\n");

	}

}
