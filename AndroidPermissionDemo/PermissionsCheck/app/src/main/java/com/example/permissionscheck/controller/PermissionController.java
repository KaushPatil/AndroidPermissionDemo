package com.example.permissionscheck.controller;

import android.app.Activity;
import android.util.Log;

import com.example.permissionscheck.interfaces.IMultiplePermissionsCallbacks;
import com.example.permissionscheck.interfaces.ISinglePermissionCallback;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.karumi.dexter.listener.single.PermissionListener;

import java.util.List;

/**
 * this class is created to handle Application permissions.For this purpose it
 * implements two interfaces, MultiplePermissionsListener for handling multiple permissions
 * and PermissionListener for handling single permissions
 */
public class PermissionController implements MultiplePermissionsListener, PermissionListener {

    private Activity activity;
    private IMultiplePermissionsCallbacks multiplePermissionsCallbacks;
    private ISinglePermissionCallback singlePermissionCallback;

    /**
     * parameterised constructor
     *
     * @param activity takes the activity as parameter
     */
    public PermissionController(Activity activity, IMultiplePermissionsCallbacks multiplePermissionsCallbacks) {
        this.activity = activity;
        this.multiplePermissionsCallbacks = multiplePermissionsCallbacks;
    }

    public PermissionController(Activity activity, ISinglePermissionCallback singlePermissionCallback) {
        this.activity = activity;
        this.singlePermissionCallback = singlePermissionCallback;
    }

    /**
     * If you want to request multiple permissions you just need to call withPermissions and register an
     * implementation of MultiplePermissionsListener
     *
     * @param permissions takes the name of more than one permissions requested
     */
    public void checkMultiplePermission(String... permissions) {
        Dexter.withActivity(activity)
                .withPermissions(permissions)
                .withListener(this)
                .check();
    }

    /**
     * callback for single permission check listener
     *
     * @param permission name of permission to be requested
     */
    public void checkSinglePermission(String permission) {
        Dexter.withActivity(activity)
                .withPermission(permission)
                .withListener(this)
                .check();
    }

    /**
     * The MultiplePermissionsReport contains all the details of the permission request like the list
     * <p>
     * of denied/granted permissions or utility methods like areAllPermissionsGranted and
     * <p>
     * isAnyPermissionPermanentlyDenied
     *
     * @param report it will give the list of granted and denied permissions.
     *               it has two boolean methods isAnyPermissionPermanentlyDenied() which will return
     *               true if there is any permission that is permanently denied by the user
     *               and areAllPermissionsGranted() which will return true when all the permissions are granted
     */

    @Override
    public void onPermissionsChecked(MultiplePermissionsReport report) {

        if (multiplePermissionsCallbacks != null) {
            /**
             * callback for onPermissionsChecked()
             */
            multiplePermissionsCallbacks.onPermissionsChecked(report);
        }

    }

    /**
     * It will call the method onPermissionRationaleShouldBeShown implemented in your listener
     * <p>
     * with a PermissionToken. It's important to keep in mind that the request process will pause
     * <p>
     * until the token is used, therefore, you won't be able to call permission process again or request any
     * <p>
     * other permissions if the token has not been used.So, to continue the request process each time
     * <p>
     * when the application starts you need to add  "token.continuePermissionRequest();" and to
     * <p>
     * stop this process to be occure each time when the Application is started you can add
     * <p>
     * "token.cancelPermissionRequest();" if you add this line to your code the permission process will
     * <p>
     * get called only after the application is installed.
     *
     * @param permissions this parameter Contains the List of permissions that are requested
     * @param token       this parameter is used to decide whether to continue the request process or not
     */
    @Override
    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
//        Log.d("test>>", "onPermissionRationaleShouldBeShown: ");

        if (multiplePermissionsCallbacks != null) {

            /**
             * callback for onPermissionRationaleShouldBeShown() for multiple permission
             */
            multiplePermissionsCallbacks.onPermissionRationaleShouldBeShown(permissions, token);
        }

    }


    /**
     * It will called when the user allow for the specific permission.
     * this method will contain the code that you want to execute after permission is granted.
     * It will contain the name of the permission requested.
     *
     * @param response will provide the granted permission name
     */

    @Override
    public void onPermissionGranted(PermissionGrantedResponse response) {
//        Log.d("test>>", "onPermissionGranted: " + response.getPermissionName());

        if (singlePermissionCallback != null) {
            /**
             * callback for onPermissionGranted()
             */
            singlePermissionCallback.onPermissionGranted(response);
        }
    }

    /**
     * It will called when the user denied for the specific permission.
     * this method will contain the code that you want to execure after permission is denied.
     * It will contain the name of the permission requested.
     *
     * @param response will provide the denied permission name
     */

    @Override
    public void onPermissionDenied(PermissionDeniedResponse response) {
//        Log.d("test>>", "onPermissionDenied: " + response.getPermissionName());
        if (singlePermissionCallback != null) {
            /**
             * callback for onPermissionDenied()
             */
            singlePermissionCallback.onPermissionDenied(response);
        }
    }


    /**
     * It will call the method onPermissionRationaleShouldBeShown implemented in your listener
     * <p>
     * with a PermissionToken. It's important to keep in mind that the request process will pause
     * <p>
     * until the token is used, therefore, you won't be able to call permission process again or request any
     * <p>
     * other permissions if the token has not been used.
     *
     * @param permission this parameter contains the name of the permission
     * @param token      it is used to decide whether to continue the permission request or not.
     *                   token.cancelPermissionRequest() to occure the permission request process
     *                   only once when the application is installed, and token.continuePermissionRequest()
     *                   to occure the process each time when the application is started.
     */
    @Override
    public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
        token.continuePermissionRequest();
        if (singlePermissionCallback != null) {
            /**
             * callback for onPermissionRationaleShouldBeShown() for single permission request
             */
            singlePermissionCallback.onPermissionRationaleShouldBeShown(permission, token);
        }
    }
}
