package com.example.edm.entity

import javax.persistence.*

@Entity
class BankAccount (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    var bankCode:String,
    var accountNumber:String,
    var accountHolderName:String,
)