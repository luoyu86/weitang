package cn.admobiletop.adsuyi.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import cn.admobiletop.adsuyi.c.A;
import cn.admobiletop.adsuyi.c.I;
import java.io.FileNotFoundException;

/* JADX INFO: loaded from: classes.dex */
public class J extends I {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f4181a;

    public J(Context context) {
        this.f4181a = context;
    }

    public static Bitmap h(Resources resources, int i2, G g2) {
        BitmapFactory.Options optionsF = I.f(g2);
        if (I.d(optionsF)) {
            BitmapFactory.decodeResource(resources, i2, optionsF);
            I.c(g2.f4157i, g2.j, optionsF, g2);
        }
        return BitmapFactory.decodeResource(resources, i2, optionsF);
    }

    @Override // cn.admobiletop.adsuyi.c.I
    public boolean a(G g2) {
        if (g2.f4154f != 0) {
            return true;
        }
        return "android.resource".equals(g2.f4153e.getScheme());
    }

    @Override // cn.admobiletop.adsuyi.c.I
    public I.a a(G g2, int i2) throws FileNotFoundException {
        Resources resourcesE = S.e(this.f4181a, g2);
        return new I.a(h(resourcesE, S.b(resourcesE, g2), g2), A.d.DISK);
    }
}
