package com.taobao.accs.net;

import android.content.Context;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.common.Constants;
import com.taobao.accs.data.Message;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f10386a;

    public l(j jVar) {
        this.f10386a = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f10386a.t.i("sendAccsHeartbeatMessage");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("dataType", "pingreq");
            jSONObject.put("timeInterval", this.f10386a.o);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        ACCSManager.AccsRequest accsRequest = new ACCSManager.AccsRequest(null, null, jSONObject.toString().getBytes(), UUID.randomUUID().toString());
        accsRequest.setTarget("accs-iot");
        accsRequest.setTargetServiceName("sal");
        j jVar = this.f10386a;
        Context context = jVar.f10354d;
        String packageName = context.getPackageName();
        this.f10386a.f10359i.getAppKey();
        this.f10386a.a(Message.a(jVar, context, packageName, Constants.TARGET_SERVICE, accsRequest, true), true);
    }
}
