package com.flashy.app.controllers

import com.flashy.app.base.DataUtil
import com.flashy.app.models.Address
import com.flashy.app.models.User
import com.flashy.app.services.AddressService
import com.flashy.app.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class UserController {

    @Autowired
    private lateinit var service: UserService

    //create a data util object
    private val myUtil: DataUtil<User> = DataUtil()

    //retrieve all brands
    @GetMapping("/users")
    fun list(): HashMap<String, Any> {
        val values:ArrayList<User> = service.listAllValues()
        myUtil.response["status"] = 200
        myUtil.response["data"] = values
        myUtil.response["message"] = "Success"
        return myUtil.response
    }

    //retrieve specific brands
    @GetMapping("/users/{id}")
    fun get(@PathVariable id:Int) : HashMap<String, Any> {
        return try {
            val address: User = service.getValue(id)
            myUtil.response["data"] = address
            myUtil.response["status"] = 200
            myUtil.response["message"] = "Success"
            myUtil.response
        }catch (ex:Exception){
            myUtil.response["status"] = 404
            myUtil.response["message"] = "Failed"
            myUtil.response["data"] = ex.message!!
            myUtil.response
        }
    }

    //add brand
    @PostMapping("/users")
    fun addBrand(@RequestBody address: User) : HashMap<String, Any> {
        //save the value
        return try{
            service.saveValue(address)
            myUtil.response["data"] = address
            myUtil.response["status"] = 200
            myUtil.response["message"] = "Success"
            myUtil.response
        }catch (ex:Exception){
            myUtil.response["status"] = 404
            myUtil.response["message"] = "Failed, could  not create account"
            myUtil.response["data"] = ex.localizedMessage!!
            myUtil.response
        }

    }

    //update brand
    @PutMapping("/users/{id}")
    fun updateBrand(@RequestBody address: User, @PathVariable id:Int) : HashMap<String, Any> {
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
            myUtil.response["data"] = ex.message!!
            myUtil.response
        }
    }

    //delete brand
    @DeleteMapping("/users/{id}")
    fun deleteBrand(@PathVariable id:Int) = service.deleteValue(id)

}