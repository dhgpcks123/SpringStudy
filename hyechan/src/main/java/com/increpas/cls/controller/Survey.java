package com.increpas.cls.controller;

import java.util.*;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import com.increpas.cls.dao.*;
import com.increpas.cls.util.*;
import com.increpas.cls.vo.*;

@Controller
@RequestMapping("/survey")
public class Survey {
	
	@Autowired
	SurveyDao sDao;
	@Autowired
	W3Color w3color;
	
	
	@RequestMapping("/surveyInfo.cls")
	public ModelAndView surveyInfo(ModelAndView mv, HttpSession session) {
		String id = (String) session.getAttribute("SID");
		if(id == null) {
			mv.setViewName("redirect:/member/login.cls");
			return mv;
		}
		List<SurveyVO> list = sDao.getCurList(id);
		//데이터 심고
		mv.addObject("LIST", list);
		
		//뷰 부르고...
		mv.setViewName("survey/surveyInfo");
		return mv;
	}
	
	@RequestMapping("/survey.cls")
	public ModelAndView survey(ModelAndView mv, int sno) {
		List<SurveyVO> list = sDao.getQuestList(sno);
		mv.addObject("LIST", list);
		mv.addObject("SNO", sno);
		mv.setViewName("survey/survey");
		return mv;
	}
	
	@RequestMapping("/surveyResult.cls")
	public ModelAndView surveyResult(ModelAndView mv, int sno) {
		List<SurveyVO> list = sDao.surveyResult(sno);
		mv.addObject("LIST", list);
		mv.addObject("COLOR", w3color);
		mv.setViewName("survey/surveyResult");
		return mv;
	}
	
	@RequestMapping("/surveyProc.cls")
	public ModelAndView surveyProc(ModelAndView mv, SurveyVO vo) {
//	public ModelAndView surveyProc(ModelAndView mv, HttpServletRequest req, SurveyVO vo) {
		ArrayList<SurveyVO> list = new ArrayList<SurveyVO>();
		for(int no : vo.getAqno()) {
			SurveyVO sVO = new SurveyVO();
			sVO.setId(vo.getId());
			sVO.setSno(vo.getSno());
			sVO.setQno(no);
			list.add(sVO);
		}
		
		
		// 할 일
		// 파라미터 꺼내고
		// 문제는 어떤 키 값으로 데이터가 넘어오는지 모른다는 것이다
		
		/*
		Enumeration en = req.getParameterNames();
		ArrayList<SurveyVO> list = new ArrayList<SurveyVO>();
		while(en.hasMoreElements()) {
			SurveyVO sVO = new SurveyVO();
			sVO.setId(vo.getId());
			sVO.setSno(vo.getSno());//굳이 vo만들어 쓰는 이유? 형변환 ㅎ
			
			String key = (String)en.nextElement();
			if(key.equals("cnt") || key.equals("id") || key.equals("sno")) {
				continue;
			}
			sVO.setQno(Integer.parseInt(req.getParameter(key)));
			
			list.add(sVO);
		}
		*/
		int cnt = 0;
		try {
			cnt = sDao.addAnswer(list);
			mv.addObject("SNO", vo.getSno());
			mv.setViewName("survey/surveyRedirect");
			mv.addObject("VIEW", "/cls/survey/surveyResult.cls");
		}catch(Exception e) {
			e.printStackTrace();
			cnt = 0;
			mv.addObject("SNO", vo.getSno());
			mv.addObject("VIEW", "/cls/survey/surveyResult.cls");
			mv.setViewName("survey/surveyRedirect");
		}
		
		return mv;
	}
	
}
