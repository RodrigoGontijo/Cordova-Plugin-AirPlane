/*
 * Phonegap AirPlaneMode Plugin for Android
 * Cordova 2.2.0
 * Email: rodrigo[dot]gontijo[at]hotmail[dot]com
 * Author: Rodrigo Augusto Gontijo
 * Date: 07/01/2016
 */

package com.rodrigo.plugins.airPlaneMode;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.LOG;
import org.json.JSONArray;
import org.json.JSONException;
import android.content.Intent;
import android.provider.Settings;

import android.content.Context;
import android.media.*;

public class AirPlaneMode extends CordovaPlugin {

    public static final String SETON = "setAirPlaneModeOn";
    public static final String SETOFF = "setAirPlaneModeOff";
    public static final String TOGGLE = "toggleAirPlaneMode";
    private static final String TAG = "AirPlaneMode";

    private Context context;


    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        boolean actionState = true;
        context = cordova.getActivity().getApplicationContext();
        if (SETON.equals(action)) {
            try {
                Settings.Global.putInt(
                        context.getContentResolver(),
                        Settings.Global.AIRPLANE_MODE_ON, 1);

                Intent intent = new Intent(Intent.ACTION_AIRPLANE_MODE_CHANGED);
                intent.putExtra("state", 1);
                context.sendBroadcast(intent);


                callbackContext.success();

            } catch (Exception e) {
                LOG.d(TAG, "Error setting volume " + e);
                actionState = false;
            }
        }

        if (SETOFF.equals(action)) {
            try {
                Settings.Global.putInt(
                        context.getContentResolver(),
                        Settings.Global.AIRPLANE_MODE_ON, 0);

                Intent intent = new Intent(Intent.ACTION_AIRPLANE_MODE_CHANGED);
                intent.putExtra("state", 0);
                context.sendBroadcast(intent);

                callbackContext.success();

            } catch (Exception e) {
                LOG.d(TAG, "Error setting volume " + e);
                actionState = false;
            }
        }


        if (TOGGLE.equals(action)) {
            try {
                boolean isEnabled = Settings.Global.getInt(
                        context.getContentResolver(),
                        Settings.Global.AIRPLANE_MODE_ON, 0) == 1;

                Settings.Global.putInt(
                        context.getContentResolver(),
                        Settings.Global.AIRPLANE_MODE_ON, isEnabled ? 0 : 1);

                Intent intent = new Intent(Intent.ACTION_AIRPLANE_MODE_CHANGED);
                intent.putExtra("state", !isEnabled);
                context.sendBroadcast(intent);

                callbackContext.success();

            } catch (Exception e) {
                LOG.d(TAG, "Error setting volume " + e);
                actionState = false;
            }
        }

        else {
            actionState = false;
        }
        return actionState;
    }

}