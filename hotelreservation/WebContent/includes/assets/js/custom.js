
$(function () {
    $('#roomsTable').DataTable();
    
    var checkInDate = $("#checkInDate");
    var checkOutDate = $("#checkOutDate");
    if(typeof checkInDate != 'undefined' && typeof checkOutDate != 'undefined'){
    	var today = new Date();
    	var day = ("0" + today.getDate()).slice(-2);
    	var month = ("0" + (today.getMonth() + 1)).slice(-2);
    	var year = today.getFullYear();
    	$("#checkInDate").attr("min", year + "-" + month + "-" + day);
    	$("#checkOutDate").attr("min", year + "-" + month + "-" + day);
    }
    
    var romAvailableDate = $("#roomAvailableDate");
    if(typeof romAvailableDate != 'undefined'){
    	var today = new Date();
    	var day = ("0" + today.getDate()).slice(-2);
    	var month = ("0" + (today.getMonth() + 1)).slice(-2);
    	var year = today.getFullYear();
    	$("#roomAvailableDate").attr("min", year + "-" + month + "-" + day);
    }
    
});

function allowNumbersOnly(evt){
    var charCode = (evt.which) ? evt.which : evt.keyCode
    if (charCode > 31 && (charCode < 48 || charCode > 57)){
    	return false;
    }
    return true;
}

function validateCheckOutDate(value){
	$("#checkOutDate").attr("min", value)
}



