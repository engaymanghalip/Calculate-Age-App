package aym.pro.calculateage

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btnDatePicker : Button = findViewById(R.id.btn_selectDate)

        btnDatePicker.setOnClickListener {
            clickDatePicker()
        }

    }

    fun clickDatePicker(){
        var myCalander = Calendar.getInstance()
        var year = myCalander.get(Calendar.YEAR)
        var month = myCalander.get(Calendar.MONTH)
        var day = myCalander.get(Calendar.DAY_OF_MONTH)
        DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener{view,year,month,dayofmonth ->

            },
            year,
            month,
            day
            )

        Toast.makeText(this,"presed",Toast.LENGTH_LONG).show()
    }

}