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
import com.example.gadsleaderboard.data.SkillLeader;

import java.util.ArrayList;
import java.util.List;

public class SkillIQLeaderRecyclerAdapter extends RecyclerView.Adapter<SkillIQLeaderRecyclerAdapter.ViewHolder> {
    private final Context mContext;
    private final List<SkillLeader> mSkillIQLeader;
    private final LayoutInflater mLayoutInflater;

    public SkillIQLeaderRecyclerAdapter(Context context, List<SkillLeader> mSkillIQLeader) {
        this.mContext = context;
        this.mSkillIQLeader = mSkillIQLeader;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public SkillIQLeaderRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.item_skill_iq_leader,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SkillIQLeaderRecyclerAdapter.ViewHolder holder, int position) {
        SkillLeader skillLeader = mSkillIQLeader.get(position);
        holder.mName.setText(skillLeader.getName());
        holder.mInformation.setText(skillLeader.getScore() + " Skill IQ Score, " +skillLeader.getCountry());
        holder.mBadge.setImageResource(R.drawable.skill_iq_trimmed);
    }

    @Override
    public int getItemCount() {
        return mSkillIQLeader.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
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
