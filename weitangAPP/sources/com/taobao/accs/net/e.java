package com.taobao.accs.net;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.client.AdapterGlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.dispatch.IntentDispatch;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.AdapterUtilityImpl;
import com.taobao.accs.utl.UtilityImpl;

/* JADX INFO: loaded from: classes2.dex */
public class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f10365a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f10366b;

    public e(b bVar, Context context) {
        this.f10366b = bVar;
        this.f10365a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (UtilityImpl.l(this.f10365a)) {
            ALog.d(this.f10366b.d(), "startChannelService", new Object[0]);
            Intent intent = new Intent(Constants.ACTION_START_SERVICE);
            intent.putExtra(Constants.KEY_APP_KEY, this.f10366b.i());
            intent.putExtra(Constants.KEY_TTID, this.f10366b.f10351a);
            intent.putExtra("packageName", this.f10365a.getPackageName());
            intent.putExtra("app_sercet", this.f10366b.f10359i.getAppSecret());
            intent.putExtra(Constants.KEY_MODE, AccsClientConfig.mEnv);
            intent.putExtra(Constants.KEY_CONFIG_TAG, this.f10366b.m);
            String packageName = this.f10365a.getPackageName();
            String str = AdapterUtilityImpl.channelService;
            intent.setClassName(packageName, str);
            IntentDispatch.dispatchIntent(this.f10365a, intent, str);
            Intent intent2 = new Intent();
            intent2.setAction("org.agoo.android.intent.action.REPORT");
            intent2.setPackage(this.f10365a.getPackageName());
            String agooCustomServiceName = AdapterGlobalClientInfo.getAgooCustomServiceName(this.f10365a);
            if (TextUtils.isEmpty(agooCustomServiceName)) {
                return;
            }
            intent2.setClassName(this.f10365a.getPackageName(), agooCustomServiceName);
            IntentDispatch.dispatchIntent(this.f10365a, intent2, agooCustomServiceName);
        }
    }
}
