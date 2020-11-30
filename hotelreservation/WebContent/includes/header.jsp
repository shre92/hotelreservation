<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	if(request.getAttribute("fromLogin") == null && request.getAttribute("fromRegistration") == null ){
		response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
		response.setHeader("Pragma","no-cache");
		response.setHeader("Expires","0");
	}
%> 
<html>
	<head>
		<link rel="stylesheet" href="includes/assets/css/bootstrap.min.css"/>
		<link rel="stylesheet" href="includes/assets/css/styles.css"/>
		<script type="text/javascript" src="includes/assets/js/jQuery.js"></script>
		<script type="text/javascript" src="includes/assets/js/popper.min.js"></script>
		<script type="text/javascript" src="includes/assets/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="includes/assets/js/all.js"></script>
		<script type="text/javascript" src="includes/assets/js/custom.js"></script>
		<link rel="stylesheet" href="includes/assets/css/datatables.min.css"/>
		<script type="text/javascript" src="includes/assets/js/datatables.min.js"></script>
	</head>
	<body>
		<!-- Bootstrap NavBar -->
		<nav class="navbar navbar-expand-md navbar-dark bg-dark">
		    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
		        <span class="navbar-toggler-icon"></span>
		    </button>
		    <a class="navbar-brand" href="#">
		        <span class="menu-collapsed">HOTEL RESERVATION</span>
		    </a>
		    <div class="collapse navbar-collapse" id="navbarNavDropdown">
		        <ul class="navbar-nav mr-auto">
		        </ul>
		        <c:if test="${not empty sessionScope.sessionAttributes}">
			         <span class="navbar-text float-right">
			            <a href="logout.html"><i class="fas fa-sign-out-alt"></i> Logout</a>
			        </span>
		        </c:if>
		    </div>
		</nav><!-- NavBar END -->
		<!-- Bootstrap row -->
		<c:if test="${not empty sessionScope.sessionAttributes && not empty sessionScope.sessionAttributes.usrType && sessionScope.sessionAttributes.usrType eq 'admin'}">
		<div class="row" id="body-row">
		    <!-- Sidebar -->
		    <div id="sidebar-container" class="sidebar-expanded d-none d-md-block">
		        <!-- d-* hiddens the Sidebar in smaller devices. Its itens can be kept on the Navbar 'Menu' -->
		        <!-- Bootstrap List Group -->
		        <ul class="list-group">
		            <!-- Menu with submenu -->
		            <a href="home.html" aria-expanded="false" class="bg-dark list-group-item list-group-item-action flex-column align-items-start">
		                <div class="d-flex w-100 justify-content-start align-items-center">
		                    <span class="fas fa-book mr-3"></span>
		                    <span class="menu-collapsed">Bookings</span>
		                </div>
		            </a>
		            <!-- Submenu content -->
		            <a href="roomtypes.html" aria-expanded="false" class="bg-dark list-group-item list-group-item-action flex-column align-items-start">
		                <div class="d-flex w-100 justify-content-start align-items-center">
		                    <span class="fas fa-hotel mr-3"></span>
		                    <span class="menu-collapsed">Room Type</span>
		                </div>
		            </a>
		            <a href="rooms.html" aria-expanded="false" class="bg-dark list-group-item list-group-item-action flex-column align-items-start">
		                <div class="d-flex w-100 justify-content-start align-items-center">
		                    <span class="fas fa-bed mr-3"></span>
		                    <span class="menu-collapsed">Rooms</span>
		                </div>
		            </a>
		            <!-- Submenu content -->
		            <!-- /END Separator -->
		        </ul><!-- List Group END-->
		    </div><!-- sidebar-container END -->
		</c:if>
		<c:if test="${not empty sessionScope.sessionAttributes && not empty sessionScope.sessionAttributes.usrType && sessionScope.sessionAttributes.usrType eq 'visitor'}">
		<div class="row" id="body-row">
		    <!-- Sidebar -->
		    <div id="sidebar-container" class="sidebar-expanded d-none d-md-block">
		        <!-- d-* hiddens the Sidebar in smaller devices. Its itens can be kept on the Navbar 'Menu' -->
		        <!-- Bootstrap List Group -->
		        <ul class="list-group">
		            <!-- Menu with submenu -->
		            <a href="searchrooms.html" aria-expanded="false" class="bg-dark list-group-item list-group-item-action flex-column align-items-start">
		                <div class="d-flex w-100 justify-content-start align-items-center">
		                    <span class="fas fa-book mr-3"></span>
		                    <span class="menu-collapsed">Search Rooms</span>
		                </div>
		            </a>
		            <!-- Submenu content -->
		            <a href="mybookings.html" aria-expanded="false" class="bg-dark list-group-item list-group-item-action flex-column align-items-start">
		                <div class="d-flex w-100 justify-content-start align-items-center">
		                    <span class="fas fa-hotel mr-3"></span>
		                    <span class="menu-collapsed">My Bookings</span>
		                </div>
		            </a>
		            <!-- Submenu content -->
		            <!-- /END Separator -->
		        </ul><!-- List Group END-->
		    </div><!-- sidebar-container END -->
		</c:if>

	
