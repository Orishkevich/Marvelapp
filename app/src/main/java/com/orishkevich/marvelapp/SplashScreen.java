package com.orishkevich.marvelapp;
/**
 * Splash Screen
 */

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

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
// анимация
        mImageView = (ImageView) findViewById(R.id.store_logo_load);
        mEnlargeAnimation = AnimationUtils.loadAnimation(this, R.anim.enlarge);
        mImageView.startAnimation(mEnlargeAnimation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        }, 2000);
    }
}

