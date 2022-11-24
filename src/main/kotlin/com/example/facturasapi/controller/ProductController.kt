package com.example.facturasapi.controller

import com.example.facturasapi.model.Product
import com.example.facturasapi.service.ProductService
import org.hibernate.annotations.UpdateTimestamp
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/product")
class ProductController {

    @Autowired
    lateinit var  productService: ProductService

    @GetMapping
    fun list():List<Product>{
        return productService.list()
    }
    @PostMapping
    fun save(@RequestBody @Valid product:Product):ResponseEntity<Product>{
        return ResponseEntity(productService.save(product), HttpStatus.OK)
    }

    @PutMapping
    fun update (@RequestBody product:Product):ResponseEntity<Product>{
        return ResponseEntity(productService.update(product), HttpStatus.OK)
    }
    @PatchMapping
    fun updateName (@RequestBody product:Product):ResponseEntity<Product>{
        return ResponseEntity(productService.updateStock(product), HttpStatus.OK)
    }

}