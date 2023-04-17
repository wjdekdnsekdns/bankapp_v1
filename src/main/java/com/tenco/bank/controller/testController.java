package com.tenco.bank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class testController {

	// VIewResolver 동작
	// prefix : /WEB-INF/view/
	// suffix : .jsp
	// --> layout/main
	// 파일 이름 리턴 처리
	@GetMapping("/main")
	public String maintest() {
		
		return "layout/main";
		
	}
}
