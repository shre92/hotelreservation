package com.hotelreservation.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "room_types")
public class RoomTypes {
	private Integer rtyId;
	private String rtyName;
	
	@Id
	@Column(name = "rty_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getRtyId() {
		return rtyId;
	}
	public void setRtyId(Integer rtyId) {
		this.rtyId = rtyId;
	}
	
	@Column(name = "rty_name")
	public String getRtyName() {
		return rtyName;
	}
	public void setRtyName(String rtyName) {
		this.rtyName = rtyName;
	}

}
