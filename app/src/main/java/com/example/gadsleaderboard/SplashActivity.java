package com.example.gadsleaderboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    private final static int MSG_CONTINUE = 1234;
    private final static long DELAY = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mHandler.sendEmptyMessageDelayed(MSG_CONTINUE, DELAY);

    }

    @Override
    protected void onDestroy()
    {
        mHandler.removeMessages( MSG_CONTINUE );
        super.onDestroy();
    }

    private void _continue()
    {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    private final Handler mHandler = new Handler(){
        public void handleMessage(android.os.Message msg){
            if (msg.what == MSG_CONTINUE) {
                _continue();
            }
        }
    };
}

