package com.increpas.cls.controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
	
	@RequestMapping("/main.cls")
	public String getMain() {
		return "main";
	}
	
	
}
