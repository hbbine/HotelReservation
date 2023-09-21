package com.springmvc.hotelReservation3.dto;

public class PageDTO {
	
	private long page;
	private long perPage;
	private long totalPage;
	private long startRow;
	private long lastRow;
	private long block;
	private long perBlock;
	private long startNum;
	private long lastNum;
	private boolean pre;
	private boolean next;
	
	public PageDTO() {
		this.page=1L;
		this.perPage=10L;
		this.perBlock=10L;
	}
	
	public void setRow() {
		/*	한페이지 10개 출력
		 * 	page startrow lastrow
		 * 	1		1		10
		 * 	2		11		20
		 */	
		
		this.startRow = (this.getPage()-1) * this.getPerPage();
		this.lastRow = this.getPage()* this.getPerPage();
	}
	
	public void setNum(long totalCount) {
		// 게시판글 총 갯수로 전체 페이지 수 구함
		// 전체 똑 떨어지면 그대로 페이지수 하고 나누어떨어지지않으면 전체페이지수 +1 하기
		this.totalPage = totalCount % this.getPerPage() == 0 ? totalCount/this.getPerPage() : totalCount/this.getPerPage() + 1;
		
		// 전체페이지수로 전체 블록 수를 구함 (하단 << < 1 2 3 4 5 > >>) 이 부분
		long totalBlock = totalPage % this.getPerBlock() == 0 ? totalPage/this.getPerBlock() : totalPage/this.getPerBlock() + 1;
		
		//현재페이지 현재블록 구하기
		long curBlock = this.getPage() % this.getPerBlock() == 0? this.getPage() / this.getPerBlock() : this.getPage()/this.getPerBlock() + 1;
		
		//현재블록의 시작점 끝점 구하기
		this.startNum = (curBlock - 1) * this.getPerBlock() + 1;
		this.lastNum = curBlock * this.getPerBlock();
		
		//현재블록이 마지막블록이면 lastnum은 마지막 페이지 번호
		if(curBlock == totalBlock) {
			this.lastNum=totalPage;
		}
		
		
		
		//두번째 페이지부터 이전버튼 활성화
		if(this.page < 1) {
			this.page = 1;
			
		}
		pre = this.page > 1;
		
		//현재블록이 마지막 블록보다 작으면 다음버튼 활성화
		if(curBlock < totalBlock) {
			next=true;
		}else {
			next=false;
		}
	}
	
	
	public long getPage() {
		return page;
	}
	public void setPage(long page) {
		this.page = page;
	}
	public long getPerPage() {
		return perPage;
	}
	public void setPerPage(long perPage) {
		this.perPage = perPage;
	}
	public long getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}
	public long getStartRow() {
		return startRow;
	}
	public void setStartRow(long startRow) {
		this.startRow = startRow;
	}
	public long getLastRow() {
		return lastRow;
	}
	public void setLastRow(long lastRow) {
		this.lastRow = lastRow;
	}
	public long getBlock() {
		return block;
	}
	public void setBlock(long block) {
		this.block = block;
	}
	public long getPerBlock() {
		return perBlock;
	}
	public void setPerBlock(long perBlock) {
		this.perBlock = perBlock;
	}
	public long getStartNum() {
		return startNum;
	}
	public void setStartNum(long startNum) {
		this.startNum = startNum;
	}
	public long getLastNum() {
		return lastNum;
	}
	public void setLastNum(long lastNum) {
		this.lastNum = lastNum;
	}
	public boolean isPre() {
		return pre;
	}
	public void setPre(boolean pre) {
		this.pre = pre;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	
	
	

}
