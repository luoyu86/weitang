package c.e.d.y;

import androidx.lifecycle.Observer;
import com.chinavisionary.paymentlibrary.vo.ResponseDiscountResultVo;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class e implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f2329a;

    public /* synthetic */ e(m mVar) {
        this.f2329a = mVar;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object obj) {
        this.f2329a.q((ResponseDiscountResultVo) obj);
    }
}
