package com.selef.jam.jam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.TransitionInflater;
import android.view.Gravity;

import com.selef.jam.jam.R;
import com.selef.jam.jam.adapter.TypeAdapter;
import com.selef.jam.jam.model.TypeModel;
import com.selef.jam.jam.ui.activity.BaseActivity;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by 99165 on 2016/5/10.
 */
public class TypeActivity extends BaseActivity {

    private RecyclerView typeRecyclerView;
    private TypeAdapter mAdapter;
    private List<TypeModel> typeModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tyoe);
        typeRecyclerView = (RecyclerView) findViewById(R.id.type_recyclerView);
        setAnimator();
        typeModels = initData();
        intView();
        setupToolbar();
    }

    private void intView() {
        mAdapter = new TypeAdapter(typeModels, content);
        typeRecyclerView.setLayoutManager(new LinearLayoutManager(content));
        typeRecyclerView.setHasFixedSize(true);
        typeRecyclerView.setAdapter(mAdapter);
    }

    private List<TypeModel> initData() {
        List<TypeModel> typeModels = new ArrayList<>();
        typeModels.add(createTypeModel("技术能力", "http://cdn-img.easyicon.net/png/11623/1162374.gif"));
        typeModels.add(createTypeModel("工作经历", "http://cdn-img.easyicon.net/png/11907/1190732.gif"));
        typeModels.add(createTypeModel("项目经验", "http://cdn-img.easyicon.net/png/11784/1178446.gif"));
        typeModels.add(createTypeModel("爱好", "http://cdn-img.easyicon.net/png/11994/1199475.gif"));
        return typeModels;
    }

    private TypeModel createTypeModel(String name, String img) {
        TypeModel typeModel = new TypeModel();
        typeModel.setTypeName(name);
        typeModel.setTypeImg(img);
        return typeModel;
    }

    private void setAnimator() {
        Slide slideTransition = new Slide();
        slideTransition.setSlideEdge(Gravity.LEFT);
        slideTransition.setDuration(getResources().getInteger(R.integer.anim_duration_long));
        getWindow().setReenterTransition(slideTransition);
        getWindow().setExitTransition(slideTransition);
    }


}
