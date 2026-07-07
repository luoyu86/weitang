package com.tianmu.g;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import com.tianmu.g.r;
import com.tianmu.g.x;

/* JADX INFO: loaded from: classes2.dex */
public class b extends x {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f12042b = 22;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AssetManager f12043a;

    public b(Context context) {
        this.f12043a = context.getAssets();
    }

    public static String c(v vVar) {
        return vVar.f12159d.toString().substring(f12042b);
    }

    @Override // com.tianmu.g.x
    public boolean a(v vVar) {
        Uri uri = vVar.f12159d;
        return "file".equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && "android_asset".equals(uri.getPathSegments().get(0));
    }

    @Override // com.tianmu.g.x
    public x.a a(v vVar, int i2) {
        return new x.a(this.f12043a.open(c(vVar)), r.e.f12137c);
    }
}
