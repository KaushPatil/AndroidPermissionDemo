package com.example.permissionscheck.interfaces;

import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;

import java.util.List;

public interface IMultiplePermissionsCallbacks {

    void onPermissionsChecked(MultiplePermissionsReport report);

    void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token);

}
