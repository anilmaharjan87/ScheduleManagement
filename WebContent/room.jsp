<%@include file="resource.jsp" %>
	<body data-spy="scroll" data-target="#pb-navbar" data-offset="200">

    <nav class="navbar navbar-expand-lg bg-dark pb_scrolled-light" id="pb-navbar">
      <div class="container">
        
        <button class="navbar-toggler ml-auto" type="button" data-toggle="collapse" data-target="#probootstrap-navbar" aria-controls="probootstrap-navbar" aria-expanded="false" aria-label="Toggle navigation">
          <span><i class="ion-navicon"></i></span>
        </button>
        <div class="collapse navbar-collapse" id="probootstrap-navbar">
          <div class="navbar-brand">
            <a href="/GeneticAlgorithm/GenerateServlet">
              <img class="logo" src="img/logo.png" alt="logo">
              
            </a>
            
          </div>
        
        </div>
      </div>
    </nav>
    <!-- END nav -->




    <section class=sm-padding bg-dark" id="section-home">
      <div class="container">
        <div class="row align-items-center justify-content-center">
        	  <div class="col-md-6">
        	  </div>
          <div class="col-md-6">
             <form action="RoomServlet" class="bg-white rounded pb_form_v1" method="post">
              <h2 class="mb-4 mt-0 text-center">Room Detail</h2>
              <div class="form-group">
                Room Number <input type="text" class="form-control pb_height-50 reverse"pattern="[A-Za-z0-9]{3}" placeholder="Enter the Room number"name="roomNumber">
              </div>
              <div class="form-group">
                Room Capacity<input type="text"MIN="10" class="form-control pb_height-50 reverse" min="10"placeholder="Enter the room capacity" name="roomCapacity" required>
              </div>
                <input type="hidden" id="RoomId" name="RoomId" value="">

              <div class="form-group">
                <input type="submit" class="btn btn-primary btn-lg btn-block pb_btn-pill  btn-shadow-blue" value="Add">
              </div>
                 </form>


                 <!-- pachi milauchu -->
                 <form action="ProfessorServlet">
                         <div class="row align-items-center justify-content-center">
                         	<div class="form-group col-md-10 ">
               		<input type="submit" class="btn btn-primary btn-lg btn-block pb_btn-pill  btn-shadow-blue" value="Next">
              			</div></div>
              			</form>
              	<!-- eha samma -->


             </div> 
          <div class="col-md-1">
         	 </div>
          		<div class="col-md-5 relative align-self-center">
          </div> 
        </div>
      </div>
    </section>
 

<%@include file="footer.jsp" %>