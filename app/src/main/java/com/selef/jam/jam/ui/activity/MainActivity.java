package com.selef.jam.jam.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.transition.Slide;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.selef.jam.jam.R;
import com.selef.jam.jam.TypeActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {


    @Bind(R.id.man_icon)
    SimpleDraweeView manIcon;
    @Bind(R.id.main_root)
    LinearLayout mainRoot;
    @Bind(R.id.main_start)
    TextView mainStart;
    @Bind(R.id.bottom_layout)
    LinearLayout bottomlayout;

    int saveWitdh;
    int saveHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupWindowAnimator();

    }

    @Override
    protected void onResume() {
        super.onResume();
        handler.sendEmptyMessageDelayed(0, 500);
        handler.sendEmptyMessageDelayed(1, 500);
    }

    private void changeLayoutSize() {
        TransitionManager.beginDelayedTransition(mainRoot);
        ViewGroup.LayoutParams lp = manIcon.getLayoutParams();
        lp.width = 450;
        lp.height = 450;
        manIcon.setLayoutParams(lp);
    }

    private void showLayoutAlph() {
        TransitionManager.beginDelayedTransition(mainRoot);
        float a = 0.0f;
        while (a < 1) {
            a += 0.1f;
            bottomlayout.setAlpha(a);
        }
    }

    private void setupWindowAnimator() {
        Slide slideTransition = new Slide();
        slideTransition.setSlideEdge(Gravity.LEFT);
        slideTransition.setDuration(getResources().getInteger(R.integer.anim_duration_long));
        getWindow().setReenterTransition(slideTransition);
        getWindow().setExitTransition(slideTransition);

    }

    @OnClick(R.id.main_start)
    public void onClick() {
        Intent intent = new Intent(this, TypeActivity.class);
        transitionTo(intent);
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    changeLayoutSize();
                    break;
                case 1:
                    showLayoutAlph();
                    break;
            }
        }
    };
}
