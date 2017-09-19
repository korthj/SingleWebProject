package SWP.domain;

import java.sql.Date;

public class Board {
	//
	private String boardId;//보드 아이디로 검색하기 위한 변수
	private int totalPageNo;//페이징에 필요한 전체 페이지 번호 변수
	private int start;//시작 페이지 변수
	private int end;//마지막 페이지 변수
	private String name;//이름
	private Date date;//날짜
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getBoardId() {
		return boardId;
	}
	public void setBoardId(String boardId) {
		this.boardId = boardId;
	}
	public int getTotalPageNo() {
		return totalPageNo;
	}
	public void setTotalPageNo(int totalPageNo) {
		this.totalPageNo = totalPageNo;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	
	@Override
	public String toString() {
		return "Board [boardId=" + boardId + ", totalPageNo=" + totalPageNo + ", start=" + start + ", end=" + end + "]";
	}
		
}
