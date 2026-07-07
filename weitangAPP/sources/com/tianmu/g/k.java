package com.tianmu.g;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tianmu.g.r;

/* JADX INFO: loaded from: classes2.dex */
public class k extends a<ImageView> {
    public e m;

    public k(r rVar, ImageView imageView, v vVar, int i2, int i3, int i4, Drawable drawable, String str, Object obj, e eVar, boolean z) {
        super(rVar, imageView, vVar, i2, i3, i4, drawable, str, obj, z);
        this.m = eVar;
    }

    @Override // com.tianmu.g.a
    public void a(Bitmap bitmap, r.e eVar) {
        if (bitmap == null) {
            throw new AssertionError(String.format("Attempted to complete action with no result!\n%s", this));
        }
        ImageView imageView = (ImageView) this.f12025c.get();
        if (imageView == null) {
            return;
        }
        r rVar = this.f12023a;
        s.a(imageView, rVar.f12119e, bitmap, eVar, this.f12026d, rVar.m);
        e eVar2 = this.m;
        if (eVar2 != null) {
            eVar2.onSuccess();
        }
    }

    @Override // com.tianmu.g.a
    public void b() {
        ImageView imageView = (ImageView) this.f12025c.get();
        if (imageView == null) {
            return;
        }
        int i2 = this.f12029g;
        if (i2 != 0) {
            imageView.setImageResource(i2);
        } else {
            Drawable drawable = this.f12030h;
            if (drawable != null) {
                imageView.setImageDrawable(drawable);
            }
        }
        e eVar = this.m;
        if (eVar != null) {
            eVar.onError();
        }
    }

    @Override // com.tianmu.g.a
    public void a() {
        super.a();
        if (this.m != null) {
            this.m = null;
        }
    }
}
