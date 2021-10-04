package com.flashy.app.models

import java.sql.Date
import javax.persistence.*


@Entity
@Table(name = "categories")
class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Int? = null

    var name:String? = null

    var date_added:Date? = null

    var image:String? = null

    constructor(){

    }

    constructor(

        id:Int,
        name:String,
        date_added:Date,
        image:String

    ){

        this.id = id
        this.name = name
        this.date_added = date_added
        this.image = image

    }


}