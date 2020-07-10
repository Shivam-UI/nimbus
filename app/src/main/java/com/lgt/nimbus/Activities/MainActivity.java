package com.lgt.nimbus.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lgt.nimbus.Adapters.HomeAdapter;
import com.lgt.nimbus.Adapters.SlidingImage_Adapter;
import com.lgt.nimbus.Common.CommonCheck;
import com.lgt.nimbus.Model.DashItems;
import com.lgt.nimbus.R;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import de.hdodenhof.circleimageview.CircleImageView;
import nl.psdcompany.duonavigationdrawer.views.DuoDrawerLayout;
import nl.psdcompany.duonavigationdrawer.widgets.DuoDrawerToggle;

public class MainActivity extends AppCompatActivity {
    private ImageView ivBackFullDescription, ivHamburger, ivNotification;
    private TextView tvHeaderName, tvHeaderEmail, tvToolbar;
    private CircleImageView civProfile;
    private RelativeLayout navHeader;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    ExpandableListView expandableListView;
    // setup menu
    DuoDrawerLayout navigationDrawer;
    private HomeAdapter mHomeAdapter;
    private RecyclerView rvDashboardItems;
    ArrayList<DashItems> mDashItems = new ArrayList<>();
    private int numberOfColumns = 2;
    int color[] = {R.drawable.ic_one,R.drawable.ic_two,R.drawable.ic_three,R.drawable.ic_four,R.drawable.girl_avatar,R.drawable.girl_avatar};
    private RecyclerView.ViewHolder mViewHolder;
    boolean clickAgainToExit = false;
    Toolbar tb_toolbar;


    private static ViewPager mPager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    private static final Integer[] IMAGES= {R.drawable.banner_three,R.drawable.banner_four,R.drawable.banner_three,R.drawable.banner_four};
    private ArrayList<Integer> ImagesArray = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // change status bar color
        CommonCheck.changeStatusBarColor("#e7e8ef", this);
        // global variable
        sharedPreferences = MainActivity.this.getSharedPreferences("USER_INFO", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        // init
        tb_toolbar = findViewById(R.id.tb_toolbar);
        expandableListView = findViewById(R.id.expanded_menu);
        navHeader = findViewById(R.id.navHeader);
        ivBackFullDescription = findViewById(R.id.ivBackFullDescription);
        ivHamburger = findViewById(R.id.ivHamburger);
        rvDashboardItems = findViewById(R.id.rvDashboardItems);
        rvDashboardItems.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
        ivNotification = findViewById(R.id.ivNotification);
        tvHeaderName = findViewById(R.id.tvHeaderName);
        civProfile = findViewById(R.id.civProfile);
        navigationDrawer = findViewById(R.id.navigationDrawer);
        //then add them to navigation drawer\
        DuoDrawerToggle duoDrawerToggle = new DuoDrawerToggle(this
                ,navigationDrawer
                ,tb_toolbar
                ,R.string.navigation_drawer_close
                ,R.string.navigation_drawer_open
        );
        navigationDrawer.setDrawerListener(duoDrawerToggle);
        duoDrawerToggle.syncState();
        for (int i = 0; i < color.length;i++){
            DashItems dashItems = new DashItems(color[i],i+" Free Score");
            mDashItems.add(dashItems);
        }
        mHomeAdapter = new HomeAdapter(mDashItems, MainActivity.this);
        rvDashboardItems.setAdapter(mHomeAdapter);
        // tab setup
        ivHamburger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        init();
    }

    private void init() {
        for(int i=0;i<IMAGES.length;i++)
            ImagesArray.add(IMAGES[i]);
        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(new SlidingImage_Adapter(MainActivity.this,ImagesArray));
        final float density = getResources().getDisplayMetrics().density;
        NUM_PAGES =IMAGES.length;
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
        }, 3500, 15000);

        // Pager listener over indicator
    }
}