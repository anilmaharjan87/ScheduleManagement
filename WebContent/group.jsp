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
            <div class="col-md-6">
            </div>
          <div class="col-md-6">
            <form action="GroupServlet" class="bg-white rounded pb_form_v1" method="post">
              <h2 class="mb-4 mt-0 text-center">Group Detail</h2>
              <div class="form-group">
                Group Name <input type="text" class="form-control pb_height-50 reverse" placeholder="Enter the Group Name" name="groupName">
              </div>
              <div class="form-group">
                Group Size  <input type="number" class="form-control pb_height-50 reverse" placeholder="Enter the Group Size" name="groupSize">
              </div>
              <div> 
                <!-- subjects Name retieved from database  -->
              </div>

           <div class="form-group">
                <input type="submit" class="btn btn-primary btn-lg btn-block pb_btn-pill  btn-shadow-blue" value="Add">
              </div>
                 </form>


                 <!-- pachi milauchu -->
                         <div class="row align-items-center justify-content-center">
                         	<div class="form-group col-md-10 ">
               			 <a href="SubjectServlet"><input type="submit" class="btn btn-primary btn-lg btn-block pb_btn-pill  btn-shadow-blue" value="Next"></a>
              			</div></div>
          <div class="col-md-1">
          </div>
          <div class="col-md-5 relative align-self-center">
            
            

          </div> 
        </div>
      </div>
    </section>
 

<%@include file="footer.jsp" %>