package c.e.c.j0.b;

import androidx.lifecycle.Observer;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.microtang.sign.fragments.RoomSignMainInfoFragment;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class v implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RoomSignMainInfoFragment f1617a;

    public /* synthetic */ v(RoomSignMainInfoFragment roomSignMainInfoFragment) {
        this.f1617a = roomSignMainInfoFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object obj) {
        this.f1617a.f2((RequestErrDto) obj);
    }
}
