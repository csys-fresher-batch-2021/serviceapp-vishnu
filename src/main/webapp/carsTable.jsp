<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List"%>
    <%@page import="in.vishnu.services.Cars" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Cars</title>
</head>
<body>
<%String admin = (String)session.getAttribute("ADMIN"); %>
	<%String user = (String)session.getAttribute("USER"); %>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>List of Services</h3>
		
		
		<%String infoMessage = request.getParameter("carDeletedMsg");
		if (infoMessage != null) {
			out.println("<font color='green'>" + infoMessage + "</font>");
		}
		
		String errorMessage = request.getParameter("carNotDeletedMsg");
		if(errorMessage != null){
			out.println("<font color='red'>" +errorMessage +"</font>");
		}
		%>
		
		
		<table class="table table-bordered">
			<caption>Available cars</caption>
			<thead>
				<tr>
					<th scope="col">S.no</th>
					<th scope="col">cars</th>
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody>
				<%
				List<String> availableCars = Cars.showCars();
				int i = 0;
				for (String car : availableCars) {
					i++;
				%>

				<tr>
					<td><%=i%></td>
					<td><%=car%></td>
						<%if(admin=="admin"){ %>				
					<td><a href="DeleteCarServlet?carName=<%=car %>" class="btn btn-danger">Delete</a></td>
					<%} %>
				</tr>

				<%
				}
				%>
			</tbody>
		</table>
		
	</main>

</body>
</html>