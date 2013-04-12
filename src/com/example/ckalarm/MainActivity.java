package com.example.ckalarm;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findViewById(R.id.button).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				AlarmManager am = (AlarmManager)getSystemService(ALARM_SERVICE);  
		        Intent intent = new Intent(getApplicationContext(), 
		        		FeedbackBroadcastReceiver.class);
		        PendingIntent sender = PendingIntent.getBroadcast(
		        		getApplicationContext(), 
		        		0, 
		        		intent, 
		        		PendingIntent.FLAG_CANCEL_CURRENT);
		        am.set(AlarmManager.RTC_WAKEUP, getLaterTime(1), sender);
			}
		});
	}
	//获取距现在minute分钟后的时间
	long getLaterTime(int minute) {
		long now = System.currentTimeMillis(); 
		now += minute*60*1000;
		return now;
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
