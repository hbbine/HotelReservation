package com.springmvc.hotelReservation3.dto;

public class BoardDTO {
	
	/*
	CREATE TABLE kopo18.board (
	b_id INT NOT NULL auto_increment PRIMARY KEY,
    m_id VARCHAR(30) NOT NULL,
    m_password VARCHAR(30) NOT NULL,
    b_content TEXT NOT NULL,
    b_viewcnt INT NOT NULL
	) DEFAULT CHARSET=utf8mb4;
	 */
	
	private String b_id;
	private String m_id;
	private String m_password;
	private String b_content;
	private int b_viewcnt;
	
	public BoardDTO() {
		super();
	}
	
	public String getB_id() {
		return b_id;
	}
	public void setB_id(String b_id) {
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
	public String getB_content() {
		return b_content;
	}
	public void setB_content(String b_content) {
		this.b_content = b_content;
	}
	public int getB_viewcnt() {
		return b_viewcnt;
	}
	public void setB_viewcnt(int b_viewcnt) {
		this.b_viewcnt = b_viewcnt;
	}
	
	

}
