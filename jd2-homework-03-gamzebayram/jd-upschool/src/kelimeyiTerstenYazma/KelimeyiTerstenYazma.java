package kelimeyiTerstenYazma;

import java.util.Scanner;

public class KelimeyiTerstenYazma {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		System.out.println("Lütfen bir kelime giriniz.");
		String kelime = scan.nextLine();
		String ters = "";
		
		for (int i=kelime.length()-1; i>=0; i--){
			ters += kelime.charAt(i);
		}
		System.out.println("Girilen kelimenin tersi:\n" + ters);
		
		if(kelime.equals(ters)){
			System.out.println("\nPolindromdur.");
		}else {
			System.out.println("\nPolindrom değildir.");
		}
	}

}
