<%@ include file="../../includes/header.jsp" %>
<div class="col p-4">
	<c:if test="${not empty requestScope.message}">
		<div class="alert alert-success text-center alert-dismissible fade show" role="alert">
		  ${requestScope.message}
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
	</c:if>
	<c:if test="${not empty sessionScope.sessionAttributes && not empty sessionScope.sessionAttributes.usrType && sessionScope.sessionAttributes.usrType eq 'visitor'}">
    <h1 class="display-4">Search Rooms</h1>
    <form name="searchRoomForm" id="searchRoomForm"  action="searchrooms.html" method="POST">
    <div class="row">
             <div class="col-md-6">
             	 <div class="form-group">
             	 	<label for="checkInDate">Check-In Date</label>
		         	<input type="date" class="form-control" required  onkeydown="return false" onchange="validateCheckOutDate(this.value);" name="checkInDate" id="checkInDate" value="${requestScope.checkInDate}"/>    
		         </div>
             </div>
             <div class="col-md-6">
             	 <div class="form-group">
             	 	<label for="checkOutDate">Check-Out Date</label>
		         	<input type="date" class="form-control" required  onkeydown="return false" name="checkOutDate" id="checkOutDate" value="${requestScope.checkOutDate}"/>    
		         </div>
		         <input type="hidden" name="mode" id="mode" value="search"/>
             </div>
      </div>
      <div class="row">
           <div class="col-md-6"></div>
           <div class="col-md-6">
           		<button class="btn btn-primary float-right" type="submit">Search Rooms</button>
           </div>
	  </div>
	</form>
	
	<div class="row mt-3">
	<div class="col-md-12">
		<table class="table table-striped" id="roomsTable">
			<thead class="thead-dark">
                 <tr>
                    <th scope="col">#</th>
                    <th scope="col">Room Type</th>
                    <th scope="col">Capacity</th>
                    <th scope="col">Available Date</th>
                    <th scope="col">Book</th>
                 </tr>
             </thead>
			<tbody>
             	<c:set var="counter" value="1"/>
             	<c:forEach items="${requestScope.filteredRooms}" varStatus="status">
               	 	<tr>
                      <td>${counter}</td>
                      <td>${status.current.roomType.rtyName}</td>
                      <td>${status.current.romCapacity}</td>
                      <td>${status.current.romAvailableDate}</td>
                      <td><a href="displaybookroom.html?romId=${status.current.romId}" class="btn btn-success">Book Now</a></td>
                    </tr>
                   <c:set var="counter" value="${counter + 1}"/>
             	</c:forEach>
             </tbody>
		</table>
	</div>
</div>
</c:if>
	<c:if test="${not empty sessionScope.sessionAttributes && not empty sessionScope.sessionAttributes.usrType && sessionScope.sessionAttributes.usrType eq 'admin'}">
    <h1 class="display-4">Bookings</h1>
	<div class="row mt-3">
	<div class="col-md-12">
		<table class="table table-striped" id="roomsTable">
			<thead class="thead-dark">
                 <tr>
                    <th scope="col">#</th>
                    <th scope="col">Room Type</th>
                    <th scope="col">No of Guests</th>
                    <th scope="col">Check-In Date</th>
                    <th scope="col">Check-Out Date</th>
                    <th scope="col">User</th>
                 </tr>
             </thead>
			<tbody>
             	<c:set var="counter" value="1"/>
             	<c:forEach items="${requestScope.bookings}" varStatus="status">
               	 	<tr>
                      <td>${counter}</td>
                      <td>${status.current.room.roomType.rtyName}</td>
                      <td>${status.current.rboNoOfGuests}</td>
                      <td>${status.current.rboCheckinDate}</td>
                      <td>${status.current.rboCheckoutDate}</td>
                      <td>${status.current.user.useFirstname} ${status.current.user.useLastname}</td>
                    </tr>
                   <c:set var="counter" value="${counter + 1}"/>
             	</c:forEach>
             </tbody>
		</table>
	</div>
</div>
</c:if>
</div>
</div>
</body>
</html>

    