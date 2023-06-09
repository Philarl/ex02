package com.demo.mapper;

import java.util.List;

import com.demo.domain.BoardVO;
import com.demo.domain.Criteria;

// Mapper Interface와 관련된 설정 - root-context.xml에서 <mybatis-spring:scan base-package="com.demo.mapper"/>
// bean으로 생성이 된다.

// Mapper Interface와 Mapper XML 파일을 생성. 이름은 동일해야한다.
public interface BoardMapper {
	
	// 메소드명과 Mapper XML의 id이름이 동일해야 한다.
	// Service 층에서 Mapper Interface의 메소드명이 호출되면, Mapper XML의 메소드명과 일치되는 id의 SQL 구문이 동작된다.
	public void insert(BoardVO board);
	
	// 테이블의 데이터 개수가 유동적이기 때문에 배열은 적합하지 않다.
	// 동적인 기억장소를 제공하는 컬렉션 중에서도 순서가 유지되는 List컬렉션을 사용
	public List<BoardVO> getList();
	
	// 1) 페이징 기능
	public List<BoardVO> getListWithPaging(Criteria cri); // 처음 pageNum = 1, amount = 10, type = null, keyword = null
	// 2) 페이징 기능
	public int getTotalCount(Criteria cri);
	
	// 게시물 읽기 정보
	public BoardVO get(Long bno);
	
	// 게시물 수정하기
	public void modify(BoardVO vo);
	
	public void delte(Long bno);

}
