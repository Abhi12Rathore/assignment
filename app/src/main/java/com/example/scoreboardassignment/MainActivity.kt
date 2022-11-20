package com.example.scoreboardassignment

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.scoreboardassignment.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var mContentViewBinding:ActivityMainBinding
    var scoreTeamA:String = ""
    var scoreTeamB:String = ""
    var scoreAB:String = ""
    var serverAB:String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContentViewBinding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        startInitialisation()
    }

    private fun startInitialisation(){
        mContentViewBinding.handler= MainActivityHandler(this)
        mContentViewBinding!!.handler!!.displayForTeamA("");
        mContentViewBinding!!.handler!!.displayForTeamB("");
        mContentViewBinding!!.handler!!.displayAB("Love All");
        serverAB = "A";

    }


}