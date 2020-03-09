package com.example.wangshjie20200309.base;

import android.app.Application;
import android.content.Context;

/**
 *王世杰
 * 202200309
 */
public class App extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context=this;
    }

    public static Context getContext() {
        return context;
    }
}
