package com.example.androidaudio;

import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	
	private Button mStart, mStop;
	private ExtAudioRecorder extAudioRecorder;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mStart = (Button)findViewById(R.id.start);
		mStop = (Button)findViewById(R.id.stop);
		
		mStart.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				extAudioRecorder = ExtAudioRecorder.getInstanse(true);    // Compressed recording (AMR)
					//extAudioRecorder = ExtAudioRecorder.getInstanse(false); // Uncompressed recording (WAV)
					 
					extAudioRecorder.setOutputFile(Environment.getExternalStorageDirectory().getAbsolutePath() + "/javarecorder.wav");
					extAudioRecorder.prepare();
					extAudioRecorder.start();
				
			}
		});
		
		mStop.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				extAudioRecorder.stop();
				extAudioRecorder.release();
				
			}
		});
		
	}

	
}
