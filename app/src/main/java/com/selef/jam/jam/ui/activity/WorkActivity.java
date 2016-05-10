package com.selef.jam.jam.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.transition.ChangeBounds;
import android.transition.ChangeClipBounds;
import android.transition.Slide;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.selef.jam.jam.R;
import com.selef.jam.jam.ui.fragment.PowerFragment1;
import com.selef.jam.jam.ui.fragment.WorkFragment1;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/5/11.
 */
public class WorkActivity extends BaseActivity {

    @Bind(R.id.title)
    TextView title;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.power_content)
    FrameLayout powerContent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_power);
        ButterKnife.bind(this);
        title.setText("工作经历");
        setupToolbar();
        setupWindowAnimations();
        setupLayout();

    }

    private void setupWindowAnimations() {
        // We are not interested in defining a new Enter Transition. Instead we change default transition duration
        getWindow().getEnterTransition().setDuration(getResources().getInteger(R.integer.anim_duration_long));
    }

    private void setupLayout() {
        // Transition for fragment1
        ChangeClipBounds slideTransition = new ChangeClipBounds();
        slideTransition.setDuration(getResources().getInteger(R.integer.anim_duration_long));
        // Create fragment and define some of it transitions
        WorkFragment1 sharedElementFragment1 = WorkFragment1.newInstance();
        sharedElementFragment1.setReenterTransition(slideTransition);
        sharedElementFragment1.setExitTransition(slideTransition);
        sharedElementFragment1.setSharedElementEnterTransition(new ChangeBounds());

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.power_content, sharedElementFragment1)
                .commit();
    }
}
