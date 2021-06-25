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

	/**
	 * This method is used to add new car to database
	 * 
	 * @param carName
	 */
	public void addCar(String carName) {
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = ("INSERT INTO cars(available_cars)VALUES(?)");
			pst = connection.prepareStatement(sql);
			pst.setString(1, carName);
			pst.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			throw new DbException("Unable to add to Db");
		} finally {
			ConnectionUtil.close(pst, connection);
		}

	}

	/**
	 * This method is to remove car from database
	 * 
	 * @param carName
	 */
	public void removeCar(String carName) {
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = ("DELETE FROM cars WHERE available_cars=?");
			pst = connection.prepareStatement(sql);
			pst.setString(1, carName);
			pst.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DbException("Unable to remove from Db");
		} finally {
			ConnectionUtil.close(pst, connection);
		}

	}

	/**
	 * This method returns list of cars from database
	 * 
	 * @return
	 */
	public List<String> getAllCars() {
		Connection connection = null;
		PreparedStatement pst = null;
		List<String> listOfCars = new ArrayList<>();
		try {
			connection = ConnectionUtil.getConnection();
			String sql = ("SELECT available_cars FROM cars");
			pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String carName = rs.getString("available_cars");
				listOfCars.add(carName);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DbException("Unable to fetch data");
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return listOfCars;
	}
}
