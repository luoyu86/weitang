package c.e.c.v.f;

import com.chinavisionary.core.app.config.bo.AppConfigExtVo;
import com.chinavisionary.core.app.config.bo.AppUpdateVo;
import com.chinavisionary.core.app.net.base.dto.NewResponseRowsVo;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.main.fragments.AppAlertFragment;
import com.chinavisionary.microtang.main.fragments.AppContractCancelAlertFragment;
import com.chinavisionary.microtang.main.fragments.VersionUpdateFragment;
import com.chinavisionary.twlib.open.bo.AlertMessageVo;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes.dex */
public class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public z f1927a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Long f1928b = 5000L;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ConcurrentMap<String, Long> f1929c = new ConcurrentHashMap();

    public a0(z zVar) {
        this.f1927a = zVar;
    }

    public final boolean a(String str) {
        if (c.e.a.d.x.isNotNull(str)) {
            Long lValueOf = Long.valueOf(System.currentTimeMillis());
            if (this.f1929c.containsKey(str)) {
                Long l = this.f1929c.get(str);
                return l == null || lValueOf.longValue() - l.longValue() > this.f1928b.longValue();
            }
            this.f1929c.put(str, lValueOf);
        }
        return true;
    }

    public final String b() {
        return c.e.a.d.x.getString(R.string.tip_app_protocol_msg);
    }

    public AlertMessageVo c() {
        AlertMessageVo alertMessageVo = new AlertMessageVo();
        alertMessageVo.setMessageType(Integer.valueOf(AlertMessageVo.TYPE_APP_NOT_NETWORK));
        alertMessageVo.setForce(Boolean.TRUE);
        alertMessageVo.setConfirmText(c.e.a.d.x.getString(R.string.tip_open));
        alertMessageVo.setCancelText(c.e.a.d.x.getString(R.string.tip_exit_app));
        alertMessageVo.setTitle(c.e.a.d.x.getString(R.string.title_alert_tip));
        alertMessageVo.setContent(c.e.a.d.x.getString(R.string.tip_network_unavailable_open_network));
        return alertMessageVo;
    }

    public void d(NewResponseRowsVo<AlertMessageVo> newResponseRowsVo, boolean z) {
        c.e.c.m0.c.getInstance().setLateFeeAlertMessageVo(null);
        c.e.c.m0.c.getInstance().setBillAlertMessageVo(null);
        if (newResponseRowsVo == null || newResponseRowsVo.getRows() == null) {
            return;
        }
        List<AlertMessageVo> rows = newResponseRowsVo.getRows();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (!rows.isEmpty()) {
            for (AlertMessageVo alertMessageVo : rows) {
                if (alertMessageVo != null && a(alertMessageVo.getMessageKey())) {
                    Integer messageType = alertMessageVo.getMessageType();
                    if (messageType != null && messageType.intValue() == 0) {
                        Boolean force = alertMessageVo.getForce();
                        if (force != null) {
                            c.e.a.d.q.d("MainAlertManager", "handlerAlertMessage force = " + force);
                            if (force.booleanValue()) {
                                arrayList.add(alertMessageVo);
                            } else {
                                arrayList2.add(alertMessageVo);
                            }
                        } else {
                            arrayList2.add(alertMessageVo);
                        }
                        c.e.a.d.q.d(a0.class.getSimpleName(), "handlerAlertMessage rent msg");
                    } else if (!z) {
                        e(alertMessageVo);
                    }
                }
            }
        }
        c.e.c.m0.c.getInstance().setLateFeeAlertMessageVo(arrayList);
        c.e.c.m0.c.getInstance().setBillAlertMessageVo(arrayList2);
    }

    public final void e(AlertMessageVo alertMessageVo) {
        if (alertMessageVo == null || !c.e.a.d.x.isNotNull(alertMessageVo.getTitle())) {
            return;
        }
        j(AppAlertFragment.getInstance(alertMessageVo), alertMessageVo.getForce() == null ? false : alertMessageVo.getForce().booleanValue());
    }

    public void f(AppUpdateVo appUpdateVo, int i2) {
        if (appUpdateVo != null) {
            int version = appUpdateVo.getVersion();
            int minVersion = appUpdateVo.getMinVersion();
            boolean zIsForceUpdate = appUpdateVo.isForceUpdate();
            boolean z = i2 < minVersion;
            if (i2 < version || z) {
                if (z) {
                    zIsForceUpdate = true;
                }
                if (zIsForceUpdate) {
                    c.e.a.d.w.getInstance().putBoolean("isAutoOpenDoorKey", false);
                }
                c.e.a.d.q.d(a0.class.getSimpleName(), "handlerAppVersionUpdate isForceUpdate = " + zIsForceUpdate);
                if (c.e.a.d.v.getInstance().isRepeatedlyAction("VersionUpdateFragment", 2000)) {
                    return;
                }
                j(VersionUpdateFragment.getInstance(appUpdateVo.getRemark(), appUpdateVo.getDownloadUrl(), zIsForceUpdate), zIsForceUpdate);
            }
        }
    }

    public void g(AlertMessageVo alertMessageVo) {
        c.e.a.d.q.d("MainAlertManager", "handlerCancelContractAlertMessage alertMessageVo");
        if (alertMessageVo == null || !c.e.a.d.x.isNotNull(alertMessageVo.getTitle())) {
            return;
        }
        j(AppContractCancelAlertFragment.getInstance(alertMessageVo), true);
    }

    public final boolean h() {
        return c.e.a.d.w.getInstance().getBoolean("isInitAppKey", true);
    }

    public void i(AppConfigExtVo appConfigExtVo) {
        if (h()) {
            AlertMessageVo alertMessageVo = new AlertMessageVo();
            alertMessageVo.setMessageType(Integer.valueOf(AlertMessageVo.TYPE_APP_PROTOCOL));
            alertMessageVo.setForce(Boolean.TRUE);
            alertMessageVo.setForwardType(1);
            alertMessageVo.setTitle(c.e.a.d.x.getString(R.string.wt_private_protocol));
            alertMessageVo.setConfirmText(c.e.a.d.x.getString(R.string.title_agree));
            alertMessageVo.setCancelText(c.e.a.d.x.getString(R.string.title_not_use));
            alertMessageVo.setHref(c.e.a.d.x.getNotNullStr(appConfigExtVo != null ? appConfigExtVo.getPrivacyPolicyUrl() : AlertMessageVo.PRIVACY_URL, AlertMessageVo.PRIVACY_URL));
            alertMessageVo.setContent(b());
            j(AppAlertFragment.getInstance(alertMessageVo), alertMessageVo.getForce() == null ? false : alertMessageVo.getForce().booleanValue());
        }
    }

    public final void j(BaseFragment baseFragment, boolean z) {
        z zVar = this.f1927a;
        if (zVar != null) {
            zVar.addFragmentIsAddBackStack(baseFragment, z);
        }
    }
}
