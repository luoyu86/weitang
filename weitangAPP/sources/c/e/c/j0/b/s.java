package c.e.c.j0.b;

import androidx.lifecycle.Observer;
import com.chinavisionary.core.app.net.base.dto.ResponseRowsVo;
import com.chinavisionary.microtang.sign.fragments.RoomSignContractNearbyFragment;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class s implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RoomSignContractNearbyFragment f1614a;

    public /* synthetic */ s(RoomSignContractNearbyFragment roomSignContractNearbyFragment) {
        this.f1614a = roomSignContractNearbyFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object obj) {
        this.f1614a.L1((ResponseRowsVo) obj);
    }
}
