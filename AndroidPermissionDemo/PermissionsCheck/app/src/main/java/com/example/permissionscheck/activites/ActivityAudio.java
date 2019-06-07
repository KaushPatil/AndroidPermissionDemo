package com.example.permissionscheck.activites;

import android.Manifest;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
 * to get audio and contact permission
 */
public class ActivityAudio extends AppCompatActivity implements View.OnClickListener, ISinglePermissionCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);

        Button audioButton = findViewById(R.id.audio_button);
        Button contactButton = findViewById(R.id.contacts_button);
        audioButton.setOnClickListener(this);
        contactButton.setOnClickListener(this);
    }

    /**
     * calls the click listeners of view by identifying their ids
     * @param view takes the view whose onclick is called
     */
    @Override
    public void onClick(View view) {
        PermissionController controller = new PermissionController(this,this);
        switch (view.getId()){
            case R.id.audio_button:
                controller.checkSinglePermission(Manifest.permission.RECORD_AUDIO);
                break;

            case R.id.contacts_button:
                controller.checkSinglePermission(Manifest.permission.READ_CONTACTS);
                break;
        }
    }

    @Override
    public void onPermissionGranted(PermissionGrantedResponse response) {

    }

    @Override
    public void onPermissionDenied(PermissionDeniedResponse response) {

    }

    @Override
    public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {

        token.continuePermissionRequest();
    }
}
