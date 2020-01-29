package com.example.timepickerdialog;

import android.app.Dialog;
import android.app.TimePickerDialog;

import android.content.Context;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class Timepicker extends DialogFragment implements TimePickerDialog.OnTimeSetListener {
    public interface TimePickerListener{
        void onTimeset(TimePicker view, int hourOfDay, int minute);
    }
    TimePickerListener timePickerListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            timePickerListener = (TimePickerListener) context;
        } catch (Exception e) {
            throw new ClassCastException(getActivity().toString()+"must implement time pick listener");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR);
        int minute = cal.get(Calendar.MINUTE);
        return  new TimePickerDialog(getActivity(),this,hour,minute, DateFormat.is24HourFormat(getContext()));
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        timePickerListener.onTimeset(view,hourOfDay,minute);

    }
}