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
    <h1 class="display-4">Book Room</h1>
    <form name="bookRoomForm" id="bookRoomForm" action="bookroom.html" method="POST">
    <div class="row">
			<div class="col-md-6">
				 <div class="form-group">
		             <label for="roomType">Room Type</label>
		             <input type="text" class="form-control" readonly name="roomType" id="roomType" value="${requestScope.room.roomType.rtyName}">    
		         </div>
             </div>
             <div class="col-md-6">
             	 <div class="form-group">
             	 	<label for="roomCapacity">No of Guests</label>
		         	<input type="number" class="form-control" name="noOfGuests" id="noOfGuests" onkeydown="return false" max="${requestScope.room.romCapacity}" min="1" value="${requestScope.room.romCapacity}"/>    
		         </div>
             </div>
      </div>
      <div class="row">
        <div class="col-md-6">
			<div class="form-group">
		          <label for="roomAvailableDate">Check-In Date</label>
		          <input type="date" class="form-control" name="checkInDateForBooking" id="checkInDateForBooking" readonly onkeydown="return false" value="${requestScope.room.romAvailableDate}"/>   
      		</div>
        </div>
        <div class="col-md-6">
			<div class="form-group">
		          <label for="roomAvailableDate">Check-Out Date</label>
		          <input type="date" class="form-control"name="checkOutDateForBooking" id="checkOutDateForBooking" onkeydown="return false" min="${requestScope.room.romAvailableDate}"/>   
      			  <input type="hidden" id="romId" name="romId" value="${requestScope.room.romId}"/>
      		</div>
        </div>
      </div>
      <div class="row">
           <div class="col-md-6"></div>
           <div class="col-md-6">
           		<button class="btn btn-primary float-right" type="submit">Book Room</button>
           </div>
	  </div>
	</form>
</div>
</div>
</body>
</html>
