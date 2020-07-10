package com.lgt.nimbus.Fragment;


import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.lgt.nimbus.Activities.MainActivity;
import com.lgt.nimbus.Adapters.HomeAdapter;
import com.lgt.nimbus.Adapters.SlidingImage_Adapter;
import com.lgt.nimbus.Common.CommonCheck;
import com.lgt.nimbus.Model.DashItems;
import com.lgt.nimbus.R;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import nl.psdcompany.duonavigationdrawer.views.DuoDrawerLayout;
import nl.psdcompany.duonavigationdrawer.widgets.DuoDrawerToggle;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {
    DuoDrawerLayout navigationDrawer;
    private HomeAdapter mHomeAdapter;
    private RecyclerView rvDashboardItems;
    ArrayList<DashItems> mDashItems = new ArrayList<>();
    private int numberOfColumns = 2;
    int color[] = {R.drawable.ic_one, R.drawable.ic_two, R.drawable.ic_three, R.drawable.ic_four, R.drawable.girl_avatar, R.drawable.girl_avatar};
    Toolbar tb_toolbar;
    // setup menu
    private static ViewPager mPager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    private static final Integer[] IMAGES = {R.drawable.banner_three, R.drawable.banner_four, R.drawable.banner_three, R.drawable.banner_four};
    private ArrayList<Integer> ImagesArray = new ArrayList<Integer>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_dashboard_layout, container, false);
        rvDashboardItems = view.findViewById(R.id.rvDashboardItems);
        mPager = (ViewPager) view.findViewById(R.id.pager);
        rvDashboardItems.setLayoutManager(new GridLayoutManager(getActivity().getApplicationContext(), numberOfColumns));
        // add dash UI items
        for (int i = 0; i < color.length; i++) {
            DashItems dashItems = new DashItems(color[i], "Upgrade Bonus");
            mDashItems.add(dashItems);
        }
        mHomeAdapter = new HomeAdapter(mDashItems, getActivity().getApplicationContext());
        rvDashboardItems.setAdapter(mHomeAdapter);
        init();


        // return view
        return view;
    }

    private void init() {
        for (int i = 0; i < IMAGES.length; i++)
            ImagesArray.add(IMAGES[i]);
        mPager.setAdapter(new SlidingImage_Adapter(getActivity().getApplicationContext(), ImagesArray));
        final float density = getResources().getDisplayMetrics().density;
        NUM_PAGES = IMAGES.length;
        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 9000000, 15000);

        // Pager listener over indicator
    }
}
