package com.tencent.mm.opensdk.channel.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.d;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: com.tencent.mm.opensdk.channel.a.a$a, reason: collision with other inner class name */
    public static class C0179a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f10524a;
        public String action;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f10525b;
        public Bundle bundle;
        public String content;
    }

    public static boolean a(Context context, C0179a c0179a) {
        String str;
        if (context == null) {
            str = "send fail, invalid argument";
        } else {
            if (!d.b(c0179a.action)) {
                String str2 = null;
                if (!d.b(c0179a.f10524a)) {
                    str2 = c0179a.f10524a + ".permission.MM_MESSAGE";
                }
                Intent intent = new Intent(c0179a.action);
                Bundle bundle = c0179a.bundle;
                if (bundle != null) {
                    intent.putExtras(bundle);
                }
                String packageName = context.getPackageName();
                intent.putExtra(ConstantsAPI.SDK_VERSION, Build.SDK_INT);
                intent.putExtra(ConstantsAPI.APP_PACKAGE, packageName);
                intent.putExtra(ConstantsAPI.CONTENT, c0179a.content);
                intent.putExtra(ConstantsAPI.APP_SUPORT_CONTENT_TYPE, c0179a.f10525b);
                intent.putExtra(ConstantsAPI.CHECK_SUM, b.a(c0179a.content, Build.SDK_INT, packageName));
                context.sendBroadcast(intent, str2);
                Log.d("MicroMsg.SDK.MMessage", "send mm message, intent=" + intent + ", perm=" + str2);
                return true;
            }
            str = "send fail, action is null";
        }
        Log.e("MicroMsg.SDK.MMessage", str);
        return false;
    }
}
