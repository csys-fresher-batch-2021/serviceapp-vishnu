package in.vishnu.model;

public class ServiceCenter {
	private String centerName;
	private String location;
	public ServiceCenter() {
		super();
		
	}
	public ServiceCenter(String centerName, String location) {
		super();
		this.centerName = centerName;
		this.location = location;
	}
	public String getCenterName() {
		return centerName;
	}
	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "ServiceCenter [centerName=" + centerName + ", location=" + location + "]";
	}
	
	

}
