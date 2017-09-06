package SingleWebProject.domain;

public class Paging {
	//
	private int pageSize;//전체 페이지 사이즈
	private int startPageNo;//시작페이지 
	private int endPageNo;//끝 페이지
	private int firstPageNo;//첫번째 페이지
	private int lastPageNo;//마지막페이지
	private int prevPageNo;//이전 페이지
	private int nextPageNo;//다음 페이지
	private int totalPageNo;//전체 페이지
	private int pageNo;//현재 페이지
	public static final int viewPageSize = 5;//보여지는 페이지 크기
	public static final int countPostList = 5;//한 화면에 보여지는 게시물수
	private int totalPost;//전체 게시물 수
	public Paging(){
		
	}
	
	public Paging(int pageNo){
		//
		this.pageNo = pageNo;
		setPaging();
	}
	
	public void setPaging() {
		//
		//시작 페이지 0으로 설정
		startPageNo = ((pageNo - 1) - pageNo) + 1;
		//마지막 페이지 4로 설정(총5페이지)
		endPageNo = startPageNo + viewPageSize - 1;

		// 총 페이지수
		totalPageNo = totalPost / countPostList;
		//마지막 페이지 출력
		if (totalPost % countPostList > 0) {
			totalPageNo++;
		}
		//전체 페이지 보다 현재 페이지가 클 경우 보정
		if (totalPageNo < pageNo) {
			pageNo = totalPageNo;
		}
		//마지막 페이지 보정
		if (endPageNo > totalPageNo) {
			endPageNo = totalPageNo;
		}

		// 다음 버튼 페이지 번호
		for (int i = pageNo; i >= pageNo;) {
			nextPageNo = i++;
		}
		// 이전 버튼 페이지 번호
		for (int i = pageNo; i <= pageNo;) {
			prevPageNo = i--;
		}

		for (int iCount = startPageNo; iCount <= endPageNo; iCount++) {
			if(){
				
			}else{
			System.out.println(" " + iCount + " ");
			}
		}
	}

	public int getTotalPost() {
		return totalPost;
	}

	public void setTotalPost(int totalPost) {
		this.totalPost = totalPost;
	}
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getStartPageNo() {
		return startPageNo;
	}
	public void setStartPageNo(int startPageNo) {
		this.startPageNo = startPageNo;
	}
	public int getEndPageNo() {
		return endPageNo;
	}
	public void setEndPageNo(int endPageNo) {
		this.endPageNo = endPageNo;
	}
	public int getFirstPageNo() {
		return firstPageNo;
	}
	public void setFirstPageNo(int firstPageNo) {
		this.firstPageNo = firstPageNo;
	}
	public int getLastPageNo() {
		return lastPageNo;
	}
	public void setLastPageNo(int lastPageNo) {
		this.lastPageNo = lastPageNo;
	}
	public int getPrevPageNo() {
		return prevPageNo;
	}
	public void setPrevPageNo(int prevPageNo) {
		this.prevPageNo = prevPageNo;
	}
	public int getNextPageNo() {
		return nextPageNo;
	}
	public void setNextPageNo(int nextPageNo) {
		this.nextPageNo = nextPageNo;
	}
	public int getTotalPageNo() {
		return totalPageNo;
	}
	public void setTotalPageNo(int totalPageNo) {
		this.totalPageNo = totalPageNo;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	@Override
	public String toString() {
		return "Paging [pageSize=" + pageSize + ", startPageNo=" + startPageNo + ", endPageNo=" + endPageNo
				+ ", firstPageNo=" + firstPageNo + ", lastPageNo=" + lastPageNo + ", prevPageNo=" + prevPageNo
				+ ", nextPageNo=" + nextPageNo + ", totalPageNo=" + totalPageNo + ", pageNo=" + pageNo
				+ ", viewPageSize=" + viewPageSize + ", countPostList=" + countPostList + ", totalPost=" + totalPost
				+ "]";
	}	
}
