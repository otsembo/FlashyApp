package com.flashy.app.services

import com.flashy.app.models.Brand
import com.flashy.app.models.Category
import com.flashy.app.repositories.BrandRepository
import com.flashy.app.repositories.CategoryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.transaction.Transactional


@Service
@Transactional
class CategoryService {

    @Autowired
    lateinit var repo: CategoryRepository

    //list all the values
    fun listAllValues() : ArrayList<Category> = repo.findAll() as ArrayList<Category>

    //save value
    fun saveValue(t: Category) = repo.save(t)

    //get specific value
    fun getValue(id:Int): Category = repo.findById(id).get()

    //delete value
    fun deleteValue(id:Int) = repo.deleteById(id)

}