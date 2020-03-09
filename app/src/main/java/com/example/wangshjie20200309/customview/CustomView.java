package com.example.wangshjie20200309.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 *王世杰
 * 202200309
 */
public class CustomView extends View {
    Paint mPaint;
    int [] data = {100,350,400,600,100,200,300,100};
    public CustomView(Context context) {
        super(context);
        init();
    }

    public CustomView(Context context,  AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public void init(){
        mPaint = new Paint();
        mPaint.setColor(Color.YELLOW);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int staX = 0;
        int staY = 200;
        for (int i =0;i<data.length;i++){
            canvas.drawLine(staX,staY,staX+100,data[i],mPaint);
            staX = staX+100;
            staY=data[i];
        }
    }
}
