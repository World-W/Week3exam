package com.example.wangshjie20200309.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;

import com.example.wangshjie20200309.R;

/**
 *王世杰
 * 202200309
 */
public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ImageView iv2 = findViewById(R.id.iv2);
        Glide.with(this).load(R.mipmap.dog).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(iv2);
    }
}
