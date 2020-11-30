package com.hotelreservation.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users {
	private String useUsername;
	private String useFirstname;
	private String useLastname;
	private String useEmail;
	private String usePassword;
	private String useMobile;
	private Integer useIsAdmin;
	
	@Id
	@Column(name = "use_username")
	public String getUseUsername() {
		return useUsername;
	}
	public void setUseUsername(String useUsername) {
		this.useUsername = useUsername;
	}
	
	@Column(name = "use_firstname")
	public String getUseFirstname() {
		return useFirstname;
	}
	public void setUseFirstname(String useFirstname) {
		this.useFirstname = useFirstname;
	}
	
	@Column(name = "use_lastname")
	public String getUseLastname() {
		return useLastname;
	}
	public void setUseLastname(String useLastname) {
		this.useLastname = useLastname;
	}
	
	@Column(name = "use_email")
	public String getUseEmail() {
		return useEmail;
	}
	public void setUseEmail(String useEmail) {
		this.useEmail = useEmail;
	}
	
	@Column(name = "use_password")
	public String getUsePassword() {
		return usePassword;
	}
	public void setUsePassword(String usePassword) {
		this.usePassword = usePassword;
	}
	
	@Column(name = "use_mobile")
	public String getUseMobile() {
		return useMobile;
	}
	public void setUseMobile(String useMobile) {
		this.useMobile = useMobile;
	}
	
	@Column(name = "use_is_admin")
	public Integer getUseIsAdmin() {
		return useIsAdmin;
	}
	public void setUseIsAdmin(Integer useIsAdmin) {
		this.useIsAdmin = useIsAdmin;
	}
	

}
