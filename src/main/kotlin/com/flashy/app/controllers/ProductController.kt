package com.flashy.app.controllers

import com.flashy.app.base.DataUtil
import com.flashy.app.models.Cart
import com.flashy.app.models.Product
import com.flashy.app.services.CartService
import com.flashy.app.services.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class ProductController {

    @Autowired
    private lateinit var service: ProductService

    //create a data util object
    private val myUtil: DataUtil<Product> = DataUtil()

    //retrieve all product
    @GetMapping("/products")
    fun list(): HashMap<String, Any> {
        val values:ArrayList<Product> = service.listAllValues()
        myUtil.response["status"] = 200
        myUtil.response["data"] = values
        myUtil.response["message"] = "Success"
        return myUtil.response
    }

    //retrieve specific product
    @GetMapping("/products/{id}")
    fun get(@PathVariable id:Int) : HashMap<String, Any> {
        return try {
            val product: Product = service.getValue(id)
            myUtil.response["data"] = product
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

    //retrieve specific cart
    @GetMapping("/products/latest")
    fun getLatestProducts() : HashMap<String, Any> {
        return try {
            val list: ArrayList<Product> = service.listLatest()
            myUtil.response["data"] = list
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

    //add cart
    @PostMapping("/products")
    fun addBrand(@RequestBody product: Product) = service.saveValue(product)

    //update cart
    @PutMapping("/products/{id}")
    fun updateBrand(@RequestBody product: Product, @PathVariable id:Int) : HashMap<String, Any> {
        return try{
            //retrieve existing brand
            val product = service.getValue(id)
            service.saveValue(product)
            myUtil.response["data"] = product
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

    //delete cart
    @DeleteMapping("/products/{id}")
    fun deleteBrand(@PathVariable id:Int) = service.deleteValue(id)

}