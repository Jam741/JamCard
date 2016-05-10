package com.selef.jam.jam.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.transition.ChangeBounds;
import android.transition.Slide;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.selef.jam.jam.R;
import com.selef.jam.jam.model.ProjectModel;
import com.selef.jam.jam.ui.fragment.PowerFragment1;
import com.selef.jam.jam.ui.fragment.ProjectFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/5/11.
 */
public class ProjectActivity extends BaseActivity {

    @Bind(R.id.title)
    TextView title;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.power_content)
    FrameLayout powerContent;

    public List<ProjectModel> projectModels = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_power);
        ButterKnife.bind(this);
        setupToolbar();
        initData();
        title.setText("项目经验");
        setupWindowAnimations();
        setupLayout();
    }

    private void initData() {
        ProjectModel projectModel = new ProjectModel();
        projectModel.setName("世豪电子会员卡");
        projectModel.setDate("2014 /6 -- 2014 /12 ");
        projectModel.setDes("服务与世豪广场内部会员，项目以世豪广场室内\n" +
                "地图导航为基础，用户可以在世豪广场室内定位，\n" +
                "导航商店，绘制路径，以及停车位导航。");
        projectModel.setJob("工作责任：二维码功能开发 ；\n" +
                "调用系统相机功能SDK开发； \n" +
                "部分页面布局及与后台基础数据对接。");
        projectModels.add(projectModel);
        ProjectModel projectModel2 = new ProjectModel();
        projectModel2.setName("世豪电子会员卡");
        projectModel2.setDate("2014 /6 -- 2014 /12 ");
        projectModel2.setDes("服务与世豪广场内部会员，项目以世豪广走走走场室内\n" +
                "地图导航为基础，用户可以在世豪广场室内定位，\n" +
                "导航商店，绘制路径，以及停车位导航。");
        projectModel2.setJob("工作责任：二维码功能开发 ；\n" +
                "调用系统相机功能SDK开发； \n" +
                "部分页面布局及与后台基础数据对接。");
        projectModels.add(projectModel2);
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
        ProjectFragment sharedElementFragment1 = ProjectFragment.newInstance(projectModels.get(0));
        sharedElementFragment1.setReenterTransition(slideTransition);
        sharedElementFragment1.setExitTransition(slideTransition);
        sharedElementFragment1.setSharedElementEnterTransition(new ChangeBounds());

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.power_content, sharedElementFragment1)
                .commit();
    }
}
