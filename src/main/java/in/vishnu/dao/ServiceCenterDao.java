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
	
	public void addServiceCenter(ServiceCenter serviceCenter ) {
		Connection connection;
		
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "insert into service_centers_db(center_name, location)values(?,?)";
			try (PreparedStatement pst = connection.prepareStatement(sql)) {
				pst.setString(1, serviceCenter.getCenterName());
				pst.setString(2, serviceCenter.getLocation());
				pst.executeUpdate();
			}
		} catch (ClassNotFoundException | SQLException e) {
						
			e.printStackTrace();
			throw new DbException("Unable to add");
		}
		
	}
	
	
	public void removeServiceCenter(ServiceCenter serviceCenter) {
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "delete from service_center_db where center_name=? AND location=?";
			pst = connection.prepareStatement(sql);
			pst.setString(1, serviceCenter.getCenterName());
			pst.setString(2, serviceCenter.getLocation());
			pst.executeUpdate();
		}catch(ClassNotFoundException | SQLException e){
			e.printStackTrace();
			throw new DbException("Cannot delete service center");
		}finally {
			ConnectionUtil.close(pst, connection);
		}		
	}
	
	public List<ServiceCenter> getAllServiceCenters() {
		List<ServiceCenter> listOfServiceCenters = new ArrayList<>();
		Connection connection;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select * from service_center_db";
			try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
				ResultSet rs = preparedStatement.executeQuery();
				while(rs.next()) {
					String serviceCenter = rs.getString("center_name");
					String location = rs.getString("location");
					ServiceCenter newCenter = new ServiceCenter(serviceCenter, location);
					listOfServiceCenters.add(newCenter);
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return listOfServiceCenters;
	}

}
