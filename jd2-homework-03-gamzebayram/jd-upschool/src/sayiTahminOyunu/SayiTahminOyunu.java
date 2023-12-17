package sayiTahminOyunu;

import java.util.Scanner;

public class SayiTahminOyunu {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
        int sayac = 0;
		int tahmin = 0;
		int rastgele = (int) (Math.random()*100+1);
		System.out.println("Lütfen 1-100 aralığında bir sayı giriniz.");
        
         
        do {
            tahmin = scan.nextInt();
            if(tahmin > rastgele) {
                System.out.println("Too high, try again.");
            }
            else if(tahmin < rastgele) {
                System.out.println("Too low, try again.");
            }
            sayac++;
        }
        while(tahmin != rastgele);
         
		System.out.println("Doğru! " + sayac + ". denemede sayıyı buldunuz.");

	}

}
