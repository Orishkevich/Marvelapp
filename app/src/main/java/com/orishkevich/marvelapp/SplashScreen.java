package com.orishkevich.marvelapp;
/**Splash Screen*/

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {

    private ImageView mImageView;
    private Animation mEnlargeAnimation;



    @Override
    protected void onPause() {
        super.onPause();
        mImageView.clearAnimation();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        mImageView = (ImageView) findViewById(R.id.store_logo_load);

        // подключаем файл анимации
        mEnlargeAnimation = AnimationUtils.loadAnimation(this, R.anim.enlarge);

        // при запуске начинаем с эффекта увеличения
        mImageView.startAnimation(mEnlargeAnimation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent( SplashScreen.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        }, 3000);
    }
    }

