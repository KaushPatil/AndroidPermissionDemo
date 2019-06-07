package com.example.permissionscheck.activites;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.permissionscheck.R;
import com.example.permissionscheck.controller.PermissionController;
import com.example.permissionscheck.interfaces.ISinglePermissionCallback;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;


/**
 * to get camera permission and if permission granted, will open the camera on button click
 */
public class ActivityCamera extends AppCompatActivity implements View.OnClickListener, ISinglePermissionCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);


        Button cameraButton = findViewById(R.id.camera_button);
        cameraButton.setOnClickListener(this);
    }

    /**
     * calls the click listeners of view by identifying their ids
     *
     * @param view takes the view whose onclick is called
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.camera_button:
                PermissionController controller = new PermissionController(this, this);
                controller.checkSinglePermission(Manifest.permission.CAMERA);

        }
    }

    @Override
    public void onPermissionGranted(PermissionGrantedResponse response) {
        Log.d("ActivityCamera>>", "onPermissionGranted camera  " + response.getPermissionName());
        openCamera();
    }

    @Override
    public void onPermissionDenied(PermissionDeniedResponse response) {
        Log.d("ActivityCamera>>", "onPermissionDenied camera" + response.getPermissionName());
    }

    @Override
    public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {

        Log.d("ActivityCamera>>", "onPermissionRationaleShouldBeShown camera");
        token.continuePermissionRequest();
    }

    /**
     * it contains intent to open the camera
     */
    private void openCamera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 100);
    }

}
