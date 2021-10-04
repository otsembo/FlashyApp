package com.flashy.app.services

import com.flashy.app.models.Address
import com.flashy.app.models.Cart
import com.flashy.app.repositories.CartRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional
class CartService {

    @Autowired
    private lateinit var repo:CartRepository

    //list all the values
    fun listAllValues(): ArrayList<Cart> {
        return repo.findAll() as ArrayList<Cart>
    }

    //find specific value for user
    fun getUserCart(id:Int) : ArrayList<Cart>{
        return repo.findActiveCart(id) as ArrayList<Cart>
    }

    //save value
    fun saveValue(t: Cart) = repo.save(t)

    //get specific value
    fun getValue(id: Int): Cart {
        return repo.findById(id).get()
    }

    //delete value
    fun deleteValue(id:Int) = repo.deleteById(id)

}