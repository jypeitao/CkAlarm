package com.example.ckalarm;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.widget.Toast;

public class FeedbackBroadcastReceiver extends BroadcastReceiver {
	public void onReceive(Context context, Intent intent) {
		Toast.makeText(context, "Alarm Test", Toast.LENGTH_SHORT)
		     .show();
		Vibrator vib = (Vibrator) context
				.getSystemService(Service.VIBRATOR_SERVICE);
		vib.vibrate(5000);//Õñ¶¯5s
	}

}
