package com.example.administrator.indicateview.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.indicateview.R;

/**
 * Created by Administrator on 2017-02-23.
 */
public class TestFragment extends Fragment {

    private final static String BUNDLE_INT="color";

    private int color;

    public static TestFragment getInstance(int color){
        TestFragment tf= new TestFragment();

        Bundle bundle = new Bundle();
        bundle.putInt(BUNDLE_INT,color);
        tf.setArguments(bundle);

        return tf;
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        color =getArguments().getInt(BUNDLE_INT,0);

        View v = inflater.inflate(R.layout.frame_layout_test,container,false);
        v.setBackgroundColor(color);
        return v;

        //return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
