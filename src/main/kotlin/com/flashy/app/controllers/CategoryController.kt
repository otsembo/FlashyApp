package com.flashy.app.controllers

import com.flashy.app.base.DataUtil
import com.flashy.app.models.Cart
import com.flashy.app.models.Category
import com.flashy.app.services.CartService
import com.flashy.app.services.CategoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
class CategoryController {

    @Autowired
    private lateinit var service: CategoryService

    //create a data util object
    private val myUtil: DataUtil<Category> = DataUtil()

    //retrieve all Category
    @GetMapping("/categories")
    fun list(): HashMap<String, Any> {
        val values:ArrayList<Category> = service.listAllValues()
        myUtil.response["status"] = 200
        myUtil.response["data"] = values
        myUtil.response["message"] = "Success"
        return myUtil.response
    }

    //retrieve specific Category
    @GetMapping("/categories/{id}")
    fun get(@PathVariable id:Int) : HashMap<String, Any> {
        return try {
            val address: Category = service.getValue(id)
            myUtil.response["data"] = address
            myUtil.response["status"] = 200
            myUtil.response["message"] = "Success"
            myUtil.response
        }catch (ex:Exception){
            myUtil.response["status"] = 404
            myUtil.response["message"] = "Failed"
            myUtil.response["data"] = "null"
            myUtil.response
        }
    }

    //add Category
    @PostMapping("/categories")
    fun addBrand(@RequestBody address: Category) = service.saveValue(address)

    //update Category
    @PutMapping("/categories/{id}")
    fun updateBrand(@RequestBody address: Category, @PathVariable id:Int) : HashMap<String, Any> {
        return try{
            //retrieve existing brand
            val existBrand = service.getValue(id)
            service.saveValue(address)
            myUtil.response["data"] = address
            myUtil.response["status"] = 200
            myUtil.response["message"] = "Success"
            myUtil.response
        }catch (ex:Exception){
            myUtil.response["status"] = 404
            myUtil.response["message"] = "Failed"
            myUtil.response["data"] = "null"
            myUtil.response
        }
    }

    //delete Category
    @DeleteMapping("/categories/{id}")
    fun deleteBrand(@PathVariable id:Int) = service.deleteValue(id)

}