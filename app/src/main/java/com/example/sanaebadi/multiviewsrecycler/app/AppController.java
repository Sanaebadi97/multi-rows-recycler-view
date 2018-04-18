package com.example.sanaebadi.multiviewsrecycler.app;


import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

import com.example.sanaebadi.multiviewsrecycler.R;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class AppController extends Application {

  @SuppressLint("StaticFieldLeak")
  public static Context context;

  @Override
  public void onCreate() {
    super.onCreate();
    context = getApplicationContext();

    CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
      .setDefaultFontPath("iransans.ttf")
      .setFontAttrId(R.attr.fontPath)
      .build()
    );
  }
}
