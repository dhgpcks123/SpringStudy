package com.increpas.cls.controller;

import java.util.*;

import javax.servlet.http.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import com.increpas.cls.dao.*;
import com.increpas.cls.util.*;
import com.increpas.cls.vo.*;

@Controller
@RequestMapping("/reBoard1")
public class ReBoard1 {

	@Autowired
	ReBoardDao1 reDao;
	
	private static final Logger log1 = LoggerFactory.getLogger(ReBoard1.class);
	//	댓글 게시글 목록 조회 요청 처리함수
	//	:	이 함수는 1번 페이지 전용이 아니고
	//		모든 페이지에 대한 요청을 처리해주는 함수이다.
	@RequestMapping("/reBoardList.cls")
	public ModelAndView reBoardList(ModelAndView mv, PageUtil page, HttpSession session, MemberVO mVO) {
		// page를 vo처럼 nowPage를 담아서 사용하면 된다. mv굳이 안 쓰고.
		int total = reDao.getTotal();
		// PageUtil 완성하고
		page.setPage(total);
		// 데이터심고
		mv.addObject("PAGE", page);
		
		// 아바타 가져오고
		String str = mVO.getAvatar();
		//로그아웃 상태에서 댓글게시판 접근할 때 오류나서 처리해줌
		if(str == null && session.getAttribute("SID") != null) {
			// 아바타 심고
			String avatar = reDao.getAvatar((String)session.getAttribute("SID"));
			mv.addObject("AVTIMG", avatar);
		}
		
		// 게시글 리스트 가져오기
		List<ReBoardVO> list = reDao.getList(page);
		// 리스트데이터 뷰에 심고
		mv.addObject("LIST", list);
		
		// 뷰 부르고
		mv.setViewName("reBoard1/reBoard");
		return mv;
	}
	
	// 게시글 삭제 요청 처리
	@RequestMapping("/reBoardDelProc.cls")
	public ModelAndView reBoardDelProc(ModelAndView mv, ReBoardVO rVO, HttpSession session) {
		int cnt = reDao.delReBoard(rVO.getBno());
		if(cnt > 0) {
			log1.info((String)session.getAttribute("SID")+" ] 회원 : [" + rVO.getBno() + "] 관련 글 [ "+ cnt+" ] 개 삭제 -----" );
		}
		mv.setViewName("/reBoard1/redirectView");
		
		return mv;
	}
	// 답글달기 처리요청
	@RequestMapping("reBoardComment.cls")
	public ModelAndView reBoardComment(ModelAndView mv) {
		
		mv.setViewName("/reBoard1/reBoardComment");
		return mv;
	}
	
}

	
