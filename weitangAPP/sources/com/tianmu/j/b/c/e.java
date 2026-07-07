package com.tianmu.j.b.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.tianmu.g.b0;
import com.tianmu.g.r;
import com.tianmu.j.b.c.a;

/* JADX INFO: loaded from: classes2.dex */
public class e<P extends com.tianmu.j.b.c.a> extends f<P> {
    private int A;
    private int B;
    private Bitmap C;
    private Bitmap D;
    private Handler E;
    public ImageView x;
    private String y;
    private boolean z;

    public class a implements b0 {
        public a() {
        }

        @Override // com.tianmu.g.b0
        public void onBitmapFailed(Drawable drawable) {
        }

        @Override // com.tianmu.g.b0
        public void onBitmapLoaded(Bitmap bitmap, r.e eVar) {
            e.this.a(bitmap);
        }

        @Override // com.tianmu.g.b0
        public void onPrepareLoad(Drawable drawable) {
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Bitmap f12293a;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e eVar;
                ImageView imageView;
                if (e.this.C != null) {
                    e.this.C.recycle();
                    e.this.C = null;
                }
                if (e.this.D == null || (imageView = (eVar = e.this).x) == null) {
                    return;
                }
                imageView.setImageBitmap(eVar.D);
            }
        }

        public b(Bitmap bitmap) {
            this.f12293a = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            e eVar = e.this;
            if (eVar.x == null || this.f12293a == null) {
                return;
            }
            boolean zA = com.tianmu.j.b.e.d.a(eVar.A, e.this.B);
            boolean zA2 = com.tianmu.j.b.e.d.a(this.f12293a.getWidth(), this.f12293a.getHeight());
            if (!zA) {
                e.this.C = com.tianmu.biz.utils.j.a(this.f12293a, 0.2f, 30);
            } else if (zA2) {
                e.this.C = com.tianmu.biz.utils.j.a(this.f12293a, 0.2f, 20);
            } else {
                e.this.C = com.tianmu.biz.utils.j.a(this.f12293a, 0.5f, 20);
            }
            if (e.this.C == null) {
                return;
            }
            int i2 = e.this.B;
            int width = (e.this.C.getWidth() * i2) / e.this.C.getHeight();
            try {
                e eVar2 = e.this;
                eVar2.D = Bitmap.createScaledBitmap(eVar2.C, width, i2, false);
                e.this.E.post(new a());
            } catch (Exception unused) {
                e.this.F();
            }
        }
    }

    public e(@NonNull Context context) {
        super(context);
        this.E = new Handler(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        Bitmap bitmap = this.C;
        if (bitmap != null) {
            bitmap.recycle();
            this.C = null;
        }
        Bitmap bitmap2 = this.D;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.D = null;
        }
        Handler handler = this.E;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.E = null;
        }
    }

    public void E() {
        if (this.z) {
            return;
        }
        this.z = true;
        this.A = getWidth();
        int height = getHeight();
        this.B = height;
        int i2 = this.A;
        int[] iArr = this.f12303h;
        if (com.tianmu.j.b.e.d.a(i2, height, iArr[0], iArr[1]) || this.x == null || TextUtils.isEmpty(this.y)) {
            return;
        }
        r.a(getContext()).a(this.y).a(Bitmap.Config.RGB_565).a(new a());
    }

    @Override // com.tianmu.j.b.c.f
    public void o() {
        super.o();
        ImageView imageView = new ImageView(getContext());
        this.x = imageView;
        imageView.setBackgroundColor(this.w);
        this.x.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.x, 0, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // com.tianmu.j.b.c.f
    public void w() {
        super.w();
        F();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bitmap bitmap) {
        com.tianmu.j.b.b.a.c().a().execute(new b(bitmap));
    }

    public void b(String str) {
        this.y = str;
    }

    @Override // com.tianmu.j.b.c.f, com.tianmu.j.b.c.a.InterfaceC0229a
    public void b(int i2, int i3) {
        super.b(i2, i3);
        if (this.f12300e != null) {
            E();
        }
    }
}
