package com.example.bahadir.grafikproje;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.astuetz.PagerSlidingTabStrip;

public class MainActivity extends FragmentActivity {
    Bitmap bitmap;
    String isim;
    Location x = new Location("ababa");
    Location y = new Location("caccaca");
    protected void onCreate(Bundle bambam){
        super.onCreate(bambam);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        tanimlar();
        nickAl();
        // yerolustur();
        //mesafeyiBul(x, y);
    }

    public void tanimlar(){
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new SampleFragmentPagerAdapter(getSupportFragmentManager()));
        PagerSlidingTabStrip tabsStrip = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        tabsStrip.setViewPager(viewPager);
    }
    public void nickAl(){
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.setTitle("nick ver");
        dialog.setContentView(R.layout.customdialog);
        dialog.getWindow().setDimAmount(0.7f);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
        final EditText etv1 = (EditText) dialog.findViewById(R.id.editText);
        Button onaylaButonu = (Button) dialog.findViewById(R.id.button5);
        onaylaButonu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String nick = etv1.getText().toString();
                Log.i("tago", "nickin :" + nick);
                dialog.cancel();
            }
        });
    }
    public void mesafeyiBul(Location a , Location b){
        float distance = a.distanceTo(b);
        Log.i("tago", "" + distance);

    }
    public void yerolustur(){
        x.setLatitude(39.8998454);
        x.setLongitude(32.7949772);
        y.setLatitude(39.8973333);
        y.setLongitude(32.7924444);
    }

}
