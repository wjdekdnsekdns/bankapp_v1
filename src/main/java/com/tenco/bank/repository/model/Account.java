package com.tenco.bank.repository.model;

import java.sql.Timestamp;

import org.springframework.http.HttpStatus;

import com.tenco.bank.handler.exception.CustomRestfullException;

import lombok.Data;

/**
 * 
 * 모델 클래스 (value Object 역할만 하는것은 아니다)
 *
 */
@Data
public class Account {

	private Integer id;
	private String number;
	private String password;
	private long balance;
	private Integer userId;
	private Timestamp createdAt;

	public void withdraw(Long amount) {
		this.balance -= amount;
	}

	public void deposit(Long amount) {
		this.balance += amount;
	}

	// 패스워드 체크
	public void checkPassword(String password) {
		if(this.password.equals(password) == false) {
			throw new CustomRestfullException("계좌 비밀번호가 틀렸습니다", HttpStatus.BAD_REQUEST);
		}
	}
	// 잔액 여부 확인 (출금시)
	public void checkBalance(Long amount) {
		if(this.balance < amount) {
			throw new CustomRestfullException("출금 잔액이 부족 합니다", HttpStatus.FORBIDDEN);
		}
	}
	// 계좌 소유자 확인
	public void checkOwner(Integer principalId) {
		if (this.userId != principalId) {
			throw new CustomRestfullException("계좌소유가 아님", HttpStatus.FORBIDDEN);
		}
	}
}
