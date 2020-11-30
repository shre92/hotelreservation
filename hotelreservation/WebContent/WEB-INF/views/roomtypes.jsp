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
    <h1 class="display-4">Room Types</h1>
    <div class="row">
	<div class="col-md-6">
		<form action="addroomtype.html" method="POST">
			 <div class="form-group">
	             <label for="roomType">Room Type</label>
	             <input type="text" required name="roomType" id="roomType" required class="form-control">
	         </div>
             <button type="submit" class="btn btn-primary float-right">Add</button>
         </form>
	</div>
</div>
<div class="row mt-3">
	<div class="col-md-6">
		<table class="table table-striped" id="roomsTable">
			<thead class="thead-dark">
                 <tr>
                    <th scope="col">#</th>
                    <th scope="col">Room Type</th>
                 </tr>
             </thead>
			<tbody>
             	<c:set var="counter" value="1"/>
             	<c:forEach items="${requestScope.rooms}" varStatus="status">
               	 	<tr>
                      <td>${counter}</td>
                      <td>${status.current.rtyName}</td>
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
