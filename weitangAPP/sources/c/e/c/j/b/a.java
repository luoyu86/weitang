package c.e.c.j.b;

import androidx.lifecycle.Observer;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.microtang.bill.fragment.BillDetailsFragment;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BillDetailsFragment f1578a;

    public /* synthetic */ a(BillDetailsFragment billDetailsFragment) {
        this.f1578a = billDetailsFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object obj) {
        this.f1578a.T1((RequestErrDto) obj);
    }
}
