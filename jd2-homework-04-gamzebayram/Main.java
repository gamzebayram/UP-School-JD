package musicStore;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Album album = new Album("Endless Summer Vacation", "Miley Cyrus", "10.03.2023", 200);
		Album album2 = new Album("Tragic Kingdom", "No Doubt", "10.10.1995", 100);
		Album album3 = new Album("Gangsta's Paradise", "Coolio", "01.09.1995", 170);
		Album album4 = new Album("The Marshall Mathers LP", "Eminem", "23.05.2000", 100);

		Song song = new Song("Flowers", album, "3:21", 20);
		Song song2 = new Song("Don't Speak", album2, "5:00", 10);
		Song song3 = new Song("Gangsta's Paradise", album3, "4:14", 20);
		Song song4 = new Song("Stan", album4, "8:08", 15);
		Song song5 = new Song("The Real Slim Shady", album4, "4:28", 10);

		User user = new User("Ahmet", "ahmetgltkn@", "Ankara");
		User user2 = new User("Asım", "asımkilic@", "Antalya");
		User user3 = new User("Gamze", "gamzebayram@", "İstanbul");

		SongStoreSystem songStoreSystem = new SongStoreSystem();

//        songStoreSystem.addSong(song);
//        songStoreSystem.addSong(song2);
//        songStoreSystem.addSong(song3);
//        songStoreSystem.addSong(song4);
//        songStoreSystem.addSong(song5);
//        
//        songStoreSystem.removeSong(song2);
//        songStoreSystem.removeSong(song5);
//        
//        songStoreSystem.addAlbum(album);
//        songStoreSystem.addAlbum(album2);
//        songStoreSystem.addAlbum(album3);
//        songStoreSystem.addAlbum(album4);
//        
//        songStoreSystem.removeAlbum(album3);
//        
//        songStoreSystem.addUser(user);
//        songStoreSystem.addUser(user2);
//        songStoreSystem.addUser(user3);   
//        
//        songStoreSystem.removeUser(user2);
//                
//        songStoreSystem.listSongs();
//        
//        songStoreSystem.searchSongs(song2);
//
//        songStoreSystem.listAlbums();
//        
//        songStoreSystem.searchAlbums(album4);
//        
//        songStoreSystem.listUsers();

		
		Scanner in = new Scanner(System.in);

		while (true) {
			System.out.println();
			System.out.println("********************MUSIC STORE****************");
			System.out.println(
					"\t\t1.Şarkı Ekle\n\t\t2.Şarkı Çıkar\n\t\t3.Albüm Ekle\n\t\t4.Albüm Çıkar\n\t\t5.Kullanıcı Ekle\n\t\t6.Kullanıcı Çıkar\n\t\t7.Şarkı Listesini Görüntüle\n\t\t8.Aradığınız şarkı mı var?\n\t\t9.Albüm Listesini Görüntüle\n\t\t10.Aradığınız albüm mü var?\n\t\t11.Kullanıcıları Görüntüle\n\t\t12.Çıkış");
			System.out.println();
			System.out.println("Yukarıdaki menüden seçiminizi girin:");
			
			int secim = in.nextInt();
			
			switch (secim) {
			case 1:
				System.out.println("Hangi şarkıyı eklemek istersiniz:");
				System.out.println("\t\t1.Flowers\n\t\t2.Don't Speak\n\t\t3.Gangsta's Paradise\n\t\t4.Stan\n\t\t5.The Real Slim Shady");
				int no = in.nextInt();
				switch (no) {
				case 1:
					songStoreSystem.addSong(song);
					System.out.println("Eklendi.");
					break;
				case 2:
					songStoreSystem.addSong(song2);
					System.out.println("Eklendi.");
					break;
				case 3:
					songStoreSystem.addSong(song3);
					System.out.println("Eklendi.");
					break;
				case 4:
					songStoreSystem.addSong(song4);
					System.out.println("Eklendi.");
					break;
				case 5:
					songStoreSystem.addSong(song5);
					System.out.println("Eklendi.");
					break;
				}
				break;
			case 2:
				System.out.println("Hangi şarkıyı çıkarmak istersiniz:");
				System.out.println("\t\t1.Flowers\n\t\t2.Don't Speak\n\t\t3.Gangsta's Paradise\n\t\t4.Stan\n\t\t5.The Real Slim Shady");
				int no2 = in.nextInt();
				switch (no2) {
				case 1:
					songStoreSystem.removeSong(song);
					System.out.println("Çıkarıldı.");
					break;
				case 2:
					songStoreSystem.removeSong(song2);
					System.out.println("Çıkarıldı.");
					break;
				case 3:
					songStoreSystem.removeSong(song3);
					System.out.println("Çıkarıldı.");
					break;
				case 4:
					songStoreSystem.removeSong(song4);
					System.out.println("Çıkarıldı.");;
					break;
				case 5:
					songStoreSystem.removeSong(song5);
					System.out.println("Çıkarıldı.");
					break;
				}
				break;
			case 3:
				System.out.println("Hangi albümü eklemek istersiniz:");
				System.out.println("\t\t1.Endless Summer Vacatio\n\t\t2.Tragic Kingdom\n\t\t3.Gangsta's Paradise\n\t\t4.The Marshall Mathers LP");
				int no3 = in.nextInt();
				switch (no3) {
				case 1:
					songStoreSystem.addAlbum(album);
					System.out.println("Eklendi.");
					break;
				case 2:
					songStoreSystem.addAlbum(album2);
					System.out.println("Eklendi.");
					break;
				case 3:
					songStoreSystem.addAlbum(album3);
					System.out.println("Eklendi.");
					break;
				case 4:
					songStoreSystem.addAlbum(album4);
					System.out.println("Eklendi.");
					break;
				}
				break;
			case 4:
			System.out.println("Hangi albümü çıkarmak istersiniz:");
			System.out.println("\t\t1.Endless Summer Vacatio\n\t\t2.Tragic Kingdom\n\t\t3.Gangsta's Paradise\n\t\t4.The Marshall Mathers LP");
			int no4 = in.nextInt();
			switch (no4) {
			case 1:
				songStoreSystem.removeAlbum(album);
				System.out.println("Çıkarıldı.");
				break;
			case 2:
				songStoreSystem.removeAlbum(album2);
				System.out.println("Çıkarıldı.");
				break;
			case 3:
				songStoreSystem.removeAlbum(album3);
				System.out.println("Çıkarıldı.");
				break;
			case 4:
				songStoreSystem.removeAlbum(album4);
				System.out.println("Çıkarıldı.");
				break;
			}
			break;
			case 5:
				System.out.println("Hangi kullanıcıyı eklemek istiyorsunuz:");
				System.out.println("\t\t1.Ahmet\n\t\t2.Asım\n\t\t3.Gamze");
				int no5 = in.nextInt();
				switch (no5) {
				case 1:
					songStoreSystem.addUser(user);
					System.out.println("Eklendi.");
					break;
				case 2:
					songStoreSystem.addUser(user2);
					System.out.println("Eklendi.");
					break;
				case 3:
					songStoreSystem.addUser(user3);
					System.out.println("Eklendi.");
					break;
				}
				break;
			case 6:
				System.out.println("Hangi kullanıcıyı çıkarmak istiyorsunuz:");
				System.out.println("\t\t1.Ahmet\n\t\t2.Asım\n\t\t3.Gamze");
				int no6 = in.nextInt();
				switch (no6) {
				case 1:
					songStoreSystem.removeUser(user);
					System.out.println("Çıkarıldı.");
					break;
				case 2:
					songStoreSystem.removeUser(user2);
					System.out.println("Çıkarıldı.");
					break;
				case 3:
					songStoreSystem.removeUser(user3);
					System.out.println("Çıkarıldı.");
					break;
				}
				break;
			case 7:
				songStoreSystem.listSongs();
				break;
			case 8:
				System.out.println("Hangi şarkıyı arıyorsunuz:");
				System.out.println("\t\t1.Flowers\n\t\t2.Don't Speak\n\t\t3.Gangsta's Paradise\n\t\t4.Stan\n\t\t5.The Real Slim Shady");
				int no8 = in.nextInt();
				switch (no8) {
				case 1:
					 songStoreSystem.searchSongs(song);
					break;
				case 2:
					songStoreSystem.searchSongs(song2);
					break;
				case 3:
					 songStoreSystem.searchSongs(song3);
					break;
				case 4:
					 songStoreSystem.searchSongs(song4);
					break;
				case 5:
					 songStoreSystem.searchSongs(song5);
					break;
				}
				break;
			case 9:
				songStoreSystem.listAlbums();
				break;
			case 10:
				System.out.println("Hangi albümü arıyorsunuz:");
				System.out.println("\t\t1.Endless Summer Vacatio\n\t\t2.Tragic Kingdom\n\t\t3.Gangsta's Paradise\n\t\t4.The Marshall Mathers LP");
				int no10 = in.nextInt();
				switch (no10) {
				case 1:
					songStoreSystem.searchAlbums(album);
					break;
				case 2:
					songStoreSystem.searchAlbums(album2);
					break;
				case 3:
					songStoreSystem.searchAlbums(album3);
					break;
				case 4:
					songStoreSystem.searchAlbums(album4);
					break;
				}
				break;
			case 11:
				songStoreSystem.listUsers();
				break;
			case 12:
				System.out.println("\nHoşçakalın");
				System.exit(0);
				break;
			default: System.out.println("\nGeçersiz Seçim");
		}
						

	}

  }
	
}
