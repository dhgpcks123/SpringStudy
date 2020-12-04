package com.increpas.cls.controller;

import java.util.*;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import com.increpas.cls.dao.*;
import com.increpas.cls.service.*;
import com.increpas.cls.util.*;
import com.increpas.cls.vo.*;

@Controller
@RequestMapping("/guestBoard")
public class GuestBoard {

	
		@Autowired
		GBoardDao gDao;
		@Autowired
		GBoardService gService;
		
		//방명록 리스트 폼 보기 요청 처리함수
		@RequestMapping(path={"/guestBoard.cls", "/gBoardList.cls"})
		public ModelAndView gBoardForm(ModelAndView mv, HttpSession session, PageUtil page,
										GBoardVO gVO) {
			gService.setGBoardPage(mv, session, page, gVO);
			return mv;
		}
		
		//방명록 글 등록 요청 처리함수
		@RequestMapping("/gBoardWrite.cls")
		public ModelAndView guestBoardWrite(ModelAndView mv, HttpSession session, GBoardVO gVO) {
			String sid = (String) session.getAttribute("SID");
			gVO.setId(sid);
			System.out.println(gVO.getBody());
			System.out.println(gVO.getId());
			int cnt = gDao.writeBoard(gVO);
			System.out.println(gVO.getGno());
			System.out.println("cnt 값" + cnt);
			if(cnt ==1) {
				//글 등록에 성공한 경우
				mv.setViewName("redirect:/guestBoard/guestBoard.cls");
				System.out.println(" 글 등록 성공");
			}else{
				//글 등록에 실패한 경우 (세선 끊어짐)
				mv.setViewName("redirect:/member/login.cls");
				System.out.println(" 글 등록 실패");
			}
			return mv;
		}
}
