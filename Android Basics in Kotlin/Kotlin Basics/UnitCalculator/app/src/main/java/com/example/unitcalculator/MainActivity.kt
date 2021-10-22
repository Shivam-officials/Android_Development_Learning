package com.example.unitcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.unitcalculator.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //setting onClickListener on calculateVolume button
        binding.volumeButton.setOnClickListener { calculateVolume() }
    }

    /**
    function for calculating volume (onClickEventHandler of volumeButton button
    */
    private fun calculateVolume(){

        //getting values of user entry
        val stringInTextView = binding.volume.text.toString()
        val volume = stringInTextView.toDoubleOrNull()


        //exit the function if volume is null or 0.0
        if(volume == null || volume ==0.0 ){
            showResult(0.0)
            return
        }

        //calculate volume based on the selected radioButton
        if(binding.conversionOptions.checkedRadioButtonId == R.id.mlToOz){
           showResult(volume * 0.033814)
        }else{
            showResult(volume * 29.574)
        }

    }

    /**
    function for showing calculated volume in calculatedVolume textView
     */
    private fun showResult(result:Double){
        binding.calculatedVolume.text = getString(R.string.calculated_volume,"%.2f".format(result))
    }


}