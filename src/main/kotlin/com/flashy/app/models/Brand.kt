package com.flashy.app.models

import javax.persistence.*
import kotlin.properties.Delegates


@Entity
@Table(name = "brands")
class Brand{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null

    var name: String? = null

    constructor(){

    }
    constructor(id:Int, name:String) : this(){
        this.id = id
        this.name = name
    }


}