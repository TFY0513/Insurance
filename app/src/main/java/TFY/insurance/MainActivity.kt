package TFY.insurance

import TFY.insurance.databinding.ActivityMainBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.lang.NumberFormatException
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    //TODO 2: Create an instance of view binding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //TODO 3: Initialize the view binding
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        binding.buttonCalculate.setOnClickListener{
            val age = binding.spinnerAge.selectedItemPosition
            val gender = binding.radioGroupGender.checkedRadioButtonId
            val smoker = binding.checkBoxSmoker.isChecked

            var premium = 0
            //Method 1: to check premium based on age
//            if(age == 0){ // less than 17
//                premium += 60
//            }

            //Method 2: to check premium based on age
            premium = when(age){
                0 -> 60
                1 -> 70
                2 -> 90
                3 -> 120
                else -> 150
            }

            if(gender == binding.radioButtonMale.id){
                premium = when(age){
                    0 -> premium + 0
                    1 -> premium + 50
                    2 -> premium + 100
                    3 -> premium + 150
                    else -> premium + 200
                }
            }

            if(smoker){
                premium = when(age){
                    0 -> premium + 0
                    1 -> premium + 100
                    2 -> premium + 150
                    3 -> premium + 200
                    4 -> premium + 250
                    else -> premium + 300
                }
            }

            val output_premium = NumberFormat.getCurrencyInstance().format(premium)
            binding.textViewPremium.text = output_premium
        }

        binding.buttonReset.setOnClickListener{
            binding.spinnerAge.setSelection(0)
            binding.radioGroupGender.clearCheck()
            binding.textViewPremium.text = null
            binding.checkBoxSmoker.isChecked = false
        }
    }
}