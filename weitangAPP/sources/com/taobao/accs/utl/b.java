package com.taobao.accs.utl;

import com.alibaba.sdk.android.logger.LogLevel;
import com.taobao.accs.utl.ALog;

/* JADX INFO: loaded from: classes2.dex */
public /* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f10473a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f10474b;

    static {
        int[] iArr = new int[ALog.Level.values().length];
        f10474b = iArr;
        try {
            iArr[ALog.Level.D.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f10474b[ALog.Level.V.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f10474b[ALog.Level.I.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f10474b[ALog.Level.W.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f10474b[ALog.Level.E.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f10474b[ALog.Level.L.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        int[] iArr2 = new int[LogLevel.values().length];
        f10473a = iArr2;
        try {
            iArr2[LogLevel.DEBUG.ordinal()] = 1;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            f10473a[LogLevel.INFO.ordinal()] = 2;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            f10473a[LogLevel.WARN.ordinal()] = 3;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            f10473a[LogLevel.ERROR.ordinal()] = 4;
        } catch (NoSuchFieldError unused10) {
        }
    }
}
