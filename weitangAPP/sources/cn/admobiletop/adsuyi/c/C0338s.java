package cn.admobiletop.adsuyi.c;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import cn.admobiletop.adsuyi.c.A;

/* JADX INFO: renamed from: cn.admobiletop.adsuyi.c.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0338s extends AbstractC0321a<ImageView> {
    public InterfaceC0332l m;

    public C0338s(A a2, ImageView imageView, G g2, int i2, int i3, int i4, Drawable drawable, String str, Object obj, InterfaceC0332l interfaceC0332l, boolean z) {
        super(a2, imageView, g2, i2, i3, i4, drawable, str, obj, z);
        this.m = interfaceC0332l;
    }

    @Override // cn.admobiletop.adsuyi.c.AbstractC0321a
    public void a(Bitmap bitmap, A.d dVar) {
        if (bitmap == null) {
            throw new AssertionError(String.format("Attempted to complete action with no result!\n%s", this));
        }
        ImageView imageView = (ImageView) this.f4210c.get();
        if (imageView == null) {
            return;
        }
        A a2 = this.f4208a;
        D.c(imageView, a2.f4113g, bitmap, dVar, this.f4211d, a2.o);
        InterfaceC0332l interfaceC0332l = this.m;
        if (interfaceC0332l != null) {
            interfaceC0332l.onSuccess();
        }
    }

    @Override // cn.admobiletop.adsuyi.c.AbstractC0321a
    public void b() {
        ImageView imageView = (ImageView) this.f4210c.get();
        if (imageView == null) {
            return;
        }
        int i2 = this.f4214g;
        if (i2 != 0) {
            imageView.setImageResource(i2);
        } else {
            Drawable drawable = this.f4215h;
            if (drawable != null) {
                imageView.setImageDrawable(drawable);
            }
        }
        InterfaceC0332l interfaceC0332l = this.m;
        if (interfaceC0332l != null) {
            interfaceC0332l.onError();
        }
    }

    @Override // cn.admobiletop.adsuyi.c.AbstractC0321a
    public void a() {
        super.a();
        if (this.m != null) {
            this.m = null;
        }
    }
}
