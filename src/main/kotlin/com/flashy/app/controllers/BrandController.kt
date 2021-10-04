package com.flashy.app.controllers

import com.flashy.app.models.Brand
import com.flashy.app.services.BrandService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import kotlin.collections.ArrayList

@RestController
class BrandController {

    @Autowired
    private lateinit var service: BrandService


    //retrieve all brands
    @GetMapping("/brands")
    fun list(): ArrayList<Brand> = service.listAllValues()

    //retrieve specific brands
    @GetMapping("/brands/{id}")
    fun get(@PathVariable id:Int) : ResponseEntity<Brand>{
        return try {
            val brand: Brand = service.getValue(id)
            ResponseEntity<Brand>(brand, HttpStatus.OK)
        }catch (ex:Exception){
            ResponseEntity<Brand>(HttpStatus.NOT_FOUND)
        }
    }

    //add brand
    @PostMapping("/brands")
    fun addBrand(@RequestBody brand: Brand) = service.saveValue(brand)

    //update brand
    @PutMapping("/brands/{id}")
    fun updateBrand(@RequestBody brand:Brand, @PathVariable id:Int) : ResponseEntity<Any> {
        return try{
            //retrieve existing brand
            val existBrand = service.getValue(id)
            service.saveValue(brand)
            ResponseEntity(HttpStatus.OK)
        }catch (ex:Exception){
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    //delete brand
    @DeleteMapping("/brands/{id}")
    fun deleteBrand(@PathVariable id:Int) = service.deleteValue(id)

}