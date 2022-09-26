package com.example.edm

import com.example.edm.dto.BankAccountDto
import com.example.edm.service.BankAccountService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/bank-account")
class BankController(var bankAccountService: BankAccountService) {

    @PostMapping
    fun addBankAccount(@RequestBody bankAccountDto: BankAccountDto) {
        bankAccountService.addBankAccount(bankAccountDto)
    }

    @GetMapping
    fun getBankAccount(@RequestParam id:Long) : ResponseEntity<BankAccountDto> {
        val bankAccount: BankAccountDto? = bankAccountService.getBankAccount(id)
        return if (bankAccount != null) ResponseEntity(bankAccount, HttpStatus.OK) else {
            ResponseEntity(HttpStatus.BAD_REQUEST)
        }
    }
}