package com.tenco.bank.repository.model;

import java.sql.Timestamp;

/**
 * 
 *  모델 클래스 (value Object 역할만 하는것은 아니다)
 *
 */
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
	// 잔액 여부 확인 (출금시)
	// 계좌 소유자 확인
}
