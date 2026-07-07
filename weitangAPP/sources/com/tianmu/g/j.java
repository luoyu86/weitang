package com.tianmu.g;

import android.content.Context;
import android.media.ExifInterface;
import android.net.Uri;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.tianmu.g.r;
import com.tianmu.g.x;

/* JADX INFO: loaded from: classes2.dex */
public class j extends f {
    public j(Context context) {
        super(context);
    }

    @Override // com.tianmu.g.f, com.tianmu.g.x
    public boolean a(v vVar) {
        return "file".equals(vVar.f12159d.getScheme());
    }

    @Override // com.tianmu.g.f, com.tianmu.g.x
    public x.a a(v vVar, int i2) {
        return new x.a(null, c(vVar), r.e.f12137c, a(vVar.f12159d));
    }

    public static int a(Uri uri) {
        int attributeInt = new ExifInterface(uri.getPath()).getAttributeInt("Orientation", 1);
        if (attributeInt == 3) {
            return BaseTransientBottomBar.ANIMATION_FADE_DURATION;
        }
        if (attributeInt != 6) {
            return attributeInt != 8 ? 0 : 270;
        }
        return 90;
    }
}
