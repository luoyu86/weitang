package c.e.c.u.m;

import androidx.lifecycle.Observer;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f1867a;

    public /* synthetic */ a(i iVar) {
        this.f1867a = iVar;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object obj) {
        this.f1867a.i((RequestErrDto) obj);
    }
}
