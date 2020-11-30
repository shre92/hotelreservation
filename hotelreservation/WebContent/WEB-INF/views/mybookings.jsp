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
    <h1 class="display-4">My Bookings</h1>
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
                 </tr>
             </thead>
			<tbody>
             	<c:set var="counter" value="1"/>
             	<c:forEach items="${requestScope.mybookings}" varStatus="status">
               	 	<tr>
                      <td>${counter}</td>
                      <td>${status.current.room.roomType.rtyName}</td>
                      <td>${status.current.rboNoOfGuests}</td>
                      <td>${status.current.rboCheckinDate}</td>
                      <td>${status.current.rboCheckoutDate}</td>
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

    