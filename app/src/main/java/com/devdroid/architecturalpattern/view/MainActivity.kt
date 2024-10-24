package com.devdroid.architecturalpattern.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.devdroid.architecturalpattern.model.FindMaxModel
import com.devdroid.architecturalpattern.R
import com.devdroid.architecturalpattern.model.AdditionModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnAddition:Button=findViewById(R.id.btnAddition)
        btnAddition.setOnClickListener {
            val i=Intent(this, AdditionModel::class.java)
            startActivity(i)
        }
        val btnFindMax:Button=findViewById(R.id.btnFindMax)
        btnFindMax.setOnClickListener {
            val i=Intent(this, FindMaxModel::class.java)
            startActivity(i)
        }
    }
}