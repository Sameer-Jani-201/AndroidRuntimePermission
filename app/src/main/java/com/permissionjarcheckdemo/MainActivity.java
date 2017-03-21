package com.permissionjarcheckdemo;

import android.Manifest;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.multiplemarshmallowpermission.permissions.PermissionResultsListeners;
import com.multiplemarshmallowpermission.permissions.PermissionsRequestUtil;

/*
*  21-Mar-2017 By Sameer Jani
* */

public class MainActivity extends AppCompatActivity implements PermissionResultsListeners {

    private PermissionsRequestUtil permissionsRequestUtil = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            permissionsRequestUtil = new PermissionsRequestUtil(MainActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 102, this);
        } else {
            Toast.makeText(MainActivity.this, "Write Permission available.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (permissionsRequestUtil != null) {
            permissionsRequestUtil.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    //Here you will get all the granted permssion name.
    @Override
    public void onPermissionGranted(String s) {

    }

    //Here you will get all the denied permission name.
    @Override
    public void onPermissionDenied(String s) {

    }

    //Here you will get all the blocked permissions.
    @Override
    public void onPermissionBlocked(String s) {

        //To open setting screen to allow permission manually using this below one line code.
        permissionsRequestUtil.showSettingDialog(MainActivity.this, s);
    }


    //This is main method where you write your actual further code.
    //When all the required permission granted that time this method will be involked.
    @Override
    public void onAllPermissionGranted() {
        Toast.makeText(MainActivity.this, "Write Permission available.", Toast.LENGTH_SHORT).show();
    }
}
