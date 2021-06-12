package in.vishnu.model;

public class Service {

	private String serviceName;
	private int serviceCharge;

	public Service() {
		super();

	}

	public Service(String serviceName, int serviceCharge) {
		super();
		this.serviceName = serviceName;
		this.serviceCharge = serviceCharge;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public int getServiceCharge() {
		return serviceCharge;
	}

	public void setServiceCharge(int serviceCharge) {
		this.serviceCharge = serviceCharge;
	}

	@Override
	public String toString() {
		return "Service [serviceId=" + ", serviceName=" + serviceName + ", serviceCharge=" + serviceCharge + "]";
	}

}
