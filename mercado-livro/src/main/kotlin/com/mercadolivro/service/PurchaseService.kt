package com.mercadolivro.service

import com.mercadolivro.enums.BookStatus
import com.mercadolivro.enums.Errors
import com.mercadolivro.events.PurchaseEvent
import com.mercadolivro.exception.BadRequestException
import com.mercadolivro.model.BookModel
import com.mercadolivro.model.PurchaseModel
import com.mercadolivro.repository.PurchaseRepository
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service
import java.util.function.Predicate

@Service
class PurchaseService(
    private val purchaseRepository: PurchaseRepository,
    private val applicationEventPublisher: ApplicationEventPublisher
) {

    fun create(purchaseModel: PurchaseModel) {

        if (purchaseModel.books.stream().anyMatch(Predicate { it.status != BookStatus.ATIVO })) {
            throw BadRequestException(Errors.ML103.message, Errors.ML103.code)
        }

            purchaseRepository.save(purchaseModel)

            println("Disparando evento de compra")
            applicationEventPublisher.publishEvent(PurchaseEvent(this, purchaseModel))
            println("Finalização do processamento!")


    }

    fun update(purchaseModel: PurchaseModel) {
        purchaseRepository.save(purchaseModel)
    }


    fun findAll(): List<PurchaseModel> {
        return purchaseRepository.findAll().toList();
    }
}
