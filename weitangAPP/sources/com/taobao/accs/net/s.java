package com.taobao.accs.net;

import android.text.TextUtils;
import anet.channel.IAuth;
import anet.channel.RequestCb;
import anet.channel.bytes.ByteArray;
import anet.channel.statist.RequestStatistic;
import com.taobao.accs.AccsState;
import com.taobao.accs.net.j;
import com.taobao.accs.utl.UtilityImpl;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class s implements RequestCb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IAuth.AuthCallback f10405a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j.a f10406b;

    public s(j.a aVar, IAuth.AuthCallback authCallback) {
        this.f10406b = aVar;
        this.f10405a = authCallback;
    }

    @Override // anet.channel.RequestCb
    public void onDataReceive(ByteArray byteArray, boolean z) {
    }

    @Override // anet.channel.RequestCb
    public void onFinish(int i2, String str, RequestStatistic requestStatistic) {
        if (i2 < 0) {
            this.f10406b.f10384e.e("auth onFinish", "statusCode", Integer.valueOf(i2));
            this.f10405a.onAuthFail(i2, "onFinish auth fail");
        }
    }

    @Override // anet.channel.RequestCb
    public void onResponseCode(int i2, Map<String, List<String>> map) {
        Map<String, String> mapA = UtilityImpl.a(map);
        this.f10406b.f10384e.d("auth", "header", mapA);
        String str = mapA.get("x-at");
        if (!TextUtils.isEmpty(str)) {
            this.f10406b.f10383d.k = str;
        }
        if (i2 == 200) {
            this.f10406b.f10384e.i("auth", "httpStatusCode", Integer.valueOf(i2));
            this.f10405a.onAuthSuccess();
            if (this.f10406b.f10383d instanceof j) {
                ((j) this.f10406b.f10383d).q();
                return;
            }
            return;
        }
        String str2 = mapA.get("s-accs-retcode");
        this.f10406b.f10384e.e("auth", "httpStatusCode", Integer.valueOf(i2));
        AccsState.getInstance().b("re", "auth fail " + str2);
        this.f10405a.onAuthFail(i2, "auth fail");
    }
}
