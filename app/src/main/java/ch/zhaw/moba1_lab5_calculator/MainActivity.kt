package ch.zhaw.moba1_lab5_calculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ch.zhaw.moba1_lab5_calculator.databinding.ActivityMainBinding

import android.view.View
import android.widget.Button
import android.widget.TextView
import ch.zhaw.moba1_lab5_calculator.R.id.resultView


class MainActivity : AppCompatActivity() {
    private var firstNo: Number? = null
    private var secondNo: Number? = null
    private var operation: String = ""
    private var result: Number? = null
    private lateinit var resultField: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        // TODO find out what goes here
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultField = findViewById(resultView)
    }

    fun onClick(view: View?) {
        // TODO
        if (view != null) {
            when (view.id) {
                R.id.additionButton -> setOperation("+")
                R.id.minusButton -> setOperation("-")
            }
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

    private fun calculate() {
        if (firstNo == null || secondNo == null) {
            // TODO error message
            // please enter 2 numbers
        } else {
            when (op) {
                "+" -> result = firstNo!!.toDouble() + secondNo!!.toDouble()
                "-" -> result = firstNo!!.toDouble() - secondNo!!.toDouble()
            }
        }
        putResult()
    }

    private fun putResult() {
        // TODO put result to resultfield
    }
}