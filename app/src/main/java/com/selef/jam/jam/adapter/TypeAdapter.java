package com.selef.jam.jam.adapter;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.selef.jam.jam.R;
import com.selef.jam.jam.model.TypeModel;
import com.selef.jam.jam.ui.activity.PowerActivity;
import com.selef.jam.jam.ui.activity.ProjectActivity;
import com.selef.jam.jam.ui.activity.TransitionHelper;
import com.selef.jam.jam.ui.activity.WorkActivity;

import java.util.List;

/**
 * Created by root on 16-5-10.
 */
public class TypeAdapter extends RecyclerView.Adapter<MyVH> {

    List<TypeModel> typeModels;
    Activity activity;

    public TypeAdapter(List<TypeModel> typeModels, Activity activity) {
        this.typeModels = typeModels;
        this.activity = activity;
    }

    @Override
    public MyVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(activity).inflate(R.layout.item_type, parent, false);
        return new MyVH(itemView);
    }

    @Override
    public void onBindViewHolder(final MyVH holder, final int position) {
        TypeModel model = typeModels.get(position);
        holder.typeText.setText(model.getTypeName());
        holder.typeImg.setImageURI(Uri.parse(model.toString()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemCheneed(position, holder);
            }
        });
    }

    private void itemCheneed(int position, MyVH holder) {
        switch (position) {
            case 0:
                Intent intent = new Intent(activity, PowerActivity.class);
                Pair<View, String>[] pairs = TransitionHelper.createSafeTransitionParticipants(activity, false,
                        new Pair<>(holder.typeImg, activity.getResources().getString(R.string.main_icon)),
                        new Pair<>(holder.typeText, activity.getResources().getString(R.string.main_name)));
                transitionTo(intent, pairs, activity);
                break;
            case 1:
                Intent intent1 = new Intent(activity, WorkActivity.class);
                Pair<View, String>[] pairs1 = TransitionHelper.createSafeTransitionParticipants(activity, false,
                        new Pair<>(holder.typeImg, activity.getResources().getString(R.string.main_icon)),
                        new Pair<>(holder.typeText, activity.getResources().getString(R.string.main_name)));
                transitionTo(intent1, pairs1, activity);
                break;
            case 2:
                Intent intent2 = new Intent(activity, ProjectActivity.class);
                Pair<View, String>[] pairs2 = TransitionHelper.createSafeTransitionParticipants(activity, false,
                        new Pair<>(holder.typeImg, activity.getResources().getString(R.string.main_icon)),
                        new Pair<>(holder.typeText, activity.getResources().getString(R.string.main_name)));
                transitionTo(intent2, pairs2, activity);
                break;
            case 3:
                break;
        }
    }

    @Override
    public int getItemCount() {
        return typeModels.size();
    }


    void transitionTo(Intent i, Activity activity) {
        final Pair<View, String>[] pairs = TransitionHelper.createSafeTransitionParticipants(activity, true);
        ActivityOptionsCompat transitionActivityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, pairs);
        activity.startActivity(i, transitionActivityOptions.toBundle());
    }

    void transitionTo(Intent i, Pair[] pairs, Activity activity) {
        ActivityOptionsCompat transitionActivityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, pairs);
        activity.startActivity(i, transitionActivityOptions.toBundle());
    }
}


class MyVH extends RecyclerView.ViewHolder {

    TextView typeText;
    SimpleDraweeView typeImg;
    View itemView;

    public MyVH(View itemView) {
        super(itemView);
        typeImg = (SimpleDraweeView) itemView.findViewById(R.id.item_type_img);
        typeText = (TextView) itemView.findViewById(R.id.item_type_text);
        this.itemView = itemView;
    }
}