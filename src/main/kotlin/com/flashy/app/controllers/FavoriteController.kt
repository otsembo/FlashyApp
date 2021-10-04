package com.flashy.app.controllers

import com.flashy.app.base.DataUtil
import com.flashy.app.models.Favorite
import com.flashy.app.services.FavoriteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class FavoriteController {


    @Autowired
    private lateinit var service: FavoriteService

    //create a data util object
    private val myUtil: DataUtil<Favorite> = DataUtil()

    //retrieve all favorites
    @GetMapping("/favorites")
    fun list(): HashMap<String, Any> {
        val values:ArrayList<Favorite> = service.listAllValues()
        myUtil.response["status"] = 200
        myUtil.response["data"] = values
        myUtil.response["message"] = "Success"
        return myUtil.response
    }

    //retrieve specific favorites
    @GetMapping("/favorites/{id}")
    fun get(@PathVariable id:Int) : HashMap<String, Any> {
        return try {
            val favorite: Favorite = service.getValue(id)
            myUtil.response["data"] = favorite
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

    //retrieve specific favorites
    @PostMapping("/favorites/{id}/{userId}")
    fun updateFavorites(@PathVariable("id") id:Int, @PathVariable("userId") userId:Int) : HashMap<String, Any> {
        return try {
            service.removeFav(userId,id)
            myUtil.response["data"] = "Removed from favorites"
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

    //retrieve specific favorites
    @GetMapping("/favorites/user/{userId}")
    fun specificUserFavorites(@PathVariable("userId") userId:Int) : HashMap<String, Any> {
        return try {
            val list: ArrayList<Favorite> = service.listActiveValues(userId)
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

    //add favorites
    @PostMapping("/favorites")
    fun addFavorites(@RequestBody cart: Favorite) = service.saveValue(cart)

    //update favorites
    @PutMapping("/favorites/{id}")
    fun updateFavorites(@RequestBody cart: Favorite, @PathVariable id:Int) : HashMap<String, Any> {
        return try{
            //retrieve existing favorites
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

    //delete favorites
    @DeleteMapping("/favorites/{id}")
    fun deleteFavorites(@PathVariable id:Int) = service.deleteValue(id)

}