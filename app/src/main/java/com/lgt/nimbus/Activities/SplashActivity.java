package com.lgt.nimbus.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Space;
import android.widget.Toast;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.DexterError;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.PermissionRequestErrorListener;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.lgt.nimbus.Common.CommonCheck;
import com.lgt.nimbus.R;

import java.util.ArrayList;
import java.util.List;

public class SplashActivity extends AppCompatActivity {
    // global storage
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private String mUserID;
    boolean isUserValid = true;
    private Context context;
    private SplashActivity activity;
    ExpandableListAdapter expandableListAdapter;
    ExpandableListView expandableListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        context = activity = this;
        // store in app
        sharedPreferences = SplashActivity.this.getSharedPreferences("USER_INFO", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        // splash
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                checkPermission();
            }
        }, 2000);
    }

    private void checkPermission() {
        try {
            Dexter.withActivity(SplashActivity.this)
                    .withPermissions(Manifest.permission.INTERNET,
                            Manifest.permission.READ_EXTERNAL_STORAGE,
                            Manifest.permission.ACCESS_NETWORK_STATE,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    .withListener(new MultiplePermissionsListener() {
                        @Override
                        public void onPermissionsChecked(MultiplePermissionsReport report) {
                            if (true) {
                                foundValidUser();
                            } else {
                                Toast.makeText(SplashActivity.this, "No Internet", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                            token.continuePermissionRequest();
                        }
                    }).withErrorListener(new PermissionRequestErrorListener() {
                @Override
                public void onError(DexterError error) {
                    Toast.makeText(SplashActivity.this, "Permission Error occurred...", Toast.LENGTH_SHORT).show();
                }
            }).onSameThread().check();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void foundValidUser() {
        if (isUserValid) {
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
            finishAffinity();
        } else {
        }
    }

}