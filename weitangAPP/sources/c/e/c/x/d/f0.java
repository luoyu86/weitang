package c.e.c.x.d;

import androidx.lifecycle.Observer;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.microtang.me.fragment.IDFragment;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f0 implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IDFragment f2042a;

    public /* synthetic */ f0(IDFragment iDFragment) {
        this.f2042a = iDFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object obj) {
        this.f2042a.C((RequestErrDto) obj);
    }
}
