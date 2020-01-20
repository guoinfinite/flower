package com.example.flowers;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;


/*让大雁飞翔*/
public class FlyActivity extends AppCompatActivity {

    /*获取屏幕宽度*/
    private int screenWidth;
    /*代表哦大雁的控件*/
    private ImageView bird;
    /*帧动画*/
    private AnimationDrawable birdAnimation;
    /*属性动画*/
    private AnimatorSet birdAnimatorSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fly);
        getWindowWidth();
        bird = (ImageView) findViewById(R.id.bird);
        /*让大雁摆放位置向左平移一个屏幕宽度*/
        bird.setTranslationX(-screenWidth);
        /*获取帧动画*/
        birdAnimation = (AnimationDrawable) bird.getDrawable();
        /*设置逐帧动画*/
        birdAnimatorSet = new AnimatorSet();
        /*设置位移动画*/
        ObjectAnimator animator = ObjectAnimator.ofFloat(bird, "translationX", screenWidth);

        /*运行时间*/
        animator.setDuration(30*1000);
        /*插值器*/
        animator.setInterpolator(new LinearInterpolator());
        /*从头开始循环*/
        animator.setRepeatCount(-1);

        /*播放逐帧动画*/
        birdAnimatorSet.play(animator);
        /*开启逐帧动画*/
        birdAnimation.start();
        /*开启属性动画*/
        birdAnimatorSet.start();
    }

    /*获取屏幕的宽高*/
    private void getWindowWidth() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        screenWidth = displayMetrics.widthPixels;
    }
}
