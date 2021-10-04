package com.flashy.app.services

import com.flashy.app.models.Country
import com.flashy.app.repositories.CountryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.transaction.Transactional


@Service
@Transactional
class CountryService {

    @Autowired
    private lateinit var repo:CountryRepository

    //list all the values
    fun listAllValues() : ArrayList<Country> = repo.findAll() as ArrayList<Country>

    //save value
    fun saveValue(t: Country) = repo.save(t)

    //get specific value
    fun getValue(id:Int): Country = repo.findById(id).get()

    //delete value
    fun deleteValue(id:Int) = repo.deleteById(id)

}