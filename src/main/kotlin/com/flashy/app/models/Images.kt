package com.flashy.app.models

import javax.persistence.*

@Entity
@Table(name = "images")
class Images {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null

    var product_id: Int? = null

    var type: String? = null

    var url: String? = null

    constructor(){

    }

    constructor(id: Int?, product_id: Int?, type: String?, url: String?) {
        this.id = id
        this.product_id = product_id
        this.type = type
        this.url = url
    }


}
