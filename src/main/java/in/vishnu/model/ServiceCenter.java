package in.vishnu.model;

public class ServiceCenter {
	private String centerName;
	private String location;
	private float rating;
	private int reponses;

	public ServiceCenter() {
		super();
	}

	public ServiceCenter(String centerName, String location, float rating, int reponses) {
		super();
		this.centerName = centerName;
		this.location = location;
		this.rating = rating;
		this.reponses = reponses;
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

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public int getReponses() {
		return reponses;
	}

	public void setReponses(int reponses) {
		this.reponses = reponses;
	}

	@Override
	public String toString() {
		return "ServiceCenter [centerName=" + centerName + ", location=" + location + ", rating=" + rating
				+ ", reponses=" + reponses + "]";
	}

}
