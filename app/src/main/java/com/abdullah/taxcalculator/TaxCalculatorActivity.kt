package com.abdullah.taxcalculator

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_tax2223.*

class TaxCalculatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tax2223)

        calculate.setOnClickListener {
            hideKeyboard()
            if (et_monthly_salary.text.isNullOrBlank()) {
                Toast.makeText(this, "Enter monthly salary", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val salary: Int = et_monthly_salary.text.toString().trim().toInt() * 12

            if (salary <= 600000) {
                tv_annual_tax_23.text = "0"
                tv_annual_tax_22.text = "0"
                return@setOnClickListener
            }

            calculateTax23(salary)
            calculateTax22(salary)

        }
    }

    private fun hideKeyboard() {
        hideKeyboard(currentFocus ?: View(this))
    }

    private fun Context.hideKeyboard(view: View) {
        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun calculateTax23(salary: Int){
        if (salary in 600001..1200000) {
            val taxAbleSalary = salary - 600000
            tv_annual_tax_23.text = (taxAbleSalary * 0.025).toString()
            return
        }

        if (salary in 1200001..2400000) {
            val taxAbleSalary = salary - 1200000
            tv_annual_tax_23.text = (15000 + (taxAbleSalary * 0.125)).toString()
            return
        }

        if (salary in 2400001..3600000) {
            val taxAbleSalary = salary - 2400000
            tv_annual_tax_23.text = (165000 + (taxAbleSalary * 0.2)).toString()
            return
        }

        if (salary in 3600001..6000000) {
            val taxAbleSalary = salary - 3600000
            tv_annual_tax_23.text = (405000 + (taxAbleSalary * 0.25)).toString()
            return
        }

        if (salary in 6000001..12000000) {
            val taxAbleSalary = salary - 6000000
            tv_annual_tax_23.text = (1005000 + (taxAbleSalary * 0.325)).toString()
            return
        }

        if (salary > 12000000) {
            val taxAbleSalary = salary - 12000000
            tv_annual_tax_23.text = (2955000 + (taxAbleSalary * 0.35)).toString()
            return
        }
    }
    
    private fun calculateTax22(salary:Int){
        if (salary in 600001..1200000) {
            val taxAbleSalary = salary - 600000
            tv_annual_tax_22.text = (taxAbleSalary * 0.05).toString()
            return
        }

        if (salary in 1200001..1800000) {
            val taxAbleSalary = salary - 1200000
            tv_annual_tax_22.text = (30000 + (taxAbleSalary * 0.1)).toString()
            return
        }

        if (salary in 180001..2500000) {
            val taxAbleSalary = salary - 1800000
            tv_annual_tax_22.text = (90000 + (taxAbleSalary * 0.15)).toString()
            return
        }

        if (salary in 2500001..3500000) {
            val taxAbleSalary = salary - 2500000
            tv_annual_tax_22.text = (195000 + (taxAbleSalary * 0.175)).toString()
            return
        }

        if (salary in 3500001..5000000) {
            val taxAbleSalary = salary - 3500000
            tv_annual_tax_22.text = (370000 + (taxAbleSalary * 0.2)).toString()
            return
        }

        if (salary in 5000001..8000000) {
            val taxAbleSalary = salary - 5000000
            tv_annual_tax_22.text = (670000 + (taxAbleSalary * 0.225)).toString()
            return
        }

        if (salary in 8000001..12000000) {
            val taxAbleSalary = salary - 8000000
            tv_annual_tax_22.text = (1345000 + (taxAbleSalary * 0.25)).toString()
            return
        }

        if (salary in 12000001..30000000) {
            val taxAbleSalary = salary - 12000000
            tv_annual_tax_22.text = (2345000 + (taxAbleSalary * 0.275)).toString()
            return
        }

        if (salary in 30000001..50000000) {
            val taxAbleSalary = salary - 30000000
            tv_annual_tax_22.text = (7295000 + (taxAbleSalary * 0.3)).toString()
            return
        }

        if (salary in 50000001..75000000) {
            val taxAbleSalary = salary - 50000000
            tv_annual_tax_22.text = (13295000 + (taxAbleSalary * 0.325)).toString()
            return
        }

        if (salary > 75000000) {
            val taxAbleSalary = salary - 75000000
            tv_annual_tax_22.text = (21420000 + (taxAbleSalary * 0.35)).toString()
            return
        }
    }

    override fun onBackPressed() {
        finish()
    }
}