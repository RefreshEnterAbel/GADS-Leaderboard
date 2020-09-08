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
import com.example.gadsleaderboard.adapter.SkillIQLeaderRecyclerAdapter;
import com.example.gadsleaderboard.api.HeroAppClient;
import com.example.gadsleaderboard.api.ServiceGenerator;
import com.example.gadsleaderboard.data.SkillLeader;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class SkillLeadersFragment extends Fragment {
    private final String TAG = getClass().getSimpleName();
    private HeroAppClient mClient;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: run SkillLeadersFragment ");
        mClient = ServiceGenerator.createService(HeroAppClient.class);

        Call<List<SkillLeader>> call = mClient.skillIQLeader();
        call.enqueue(new Callback<List<SkillLeader>>() {

            @Override
            public void onResponse(Call<List<SkillLeader>> call, Response<List<SkillLeader>> response) {
                Log.d(TAG, "onResponse: ok good " +response);
                RecyclerView skillIQLeader = getView().findViewById(R.id.skill_leader_list);
                List<SkillLeader> skillLeaders = response.body();
                GridLayoutManager skillLeaderGridLayoutManager =  new GridLayoutManager(getContext(),1);
                skillIQLeader.setLayoutManager(skillLeaderGridLayoutManager);
                SkillIQLeaderRecyclerAdapter adapter = new SkillIQLeaderRecyclerAdapter(getContext(),skillLeaders);
                skillIQLeader.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<SkillLeader>> call, Throwable t) {
                Log.d(TAG, "onFailure: fail bad "+ t);
            }
        });
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_skill_leaders, container, false);

    }
}