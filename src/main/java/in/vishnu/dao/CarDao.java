package in.vishnu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.vishnu.exception.DbException;
import in.vishnu.util.ConnectionUtil;

public class CarDao {

	public void addCar(String carName) {
		Connection connection = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = ("insert into cars(available_cars)values(?)");
			try (PreparedStatement pst = connection.prepareStatement(sql)) {
				pst.setString(1, carName);
				pst.executeUpdate();
			} 
		} catch (ClassNotFoundException | SQLException e) {
			throw new DbException("unable to add");
		}
		
	}

	public void removeCar(String carName) {
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = ("delete from cars where available_cars=?");
			pst = connection.prepareStatement(sql);
			pst.setString(1, carName);
			pst.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DbException("Unable to remove");
		} finally {
			ConnectionUtil.close(pst, connection);
		}

	}

	public List<String> displayCars() {
		Connection connection = null;
		List<String> carList = new ArrayList<>();
		try {
			connection = ConnectionUtil.getConnection();
			String sql = ("select * from cars");
			try (PreparedStatement pst = connection.prepareStatement(sql)) {
				ResultSet rs = pst.executeQuery();
				while (rs.next()) {
					String carName = rs.getString("available_cars");
					carList.add(carName);
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DbException("Unable to fetch data");
		}
		return carList;
	}

	public List<String> getAllCars() {
		Connection connection = null;
		List<String> listOfCars = new ArrayList<>();
		try {
			connection = ConnectionUtil.getConnection();
			String sql = ("select * from cars");
			try (PreparedStatement pst = connection.prepareStatement(sql)) {
				ResultSet rs = pst.executeQuery();
				while (rs.next()) {
					String carName = rs.getString("available_cars");
					listOfCars.add(carName);
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DbException("Unable to fetch data");
		}
		return listOfCars;
	}
}
