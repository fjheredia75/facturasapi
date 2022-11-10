package com.example.facturasapi.controller

import com.example.facturasapi.model.Client
import com.example.facturasapi.service.ClientService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/client")
class ClientController {

    @Autowired
    lateinit var  clientService: ClientService

    @GetMapping
    fun list():List<Client>{
        return clientService.list()
    }
    @PostMapping
    fun save(@RequestBody client:Client):Client{
        return clientService.save(client)
    }
}