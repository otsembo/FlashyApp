package com.flashy.app.controllers

import com.flashy.app.base.DataUtil
import com.flashy.app.models.Country
import com.flashy.app.services.CountryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
class CountryController {

    @Autowired
    private lateinit var service: CountryService

    //create a data util object
    private val myUtil: DataUtil<Country> = DataUtil()

    //retrieve all countries
    @GetMapping("/countries")
    fun list(): HashMap<String, Any> {
        val values:ArrayList<Country> = service.listAllValues()
        myUtil.response["status"] = 200
        myUtil.response["data"] = values
        myUtil.response["message"] = "Success"
        return myUtil.response
    }

    //retrieve specific countries
    @GetMapping("/countries/{id}")
    fun get(@PathVariable id:Int) : HashMap<String, Any> {
        return try {
            val country: Country = service.getValue(id)
            myUtil.response["data"] = country
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

    //add countries
    @PostMapping("/countries")
    fun addBrand(@RequestBody country: Country) = service.saveValue(country)

    //update countries
    @PutMapping("/countries/{id}")
    fun updateBrand(@RequestBody country: Country, @PathVariable id:Int) : HashMap<String, Any> {
        return try{
            //retrieve existing brand
            val existBrand = service.getValue(id)
            service.saveValue(country)
            myUtil.response["data"] = country
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

    //delete countries
    @DeleteMapping("/countries/{id}")
    fun deleteBrand(@PathVariable id:Int) = service.deleteValue(id)

}