package com.shen.myminiheadline.entity;

import android.app.Application;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;

import org.xutils.x;

/**
 * Created by shgl1hz1 on 2017/6/22.
 */

public class MyApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        SDKInitializer.initialize(getApplicationContext());
        SDKInitializer.setCoordType(CoordType.BD09LL);
        x.Ext.init(this);
        x.Ext.setDebug(true);

    }

}
