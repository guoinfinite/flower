package com.example.flowers.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.flowers.db.DatasDao;
import com.example.flowers.db.MyDataUtils;
import com.example.flowers.ui.utils.GetDateUtils;
import com.example.flowers.ui.utils.SaveKeyValues;

/**
 * 接收广播并清空数据
 */
public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (GetDateUtils.dayOfWeek() == 1){//1代表星期日
            //清空一周的花儿种的数量
            SaveKeyValues.putIntValues("flowerCount",0);
            //重置花的数量
            MyDataUtils.upData(new DatasDao(context));
        }
    }
}
