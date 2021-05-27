<%@page import="in.vishnu.services.CarServices"%>
<%@page import="java.util.List"%>
<!DOCTYPE>
<html lang="en">
<head>
<title>Car Service</title>
</head>
<body>
	<%String admin = (String)session.getAttribute("ADMIN"); %>
	<%String user = (String)session.getAttribute("USER"); %>
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
					<%if(user=="user") {%>
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
					<%if(user=="user"){ %>
					<td><button type="submit">Book Now</button></td>
						<%} %>
						<%if(admin=="admin"){ %>				
					<td><a href="DeleteServices?serviceName=<%=service %>" class="btn btn-danger">Delete</a></td>
					<%} %>
				</tr>

				<%
				}
				%>
			</tbody>
		</table>
		<%if(admin=="admin"){ %>
		<a href="addServices.jsp">Add new service</a>
		<%} %>
	</main>
</body>

</html>
