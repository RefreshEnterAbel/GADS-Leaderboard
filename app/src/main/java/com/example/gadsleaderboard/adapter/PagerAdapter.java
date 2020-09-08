package com.example.gadsleaderboard.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.gadsleaderboard.ui.LeadingLeadersFragment;
import com.example.gadsleaderboard.ui.SkillLeadersFragment;

public class PagerAdapter extends FragmentPagerAdapter {
    private int numberOfTabs;
    public PagerAdapter(@NonNull FragmentManager fm, int numberOfTabs) {
        super(fm);
        this.numberOfTabs = numberOfTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new LeadingLeadersFragment();
            case 1:
                return new SkillLeadersFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}
