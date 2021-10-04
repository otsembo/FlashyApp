package com.flashy.app.controllers

import com.flashy.app.base.DataUtil
import com.flashy.app.models.Address
import com.flashy.app.services.AddressService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
class AddressController {

    @Autowired
    private lateinit var service: AddressService

    //create a data util object
    private val myUtil:DataUtil<Address> = DataUtil()

    //retrieve all brands
    @GetMapping("/addresses")
    fun list(): HashMap<String, Any> {
        val values:ArrayList<Address> = service.listAllValues()
        myUtil.response["status"] = 200
        myUtil.response["data"] = values
        myUtil.response["message"] = "Success"
        return myUtil.response
    }

    //retrieve specific brands
    @GetMapping("/addresses/{id}")
    fun get(@PathVariable id:Int) : HashMap<String, Any> {
        return try {
            val address: Address = service.getValue(id)
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

    //add brand
    @PostMapping("/addresses")
    fun addBrand(@RequestBody address: Address) = service.saveValue(address)

    //update brand
    @PutMapping("/addresses/{id}")
    fun updateBrand(@RequestBody address: Address, @PathVariable id:Int) : HashMap<String, Any> {
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

    //delete brand
    @DeleteMapping("/addresses/{id}")
    fun deleteBrand(@PathVariable id:Int) = service.deleteValue(id)

}