package in.vishnu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import in.vishnu.exception.DbException;
import in.vishnu.model.BookingDetails;
import in.vishnu.model.UserBooking;
import in.vishnu.util.ConnectionUtil;

public class BookingDetailsDAO {

	/**
	 * This method is used to add booking details to Database
	 * 
	 * @param booking
	 */
	public void addBookingDetails(BookingDetails booking) {
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "INSERT INTO booking_details(booking_id, email_id, car_name, "
					+ "registration_no, service_type, service_center, booking_status, delivery_date)VALUES(DEFAULT, ?,?,?,?,?,?,?)";
			pst = connection.prepareStatement(sql);
			pst.setString(1, booking.getEmailId());
			pst.setString(2, booking.getCarName());
			pst.setString(3, booking.getRegistrationNumber());
			pst.setString(4, booking.getServiceType());
			pst.setString(5, booking.getServiceCenter());
			pst.setString(6, "CONFIRMED");
			pst.setString(7,"IN PROGRESS");
			pst.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DbException("Unable to add to Db");
		} finally {
			ConnectionUtil.close(pst, connection);
		}
	}

	/**
	 * This method is used to fetch all booking details for user
	 * 
	 * @param sessionEmail
	 * @return
	 */
	public List<UserBooking> getBookingDetails(String sessionEmail) {
		Connection connection1 = null;
		PreparedStatement pst1 = null;
		List<UserBooking> newList = new ArrayList<>();
		try {
			connection1 = ConnectionUtil.getConnection();
			String sql = "SELECT  booking_id, car_name, registration_no, service_type, "
					+ "services.service_charge as charge, service_centers.id as service_center_id, "
					+ "service_center, booking_status, booking_date, delivery_date FROM booking_details "
					+ "INNER JOIN services ON booking_details.service_type = services.service_name "
					+ "INNER JOIN service_centers ON SPLIT_PART(booking_details.service_center,',',1)"
					+ " LIKE service_centers.center_name "
					+ "WHERE email_id=? ORDER BY booking_id ASC";

			pst1 = connection1.prepareStatement(sql);
			pst1.setString(1, sessionEmail);
			ResultSet rs = pst1.executeQuery();
			while (rs.next()) {
				UserBooking newBooking = new UserBooking();
				newBooking.setBookingId(rs.getInt("booking_id"));
				newBooking.setCarName(rs.getString("car_name"));
				newBooking.setRegistrationNumber(rs.getString("registration_no"));
				newBooking.setServiceType(rs.getString("service_type"));
				newBooking.setServiceCharge(rs.getInt("charge"));
				newBooking.setServiceCenterId(rs.getInt("service_center_id"));
				newBooking.setServiceCenter(rs.getString("service_center"));
				newBooking.setBookingStatus(rs.getString("booking_status"));
				newBooking.setDate(rs.getDate("booking_date").toLocalDate());
				newBooking.setDeliveryDate(rs.getString("delivery_date"));
				newList.add(newBooking);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DbException("Unable to fetch required details from Db");
		} finally {
			ConnectionUtil.close(pst1, connection1);
		}
		return newList;
	}

	/**
	 * This method is used to get all booking details for admin
	 * 
	 * @return
	 */
	public List<ArrayList<String>> getAllBookingDetail() {

		List<ArrayList<String>> listOfBookings = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "SELECT booking_id, email_id, car_name, registration_no, service_type, "
					+ "service_center, booking_status, booking_date, booking_time, delivery_date "
					+ " FROM booking_details ORDER BY booking_id DESC";
			pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String id = String.valueOf(rs.getInt("booking_id"));
				String email = rs.getString("email_id");
				String car = rs.getString("car_name");
				String regNo = rs.getString("registration_no");
				String service = rs.getString("service_type");
				String serviceCenter = rs.getString("service_center");
				String status = rs.getString("booking_status");
				String date = rs.getDate("booking_date").toLocalDate().toString();
				String time = rs.getTime("booking_time").toLocalTime().toString();
				String deliveryDate = rs.getString("delivery_date");
				ArrayList<String> valuesList = new ArrayList<>();
				valuesList.add(id);
				valuesList.add(email);
				valuesList.add(car);
				valuesList.add(regNo);
				valuesList.add(service);
				valuesList.add(serviceCenter);
				valuesList.add(status);
				valuesList.add(date);
				valuesList.add(time);
				valuesList.add(deliveryDate);
				listOfBookings.add(valuesList);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DbException("Unable to fetch data from db");
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return listOfBookings;
	}

	/**
	 * This method is to update booking status
	 * 
	 * @param carName
	 * @param serviceSelected
	 * @param status
	 * @param regNo
	 */
	public void updateBookingStatus(String carName, String serviceSelected, String status, String regNo) {
		status = status.toUpperCase();
		carName = carName.toUpperCase();
		serviceSelected = serviceSelected.toUpperCase();
		regNo = regNo.toUpperCase();
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "UPDATE booking_details SET booking_status=?"
					+ " WHERE car_name=? AND service_type=? AND registration_no=?";
			pst = connection.prepareStatement(sql);
			pst.setString(1, status);
			pst.setString(2, carName);
			pst.setString(3, serviceSelected);
			pst.setString(4, regNo);
			pst.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DbException("Unable to update");
		} finally {
			ConnectionUtil.close(pst, connection);
		}

	}

	/**
	 * This method is to update delivery date
	 * 
	 * @param deliveryDate
	 * @param bookingId
	 */
	public void updateDeliveryDate(String deliveryDate, int bookingId) {
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "UPDATE booking_details SET delivery_date = ? WHERE booking_id = ?";
			pst = connection.prepareStatement(sql);
			pst.setString(1, deliveryDate);
			pst.setInt(2, bookingId);
			pst.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DbException("Unable to update delivery date");
		} finally {
			ConnectionUtil.close(pst, connection);
		}

	}

}
