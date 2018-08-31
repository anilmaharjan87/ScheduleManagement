
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="resource.jsp"%>



<body data-spy="scroll" data-target="#pb-navbar" data-offset="200">

	<nav class="navbar navbar-expand-lg bg-dark pb_scrolled-light"
		id="pb-navbar">
		<div class="container">

			<button class="navbar-toggler ml-auto" type="button"
				data-toggle="collapse" data-target="#probootstrap-navbar"
				aria-controls="probootstrap-navbar" aria-expanded="false"
				aria-label="Toggle navigation">
				<span><i class="ion-navicon"></i></span>
			</button>
			<div class="collapse navbar-collapse" id="probootstrap-navbar">
				<div class="navbar-brand">
					<a href="#"> <img class="logo" src="img/logo.png"
						alt="logo">

					</a>

				</div>

				<ul class="navbar-nav ml-auto">
					
						
				</ul>

				<form action="/GeneticAlgorithm/loginServlet"
					class="form-inline my-2 my-lg-0" method="post">
					<c:if test="${! login}">
						<input class="form-control mr-sm-2" type="search"
							placeholder="Username" aria-label="Username" name="username"
							required>
						<input class="form-control mr-sm-2" type="Password"
							placeholder="Password" aria-label="Password" name="password"
							required>
						<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Login</button>
					</c:if>

				</form>
				<form action="/GeneticAlgorithm/index"
					class="form-inline my-2 my-lg-0" method="post">

					<c:if test="${login}">
						<button class="btn btn-outline-success my-2 my-sm-0" type="submit"
							style="margin: 10px;">Generate</button>
					</c:if>
				</form>
				
				<form action="RoomServlet" class="form-inline my-2 my-lg-0">


					<c:if test="${login}">
						<button class="btn btn-outline-success my-2 my-sm-0" type="submit"
							style="margin: 10px;">Configure</button>
					</c:if>
				</form>
				<form action="/GeneticAlgorithm"
					class="form-inline my-2 my-lg-0" method="post">

					<c:if test="${login}">
						<button class="btn btn-outline-success my-2 my-sm-0" type="submit"
							style="margin: 10px;">Logout</button>
					</c:if>
				</form>
				
			</div>
		</div>
	</nav>
	<!-- END nav -->




	<section class=sm-padding bg-dark" id="section-home">
		<div class="container">
			<div class="row align-items-center justify-content-center">
				<div class="col-md- 10 bg-light">
					<c:forEach var="timeclassrow" items="${TIMECLASSHASHMAP}">
						<div style="text-align: center">
							<b><p>${timeclassrow.key}</p></b>
						</div>
						<table class="table "
							style="background-color: #fff; opacity: 0.5; color: black">

							<thead>
								<tr>
									<th>Day/Time</th>
									<c:forEach var="time" items="${TIMESLOT}">
										<td>${time.timeSlot}</td>
									</c:forEach>

								</tr>
							</thead>
							<tbody>
								<!--  -->
								<c:forEach var="day" items="${DAYS}">
									<tr>
										<td>${day}</td>
										<c:forEach var="timeclass" items="${timeclassrow.value}">
											<td>${timeclass.subjectCode}<br>${timeclass.professorName}
												<br>${timeclass.roomNumber}<br>${timeclass.subjectName}<br>
											</td>
										</c:forEach>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</c:forEach>
				</div>
			</div>
			<div class="col-md-1"></div>
	</section>

<%@include file="footer.jsp"%>