package com.example.edm.repository

import com.example.edm.entity.BankAccount
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface BankAccountRepository : CrudRepository<BankAccount, Long> {
}