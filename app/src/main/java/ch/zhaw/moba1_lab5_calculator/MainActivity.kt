package ch.zhaw.moba1_lab5_calculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ch.zhaw.moba1_lab5_calculator.databinding.ActivityMainBinding

import android.view.View
import android.widget.Button
import android.widget.TextView
import ch.zhaw.moba1_lab5_calculator.R.id.*
import com.google.android.material.textfield.TextInputEditText
import java.text.DecimalFormat



class MainActivity : AppCompatActivity(), View.OnClickListener {
    //private var firstNo: Number? = null
    //private var secondNo: Number? = null // TODO
    private var operation: String = ""
    private var result: String = ""
    private lateinit var resultField: TextView
    private lateinit var firstNoField: TextInputEditText
    private lateinit var secondNoField: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultField = findViewById(resultView)
        firstNoField = findViewById(firstNumberField)
        secondNoField = findViewById(secondNumberField)

        arrayOf<Button>(
            findViewById(additionButton),
            findViewById(minusButton),
        ).forEach {it.setOnClickListener(this)}
    }

    override fun onClick(view: View?) {
        // TODO
        if (view != null || result != null) {
            when (view!!.id) {
                additionButton -> setOperation("+")
                minusButton -> setOperation("-")
            }
            calculate()
        }
    }

    private fun setOperation(op: String) {
        if (op == "+") {
            operation = "+"
        }
        if (op == "-") {
            operation = "-"
        }
    }

    // TODO where to add this?
    private fun calculate() {
        // TODO get numbers, this doesnt work correctly here
        val firstNo = firstNoField.text.toString().toDouble()
        val secondNo = secondNoField.text.toString().toDouble()

        if (firstNo == null || secondNo == null) {
            // TODO error message
            // please enter 2 numbers
            resultField.text = "please enter two numbers"

        } else {
            // TODO
            // i think error happens here

            val calc = when (operation) {
                "+" -> (firstNo!!.toDouble() + secondNo!!.toDouble())
                "-" -> (firstNo!!.toDouble() - secondNo!!.toDouble())
                else -> 0.0
            }
            //putResult(calc)
            resultField.text = calc.toString()
        }
    }

    private fun putResult(calc: Double) {
        //resultField.text = result?.toDouble().toString()
        resultField.text = calc.toString()
    }
}