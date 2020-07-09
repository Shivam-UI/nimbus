package com.lgt.nimbus.Adapters;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class TabAdapter extends FragmentPagerAdapter {
    private Context mContext;
    int tTabs;

    public TabAdapter(FragmentManager fm, Context context, int tTab) {
        super(fm);
        this.mContext = context;
        this.tTabs = tTab;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Toast.makeText(mContext, "0", Toast.LENGTH_SHORT).show();
                break;
            case 1:
                Toast.makeText(mContext, "1", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(mContext, "2", Toast.LENGTH_SHORT).show();
                break;
            default:
                return null;
        }
        return null;
    }

    @Override
    public int getCount() {
        return tTabs;
    }
}
