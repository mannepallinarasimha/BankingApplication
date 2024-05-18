package com.java.bank.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.java.bank.dto.AccountDto;
import com.java.bank.entity.Account;
import com.java.bank.mapper.AccountMapper;
import com.java.bank.repository.AccountRepository;
import com.java.bank.service.AccountService;

@Service
//@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
//	@Autowired
	private AccountRepository accountRepository;

	public AccountServiceImpl(AccountRepository accountRepository) {
	super();
	this.accountRepository = accountRepository;
}

	@Override
	public AccountDto createAccount(AccountDto accountDto) {
		Account account = AccountMapper.mapToAccount(accountDto);
		 return AccountMapper.mapToAccountDto(accountRepository.save(account));
	}

	@Override
	public AccountDto getById(Integer id) {
		 Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account Does Not Exist"));
		 return AccountMapper.mapToAccountDto(account);
	}

	@Override
	public AccountDto deposit(Integer id, Double amount) {
		Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account Does Not Exist"));
		Double total = account.getBalence()+amount;
		account.setBalence(total);
		Account savedAccount = accountRepository.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}

	@Override
	public AccountDto withdraw(Integer id, double amount) {
		Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account Does Not Exist"));
		if(account.getBalence() < amount) {
			throw new RuntimeException("Insufficiant balence");
		}
		Double total = account.getBalence() - amount;
		account.setBalence(total);
		Account savedAccount = accountRepository.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}

	@Override
	public List<AccountDto> getAllAccounts() {
		List<Account> accountsList = accountRepository.findAll();
		return accountsList.stream().map(account -> AccountMapper.mapToAccountDto(account)).toList();
	}

	@Override
	public String delete(Integer id) {
		Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account Does Not Exist"));
		 accountRepository.delete(account);
		 return "Account deleted Successfully...";
	}

}
