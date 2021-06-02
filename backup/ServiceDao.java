package in.vishnu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.vishnu.exception.DbException;
import in.vishnu.util.ConnectionUtil;

public class ServiceDao {
	
	public void addService(String serviceName) {
		Connection connection;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "insert into services(available_services)values(?)";
			try (PreparedStatement preparedStatement = connection.prepareStatement(sql) ) {
				preparedStatement.setString(1, serviceName);
				preparedStatement.executeUpdate();
			}
		} catch (ClassNotFoundException | SQLException e) {
						
			e.printStackTrace();
			throw new DbException("Unable to add");
			
		}
		
	}
	
	public List<String> displayService() {
		List<String> serviceList = new ArrayList<>();
		Connection connection;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select * from services";
			try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
				ResultSet rs = preparedStatement.executeQuery();
				while(rs.next()) {
					String serviceName = rs.getString("available_services");
					serviceList.add(serviceName);
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
			throw new DbException("Unable to fetch data");
		}
		return serviceList;
	}
	
	
	public void removeService(String serviceName) {
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "delete from services where available_services=?";
			pst = connection.prepareStatement(sql);
			pst.setString(1, serviceName);
			pst.executeUpdate();
		}catch(ClassNotFoundException | SQLException e){
			e.printStackTrace();
			throw new DbException("Cannot delete service");
		}finally {
			ConnectionUtil.close(pst, connection);
		}		
	}
	
	public List<String> getAllServices() {
		List<String> listOfServices = new ArrayList<>();
		Connection connection;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select * from services";
			try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
				ResultSet rs = preparedStatement.executeQuery();
				while(rs.next()) {
					String serviceName = rs.getString("available_services");
					listOfServices.add(serviceName);
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return listOfServices;
	}
}
