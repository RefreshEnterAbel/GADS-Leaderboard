package com.example.gadsleaderboard.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gadsleaderboard.R;
import com.example.gadsleaderboard.adapter.HoursLeaderRecyclerAdapter;
import com.example.gadsleaderboard.adapter.SkillIQLeaderRecyclerAdapter;
import com.example.gadsleaderboard.api.HeroAppClient;
import com.example.gadsleaderboard.api.ServiceGenerator;
import com.example.gadsleaderboard.data.HoursLeader;
import com.example.gadsleaderboard.data.SkillLeader;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LeadingLeadersFragment extends Fragment {

    public final String TAG = getClass().getSimpleName();
    private HeroAppClient mClient;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: run LeadingLeadersFragment ");
        mClient = ServiceGenerator.createService(HeroAppClient.class);

        Call<List<HoursLeader>> call = mClient.hoursLeader();
        call.enqueue(new Callback<List<HoursLeader>>() {

            @Override
            public void onResponse(Call<List<HoursLeader>> call, Response<List<HoursLeader>> response) {
                Log.d(TAG, "onResponse: ok good " +response.body());
                RecyclerView learnerLeader = getView().findViewById(R.id.learner_leader_list);
                List<HoursLeader> hoursLeaders = response.body();
                GridLayoutManager learnerLeaderGridLayoutManager =  new GridLayoutManager(getContext(),1);
                learnerLeader.setLayoutManager(learnerLeaderGridLayoutManager);
                HoursLeaderRecyclerAdapter adapter = new HoursLeaderRecyclerAdapter(getContext(),hoursLeaders);
                learnerLeader.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<HoursLeader>> call, Throwable t) {
                Log.d(TAG, "onFailure: fail bad "+ t);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_learing_leaders, container, false);
    }
}