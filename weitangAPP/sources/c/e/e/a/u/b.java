package c.e.e.a.u;

import android.bluetooth.BluetoothAdapter;
import c.e.e.a.x.k;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    public static String getBluetoothMac(String str) {
        if (k.isNotNull(str) && BluetoothAdapter.checkBluetoothAddress(str)) {
            return str;
        }
        return (str.substring(0, 2) + ":" + str.substring(2, 4) + ":" + str.substring(4, 6) + ":" + str.substring(6, 8) + ":" + str.substring(8, 10) + ":" + str.substring(10, 12)).toUpperCase();
    }

    public static boolean isEqualsMac(String str, String str2) {
        return getBluetoothMac(str).equalsIgnoreCase(str2);
    }
}
