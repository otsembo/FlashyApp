package com.flashy.app.models

import java.sql.Date
import javax.persistence.*

@Entity
@Table(name = "users")
class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Int? = null

    var code:String? = null

    var name:String? = null

    var email:String? = null

    var password:String? = null

    var date_registered:Date? = null

    var date_blocked:Date? = null

    var is_blocked:Boolean? = null

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name="address_id", referencedColumnName = "id")
    var address:Address? = null

    var birth_date:Date? = null

    constructor(){

    }

    constructor(
        id: Int?,
        code: String?,
        name: String?,
        email: String?,
        password: String?,
        date_registered: Date?,
        date_blocked: Date?,
        is_blocked: Boolean?,
        address: Address?,
        birth_date: Date?
    ) {
        this.id = id
        this.code = code
        this.name = name
        this.email = email
        this.password = password
        this.date_registered = date_registered
        this.date_blocked = date_blocked
        this.is_blocked = is_blocked
        this.address = address
        this.birth_date = birth_date
    }


}