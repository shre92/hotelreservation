<%@ include file="../../includes/header.jsp" %>
<html>
	<body>
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-12">
					<c:if test="${not empty requestScope.message}">
						<div class="alert ${requestScope.message != 'Registration Successful' ? 'alert-danger' : 'alert-success'} text-center alert-dismissible fade show" role="alert">
						  ${requestScope.message}
						  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
						    <span aria-hidden="true">&times;</span>
						  </button>
						</div>
					</c:if>
				</div>
			</div>
			<div class="row mt-3">
		        <div class="col-md-4"></div>
		        <div class="col-md-4">
		        <form name="loginForm" id="loginForm" action="home.html" method="POST">
		            <div class="card mt-5">
		                <h3 class="card-header bg-dark text-light">
		                    Login
		                </h3>
		                <div class="card-body">
		                
		                    <div class="form-group">
		                        <label for="username">Username</label>
		                        <input type="text" name="useUsername" id="useUsername" required class="form-control">
		                    </div>
		                    <div class="form-group">
		                        <label for="password">Password</label>
		                        <input type="password" id="usePassword" name="usePassword" required class="form-control">   
		                    </div>
		                    <div class="form-group mt-4">
		                        <button type="submit" class="form-control btn btn-outline-dark">LOGIN</button>
		                    </div>
		                   
		                </div>
		                <div class="card-footer text-center">
		                    Not a member? Please <a href="useradd.html">Register</a>
		                </div>
		            </div>
		           </form>
		        </div>
		         <div class="col-md-4"></div>
		    </div>
	    </div>
	</body>
</html>