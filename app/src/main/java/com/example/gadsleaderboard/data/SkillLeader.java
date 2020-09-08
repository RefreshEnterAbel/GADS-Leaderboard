package com.example.gadsleaderboard.data;

public class SkillLeader {
    private String name;
    private int score;
    private String country;
    private String badgeUrl;

    public SkillLeader(String name, int hours, String country, String badgeUrl) {
        this.name = name;
        this.score = hours;
        this.country = country;
        this.badgeUrl = badgeUrl;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBadgeUrl() {
        return badgeUrl;
    }
}
