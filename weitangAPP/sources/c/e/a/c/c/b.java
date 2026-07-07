package c.e.a.c.c;

import com.chinavisionary.core.scan.view.ViewfinderView;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;

/* JADX INFO: loaded from: classes.dex */
public final class b implements ResultPointCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewfinderView f1173a;

    public b(ViewfinderView viewfinderView) {
        this.f1173a = viewfinderView;
    }

    @Override // com.google.zxing.ResultPointCallback
    public void foundPossibleResultPoint(ResultPoint resultPoint) {
        this.f1173a.addPossibleResultPoint(resultPoint);
    }
}
