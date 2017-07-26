package com.shen.myminiheadline.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import com.shen.myminiheadline.MainActivity;
import com.shen.myminiheadline.R;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {
    private SharedPreferences sp;
    private boolean isFirstLogin ;
    private MyCount myCount;
    private TextView tvCountDownTimer;
    private Timer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        overridePendingTransition(0,R.anim.zoom_enter);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        sp = getSharedPreferences("isFirstLogin",MODE_PRIVATE);
        tvCountDownTimer = (TextView) findViewById(R.id.tv_countdown_timer);
        isFirstLogin = sp.getBoolean("isFirstKey",true);
        myCount = new MyCount(10*1000,1000);
        myCount.start();
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent();
                if(isFirstLogin){
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putBoolean("isFirstKey",false);
                    editor.commit();
                    intent.setClass(SplashActivity.this,GuideActivity.class);
                }else{
                    intent.setClass(SplashActivity.this, MainActivity.class);
                }
                SharedPreferences.Editor editor = sp.edit();
                editor.putBoolean("isFirstKey",true);
                editor.commit();
                startActivity(intent);
                SplashActivity.this.finish();
            }
        },10*1000);

        tvCountDownTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.cancel();
                Intent intent = new Intent(SplashActivity.this,GuideActivity.class);
                startActivity(intent);
            }
        });
    }

    class MyCount extends CountDownTimer {
        /**
         * @param millisInFuture    The number of millis in the future from the call
         *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
         *                          is called.
         * @param countDownInterval The interval along the way to receive
         *                          {@link #onTick(long)} callbacks.
         */
        public MyCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            tvCountDownTimer.setText(millisUntilFinished/1000+"s");
        }

        @Override
        public void onFinish() {

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myCount.cancel();
    }
}
