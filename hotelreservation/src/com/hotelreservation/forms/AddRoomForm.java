package com.hotelreservation.forms;

import java.sql.Date;

public class AddRoomForm {
	private Integer roomType;
	private Integer roomCapacity;
	private Date roomAvailableDate;
	public Integer getRoomType() {
		return roomType;
	}
	public void setRoomType(Integer roomType) {
		this.roomType = roomType;
	}
	public Integer getRoomCapacity() {
		return roomCapacity;
	}
	public void setRoomCapacity(Integer roomCapacity) {
		this.roomCapacity = roomCapacity;
	}
	public Date getRoomAvailableDate() {
		return roomAvailableDate;
	}
	public void setRoomAvailableDate(Date roomAvailableDate) {
		this.roomAvailableDate = roomAvailableDate;
	}
	
	
}
