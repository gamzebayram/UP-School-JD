package paymentSystem;

import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean system = false;
		int maxAttempts = 2; // Deneme hakkı sayısı
		int remainingAttempts = maxAttempts; // Kullanılabilir deneme hakkı sayısı

		do {
			system = false;
			try {
				System.out.print("Ödeme gerçekleştireceğiniz tutarı giriniz: ");
				String amount = scanner.nextLine();
				if (isValidAmount(amount)) {
					throw new InvalidAmountException("Negatif veya virgüllü bir tutar girilemez.");
				}

				System.out.print("Ödeme gerçekleştireceğiniz kredi kartı numaranızı giriniz: ");
				String cardNumber = scanner.nextLine();
				if (!isValidCardNumber(cardNumber)) {
					throw new InvalidCardNumberException("Kart numarası geçersiz! 16 karakter olmalı ve harf içeremez.", cardNumber);
				}

				System.out.print("Kredi kartınızın son kullanma tarihini giriniz: ");
				String date = scanner.nextLine();
				if (isValidDate(date)) {
					throw new InvalidExpirationDateException("Geçersiz tarih girdiniz.");
				}

				System.out.print("Kredi kartınızın güvenlik kodunu giriniz: ");
				String code = scanner.nextLine();
				if (!isValidCode(code)) {
					throw new InvalidSecurityCodeException("Güvenlik kodu geçersiz! 3 karakter olmalı ve harf içeremez.");
				}
				
				try {
					pay();
				} catch (SystemNotWorkingException e) {
					system = true;
					remainingAttempts--;
					System.out.println("Ödeme işleminiz gerçekleştirilemedi.");
				}
				
			} catch (InvalidCardNumberException e) {
			      System.out.println(e.getMessage() + " \nGirilen kredi kartı: " + e.getCardNumber() );
		    } catch (InvalidExpirationDateException | InvalidAmountException | InvalidSecurityCodeException e) {
				System.out.println(e.getMessage());
			}
		} while (system && remainingAttempts > 0);
	}

	private static boolean isValidAmount(String amount) {
		return amount.contains("-") || amount.contains(",");
	}

	private static boolean isValidCardNumber(String cardNumber) {
		if (cardNumber.length() != 16) {
			return false;
		}

		for (char c : cardNumber.toCharArray()) {
			if (!Character.isDigit(c)) {
				return false;
			}
		}
		return true;
	}

	private static boolean isValidDate(String date) {
		
		if (date.length() != 6) {
		      return true;
		    }

		LocalDate currentDate = LocalDate.now();
		int currentYear = currentDate.getYear();
		int currentMonth = currentDate.getMonthValue();

		int month = Integer.parseInt(date.substring(0, 2));
		int year = Integer.parseInt(date.substring(date.length() - 4));

		if (year < currentYear || month < currentMonth || month < 1 || month > 12) {
			return true;
		}
		return false;
	}

	private static boolean isValidCode(String code) {
		if (code.length() != 3) {
			return false;
		}

		for (char c : code.toCharArray()) {
			if (!Character.isDigit(c)) {
				return false;
			}
		}
		return true;
	}

	private static void pay() throws SystemNotWorkingException {
		Random random = new Random();
		int randomNumber = random.nextInt(101);
		if (randomNumber > 75) {
			throw new SystemNotWorkingException();
		}else {System.out.println("Ödeme işleminiz gerçekleştirildi.");
		}
	}
}
