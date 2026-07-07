package org.android.agoo.control;

import com.taobao.accs.ACCSManager;
import com.taobao.accs.IACCSManager;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.AdapterUtilityImpl;
import com.taobao.accs.utl.UTMini;
import java.util.HashMap;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.Config;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f14969a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f14970b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f14971c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f14972d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ boolean f14973e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ NotifManager f14974f;

    public m(NotifManager notifManager, String str, String str2, String str3, String str4, boolean z) {
        this.f14974f = notifManager;
        this.f14969a = str;
        this.f14970b = str2;
        this.f14971c = str3;
        this.f14972d = str4;
        this.f14973e = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            HashMap map = new HashMap();
            String str = this.f14969a;
            if (str != null) {
                map.put("sdkVer", str);
            }
            map.put("thirdTokenType", this.f14970b);
            map.put("token", this.f14971c);
            map.put("appkey", Config.b(NotifManager.mContext));
            map.put("utdid", AdapterUtilityImpl.getDeviceId(NotifManager.mContext));
            String str2 = this.f14972d;
            if (str2 != null) {
                map.put("vendorSdkVersion", str2);
            }
            ALog.d("NotifManager", "report,utdid=" + AdapterUtilityImpl.getDeviceId(NotifManager.mContext) + ",regId=" + this.f14971c + ",type=" + this.f14970b + " sdkVer=" + this.f14969a + " thirdVer=" + this.f14972d, new Object[0]);
            ACCSManager.AccsRequest accsRequest = new ACCSManager.AccsRequest(null, "agooTokenReport", new JSONObject(map).toString().getBytes("UTF-8"), null, null, null, null);
            IACCSManager accsInstance = ACCSManager.getAccsInstance(NotifManager.mContext, Config.b(NotifManager.mContext), Config.d(NotifManager.mContext));
            String strSendData = this.f14973e ? accsInstance.sendData(NotifManager.mContext, accsRequest) : accsInstance.sendPushResponse(NotifManager.mContext, accsRequest, new TaoBaseService.ExtraInfo());
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.i("NotifManager", "reportThirdPushToken,dataId=" + strSendData + ",regId=" + this.f14971c + ",type=" + this.f14970b, new Object[0]);
            }
        } catch (Throwable th) {
            UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, "reportThirdPushToken", AdapterUtilityImpl.getDeviceId(NotifManager.mContext), th.toString());
            if (ALog.isPrintLog(ALog.Level.E)) {
                ALog.e("NotifManager", "[report] is error", th, new Object[0]);
            }
        }
    }
}
