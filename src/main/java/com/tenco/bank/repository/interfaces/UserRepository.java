package com.tenco.bank.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tenco.bank.dto.SignInFormDto;
import com.tenco.bank.dto.SignUpFormDto;
import com.tenco.bank.repository.model.User;
@Mapper // MyBatis 의존 설정 함(build.gradle 파일)
public interface UserRepository {

	public int insert(SignUpFormDto signUpFormDto);
	public int updateById(User user);
	public int deleteById(Integer id);
	public User findById(Integer id);
	public List<User> findAll();
	
	// 추가 작업
	public User findByUsernameAndPassword(SignInFormDto signInFormDto);
}
