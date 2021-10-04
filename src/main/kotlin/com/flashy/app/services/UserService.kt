package com.flashy.app.services

import com.flashy.app.models.Address
import com.flashy.app.models.User
import com.flashy.app.repositories.AddressRepository
import com.flashy.app.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional
class UserService {

    @Autowired
    private lateinit var repo: UserRepository

    //list all the values
    fun listAllValues(): ArrayList<User> {
        return repo.findAll() as ArrayList<User>
    }

    //save value
    fun saveValue(t: User) = repo.save(t)

    //get specific value
    fun getValue(id: Int): User {
        return repo.findById(id).get()
    }

    //delete value
    fun deleteValue(id:Int) = repo.deleteById(id)


}