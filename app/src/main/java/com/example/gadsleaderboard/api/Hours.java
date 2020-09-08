package com.example.gadsleaderboard.api;

import com.example.gadsleaderboard.data.HoursLeader;

import java.util.List;

public class Hours {
    private List<HoursLeader> hourisResults;

    public Hours(List<HoursLeader> results) {
        this.hourisResults = results;
    }

    public int getSize() {
        return hourisResults.size();
    }

    public List<HoursLeader> getHourisResults() {
        return hourisResults;
    }

    public void setHoursResults(List<HoursLeader> hoursResults) {
        this.hourisResults = hoursResults;
    }
}
