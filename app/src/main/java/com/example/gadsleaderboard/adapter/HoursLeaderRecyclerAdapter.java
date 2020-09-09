package com.example.gadsleaderboard.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gadsleaderboard.R;
import com.example.gadsleaderboard.data.HoursLeader;
import com.example.gadsleaderboard.data.SkillLeader;

import java.util.List;

public class HoursLeaderRecyclerAdapter extends RecyclerView.Adapter<HoursLeaderRecyclerAdapter.ViewHolder> {
    private final Context mContext;
    private final List<HoursLeader> mHoursLeaders;
    private final LayoutInflater mLayoutInflater;

    public HoursLeaderRecyclerAdapter(Context context, List<HoursLeader> hoursLeaders) {
        this.mContext = context;
        this.mHoursLeaders = hoursLeaders;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public HoursLeaderRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.item_houres_leader,parent,false);
        return new HoursLeaderRecyclerAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull HoursLeaderRecyclerAdapter.ViewHolder holder, int position) {
        HoursLeader hoursLeader = mHoursLeaders.get(position);
        holder.mName.setText(hoursLeader.getName());
        holder.mInformation.setText(hoursLeader.getHours() + " Learing Hours, " +hoursLeader.getCountry());
        holder.mBadge.setImageResource(R.drawable.top_learner);
    }

    @Override
    public int getItemCount() {
        return mHoursLeaders.size();
    }

    public static class ViewHolder  extends RecyclerView.ViewHolder{
        public final TextView mName;
        public final TextView mInformation;
        public final ImageView mBadge;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mName = itemView.findViewById(R.id.name);
            mInformation = itemView.findViewById(R.id.information);
            mBadge = itemView.findViewById(R.id.badge_image);
        }
    }
}
