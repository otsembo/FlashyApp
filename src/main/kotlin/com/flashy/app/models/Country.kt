package com.flashy.app.models

import javax.persistence.*


@Entity
@Table(name = "countries")
class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Int? = null

    var phoneCode:String? = null

    var name:String? = null

    var abbreviation:String? = null

    constructor(id: Int?) {
        this.id = id
    }

    constructor(id: Int?, phoneCode: String?, name: String?, abbreviation: String?) {
        this.id = id
        this.phoneCode = phoneCode
        this.name = name
        this.abbreviation = abbreviation
    }


}