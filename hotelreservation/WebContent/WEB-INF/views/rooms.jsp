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
    <h1 class="display-4">Rooms</h1>
    <form name="addRoomForm" id="addRoomForm"  action="addroom.html" method="POST">
    <div class="row">
			<div class="col-md-6">
				 <div class="form-group">
		             <label for="roomType">Room Type</label>
		             <select class="form-control" name="roomType" id="roomType" required>
		             	<option value="">Please Select</option>
		             	<c:forEach items="${requestScope.roomTypes}" varStatus="status">
		             		<option value="${status.current.rtyId}">${status.current.rtyName}</option>
		             	</c:forEach>
		             </select>
		         </div>
             </div>
             <div class="col-md-6">
             	 <div class="form-group">
             	 	<label for="roomCapacity">Room Capacity</label>
		         	<input type="text" class="form-control" name="roomCapacity" id="roomCapacity" onkeypress="return allowNumbersOnly(event);"/>    
		         </div>
             </div>
      </div>
      <div class="row">
        <div class="col-md-6">
			<div class="form-group">
		          <label for="roomAvailableDate">Available Date</label>
		          <input type="date" class="form-control" name="roomAvailableDate" id="roomAvailableDate" onkeydown="return false"/>   
      		</div>
        </div>
      </div>
      <div class="row">
           <div class="col-md-6"></div>
           <div class="col-md-6">
           		<button class="btn btn-primary float-right" type="submit">Add Room</button>
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
                    <th scope="col">Booked/Available</th>
                 </tr>
             </thead>
			<tbody>
             	<c:set var="counter" value="1"/>
             	<c:forEach items="${requestScope.rooms}" varStatus="status">
               	 	<tr>
                      <td>${counter}</td>
                      <td>${status.current.roomType.rtyName}</td>
                      <td>${status.current.romCapacity}</td>
                      <td>${status.current.romAvailableDate}</td>
                      <c:if test="${empty status.current.romIsBooked}">
                      	<td><div class="badge badge-success">Available</div></td>
                      </c:if>
                       <c:if test="${not empty status.current.romIsBooked}">
                      	<td><div class="badge badge-primary">Booked</div></td>
                      </c:if>
                    </tr>
                   <c:set var="counter" value="${counter + 1}"/>
             	</c:forEach>
             </tbody>
		</table>
	</div>
</div>
</div>
</div>
</body>
</html>
