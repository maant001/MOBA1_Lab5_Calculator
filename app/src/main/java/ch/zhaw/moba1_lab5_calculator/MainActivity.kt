package ch.zhaw.moba1_lab5_calculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import android.view.View
import android.widget.Button
import android.widget.TextView
import ch.zhaw.moba1_lab5_calculator.R.id.*
import com.google.android.material.textfield.TextInputEditText



class MainActivity : AppCompatActivity(), View.OnClickListener {
    //private var firstNo: Number? = 0
    //private var secondNo: Number? = 0 // TODO
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

            if(!(firstNoField.text.toString() == null && secondNoField.text.toString() == null)) {
                calculate()
            }
        }
    }

    private fun reset() {
        //firstNo = 0
        //secondNo = 0
        result = ""
        operation = ""
    }

    private fun setOperation(op: String) {
        if (op == "+") {
            operation = "+"
        }
        if (op == "-") {
            operation = "-"
        }
    }

    private fun calculate() {
        if (firstNoField.text.isNullOrBlank() || secondNoField.text.isNullOrBlank()) {
            resultField.text = "error! please enter two numbers!"
        } else {
            val calc = when (operation) {
                "+" -> (firstNoField.text.toString()!!.toDouble() + secondNoField.text.toString()!!.toDouble())
                "-" -> (firstNoField.text.toString()!!.toDouble() - secondNoField.text.toString()!!.toDouble())
                else -> 0.0
            }
            putResult(calc)
            }
        }

    private fun putResult(calc: Double) {
        resultField.text = calc.toString()
    }
}