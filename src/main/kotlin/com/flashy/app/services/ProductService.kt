package com.flashy.app.services

import com.flashy.app.models.Product
import com.flashy.app.repositories.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional
class ProductService {

    @Autowired
    private lateinit var repo: ProductRepository

    //list all the values
    fun listAllValues() : ArrayList<Product> = repo.findAll() as ArrayList<Product>

    //list latest products
    fun listLatest () : ArrayList<Product> = repo.getLatestProducts() as ArrayList<Product>

    //save value
    fun saveValue(t: Product) = repo.save(t)

    //get specific value
    fun getValue(id:Int): Product = repo.findById(id).get()

    //delete value
    fun deleteValue(id:Int) = repo.deleteById(id)


}