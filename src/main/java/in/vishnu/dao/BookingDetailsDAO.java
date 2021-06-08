package in.vishnu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;

import in.vishnu.exception.DbException;
import in.vishnu.model.BookingDetails;

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
					+ "registration_no, service_type, service_center, booking_status)"
					+ "VALUES(NEXTVAL('booking_id_sequence'), ?,?,?,?,?,'CONFIRMED')";
			pst = connection.prepareStatement(sql);
			pst.setString(1, booking.getEmailId());
			pst.setString(2, booking.getCarName());
			pst.setString(3, booking.getRegistrationNumber());
			pst.setString(4, booking.getServiceType());
			pst.setString(5, booking.getServiceCenter());
			pst.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DbException("Unable to add to Db");
		} finally {
			ConnectionUtil.close(pst, connection);
		}
	}

}
