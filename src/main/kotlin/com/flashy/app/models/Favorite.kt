package com.flashy.app.models

import java.sql.Date
import javax.persistence.*

@Entity
@Table(name = "favorites")
class Favorite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Int? = null

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    var product:Product? = null

    var date_added:Date? = null

    var is_removed:Boolean? = null

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    var user:User? = null

    constructor(){

    }

    constructor(id: Int?, product: Product?, date_added: Date?, is_removed: Boolean?, user: User?) {
        this.id = id
        this.product = product
        this.date_added = date_added
        this.is_removed = is_removed
        this.user = user
    }


}