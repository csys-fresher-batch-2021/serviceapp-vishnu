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
	 * This method is used to update five star ratings
	 * 
	 * @param centerName
	 */
	public void updateFiveStarRating(String centerName) {
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "UPDATE service_centers_db SET five_star=five_star+1 WHERE center_name = ?";
			pst = connection.prepareStatement(sql);
			pst.setString(1, centerName);
			pst.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DbException("Unable to update");
		} finally {
			ConnectionUtil.close(pst, connection);
		}

	}

	/**
	 * This method is used to update four star rating
	 * 
	 * @param centerName
	 */
	public void updateFourStarRating(String centerName) {
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "UPDATE service_centers_db SET four_star=four_star+1 WHERE center_name = ?";
			pst = connection.prepareStatement(sql);
			pst.setString(1, centerName);
			pst.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DbException("Unable to rate");
		} finally {
			ConnectionUtil.close(pst, connection);
		}

	}

	/**
	 * This method is used to update three star rating
	 * 
	 * @param centerName
	 */
	public void updateThreeStarRating(String centerName) {
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "UPDATE service_centers_db SET three_star=three_star+1 WHERE center_name = ?";
			pst = connection.prepareStatement(sql);
			pst.setString(1, centerName);
			pst.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DbException("Unable to update three star");
		} finally {
			ConnectionUtil.close(pst, connection);
		}

	}

	/**
	 * This method is used to update two star rating
	 * 
	 * @param centerName
	 */
	public void updateTwoStarRating(String centerName) {
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "UPDATE service_centers_db SET two_star=two_star+1 WHERE center_name = ?";
			pst = connection.prepareStatement(sql);
			pst.setString(1, centerName);
			pst.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DbException("Unable to update two star");
		} finally {
			ConnectionUtil.close(pst, connection);
		}

	}

	/**
	 * This method is used to update one star rating
	 * 
	 * @param centerName
	 */
	public void updateOneStarRating(String centerName) {
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "UPDATE service_centers_db SET one_star=one_star+1 WHERE center_name = ?";
			pst = connection.prepareStatement(sql);
			pst.setString(1, centerName);
			pst.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DbException("Unable to update");
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
			String sql = "SELECT center_name, location, (five_star*5+four_star*4+three_star*3+two_star*2+one_star)"
					+ "/(five_star+four_star+three_star+two_star+one_star)"
					+ "AS rating, (five_star+four_star+three_star+two_star+one_star) AS responses "
					+ "FROM service_centers_db ORDER BY rating DESC";
			pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String serviceCenter = rs.getString("center_name");
				String location = rs.getString("location");
				float rating = rs.getFloat("rating");
				int responses = rs.getInt("responses");
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
