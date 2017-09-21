package SWP.domain;

import java.sql.Date;

public class Posting {
	//
	private String postTitle;//게시물 제목
	private String postCreatorName;//작성자 이름
	private String postId;//게시물 번호
	private Date postCreateDate;//생성일
	private String postContents;//내용
	private String boardId;
	private int start;//시작 페이지
	private int end;//마지막 페이지
	private int totalPageNo;//전페 페이지 번호 
		
	
	public int getTotalPageNo() {
		return totalPageNo;
	}
	public void setTotalPageNo(int totalPageNo) {
		this.totalPageNo = totalPageNo;
	}
	public String getBoardId() {
		return boardId;
	}
	public void setBoardId(String boardId) {
		this.boardId = boardId;
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
	public String getPostTitle() {
		return postTitle;
	}
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	public String getPostCreatorName() {
		return postCreatorName;
	}
	public void setPostCreatorName(String postCreatorName) {
		this.postCreatorName = postCreatorName;
	}
	public String getPostId() {
		return postId;
	}
	public void setPostId(String postId) {
		this.postId = postId;
	}
	public Date getPostCreateDate() {
		return postCreateDate;
	}
	public void setPostCreateDate(Date postCreateDate) {
		this.postCreateDate = postCreateDate;
	}
	public String getPostContents() {
		return postContents;
	}
	public void setPostContents(String postContents) {
		this.postContents = postContents;
	}
	
	@Override
	public String toString() {
		return "Posting [postTitle=" + postTitle + ", postCreatorName=" + postCreatorName + ", postId=" + postId
				+ ", postCreateDate=" + postCreateDate + ", postContents=" + postContents + ", boardId=" + boardId
				+ ", start=" + start + ", end=" + end + ", totalPageNo=" + totalPageNo + "]";
	}
	
}
