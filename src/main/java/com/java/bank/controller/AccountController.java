package com.java.bank.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.bank.dto.AccountDto;
import com.java.bank.service.AccountService;

@RestController
@RequestMapping(path = "api/v1/account")
//@RequiredArgsConstructor
public class AccountController {
//	@Autowired
	private AccountService accountService;

	public AccountController(AccountService accountService) {
		super();
		this.accountService = accountService;
	}

	@PostMapping(path = "create")
	public ResponseEntity<AccountDto> saveAccount(@RequestBody AccountDto account) {
		return new ResponseEntity<AccountDto>(accountService.createAccount(account), HttpStatus.CREATED);
	}
	
	@GetMapping(path="get/{id}")
	public ResponseEntity<AccountDto> getAccount(@PathVariable("id") Integer id){
		return new ResponseEntity<AccountDto>(accountService.getById(id), HttpStatus.OK);
	}
	
	@PutMapping(path="deposit/{id}")
	public ResponseEntity<AccountDto> depositAmount(@PathVariable("id")Integer id, @RequestBody Map<String, Double> request){
		double amount = request.get("amount");
		return new ResponseEntity<AccountDto>(accountService.deposit(id, amount), HttpStatus.OK);
	}
	
	@PutMapping(path="withdraw/{id}")
	public ResponseEntity<AccountDto> withdrawAmount(@PathVariable("id")Integer id, @RequestBody Map<String, Double> request){
		double amount = request.get("amount");
		return new ResponseEntity<AccountDto>(accountService.withdraw(id, amount), HttpStatus.OK);
	}
	
	@GetMapping(path="getAllAccounts")
	public ResponseEntity<List<AccountDto>> getAllAcounts(){
		return new ResponseEntity<List<AccountDto>>(accountService.getAllAccounts(), HttpStatus.OK);
	}
	
	@DeleteMapping(path="delete/{id}")
	public ResponseEntity<String> deleteAccount(@PathVariable("id")Integer id){
		return new ResponseEntity<String>(accountService.delete(id), HttpStatus.OK);
	}
	
	
}
