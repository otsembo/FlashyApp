package com.flashy.app.controllers

import com.flashy.app.base.DataUtil
import com.flashy.app.models.Favorite
import com.flashy.app.models.Images
import com.flashy.app.services.ImagesService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class ImagesController {

    @Autowired
    private lateinit var service:ImagesService

    //create a data util object
    private val myUtil: DataUtil<Images> = DataUtil()

    //retrieve specific images
    @GetMapping("/images/{productId}")
    fun get(@PathVariable productId:Int) : HashMap<String, Any> {
        return try {
            val images = service.listAllValues(productId)
            myUtil.response["data"] = images
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

    //get all images
    @GetMapping("/images")
    fun getAll() : HashMap<String, Any>{
        return try {
            val images = service.getAll()
            myUtil.response["data"] = images
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


    //add images
    @PostMapping("/images")
    fun addFavorites(@RequestBody images: Images) = service.saveValue(images)

    //delete images
    @DeleteMapping("/images/{id}")
    fun deleteFavorites(@PathVariable id:Int) = service.deleteValue(id)

}