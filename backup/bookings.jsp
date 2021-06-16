<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="in.vishnu.model.UserBooking"%>
<%@page import="in.vishnu.services.BookingDetailsService"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>AXLES</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid"></main>

	<%
	String admin = (String) session.getAttribute("ADMIN");
	%>
	<form>
		<table class="table table-hover">
			<caption>Available Services</caption>
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">EMAIL</th>
					<th scope="col">CAR</th>
					<th scope="col">REG.NO</th>
					<th scope="col">SERVICE</th>
					<th scope="col">STATION</th>
					<th scope="col">STATUS</th>
					<th scope="col">DATE</th>
					<th scope="col">TIME</th>
				</tr>
			</thead>
			<tbody>
				<%
				List<ArrayList<String>> listOfBookings = BookingDetailsService.showAllUserBookings();

				for (ArrayList<String> bookings : listOfBookings) {
				%>

				<tr>
					<td><%=bookings.get(0)%></td>
					<td><%=bookings.get(1)%></td>
					<td><%=bookings.get(2)%></td>
					<td><%=bookings.get(3)%></td>
					<td><%=bookings.get(4)%></td>
					<td><%=bookings.get(5)%></td>
					<td><%=bookings.get(6)%></td>
					<td><%=bookings.get(7)%></td>
					<td><%=bookings.get(8)%></td>
					<%
					if (admin == "admin") {
					%>
					<td><a
						href="UpdateBookingStatus?serviceType=<%=bookings.get(4)%>
						&regNum=<%=bookings.get(3)%>
						&carName=<%=bookings.get(2)%>
						&status=COMPLETED"
						class="btn btn-danger">DONE</a></td>
					<%
					}
					%>
				</tr>

				<%
				}
				%>
			</tbody>
		</table>
	</form>

</body>
</html>