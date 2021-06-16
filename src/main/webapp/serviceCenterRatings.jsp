<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="in.vishnu.model.ServiceCenter"%>
<%@page import="in.vishnu.services.Ratings"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Axles-car services</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3 class="text-center">Service Centers</h3>
		<table class="table table-hover">
			<caption>Service Centers</caption>
			<thead class="thead-dark">
				<tr>
					<th scope="col">S.NO</th>
					<th scope="col">NAME</th>
					<th scope="col">LOCATION</th>
					<th scope="col">RATING (Stars)</th>
					<th scope="col">NO OF VOTES</th>
				</tr>
			</thead>
			<%
			List<ServiceCenter> centerList = Ratings.getRatings();
			int i = 0;
			for (ServiceCenter listItem : centerList) {
				i++;
			%>
			<tbody>
				<tr>
					<td><%=i%></td>
					<td><%=listItem.getCenterName()%></td>
					<td><%=listItem.getLocation()%></td>
					<td><%=listItem.getRating()%></td>
					<td><%=listItem.getReponses()%></td>
				</tr>
			</tbody>
			<%
			}
			%>

		</table>
		<h6>Popular service center shown first</h6>

	</main>
</body>
</html>