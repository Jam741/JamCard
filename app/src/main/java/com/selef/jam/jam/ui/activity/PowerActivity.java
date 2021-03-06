package com.selef.jam.jam.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.transition.ChangeBounds;
import android.transition.Slide;
import android.view.Gravity;

import com.selef.jam.jam.R;
import com.selef.jam.jam.ui.fragment.PowerFragment1;

/**
 * Created by root on 16-5-10.
 */
public class PowerActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_power);
        setupWindowAnimations();
        setupToolbar();
        setupLayout();
    }


    private void setupWindowAnimations() {
        // We are not interested in defining a new Enter Transition. Instead we change default transition duration
        getWindow().getEnterTransition().setDuration(getResources().getInteger(R.integer.anim_duration_long));
    }

    private void setupLayout() {
        // Transition for fragment1
        Slide slideTransition = new Slide(Gravity.LEFT);
        slideTransition.setDuration(getResources().getInteger(R.integer.anim_duration_long));
        // Create fragment and define some of it transitions
        PowerFragment1 sharedElementFragment1 = PowerFragment1.newInstance();
        sharedElementFragment1.setReenterTransition(slideTransition);
        sharedElementFragment1.setExitTransition(slideTransition);
        sharedElementFragment1.setSharedElementEnterTransition(new ChangeBounds());

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.power_content, sharedElementFragment1)
                .commit();
    }
}
