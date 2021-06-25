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

public class ServiceCenterDao {

	/**
	 * This method is used to add new service centers to database
	 * 
	 * @param serviceCenter
	 */
	public void addServiceCenter(ServiceCenter serviceCenter) {
		Connection connection = null;
		PreparedStatement pst = null;

		try {
			connection = ConnectionUtil.getConnection();
			String sql = "INSERT INTO service_centers(center_name, location)VALUES(?,?)";
			pst = connection.prepareStatement(sql);
			pst.setString(1, serviceCenter.getCenterName());
			pst.setString(2, serviceCenter.getLocation());
			pst.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
			throw new DbException("Unable to add to database");
		} finally {
			ConnectionUtil.close(pst, connection);
		}

	}

	/**
	 * This method is used to remove service center from database
	 * 
	 * @param serviceCenter
	 */
	public void removeServiceCenter(ServiceCenter serviceCenter) {
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "DELETE FROM service_centers WHERE center_name=? AND location=?";
			pst = connection.prepareStatement(sql);
			pst.setString(1, serviceCenter.getCenterName());
			pst.setString(2, serviceCenter.getLocation());
			pst.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DbException("Cannot delete service center");
		} finally {
			ConnectionUtil.close(pst, connection);
		}
	}

	/**
	 * This method is used to get all service centers
	 * @return
	 */
	public List<ServiceCenter> getAllServiceCenters() {
		Connection connection = null;
		PreparedStatement pst = null;
		List<ServiceCenter> listOfServiceCenters = new ArrayList<>();
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "SELECT center_name, location FROM service_centers";
			pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String serviceCenter = rs.getString("center_name");
				String location = rs.getString("location");
				ServiceCenter newCenter = new ServiceCenter();
				newCenter.setCenterName(serviceCenter);
				newCenter.setLocation(location);
				listOfServiceCenters.add(newCenter);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DbException("Unable to get all service centers");
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return listOfServiceCenters;
	}

}
