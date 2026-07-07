package com.tianmu.g;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tianmu.g.r;

/* JADX INFO: loaded from: classes2.dex */
public final class c0 extends a<b0> {
    public c0(r rVar, b0 b0Var, v vVar, int i2, int i3, Drawable drawable, String str, Object obj, int i4) {
        super(rVar, b0Var, vVar, i2, i3, i4, drawable, str, obj, false);
    }

    @Override // com.tianmu.g.a
    public void a(Bitmap bitmap, r.e eVar) {
        if (bitmap == null) {
            throw new AssertionError(String.format("Attempted to complete action with no result!\n%s", this));
        }
        b0 b0VarJ = j();
        if (b0VarJ != null) {
            b0VarJ.onBitmapLoaded(bitmap, eVar);
            if (bitmap.isRecycled()) {
                throw new IllegalStateException("Target callback must not recycle bitmap!");
            }
        }
    }

    @Override // com.tianmu.g.a
    public void b() {
        b0 b0VarJ = j();
        if (b0VarJ != null) {
            if (this.f12029g != 0) {
                b0VarJ.onBitmapFailed(this.f12023a.f12119e.getResources().getDrawable(this.f12029g));
            } else {
                b0VarJ.onBitmapFailed(this.f12030h);
            }
        }
    }
}
