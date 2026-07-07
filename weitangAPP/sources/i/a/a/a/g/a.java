package i.a.a.a.g;

import android.annotation.TargetApi;
import android.content.Context;
import android.widget.OverScroller;

/* JADX INFO: loaded from: classes3.dex */
@TargetApi(9)
public class a extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OverScroller f14920a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f14921b = false;

    public a(Context context) {
        this.f14920a = new OverScroller(context);
    }

    @Override // i.a.a.a.g.d
    public boolean computeScrollOffset() {
        if (this.f14921b) {
            this.f14920a.computeScrollOffset();
            this.f14921b = false;
        }
        return this.f14920a.computeScrollOffset();
    }

    @Override // i.a.a.a.g.d
    public void fling(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        this.f14920a.fling(i2, i3, i4, i5, i6, i7, i8, i9, i10, i11);
    }

    @Override // i.a.a.a.g.d
    public void forceFinished(boolean z) {
        this.f14920a.forceFinished(z);
    }

    @Override // i.a.a.a.g.d
    public int getCurrX() {
        return this.f14920a.getCurrX();
    }

    @Override // i.a.a.a.g.d
    public int getCurrY() {
        return this.f14920a.getCurrY();
    }

    @Override // i.a.a.a.g.d
    public boolean isFinished() {
        return this.f14920a.isFinished();
    }
}
