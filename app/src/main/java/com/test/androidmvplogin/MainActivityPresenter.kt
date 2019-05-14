package com.test.androidmvplogin

class MainActivityPresenter(private var view: View, val user: User = User()) {


    fun updateFullName(fullName:String){
    user.fullName = fullName;
    view.updateUserInfoTextView(user.toString())
    }

    fun updateEmail(email: String) {
        user.email = email
        view.updateUserInfoTextView(user.toString())

    }

    interface View {
        fun updateUserInfoTextView(info: String)
        fun showProgressBar()
        fun hideProgressBar()
    }

}
