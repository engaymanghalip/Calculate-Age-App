package aym.pro.calculateage

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {

  private  var textSelectedDatevar : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textSelectedDatevar = findViewById(R.id.textSelectedDate)

        val btnDatePicker : Button = findViewById(R.id.btn_selectDate)


        btnDatePicker.setOnClickListener {
            clickDatePicker()
        }

    }

   private fun clickDatePicker(){
        var myCalander = Calendar.getInstance()
        var year = myCalander.get(Calendar.YEAR)
        var month = myCalander.get(Calendar.MONTH)
        var day = myCalander.get(Calendar.DAY_OF_MONTH)
        val text2 = findViewById<TextView>(R.id.text2)
       var dp =  DatePickerDialog(this,
           { _ , selectedYear, selectedMonth, selectedDayofmonth ->
               Toast.makeText(this,"Year is $selectedYear, Month is  ${selectedMonth+1} ," +
                       " DAY IS $selectedDayofmonth",Toast.LENGTH_LONG).show()

               val selectedDate = "$selectedDayofmonth/${selectedMonth+1}/$selectedYear"

               textSelectedDatevar?.setText(selectedDate)


               var sdf = SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH)
               val theDate = sdf.parse(selectedDate)

               theDate?.let{
                   val selectedDate01 = theDate.time /60000
                   val current = sdf.parse(sdf.format(System.currentTimeMillis()))
                   current?.let{
                       val currentdDate = current.time /60000
                       val differance = currentdDate - selectedDate01
                       text2.text=differance.toString()
                   }

               }

           },
           year,
           month,
           day
       )
        dp.datePicker.maxDate = System.currentTimeMillis()
        dp.show()


    }

}