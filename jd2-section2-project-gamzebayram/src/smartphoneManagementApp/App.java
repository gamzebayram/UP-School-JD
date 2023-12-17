package smartphoneManagementApp;


public class App {

	private String appName;

	private String appVersion;

	private int appSize;
	

	public App(String appName, String appVersion, int appSize) {
		this.appName = appName;
		this.appVersion = appVersion;
		this.appSize = appSize;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getAppVersion() {
		return appVersion;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	public int getAppSize() {
		return appSize;
	}

	public void setAppSize(int appSize) {
		this.appSize = appSize;
	}
	
	
	@Override
	public String toString() {
		return "App [appName=" + appName + ", appVersion=" + appVersion + ", appSize=" + appSize + "]";
	}
	

}
