package smartphoneManagementApp;

import java.util.List;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BackupFile {

	public static void dataBackup(Phone phone) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    String tarih = dateFormat.format(new Date());
	    
	    try (ObjectOutputStream appOutputStream = new ObjectOutputStream(new FileOutputStream("smartphone_applist.txt", true))) {
	        appOutputStream.writeObject(tarih + " - " + phone.getAppList());
	        System.out.println(phone.getModel() + " Applist verileri dosyaya kaydedildi.");
	    } catch (IOException e) {
	        System.out.println("Applist dosyasına yazma hatası: ");
	        e.printStackTrace();
	    }
	    
	    try (ObjectOutputStream contactOutputStream = new ObjectOutputStream(new FileOutputStream("smartphone_contactlist.txt", true))) {
	        contactOutputStream.writeObject(tarih + " - " + phone.getContactList());
	        System.out.println(phone.getModel() + " Contactlist verileri dosyaya kaydedildi.");
	    } catch (IOException e) {
	        System.out.println("Contactlist dosyasına yazma hatası: ");
	        e.printStackTrace();
	    }
	}
	
	public static void dataRestore(Phone phone) {
	    try (ObjectInputStream appInputStream = new ObjectInputStream(new FileInputStream("smartphone_applist.txt"))) {
	        Object object = appInputStream.readObject();
	        if (object instanceof List<?>) {
	            List<?> list = (List<?>) object;
	            if (!list.isEmpty() && list.get(0) instanceof App) {
	                List<App> appList = (List<App>) list;
	                phone.setAppList(appList);
	                System.out.println("Applist verileri geri yüklendi.");
	                System.out.println("Geri yüklenen App listesi:");
	                appList.forEach(app -> System.out.println(app));
	            } else {
	                System.out.println("Applist dosyasının içeriği beklenen formatta değil.");
	            }
	        } else {
	            System.out.println("Applist dosyasının içeriği beklenen formatta değil.");
	        }
	    } catch (IOException | ClassNotFoundException e) {
	        System.out.println("Applist dosyasını okuma hatası: ");
	        e.printStackTrace();
	    }
	    
	    try (ObjectInputStream contactInputStream = new ObjectInputStream(new FileInputStream("smartphone_contactlist.txt"))) {
	        Object object = contactInputStream.readObject();
	        if (object instanceof List<?>) {
	            List<?> list = (List<?>) object;
	            if (!list.isEmpty() && list.get(0) instanceof Contact) {
	                List<Contact> contactList = (List<Contact>) list;
	                phone.setContactList(contactList);
	                System.out.println("Applist verileri geri yüklendi.");
	                System.out.println("Geri yüklenen App listesi:");
	                contactList.forEach(contact -> System.out.println(contact));
	            } else {
	                System.out.println("Contactlist dosyasının içeriği beklenen formatta değil.");
	            }
	        } else {
	            System.out.println("Contactlist dosyasının içeriği beklenen formatta değil.");
	        }
	    } catch (IOException | ClassNotFoundException e) {
	        System.out.println("Contactlist dosyasını okuma hatası: ");
	        e.printStackTrace();
	    }
	    
	}


	
}