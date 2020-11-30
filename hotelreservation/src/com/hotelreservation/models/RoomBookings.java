package com.hotelreservation.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "room_bookings")
public class RoomBookings {
	private Integer rboId;
	private Integer rboRomId;
	private Integer rboNoOfGuests;
	private Date rboCheckinDate;
	private Date rboCheckoutDate;
	private String rboBookingDoneBy;
	private Rooms room;
	private Users user;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rbo_id")
	public Integer getRboId() {
		return rboId;
	}
	public void setRboId(Integer rboId) {
		this.rboId = rboId;
	}
	
	@Column(name = "rbo_rom_id")
	public Integer getRboRomId() {
		return rboRomId;
	}
	public void setRboRomId(Integer rboRomId) {
		this.rboRomId = rboRomId;
	}
	
	@Column(name = "rbo_no_of_guests")
	public Integer getRboNoOfGuests() {
		return rboNoOfGuests;
	}
	public void setRboNoOfGuests(Integer rboNoOfGuests) {
		this.rboNoOfGuests = rboNoOfGuests;
	}
	
	@Column(name = "rbo_checkin_date")
	public Date getRboCheckinDate() {
		return rboCheckinDate;
	}
	public void setRboCheckinDate(Date rboCheckinDate) {
		this.rboCheckinDate = rboCheckinDate;
	}
	
	@Column(name = "rbo_checkout_date")
	public Date getRboCheckoutDate() {
		return rboCheckoutDate;
	}
	public void setRboCheckoutDate(Date rboCheckoutDate) {
		this.rboCheckoutDate = rboCheckoutDate;
	}
	
	@Column(name = "rbo_booking_done_by")
	public String getRboBookingDoneBy() {
		return rboBookingDoneBy;
	}
	public void setRboBookingDoneBy(String rboBookingDoneBy) {
		this.rboBookingDoneBy = rboBookingDoneBy;
	}
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "rbo_rom_id",insertable = false, updatable = false)
	public Rooms getRoom() {
		return room;
	}
	public void setRoom(Rooms room) {
		this.room = room;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "rbo_booking_done_by", insertable = false, updatable = false)
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	
}
