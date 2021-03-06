<%@page import="in.vishnu.services.CarServices"%>
<%@page import="java.util.List"%>
<%@page import="in.vishnu.model.Service"%>
<!DOCTYPE>
<html lang="en">
<head>
<title>Car Service</title>
</head>
<body>
	<%
	String admin = (String) session.getAttribute("ADMIN");
	%>
	<%
	String user = (String) session.getAttribute("USER");
	%>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3 class="text-center">List of Services</h3>
		<%
		String infoMessage = request.getParameter("message");
		if (infoMessage != null) {
			out.println("<font color='green'>" + infoMessage + "</font>");
		}
		%>


		<table class="table table-striped">
			<caption>Available Services</caption>
			<thead class="thead-dark">
				<tr>
					<th scope="col">S.no</th>
					<th scope="col">Services</th>
					<th scope="col">Charge(in Rs)</th>
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody>
				<%
				List<Service> numberOfServices = CarServices.showAllServices();
				int i = 0;
				for (Service service : numberOfServices) {
					i++;
				%>

				<tr>
					<td><%=i%></td>
					<td><%=service.getServiceName()%></td>
					<td><%=service.getServiceCharge()%></td>
					<%
					if (admin == "admin") {
					%>
					<td><a
						href="DeleteServices?serviceName=<%=service.getServiceName()%>
						&serviceCharge=<%=service.getServiceCharge()%>"
						class="btn btn-danger">Delete</a></td>
					<%
					}
					%>
				</tr>
				
				<%
				}
				%>
			</tbody>
		</table>

	</main>
</body>

</html>
