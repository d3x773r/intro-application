package com.gurpster.introapplication;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class MainActivity extends AppCompatActivity {

    private AppCompatImageView leftGesture;
    private AppCompatImageView rightGesture;
    private AppCompatImageView upGesture;
    private AppCompatImageView downGesture;
    private AppCompatImageView clickGesture;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        leftGesture = (AppCompatImageView) findViewById(R.id.swipe_gesture_left);
        rightGesture = (AppCompatImageView) findViewById(R.id.swipe_gesture_right);
        upGesture = (AppCompatImageView) findViewById(R.id.swipe_gesture_up);
        downGesture = (AppCompatImageView) findViewById(R.id.swipe_gesture_down);
        clickGesture = (AppCompatImageView) findViewById(R.id.swipe_gesture_click);
    }

    @Override
    protected void onResume() {
        super.onResume();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
//                leftAndRight();
                right();
//                Toast.makeText(MainActivity.this, "run", Toast.LENGTH_SHORT).show();
            }
        }, 900);
    }

    private void leftAndRight() {

    }

    private void left() {
        rightGesture.setVisibility(View.VISIBLE);

        final Animation left =
                AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move_right);
        rightGesture.startAnimation(left);
        left.setRepeatCount(3);

        left.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                left.start();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                Toast.makeText(MainActivity.this, "end", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void right() {
        leftGesture.setVisibility(View.VISIBLE);
        final Animation right =
                AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move_left);
        leftGesture.startAnimation(right);
        right.setRepeatCount(3);

        right.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                right.start();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    private void upAndDown() {

        upGesture.setVisibility(View.VISIBLE);
        YoYo.with(Techniques.FadeOutLeft)
                .duration(1000)
                .repeat(3)
                .playOn(upGesture);
        upGesture.setVisibility(View.GONE);

        downGesture.setVisibility(View.VISIBLE);
        YoYo.with(Techniques.FadeOutLeft)
                .duration(1000)
                .repeat(3)
                .playOn(downGesture);
        downGesture.setVisibility(View.GONE);

    }
}
