package com.springmvc.hotelReservation3.dto;

public class MemberDTO {

	/*
		CREATE TABLE member (
    m_id VARCHAR(30) NOT NULL,
    m_password VARCHAR(30) NOT NULL,
    m_name VARCHAR(30) NOT NULL,
    m_email VARCHAR(30) DEFAULT NULL,
    m_tel VARCHAR(30) NOT NULL,
    m_authority VARCHAR(30) NOT NULL DEFAULT 'isAuthenticated'
	) DEFAULT CHARSET=utf8mb4;
	 */
	
	private String m_id;
	private String m_password;
	private String m_name;
	private String m_email;
	private String m_tel;
	private String m_authority;
	
	public MemberDTO() {
		super();
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getM_password() {
		return m_password;
	}

	public void setM_password(String m_password) {
		this.m_password = m_password;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public String getM_email() {
		return m_email;
	}

	public void setM_email(String m_email) {
		this.m_email = m_email;
	}

	public String getM_tel() {
		return m_tel;
	}

	public void setM_tel(String m_tel) {
		this.m_tel = m_tel;
	}

	public String getM_authority() {
		return m_authority;
	}

	public void setM_authority(String m_authority) {
		this.m_authority = m_authority;
	}
	
	
	
	
}
