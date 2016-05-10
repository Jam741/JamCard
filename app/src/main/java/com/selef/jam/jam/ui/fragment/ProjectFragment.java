package com.selef.jam.jam.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.transition.ChangeBounds;
import android.transition.Explode;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.selef.jam.jam.R;
import com.selef.jam.jam.model.ProjectModel;
import com.selef.jam.jam.ui.activity.ProjectActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/5/11.
 */
public class ProjectFragment extends Fragment {

    @Bind(R.id.name)
    TextView name;
    @Bind(R.id.date)
    TextView date;
    @Bind(R.id.des)
    TextView des;
    @Bind(R.id.jop)
    TextView jop;
    @Bind(R.id.nextBtn)
    Button nextBtn;

    public static final String INDEX = "index";

    private static int index;
    private ProjectModel projectModel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_project, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private Transition buildEnterTransition() {
        Explode enterTransition = new Explode();
        enterTransition.setDuration(getResources().getInteger(R.integer.anim_duration_long));
        return enterTransition;
    }

    private void setupWindowAnimations() {
        Transition transition;

        if (index % 2 == 0) {
            transition = buildEnterTransition();
        } else {
            transition = TransitionInflater.from(getContext()).inflateTransition(R.transition.explode);
        }
        setEnterTransition(transition);
    }

    private void initView() {
        Bundle bundle = getArguments();
        index = bundle.getInt(INDEX, 0);
        projectModel = (ProjectModel) bundle.getSerializable("model");
        Log.d("INDEX", index + "---------------");
        name.setText(projectModel.getName());
        date.setText(projectModel.getDate());
        des.setText(projectModel.getDes());
        jop.setText(projectModel.getJob());
    }


    public static ProjectFragment newInstance(ProjectModel projectModel) {
        ProjectFragment projectFragment = new ProjectFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(INDEX, index + 1);
        bundle.putSerializable("model", projectModel);
        projectFragment.setArguments(bundle);
        return projectFragment;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick(R.id.nextBtn)
    public void onClick() {
        if (((ProjectActivity) getActivity()).projectModels.size() > index) {
            addNextFragment(name, date, des, jop, true);
        } else {
            getActivity().finishAfterTransition();
        }
    }

    public int getIndex() {
        return index;
    }


    private void addNextFragment(TextView name, TextView date, TextView des, TextView job, boolean overlap) {
        ProjectFragment sharedElementFragment2 = ProjectFragment.newInstance(((ProjectActivity) getActivity()).projectModels.get(index));

        Slide slideTransition = new Slide(Gravity.RIGHT);
        slideTransition.setDuration(getResources().getInteger(R.integer.anim_duration_medium));

        Explode changeBoundsTransition = new Explode();
        changeBoundsTransition.setDuration(getResources().getInteger(R.integer.anim_duration_medium));

        sharedElementFragment2.setEnterTransition(slideTransition);
        sharedElementFragment2.setAllowEnterTransitionOverlap(overlap);
        sharedElementFragment2.setAllowReturnTransitionOverlap(overlap);
        sharedElementFragment2.setSharedElementEnterTransition(changeBoundsTransition);

        getFragmentManager().beginTransaction()
                .replace(R.id.power_content, sharedElementFragment2)
                .addToBackStack(null)
                .addSharedElement(name, getString(R.string.pj_name))
                .addSharedElement(date, getString(R.string.pj_date))
                .addSharedElement(des, getString(R.string.pj_des))
                .addSharedElement(job, getString(R.string.pj_job))
                .commit();
    }
}
