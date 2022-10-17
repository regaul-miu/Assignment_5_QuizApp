package com.example.quizapp

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.quizapp.R
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    var points:Double = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rgroup.clearCheck()



        btnSubmit.setOnClickListener {
            val sdf = SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z")
            val date: String = sdf.format(Date())
            points = 0.0
//        val selectedRadio = rgroup.checkedRadioButtonId
            if (r2.isChecked){
                points += 50
            }
            if (c1.isChecked)
                points += 50

            val dialogBuilder = AlertDialog.Builder(this)

            // set message of alert dialog
            dialogBuilder.setMessage("“Congratulations! You submitted on $date, You achieved $points%")
                // if the dialog is cancelable
                .setCancelable(false)
                // positive button text and action
                .setPositiveButton("Finish", DialogInterface.OnClickListener {
                        dialog, id -> finish()
                })
                // negative button text and action
                .setNegativeButton("Cancel", DialogInterface.OnClickListener {
                        dialog, id -> dialog.cancel()
                })

            // create dialog box
            val alert = dialogBuilder.create()
            // set title for alert dialog box
            alert.setTitle("Exam finished!!!")
            // show alert dialog
            alert.show()
        }
        btnReset.setOnClickListener {
            rgroup.clearCheck()
            c1.isChecked = false
            c2.isChecked = false
            c3.isChecked = false
        }

    }
}