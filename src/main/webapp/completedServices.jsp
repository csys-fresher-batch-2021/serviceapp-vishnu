<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.util.List"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.temporal.ChronoUnit"%>
<%@page import="in.vishnu.model.UserBooking"%>
<%@page import="in.vishnu.services.BookingDetailsService"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>AXLEs</title>
</head>
<body class="text-center">
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>My bookings</h3>
		<h5>Completed bookings</h5>
		<%
		String sessionEmail = (String) session.getAttribute("sessionEmail");
		List<UserBooking> newList = BookingDetailsService.getCompletedServices(sessionEmail);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-YYYY");

		String ratedMessage = request.getParameter("ratedMessage");
		if (ratedMessage != null) {
			out.println("<font color='green'>" + ratedMessage + "</font>");
		}
		%>

		<table class="table table-hover">
			<caption>Completed Bookings</caption>
			<thead class="thead-dark">
				<tr>
					<th scope="col">Car</th>
					<th scope="col">Reg. No</th>
					<th scope="col">Service</th>
					<th scope="col">Charge</th>
					<th scope="col">Station</th>
					<th scope="col">Status</th>
					<th scope="col">Booking Date</th>
					<th scope="col">Delivery Date</th>
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
					<td><%=formatter.format(userBooking.getDate())%></td>
					<td><%=userBooking.getDeliveryDate()%></td>
					<td>
						<form action="OnRatingAction" method="get">
							<select name="rate">
								<option value="">Not rated</option>
								<option value="1">1 Star</option>
								<option value="2">2 Stars</option>
								<option value="3">3 Stars</option>
								<option value="4">4 Stars</option>
								<option value="5">5 Stars</option>
							</select> 
							<input type="hidden" name="center" value="<%=userBooking.getServiceCenter()%>">
								<%System.out.println(userBooking.getServiceCenter()); %> 
							<input type="hidden" name="bookingId" value="<%=userBooking.getBookingId()%>"> 
								<%System.out.println(userBooking.getBookingId()); %>
							<input type="hidden" name="centerId" value="<%=userBooking.getServiceCenterId()%>">
								<%System.out.println(userBooking.getServiceCenterId()); %> 
							
							<button type="submit" class="btn btn-primary">Submit</button>
						</form>
					</td>
				</tr>
			</tbody>
			<%
			}
			%>
		</table>
	</main>
</body>
</html>