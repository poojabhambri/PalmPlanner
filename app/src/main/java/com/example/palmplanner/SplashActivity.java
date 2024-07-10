package com.example.palmplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Path;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        TextView splashTitle = findViewById(R.id.splashTitle);
        LottieAnimationView lottie = findViewById(R.id.lottie);
        LottieAnimationView turtle = findViewById(R.id.turtle);
//
//        splashTitle.animate().translationY(-1400).setDuration(2700).setStartDelay(0);
//        lottie.animate().translationX(2000).setDuration(2000).setStartDelay(2900);

        ObjectAnimator scaleUpX = ObjectAnimator.ofFloat(splashTitle, "scaleX", 2f);
        scaleUpX.setDuration(1500);
        scaleUpX.setInterpolator(new AccelerateDecelerateInterpolator());

        ObjectAnimator scaleUpY = ObjectAnimator.ofFloat(splashTitle, "scaleY", 2f);
        scaleUpY.setDuration(1500);
        scaleUpY.setInterpolator(new AccelerateDecelerateInterpolator());

        ObjectAnimator fadeIn = ObjectAnimator.ofFloat(splashTitle, "alpha", 1f);
        fadeIn.setDuration(1500);
        fadeIn.setInterpolator(new AccelerateDecelerateInterpolator());

        // Second animation: Slam back
        ObjectAnimator scaleDownX = ObjectAnimator.ofFloat(splashTitle, "scaleX", 1f);
        scaleDownX.setDuration(1500);
        scaleDownX.setInterpolator(new AccelerateDecelerateInterpolator());

        ObjectAnimator scaleDownY = ObjectAnimator.ofFloat(splashTitle, "scaleY", 1f);
        scaleDownY.setDuration(1500);
        scaleDownY.setInterpolator(new AccelerateDecelerateInterpolator());

        ObjectAnimator fadeOut = ObjectAnimator.ofFloat(splashTitle, "alpha", 0f);
        fadeOut.setDuration(1500);
        fadeOut.setInterpolator(new AccelerateDecelerateInterpolator());

        // Chain the animations
        AnimatorSet firstSet = new AnimatorSet();
        firstSet.playTogether(scaleUpX, scaleUpY);

        AnimatorSet secondSet = new AnimatorSet();
        secondSet.playTogether(scaleDownX, scaleDownY, fadeOut);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(firstSet, secondSet);
        animatorSet.start();

        ObjectAnimator fadeTreeOut = ObjectAnimator.ofFloat(lottie, "alpha", 1f, 0f);
        fadeTreeOut.setDuration(1200); // Duration of the fade out animation
        fadeTreeOut.setStartDelay(1200); // Start delay of 1.5 seconds (1500 milliseconds)
        fadeTreeOut.setInterpolator(new AccelerateDecelerateInterpolator());
        fadeTreeOut.start();


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(i);
            }
        }, 3000);
    }
}