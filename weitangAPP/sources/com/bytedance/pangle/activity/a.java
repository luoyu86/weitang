package com.bytedance.pangle.activity;

import android.app.Activity;
import android.view.View;
import androidx.annotation.NonNull;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Activity f5944a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f5945b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f5946c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Method f5947d;

    public a(@NonNull Activity activity, int i2, @NonNull String str) {
        this.f5944a = activity;
        this.f5945b = str;
        this.f5946c = i2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(@NonNull View view) {
        if (this.f5947d == null) {
            try {
                Method method = this.f5944a.getClass().getMethod(this.f5945b, View.class);
                if (method != null) {
                    this.f5947d = method;
                }
            } catch (NoSuchMethodException unused) {
            }
            throw new IllegalStateException("Could not find method " + this.f5945b + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.f5946c);
        }
        try {
            this.f5947d.invoke(this.f5944a, view);
        } catch (IllegalAccessException e2) {
            throw new IllegalStateException("Could not execute non-public method for android:onClick", e2);
        } catch (InvocationTargetException e3) {
            throw new IllegalStateException("Could not execute method for android:onClick", e3);
        }
    }
}
