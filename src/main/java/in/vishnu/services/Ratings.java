package in.vishnu.services;

import java.util.List;
import in.vishnu.dao.RatingDAO;
import in.vishnu.model.ServiceCenter;

public class Ratings {
	private Ratings() {
	}

	/**
	 * This method is used to update ratings
	 * 
	 * @param rating
	 * @param center
	 * @return
	 */
	public static boolean updateRating(int centerId, int bookingId, int rating) {
		boolean isDone = false;
		RatingDAO dao = new RatingDAO();
		dao.updateRating(centerId, bookingId, rating);
		isDone = true;
		return isDone;
	}

	/**
	 * This method is used to get all service centers and their ratings
	 * 
	 * @return List of services centers
	 *
	 */
	public static List<ServiceCenter> getRatings() {
		RatingDAO dao = new RatingDAO();
		return dao.getAllServiceCentersRating();
	}
}
