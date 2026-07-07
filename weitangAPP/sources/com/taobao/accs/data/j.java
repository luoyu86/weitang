package com.taobao.accs.data;

import android.content.Intent;
import android.text.TextUtils;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;

/* JADX INFO: loaded from: classes2.dex */
public class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Intent f10305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MsgDistributeService f10306b;

    public j(MsgDistributeService msgDistributeService, Intent intent) {
        this.f10306b = msgDistributeService;
        this.f10305a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        ALog.i("MsgDistributeService", "onStartCommand send message", new Object[0]);
        ACCSManager.AccsRequest accsRequest = (ACCSManager.AccsRequest) this.f10305a.getSerializableExtra(Constants.KEY_SEND_REQDATA);
        String stringExtra = this.f10305a.getStringExtra("packageName");
        String stringExtra2 = this.f10305a.getStringExtra(Constants.KEY_APP_KEY);
        String stringExtra3 = this.f10305a.getStringExtra(Constants.KEY_CONFIG_TAG);
        if (TextUtils.isEmpty(stringExtra3)) {
            stringExtra3 = stringExtra2;
        }
        ACCSManager.getAccsInstance(this.f10306b.getApplicationContext(), stringExtra2, stringExtra3).sendRequest(this.f10306b.getApplicationContext(), accsRequest, stringExtra, true);
    }
}
