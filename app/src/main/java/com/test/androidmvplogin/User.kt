package com.test.androidmvplogin

class User(var fullName : String = "", var email: String = "")
{
    constructor() : this("" , "" )

    override fun toString(): String {
        return "Email : $email\nFullName : $fullName"
    }

}
