package com.example.newswave;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class pagerAdapter extends FragmentPagerAdapter {
    public pagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new HomeFrag();
        } else if (position == 1) {
            return new SportsFrag();
        } else if (position == 2) {
            return new HealthFrag();
        } else if (position == 3) {
            return new ScienceFrag();
        } else if (position == 4) {
            return new EntertainmentFrag();
        } else
            return new TechnnologyFrag();
    }

    @Override
    public int getCount() {
        return 6;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return "Home";
        } else if (position == 1) {
            return "Sports";
        } else if (position == 2) {
            return "Health";
        } else if (position == 3) {
            return "Science";
        } else if (position == 4) {
            return "Entertainment";
        } else
            return "Technology";
    }
}
