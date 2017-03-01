package com.example.indicateviewlib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-02-23.
 */
public class IndicateView extends LinearLayout implements ViewPager.OnPageChangeListener {
    private final static String TAG="IndicateView";
    private final static int DEFAULT_BLANK_SIZE=2;
    private final static int DEFAUTL_DOTR =10;

    private Context mcontext;

    private List<DotView> dotViewList = new ArrayList<>();
    private int widthDP;
    private int widthPX;

    private int dotR;
    private int selectColor;
    private int idleColor;
    private int blankSize;

    private int dotNum;
    private int isSelect;
    public IndicateView(Context context){
        super(context);
        mcontext = context;
    }

    public IndicateView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setAttrs(context,attrs);
        mcontext = context;
        addView();
    }

    private void setAttrs(Context context,AttributeSet attrs){
        int count;
        count = attrs.getAttributeCount();
        Log.d(TAG,"attrs count="+count);

        for(int i=0;i<count;i++)
            Log.d(TAG,"name="+attrs.getAttributeName(i)+",value="+attrs.getAttributeValue(i));

        TypedArray ta = context.obtainStyledAttributes(attrs,R.styleable .IndicateView);
        blankSize = ta.getInt(R.styleable.IndicateView_indicate_blankSize,DEFAULT_BLANK_SIZE);
        dotR = ta.getInt(R.styleable.IndicateView_indicate_dotSize,DEFAUTL_DOTR);
        selectColor = ta.getInt(R.styleable.IndicateView_select_color,Color.RED);
        idleColor = ta.getInt(R.styleable.IndicateView_idle_color,Color.GRAY);

  /*      TypedArray ta = context.obtainStyledAttributes(attrs,R.styleable.IndicateView);

        blankSize = ta.getInt(R.styleable.IndicateView_indicate_blankSize,DEFAULT_BLANK_SIZE);
        dotR = ta.getInt(R.styleable.IndicateView_indicate_dotSize,DEFAUTL_DOTR);
        selectColor = ta.getInt(R.styleable.IndicateView_select_color,Color.RED);
        idleColor = ta.getInt(R.styleable.IndicateView_idle_color,Color.GRAY);*/
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        widthPX = getWidth();

        //Log.d(TAG,"widthPX ="+ widthPX+",dp="+widthDP);
    }



    public void attachPager(ViewPager vp){
        vp.setOnPageChangeListener(this);
        dotNum = vp.getAdapter().getCount();
        addView();
    }

    private void addView(){
        removeAllViews();

        setGravity(Gravity.CENTER);
        for(int i=0;i<dotNum;i++) {

            DotView dotView = new DotView(mcontext);
            dotView.setR(dotR);
            if(isSelect == i)
                dotView.setColor(selectColor);
            else
                dotView.setColor(idleColor);

            LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT,
                    LayoutParams.WRAP_CONTENT);
            dotView.setLayoutParams(params);


            addView(dotView);

            View v = new View(mcontext);
            LayoutParams params2 = new LayoutParams(blankSize,
                    blankSize);
            v.setLayoutParams(params2);
            addView(v);

            dotViewList.add(dotView);
        }
    }


    public void setSelectDot(int i){

        isSelect = i%dotNum;
        addView();
    }

    private int calMaxDot(int lenth){
        int max = lenth/(dotR+
                blankSize);
        return max;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        setSelectDot(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
