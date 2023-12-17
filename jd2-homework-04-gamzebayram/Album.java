package musicStore;

public class Album {

	private String albumName;
   	private String singerName;
    private String releaseDate;
    private double albumPrice;
    

	public Album(String albumName, String singerName, String releaseDate, double albumPrice) {
		this.albumName = albumName;
		this.singerName = singerName;
		this.releaseDate = releaseDate;
		this.albumPrice = albumPrice;
		
	}


	public String getAlbumName() {
		return albumName;
	}


	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}


	public String getSingerName() {
		return singerName;
	}


	public void setSingerName(String singerName) {
		this.singerName = singerName;
	}


	public String getReleaseDate() {
		return releaseDate;
	}


	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	public double getAlbumPrice() {
		return albumPrice;
	}


	public void setAlbumPrice(double albumPrice) {
		this.albumPrice = albumPrice;
	}


	public void printAlbumInfo() {
		System.out.println("Albüm Adı: " + albumName);
        System.out.println("Sanatçı Adı: " + singerName);
        System.out.println("Yayın Tarihi: " + releaseDate);
        System.out.println("Albüm Fiyatı: " + albumPrice + " dolar");
        System.out.println();
	}
	
   
}
