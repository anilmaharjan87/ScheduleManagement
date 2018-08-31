<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*,com.geneticalgorithm.*"%>

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
					<a href="/GeneticAlgorithm/GenerateServlet"> <img class="logo" src="img/logo.png"
						alt="logo">

					</a>

				</div>
				<ul class="navbar-nav ml-auto">
					 <form  action="/GeneticAlgorithm/GenerateServlet">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit"
							style="margin: 10px;">Home</button>
					</form>
				</ul>
			</div>
		</div>
	</nav>
	<!-- END nav -->




	<section class=sm-padding bg-dark" id="section-home">
		<div class="container">
			<div class="row align-items-center justify-content-center">
				<div class="col-md-6"></div>
				<div class="col-md-6">
					<form action="/GeneticAlgorithm/SubjectServlet"
						class="bg-white rounded pb_form_v1" method="post">
						<h2 class="mb-4 mt-0 text-center">Subject Detail</h2>
						<div class="form-group">
							Subject Name <input type="text" 
								class="form-control pb_height-50 reverse"
								placeholder="Enter the Subject Name" name="subjectName">
						</div>
						<div class="form-group">
							Subject Code <input type="text"
								class="form-control pb_height-50 reverse"
								placeholder="Enter the Subject Code" name="subjectCode">
						</div>
						<input type="hidden" id="SubjectId" name="SubjectId" value="">

						Professor:
						<c:forEach var="tempProfessor" items="${PROFESSOR_LIST}">
							<ul>
								<li><input type="hidden" name="id"
									value="${tempProfessor.id}"> <input type="checkbox"
									name="professor" value="${tempProfessor.id}">${tempProfessor.professorName}
								</li>
							</ul>

						</c:forEach>
						<div class="form-group">
							<label for="sel1">Select Group:</label>
							 <select name="group"
								class="form-control" id="sel1">
								<c:forEach var="tempGroup" items="${GROUP_LIST}">
									<option value="${tempGroup.groupId}">${tempGroup.groupName}</option>
								</c:forEach>
							</select>
						</div>



						<div class="form-group">
							<input type="submit"
								class="btn btn-primary btn-lg btn-block pb_btn-pill  btn-shadow-blue"
								value="ADD">
						</div>
						
					</form>
					<form  action="/GeneticAlgorithm/GenerateServlet">
					 <div class="row align-items-center justify-content-center">
                         	<div class="form-group col-md-10 ">
               			 <input type="submit" class="btn btn-primary btn-lg btn-block pb_btn-pill  btn-shadow-blue" value="Next">
              			</div></div>
					</form>
					


					<!-- pachi milauchu -->
					<div class="row align-items-center justify-content-center">
						<div class="form-group col-md-10 ">
							
						</div>
					</div>
					<!-- eha samma -->




				</div>
				<div class="col-md-1"></div>
				<div class="col-md-5 relative align-self-center"></div>
			</div>
		</div>
	</section>

	<%@include file="footer.jsp"%>