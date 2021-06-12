<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="in.vishnu.model.UserBooking"%>
<%@page import="in.vishnu.services.BookingDetailsService"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>AXLEs</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid"></main>
	<h3>My bookings</h3>
	<h5>Cancelled bookings</h5>
	<%
	String sessionEmail = (String) session.getAttribute("sessionEmail");
	List<UserBooking> newList = BookingDetailsService.getCancelledServices(sessionEmail);
	%>
	<form>
		<table class="table table-hover">
			<caption>Cancelled Bookings</caption>
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
				</tr>
			</tbody>
			<%
			}
			%>
		</table>
	</form>
</body>
</html>