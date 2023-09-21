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
import com.springmvc.hotelReservation3.dto.PageDTO;

@Mapper
public interface BoardMapper {

	//insert board table
	@Insert("INSERT INTO board(m_id, m_password, b_title, b_content, b_date, b_viewcnt) VALUES(#{m_id}, #{m_password},#{b_title}, #{b_content},NOW(), #{b_viewcnt})")
	public void insertBoard(BoardDTO dto);
	
	//boardList
	@Select("SELECT b_id, m_id, b_title, b_date, b_viewcnt, is_admin FROM board ORDER BY is_admin DESC, b_date desc")
	public List<BoardDTO> getAllBoardList();
	
	//one view
	@Select("SELECT * FROM board WHERE b_id = #{b_id}")
	public BoardDTO oneView(@Param("b_id") int b_id) throws DataAccessException;

	//view count
	@Update("UPDATE board SET b_viewcnt = #{cnt} WHERE b_id = #{b_id}")
	public void updateViewCnt(@Param("b_id") int b_id, @Param("cnt") int cnt);

	//update
	@Update("UPDATE board SET b_title = #{b_title}, b_content = #{b_content}, b_date = NOW() WHERE b_id = #{b_id}")
	public void updateBoard(BoardDTO board);
	
	//delete
	@Delete("DELETE FROM board WHERE b_id=#{b_id}")
	void deleteBoard(@Param("b_id") int b_id) throws DataAccessException;
	
	//update admin post
	@Update("UPDATE board SET is_admin = 1 WHERE m_id = #{m_id}")
	void updateAdminPost(@Param("m_id") String m_id);
	
	//select admin post
	@Select("SELECT b_id, m_id, b_title, b_date, b_viewcnt, is_admin FROM board WHERE is_admin = 1 ORDER BY b_date desc")
	public List<BoardDTO> getAllAdminBoardList();
	
	//admin one view
	@Select("SELECT * FROM board WHERE b_id = #{b_id}")
	public BoardDTO adminOneView(@Param("b_id") int b_id) throws DataAccessException;
	
	//board pagination
	@Select("SELECT b_id, m_id, b_title, b_date, b_viewcnt, is_admin FROM board ORDER BY is_admin DESC, b_date DESC LIMIT #{startRow}, #{perPage}")
	public List<BoardDTO> getPageBoardList(PageDTO pagedto);
	
	//board pagination with count
	@Select("SELECT COUNT(b_id) FROM board")
	public int getCountBoard();

	
	
}
