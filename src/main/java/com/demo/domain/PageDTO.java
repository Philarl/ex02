package com.demo.domain;

// 페이징기능 구현목적으로 사용하는 클래스
public class PageDTO {
	
	/*
	 * 
	 * 페이지마다 데이터 출력건수 10개
	 * 
	 * 첫번째 블럭
	 * 1 2 3 4 5 [next]
	 * 
	 * 두번째 블럭
	 * [prev] 6 7 8 9 10 [next]
	 * 
	 */
	
	private int startPage; // 시작페이지번호
	private int endPage; // 끝페이지번호
	
	// [이전] [다움] 표시여부
	private boolean prev;
	private boolean next;
	
	// 게시판 테이블의 총 데이터 개수
	private int total;
	
	// 페이징정보(pageNum, amount)와 검색필드
	private Criteria cri;
	
	// total : 데이터 총 개수, pageNum : 페이지번호, amount : 출력 건수
	public PageDTO(int total, Criteria cri) {
		
		this.cri = cri;
		this.total = total;
		
		int pageSize = 10; // 블럭당 출력할 페이지 개수
		int endPageInfo = pageSize - 1;
		
		// 1 2 3 4 5
		
		// pageNum = 1, pageSize = 5
		// this.endPage = (int) Math.ceil(1 / (double) 5) * 5;
		
		// pageNum = 5, pageSize = 5
		// this.endPage = (int) Math.ceil(5 / (double) 5) * 5;
		
		this.endPage = (int) Math.ceil(cri.getPageNum() / (double) pageSize) * pageSize;
		this.startPage = this.endPage - endPageInfo;
		
		// 게시판테이블의 실제 데이터 개수에 따른 마지막 페이지(endPage)를 구해야 한다.
		int realEnd = (int) Math.ceil((total * 1.0) / cri.getAmount());
		
		if(this.endPage > realEnd) {
			this.endPage = realEnd; // 테이블 데이터 개수에 따른 실제페이지 수
		}
		
		this.prev = this.startPage > 1; // [이전] 블럭에 표시할 데이터가 존재한다는 의미
		this.next = realEnd > this.endPage; // [다음] 블럭에 표시할 데이터가 존재한다는 의미
		
		
		
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Criteria getCri() {
		return cri;
	}

	public void setCri(Criteria cri) {
		this.cri = cri;
	}

}
