package com.intelligoo.sdk;

import android.os.Bundle;

/* JADX INFO: loaded from: classes2.dex */
public class i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static i f9264c = new i();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LibDevModel f9265a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Bundle f9266b = null;

    private i() {
    }

    public static i a() {
        return f9264c;
    }

    public static i a(LibDevModel libDevModel) {
        if (libDevModel == null) {
            return null;
        }
        a().f9265a = libDevModel;
        return f9264c;
    }

    public void a(Bundle bundle) {
        this.f9266b = bundle;
    }
}
