package c.e.c.x.e;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.chinavisionary.core.app.config.bo.AppUpdateVo;
import com.chinavisionary.core.app.net.version.model.AppVersionModel;
import com.chinavisionary.microtang.main.fragments.VersionUpdateFragment;

/* JADX INFO: loaded from: classes.dex */
public class j0 extends b0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AppVersionModel f2158b;

    public j0(g0 g0Var) {
        super(g0Var);
        e();
    }

    public final void c(AppUpdateVo appUpdateVo) {
        g0 g0Var = this.f2124a;
        if (g0Var != null) {
            g0Var.hideAlertLoading();
            if (appUpdateVo != null) {
                int appVersion = c.e.a.a.b.getInstance().getAppVersion(this.f2124a.getCurrentActivity());
                int version = appUpdateVo.getVersion();
                int minVersion = appUpdateVo.getMinVersion();
                boolean zIsForceUpdate = appUpdateVo.isForceUpdate();
                boolean z = appVersion < minVersion;
                if (appVersion >= version && !z) {
                    c.e.a.d.q.d(j0.class.getSimpleName(), "is new version");
                    return;
                }
                if (z) {
                    zIsForceUpdate = true;
                }
                if (zIsForceUpdate) {
                    c.e.a.d.w.getInstance().putBoolean("isAutoOpenDoorKey", false);
                }
                c.e.a.d.q.d(j0.class.getSimpleName(), "VersionUpdateFragment handlerAppVersionUpdate");
                if (c.e.a.d.v.getInstance().isRepeatedlyAction("VersionUpdateFragment", 2000)) {
                    return;
                }
                this.f2124a.addFragment(VersionUpdateFragment.getInstance(appUpdateVo.getRemark(), appUpdateVo.getDownloadUrl(), zIsForceUpdate), !zIsForceUpdate);
            }
        }
    }

    public final void e() {
        g0 g0Var = this.f2124a;
        if (g0Var != null) {
            FragmentActivity currentActivity = g0Var.getCurrentActivity();
            AppVersionModel appVersionModel = (AppVersionModel) ViewModelProviders.of(currentActivity).get(AppVersionModel.class);
            this.f2158b = appVersionModel;
            appVersionModel.getUpdateVoMutableLiveData().observe(currentActivity, new Observer() { // from class: c.e.c.x.e.c
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f2125a.c((AppUpdateVo) obj);
                }
            });
        }
    }
}
