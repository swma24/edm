package com.example.edm.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class BankAccount (
    var bankCode:String,
    var accountNumber:String,
    var accountHolderName:String,
    @Id @GeneratedValue val id: Long? = null
)