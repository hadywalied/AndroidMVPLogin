package com.test.androidmvplogin

import android.content.res.Resources
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.widget.RelativeLayout




class MainActivity : AppCompatActivity(), MainActivityPresenter.View {
    private var presenter: MainActivityPresenter? = null

    private var myTextView: TextView? = null
    private var progressBar: ProgressBar? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setActionBar(findViewById(R.id.toolbar))

        presenter = MainActivityPresenter(this)

        myTextView = findViewById(R.id.myTextView)
        var username: EditText = findViewById(R.id.username)
        var email: EditText = findViewById(R.id.email)
        initProgressBar()


        username.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                hideProgressBar();
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                presenter!!.updateFullName(p0.toString()); }
        })
        email.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                hideProgressBar();
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                presenter!!.updateEmail(p0.toString()); }
        })


    }

    private fun initProgressBar() {
        progressBar = ProgressBar(this, null, android.R.attr.progressBarStyleSmall)
        progressBar!!.setIndeterminate(true)
        val params = RelativeLayout.LayoutParams(
            Resources.getSystem().getDisplayMetrics().widthPixels,
            80
        )
        params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM)
        this.addContentView(progressBar, params)
        showProgressBar()
    }

    override fun updateUserInfoTextView(info: String) {
        myTextView!!.setText(info);
    }

    override fun showProgressBar() {
        progressBar!!.setVisibility(View.VISIBLE)
    }

    override fun hideProgressBar() {
        progressBar!!.setVisibility(View.INVISIBLE);
    }
}