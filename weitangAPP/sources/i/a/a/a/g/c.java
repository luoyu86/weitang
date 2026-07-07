package i.a.a.a.g;

import android.content.Context;
import android.widget.Scroller;

/* JADX INFO: loaded from: classes3.dex */
public class c extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Scroller f14922a;

    public c(Context context) {
        this.f14922a = new Scroller(context);
    }

    @Override // i.a.a.a.g.d
    public boolean computeScrollOffset() {
        return this.f14922a.computeScrollOffset();
    }

    @Override // i.a.a.a.g.d
    public void fling(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        this.f14922a.fling(i2, i3, i4, i5, i6, i7, i8, i9);
    }

    @Override // i.a.a.a.g.d
    public void forceFinished(boolean z) {
        this.f14922a.forceFinished(z);
    }

    @Override // i.a.a.a.g.d
    public int getCurrX() {
        return this.f14922a.getCurrX();
    }

    @Override // i.a.a.a.g.d
    public int getCurrY() {
        return this.f14922a.getCurrY();
    }

    @Override // i.a.a.a.g.d
    public boolean isFinished() {
        return this.f14922a.isFinished();
    }
}
