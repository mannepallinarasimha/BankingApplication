package com.java.bank.service;

import java.util.List;

import com.java.bank.dto.AccountDto;

public interface AccountService {

	public AccountDto createAccount(AccountDto account);

	public AccountDto getById(Integer id);

	public AccountDto deposit(Integer id, Double amount);

	public AccountDto withdraw(Integer id, double amount);

	public List<AccountDto> getAllAccounts();

	public String delete(Integer id);



}
