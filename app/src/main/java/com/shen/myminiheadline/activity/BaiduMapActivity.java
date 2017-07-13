package com.shen.myminiheadline.activity;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.map.TextOptions;
import com.baidu.mapapi.model.LatLng;
import com.shen.myminiheadline.R;

import java.util.ArrayList;

public class BaiduMapActivity extends AppCompatActivity {
    MapView mMapView = null;
    private BaiduMap mBaiduMap;
    private BitmapDescriptor bitmap;
    private Marker mMarkerA;
    private Marker mMarkerB;
    private Marker mMarkerC;
    private Marker mMarkerD;
    BitmapDescriptor bdA = BitmapDescriptorFactory
            .fromResource(R.drawable.icon_marka);
    BitmapDescriptor bdB = BitmapDescriptorFactory
            .fromResource(R.drawable.icon_markb);
    BitmapDescriptor bdC = BitmapDescriptorFactory
            .fromResource(R.drawable.icon_markc);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //在使用SDK各组件之前初始化context信息，传入ApplicationContext
        //注意该方法要再setContentView方法之前实现

        SDKInitializer.initialize(getApplicationContext());
        setContentView(R.layout.activity_baidu_map);
        mMapView = (MapView) findViewById(R.id.bmapView);
        mBaiduMap = mMapView.getMap();

        //设置比例尺是否显示
        mMapView.showScaleControl(true);

        //设置缩放控件是否显示
        mMapView.showZoomControls(true);

        LatLng  centerPoint = new LatLng(30.287348,120.07581);
        MapStatus mapStatus = new MapStatus.Builder().target(centerPoint).zoom(18).build();
        MapStatusUpdate mapStatusUpdate = MapStatusUpdateFactory.newMapStatus(mapStatus);
        mBaiduMap.setMapStatus(mapStatusUpdate);





        //定义Maker坐标点
        LatLng point = new LatLng(30.287348,120.07581);
        //构建Marker图标
         bitmap = BitmapDescriptorFactory
                .fromResource(R.drawable.icon_gcoding);


        MarkerOptions options = new MarkerOptions()
                .position(point)  //设置marker的位置
                .icon(bitmap)  //设置marker图标
                .zIndex(9)  //设置marker所在层级
                .draggable(true);  //设置手势拖拽

        options.animateType(MarkerOptions.MarkerAnimateType.drop);
        //将marker添加到地图上
       Marker marker = (Marker) mBaiduMap.addOverlay(options);

        //调用BaiduMap对象的setOnMarkerDragListener方法设置marker拖拽的监听
        mBaiduMap.setOnMarkerDragListener(new BaiduMap.OnMarkerDragListener() {
            public void onMarkerDrag(Marker marker) {
                //拖拽中
            }
            public void onMarkerDragEnd(Marker marker) {
                //拖拽结束
            }
            public void onMarkerDragStart(Marker marker) {
                //开始拖拽
            }
        });


        // 通过marker的icons设置一组图片，再通过period设置多少帧刷新一次图片资源
        ArrayList<BitmapDescriptor> giflist = new ArrayList<BitmapDescriptor>();
        giflist.add(bdA);
        giflist.add(bdB);
        giflist.add(bdC);
        OverlayOptions ooD = new MarkerOptions().position(point).icons(giflist)
                .zIndex(0).period(10);
        mMarkerD = (Marker) (mBaiduMap.addOverlay(ooD));



        //定义文字所显示的坐标点
        LatLng llText = new LatLng(30.287348,120.07581);
        //构建文字Option对象，用于在地图上添加文字
        OverlayOptions textOption = new TextOptions()
                .bgColor(0xAAFFFF00)
                .fontSize(50)
                .fontColor(0xFFFF00FF)
                .text("我在这儿~")
                .rotate(30)
                .position(llText);
        //在地图上添加该文字对象并显示
        mBaiduMap.addOverlay(textOption);








    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        mMapView.onDestroy();
        bitmap.recycle();
        bdA.recycle();
        bdB.recycle();
        bdC.recycle();

    }
    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mMapView.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mMapView.onPause();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0,101,1,"普通地图");
        menu.add(0,102,1,"卫星地图");
        menu.add(0,103,1,"空白地图");
        menu.add(0,104,1,"开启实时交通地图");
        menu.add(0,105,1,"关闭实时交通地图");
        menu.add(0,106,1,"开启热力图");
        menu.add(0,107,1,"关闭热力图");

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case 101:
                mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
                break;
            case 102:
                mBaiduMap.setMapType(BaiduMap.MAP_TYPE_SATELLITE);
                break;
            case 103:
                mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NONE);
                break;
            case 104:
                mBaiduMap.setTrafficEnabled(true);
                break;
            case 105:
                mBaiduMap.setTrafficEnabled(false);
                break;
            case 106:
                mBaiduMap.setBaiduHeatMapEnabled(true);
                break;
            case 107:
                mBaiduMap.setBaiduHeatMapEnabled(false);
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
