package in.vishnu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.vishnu.exception.DbException;
import in.vishnu.model.Service;
import in.vishnu.util.ConnectionUtil;

public class ServicesDAO {

	/**
	 * This method is used for new service details to Database
	 * 
	 * @param services
	 */
	public void addService(Service services) {
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "INSERT INTO services(service_id, service_name, service_charge)"
					+ "VALUES(NEXTVAL('service_id_sequence'),?,?)";
			pst = connection.prepareStatement(sql);
			pst.setString(1, services.getServiceName());
			pst.setInt(2, services.getServiceCharge());
			pst.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DbException("Unable to add data to db");
		} finally {
			ConnectionUtil.close(pst, connection);
		}
	}

	/**
	 * This method is used to get all services from database
	 * 
	 * @return
	 */
	public List<Service> getAllServices() {
		List<Service> listOfServices = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "SELECT service_name, service_charge FROM services";
			pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String serviceName = rs.getString("service_name");
				int serviceCharge = rs.getInt("service_charge");
				Service newService = new Service(serviceName, serviceCharge);
				listOfServices.add(newService);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DbException("Unable to fetch data from db");
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return listOfServices;
	}

	/**
	 * This method is used to remove service from database
	 * 
	 * @param service
	 */
	public void removeService(Service service) {
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "DELETE FROM services WHERE service_name=? AND service_charge=?";
			pst = connection.prepareStatement(sql);
			pst.setString(1, service.getServiceName());
			pst.setInt(2, service.getServiceCharge());
			pst.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DbException("Cannot delete service from db");
		} finally {
			ConnectionUtil.close(pst, connection);
		}
	}

	/**
	 * This method is used to get service charge from database
	 * 
	 * @param serviceType
	 * @return
	 */
	public int getServiceCharge(String serviceType) {
		Connection connection = null;
		PreparedStatement pst = null;
		int serviceCharge = 0;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "SELECT service_charge FROM services WHERE service_name=?";
			pst = connection.prepareStatement(sql);
			pst.setString(1, serviceType);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int charge = rs.getInt("service_charge");
				serviceCharge += charge;
				break;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DbException("Unable to fetch data from db");
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return serviceCharge;
	}
}
