package com.increpas.cls.service;

import java.util.List;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.servlet.*;

import com.increpas.cls.dao.*;
import com.increpas.cls.util.*;
import com.increpas.cls.vo.*;

public class GBoardService {

	@Autowired
	GBoardDao gDao;
	
	public void setGBoardPage(ModelAndView mv, HttpSession session, PageUtil page,
							GBoardVO gVO) {
		// 할일
		// 세션에서 아이디 꺼내오고
		String sid = (String) session.getAttribute("SID");
		
		// vo에 id 넣고
		if(sid != null) {
			gVO.setId(sid);
			String afile = gDao.getAvatar(sid);
			mv.addObject("AVATAR", afile);
		}
		page.getNowPage();
		// page 완성하고
		int total = gDao.getTotal();
		page.setTotalCount(total);
		page.setPage();
		// vo에 page 담고
		gVO.setPage(page);
		// 방명록 리스트 가져오고
		List<GBoardVO> list = gDao.getList(gVO);
		
		// 뷰에 데이터 심고
		mv.addObject("LIST", list);
		mv.addObject("CNT", list.get(0).getCnt());
		mv.addObject("PAGE", page);
		
		mv.setViewName("guestBoard/gBoardList");
	}
}
