package smartphoneManagementApp;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class Phone {

	private String brand;

	private String model;

	private final String serialNumber;

	private final int storage;
	
	private int freeStorage;

	private String operatingSystem;

	private List<App> appList;

	private List<Contact> contactList;

	public Phone(String brand, String model, int storage, String operatingSystem) {
		this.brand = brand;
		this.model = model;
		this.serialNumber = UUID.randomUUID().toString();
		this.storage = storage;
		this.freeStorage = storage;
		this.operatingSystem = operatingSystem;
		this.appList = new ArrayList<>();
		this.contactList = new ArrayList<>();
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getStorage() {
		return storage;
	}

	public int getFreeStorage() {
		return freeStorage;
	}

	public void setFreeStorage(int freeStorage) {
		this.freeStorage = freeStorage;
	}

	public String getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	public List<App> getAppList() {
		return appList;
	}

	public void setAppList(List<App> appList) {
		this.appList = appList;
	}

	public List<Contact> getContactList() {
		return contactList;
	}

	public void setContactList(List<Contact> contactList) {
		this.contactList = contactList;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	@Override
	public String toString() {
		return "Phone [brand=" + brand + ", model=" + model + ", serialNumber=" + serialNumber + ", storage=" + storage
				+ ", operatingSystem=" + operatingSystem + ", appList=" + appList + ", contactList=" + contactList
				+ "]";
	}

}
