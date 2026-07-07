package com.aliyun.ams.emas.push;

import android.content.Intent;
import android.text.TextUtils;
import c.a.a.a.a.m;
import c.a.a.a.a.n.f;
import com.taobao.accs.data.MsgDistributeService;
import com.taobao.accs.utl.ALog;

/* JADX INFO: loaded from: classes.dex */
public class MsgService extends MsgDistributeService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f f5807b = new f();

    @Override // com.taobao.accs.data.MsgDistributeService, android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        if (intent == null) {
            ALog.d("MPS:MsgService", "intent null", new Object[0]);
            return super.onStartCommand(intent, i2, i3);
        }
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            return super.onStartCommand(intent, i2, i3);
        }
        ALog.d("MPS:MsgService", "MsgService onStartCommand begin...action=" + action, new Object[0]);
        if (!TextUtils.equals(action, m.f813b)) {
            return super.onStartCommand(intent, i2, i3);
        }
        this.f5807b.a(intent, getApplicationContext());
        return 2;
    }
}
