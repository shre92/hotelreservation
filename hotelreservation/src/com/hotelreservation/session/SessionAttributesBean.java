package com.hotelreservation.session;

public class SessionAttributesBean {
	private String sessionId;
	private String usrUserName;
	private String usrType;
	private Integer orgId;
	
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getUsrUserName() {
		return usrUserName;
	}
	public void setUsrUserName(String usrUserName) {
		this.usrUserName = usrUserName;
	}
	public String getUsrType() {
		return usrType;
	}
	public void setUsrType(String usrType) {
		this.usrType = usrType;
	}
	public Integer getOrgId() {
		return orgId;
	}
	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}
}
