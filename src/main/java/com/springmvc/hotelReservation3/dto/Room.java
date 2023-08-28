package com.springmvc.hotelReservation3.dto;

public class Room {

	/*
	 * use kopo18; CREATE TABLE room ( 
	 * room_id INT PRIMARY KEY, 
	 * room_type VARCHAR(50) NOT NULL, 
	 * room_size INT NOT NULL, 
	 * room_capacity INT NOT NULL,
	 * room_price DECIMAL(10, 2) NOT NULL, 
	 * room_img VARCHAR(60), room_count INT NOTNULL 
	 * );
	 */
	
	/*DB에서 방 고유번호는 기본키로 설정*/
	private int room_id; //각 방에 대한 고유번호
	private String room_type; //방 이름
	private int room_size; //방 크기
	private int room_capacity; //방 수용인원
	private int room_price; //방 가격
	private String room_img; //방 이미지 경로
	private int room_count; //방 갯수
	
	public Room() {}
	
	public int getRoom_id() {
		return room_id;
	}
	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}
	public String getRoom_type() {
		return room_type;
	}
	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}
	public int getRoom_size() {
		return room_size;
	}
	public void setRoom_size(int room_size) {
		this.room_size = room_size;
	}
	public int getRoom_capacity() {
		return room_capacity;
	}
	public void setRoom_capacity(int room_capacity) {
		this.room_capacity = room_capacity;
	}
	public int getRoom_price() {
		return room_price;
	}
	public void setRoom_price(int room_price) {
		this.room_price = room_price;
	}
	public String getRoom_img() {
		return room_img;
	}
	public void setRoom_img(String room_img) {
		this.room_img = room_img;
	}
	public int getRoom_count() {
		return room_count;
	}
	public void setRoom_count(int room_count) {
		this.room_count = room_count;
	}

	//확인절차
	public void roomToString() {
		System.out.println(this.room_id + "," + this.room_type + "," + this.room_capacity + "," + this.room_size + "," + this.room_img);
	}

}
