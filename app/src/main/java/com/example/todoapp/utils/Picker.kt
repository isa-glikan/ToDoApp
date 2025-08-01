package com.example.todoapp.utils

import android.content.Context
import android.icu.text.SimpleDateFormat
import android.icu.util.TimeZone
import android.widget.EditText
import androidx.fragment.app.FragmentManager
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import java.util.Date
import java.util.Locale

class Picker(var fragmentManager: FragmentManager,private var editText: EditText) {
    init {
        makeDatePicker()
        makeTimePiker()
    }

    private fun makeTimePiker() {
        var timPicker: MaterialTimePicker = MaterialTimePicker.Builder().setTitleText("select time")
            .setTimeFormat(TimeFormat.CLOCK_24H).build()
        timPicker.show(fragmentManager, "timePickerInAddTask")
        timPicker.addOnPositiveButtonClickListener {
            hour = timPicker.hour
            minute = timPicker.minute
            var result= "$fullDate, $hour , $minute"
            editText.setText(result)
        }

    }

    private fun makeDatePicker() {
        val datepicker =
            MaterialDatePicker.Builder.datePicker().setTitleText("select date ").build()
        datepicker.show(fragmentManager, "datePickerInAddTask")

        datepicker.addOnPositiveButtonClickListener {
            val outpDateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
            outpDateFormat.timeZone = TimeZone.getTimeZone("UTC")
            fullDate = outpDateFormat.format(it)
            makeTimePiker()
        }

    }

}
