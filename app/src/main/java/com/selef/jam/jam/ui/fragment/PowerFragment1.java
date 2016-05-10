package com.selef.jam.jam.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.transition.ChangeBounds;
import android.transition.Slide;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.selef.jam.jam.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/5/11.
 */
public class PowerFragment1 extends Fragment {

    @Bind(R.id.center1)
    TextView center1;
    @Bind(R.id.java)
    TextView java;
    @Bind(R.id.library)
    TextView library;
    @Bind(R.id.design)
    TextView design;
    @Bind(R.id.net)
    TextView net;
    @Bind(R.id.animator)
    TextView animator;
    @Bind(R.id.model)
    TextView model;
    @Bind(R.id.uitest)
    TextView uitest;
    @Bind(R.id.ui)
    TextView ui;
    @Bind(R.id.nextButton)
    Button nextButton;

    public static PowerFragment1 newInstance() {
        return new PowerFragment1();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_power1, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick(R.id.nextButton)
    public void onClick() {
        getActivity().finishAfterTransition();
    }


}
