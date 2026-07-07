package c.e.d.y;

import androidx.lifecycle.Observer;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class h implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f2332a;

    public /* synthetic */ h(o oVar) {
        this.f2332a = oVar;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object obj) {
        this.f2332a.handleRequestErr((RequestErrDto) obj);
    }
}
