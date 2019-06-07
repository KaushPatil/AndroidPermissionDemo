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

public class ActivityMultiplePermissions extends AppCompatActivity implements View.OnClickListener, ISinglePermissionCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_permisions);

        Button multiPermissionButton=findViewById(R.id.multi_permission_button);
        multiPermissionButton.setOnClickListener(this);
    }

    /**
     * calls the click listeners of view by identifying their ids
     * @param view takes the view whose onclick is called
     */
    @Override
    public void onClick(View view) {
        PermissionController controller = new PermissionController(this,this);
        controller.checkMultiplePermission(Manifest.permission.RECORD_AUDIO,Manifest.permission.READ_CONTACTS);
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
