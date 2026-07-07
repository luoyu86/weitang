package c.e.c.b0.b;

import androidx.lifecycle.Observer;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.microtang.order.fragment.ServiceOrderListFragment;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class n implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ServiceOrderListFragment f1394a;

    public /* synthetic */ n(ServiceOrderListFragment serviceOrderListFragment) {
        this.f1394a = serviceOrderListFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object obj) {
        this.f1394a.G1((ResponseStateVo) obj);
    }
}
