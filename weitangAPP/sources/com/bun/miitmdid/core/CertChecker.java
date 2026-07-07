package com.bun.miitmdid.core;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class CertChecker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CertChecker f5833a = new CertChecker();

    static {
        try {
            System.loadLibrary("msaoaidauth");
        } catch (RuntimeException e2) {
            e2.printStackTrace();
        }
    }

    public static native CertChecker a();

    public native boolean verifyCert(Context context, String str);
}
