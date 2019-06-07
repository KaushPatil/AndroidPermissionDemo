package com.example.permissionscheck.interfaces;

import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;

public interface ISinglePermissionCallback {

     void onPermissionGranted(PermissionGrantedResponse response);

     void onPermissionDenied(PermissionDeniedResponse response);

     void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token);
}
