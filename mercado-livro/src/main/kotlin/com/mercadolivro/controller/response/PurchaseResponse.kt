package com.mercadolivro.controller.response

import java.math.BigDecimal
import java.time.LocalDateTime

data class PurchaseResponse(

    var id: Int? = null,
    var customerName: String,
    var customerId: Int? = null,
    var books: List<BookResponse>,
    var nfe: String? = null,
    var price: BigDecimal,
    var createdAt: LocalDateTime

)