package com.shen.myminiheadline.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;

import com.shen.myminiheadline.MainActivity;
import com.shen.myminiheadline.R;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {
    private SharedPreferences sp;
    private boolean isFirstLogin ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        sp = getSharedPreferences("isFirstLogin",MODE_PRIVATE);
        isFirstLogin = sp.getBoolean("isFirstKey",true);
        new Timer().schedule(new TimerTask() {
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
        },3000);
    }
}
