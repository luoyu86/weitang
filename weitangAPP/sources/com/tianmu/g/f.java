package com.tianmu.g;

import android.content.Context;
import com.tianmu.g.r;
import com.tianmu.g.x;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class f extends x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f12063a;

    public f(Context context) {
        this.f12063a = context;
    }

    @Override // com.tianmu.g.x
    public boolean a(v vVar) {
        return "content".equals(vVar.f12159d.getScheme());
    }

    public InputStream c(v vVar) {
        return this.f12063a.getContentResolver().openInputStream(vVar.f12159d);
    }

    @Override // com.tianmu.g.x
    public x.a a(v vVar, int i2) {
        return new x.a(c(vVar), r.e.f12137c);
    }
}
