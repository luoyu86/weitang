package cn.admobiletop.adsuyi.c;

import android.content.Context;
import android.media.ExifInterface;
import android.net.Uri;
import cn.admobiletop.adsuyi.c.A;
import cn.admobiletop.adsuyi.c.I;
import com.google.android.material.snackbar.BaseTransientBottomBar;

/* JADX INFO: loaded from: classes.dex */
public class r extends C0333m {
    public r(Context context) {
        super(context);
    }

    public static int i(Uri uri) {
        int attributeInt = new ExifInterface(uri.getPath()).getAttributeInt("Orientation", 1);
        if (attributeInt == 3) {
            return BaseTransientBottomBar.ANIMATION_FADE_DURATION;
        }
        if (attributeInt != 6) {
            return attributeInt != 8 ? 0 : 270;
        }
        return 90;
    }

    @Override // cn.admobiletop.adsuyi.c.C0333m, cn.admobiletop.adsuyi.c.I
    public boolean a(G g2) {
        return "file".equals(g2.f4153e.getScheme());
    }

    @Override // cn.admobiletop.adsuyi.c.C0333m, cn.admobiletop.adsuyi.c.I
    public I.a a(G g2, int i2) {
        return new I.a(null, h(g2), A.d.DISK, i(g2.f4153e));
    }
}
