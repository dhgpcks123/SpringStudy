package com.increpas.cls.controller;

import java.util.*;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import com.increpas.cls.vo.MemberVO;
import com.increpas.cls.vo.ReBoardVO;
import com.increpas.cls.dao.*;
import com.increpas.cls.service.*;
import com.increpas.cls.util.*;

@Controller
@RequestMapping("/reBoard")
public class ReBoard {

	@Autowired
	ReBoardDao rDao;
	@Autowired
	MemberDao mDao;
	
	// 댓글게시판 게시글보기 요청
	@RequestMapping("/reBoard.cls")
	public ModelAndView reBoardList(ModelAndView mv, PageUtil page, ReBoardVO rVO, HttpSession session) {
		int totalCount = rDao.totoalCount();
		int nowPage = rVO.getNowPage();
		if(session.getAttribute("SID") ==null) {
			mv.setViewName("redirect:/member/login.cls");
			return mv;
		}
		if(nowPage == 0) {
			nowPage = 1;
		}
		try {
			
			page.setPage(nowPage, totalCount);
			rVO.setPage(page);
			List<ReBoardVO> list = rDao.reBoardList(rVO);
			//아바타 가져오기
			String avatar = rDao.getAvtImg((String)session.getAttribute("SID"));
			mv.addObject("AVTIMG", avatar);
			mv.addObject("PAGE", page);
			mv.addObject("LIST",list);
		}catch(Exception e) {}
		
		mv.setViewName("/reBoard/reBoard");
		return mv;
	}
	
	//댓글게시판 더미데이터 삽입 요청
	@RequestMapping("/initRBD.cls")
	public ModelAndView initRBD(ModelAndView mv) {
		ReBoardService init = new ReBoardService();
		ArrayList<ReBoardVO> list = init.list;
		int cnt = rDao.initRBDList(list);
		System.out.println(cnt+"의 댓글이 업데이트 되었습니다.");
		//DB에 데이터 넣는 작업, 업데이트하는 작업같은 경우 redirect시켜주자
		mv.setViewName("redirect:/reBoard/reBoard.cls");
		return mv;
	}
	
	//원글 쓰기 처리요청
	@RequestMapping("/reBoardWriteProc.cls")
	public ModelAndView reBoardWriteProc(ModelAndView mv, ReBoardVO rVO, HttpSession session) {
		if(session.getAttribute("SID") == null) {
			mv.setViewName("/main");
			return mv;
		}
		int cnt = rDao.reBoardWriteProc(rVO);
		System.out.println("등록된 글 수 : " + cnt);
		mv.setViewName("redirect:/reBoard/reBoard.cls");
		return mv;
	}
	
	//게시판 글삭제 요청
	@RequestMapping("/reBoardDelProc.cls")
	public ModelAndView reBoardDelProc(ModelAndView mv, ReBoardVO rVO) {
		int cnt = rDao.reBoardDelProc(rVO);
		mv.setViewName("redirect:/reBoard/reBoard.cls");
		return mv;
	}
	
	//게시판 글수정 폼보기 요청
	@RequestMapping("reBoardEditView.cls")
	public ModelAndView reBoardEditView(ModelAndView mv, ReBoardVO rVO) {
		mv.setViewName("/reBoard/reBoardEdit");
		return mv;
	}
	
	//게시판 글수정처리 요청
	@RequestMapping("reBoardEditProc.cls")
	public ModelAndView reBoardEditProc(ModelAndView mv, ReBoardVO rVO) {
		int cnt = rDao.reBoardEditProc(rVO);
		if(cnt == 1) {
			mv.setViewName("redirect:/reBoard/reBoard.cls");
			System.out.println("업데이트 성공");
		}else{
			mv.setViewName("/reBoard/reBoardEdit");			
		}
		return mv;
	}
	
	//댓글게시판 댓글작성 폼 요청
	@RequestMapping("reBoardComment.cls")
	public ModelAndView reBoardComment(ModelAndView mv, ReBoardVO rVO) {
		mv.setViewName("/reBoard/reBoardComment");
		return mv;
	}
	//댓글게시판 입력요청
	@RequestMapping("reBoardCommentProc.cls")
	public ModelAndView reBoardCommentProc(ModelAndView mv, ReBoardVO rVO, HttpSession session) {
		if(session.getAttribute("SID") == null) {
			mv.setViewName("redirect:/member/login.cls");
			return mv;
		}
		String sid = (String)session.getAttribute("SID");
		rVO.setId(sid);
		int cnt = rDao.reBoardCommentProc(rVO);
		
		mv.setViewName("redirect:/reBoard/reBoard.cls");
		return mv;
	}
	
}
