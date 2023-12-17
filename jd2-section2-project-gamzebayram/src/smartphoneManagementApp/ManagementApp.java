package smartphoneManagementApp;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ManagementApp{

	private List<Phone> phones;

	public ManagementApp() {
		phones = new ArrayList<>();
	}

	public void addPhone(Phone phone) {
		phones.add(phone);
		System.out.println("Telefon eklendi: " + phone);
	}
	

	public void removePhone(Phone phone) {
		phones.remove(phone);
		System.out.println("Telefon kaldırıldı: " + phone.getModel());
	}
	

	public void addContact(Phone phone, Contact contact) {
		phone.getContactList().add(contact);
		System.out.println("Kişi eklendi: " + contact.getName() + " " + contact.getSurname() + " - " + contact.getPhoneNumber());
	}
	

	public void removeContact(Phone phone, Contact contact) {
		phone.getContactList().remove(contact);
		System.out.println("Kişi silindi: " + contact.getName() + " " + contact.getSurname());
	}
	

	public void addApplication(Phone phone, App application) throws ApplicationAlreadyInstalledException, InsufficientStorageException {
		if (isApplicationInstalled(phone, application)) {
			throw new ApplicationAlreadyInstalledException("Bu uygulama zaten yüklü: " + application.getAppName() + " " + application.getAppVersion());
		} 
		if (phone.getStorage() < application.getAppSize()) {
          throw new InsufficientStorageException("Yetersiz depolama alanı: ");
      }
		phone.getAppList().add(application);
		phone.setFreeStorage(phone.getFreeStorage() - application.getAppSize());
		System.out.println("Uygulama yüklendi: " + application.getAppName() + " " + application.getAppVersion());
	}


	private boolean isApplicationInstalled(Phone phone, App application) {
		return phone.getAppList().stream().anyMatch(app -> app.getAppName().equalsIgnoreCase(application.getAppName()));
	}
	

	public void removeApplication(Phone phone, App application) throws NotFound {
		if (phone.getAppList().stream().anyMatch(app -> app.getAppName().equalsIgnoreCase(application.getAppName()))) {
		phone.getAppList().remove(application);
		phone.setFreeStorage(phone.getFreeStorage() + application.getAppSize());
		System.out.println("Uygulama kaldırıldı: " + application.getAppName() + " " + application.getAppVersion());
	}else {
        throw new NotFound("Uygulama zaten yüklü değil.");
    }
		 }

	
	public void listAppsOfPhone(Phone phone) {
		System.out.println(phone.getModel() + " Telefonuna yüklü uygulamalar: ");
		phone.getAppList().stream()
         .map(app -> app.getAppName() + " - "  + app.getAppVersion())
          .forEach(System.out::println);
	}
	    
	
	public void listContactsOfPhone(Phone phone) {
		System.out.println(phone.getModel() + " Telefon rehberindeki kişiler: ");
		phone.getContactList().stream()
         .map(contact -> contact.getName() + " " + contact.getSurname() + " - " + contact.getPhoneNumber())
          .forEach(System.out::println);
	}
		
	
	
	public void updateApp(Phone phone, String appName, String newAppVersion, int appSize) throws VersionMismatchException {
		Optional<App> appUpdate = phone.getAppList().stream().filter(app -> app.getAppName().equalsIgnoreCase(appName)
				&& !app.getAppVersion().equalsIgnoreCase(newAppVersion)).findFirst();

		if (appUpdate.isPresent()) {
			appUpdate.get().setAppVersion(newAppVersion);
			phone.setFreeStorage(phone.getFreeStorage() - appSize);
			System.out.println(appName + " uygulaması " + newAppVersion + " sürümü başarıyla güncellendi.");
		} else {
			throw new VersionMismatchException("Uygulama sürümü uyumsuz veya uygulama bulunamadı: " + appName);
		}
	}



	public void updateContact(Phone phone, Contact updatedContact) throws NotFound {
	    Optional<Contact> contactUpdate = phone.getContactList().stream()
	            .filter(contact -> contact.getName().equalsIgnoreCase(updatedContact.getName())
	                    || contact.getSurname().equalsIgnoreCase(updatedContact.getSurname())
	                    || contact.getPhoneNumber().equalsIgnoreCase(updatedContact.getPhoneNumber())
	                    || contact.getEmail().equalsIgnoreCase(updatedContact.getEmail()))
	            .findFirst();

	    if (contactUpdate.isPresent()) {
	        Contact existingContact = contactUpdate.get();
	        if (!existingContact.getName().equalsIgnoreCase(updatedContact.getName())) {
	            existingContact.setName(updatedContact.getName());
	        }
	        if (!existingContact.getSurname().equalsIgnoreCase(updatedContact.getSurname())) {
	            existingContact.setSurname(updatedContact.getSurname());
	        }
	        if (!existingContact.getPhoneNumber().equalsIgnoreCase(updatedContact.getPhoneNumber())) {
	            existingContact.setPhoneNumber(updatedContact.getPhoneNumber());
	        }
	        if (!existingContact.getEmail().equalsIgnoreCase(updatedContact.getEmail())) {
	            existingContact.setEmail(updatedContact.getEmail());
	        }
	        System.out.println(existingContact + " kişisi güncellendi.");
	    } else {
	        throw new NotFound(updatedContact.getName() + " " + updatedContact.getSurname() + " kişisi bulunamadı.");
	    }
	}


	
	public void callContact(Phone phone, String name, String surname, String phoneNumber) throws NotFound {
	    boolean contactExists = phone.getContactList().stream()
	            .anyMatch(contact -> contact.getName().equalsIgnoreCase(name)
	                    && contact.getSurname().equalsIgnoreCase(surname)
	                    || contact.getPhoneNumber().equalsIgnoreCase(phoneNumber));

	    if (contactExists) {
	        System.out.println("Arama yapılıyor..Çalıyor.");
	    } else {
	        throw new NotFound("Arama yapmak istediğiniz kişi bulunamadı.");
	    }
	}


    public void showStorageStatus() {
	 phones.stream()
     .map(phone -> "\nTelefon Marka: " + phone.getBrand() +
    		 "\nTelefon Model: " + phone.getModel()+
             "\nToplam depolama alanı: " + phone.getStorage() + " GB" +
             "\nKullanılan depolama alanı: " + (phone.getStorage() - phone.getFreeStorage()) + " GB" +
             "\nBoş depolama alanı: " + phone.getFreeStorage() + " GB")
     .forEach(System.out::println);
    }

    public void backup(Phone phone) {
    BackupFile.dataBackup(phone);
}
    
    public void restore(Phone phone) {
    BackupFile.dataRestore(phone);
}
    

    public void getContactsStartWithA(Phone phone) {
    	System.out.println(phone.getModel() + " Telefon rehberindeki -A- ile başlayan kişiler: ");
         phone.getContactList().stream()
        .filter(contact -> contact.getName().startsWith("A"))
        .map(contact -> contact.getName() + " " + contact.getSurname() + " - " + contact.getPhoneNumber())
        .forEach(System.out::println);

      }
    
    
}

















