package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

/**
 *  this activity allow the user to roll a dice and view the
 *  result on the screen
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

<<<<<<< Updated upstream
        //Find the roll Button in the layout
        val rollButton: Button = findViewById(R.id.button2)
=======
        // onClickLIstener for button to roll dice
        rollButton.setOnClickListener {
            Toast.makeText(this, "Dice rolled ", Toast.LENGTH_SHORT).show()
            /**
             * textView1 dice1 updating text with rolling dice
             */
            val dice = Dice(6)
            val randomRolledNumber = dice.roll()
>>>>>>> Stashed changes

        // onClickListener for button to roll dice and imageView
        rollButton.setOnClickListener { rollDice() }

        //roll the dice when the app starts automatically
        rollDice()
    }

    /**
     * roll the dice and update the image acc. to the result
     */
    private fun rollDice() {
        // creating a new dice object with 6 numsides and roll the dice
        val dice = Dice(6)
        val randomRolledNumber = dice.roll()

<<<<<<< Updated upstream
        //toast for text msg dice rolled at this number
        Toast.makeText(this, "Dice rolled at $randomRolledNumber", Toast.LENGTH_SHORT).show()
=======
            // updating the textview2 with random rolled number of dice
            val resultTextView2: TextView = findViewById(R.id.textView2)
            resultTextView2.text =
                randomRolledNumber2.toString()//toString bcz TextView used text so converting it to string
<<<<<<< Updated upstream
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes

        //Determining which dice resource ID is going to be used acc to randomRolledNumber
        val diceImage: ImageView = findViewById(R.id.imageView)
        val drawableResource = when (randomRolledNumber) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        //updating the imageView with dice image acc to rollRandomNumber
        diceImage.setImageResource(drawableResource)

        // setting the contentDescription acc . randomRolledNumber
        diceImage.contentDescription = randomRolledNumber.toString()
    }

}


/**
 * class creating dice with  flexible sides and for rolling the dice
 */
class Dice(val numsides: Int) {

    //do a dice roll and return a random result
    fun roll(): Int {
        return (1..numsides).random()
    }
}