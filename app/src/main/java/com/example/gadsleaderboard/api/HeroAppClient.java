package com.example.gadsleaderboard.api;

import com.example.gadsleaderboard.data.HoursLeader;
import com.example.gadsleaderboard.data.SkillLeader;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface HeroAppClient {

    @GET("/api/hours")
    Call<List<HoursLeader>> hoursLeader();

    @GET("/api/skilliq")
    Call<List<SkillLeader>> skillIQLeader();
}
