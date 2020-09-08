package com.example.gadsleaderboard.api;

import com.example.gadsleaderboard.data.SkillLeader;

import java.util.List;

public class SkillIQ {
    private List<SkillLeader> skillIQResults;

    public SkillIQ(List<SkillLeader> skillIQResults) {
        this.skillIQResults = skillIQResults;
    }


    public int getSize() {
        return skillIQResults.size();
    }

    public List<SkillLeader> getSkillIQResults() {
        return skillIQResults;
    }

    public void setSkillIQResults(List<SkillLeader> skillIQResults) {
        this.skillIQResults = skillIQResults;
    }
}

