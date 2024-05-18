package com.java.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.bank.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

}
