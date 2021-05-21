<%@page import="in.vishnu.services.CarServices"%>
<%@page import="java.util.List"%>
<!DOCTYPE>
<html lang="en">
<head>
<title>Car Service</title>
</head>
<body>
	<%String role = (String)session.getAttribute("ROLE"); %>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>List of Services</h3>
		<%String infoMessage = request.getParameter("message");
		if (infoMessage != null) {
			out.println("<font color='green'>" + infoMessage + "</font>");
		}
		%>
		<table class="table table-bordered">
			<caption>Available Services</caption>
			<thead>
				<tr>
					<th scope="col">S.no</th>
					<th scope="col">Services</th>
					<%if(role=="user") {%>
					<th scope="col">Quick Book</th>
					<%} %>
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody>
				<%
				List<String> numberOfServices = CarServices.getServices();
				int i = 0;
				for (String service : numberOfServices) {
					i++;
				%>

				<tr>
					<td><%=i%></td>
					<td><%=service%></td>
					<%if(role=="user"){ %>
					<td><button type="submit">Book Now</button></td>
						<%} %>				
					<td><a href="DeleteServices?serviceName=<%=service %>" class="btn btn-danger">Delete</a></td>
				</tr>

				<%
				}
				%>
			</tbody>
		</table>
		<a href="addServices.jsp">Add new service</a>
	</main>
</body>

</html>
