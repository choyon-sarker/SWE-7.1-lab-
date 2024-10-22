package com.devdroid.architecturalpattern.model

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.devdroid.architecturalpattern.R
import com.devdroid.architecturalpattern.viewmodel.AdditionFunction
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AdditionModel : AppCompatActivity() {

     private lateinit var dbRef:DatabaseReference
    private lateinit var firstNumber:EditText
    private lateinit var secondNumber:EditText
    private lateinit var btnAddition: Button
    private lateinit var answer:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_addition_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        firstNumber=findViewById(R.id.firstNumber)
        secondNumber=findViewById(R.id.secondNumber)
        btnAddition=findViewById(R.id.btnAddition)
        answer=findViewById(R.id.ansAddition)


        dbRef=FirebaseDatabase.getInstance().getReference("AdditionData")
        btnAddition.setOnClickListener {
            val firstNumber=firstNumber.text.toString()
            val secondNumber=secondNumber.text.toString()

            //val add=AdditionFunction(AddTwoNumber(firstNumber.toInt(),secondNumber.toInt()))
            //val add=AddTwoNumber(firstNumber.toInt(),secondNumber.toInt())
            val add=AdditionFunction().AddTwoNumber(firstNumber.toInt(),secondNumber.toInt())
            answer.text=add.toString()
            val answerValue=answer.text.toString()

            val AdditionValue=AdditionDataModel(firstNumber.toInt(),secondNumber.toInt(),answerValue.toInt())
            val AdditionValueId=dbRef.push().key!!
            dbRef.child(AdditionValueId).setValue(AdditionValue)

        }
    }

}