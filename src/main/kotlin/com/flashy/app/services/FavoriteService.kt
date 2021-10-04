package com.flashy.app.services

import com.flashy.app.models.Country
import com.flashy.app.models.Favorite
import com.flashy.app.repositories.CountryRepository
import com.flashy.app.repositories.FavoriteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional
class FavoriteService {

    @Autowired
    private lateinit var repo: FavoriteRepository

    //list all the values
    fun listAllValues() : ArrayList<Favorite> = repo.findAll() as ArrayList<Favorite>

    //list all active favorites
    fun listActiveValues (id: Int) : ArrayList<Favorite> = repo.findActiveFavorite(id) as ArrayList<Favorite>

    //save value
    fun saveValue(t: Favorite) = repo.save(t)

    //get specific value
    fun getValue(id:Int): Favorite = repo.findById(id).get()

    //delete value
    fun deleteValue(id:Int) = repo.deleteById(id)

    //remove favorite marking
    fun removeFav(userId:Int, favId:Int) = repo.removeFav(userId, favId)

}