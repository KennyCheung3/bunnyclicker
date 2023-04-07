package com.example.cookieclicker;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;
import java.util.Timer;

public class MainActivity extends AppCompatActivity {

    private TextView tvPoints;
    private int points = 0;

    private int cps = 100;

    private CookieCounter cookieCounter = new CookieCounter();

    private Typeface ttf;

    private Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvPoints = findViewById(R.id.tvPoints);
        ttf = Typeface.createFromAsset(getAssets(), "EasterBunny.ttf");
        tvPoints.setTypeface(ttf);
        random = new Random();
    }

    public void onClick(View v) {
        if (v.getId() == R.id.imgCookie) {
            Animation a = AnimationUtils.loadAnimation(this, R.anim.cookie_animation);
            a.setAnimationListener(new SimpleAnimationListener() {

                @Override
                public void onAnimationEnd(Animation animation) {
                    cookieClick();

                }
            });

            v.startAnimation(a);

        }
    }

    private void cookieClick() {
        points++;
        tvPoints.setText(Integer.toString(points));
        showToast(R.string.clicked);

    }

    private void showToast(int stringID) {
        final Toast toast = new Toast(this);
        toast.setGravity(Gravity.CENTER|Gravity.LEFT, random.nextInt(600)+100, random.nextInt(600)-300);
        toast.setDuration(Toast.LENGTH_SHORT);
        TextView textView = new TextView(this);
        textView.setText(stringID);
        textView.setTextSize(40f);
        textView.setTextColor(Color.BLACK);
        textView.setTypeface(ttf);
        toast.setView(textView);
        CountDownTimer toastCountDown;
        toastCountDown = new CountDownTimer(500, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                toast.show();
            }

            @Override
            public void onFinish() {
                toast.cancel();
            }
        };
        toast.show();
        toastCountDown.start();
    }

    public void update() {
        points += cps/100;
        tvPoints.setText(Integer.toString(points));
    }

    public class CookieCounter {

        private Timer timer;


        /* COMMENT: Automatically increases the number of cookies per second

        private CookieCounter() {
            timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            update();
                        }
                    });
                }
            }, 1000, 10);
        }

        */
    }
}