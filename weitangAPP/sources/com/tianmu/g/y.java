package com.tianmu.g;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tianmu.g.r;
import com.tianmu.g.x;
import java.io.FileNotFoundException;

/* JADX INFO: loaded from: classes2.dex */
public class y extends x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f12188a;

    public y(Context context) {
        this.f12188a = context;
    }

    @Override // com.tianmu.g.x
    public boolean a(v vVar) {
        if (vVar.f12160e != 0) {
            return true;
        }
        return "android.resource".equals(vVar.f12159d.getScheme());
    }

    @Override // com.tianmu.g.x
    public x.a a(v vVar, int i2) throws FileNotFoundException {
        Resources resourcesA = f0.a(this.f12188a, vVar);
        return new x.a(a(resourcesA, f0.a(resourcesA, vVar), vVar), r.e.f12137c);
    }

    private static Bitmap a(Resources resources, int i2, v vVar) {
        BitmapFactory.Options optionsB = x.b(vVar);
        if (x.a(optionsB)) {
            BitmapFactory.decodeResource(resources, i2, optionsB);
            x.a(vVar.f12163h, vVar.f12164i, optionsB, vVar);
        }
        return BitmapFactory.decodeResource(resources, i2, optionsB);
    }
}
