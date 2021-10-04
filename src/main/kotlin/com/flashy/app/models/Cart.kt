package com.flashy.app.models

import java.sql.Date
import javax.persistence.*

@Entity
@Table(name = "cart")
class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Int? = null

    //user id
    var user_id:Int? = null

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    var product:Product? = null

    var is_checked:Boolean? = null

    var qty:Int? = null

    var unit_price:Double? = null

    var is_deleted:Boolean? = null

    var date_added:Date? = null
}