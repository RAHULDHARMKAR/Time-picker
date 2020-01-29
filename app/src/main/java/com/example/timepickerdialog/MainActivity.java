package com.example.timepickerdialog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements Timepicker.TimePickerListener {
    private TextView t_dialog;
    Button b_show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t_dialog = findViewById(R.id.t_dialog);
        b_show = findViewById(R.id.b_show);
        b_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timepicker = new Timepicker();
                timepicker.setCancelable(false);
                timepicker.show(getSupportFragmentManager(),"timepicker");
            }
        });

    }

    @Override
    public void onTimeset(TimePicker view, int hourOfDay, int minute) {
       t_dialog.setText("Hour ="+ hourOfDay + "Minute ="+ minute );
    }
}
