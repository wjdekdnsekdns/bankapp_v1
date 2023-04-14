-- 유저 테이블 설계해 보기
CREATE TABLE user_tb(
	id int PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) not null UNIQUE,
    password VARCHAR(30) not null,
    fullname VARCHAR(50) not null,
    created_at TIMESTAMP not null DEFAULT now()
);

-- 사용자에 계좌 정보 테이블
CREATE TABLE account_tb(
	id int AUTO_INCREMENT PRIMARY KEY,
    number varchar(30) not null UNIQUE,
    password VARCHAR(20) not null,
    balance BIGINT not null COMMENT '계좌 잔액',
    user_id int,
    created_at TIMESTAMP not null DEFAULT now()
);
-- 입금 내역 저장
-- 출금 내역 저장
-- 사용자간 이체 내역 저장
-- 사용자들에 history 테이블 설계
-- BIGINT 8바이트 크기에 정수형
CREATE TABLE history_tb(
	id int AUTO_INCREMENT PRIMARY KEY COMMENT'거래 내역',
    amount BIGINT not null COMMENT'거래 금액',
    w_account_id int COMMENT'출금 계좌 id',
    d_account_id int COMMENT'입금 계좌 id',
    w_balance BIGINT COMMENT'출금요청된 계좌에 잔액',
    d_balance BIGINT COMMENT'입금 요청된 계좌에 잔액',
    created_at TIMESTAMP not null DEFAULT now()
);