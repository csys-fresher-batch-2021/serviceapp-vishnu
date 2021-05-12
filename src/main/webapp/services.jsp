<%@page import="in.vishnu.services.DisplayServices"%>
<%@page import="java.util.List"%>
<!DOCTYPE>
<html lang="en">
<head>
<title>Car Service</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>List of Services</h3>
		<table class = "table table-bordered">
		<caption>Available Services</caption>
		<thead>
		<tr><th scope = "col">S.no</th> <th scope = "col">Services</th> <th scope = "col">Quick Book</th> </tr>
		</thead>
		<tbody>
		<% List<String> numberOfServices = DisplayServices.getServices();
		int i=0;
		for(String service: numberOfServices){
			i++;
		 %>
		 
		 <tr>
		 	<td><%=i %> </td><td><%=service %></td>
		 	<td><button type="submit">Book Now</button></td>
		 </tr>
		 
		<%} %>
		</tbody>
		</table>
	</main>
</body>

</html>
