package com.flashy.app.services

import com.flashy.app.models.Favorite
import com.flashy.app.models.Images
import com.flashy.app.repositories.FavoriteRepository
import com.flashy.app.repositories.ImagesRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.awt.Image
import javax.transaction.Transactional

@Service
@Transactional
class ImagesService {
    @Autowired
    private lateinit var repo: ImagesRepository

    //list all the values
    fun listAllValues(productId:Int) : ArrayList<Images> = repo.getSpecificBanners(productId) as ArrayList<Images>

    //save value
    fun saveValue(t: Images) = repo.save(t)

    //delete value
    fun deleteValue(id:Int) = repo.deleteById(id)

    //get all images possible
    fun getAll() : ArrayList<Images> = repo.findAll() as ArrayList<Images> /* = java.util.ArrayList<com.flashy.app.models.Images> */

}