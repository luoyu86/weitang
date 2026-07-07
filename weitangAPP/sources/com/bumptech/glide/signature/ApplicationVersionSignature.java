package com.bumptech.glide.signature;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.bumptech.glide.load.Key;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationVersionSignature {
    private static final ConcurrentHashMap<String, Key> PACKAGE_NAME_TO_KEY = new ConcurrentHashMap<>();

    private ApplicationVersionSignature() {
    }

    public static Key obtain(Context context) {
        String packageName = context.getPackageName();
        ConcurrentHashMap<String, Key> concurrentHashMap = PACKAGE_NAME_TO_KEY;
        Key key = concurrentHashMap.get(packageName);
        if (key != null) {
            return key;
        }
        Key keyObtainVersionSignature = obtainVersionSignature(context);
        Key keyPutIfAbsent = concurrentHashMap.putIfAbsent(packageName, keyObtainVersionSignature);
        return keyPutIfAbsent == null ? keyObtainVersionSignature : keyPutIfAbsent;
    }

    private static Key obtainVersionSignature(Context context) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            packageInfo = null;
        }
        return new StringSignature(packageInfo != null ? String.valueOf(packageInfo.versionCode) : UUID.randomUUID().toString());
    }

    public static void reset() {
        PACKAGE_NAME_TO_KEY.clear();
    }
}
