package com.springmvc.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.springmvc.hotelReservation3.dto.ReservationDTO;

@Mapper
public interface ReservationMapper {
	
	//insert reservation table
	public void reservationInsert(@Param("reservationInsert") ReservationDTO reservationDTO);
	
	//read table
	public List<ReservationDTO> getAllReservation();
	
	
	
	
}
