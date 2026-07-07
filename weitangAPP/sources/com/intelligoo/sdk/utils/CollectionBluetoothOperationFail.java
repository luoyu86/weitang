package com.intelligoo.sdk.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.util.Log;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class CollectionBluetoothOperationFail {
    private static CollectionBluetoothOperationFail instance;
    private Map<String, String> infos = new HashMap();
    private String TAG = "CollectionBleFail";
    private DateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault());

    private CollectionBluetoothOperationFail() {
    }

    public static synchronized CollectionBluetoothOperationFail getBleOperationInstance() {
        if (instance == null) {
            instance = new CollectionBluetoothOperationFail();
        }
        return instance;
    }

    private String saveCrashInfo2File(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, String> entry : this.infos.entrySet()) {
            stringBuffer.append(entry.getKey() + "=" + entry.getValue() + "\n");
        }
        stringBuffer.append(str);
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            String str2 = "doormaster--crash-" + this.formatter.format(new Date()) + "-" + jCurrentTimeMillis + ".txt";
            if (!Environment.getExternalStorageState().equals("mounted")) {
                return str2;
            }
            File file = new File("/sdcard/DoorMasterSDKLog");
            if (!file.exists()) {
                file.mkdirs();
            }
            String str3 = "/sdcard/DoorMasterSDKLog/" + str2;
            FileOutputStream fileOutputStream = new FileOutputStream(str3);
            fileOutputStream.write(stringBuffer.toString().getBytes());
            fileOutputStream.close();
            return str3;
        } catch (Exception e2) {
            Log.e(this.TAG, "an error occured while writing file...", e2);
            return null;
        }
    }

    public void collectDeviceInfo(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 1);
            if (packageInfo != null) {
                String str2 = packageInfo.versionName;
                if (str2 == null) {
                    str2 = "null";
                }
                String str3 = packageInfo.versionCode + "";
                this.infos.put(TTDownloadField.TT_VERSION_NAME, str2);
                this.infos.put(TTDownloadField.TT_VERSION_CODE, str3);
            }
        } catch (PackageManager.NameNotFoundException e2) {
            Log.e(this.TAG, "an error occured when collect package info", e2);
        }
        for (Field field : Build.class.getDeclaredFields()) {
            try {
                field.setAccessible(true);
                this.infos.put(field.getName(), field.get(null).toString());
                Log.d(this.TAG, field.getName() + " : " + field.get(null));
            } catch (Exception e3) {
                Log.e(this.TAG, "an error occured when collect crash info", e3);
            }
        }
        saveCrashInfo2File(str);
    }
}
