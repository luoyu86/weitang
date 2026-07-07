package c.e.c.y.b;

import androidx.lifecycle.Observer;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.microtang.merchant.fragment.FoodSpecFragment;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class i implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FoodSpecFragment f2233a;

    public /* synthetic */ i(FoodSpecFragment foodSpecFragment) {
        this.f2233a = foodSpecFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object obj) {
        this.f2233a.C((RequestErrDto) obj);
    }
}
