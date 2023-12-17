package smartphoneManagementApp;


public class Main {

	public static void main(String[] args) {

		Phone phone1 = new Phone("Apple", "12Pro", 256, "IOS");
		Phone phone2 = new Phone("Samsung", "GalaxyS23", 128, "Android");

		App calculatorApp = new App("Calculator", "1.2.3", 5);
		App cameraApp = new App("Camera", "2.1.0", 10);
		App galleryApp = new App("Gallery", "3.0.1", 50);

		Contact contact1 = new Contact("Ahmet", "Gültekin", "4444444", "ahmetgltkn@");
		Contact contact2 = new Contact("Asım", "Kılıç", "5445555", "asımkilic@");
		Contact contact3 = new Contact("Gamze", "Bayram", "7447444", "gamzebayram@");

		ManagementApp management = new ManagementApp();


		try {
			management.addPhone(phone1);
			management.addPhone(phone2);
			management.removePhone(phone1);
			management.addContact(phone2, contact1);
			management.addContact(phone2, contact2);
			management.addContact(phone2, contact3);
			management.removeContact(phone2, contact3);
			management.addApplication(phone2, calculatorApp);
			management.addApplication(phone2, cameraApp);
			management.addApplication(phone2, galleryApp);
			management.removeApplication(phone2, calculatorApp);
			management.listAppsOfPhone(phone2);
			management.updateApp(phone2, "Camera", "2.1.5", 23);
			management.listAppsOfPhone(phone2);
			management.showStorageStatus();
			management.listContactsOfPhone(phone2);
			management.updateContact(phone2, contact2);
			management.callContact(phone2, "Ahmet", null, "4444444");
			management.listContactsOfPhone(phone2);
			management.backup(phone2);
			management.restore(phone2);
			management.getContactsStartWithA(phone2);
			management.addApplication(phone2, galleryApp);			
		} catch (ApplicationAlreadyInstalledException | VersionMismatchException | NotFound
				| InsufficientStorageException e) {
			System.out.println(e.getMessage());
		}

	}
}




