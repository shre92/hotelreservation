<%@ include file="../../includes/header.jsp" %>
<html>
	<body>
		<div class="container-fluid">
			<div class="row mt-5">
				<div class="col-md-12">
					<c:if test="${not empty requestScope.message}">
						<div class="alert alert-danger text-center alert-dismissible fade show" role="alert">
						  ${requestScope.message}
						  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
						    <span aria-hidden="true">&times;</span>
						  </button>
						</div>
					</c:if>
				</div>
			</div>
			<div class="row mt-3">
				<div class="col-md-1"></div>
				<div class="col-md-10">
					<button onclick="javascript:window.location.href='login.html';" class="btn btn-warning float-left"><i class="fas fa-arrow-left"></i> Login</button>
				</div>
				<div class="col-md-1"></div>
			</div>
			<div class="row">
		        <div class="col-md-1"></div>
		        <div class="col-md-10">
		        <form name="registrationForm" id="registrationForm" action="registeruser.html" method="POST">
		            <div class="card mt-5">
		                <h3 class="card-header bg-dark text-light">
		                    Register
		                </h3>
		                <div class="card-body">
		                	<div class="row">
		                		<div class="col-md-6">
			                		<div class="form-group">
				                        <label for="username">Username</label>
				                        <input type="text" name="useUsername" id="useUsername" required class="form-control">
				                    </div>
				                 </div>
				                 <div class="col-md-6">
				                    <div class="form-group">
				                        <label for="password">Password</label>
				                        <input type="password" id="usePassword" name="usePassword" required class="form-control">   
				                    </div>
		                		</div>
		                	</div>
		                    <div class="row">
		                		<div class="col-md-6">
				                    <div class="form-group">
				                        <label for="useFirstname">First Name</label>
				                        <input type="text" id="useFirstname" name="useFirstname" required class="form-control">   
				                    </div>
				                </div>
				                <div class="col-md-6">
				                     <div class="form-group">
				                        <label for="useLastname">Last Name</label>
				                        <input type="text" id="useLastname" name="useLastname" class="form-control">   
				                    </div>
				                 </div>
		                	</div>
		                	<div class="row">
		                		<div class="col-md-6">
				                    <div class="form-group">
				                        <label for="useEmail">Email</label>
				                        <input type="email" id="useEmail" name="useEmail" required class="form-control">   
				                    </div>
				                 </div>
				                 <div class="col-md-6">
				                    <div class="form-group">
				                        <label for="useMobile">Mobile</label>
				                        <input type="text" id="useMobile" maxlength="10" name="useMobile" class="form-control">   
				                    </div>
				                  </div>
				              </div>
				              <div class="row">
				              		<div class="col-md-6"></div>
				              		<div class="col-md-6">
					                    <div class="float-right mt-4">
					                        <button type="submit" class="form-control btn btn-outline-dark">REGISTER</button>
					                    </div>
				                    </div>
				               </div>
		                   
		                </div>
		            </div>
		           </form>
		        </div>
		         <div class="col-md-1"></div>
		    </div>
	    </div>
	</body>
</html>