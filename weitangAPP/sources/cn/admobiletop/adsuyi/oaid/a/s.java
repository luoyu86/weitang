package cn.admobiletop.adsuyi.oaid.a;

import android.annotation.SuppressLint;
import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import cn.admobiletop.adsuyi.oaid.IGetter;
import com.taobao.accs.common.Constants;

/* JADX INFO: loaded from: classes.dex */
public class s implements cn.admobiletop.adsuyi.oaid.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f4327a;

    public s(Context context) {
        this.f4327a = context;
    }

    @Override // cn.admobiletop.adsuyi.oaid.b
    @SuppressLint({"AnnotateVersionCheck"})
    public boolean a() {
        return Build.VERSION.SDK_INT >= 29;
    }

    @Override // cn.admobiletop.adsuyi.oaid.b
    public void a(IGetter iGetter) {
        if (this.f4327a == null || iGetter == null) {
            return;
        }
        if (!a()) {
            cn.admobiletop.adsuyi.oaid.d.a("Only supports Android 10.0 and above for Nubia");
            iGetter.onOAIDGetError(new cn.admobiletop.adsuyi.oaid.c("Only supports Android 10.0 and above for Nubia"));
            return;
        }
        try {
            ContentProviderClient contentProviderClientAcquireContentProviderClient = this.f4327a.getContentResolver().acquireContentProviderClient(Uri.parse("content://cn.nubia.identity/identity"));
            if (contentProviderClientAcquireContentProviderClient == null) {
                return;
            }
            Bundle bundleCall = contentProviderClientAcquireContentProviderClient.call("getOAID", null, null);
            if (Build.VERSION.SDK_INT >= 24) {
                contentProviderClientAcquireContentProviderClient.close();
            } else {
                contentProviderClientAcquireContentProviderClient.release();
            }
            if (bundleCall == null) {
                throw new cn.admobiletop.adsuyi.oaid.c("OAID query failed: bundle is null");
            }
            String string = bundleCall.getInt("code", -1) == 0 ? bundleCall.getString("id") : null;
            if (string == null || string.length() == 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("OAID query failed: ");
                sb.append(bundleCall.getString(Constants.SHARED_MESSAGE_ID_FILE));
                throw new cn.admobiletop.adsuyi.oaid.c(sb.toString());
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("OAID query success: ");
            sb2.append(string);
            cn.admobiletop.adsuyi.oaid.d.a(sb2.toString());
            iGetter.onOAIDGetComplete(string);
        } catch (Exception e2) {
            cn.admobiletop.adsuyi.oaid.d.a(e2);
            iGetter.onOAIDGetError(e2);
        }
    }
}
