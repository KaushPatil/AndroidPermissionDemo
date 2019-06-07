package com.example.permissionscheck.activites;

import android.Manifest;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.permissionscheck.R;
import com.example.permissionscheck.controller.PermissionController;
import com.example.permissionscheck.interfaces.IMultiplePermissionsCallbacks;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;

import java.util.List;


/**
 * this activity will switch you to activities having single permissions.This activity Itself ask
 * for multiple permissions
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener, IMultiplePermissionsCallbacks {

    private Button openCameraActivity;
    private Button openAudioActivity;
    private Button openMultiplePermissionActivity;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
        setListenersToViews();
        askForPermission();

    }

    /**
     * views initialization
     */
    private void initializeViews() {
        openCameraActivity = findViewById(R.id.camera_activty_button);
        openAudioActivity = findViewById(R.id.audio_activty_button);
        openMultiplePermissionActivity = findViewById(R.id.multiple_permission_activty_button);
    }

    /**
     * setting views onclick event liteners
     */
    private void setListenersToViews() {
        openCameraActivity.setOnClickListener(this);
        openAudioActivity.setOnClickListener(this);
        openMultiplePermissionActivity.setOnClickListener(this);
    }


    /**
     * call permission controller to execute permission process
     */
    private void askForPermission() {
        PermissionController controller = new PermissionController(this, this);
        controller.checkMultiplePermission(Manifest.permission.CAMERA, Manifest.permission.READ_CONTACTS, Manifest.permission.RECORD_AUDIO);
    }


    /**
     * calls the click listeners of view by identifying their ids
     *
     * @param view takes the view whose onclick is called
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.camera_activty_button:
                onOpenCameraActivityClick();
                break;
            case R.id.audio_activty_button:
                onOpenAudioActivityClick();
                break;
            case R.id.multiple_permission_activty_button:
                onOpenMultiplePermissionActivityClick();
        }
    }

    /**
     * opens the activity to ask camera permission
     */
    private void onOpenCameraActivityClick() {
        intent = new Intent(this, ActivityCamera.class);
        startActivity(intent);
    }

    /**
     * opens the activity to ask audio and contact permission
     */
    private void onOpenAudioActivityClick() {
        intent = new Intent(this, ActivityAudio.class);
        startActivity(intent);
    }

    /**
     * opens the activity to ask multiple permission
     */
    private void onOpenMultiplePermissionActivityClick() {
        intent = new Intent(this, ActivityMultiplePermissions.class);
        startActivity(intent);
    }

    @Override
    public void onPermissionsChecked(MultiplePermissionsReport report) {
        Log.d("MainActivity>>", "onPermissionsChecked ");
    }

    @Override
    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
        token.cancelPermissionRequest();


        /**
         * token.continuePermissionRequest();
         *
         * use this only if you want permissions to be asked every time the app will launch
         * otherwise add token.cancelPermissionRequest() to your code this will ask for the permission
         * only once when the application is installed
         *
         * */
    }


}
