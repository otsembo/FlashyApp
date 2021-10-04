package com.flashy.app.services

import com.flashy.app.models.Brand
import com.flashy.app.repositories.BrandRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.persistence.Entity
import javax.transaction.Transactional


@Service
@Transactional
class BrandService{

    @Autowired
    lateinit var repo: BrandRepository

    //list all the values
    fun listAllValues() : ArrayList<Brand> = repo.findAll() as ArrayList<Brand>

    //save value
    fun saveValue(t: Brand) = repo.save(t)

    //get specific value
    fun getValue(id:Int): Brand = repo.findById(id).get()

    //delete value
    fun deleteValue(id:Int) = repo.deleteById(id)

}