package com.increpas.cls.controller;

import javax.servlet.http.*;
import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;
import org.springframework.web.servlet.view.*;

import com.increpas.cls.dao.*;
import com.increpas.cls.util.*;
import com.increpas.cls.vo.*;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.*;

@Controller
@RequestMapping("/member")
public class Member {

	@Autowired
	MemberDao mDao;
	@Autowired
	W3Color w3color;
/*
	이거 말고 그냥 매개변수에 W3Color w3color에 넣어줘도
	알아서 객체 만들어서 해준다. 근데 @Autowired가 원칙임
	사용빈도가 낮으면 매개변수에 넣어서 해줘
	Dao같은 거? 함수 쓸 때 마다 new시키는 꼴인거잖아.
	빈처리하면 처음에 한 거 그냥 가져다 쓰는거잖아. 뒤에꺼가 더 좋지.
 */
	
	@RequestMapping("/login.cls")	//	==>	클래스의 /member + 함수의 /login.cls = >/member/login.cls로 처리함
	public String loginPage() {
		return "member/Login";
	}
	
	
	@RequestMapping(path="/loginProc.cls", params={"id","pw"}, method=RequestMethod.POST)
	public ModelAndView loginProc(ModelAndView mv, RedirectView rd,
									HttpSession session, MemberVO mVO) {
		//매개변수에 기입하잖아? Spring이 new시켜서 제공해줘... ㄹㅇ..
		
		int cnt = mDao.loginCnt(mVO);
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
	public ModelAndView joinForm(HttpSession session, ModelAndView mv) {
//	public ModelAndView joinForm(HttpSession session, RedirectView rd, ModelAndView mv) {
//		이 함수내에서 처리할 내용이 로그인 되어있는 회원의 경우는 리다이렉트로 main.cls로 보낸다
		String sid = (String) session.getAttribute("SID");
		if(sid != null) {
			/*
			rd.setUrl("/cls/main.cls");
			mv.setView(rd);	//	redirect로 뷰를 호출하는 경우
			*/
			mv.setViewName("redirect:/main.cls"); // == redirect로 새롭게 요청하는 경우
		} else {
			//데이터만들고
			List<AvatarVO> list = mDao.getAvtList();
			//데이터 뷰 심고
			mv.addObject("LIST", list);
			//뷰 부르고
			mv.setViewName("member/join"); // forward로 뷰를 부르는 경우
		}
		return mv;
	}
	
	/* ResponseBody. Json 객체로 반환해줘 */
	@RequestMapping("/idCheck.cls")
	@ResponseBody
	public HashMap<String, String> idCheck(String id) {
		// 할 일
		// 데이터베이스에서 조회하고
		// 참고 json 형식 var 변수 = {키값:데이터, 키값:데이터};
		
		HashMap<String, String> map = new HashMap<String, String>();
		/*
		int cnt = mDao.getIdCnt(id);
		String result =(cnt==0)?"OK":"NO" ;
		map.put("'result'", "'"+result+"'");
		  		▽ 한 줄로 줄입시다
		 */
		map.put("result", (mDao.getIdCnt(id) == 0) ? "OK" : "NO");
		//==> { 'result':'OK' } or { 'result':'NO' }
		return map;
	}
	@RequestMapping(value="/joinProc.cls", method=RequestMethod.POST)
	@ResponseBody
	public String joinProc(HttpServletRequest req, HttpSession session, MemberVO mVO) {
		MultipartRequest multi;
		String path = req.getSession().getServletContext().getRealPath("resources/img/upload");
		String result ="OK";
		try {
			multi = new MultipartRequest(req, path, 1024*1024*10, "UTF-8", new DefaultFileRenamePolicy());
			
			String id= multi.getParameter("id");
			String pw = multi.getParameter("pw");
			String name = multi.getParameter("name");
			String mail = multi.getParameter("mail");
			String gen = multi.getParameter("gen");
			String sno = multi.getParameter("avt");
			int avt = Integer.parseInt(sno);
			
			mVO.setId(id);
			mVO.setPw(pw);
			mVO.setName(name);
			mVO.setMail(mail);
			mVO.setGen(gen);
			mVO.setAvt(avt);
			System.out.println(id);
			
			int cnt = mDao.insertMember(mVO);
			if(cnt == 1) {
				session.setAttribute("SID", id);
			} else {
				result = "NO";
			}
		}catch(Exception e) {
			System.out.println("###데이터 전송 실패###");
			e.printStackTrace();
		}
		String str ="";
			System.out.println(mVO.getId() +" 엄... ");
		str = mVO.getId();
		return result;
	}
	/*
	@RequestMapping("/joinProc.cls")
	public ModelAndView joinProc(ModelAndView mv, HttpSession session, MemberVO mVO) {
		System.out.println("/joinProc 동기 처리");
		// 할일
		// 데이터베이스 작업하고
		int cnt = mDao.insertMember(mVO);
		if(cnt == 1) {
			// 성공하면 로그인처리하고
			session.setAttribute("SID", mVO.getId());
			// 메인페이지로 이동하고
			mv.setViewName("redirect:/main.cls");
		}else {
			// 실패한 경우
			// 회원가입페이지로 다시 이동시키고
			mv.setViewName("redirect:/member/join.cls");
		}
		return mv;
	}
	*/
	
	
	@RequestMapping("/memberInfo.cls")
	public ModelAndView getInfo(ModelAndView mv, HttpSession session, RedirectView rv) {
		String sid = (String) session.getAttribute("SID");
		if(sid ==null) {
			rv.setUrl("/cls/member/login.cls");
			mv.setView(rv);	//redirect로 뷰를 호출하는 경우
		}else {
			mv.setViewName("member/memberInfo");//forward로 뷰를 부르는 경우
			MemberVO mVO = mDao.getInfo(sid);
			mv.addObject("DATA", mVO);
		}
		return mv;
	}
	
	@RequestMapping("/memberInfo2.cls")
	@ResponseBody
	public MemberVO getInfo(MemberVO mVO) {
		mVO = mDao.getInfo(mVO.getMno());
		return mVO;
	}
	
	
	//요청하는데 mno파라미터 넘기면서 POST방식으로 요청시키는 경우 아래에꺼 실행시켜라.
	@RequestMapping(value="/memberInfo.cls", params="mno", method=RequestMethod.POST)
	public ModelAndView getInfo(ModelAndView mv, HttpSession session, RedirectView rv, int mno) {
			MemberVO mVO = mDao.getInfo(mno);
			mv.addObject("DATA", mVO);
			mv.setViewName("member/memberInfo");	//forward로 뷰를 부르는 경우
		return mv;
	}
	
	@RequestMapping("/logout.cls")
	public ModelAndView logout(ModelAndView mv, HttpSession session) {
		
		//세션에 기록 내용(속성 : SID)을 지운다.
		session.removeAttribute("SID");
		// 뷰를 지정한다.
		mv.setViewName("redirect:/main.cls");

		return mv;
	}
	
	@RequestMapping(value="/memberDel.cls", method=RequestMethod.POST)
	public ModelAndView memberDel(ModelAndView mv, MemberVO mVO, HttpSession session) {
		int cnt = mDao.outMember(mVO);
		if(cnt == 1) {
			// 이 경우는 회원탈퇴에 성공한 경위므로
			// 세션에 기록된 데이터 지우고 메인페이지로 돌려보낸다.
			session.removeAttribute("SID");
			mv.setViewName("redirect:/main.cls");
		}else {
			// 이 경우는 처리에 실패한 경우이므로, 회원상세정보페이지로 다시 보낸다.
			mv.setViewName("redirect:/member/memberInfo.cls");
		}
		
		return mv;
	}
	
	
	@RequestMapping("/nameList")
	public ModelAndView getList(ModelAndView mv) {
		
		List<MemberVO> list = mDao.getNameList();
		//데이터를 뷰에 전달하는 방법
		mv.addObject("LIST", list);
		ArrayList<String> color = w3color.getList();
		mv.addObject("COLOR", color);
		mv.setViewName("member/memberList");
		
		return mv;
	}	
	
	
}
