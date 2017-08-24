package com.admin.todolist.widget;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.util.Calendar;

/**
 * Created by Administrator on 2017/8/22.
 * 日期时间组件
 */

public class DateAndTimePickerDialog {

   private static OnDateAndTimePickedListener onDateAndTimePickedListener;

    public static void showDateAndTimePickerDialog(Context context,OnDateAndTimePickedListener listener) {
        showDatePickerDialog(context);
        onDateAndTimePickedListener =listener;
    }


        private static int pickedYear;
        private static int pickedMonth;
        private static int pickedDay;
        private static int pickedHour;
        private static int pickedMinute;

    private static void showDatePickerDialog(final Context context) {

        Calendar calendar = Calendar.getInstance();
        int currenYear =calendar.get(Calendar.YEAR);
        int currenMonth = calendar.get(Calendar.MONTH);
        int currenDay =calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(context,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                        showTimePickerDialog(context);
                        pickedYear = year;
                        pickedMonth = monthOfYear;
                        pickedDay = dayOfMonth;
                    }
                }, currenYear, currenMonth, currenDay);
        datePickerDialog.show();
    }

    private static void showTimePickerDialog(Context context) {
        TimePickerDialog timePickerDialog = new TimePickerDialog(context,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        pickedHour = i;
                        pickedMinute = i1;
                        String pickedTime = pickedYear + "/" + (++pickedMonth) + "/" + pickedDay + "/" + pickedHour + "/" + pickedMinute;
                        if(onDateAndTimePickedListener != null){
                            onDateAndTimePickedListener.OnDateAndTimePicked(pickedTime);
                        }
                    }
                }, 0, 0, true);
        timePickerDialog.show();
    }

    public interface OnDateAndTimePickedListener{
        public  void OnDateAndTimePicked(String pickedTime);
    }

}
