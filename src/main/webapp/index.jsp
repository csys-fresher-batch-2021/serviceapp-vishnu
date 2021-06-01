<%@page import="in.vishnu.services.Cars"%>
<%@page import="in.vishnu.services.CarServices"%>

<%@page import="java.util.List"%>
<!DOCTYPE>
<html lang="en">
<head>
<title>Car Services App</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Quick Book</h3>
		<form action="SelectServiceCenter" method="post">
		
		<label >Select your car:</label>
		<select name="cars" required>
		<option value="">Not selected</option>
		<%List<String> carList = Cars.showCars();
		
		for(String car: carList){
			
		
		%>
		<option value="<%=car%>"><%=car%></option>
		<%} %>
		</select>
		<br>
		
		<label>Select your service:</label>
		<select name="services" required>
		<option value="">Not selected</option>
		<%List<String> serviceList = CarServices.getServices();
		
		for(String service: serviceList){
			
		
		%>
		<option value="<%=service%>"><%=service%></option>
		<%}%>
		</select>
		<br>
		<label>Enter vehicle Registration number:</label>
		<input type ="text" name="regno" placeholder="TN-03-AP-3333" required>
		<br>
		<button type="submit">Book Now</button>
		
		</form>

	</main>
</body>
</html>
