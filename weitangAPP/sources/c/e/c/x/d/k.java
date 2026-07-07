package c.e.c.x.d;

import androidx.lifecycle.Observer;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.microtang.me.fragment.EditMeNewFragment;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class k implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ EditMeNewFragment f2061a;

    public /* synthetic */ k(EditMeNewFragment editMeNewFragment) {
        this.f2061a = editMeNewFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object obj) {
        this.f2061a.O1((ResponseStateVo) obj);
    }
}
