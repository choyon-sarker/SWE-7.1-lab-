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
import com.devdroid.architecturalpattern.viewmodel.FindMaxViewModel
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class FindMaxModel : AppCompatActivity() {

    private lateinit var dbRef: DatabaseReference
    private lateinit var firstNumber: EditText
    private lateinit var secondNumber: EditText
    private lateinit var thirdNumber:EditText
    private lateinit var btnFindMax1: Button
    private lateinit var answer: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_find_max_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        firstNumber=findViewById(R.id.firstNumber)
        secondNumber=findViewById(R.id.secondNumber)
        thirdNumber=findViewById(R.id.thirdNumber)
        btnFindMax1=findViewById(R.id.btnFindMax1)
        answer=findViewById(R.id.ansFindMax)

        dbRef= FirebaseDatabase.getInstance().getReference("Find Max Values")
        btnFindMax1.setOnClickListener {
            val firstNumber=firstNumber.text.toString()
            val secondNumber=secondNumber.text.toString()
            val thirdNumber=thirdNumber.text.toString()

            val find=FindMaxViewModel().findMax(firstNumber.toInt(),secondNumber.toInt(),thirdNumber.toInt())
            answer.text=find.toString()
            val answerValue=answer.text.toString()

            val FindMaxValue= FindMaxDataModel(firstNumber.toInt(),secondNumber.toInt(),thirdNumber.toInt(),answerValue.toInt())
            val FindMaxValueid=dbRef.push().key!!
            dbRef.child(FindMaxValueid).setValue(FindMaxValue)

        }
    }
}