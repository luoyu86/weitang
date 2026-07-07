package c.e.c.x.d;

import androidx.lifecycle.Observer;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.microtang.me.fragment.EditMeNewFragment;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class o implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ EditMeNewFragment f2077a;

    public /* synthetic */ o(EditMeNewFragment editMeNewFragment) {
        this.f2077a = editMeNewFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object obj) {
        this.f2077a.C((RequestErrDto) obj);
    }
}
