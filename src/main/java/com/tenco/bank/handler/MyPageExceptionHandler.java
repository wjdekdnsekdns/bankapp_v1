package com.tenco.bank.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.tenco.bank.handler.exception.CustompageException;

/**
 * 
 * view 렌더링을 위해 ModelAndView
 * 객체를 반환하도록 기본 설정 되어 있다
 * 예외 page를 리턴하도록 활용 예정
 *
 */
@ControllerAdvice
public class MyPageExceptionHandler {

	// 사용자 정의 클래스 활용
	@ExceptionHandler(CustompageException.class)
	public ModelAndView handleRuntimePageException(CustompageException e) {
		// ModelAndView 활용 방법
		ModelAndView modelAndView = new ModelAndView("errorPage");
		modelAndView.addObject("statusCode",HttpStatus.NOT_FOUND.value());
		modelAndView.addObject("message",e.getMessage());
		return modelAndView;
	}
	
}
