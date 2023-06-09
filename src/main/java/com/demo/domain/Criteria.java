package com.demo.domain;

// 검색기능 및 페이징 정보를 가지고 있는 클래스

public class Criteria {
	
	private int pageNum;	// 선택한 페이지 번호. 1 2 3 4 5
	private int amount;		// 페이지마다 출력할 게시물 개수. 5개, 10, 15, 20
	
	// 검색기능에 사용할 필드. 목록에서 검색기능을 사용하지 않을 경우 type, keyword 필드는 null이 됨.
	private String type;
	private String keyword;
	
	public Criteria() {
		this(1, 10);
		
	}
	
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	// mapper xml에서 참조
	// 검색기능 사용한 경우 type: TWC
	public String[] getTypeArr() {
		return type == null ? new String[] {} : type.split(""); // "T", "W", "C"
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	

}
