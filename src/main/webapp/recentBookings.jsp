<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="in.vishnu.model.UserBooking"%>
<%@page import="in.vishnu.services.BookingDetailsService"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>My bookings</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid"></main>
	<h3 class="text-center">My bookings</h3>
	<h5>Recent bookings</h5>
	<p>Bookings shown only for two days</p>
	<%
	String sessionEmail = (String) session.getAttribute("sessionEmail");
	List<UserBooking> newList = BookingDetailsService.getRecentBooking(sessionEmail);
	%>
	<form>
		<table class="table table-hover">
			<caption>My Recent Bookings</caption>
			<thead>
				<tr>
					<th scope="col">Car</th>
					<th scope="col">Reg. No</th>
					<th scope="col">Service</th>
					<th scope="col">Charge</th>
					<th scope="col">Station</th>
					<th scope="col">Status</th>
					<th scope="col">Date</th>
					<th scope="col"></th>
				</tr>
			</thead>
			<%
			for (UserBooking userBooking : newList) {
			%>
			<tbody>
				<tr>
					<td><%=userBooking.getCarName()%></td>
					<td><%=userBooking.getRegistrationNumber()%></td>
					<td><%=userBooking.getServiceType()%></td>
					<td><%=userBooking.getServiceCharge()%></td>
					<td><%=userBooking.getServiceCenter()%></td>
					<td><%=userBooking.getBookingStatus()%></td>
					<td><%=userBooking.getDate()%></td>
					<td><a
						href="UpdateBookingStatus?serviceType=<%=userBooking.getServiceType()%>
						&regNum=<%=userBooking.getRegistrationNumber()%>
						&carName=<%=userBooking.getCarName()%>
						&status=CANCELLED"
						class="btn btn-danger">Cancel</a></td>
				</tr>
			</tbody>
			<%
			}
			%>
		</table>
	</form>



</body>
</html>