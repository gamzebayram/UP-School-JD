package musicStore;

public class Song {

	 	private String songName;
	    private Album album;
	    private String songLength;
	    private int price;
	  

		public Song(String songName, Album album, String songLength, int price) {
			this.songName = songName;
			this.album = album;
			this.songLength = songLength;
			this.price = price;
		}

		public String getSongName() {
			return songName;
		}

		public void setSongName(String songName) {
			this.songName = songName;
		}

		public Album getAlbum() {
			return album;
		}

		public void setAlbum(Album album) {
			this.album = album;
		}

		public String getSongLength() {
			return songLength;
		}

		public void setSongLength(String songLength) {
			this.songLength = songLength;
		}
		
		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}
		
		public void printSongInfo(){
	        System.out.println("Şarkı Adı: " + songName);
	        System.out.println("Sanatçı Adı: " + album.getSingerName());
	        System.out.println("Albüm Adı: " + album.getAlbumName());
	        System.out.println("Şarkı Süresi: " + songLength + " dakika");
	        System.out.println("Şarkı Fiyatı: " + price + " dolar");
	        System.out.println();
	    }
		    	
}
