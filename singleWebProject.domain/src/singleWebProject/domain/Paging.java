package singleWebProject.domain;

public class Paging {
	//
	//페이지 당 게시물 수
	public static final int PAGE_SCALE = 10;
	//화면 당 페이지 수
	public static final int BLOCK_SCALE = 5;
	private int curPage;//현재 페이지
	private int nextPage;///다음 페이지
	private int prevPage;//이전 페이지
	private int totalPage;//전체 페이지
	private int totalBlock;//전체 페이지 블록 개수
	private int curBlock;//현재 페이지 블록
	private int prevBlock;//아전 페이지 블록
	private int nextBlock;//다음 페이지 블록
	//where rn BETWEEN #{start} AND #{END} 
	private int startBlockPage;//#{start},시작 페이지
	private int endBlockPage;//#{end},마지막 페이지
	private int blockBegin;//현재 페이지 블록의 시작 번호
	private int blockEnd;//현재 페이지 블록의 마지막 번호
	
	//생성자
	//레코드 개수, 현재 페이지 번호
	public Paging( int count , int curPage){
		//
		this.curPage = curPage;
		curBlock = 1;//현재 페이지 블록
		setTotalPage(count);//전체 페이지
		setBlockRange();//페이지 블록의 시작, 끝 번호 계산
		setTotalBlock();//전체 페이지 블록 계산
		setPageRange();//페이지 시작 끝 번호 계산
	}
	
	public void setBlockRange(){
		//현재 페이지의 블록 범위 계산
		curBlock = (int)Math.ceil((curPage-1)/BLOCK_SCALE)+1;
		
		//블록 시작 부분
		blockBegin = (curBlock-1)*BLOCK_SCALE+1;
		
		//블록 끝 부분
		blockEnd = blockBegin+BLOCK_SCALE-1;
		
		//블록의 마지막 부분이 전체 페이지를 넘지 않도록 보정
		if(blockEnd > totalPage){
			blockEnd = totalPage;
		}
		//이전 버튼을 눌었을때 이동할 이전 페이지
		prevPage = (curPage==1) ? 1 : (curBlock-1)*BLOCK_SCALE; 
		
		//다음 버튼을 눌렀을때 이동할 다음 페이지
		nextPage = (curBlock>totalBlock) ? curBlock*BLOCK_SCALE : curBlock*BLOCK_SCALE+1; 
		
		//현재 블록이 마지막 블록을 넘어가지 않게 보정
		if(nextPage >= totalPage){
			nextPage = totalPage;
		}
	}
	//현재 페이지 블록의 시작 페이지와 마지막 페이지 계산
	public void setPageRange(){
		//#{start}
		startBlockPage = (curPage-1)*PAGE_SCALE+1;
		//#{end}
		endBlockPage = startBlockPage*PAGE_SCALE-1;
	}

	
	public void setTotalBlock(){
		//전체 블록 크기
		totalBlock = (int) Math.ceil(totalPage/BLOCK_SCALE);
	}
	
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getNextPage() {
		return nextPage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	public int getPrevPage() {
		return prevPage;
	}
	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	
	//전체 페이지 계산
	public void setTotalPage(int count) {
		totalPage = (int)Math.ceil(count*1.0/PAGE_SCALE);
	}
	
	public int getTotalBlock() {
		return totalBlock;
	}
	public void setTotalBlock(int totalBlock) {
		this.totalBlock = totalBlock;
	}
	public int getCurBlock() {
		return curBlock;
	}
	public void setCurBlock(int curBlock) {
		this.curBlock = curBlock;
	}
	public int getPrevBlock() {
		return prevBlock;
	}
	public void setPrevBlock(int prevBlock) {
		this.prevBlock = prevBlock;
	}
	public int getNextBlock() {
		return nextBlock;
	}
	public void setNextBlock(int nextBlock) {
		this.nextBlock = nextBlock;
	}
	public int getStartBlockPage() {
		return startBlockPage;
	}
	public void setStartBlockPage(int startBlockPage) {
		this.startBlockPage = startBlockPage;
	}
	public int getEndBlockPage() {
		return endBlockPage;
	}
	public void setEndBlockPage(int endBlockPage) {
		this.endBlockPage = endBlockPage;
	}
	public int getBlockBegin() {
		return blockBegin;
	}
	public void setBlockBegin(int blockBegin) {
		this.blockBegin = blockBegin;
	}
	public int getBlockEnd() {
		return blockEnd;
	}
	public void setBlockEnd(int blockEnd) {
		this.blockEnd = blockEnd;
	}
	
}
	