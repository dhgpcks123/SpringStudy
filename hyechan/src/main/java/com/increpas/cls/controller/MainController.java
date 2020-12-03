package com.increpas.cls.controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
	
	@RequestMapping("/member/login.cls")	//	==>	클래스의 /member + 함수의 /login.cls = >/member/login.cls로 처리함
	public String loginPage() {
		return "member/Login";
	}
	
	@RequestMapping("/main.cls")
	public String getMain() {
		return "main";
	}
	
	
}
