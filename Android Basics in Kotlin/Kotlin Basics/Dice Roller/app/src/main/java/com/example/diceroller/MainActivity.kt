package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

/**
 *  this activity allow the user to roll a dice and view the
 *  result on the screen
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button2)

        // onClickLIstener for button to roll dice
        rollButton.setOnClickListener {
            Toast.makeText(this, "Dice rolled ", Toast.LENGTH_SHORT).show()
            /**
             * textView1 dice1 updating text with rolling dice
             */
            val dice= Dice(6)
            val randomRolledNumber = dice.roll()

            // updating the textview1 with random rolled number of dice
            val resultTextView: TextView = findViewById(R.id.textView)
            resultTextView.text =
                randomRolledNumber.toString()   //toString bcz TextView used text so converting it to string

        }
    }
}

/**
 * *lass creating dice with  flexible sides and for rolling the dice
 */
class Dice(val numsides: Int) {

    fun roll(): Int {
        return (1..numsides).random()
    }
}