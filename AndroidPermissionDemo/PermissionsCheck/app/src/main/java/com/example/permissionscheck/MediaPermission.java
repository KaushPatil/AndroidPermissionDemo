package com.example.permissionscheck;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.DexterError;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.PermissionRequestErrorListener;
import com.karumi.dexter.listener.multi.DialogOnAnyDeniedMultiplePermissionsListener;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.karumi.dexter.listener.single.PermissionListener;

import java.util.List;

public class MediaPermission {
//        implements PermissionRequestErrorListener, IMultiplePermissionsCallbacks, PermissionListener {

//    private Activity activity;
//    public static Boolean isAllPermissionGranted = false;
//
//
//    public MediaPermission(Activity activity) {
//        this.activity = activity;
//    }
//
//    public void cameraPermission() {
//        Dexter.withActivity(activity)
//                .withPermission(Manifest.permission.CAMERA)
//                .withListener(this)
//                .withErrorListener(this)
//                .onSameThread()
//                .check();
//    }
//
//    public void contactsPermission() {
//        Dexter.withActivity(activity)
//                .withPermission(Manifest.permission.READ_CONTACTS)
//                .withListener(this)
//                .withErrorListener(this)
//                .check();
//    }
//
//    public void audioPermission() {
//        Dexter.withActivity(activity)
//                .withPermission(Manifest.permission.RECORD_AUDIO)
//                .withListener(this)
//                .withErrorListener(this)
//                .check();
//    }
//
//    public void registerMultiplePermission() {
//        Dexter.withActivity(activity)
//                .withPermissions(
//                        Manifest.permission.CAMERA,
//                        Manifest.permission.READ_CONTACTS,
//                        Manifest.permission.RECORD_AUDIO
//                ).withListener(this)
//                .withErrorListener(this)
//                .onSameThread()
//                .check();
//    }
//
//    @Override
//    public void onError(DexterError error) {
//
//        Toast.makeText(activity, "Some Error! ", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void onPermissionsChecked(MultiplePermissionsReport report) {
//        // check if all permissions are granted
//        if (report.areAllPermissionsGranted()) {
//            isAllPermissionGranted = true;
//        }
//
//        // check for permanent denial of any permission
//        if (report.isAnyPermissionPermanentlyDenied()) {
//            // show alert dialog navigating to Settings
//            // permissionDialog();
//        }
//    }
//
//    private void permissionDialog() {
//        IMultiplePermissionsCallbacks dialogMultiplePermissionsListener = DialogOnAnyDeniedMultiplePermissionsListener.Builder
//                .withContext(activity)
//                .withTitle("Camera & audio permission")
//                .withMessage("Both camera and audio permission are needed to take pictures of your cat")
//                .withButtonText(android.R.string.ok)
//                .withIcon(R.drawable.icon_audio)
//                .build();
//
//    }
//
//
//    @Override
//    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
//        //  token.continuePermissionRequest();
//
//        permissionDialog();
//
//        showPermissionRationale(token);
//    }
//
//    public void showPermissionRationale(final PermissionToken token) {
//        new AlertDialog.Builder(activity).setTitle(R.string.all_permissions_title)
//                .setMessage(R.string.all_permissions_msg)
//                .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.dismiss();
//                        token.cancelPermissionRequest();
//                    }
//                })
//                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.dismiss();
//                        token.continuePermissionRequest();
//                    }
//                })
//                .setOnDismissListener(new DialogInterface.OnDismissListener() {
//                    @Override
//                    public void onDismiss(DialogInterface dialog) {
//                        token.cancelPermissionRequest();
//                    }
//                })
//                .show();
//    }
//
//    @Override
//    public void onPermissionGranted(PermissionGrantedResponse response) {
//
//    }
//
//    @Override
//    public void onPermissionDenied(PermissionDeniedResponse response) {
//
//    }
//
//    @Override
//    public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
//
//        if(permission.getName().equals(Manifest.permission.CAMERA)){
//            cameraPermission();
//
//        }else if(permission.getName().equals(Manifest.permission.READ_CONTACTS)){
//            contactsPermission();
//
//        }else{
//            audioPermission();
//        }
//
//    }
}


//    private void snackBarDialog() {
//        IMultiplePermissionsCallbacks snackbarMultiplePermissionsListener =
//                SnackbarOnAnyDeniedMultiplePermissionsListener
//                        .Builder
//                        .with(view, "Camera and audio access is needed to take pictures of your dog")
//                        .withOpenSettingsButton("Settings")
//                        .withCallback(new Snackbar.Callback() {
//                            @Override
//                            public void onShown(Snackbar snackbar) {
//                                // Event handler for when the given Snackbar has been dismissed
//                            }
//
//                            @Override
//                            public void onDismissed(Snackbar snackbar, int event) {
//                                // Event handler for when the given Snackbar is visible
//                            }
//                        })
//                        .build();
//    }



