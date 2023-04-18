package com.tenco.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tenco.bank.dto.SignInFormDto;
import com.tenco.bank.dto.SignUpFormDto;
import com.tenco.bank.handler.exception.CustomRestfullException;
import com.tenco.bank.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired // DI 처리
	private UserService userService;
	
	// http://localhost:8080/user/sign-up
	@GetMapping("/sign-up")
	public String signUp() {

		return "/user/signUp";
	}

	/**
	 * 회원 가입 처리
	 * 
	 * @param SignUpFormDto
	 * @return 리다이렉트 로그인 페이지
	 */
	@PostMapping("/sign-up")
	public String signUpProc(SignUpFormDto signUpFormDto) {
		// 1. 유효성 검사
		if(signUpFormDto.getUsername() == null || signUpFormDto.getUsername().isEmpty()) {
			throw new CustomRestfullException("username을 입력해주세요", HttpStatus.BAD_REQUEST);
		}
		if(signUpFormDto.getPassword() == null || signUpFormDto.getPassword().isEmpty()) {
			throw new CustomRestfullException("password을 입력해주세요", HttpStatus.BAD_REQUEST);
		}
		if(signUpFormDto.getFullname() == null || signUpFormDto.getFullname().isEmpty()) {
			throw new CustomRestfullException("fullname을 입력해주세요", HttpStatus.BAD_REQUEST);
		}
		// 서비스 호출
		userService.signUp(signUpFormDto);
		return "redirect:/user/sign-in";
	}

	/**
	 * 로그인 폼
	 * 
	 * @return 로그인 페이지 리턴
	 */
	@GetMapping("/sign-in")
	public String signIn() {

		return "/user/signIn";
	}

	/**
	 * 로그인 처리
	 * @param signInFormDto
	 * @return 메인 페이지 이동 ( 수정 예정)
	 */
	@PostMapping("/sign-in")
	public String signInProc(SignInFormDto signInFormDto) {

		//todo 변경 예정
		return "user/signIn";
	}
	
	
}
