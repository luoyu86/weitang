package cn.admobiletop.adsuyi.a.m;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import androidx.core.content.ContextCompat;
import cn.admobiletop.adsuyi.ADSuyiSdk;
import cn.admobiletop.adsuyi.config.ADSuyiInitConfig;
import com.alibaba.sdk.android.oss.common.RequestParameters;

/* JADX INFO: loaded from: classes.dex */
public class i {
    @SuppressLint({"MissingPermission"})
    public static Location a(Context context) {
        LocationManager locationManager;
        if (context == null) {
            return null;
        }
        try {
            ADSuyiInitConfig config = ADSuyiSdk.getInstance().getConfig();
            if (config == null || !config.isCanUseLocation() || ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION") != 0 || (locationManager = (LocationManager) context.getSystemService(RequestParameters.SUBRESOURCE_LOCATION)) == null) {
                return null;
            }
            Location lastKnownLocation = (ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == 0 && locationManager.isProviderEnabled("gps")) ? locationManager.getLastKnownLocation("gps") : null;
            return lastKnownLocation == null ? locationManager.getLastKnownLocation("network") : lastKnownLocation;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return null;
    }
}
