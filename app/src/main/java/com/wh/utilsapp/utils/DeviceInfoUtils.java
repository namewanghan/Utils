package com.wh.utilsapp.utils;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.support.v4.app.ActivityCompat;
import android.telephony.TelephonyManager;

public class DeviceInfoUtils {

    public static String getIMSI(Context context) {
        String imsi = "NO Search";
        TelephonyManager telephonyManager = (TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE);
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            return "empty";
        }
        imsi = telephonyManager.getSubscriberId();
        return imsi;
    }

    public static String MAC(Context context) {
        String mac = "NO Search";
        WifiManager manager = (WifiManager) context.getApplicationContext()
                .getSystemService(Context.WIFI_SERVICE);
        WifiInfo info = manager.getConnectionInfo();
        mac = info.getMacAddress();
        return mac;
    }

    public static String ID(Context context) {
        String id = "NO Search";
        id = android.provider.Settings.Secure.getString(
                context.getContentResolver(),
                android.provider.Settings.Secure.ANDROID_ID);
        return id;
    }
}
