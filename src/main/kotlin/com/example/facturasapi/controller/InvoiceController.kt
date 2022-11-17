package com.example.facturasapi.controller

import com.example.facturasapi.model.Invoice
import com.example.facturasapi.service.InvoiceService
import org.hibernate.annotations.UpdateTimestamp
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/invoice")
class InvoiceController {

    @Autowired
    lateinit var  invoiceService: InvoiceService

    @GetMapping
    fun list():List<Invoice>{
        return invoiceService.list()
    }
    @PostMapping
    fun save(@RequestBody invoice:Invoice):ResponseEntity<Invoice>{
        return ResponseEntity(invoiceService.save(invoice), HttpStatus.OK)
    }

    @PutMapping
    fun update (@RequestBody invoice:Invoice):ResponseEntity<Invoice>{
        return ResponseEntity(invoiceService.update(invoice), HttpStatus.OK)
    }
    @PatchMapping
    fun updateName (@RequestBody invoice:Invoice):ResponseEntity<Invoice>{
        return ResponseEntity(invoiceService.updateTotal(invoice), HttpStatus.OK)
    }

}