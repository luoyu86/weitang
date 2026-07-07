package c.e.d.y;

import androidx.lifecycle.Observer;
import com.chinavisionary.paymentlibrary.vo.ResponseFoodVo;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class b implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f2326a;

    public /* synthetic */ b(m mVar) {
        this.f2326a = mVar;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object obj) {
        this.f2326a.p((ResponseFoodVo) obj);
    }
}
