package com.selef.jam.jam.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.selef.jam.jam.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/5/11.
 */
public class WorkFragment1 extends Fragment {

    @Bind(R.id.exitBtn)
    Button exitBtn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_work1, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    public static WorkFragment1 newInstance() {
        return new WorkFragment1();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick(R.id.exitBtn)
    public void onClick() {
        getActivity().finishAfterTransition();
    }


}
