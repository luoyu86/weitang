package c.e.d.y;

import androidx.lifecycle.Observer;
import com.chinavisionary.paymentlibrary.vo.ResponseFddSignUrlVo;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class k implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f2335a;

    public /* synthetic */ k(s sVar) {
        this.f2335a = sVar;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object obj) {
        this.f2335a.n((ResponseFddSignUrlVo) obj);
    }
}
