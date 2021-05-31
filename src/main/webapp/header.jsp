<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/fontawesome.min.css">
<link rel="stylesheet" href="assets/css/style.css">

<%String role = (String) session.getAttribute("ADMIN"); %>
<%String user = (String)session.getAttribute("USER"); %>

<header>
	<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
		<a class="navbar-brand" href="StartPage.jsp">AXLES</a>
		<button class="navbar-toggler d-lg-none" type="button"
			data-toggle="collapse" data-target="#collapsibleNavId"
			aria-controls="collapsibleNavId" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="collapsibleNavId">
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
			<%if(user!=null){ %>
				<li class="nav-item active"><a class="nav-link"
					href="index.jsp">Home <span class="sr-only">(current)</span></a></li>
				<%} %>	
					<%if(role!=null && user==null){ %>
				<li class="nav-item"><a class="nav-link" href="services.jsp">Services</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="serviceCenters.jsp">Service Centers</a>
				</li>
				<%} %>
				
			</ul>
			<%if(role==null && user==null ){ %>
			<ul class="navbar-nav ml-auto mt-2 mt-lg-0">
				<li class="nav-item active"><a class="nav-link"
					href="login.jsp">Admin</a></li>
					<li class="nav-item active"><a class="nav-link"
					href="UserLogin.jsp">Login</a></li>
				<li class="nav-item"><a class="nav-link" href="UserRegistration.jsp">Register</a>
				</li>
			</ul>
			<%} else if(role!=null){ %>
			
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
			<li class="nav-item"><a class="nav-link" href="carsTable.jsp">Cars</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="addServices.jsp">Add new Detail</a>
				</li>
				</ul>
				<ul class="navbar-nav ml-auto mt-2 mt-lg-0">
				<li class="nav-item active"><a class="nav-link"
					href="AdminLogOut">Logout</a></li>
					</ul>
					
			<%} else if(role==null && user=="user"){%>
			<ul class="navbar-nav ml-auto mt-2 mt-lg-0">
			
				<li class="nav-item active"><a class="nav-link"
					href="UserLogOutServlet">Logout</a></li>
					
					</ul>
					<%} %>

		</div>
	</nav>
</header>