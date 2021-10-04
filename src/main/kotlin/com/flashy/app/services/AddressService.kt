package com.flashy.app.services

import com.flashy.app.models.Address
import com.flashy.app.repositories.AddressRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional
class AddressService {

    @Autowired
    private lateinit var repo:AddressRepository

    //list all the values
    fun listAllValues(): ArrayList<Address> {
        return repo.findAll() as ArrayList<Address>
    }

    //save value
    fun saveValue(t: Address) = repo.save(t)

    //get specific value
    fun getValue(id: Int): Address {
        return repo.findById(id).get()
    }

    //delete value
    fun deleteValue(id:Int) = repo.deleteById(id)


}