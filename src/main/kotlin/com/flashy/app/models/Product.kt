package com.flashy.app.models

import java.sql.Date
import javax.persistence.*

@Entity
@Table(name = "products")
class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Int? = null

    var name:String? = null

    var date:Date? = null

    var unit_price:Double? = null

    var qty_available:Int? = null

    var sizes:String? = null

    var colors:String? = null

    var banner:String? = null

    var brands:String? = null

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    var category:Category? = null

    var genders:String? = null

    var description:String? = null

    constructor(){

    }

    constructor(
        id: Int?,
        name: String?,
        date: Date?,
        unit_price: Double?,
        qty_available: Int?,
        sizes: String?,
        colors: String?,
        banner: String?,
        brands: String?,
        category: Category?,
        genders: String?,
        description: String?
    ) {
        this.id = id
        this.name = name
        this.date = date
        this.unit_price = unit_price
        this.qty_available = qty_available
        this.sizes = sizes
        this.colors = colors
        this.banner = banner
        this.brands = brands
        this.category = category
        this.genders = genders
        this.description = description
    }


}