package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button2)
        rollButton.setOnClickListener {
            Toast.makeText(this, "Dice rolled ", Toast.LENGTH_SHORT).show()

            val dice = Dice(6)
            val randomRolledNumber = dice.roll()

           // updating the textview with random rolled number of dice
            val resultTextView: TextView= findViewById(R.id.textView)
            resultTextView.text=randomRolledNumber.toString()   //toString bcz TextView used text so converting it to string
        }
    }
}
class Dice( val numsides: Int) {

    fun roll(): Int {
        return (1..numsides).random()
    }
}