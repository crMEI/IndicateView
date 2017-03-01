package com.example.indicateviewlib;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017-02-22.
 */
public class DotView extends View {

    public final static int DOTVIEW_BULE =0;
    public final static int DOTVIEW_REA=1;
    public final static int DOTVIEW_GREEN=2;
    public final static int DOTVIEW_WHITE=3;

    public final static int SIZE_DEFUALT =10;
    public final static int SIZE_MAX =30;
    public final static int SIZE_MIN=5;

    private int dotColor;
    private int sizeR;


    public DotView(Context context) {
        super(context);
        setView();
    }

    public DotView(Context context, AttributeSet attrs){
        super(context,attrs);
        setView();
    }


    private void setView(){
        setR(20);
        setColor(DOTVIEW_BULE);
    }

    public void setR(int r){
        if(r >SIZE_MAX)
            r = SIZE_MAX;
        if(r < SIZE_MIN)
            r = SIZE_MIN;
        sizeR = r;
    }

    public void setColor(int c){
        dotColor =c;
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(sizeR*2,sizeR*2);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setColor(dotColor);

        int centerX = sizeR;
        int centerY = sizeR;

        canvas.drawCircle(centerX,centerY,sizeR,paint);
    }
}
