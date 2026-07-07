package com.tencent.mm.opensdk.diffdev.a;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mm.opensdk.diffdev.IDiffDevOAuth;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import com.tencent.mm.opensdk.utils.Log;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements IDiffDevOAuth {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private d f10527d;
    private Handler handler = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<OAuthListener> f10526c = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private OAuthListener f10528e = new b(this);

    public static /* synthetic */ d c(a aVar) {
        aVar.f10527d = null;
        return null;
    }

    @Override // com.tencent.mm.opensdk.diffdev.IDiffDevOAuth
    public final void addListener(OAuthListener oAuthListener) {
        if (this.f10526c.contains(oAuthListener)) {
            return;
        }
        this.f10526c.add(oAuthListener);
    }

    @Override // com.tencent.mm.opensdk.diffdev.IDiffDevOAuth
    public final boolean auth(String str, String str2, String str3, String str4, String str5, OAuthListener oAuthListener) {
        Log.i("MicroMsg.SDK.DiffDevOAuth", "start auth, appId = ".concat(String.valueOf(str)));
        if (str == null || str.length() <= 0 || str2 == null || str2.length() <= 0) {
            Log.d("MicroMsg.SDK.DiffDevOAuth", String.format("auth fail, invalid argument, appId = %s, scope = %s", str, str2));
            return false;
        }
        if (this.handler == null) {
            this.handler = new Handler(Looper.getMainLooper());
        }
        addListener(oAuthListener);
        if (this.f10527d != null) {
            Log.d("MicroMsg.SDK.DiffDevOAuth", "auth, already running, no need to start auth again");
            return true;
        }
        d dVar = new d(str, str2, str3, str4, str5, this.f10528e);
        this.f10527d = dVar;
        if (Build.VERSION.SDK_INT >= 11) {
            dVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        } else {
            dVar.execute(new Void[0]);
        }
        return true;
    }

    @Override // com.tencent.mm.opensdk.diffdev.IDiffDevOAuth
    public final void detach() {
        Log.i("MicroMsg.SDK.DiffDevOAuth", "detach");
        this.f10526c.clear();
        stopAuth();
    }

    @Override // com.tencent.mm.opensdk.diffdev.IDiffDevOAuth
    public final void removeAllListeners() {
        this.f10526c.clear();
    }

    @Override // com.tencent.mm.opensdk.diffdev.IDiffDevOAuth
    public final void removeListener(OAuthListener oAuthListener) {
        this.f10526c.remove(oAuthListener);
    }

    @Override // com.tencent.mm.opensdk.diffdev.IDiffDevOAuth
    public final boolean stopAuth() {
        boolean zA;
        Log.i("MicroMsg.SDK.DiffDevOAuth", "stopAuth");
        try {
            d dVar = this.f10527d;
            zA = dVar == null ? true : dVar.a();
        } catch (Exception e2) {
            Log.w("MicroMsg.SDK.DiffDevOAuth", "stopAuth fail, ex = " + e2.getMessage());
            zA = false;
        }
        this.f10527d = null;
        return zA;
    }
}
