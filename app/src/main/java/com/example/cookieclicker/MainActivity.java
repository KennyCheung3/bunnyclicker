package com.example.cookieclicker;

import android.app.AlertDialog;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private TextView tvPoints;
    private int points;

    private int cps;



    private CookieCounter cookieCounter = new CookieCounter();

    private Typeface ttf;

    private Random random;

    private TextView tvCps;

    private int[] Images = {R.drawable.cursor};
    private String[] Names = {"Item 1"};
    private String[] Description = {"+100 Bunnies per second"};

    private int[] Images2 = {R.drawable.cursor2};
    private String[] Names2 = {"Item 2"};
    private String[] Description2 = {"+500 Bunnies per second"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvPoints = findViewById(R.id.tvPoints);
        ttf = Typeface.createFromAsset(getAssets(), "EasterBunny.ttf");
        tvPoints.setTypeface(ttf);
        tvCps = findViewById(R.id.tvCps);
        tvCps.setTypeface(ttf);
        random = new Random();
        open();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            showCookieFragment();
            tvPoints = findViewById(R.id.tvPoints);
            ttf = Typeface.createFromAsset(getAssets(), "EasterBunny.ttf");
            tvPoints.setTypeface(ttf);
            tvCps = findViewById(R.id.tvCps);
            tvCps.setTypeface(ttf);
            random = new Random();
            open();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onPause() {
        super.onPause();
        save();
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

        } else if (v.getId() == R.id.btnShop) {
            showShopFragment();
            save();
        }
    }

    private void showCookieFragment() {
        ViewGroup container = findViewById(R.id.container);
        container.removeAllViews();
        container.addView(getLayoutInflater().inflate(R.layout.activity_main, null));
    }

    private void cookieClick() {
        points++;
        tvPoints.setText(Integer.toString(points));
        showToast(R.string.clicked);

    }

    private void showToast(int stringID) {
        final Toast toast = new Toast(this);
        toast.setGravity(Gravity.CENTER|Gravity.LEFT, random.nextInt(400)+100, random.nextInt(400)-300);
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
        tvCps.setText(Integer.toString(cps) + " cps");
    }

    private void save() {
        SharedPreferences preferences = getSharedPreferences("GAME", 0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("cps", cps);
        editor.putInt("cookies", points);
        editor.commit();
    }

    private void open() {
        SharedPreferences preferences = getSharedPreferences("GAME", 0);
        cps = preferences.getInt("cps", 0);
        points = preferences.getInt("cookies", 0);
    }

    private void showShopFragment() {
        ViewGroup container = findViewById(R.id.container);
        ShopAdapter shopAdapter = new ShopAdapter();
        container.removeAllViews();
        container.addView(getLayoutInflater().inflate(R.layout.shop_activity, null));
        ((ListView)findViewById(R.id.listShop)).setAdapter(shopAdapter);

    }

    private void updateCps(int i) {
        cps += i;
    }

    private void updatePoints(int i) {
        points -= i;
    }


    public class CookieCounter {

        private Timer timer;


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

    }


    // NEEDS TO BE CHECKED AND FIXED VVVVV
    // NEEDS TO BE CHECKED AND FIXED VVVVV
    // NEEDS TO BE CHECKED AND FIXED VVVVV


    public class ShopAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return Images.length;
        }

        public int getCount2() {
            return Images2.length+1;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.item_listview, null);

            ((ImageView)convertView.findViewById(R.id.imgItem)).setImageResource(Images[position]);
            ((TextView)convertView.findViewById(R.id.tvName)).setText(Names[position]);
            ((TextView)convertView.findViewById(R.id.tvDescription)).setText(Description[position]);


            ((ImageView)convertView.findViewById(R.id.imgItem2)).setImageResource(Images2[position]);
            ((TextView)convertView.findViewById(R.id.tvName2)).setText(Names2[position]);
            ((TextView)convertView.findViewById(R.id.tvDescription2)).setText(Description2[position]);

            int imgItem2 = 2;

            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {



                    if (getCount() == 1) {
                        if (points > 100) {
                            updateCps(100);
                            updatePoints(100);
                            save();
                        }
                    }
                    if (imgItem2 == 2) {
                        if (points > 500) {
                            updateCps(500);
                            updatePoints(500);
                            save();
                        } else {
                            new AlertDialog.Builder((MainActivity.this)).setMessage("You do not have enough points!")
                                   .show();
                        }
                    }
                }
            });

            return convertView;
        }
    }

}