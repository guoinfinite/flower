package com.example.flowers.ui.base;

import android.view.View;

/**
 * 用于设置标题栏
 */
public interface SetTitleShowStyle {
    //是否有标题
    boolean isAddTitle();
    //带有左右图片的标题栏
    void setTitleLeftImgAndRightImg(View leftView, View rightView);
    //返回左侧按钮
    void setTitleLeftImg(View leftView);
    //返回 左边 中间 右的的一个按钮
    void setTitleLeftImgWithTitleRightImg(View leftView, View title, View rightView);
}
