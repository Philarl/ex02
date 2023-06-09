package com.demo.service;

import java.util.List;

import com.demo.domain.BoardVO;
import com.demo.domain.Criteria;

public interface BoardService {
	
	public void insert(BoardVO board);
	
	public List<BoardVO> getList();
	
	public List<BoardVO> getListWithPaging(Criteria cri);
	
	public int getTotalCount(Criteria cri);
	
	public BoardVO get(Long bno);
	
	public void modify(BoardVO vo);
	
	public void delete(Long bno);

}
