package com.flashy.app.controllers

import com.flashy.app.base.DataUtil
import com.flashy.app.models.Cart
import com.flashy.app.services.CartService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class CartController {

    @Autowired
    private lateinit var service: CartService

    //create a data util object
    private val myUtil: DataUtil<Cart> = DataUtil()

    //retrieve all cart
    @GetMapping("/cart")
    fun list(): HashMap<String, Any> {
        val values:ArrayList<Cart> = service.listAllValues()
        myUtil.response["status"] = 200
        myUtil.response["data"] = values
        myUtil.response["message"] = "Success"
        return myUtil.response
    }

    //retrieve specific cart
    @GetMapping("/cart/{id}")
    fun get(@PathVariable id:Int) : HashMap<String, Any> {
        return try {
            val cart: Cart = service.getValue(id)
            myUtil.response["data"] = cart
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
    @GetMapping("/cart/mycart/{id}")
    fun getUserCart(@PathVariable id:Int) : HashMap<String, Any> {
        return try {
            val list: ArrayList<Cart> = service.getUserCart(id)
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
    @PostMapping("/cart")
    fun addBrand(@RequestBody cart: Cart) = service.saveValue(cart)

    //update cart
    @PutMapping("/cart/{id}")
    fun updateBrand(@RequestBody cart: Cart, @PathVariable id:Int) : HashMap<String, Any> {
        return try{
            //retrieve existing brand
            val existBrand = service.getValue(id)
            service.saveValue(cart)
            myUtil.response["data"] = cart
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
    @DeleteMapping("/cart/{id}")
    fun deleteBrand(@PathVariable id:Int) = service.deleteValue(id)

}