package com.example.facturasapi.service


import com.example.facturasapi.model.Detail
import com.example.facturasapi.repository.DetailRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class DetailService {

    @Autowired
    lateinit var detailRepository: DetailRepository

    fun list():List<Detail>{
        return detailRepository.findAll()
    }


    fun save(detail: Detail):Detail{
        return detailRepository.save(detail)
    }

    fun update(detail:Detail): Detail {
        try{
            detailRepository.findById(detail.id)
                ?: throw Exception("ID no existe")

            return detailRepository.save(detail)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }


    fun updateQuantity(detail:Detail): Detail {
        try{
            val response = detailRepository.findById(detail.id)
                ?: throw Exception("ID no existe")
            response.apply {
                quantity =detail.quantity
            }
            return detailRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

}




