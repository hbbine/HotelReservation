package com.springmvc.hotelReservation3.dto;

import java.util.List;

public class FileDTO {
	
	/*
	CREATE TABLE kopo18.file (
    f_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    b_id INT NOT NULL,
    f_oName VARCHAR(300) NOT NULL,
    f_tName VARCHAR(300) NOT NULL,
    f_size INT NOT NULL,
    f_date timestamp DEFAULT CURRENT_TIMESTAMP,
    f_del VARCHAR(1) DEFAULT 'n' NOT NULL
	);
	 */
	
	private List<FileDTO> list;
	
	private int f_id;
	private int b_id;
	private String f_oName;
	private String f_tName;
	private int f_size;
	private String f_date;
	private String f_del;
	
	
	
	public List<FileDTO> getList() {
		return list;
	}
	
	public void setList(List<FileDTO> list) {
		this.list = list;
	}
	public int getF_id() {
		return f_id;
	}
	public void setF_id(int f_id) {
		this.f_id = f_id;
	}
	public int getB_id() {
		return b_id;
	}
	public void setB_id(int b_id) {
		this.b_id = b_id;
	}
	public String getF_oName() {
		return f_oName;
	}
	public void setF_oName(String f_oName) {
		this.f_oName = f_oName;
	}
	public String getF_tName() {
		return f_tName;
	}
	public void setF_tName(String f_tName) {
		this.f_tName = f_tName;
	}
	public int getF_size() {
		return f_size;
	}
	public void setF_size(int f_size) {
		this.f_size = f_size;
	}
	public String getF_date() {
		return f_date;
	}
	public void setF_date(String f_date) {
		this.f_date = f_date;
	}
	public String getF_del() {
		return f_del;
	}
	public void setF_del(String f_del) {
		this.f_del = f_del;
	}
	
	
	

}
