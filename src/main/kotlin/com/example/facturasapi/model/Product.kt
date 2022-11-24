package com.example.facturasapi.model

import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "product")

class Product {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var description : String? = null
    var brand: String? = null
    @NotBlank
    var stock: Long? = null
}