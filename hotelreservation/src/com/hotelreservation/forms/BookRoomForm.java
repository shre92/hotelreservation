package com.hotelreservation.forms;

import java.sql.Date;

public class BookRoomForm {
	private Integer romId;
	private Integer noOfGuests;
	private Date checkInDateForBooking;
	private Date checkOutDateForBooking;
	public Integer getRomId() {
		return romId;
	}
	public void setRomId(Integer romId) {
		this.romId = romId;
	}
	public Integer getNoOfGuests() {
		return noOfGuests;
	}
	public void setNoOfGuests(Integer noOfGuests) {
		this.noOfGuests = noOfGuests;
	}
	public Date getCheckInDateForBooking() {
		return checkInDateForBooking;
	}
	public void setCheckInDateForBooking(Date checkInDateForBooking) {
		this.checkInDateForBooking = checkInDateForBooking;
	}
	public Date getCheckOutDateForBooking() {
		return checkOutDateForBooking;
	}
	public void setCheckOutDateForBooking(Date checkOutDateForBooking) {
		this.checkOutDateForBooking = checkOutDateForBooking;
	}
}
