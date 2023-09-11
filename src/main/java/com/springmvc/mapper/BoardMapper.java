package com.springmvc.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.springmvc.hotelReservation3.dto.BoardDTO;

@Mapper
public interface BoardMapper {

	//insert board table
	@Insert("INSERT INTO board(m_id, m_password, b_content, b_viewcnt) VALUES(#{m_id}, #{m_password}, #{b_content}, #{b_viewcnt})")
	public void insertBoard(BoardDTO dto);

}

