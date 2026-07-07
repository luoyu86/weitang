package com.tianmu.j.a;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tianmu.biz.widget.a;
import com.tianmu.c.f.w0;
import com.tianmu.j.a.b.b;
import com.tianmu.j.a.b.d;
import com.tianmu.j.a.b.e;
import com.tianmu.j.b.a.c;

/* JADX INFO: loaded from: classes2.dex */
public class a extends com.tianmu.j.b.a.a {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f12238q;
    private a.InterfaceC0188a r;

    public a(@NonNull Context context) {
        this(context, null);
    }

    private void f(int i2) {
        a.InterfaceC0188a interfaceC0188a = this.r;
        if (interfaceC0188a == null) {
            return;
        }
        if (i2 == -1) {
            interfaceC0188a.onVideoError();
            return;
        }
        if (i2 == 2) {
            interfaceC0188a.onVideoPrepared(k());
            return;
        }
        if (i2 == 3) {
            interfaceC0188a.onVideoStart();
        } else if (i2 == 4) {
            interfaceC0188a.onVideoPause(j());
        } else {
            if (i2 != 5) {
                return;
            }
            interfaceC0188a.onVideoCompletion(j());
        }
    }

    private int j() {
        return (int) this.f12261a.j();
    }

    private int k() {
        return (int) this.f12261a.h();
    }

    public void a(a.InterfaceC0188a interfaceC0188a) {
        this.r = interfaceC0188a;
    }

    @Override // com.tianmu.j.b.a.a
    public void a(boolean z, Animation animation) {
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0029  */
    @Override // com.tianmu.j.b.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(int r5) {
        /*
            r4 = this;
            super.b(r5)
            r0 = -1
            r1 = 7
            if (r5 == r0) goto L29
            r0 = 6
            r2 = 1
            if (r5 == r2) goto L1f
            r3 = 2
            if (r5 == r3) goto L29
            r3 = 3
            if (r5 == r3) goto L19
            r3 = 4
            if (r5 == r3) goto L29
            if (r5 == r0) goto L1f
            if (r5 == r1) goto L29
            goto L2e
        L19:
            com.tianmu.j.b.a.b r0 = r4.f12261a
            r0.b()
            goto L2e
        L1f:
            if (r5 != r0) goto L23
            r4.f12238q = r2
        L23:
            com.tianmu.j.b.a.b r0 = r4.f12261a
            r0.f()
            goto L2e
        L29:
            if (r5 != r1) goto L2e
            r0 = 0
            r4.f12238q = r0
        L2e:
            r4.f(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tianmu.j.a.a.b(int):void");
    }

    @Override // com.tianmu.j.b.a.a
    public int c() {
        return w0.f11532a;
    }

    @Override // com.tianmu.j.b.a.a
    public void e() {
        super.e();
    }

    public a(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void a(String str, com.tianmu.j.a.c.a aVar) {
        c aVar2 = new com.tianmu.j.a.b.a(getContext());
        c bVar = new b(getContext());
        d dVar = new d(getContext());
        dVar.a(str);
        a(aVar2, bVar, dVar, new com.tianmu.j.a.b.c(getContext()));
        if (aVar != null) {
            e eVar = new e(getContext());
            eVar.a(aVar);
            a(eVar);
        }
    }

    @Override // com.tianmu.j.b.a.a
    public void c(int i2) {
        super.c(i2);
        if (i2 == 10) {
            setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        }
        if (this.f12262b != null) {
            a();
        }
    }

    public a(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2) {
        super(context, attributeSet, i2);
    }

    @Override // com.tianmu.j.b.a.a
    public void a(int i2, int i3) {
        a.InterfaceC0188a interfaceC0188a = this.r;
        if (interfaceC0188a != null) {
            interfaceC0188a.onVideoPosition(i3, i2);
        }
    }
}
