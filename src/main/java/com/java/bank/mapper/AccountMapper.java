package com.java.bank.mapper;

import com.java.bank.dto.AccountDto;
import com.java.bank.entity.Account;

public class AccountMapper {

	public static Account mapToAccount(AccountDto accountDto) {
		return new Account(accountDto.id(), accountDto.accountHolderName(), accountDto.balence());
	}
	
	public static AccountDto mapToAccountDto(Account account) {
		return new AccountDto(account.getId(), account.getAccountHolderName(), account.getBalence());
	}
}
