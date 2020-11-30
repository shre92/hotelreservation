package com.hotelreservation.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "rooms")
public class Rooms {
	private Integer romId;
	private Integer romRtyId;
	private Integer romCapacity;
	private Date romAvailableDate;
	private RoomTypes roomType;
	private Integer romIsBooked;
	
	@Id
	@Column(name = "rom_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getRomId() {
		return romId;
	}
	public void setRomId(Integer romId) {
		this.romId = romId;
	}
	
	@Column(name = "rom_rty_id")
	public Integer getRomRtyId() {
		return romRtyId;
	}
	public void setRomRtyId(Integer romRtyId) {
		this.romRtyId = romRtyId;
	}
	
	@Column(name = "rom_capacity")
	public Integer getRomCapacity() {
		return romCapacity;
	}
	public void setRomCapacity(Integer romCapacity) {
		this.romCapacity = romCapacity;
	}
	
	@Column(name = "rom_available_date")
	public Date getRomAvailableDate() {
		return romAvailableDate;
	}
	public void setRomAvailableDate(Date romAvailableDate) {
		this.romAvailableDate = romAvailableDate;
	}
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "rom_rty_id", insertable = false, updatable = false)
	public RoomTypes getRoomType() {
		return roomType;
	}
	public void setRoomType(RoomTypes roomType) {
		this.roomType = roomType;
	}
	
	@Column(name = "rom_is_booked")
	public Integer getRomIsBooked() {
		return romIsBooked;
	}
	public void setRomIsBooked(Integer romIsBooked) {
		this.romIsBooked = romIsBooked;
	}
	
}
