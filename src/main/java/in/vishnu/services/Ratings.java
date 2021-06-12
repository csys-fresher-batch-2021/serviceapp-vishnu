package in.vishnu.services;

import java.util.List;

import in.vishnu.dao.RatingDAO;
import in.vishnu.exception.ServiceException;
import in.vishnu.model.ServiceCenter;

public class Ratings {
	private Ratings() {
	}

	/**
	 * This method is used to update ratings
	 * @param rating
	 * @param center
	 * @return
	 */
	public static boolean updateRating(int rating, String center) {
		boolean isDone = false;
		String[] temp = center.split(",", 2);
		center = temp[0];
		RatingDAO dao = new RatingDAO();
		try {
			if (rating >= 1 && rating <= 5) {
				if (rating == 5) {
					dao.updateFiveStarRating(center);
					isDone = true;
				} else if (rating == 4) {
					dao.updateFourStarRating(center);
					isDone = true;
				} else if (rating == 3) {
					dao.updateThreeStarRating(center);
					isDone = true;
				} else if (rating == 2) {
					dao.updateTwoStarRating(center);
					isDone = true;
				} else {
					dao.updateOneStarRating(center);
					isDone = true;
				}
			}
		} catch (ServiceException e) {
			e.printStackTrace();
			throw new ServiceException("Unable to update");
		}
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
