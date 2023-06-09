package com.demo.domain;

import java.util.Date;

/*
 * VO클래스 구성가이드
 * 구성요소 - 필드, getter/setter, toString() 재정의
 * 테이블명과 클래스명은 이름이 같은 필요는 없다.
 * 컬럼명과 필드명은 보통 동일하게 한다. 동일하지 않게 할 수도 있다.
 */

public class BoardVO {
	/*
	CREATE TABLE TBL_BOARD (
	    BNO     NUMBER      PRIMARY KEY,
	    TITLE   VARCHAR2(50)    NOT NULL,
	    WRITER  VARCHAR2(50)    NOT NULL,
	    CONTENT VARCHAR2(1000)  NOT NULL,
	    REGDATE DATE    DEFAULT SYSDATE,
	    UPDATEDDATE  DATE    DEFAULT SYSDATE
	);
	 */
	
	private Long bno;	// 기본데이터타입이 아니라 참조타입을 사용.
	private String title;
	private String writer;
	private String content;
	private Date regdate;	// 날짜데이터타입은 java.util 패키지 사용.
	private Date updateddate;
	
	public Long getBno() {
		return bno;
	}
	public void setBno(Long bno) {
		this.bno = bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public Date getUpdateddate() {
		return updateddate;
	}
	public void setUpdateddate(Date updateddate) {
		this.updateddate = updateddate;
	}
	
	@Override
	public String toString() {
		return "BoardVO [bno=" + bno + ", title=" + title + ", writer=" + writer + ", content=" + content + ", regdate="
				+ regdate + ", updateddate=" + updateddate + "]";
	}
	

}
