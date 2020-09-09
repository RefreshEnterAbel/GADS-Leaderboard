package com.example.gadsleaderboard.api;

import com.example.gadsleaderboard.data.HoursLeader;
import com.example.gadsleaderboard.data.SkillLeader;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface HeroAppClient {

    @GET("/api/hours")
    Call<List<HoursLeader>> hoursLeader();

    @GET("/api/skilliq")
    Call<List<SkillLeader>> skillIQLeader();

    @POST("https://docs.google.com/forms/d/e/1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl\n" +
            "35cwZr2xyjIhaMAz8WChQ/formResponse")
    @FormUrlEncoded
    Call<Void> postProject(
            @Field("entry.1824927963")  String emailAddress,
            @Field("entry.1877115667")  String name,
            @Field("entry.2006916086")  String lastName,
            @Field("entry.284483984")  String linkToProject
    );

}
