package com.springmvc.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.springmvc.hotelReservation3.dto.StatusDTO;

@Mapper
public interface StatusMapper {

	//insert default Status table
	@Insert("INSERT INTO status(s_date, s_royalSweet, s_deluxe, s_standard) VALUES (#{s_date},#{s_royalSweet},#{s_deluxe},#{s_standard})")
	public void insertStatus(StatusDTO statusdto);
	
	
}
