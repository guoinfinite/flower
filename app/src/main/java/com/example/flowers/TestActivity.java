package com.example.flowers;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorInflater;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;

import com.example.flowers.view.Plant;

public class TestActivity extends AppCompatActivity {

    private Plant plant;//控件
    private View background;//界面
    private ObjectAnimator parentAnimator;//父布局动画
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        background = getLayoutInflater().inflate(R.layout.activity_test,null);
        setContentView(background);
        plant = (Plant) findViewById(R.id.plant2);//初始化控件
        plant.setCirculation(true);//设置循环
        setParentViewAnimation();//设置背景颜色渐变的动画
    }
    /**
     * 设置背景颜色渐变动画
     */
    private void setParentViewAnimation() {
        parentAnimator= (ObjectAnimator) AnimatorInflater.
                loadAnimator(this, R.animator.background);
        parentAnimator.setEvaluator(new ArgbEvaluator());
        parentAnimator.setTarget(background);
    }
    /**
     * 按钮
     * @param view
     */
    public void test2(View view){
        plant.plantAnimatorStart();
        parentAnimator.start();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }
}

