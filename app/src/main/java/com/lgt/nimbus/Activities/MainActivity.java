package com.lgt.nimbus.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lgt.nimbus.Adapters.HomeAdapter;
import com.lgt.nimbus.Common.CommonCheck;
import com.lgt.nimbus.Model.DashItems;
import com.lgt.nimbus.R;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import nl.psdcompany.duonavigationdrawer.views.DuoDrawerLayout;

public class MainActivity extends AppCompatActivity {
    private ImageView ivBackFullDescription, ivHamburger, ivNotification;
    private TextView tvHeaderName, tvHeaderEmail, tvToolbar;
    private CircleImageView civProfile;
    private LinearLayout navHeader;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    ExpandableListView expandableListView;
    // setup menu
    DuoDrawerLayout sNavigationDrawer;
    private HomeAdapter mHomeAdapter;
    private RecyclerView rvDashboardItems;
    ArrayList<DashItems> mDashItems = new ArrayList<>();
    private int numberOfColumns = 2;
    int color[] = {R.color.one,R.color.two,R.color.three,R.color.four,R.color.five,R.color.six,R.color.seven,R.color.edtColor};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // change status bar color
        CommonCheck.changeStatusBarColor("#288153", this);
        // global variable
        sharedPreferences = MainActivity.this.getSharedPreferences("USER_INFO", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        // init
        expandableListView = findViewById(R.id.expanded_menu);
        navHeader = findViewById(R.id.navHeader);
        ivBackFullDescription = findViewById(R.id.ivBackFullDescription);
        ivHamburger = findViewById(R.id.ivHamburger);
        rvDashboardItems = findViewById(R.id.rvDashboardItems);
        rvDashboardItems.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
        ivNotification = findViewById(R.id.ivNotification);
        tvHeaderName = findViewById(R.id.tvHeaderName);
        civProfile = findViewById(R.id.civProfile);
        sNavigationDrawer = findViewById(R.id.navigationDrawer);
        //then add them to navigation drawer\

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
    }
}