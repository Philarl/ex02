package com.demo.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.demo.domain.BoardVO;
import com.demo.domain.Criteria;
import com.demo.mapper.BoardMapper;

// 관련설정 : root-context.xml에서
// <context:component-scan base-package="com.demo.service" /> bean 생성이 됨
// bean name : boardServiceImpl

@Service
public class BoardServiceImpl implements BoardService {
	
	@Inject
	private BoardMapper boardMapper;
	
	@Override
	public void insert(BoardVO board) {
		
		boardMapper.insert(board);
		
	}

	@Override
	public List<BoardVO> getList() {
		
		return boardMapper.getList();
	}

	@Override
	public BoardVO get(Long bno) {
		
		return boardMapper.get(bno);
	}

	@Override
	public void modify(BoardVO vo) {
		
		boardMapper.modify(vo);
		
	}

	@Override
	public void delete(Long bno) {
		
		boardMapper.delte(bno);
		
	}

	@Override
	public List<BoardVO> getListWithPaging(Criteria cri) {
		return boardMapper.getListWithPaging(cri);
	}

	@Override
	public int getTotalCount(Criteria cri) {
		return boardMapper.getTotalCount(cri);
	}
	
	

}
