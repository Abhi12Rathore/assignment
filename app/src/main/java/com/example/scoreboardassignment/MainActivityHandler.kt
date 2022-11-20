package com.example.scoreboardassignment

import android.view.View
import android.view.WindowManager
import android.widget.Toast
import android.widget.ToggleButton

class MainActivityHandler(private val mContext: MainActivity) {

    var setPlayer1:Int=0;
    var setPlayer2:Int=0

    fun changeTeam() {
        val checked = mContext.mContentViewBinding.togglebutton.isChecked
        if (checked) {
            mContext.serverAB = "A"
            mContext. scoreTeamA = ""
            mContext. scoreTeamB = ""
            mContext. scoreAB = "Love All"
            displayForTeamA( mContext.scoreTeamA)
            displayForTeamB( mContext.scoreTeamB)
            displayAB( mContext.scoreAB)
        } else {
            mContext. serverAB = "B"
            mContext.scoreTeamA = ""
            mContext. scoreTeamB = ""
            mContext.scoreAB = "Love All"
            displayForTeamA( mContext.scoreTeamA)
            displayForTeamB( mContext.scoreTeamB)
            displayAB( mContext.scoreAB)
        }
        setPlayer2=0
        setPlayer1=0
    }

    fun displayForTeamA(score: String) {
        mContext.mContentViewBinding.teamAScore.text = score
    }

    fun displayForTeamB(score: String) {
        mContext.mContentViewBinding.teamBScore.text = score
    }

    fun displayAB(score: String) {
        mContext.mContentViewBinding.teamsScore.text = score
    }

    /**
     * This method is called when added points button for Team A is clicked.
     */
    fun addTeamA() {
        if ("Love All" == mContext.scoreAB && mContext.scoreTeamA == ""
            || mContext.scoreAB.length == 0 && mContext.scoreTeamA == ""
            || mContext.scoreAB.length == 0 && mContext.scoreTeamA == "0"
        ) {
            mContext.scoreTeamA = "15"
            mContext.scoreAB = ""
            if ("" == mContext.scoreTeamB) {
                mContext.scoreTeamB = "0"
            }
        } else if (mContext.scoreTeamA == "15") {
            mContext.scoreTeamA = "30"
        } else if (mContext.scoreTeamA == "30" && "40" != mContext.scoreTeamB) {
            mContext.scoreTeamA = "40"
        } else if (mContext.scoreTeamA == "40" && "40" != mContext.scoreTeamB) {
            mContext.scoreTeamA = ""
            mContext.scoreTeamB = ""
            mContext.scoreAB = "Game A!"
            setPlayer1++
        } else if (mContext.scoreTeamA == "30" && mContext.scoreTeamB == "40") {
            mContext.scoreTeamA = ""
            mContext.scoreTeamB = ""
            mContext.scoreAB = "Deuce"
        } else if (mContext.scoreAB == "Deuce") {
            mContext.scoreTeamA = ""
            mContext.scoreTeamB = ""
            mContext.scoreAB = "Ad-In A"
        } else if (mContext.scoreAB == "Ad-In A") {
            mContext.scoreAB = "Game A!"
            setPlayer1++
        } else if (mContext.scoreAB == "Ad-In B") {
            mContext.scoreAB = "Deuce"
        } else if (mContext.scoreAB == "Game A!" || mContext.scoreAB == "Game B!") {
            mContext.scoreTeamA = ""
            mContext.scoreTeamB = ""
            mContext.scoreAB = "Love All"
        }
        displayForTeamA(mContext.scoreTeamA)
        displayForTeamB(mContext.scoreTeamB)
        displayAB(mContext.scoreAB)
        checkWinner()
    }


    /**
     * This method is called when added points button for Team B is clicked.
     */
    fun addTeamB() {
        if ("Love All" == mContext.scoreAB && mContext.scoreTeamB == ""
            || mContext.scoreAB.length == 0 && mContext.scoreTeamB == ""
            || mContext.scoreAB.length == 0 && mContext.scoreTeamB == "0"
        ) {
            mContext.scoreTeamB = "15"
            mContext.scoreAB = ""
            if ("" == mContext.scoreTeamA) {
                mContext.scoreTeamA = "0"
            }
        } else if (mContext.scoreTeamB == "15") {
            mContext.scoreTeamB = "30"
        } else if (mContext.scoreTeamB == "30" && "40" != mContext.scoreTeamA) {
            mContext.scoreTeamB = "40"
        } else if (mContext.scoreTeamB == "40" && "40" != mContext.scoreTeamA) {
            mContext.scoreTeamA = ""
            mContext.scoreTeamB = ""
            mContext.scoreAB = "Game B!"
            setPlayer2++
        } else if (mContext.scoreTeamB == "30" && mContext.scoreTeamA == "40") {
            mContext.scoreTeamA = ""
            mContext.scoreTeamB = ""
            mContext.scoreAB = "Deuce"
        } else if (mContext.scoreAB == "Deuce") {
            mContext.scoreTeamA = ""
            mContext.scoreTeamB = ""
            mContext.scoreAB = "Ad-In B"
        } else if (mContext.scoreAB == "Ad-In B") {
            mContext.scoreAB = "Game B!"
            setPlayer2++
        } else if (mContext.scoreAB == "Ad-In A") {
            mContext.scoreAB = "Deuce"
        } else if (mContext.scoreAB == "Game B!" || mContext.scoreAB == "Game A!") {
            mContext.scoreTeamA = ""
            mContext.scoreTeamB = ""
            mContext.scoreAB = "Love All"
        }
        displayForTeamA(mContext.scoreTeamA)
        displayForTeamB(mContext.scoreTeamB)
        displayAB(mContext.scoreAB)
        checkWinner()
    }

    private fun checkWinner(){
        if(setPlayer1>setPlayer2){
            if(setPlayer1>=6){
                mContext.window.setFlags(
                    WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                    WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                Toast.makeText(mContext,"PLAYER 1 WIN, Please start the app again  ",Toast.LENGTH_SHORT).show()
            }
        }else{
            if(setPlayer2>=6){
                mContext.window.setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                    WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                Toast.makeText(mContext,"PLAYER 2 WIN, Please start the app again  ",Toast.LENGTH_SHORT).show()
            }
        }
    }
}