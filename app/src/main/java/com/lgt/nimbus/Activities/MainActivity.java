package com.lgt.nimbus.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuAdapter;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.lgt.nimbus.Adapters.TabAdapter;
import com.lgt.nimbus.Common.CommonCheck;
import com.lgt.nimbus.R;
import com.lgt.nimbus.menu.ExpandableListAdapter;
import com.lgt.nimbus.menu.MenuChildModel;
import com.lgt.nimbus.menu.MenuModel;
import com.shrikanthravi.customnavigationdrawer2.widget.SNavigationDrawer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView ivBackFullDescription, ivHamburger, ivNotification;
    private TextView tvHeaderName, tvHeaderEmail, tvToolbar;
    private CircleImageView civProfile;
    private LinearLayout navHeader;
    private DrawerLayout drawer;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    ExpandableListAdapter expandableListAdapter;
    ExpandableListView expandableListView;
    List<MenuModel> headerList = new ArrayList<>();
    HashMap<MenuModel, List<MenuChildModel>> childList = new HashMap<>();
    // setup menu
    //Global Declaration
    SNavigationDrawer sNavigationDrawer;
    Class fragmentClass;
    public static Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // change status bar color
        CommonCheck.changeStatusBarColor("#FFFFFF", this);
        // global variable
        sharedPreferences = MainActivity.this.getSharedPreferences("USER_INFO", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        // init
        expandableListView = findViewById(R.id.expanded_menu);
        drawer = findViewById(R.id.drawer_layout);
        navHeader = findViewById(R.id.navHeader);
        ivBackFullDescription = findViewById(R.id.ivBackFullDescription);
        ivHamburger = findViewById(R.id.ivHamburger);
        ivNotification = findViewById(R.id.ivNotification);
        tvHeaderName = findViewById(R.id.tvHeaderName);
        civProfile = findViewById(R.id.civProfile);
        sNavigationDrawer = findViewById(R.id.navigationDrawer);
        List<com.lgt.nimbus.Model.MenuItem> menuItems = new ArrayList<>();
        // add menu items
        menuItems.add(new com.lgt.nimbus.Model.MenuItem("News",R.drawable.news_bg));
        menuItems.add(new com.lgt.nimbus.Model.MenuItem("News",R.drawable.news_bg));
        menuItems.add(new com.lgt.nimbus.Model.MenuItem("News",R.drawable.news_bg));
        menuItems.add(new com.lgt.nimbus.Model.MenuItem("News",R.drawable.news_bg));
        menuItems.add(new com.lgt.nimbus.Model.MenuItem("News",R.drawable.news_bg));
        //then add them to navigation drawer

        // tab setup
        ivHamburger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.openDrawer(Gravity.LEFT);
            }
        });
        SetupDrawer();
    }

    private void SetupDrawer() {

    }

//    private void prepareMenuData() {
//
//        MenuModel menuModel = new MenuModel("Home", true, false); //Menu of Android Tutorial. No sub menus
//        headerList.add(menuModel);
//
//        List<MenuChildModel> childModelsList = new ArrayList<>();
//        MenuChildModel childModel = new MenuChildModel("View / Edit", false, false);
//        childModelsList.add(childModel);
//
//        childModel = new MenuChildModel("My KYC", false, false);
//        childModelsList.add(childModel);
//
//        childModel = new MenuChildModel("CHANGE PASSWORD", false, false);
//        childModelsList.add(childModel);
//
//        if (!menuModel.hasChildren) {
//            childList.put(menuModel, childModelsList);
//        }
//        MenuModel menuMode2 = new MenuModel("My Profile", true, false); //Menu of Android Tutorial. No sub menus
//        headerList.add(menuMode2);
//
//        if (!menuModel.hasChildren) {
//            childList.put(menuModel, null);
//        }
//        menuModel = new MenuModel("Drafts", true, true); //Menu of Java Tutorials
//        headerList.add(menuModel);
//
//        List<MenuChildModel> childModelsList = new ArrayList<>();
//        MenuChildModel childModel2 = new MenuChildModel("Survey", false, false);
//        childModelsList.add(childModel2);
//
//        childModel2 = new MenuChildModel("Enquiry", false, false);
//        childModelsList.add(childModel2);
//
//
//        if (menuModel.hasChildren) {
//            childList.put(menuModel, childModelsList);
//        }
//
//        childModelsList = new ArrayList<>();
//        menuModel = new MenuModel("Settings", true, true); //Menu of Python Tutorials
//        headerList.add(menuModel);
//        childModel = new MenuChildModel("Unit Settings", false, false);
//        childModelsList.add(childModel);
//
//        childModel = new MenuChildModel("Master Settings", false, false);
//        childModelsList.add(childModel);
//
//        if (menuModel.hasChildren) {
//            childList.put(menuModel, childModelsList);
//        }
//        MenuModel menuMode3 = new MenuModel("Log Out", true, false); //Menu of Android Tutorial. No sub menus
//        headerList.add(menuMode3);
//
//    }
//
//    private void populateExpandableList() {
//
//        expandableListAdapter = new ExpandableListAdapter(this, headerList, childList);
//        expandableListView.setAdapter(expandableListAdapter);
//
//        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
//            @Override
//            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
//
//                if (headerList.get(groupPosition).isGroup) {
//                    if (!headerList.get(groupPosition).hasChildren) {
//                        if (groupPosition == 4) {
//                            // sessionManager.Logout();
//
//                        }
//                        if (groupPosition == 1) {
//                            // sessionManager.Logout();
//
//                        }
//                        onBackPressed();
//                    }
//                }
//
//                return false;
//            }
//        });
//
//        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
//            @Override
//            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
//
//                if (childList.get(headerList.get(groupPosition)) != null) {
//                    MenuChildModel model = childList.get(headerList.get(groupPosition)).get(childPosition);
//                    Fragment newFragment;
//                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
//
//                    if (groupPosition == 3) {
//                        if (childPosition == 0) {
//                            // finish();
//                        }
//                    }
//                    if (groupPosition == 2) {
//                        if (childPosition == 0) {
//                            // finish();
//                        }
//                    }
//                }
//
//                return false;
//            }
//        });
//    }
}