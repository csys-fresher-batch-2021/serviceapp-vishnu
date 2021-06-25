package in.vishnu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.vishnu.exception.DbException;
import in.vishnu.model.ServiceCenter;
import in.vishnu.util.ConnectionUtil;

public class RatingDAO {

	/**
	 * This method is used to update rating
	 * 
	 * @param centerId
	 * @param bookingId
	 * @param rating
	 */
	public void updateRating(int centerId, int bookingId, int rating) {
		Connection connection = null;
		PreparedStatement pst = null;

		try {
			connection = ConnectionUtil.getConnection();
			String sql = "INSERT INTO service_ratings(id, service_center_id, booking_detail_id,"
					+ "rating, created_date)VALUES(DEFAULT,?,?,?,DEFAULT)";
			pst = connection.prepareStatement(sql);
			pst.setInt(1, centerId);
			pst.setInt(2, bookingId);
			pst.setInt(3, rating);
			pst.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			throw new DbException("Unable to update rating");
		} finally {
			ConnectionUtil.close(pst, connection);
		}
	}

	/**
	 * This method is used to get all service centers from database
	 * 
	 * @return
	 */
	public List<ServiceCenter> getAllServiceCentersRating() {
		Connection connection = null;
		PreparedStatement pst = null;
		List<ServiceCenter> listOfServiceCenters = new ArrayList<>();
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select sc.*, avg(rating)::numeric(10,1) as ratings, count(rating) as no_of_ratings\r\n"
					+ "from service_centers sc, service_ratings sr\r\n" + "where sc.id = sr.service_center_id \r\n"
					+ "group by sr.service_center_id, sc.id order by ratings DESC;";
			pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String serviceCenter = rs.getString("center_name");
				String location = rs.getString("location");
				float rating = rs.getFloat("ratings");
				int responses = rs.getInt("no_of_ratings");
				ServiceCenter newCenter = new ServiceCenter(serviceCenter, location, rating, responses);
				listOfServiceCenters.add(newCenter);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DbException("Unable to get all ratings");
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return listOfServiceCenters;
	}

}
