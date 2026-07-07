package c.e.c.u.m;

import androidx.lifecycle.Observer;
import com.chinavisionary.core.app.config.bo.UserInfoVo;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f1872a;

    public /* synthetic */ f(i iVar) {
        this.f1872a = iVar;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object obj) {
        this.f1872a.h((UserInfoVo) obj);
    }
}
