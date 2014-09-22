package com.bogdan.droid.apps;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.drm.DrmStore;
import android.media.AudioManager;
import android.media.MediaActionSound;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.Settings;
import android.transition.Visibility;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.TextView;

public class WhiteActivity extends Activity {
    private static final float MAX_SCREEN_BRIGHTNESS = 1.0f;

	/** Called when the activity is first created. */
    @SuppressLint("NewApi")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
        		WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        maximizeBrightness();

        final Button exitButton = (Button) findViewById(R.id.buttonExit);

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //exit application
//                MediaPlayer mp = new MediaPlayer();
//
//                mp.release();
//                MediaActionSound sound = new MediaActionSound();
//                sound.play(MediaActionSound.SHUTTER_CLICK);

//                SoundPool soundPool = new SoundPool(1, AudioManager.STREAM_NOTIFICATION, 0);
//                int shutterSound = soundPool.load(this, R.raw.camera_click, 0);
//                soundPool.play(shutterSound, 1f, 1f, 0, 0, 1);
                System.exit(0);
            }
        });

//        final Button button = (Button) findViewById(R.id.button);
//
//        EditText minutes = (EditText) findViewById(R.id.editMinutes);
//        long mins = Long.parseLong(minutes.getText().toString());
//
//        EditText seconds = (EditText) findViewById(R.id.editSeconds);
//        long secs = Long.parseLong(seconds.getText().toString());
//
//        final long totalMillis = ((mins * 60)*1000)+(secs*1000);
//
//        button.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                // Perform action on click
//                final GridLayout gv = (GridLayout) findViewById(R.id.TimerGrid);
//                gv.setVisibility(View.INVISIBLE);
//                new CountDownTimer(totalMillis, 1000) {
//                    @Override
//                    public void onFinish() {
//                        gv.setVisibility(View.VISIBLE);
//                        exitButton.setVisibility(View.VISIBLE);
//                    }
//
//                    @Override
//                    public void onTick(long l) {
//                        //
//                    }
//                }.start();
//            }
//        });
    }

	protected void maximizeBrightness() {
		Window win = getWindow();
		int mode = Settings.System.getInt(getContentResolver(), Settings.System.SCREEN_BRIGHTNESS_MODE, Settings.System.SCREEN_BRIGHTNESS_MODE_MANUAL);
		if(mode == Settings.System.SCREEN_BRIGHTNESS_MODE_AUTOMATIC || mode == Settings.System.SCREEN_BRIGHTNESS_MODE_MANUAL) {
			WindowManager.LayoutParams winParams = win.getAttributes();
			winParams.screenBrightness = MAX_SCREEN_BRIGHTNESS;
			win.setAttributes(winParams);
		}
	}
}