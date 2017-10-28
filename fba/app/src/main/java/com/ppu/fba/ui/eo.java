package com.ppu.fba.ui;

import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.text.format.DateFormat;
import android.widget.TimePicker;
import com.ppu.fba.free.R;

class eo implements OnTimeSetListener {
    final /* synthetic */ SettingsActivity f1826a;

    eo(SettingsActivity settingsActivity) {
        this.f1826a = settingsActivity;
    }

    public void onTimeSet(TimePicker timePicker, int i, int i2) {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this.f1826a, new ep(this, i, i2), this.f1826a.f1524k.intValue(), this.f1826a.f1525l.intValue(), DateFormat.is24HourFormat(this.f1826a));
        timePickerDialog.setTitle(R.string.night_end);
        timePickerDialog.show();
    }
}
