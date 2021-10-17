package com.example.tiptime

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // onClickListner of calculateButton
        binding.calculateButton.setOnClickListener { calculateTip() }

    }

    /*
    function for calculating the tip
     */
    private fun calculateTip() {
        val stringInTextField = binding.costOfService.text.toString()
        val cost = stringInTextField.toDouble()

        //storing tip percentage acc to selected radioButton in a tipPercentage variable
        val tipPercentage = when (binding.tipOptions.checkedRadioButtonId) {
            R.id.option_twenty_percent -> 0.2
            R.id.option_eighteen_percent -> 0.18
            else -> 0.15
        }

        //calculating tip
        var tip = cost * tipPercentage

        //rounding up the tip
        val roundup = binding.roundUpSwitch.isChecked
        if (roundup) {
            tip = kotlin.math.ceil(tip)
        }

        //formatting the tip in currency format
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)

        //assigning the formatted tip in tipResult TextView text
        binding.tipResult.text = getString(R.string.tip_amount, formattedTip)

    }


}
