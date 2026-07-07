package c.e.c.x.d;

import androidx.lifecycle.Observer;
import com.chinavisionary.microtang.me.fragment.EditMeNewFragment;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class i implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ EditMeNewFragment f2053a;

    public /* synthetic */ i(EditMeNewFragment editMeNewFragment) {
        this.f2053a = editMeNewFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object obj) {
        this.f2053a.M1((String) obj);
    }
}
