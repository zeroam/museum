package kr.co.museum.utils;

public class PageMapper {
	// 시작
	private int start = 0;
	// 현재 페이지
	private int page = 1;
	// 페이지당 게시글 수
	private final int page_num = Config.PAGE_NUM;
	// 전체 글
	private int total;
	// 전체 페이지
	private int totalPage;
	// 페이지 그룹
	private int groupCurrent;
	private int groupStart;
	private int groupEnd;
	// 이전 이후 그룹
	private int groupPre;
	private int groupPost;

	public int getTotalPage() {
		return totalPage;
	}

	public int getGroupCurrent() {
		return groupCurrent;
	}

	public int getGroupStart() {
		return groupStart;
	}

	public int getGroupEnd() {
		return groupEnd;
	}

	public int getGroupPre() {
		return groupPre;
	}

	public int getGroupPost() {
		return groupPost;
	}
	
	private String searchField;
	private String searchValue;
	
	public void setMapper(int total) {
		// 전체글 초기화
		this.total = total;
		// 전체 페이지 초기화 - totalPage
		total_page(total);
		// 게시글 시작 번호 초기화 - start
		get_board_num(total, this.page);
		
		// 페이지 그룹 초기화
		this.groupCurrent = (int)Math.ceil(this.page/10.0);
		this.groupStart = (this.groupCurrent-1)*10 + 1;
		this.groupEnd = this.groupCurrent*10;
		if(this.groupEnd > this.totalPage) {
			this.groupEnd = this.totalPage;
		}
		
		// 이전.이후 그룹 초기화
		this.groupPre = 1;
		if(this.groupCurrent>2) {
			this.groupPre = (this.groupCurrent-2)*10 + 1; 
		}
		this.groupPost = this.groupCurrent*10 + 1;
		if(this.groupCurrent >= (int)Math.ceil(this.totalPage)/10.0) {
			this.groupPost = this.groupStart;
		}
	}
	
	// 전체 페이지 계산
	public void total_page(int total) {
		// 페이지당 글 갯수로 나누어 떨어질 경우
		if(total % this.page_num == 0) {
			this.totalPage = total/this.page_num;
		} else {
			this.totalPage = total/this.page_num + 1;
		}
	}
	
	// 게시글 시작 번호
	public void get_board_num(int total, int page) {
		this.start = (page-1) * this.page_num;
	}
	
	public int getPage_num() {
		return page_num;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String getSearchField() {
		return searchField;
	}
	public void setSearchField(String searchField) {
		this.searchField = searchField;
	}
	public String getSearchValue() {
		return searchValue;
	}
	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}

	public int getTotal() {
		return total;
	}
	
}
