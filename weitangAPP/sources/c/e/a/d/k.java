package c.e.a.d;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import com.taobao.accs.utl.UtilityImpl;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.Locale;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f1218a = Build.VERSION.RELEASE;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f1219b = Build.MODEL;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f1220c = Build.BRAND;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f1221d;

    public static DisplayMetrics a(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            if (defaultDisplay != null) {
                defaultDisplay.getMetrics(displayMetrics);
            } else {
                displayMetrics.setToDefaults();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return displayMetrics;
    }

    @TargetApi(9)
    public static String b() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
                if ("wlan0".equals(networkInterfaceNextElement.getName()) || "eth0".equals(networkInterfaceNextElement.getName())) {
                    byte[] hardwareAddress = networkInterfaceNextElement.getHardwareAddress();
                    if (hardwareAddress != null && hardwareAddress.length != 0) {
                        StringBuilder sb = new StringBuilder();
                        for (byte b2 : hardwareAddress) {
                            sb.append(String.format("%02X:", Byte.valueOf(b2)));
                        }
                        if (sb.length() > 0) {
                            sb.deleteCharAt(sb.length() - 1);
                        }
                        return sb.toString().toLowerCase(Locale.getDefault());
                    }
                    return null;
                }
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String c(Context context) {
        if (context == null) {
            return "";
        }
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService(UtilityImpl.NET_TYPE_WIFI);
            if (checkPermission(context, "android.permission.ACCESS_WIFI_STATE")) {
                return wifiManager.getConnectionInfo().getMacAddress();
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    public static boolean checkPermission(Context context, String str) {
        if (context == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                if (((Integer) Class.forName("android.content.Context").getMethod("checkSelfPermission", String.class).invoke(context, str)).intValue() != 0) {
                    return false;
                }
            } catch (Throwable unused) {
                return false;
            }
        } else if (context.getPackageManager().checkPermission(str, context.getPackageName()) != 0) {
            return false;
        }
        return true;
    }

    public static int getBannerHeight(Context context) {
        return (int) (getScreenWidth(context) * 0.43f);
    }

    public static float getDensity(Context context) {
        return a(context).density;
    }

    public static int getDensityDpi(Context context) {
        return a(context).densityDpi;
    }

    public static String getDeviceInfo(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            String mac = getMac(context);
            jSONObject.put("mac", mac);
            if (!TextUtils.isEmpty(null)) {
                mac = null;
            }
            if (TextUtils.isEmpty(mac)) {
                mac = Settings.Secure.getString(context.getContentResolver(), "android_id");
            }
            jSONObject.put("device_id", mac);
            return jSONObject.toString();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String getLocalIpAddress(Context context) {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddressNextElement = inetAddresses.nextElement();
                    if (!inetAddressNextElement.isLoopbackAddress() && !inetAddressNextElement.isLinkLocalAddress()) {
                        return inetAddressNextElement.getHostAddress().toString();
                    }
                }
            }
            return null;
        } catch (SocketException e2) {
            Toast.makeText(context, e2.getMessage(), 0).show();
            return null;
        }
    }

    public static String getMac(Context context) {
        if (context == null) {
            return "";
        }
        if (Build.VERSION.SDK_INT < 23) {
            return c(context);
        }
        String strB = b();
        return TextUtils.isEmpty(strB) ? c(context) : strB;
    }

    public static int getProductBannerHeight(Context context) {
        return (int) (getScreenWidth(context) * 0.56f);
    }

    public static int getScreenHeight(Context context) {
        return a(context).heightPixels;
    }

    public static int getScreenWidth(Context context) {
        return a(context).widthPixels;
    }

    public static void init(Context context) {
        if (ContextCompat.checkSelfPermission(context, "android.permission.READ_PHONE_STATE") != 0) {
            return;
        }
        f1221d = ((WifiManager) context.getSystemService(UtilityImpl.NET_TYPE_WIFI)).getConnectionInfo().getMacAddress();
    }
}
