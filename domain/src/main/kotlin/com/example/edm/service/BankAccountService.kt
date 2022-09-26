package com.example.edm.service

import com.example.edm.dto.BankAccountDto
import com.example.edm.entity.BankAccount
import com.example.edm.repository.BankAccountRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class BankAccountService(val bankAccountRepository: BankAccountRepository) {
    fun addBankAccount(bankAccountDto: BankAccountDto): BankAccountDto {
        val bankAccount = BankAccount(
            bankCode = bankAccountDto.bankCode,
            accountNumber = bankAccountDto.accountNumber,
            accountHolderName = bankAccountDto.accountHolderName,
        )
        val newBankAccount = bankAccountRepository.save(bankAccount)
        return BankAccountDto(
            bankCode = newBankAccount.bankCode,
            accountNumber = newBankAccount.accountNumber,
            accountHolderName = newBankAccount.accountHolderName,
        )
    }
    fun getBankAccount(id: Long): BankAccountDto? {
        val bankAccount = bankAccountRepository.findByIdOrNull(id) ?: return null
        return BankAccountDto(
            bankCode = bankAccount.bankCode,
            accountNumber = bankAccount.accountNumber,
            accountHolderName = bankAccount.accountHolderName,
        )
    }
}
