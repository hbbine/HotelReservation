package com.springmvc.hotelReservation3.dto;

public class StatusDTO {
	
	/*
	 * CREATE TABLE kopo18.status (
    s_date VARCHAR(30) NOT NULL,
	s_royalSweet VARCHAR(30) NOT NULL DEFAULT '예약가능',
    s_deluxe varchar(30) not null  DEFAULT '예약가능',
    s_standard varchar(30) not null  DEFAULT '예약가능'
	) DEFAULT CHARSET=utf8mb4;
	 */

	private String s_checkin;
	private String s_checkout;
	private String s_royalSweet;
	private String s_deluxe;
	private String s_standard;
	
	

	public StatusDTO() {
		super();
	}
	
	

	public StatusDTO(String s_royalSweet, String s_deluxe, String s_standard) {
		super();
		this.s_royalSweet = s_royalSweet;
		this.s_deluxe = s_deluxe;
		this.s_standard = s_standard;
	}

	public String getS_checkin() {
		return s_checkin;
	}



	public void setS_checkin(String s_checkin) {
		this.s_checkin = s_checkin;
	}



	public String getS_checkout() {
		return s_checkout;
	}



	public void setS_checkout(String s_checkout) {
		this.s_checkout = s_checkout;
	}



	public String getS_royalSweet() {
		return s_royalSweet;
	}

	public void setS_royalSweet(String s_royalSweet) {
		this.s_royalSweet = s_royalSweet;
	}

	public String getS_deluxe() {
		return s_deluxe;
	}

	public void setS_deluxe(String s_deluxe) {
		this.s_deluxe = s_deluxe;
	}

	public String getS_standard() {
		return s_standard;
	}

	public void setS_standard(String s_standard) {
		this.s_standard = s_standard;
	}

	
}
