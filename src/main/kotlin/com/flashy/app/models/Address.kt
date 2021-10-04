package com.flashy.app.models

import javax.persistence.*


@Entity
@Table(name = "addresses")
class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Int? = null

    var name:String? = null

    var address:String? = null

    var city:String? = null

    var region:String? = null

    var zipcode:String? = null

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    var country:Country? = null


    constructor(){
    }

    constructor(
        id: Int?,
        name: String?,
        address: String?,
        city: String?,
        region: String?,
        zipCode: String?,
        hostCountry: Country?
    ) {
        this.id = id
        this.name = name
        this.address = address
        this.city = city
        this.region = region
        this.zipcode = zipCode
        this.country = hostCountry
    }


}