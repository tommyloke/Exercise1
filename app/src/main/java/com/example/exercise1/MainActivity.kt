package com.example.exercise1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import java.text.NumberFormat
import java.util.*
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T




class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener {
            var valid = true
            if(editTextCarPrice.text.length==0){
                editTextCarPrice.setError("Invalid")
                valid = false
            }
            else if(editTextDownPayment.text.length==0){
                editTextDownPayment.setError("Invalid")
                valid = false
            }
            else if(editTextLoanPeriod.text.length==0){
                editTextLoanPeriod.setError("Invalid")
                valid = false
            }
            else if(editTextInterestRate.text.length==0){
                editTextInterestRate.setError("Invalid")
                valid = false
            }
            if(valid){
                val car_price = editTextCarPrice.text.toString().toInt()
                val downpayment = editTextDownPayment.text.toString().toInt()
                val loan_period = editTextLoanPeriod.text.toString().toInt()
                val interest_rate = editTextInterestRate.text.toString().toFloat()
                //TODO : continue the calculation here
                val loan = car_price - downpayment
                val interest = loan * interest_rate / 100 * loan_period
                val monthly_pay = (loan + interest) / loan_period / 12

                val format = NumberFormat.getCurrencyInstance(Locale.US)
                val currencyLoan = format.format(loan)
                val currencyInterest = format.format(interest)
                val currencyMonthlyRepayment = format.format(monthly_pay)

                textViewLoan.text = getString(R.string.loan)+ " " + currencyLoan
                textViewInterest.text = getString(R.string.Interest) + " " + currencyInterest
                textViewMonthlyPayment.text = getString(R.string.monthly_repayment) + " "+ currencyMonthlyRepayment
            }
        }
    }

    fun resetInputs(view: View) {
        editTextCarPrice.text.clear()
        editTextDownPayment.text.clear()
        editTextLoanPeriod.text.clear()
        editTextInterestRate.text.clear()
        textViewLoan.text = getString(R.string.loan)
        textViewInterest.text = getString(R.string.Interest)
        textViewMonthlyPayment.text =  getString(R.string.monthly_repayment)

    }
}
