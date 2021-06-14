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
	<h5>Completed bookings</h5>
	<%
	String sessionEmail = (String) session.getAttribute("sessionEmail");
	List<UserBooking> newList = BookingDetailsService.getCompletedServices(sessionEmail);

	String ratedMessage = request.getParameter("ratedMessage");
	if (ratedMessage != null) {
		out.println("<font color='green'>" + ratedMessage + "</font>");
	}
	%>

	<table class="table table-hover">
		<caption>Completed Bookings</caption>
		<thead>
			<tr>
				<th scope="col">Car</th>
				<th scope="col">Reg. No</th>
				<th scope="col">Service</th>
				<th scope="col">Charge</th>
				<th scope="col">Station</th>
				<th scope="col">Status</th>
				<th scope="col">Date</th>
				<th scope="col">Rate Your Service(?/5)</th>
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
				<td>
					<form action="OnRatingAction" method="get">
						<select name="rate">
							<option value="">Not rated</option>
							<option value="1">1 Star</option>
							<option value="2">2 Stars</option>
							<option value="3">3 Stars</option>
							<option value="4">4 Stars</option>
							<option value="5">5 Stars</option>
						</select> <input type="hidden" name="center"
							value="<%=userBooking.getServiceCenter()%>">
						<button type="submit" class="btn btn-primary">Submit</button>
					</form>
				</td>

			</tr>
		</tbody>
		<%
		}
		%>
	</table>

</body>
</html>