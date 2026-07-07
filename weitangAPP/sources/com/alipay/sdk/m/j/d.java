package com.alipay.sdk.m.j;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.alipay.sdk.m.m.a;
import com.alipay.sdk.m.u.n;
import java.util.Collections;
import java.util.List;
import org.android.agoo.common.AgooConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f5399a = 1010;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static a f5400b;

    public interface a {
        void a(boolean z, JSONObject jSONObject, String str);
    }

    public static boolean a(com.alipay.sdk.m.s.a aVar, Context context) {
        return n.a(aVar, context, (List<a.b>) Collections.singletonList(new a.b(AgooConstants.TAOBAO_PACKAGE, 0, "")), false);
    }

    public static boolean a(com.alipay.sdk.m.s.a aVar, Activity activity, int i2, String str, String str2, a aVar2) {
        try {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.u0);
            activity.startActivityForResult(new Intent(str2, Uri.parse(str)), i2);
            f5400b = aVar2;
            return true;
        } catch (Throwable th) {
            aVar2.a(false, null, "UNKNOWN_ERROR");
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.y0, th);
            return false;
        }
    }

    public static boolean a(com.alipay.sdk.m.s.a aVar, int i2, int i3, Intent intent) {
        if (i2 != 1010 || intent == null) {
            return false;
        }
        a aVar2 = f5400b;
        if (aVar2 == null) {
            return true;
        }
        f5400b = null;
        if (i3 == -1) {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.x0, intent.toUri(1));
            aVar2.a(true, n.a(intent), "OK");
        } else if (i3 != 0) {
            com.alipay.sdk.m.k.a.b(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.w0, "" + i3);
        } else {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.v0, intent.toUri(1));
            aVar2.a(false, null, "CANCELED");
        }
        return true;
    }
}
