package com.example.edm

import com.example.edm.entity.BankAccount
import com.example.edm.repository.BankAccountRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.data.repository.findByIdOrNull


@DataJpaTest
class BankAccountRepositoryTest {
    @Autowired
    lateinit var repository: BankAccountRepository

    @Test
    fun `when get bank account then return bank account`() {
        // given
        val bankAccount = BankAccount(
            bankCode = "012",
            accountNumber = "110123456789",
            accountHolderName = "Seungwan",
        )

        // when
        repository.save(bankAccount)
        val result = repository.findByIdOrNull(1)

        // then
        assertEquals(bankAccount, result)

        // when
        val result2 = repository.findByIdOrNull(2)

        // then
        assertEquals(null, result2)
    }
}