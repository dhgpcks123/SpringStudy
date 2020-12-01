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
/*	
	@RequestMapping("/join.cls")
	public String joinForm() {
		return "member/join";
	}
	@RequestMapping("/join.cls")
	public void joinForm() {
		
		 	이 컨트롤러의 역할은 회원가입 뷰를 띄워주는 것이다.
		 	이 말은 뷰만 보여주면 된다. 그런데 반환값타입이 void인 경우는 요청내용을 이용해서
		 	보여줄 뷰를 선택한다.
		 		이 함수의 요청내용은 localhost/cls/member/join.cls이고
		 	이걸 이용해서 보여주는 뷰는 /WEB-INF/ + member/join + jsp로 만들어진다.
	}
*/
	@RequestMapping("/join.cls")
	public ModelAndView joinForm(HttpSession session, RedirectView rd, ModelAndView mv) {
		 	
//		 이 함수내에서 처리할 내용이 로그인 되어있는 회원의 경우는 리다이렉트로 main.cls로 보낸다
		String sid = (String) session.getAttribute("SID");
		if(sid != null || sid.trim().length() != 0) {
			rd.setUrl("/cls/main.cls");
			mv.setView(rd);	//	redirect로 뷰를 호출하는 경우
		} else {
			mv.setViewName("member/join"); // forward로 뷰를 부르는 경우
		}
		return mv;
	}
}
