package com.taobao.accs.net;

import android.content.Intent;
import com.taobao.accs.common.Constants;
import com.taobao.accs.dispatch.IntentDispatch;
import com.taobao.accs.utl.AdapterUtilityImpl;

/* JADX INFO: loaded from: classes2.dex */
public class v implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u f10408a;

    public v(u uVar) {
        this.f10408a = uVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        String packageName = this.f10408a.f10369a.getPackageName();
        Intent intent = new Intent();
        intent.setPackage(packageName);
        intent.setAction(Constants.ACTION_COMMAND);
        intent.putExtra("command", 201);
        String str = AdapterUtilityImpl.channelService;
        intent.setClassName(packageName, str);
        IntentDispatch.dispatchIntent(this.f10408a.f10369a.getApplicationContext(), intent, str);
    }
}
