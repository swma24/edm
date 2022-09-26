package com.example.edm.repository

import com.example.edm.entity.BankAccount
import org.springframework.data.repository.CrudRepository

interface BankAccountRepository : CrudRepository<BankAccount, Long>