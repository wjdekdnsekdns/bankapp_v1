package com.tenco.bank.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tenco.bank.handler.exception.CustomRestfullException;
import com.tenco.bank.handler.exception.UnAuthorizedException;

/**
 * 예외 시
 * 데이터를 내려 줄 수 있다
 *
 */
@RestControllerAdvice // IoC 대상 + AOP 기반
public class MyRestfullExceptionHandler {

	@ExceptionHandler(Exception.class)
	public void exception(Exception e) {
		System.out.println(e.getClass().getName());
		System.out.println(e.getMessage());
	}
	// 사용자 정의 예외 클래스 활용
	@ExceptionHandler(CustomRestfullException.class)
	public String basicException(CustomRestfullException e) {
		StringBuffer sb = new StringBuffer();
		sb.append("<script>");
		// 반드시 마지막에 ; 콜론을 붙어서 사용하자
		sb.append("alert('"+e.getMessage() +"');");
		sb.append("history.back();");
		sb.append("</script>");
		return sb.toString();
	}
	
	// 사용자 정의 예외 클래스 활용
	@ExceptionHandler(UnAuthorizedException.class)
	public String unAuthorizedException(UnAuthorizedException e) {
		StringBuffer sb = new StringBuffer();
		sb.append("<script>");
		// 반드시 마지막에 ; 콜론을 붙어서 사용하자
		sb.append("alert('"+e.getMessage() +"');");
		sb.append("location.href='/user/sign-in;'");
		sb.append("</script>");
		return sb.toString();
	}
}
