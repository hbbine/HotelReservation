package com.springmvc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.dao.DataAccessException;

import com.springmvc.hotelReservation3.dto.BoardDTO;
import com.springmvc.hotelReservation3.dto.MemberDTO;

@Mapper
public interface MemberMapper {

	//insert member table
	@Insert("INSERT INTO member(m_id, m_password, m_name, m_email, m_tel) VALUES(#{m_id}, #{m_password}, #{m_name}, #{m_email}, #{m_tel})")
	public void memberJoin(MemberDTO dto);
	
	//login
	@Select("SELECT * FROM member WHERE m_id=#{m_id} and m_password=#{m_password}")
	public MemberDTO Login(MemberDTO dto);
	
	//id중복체크
	@Select("SELECT COUNT(*) FROM member WHERE m_id=#{memberId}")
	public int idCheck(String memberId);
	
	//update member information
	@Update("UPDATE member SET m_password = #{m_password}, m_name = #{m_name}, m_email = #{m_email}, m_tel = #{m_tel} WHERE m_id = #{m_id}")
	public void updateMyInformation(MemberDTO memberdto);
	
	//delete member
	@Delete("DELETE FROM member WHERE m_id=#{m_id}")
	void deleteMember(@Param ("m_id") String m_id) throws DataAccessException;
	
	//boardList
	@Select("SELECT m_id, m_password, m_name, m_email, m_tel FROM member")
	public List<MemberDTO> getAllMemberList();
}
