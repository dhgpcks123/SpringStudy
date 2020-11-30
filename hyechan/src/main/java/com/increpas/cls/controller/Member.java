package com.increpas.cls.controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
@Controller
public class Member {

	@RequestMapping("/member/login.cls")
	public String loginPage() {
		
		return "member/Login";
	}
}
