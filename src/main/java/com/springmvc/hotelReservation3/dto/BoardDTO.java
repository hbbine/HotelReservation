package com.springmvc.hotelReservation3.dto;

public class BoardDTO {
	
	/*
	CREATE TABLE kopo18.board (
	b_id INT NOT NULL auto_increment PRIMARY KEY,
    m_id VARCHAR(30) NOT NULL,
    m_password VARCHAR(30) NOT NULL,
    b_title varchar(30) not null,
    b_content TEXT NOT NULL,
    b_date timestamp,
    b_viewcnt INT NOT NULL,
    is_admin BOOLEAN NOT NULL DEFAULT '0'
	) DEFAULT CHARSET=utf8mb4;
	 */
	
	private int b_id;
	private String m_id;
	private String m_password;
	private String b_title;
	private String b_content;
	private String b_date;
	private int b_viewcnt;
	private boolean is_admin;
	
	public BoardDTO() {
		super();
	}

	public int getB_id() {
		return b_id;
	}

	public void setB_id(int b_id) {
		this.b_id = b_id;
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

	public String getB_title() {
		return b_title;
	}

	public void setB_title(String b_title) {
		this.b_title = b_title;
	}

	public String getB_content() {
		return b_content;
	}

	public void setB_content(String b_content) {
		this.b_content = b_content;
	}

	public String getB_date() {
		return b_date;
	}

	public void setB_date(String b_date) {
		this.b_date = b_date;
	}

	public int getB_viewcnt() {
		return b_viewcnt;
	}

	public void setB_viewcnt(int b_viewcnt) {
		this.b_viewcnt = b_viewcnt;
	}

	public boolean isIs_admin() {
		return is_admin;
	}

	public void setIs_admin(boolean is_admin) {
		this.is_admin = is_admin;
	}

	

	
	

}
