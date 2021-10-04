package com.flashy.app.base

class DataUtil<T> {
    //variable to format response
    var status:Int = 200
    var message:String = "success"
    var responseData:ArrayList<T> = ArrayList()
    var response:HashMap<String, Any> = hashMapOf("message" to message, "data" to responseData,"status" to status)
}