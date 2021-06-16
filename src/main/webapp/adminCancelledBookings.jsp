<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="in.vishnu.model.UserBooking"%>
<%@page import="in.vishnu.services.BookingDetailsService"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Cancelled Services</title>
</head>
<body class="text-center">

	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">

		<h3>List of Cancelled Bookings</h3>
		<%
		String admin = (String) session.getAttribute("ADMIN");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-YYYY");
		%>
		<table class="table table-striped">
			<caption>Available Services</caption>
			<thead class="thead-dark">
				<tr>
					<th scope="col">ID</th>
					<th scope="col">EMAIL</th>
					<th scope="col">CAR</th>
					<th scope="col">REG.NO</th>
					<th scope="col">SERVICE</th>
					<th scope="col">STATION</th>
					<th scope="col">STATUS</th>
					<th scope="col">BOOKING DATE</th>
					<th scope="col">BOOKING TIME</th>
				</tr>
			</thead>
			<tbody>
				<%
				List<ArrayList<String>> listOfBookings = BookingDetailsService.showAllUserBookings();

				for (ArrayList<String> bookings : listOfBookings) {
					if (bookings.get(6).equals("CANCELLED")) {
				%>

				<tr>
					<td><%=bookings.get(0)%></td>
					<td><%=bookings.get(1)%></td>
					<td><%=bookings.get(2)%></td>
					<td><%=bookings.get(3)%></td>
					<td><%=bookings.get(4)%></td>
					<td><%=bookings.get(5)%></td>
					<td><%=bookings.get(6)%></td>
					<td><%=formatter.format(LocalDate.parse(bookings.get(7)))%></td>
					<td><%=bookings.get(8)%></td>
			</tbody>
			<%
			}
			}
			%>
		</table>
	</main>
</body>
</html>