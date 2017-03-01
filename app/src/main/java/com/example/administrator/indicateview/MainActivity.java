package com.example.administrator.indicateview;

import android.graphics.Color;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.administrator.indicateview.ui.TestFragment;
import com.example.indicateviewlib.IndicateView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.indicateView)
    IndicateView indicateView;

    @Bind(R.id.vp)
    ViewPager vp;

/*    @Bind(R.id.frame_content)
    FrameLayout frameLayout;*/

    private int value;
    private List<Fragment> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        list.add(TestFragment.getInstance(Color.RED));
        list.add(TestFragment.getInstance(Color.GREEN));
        list.add(TestFragment.getInstance(Color.YELLOW));
        vp.setAdapter(new mAdapter(getSupportFragmentManager(),list));

        indicateView.attachPager(vp);


    }

    @OnClick(R.id.add)
    void add(){

        indicateView.setSelectDot(value++);
    }

    public class mAdapter extends FragmentPagerAdapter {

        private List<Fragment> views;

        public mAdapter(FragmentManager supportFragmentManager,List<Fragment> views) {
            super(supportFragmentManager);
            this.views = views;
        }


        @Override
        public Fragment getItem(int position) {
            return views.get(position);
        }


        @Override
        public int getCount() {
            return views.size();
        }

    }
}
