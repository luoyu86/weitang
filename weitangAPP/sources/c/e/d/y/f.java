package c.e.d.y;

import androidx.lifecycle.Observer;
import com.chinavisionary.paymentlibrary.vo.ResponseDiscountVo;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class f implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f2330a;

    public /* synthetic */ f(m mVar) {
        this.f2330a = mVar;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object obj) {
        this.f2330a.n((ResponseDiscountVo) obj);
    }
}
