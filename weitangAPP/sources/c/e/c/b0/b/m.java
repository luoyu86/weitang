package c.e.c.b0.b;

import androidx.lifecycle.Observer;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.microtang.order.fragment.ServiceOrderListFragment;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class m implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ServiceOrderListFragment f1393a;

    public /* synthetic */ m(ServiceOrderListFragment serviceOrderListFragment) {
        this.f1393a = serviceOrderListFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object obj) {
        this.f1393a.H1((RequestErrDto) obj);
    }
}
