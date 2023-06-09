package com.demo.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demo.domain.BoardVO;
import com.demo.domain.Criteria;
import com.demo.domain.PageDTO;
import com.demo.service.BoardService;

// 게시판의 기능의 주소요청을 담당하는 목적

@Controller // Bean이름 : boardController
@RequestMapping("/board/*")
public class BoardController {
	
	@Inject
	private BoardService boardService;
	
	// 글쓰기 폼
	@GetMapping("/insert")
	public void insert() {
		
	}
	
	// 글쓰기 저장
	@PostMapping("/insert")
	public String insert(BoardVO board) {
		
		boardService.insert(board);
		
		return "redirect:/board/list";
	}
	
	// 게시물 목록 : 페이지 기능이 없음.
//	@GetMapping("/list")
//	public void list(Model model) {
//		
//		List<BoardVO> list = boardService.getList();
//		
//		model.addAttribute("boardList", list);
//		
//	}
	
	// 처음 시작시 주소: /board/list 요청하면, Criteria 클래스의 기본생성자가 동작된다.
	@GetMapping("/list") // cri <- pageNum, amount
	public void list(Criteria cri, Model model) {
		
		// 1) Model객체. 목록데이터
		List<BoardVO> list = boardService.getListWithPaging(cri);
		model.addAttribute("boardList", list);
		
		// pageDTO클래스 객체생성 작업
		// 1 2 3 4 5
		int total = boardService.getTotalCount(cri);
		
		// 1) Model객체. 페이징 기능 정보
		// 처음에 Criteria 생성자 호출되어, pageNum = 1, amount = 10
		PageDTO pageDTO = new PageDTO(total, cri);
		model.addAttribute("pageMaker", pageDTO);
	}
	
	// 게시물 읽기, 수정폼
	@GetMapping(value = {"/get", "/modify"})
	public void get(@RequestParam("bno") Long bno, @ModelAttribute("cri") Criteria cri, Model model) {
		// 서비스 호출
		/*
		BoardVO board = boardService.get(bno);
		model.addAttribute("board", board);
		*/
		model.addAttribute("board", boardService.get(bno));
	}
	
	// 글 수정하기
	@PostMapping("/modify")
	public String modify(BoardVO vo, Criteria cri, RedirectAttributes rttr) {
		
		boardService.modify(vo);
		
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		return "redirect:/board/list";
	}
	
	// 글 삭제하기
	@GetMapping("/delete")
	public String delete(Long bno, Criteria cri, RedirectAttributes rttr) {
		
		boardService.delete(bno);
		
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		return "redirect:/board/list";
	}

}
