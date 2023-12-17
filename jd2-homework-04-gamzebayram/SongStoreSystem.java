package musicStore;

import java.util.ArrayList;
import java.util.List;

public class SongStoreSystem {
	private List<Song>  songs ;
    private List<Album> albums;
    private List<User> users;

    public SongStoreSystem() {
    	songs = new ArrayList<>();
    	albums = new ArrayList<>();
        users = new ArrayList<>();    
    }
    
    public void addSong(Song song){
        this.songs.add(song);
    }

    public void removeSong(Song song){
        this.songs.remove(song);
    }

    public void addAlbum(Album album){
        this.albums.add(album);
    }
    
    public void removeAlbum(Album album){
        this.albums.remove(album);
    }
    public void addUser(User user){
        this.users.add(user);
    }
    public void removeUser(User user){
        this.users.remove(user);
    }
   
    public void listSongs(){
        System.out.println("****************Şarkılar****************");
        for (Song song : this.songs){
            song.printSongInfo();
        }
        System.out.println("Toplam Fiyat :" + totalPrice()+ " dolar");
        System.out.println();
    }
    
    private int totalPrice() {
        int toplam = 0;
        for (Song song : this.songs){
            toplam += song.getPrice();
        }
        return toplam;
    }
        
    
    public void searchSongs(Song song){
        System.out.println("****************Arama Sonucu****************");
    	System.out.println("Mağazada " + song.getSongName() + " şarkısı mevcut mu: " + (songs.contains(song) ? "EVET" : "HAYIR"));
    	System.out.println();
      }
 
    public void listAlbums(){
        System.out.println("****************Albümler****************");
        for (Album album : this.albums){
        	album.printAlbumInfo();
        }
        System.out.println("Toplam Fiyat :" + totalAlbumPrice()+ " dolar");
        System.out.println();

    }
     
    private double totalAlbumPrice() {
    	double toplam = 0;
        for (Album album : this.albums){
            toplam += album.getAlbumPrice();
        }
        return toplam;
    }
        
    public void searchAlbums(Album album){
        System.out.println("****************Arama Sonucu****************");
    	System.out.println("Mağazada " + album.getAlbumName() + " albümü mevcut mu: " + (albums.contains(album) ? "EVET" : "HAYIR")); 
    	System.out.println();
      }
    
    public void listUsers(){
        System.out.println("****************Kullanıcılar****************");
        for (User user : this.users){
            user.printUserInfo();
        }
    }
    
}
