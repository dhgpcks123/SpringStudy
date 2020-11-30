package com.increpas.cls.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;
import org.springframework.web.servlet.view.*;

import com.increpas.cls.dao.*;
import com.increpas.cls.vo.*;

@Controller
@RequestMapping("/member")
public class Member {

	@Autowired
	MemberDao mDao;
	
	@RequestMapping("/login.cls")	//	==>	클래스의 /member + 함수의 /login.cls = >/member/login.cls로 처리함
	public String loginPage() {
		return "member/Login";
	}
	
	
	@RequestMapping(path="/loginProc.cls", params={"id","pw"}, method=RequestMethod.POST)
	public ModelAndView loginProc(ModelAndView mv, RedirectView rd,
									HttpSession session, MemberVO mVO) {
		//매개변수에 기입하잖아? Spring이 new시켜서 제공해줘... ㄹㅇ..
		
		int cnt = mDao.loginCnt(mVO);
		System.out.println("### cont login cnt : " + cnt);
		if(cnt == 0) {
			rd.setUrl("/cls/member/login.cls");
		}else{
			session.setAttribute("SID", mVO.getId());
			rd.setUrl("/cls/main.cls");
		}
		mv.setView(rd);
		return mv;
	}
	
	
}
