package com.tenco.bank.repository.interfaces;

import java.util.List;

import com.tenco.bank.repository.model.Account;

public interface AccountRepository {

	public int insert(Account account);
	public int updateById(Account account);
	public int deleteBuId(int id);
	
	public List<Account> findAll();
	public Account findById(int id);
	
}
