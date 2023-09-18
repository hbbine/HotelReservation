package com.springmvc.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.dao.DataAccessException;

import com.springmvc.hotelReservation3.dto.BoardDTO;
import com.springmvc.hotelReservation3.dto.ReservationDTO;

@Mapper
public interface ReservationMapper {
	
	//insert reservation table
	public void reservationInsert(@Param("reservationInsert") ReservationDTO reservationDTO);
	
	//reservationList
	@Select("SELECT * FROM reservation ")
	public List<ReservationDTO> getAllReservation();
	
	//reservation duplicate check
	@Select("SELECT COUNT(*) FROM reservation WHERE r_type=#{r_type} "
	        + "AND STR_TO_DATE(r_checkin, '%Y-%m-%d') >= #{r_checkin}"
	        + "AND STR_TO_DATE(r_checkout, '%Y-%m-%d') <= #{r_checkout}")
	public int reservationCheck(@Param("r_type") String r_type, 
	                            @Param("r_checkin") String formattedBeginDate, 
	                            @Param("r_checkout") String formattedEndDate);
	//my page reservationList
	@Select("SELECT r_id, m_id, r_checkin, r_checkout, r_type, r_adults, r_kids, r_price FROM reservation WHERE m_id=#{m_id} ORDER BY r_id DESC")
	public List<ReservationDTO> getPersonalReservaionList(@Param("m_id") String m_id);
	
	
	//관리자 회원 전체 예약 목록 보기
	@Select("SELECT * FROM reservation ORDER BY r_checkin ASC;")
	public List<ReservationDTO> getAdminReservation();
	
	//관리자 예약 1개 보기
	@Select("SELECT * FROM board WHERE r_id = #{r_id}")
	public ReservationDTO adminOneiew(@Param("r_id") int r_id) throws DataAccessException;
	
	//관리자 예약 수정
	@Update("UPDATE reservation SET r_checkin = #{r_checkin}, r_checkout = #{r_checkout}, r_type = #{r_type}, r_adults = #{r_adults}, r_kids = #{r_kids}, r_price = #{r_price}")
	public void updateReservation(ReservationDTO reservation);
}