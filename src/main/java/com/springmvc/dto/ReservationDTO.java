package com.springmvc.dto;

public class ReservationDTO {

	/*
	 * CREATE TABLE kopo18.reservation ( 
	r_id VARCHAR(30) NOT NULL, 
	m_id VARCHAR(30) NOT NULL,
	r_checkin DATE NOT NULL, 
	r_checkout DATE NOT NULL, 
	r_type VARCHAR(50) NOT NULL, 
	r_adults INT NOT NULL, 
	r_kids INT NOT NULL, s
	r_price INT NOT NULL, 
	CONFIRMATION_PAYMENT tinyint(1) DEFAULT NULL
	);
	 */
	
	/*예약정보 관련 클래스*/
	

	
	private String rid; //예약번호
	private String m_id; //예약고객 ID
	private String r_checkin; //체크인 날짜
	private String r_checkout;//체크아웃 날짜
	private String r_type;//예약한 방 종류
	private int r_adults; //투숙 성인 인원수
	private int r_kids; //투숙 아동인원수
	private int r_price; //총금액
	private boolean CONFIRMATION_PAYMENT; //결제 승인
	
	
	public ReservationDTO() {
		super();
	}

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getR_checkin() {
		return r_checkin;
	}

	public void setR_checkin(String r_checkin) {
		this.r_checkin = r_checkin;
	}

	public String getR_checkout() {
		return r_checkout;
	}

	public void setR_checkout(String r_checkout) {
		this.r_checkout = r_checkout;
	}

	public String getR_type() {
		return r_type;
	}

	public void setR_type(String r_type) {
		this.r_type = r_type;
	}

	public int getR_adults() {
		return r_adults;
	}

	public void setR_adults(int r_adults) {
		this.r_adults = r_adults;
	}

	public int getR_kids() {
		return r_kids;
	}

	public void setR_kids(int r_kids) {
		this.r_kids = r_kids;
	}

	public int getR_price() {
		return r_price;
	}

	public void setR_price(int r_price) {
		this.r_price = r_price;
	}

	public boolean isCONFIRMATION_PAYMENT() {
		return CONFIRMATION_PAYMENT;
	}

	public void setCONFIRMATION_PAYMENT(boolean cONFIRMATION_PAYMENT) {
		CONFIRMATION_PAYMENT = cONFIRMATION_PAYMENT;
	}

	//출력확인
	/*
	 * public void rToString() { System.out.println(this.rid + ", " + this.m_id +
	 * ", " + this.r_adults + ", " + this.r_kids + ", " + this.r_checkin + ", " +
	 * this.r_checkout + ", " + this.r_type + ", " + this.r_price + ", "); }
	 */
	
}
