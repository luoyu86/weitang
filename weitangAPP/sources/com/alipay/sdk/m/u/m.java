package com.alipay.sdk.m.u;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.alipay.sdk.app.EnvUtils;
import org.android.agoo.common.AgooConstants;

/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f5710a = "content://com.alipay.android.app.settings.data.ServerProvider/current_server";

    public static String a(Context context) {
        Cursor cursorQuery = context.getContentResolver().query(Uri.parse(f5710a), null, null, null, null);
        if (cursorQuery != null && cursorQuery.getCount() > 0) {
            string = cursorQuery.moveToFirst() ? cursorQuery.getString(cursorQuery.getColumnIndex(AgooConstants.OPEN_URL)) : null;
            cursorQuery.close();
        }
        return string;
    }

    public static String b(Context context) {
        if (EnvUtils.isPreSandBox()) {
            return com.alipay.sdk.m.l.a.f5437b;
        }
        if (EnvUtils.isNewSanBox()) {
            return com.alipay.sdk.m.l.a.f5438c;
        }
        if (context == null) {
            return com.alipay.sdk.m.l.a.f5436a;
        }
        String str = com.alipay.sdk.m.l.a.f5436a;
        return TextUtils.isEmpty(str) ? com.alipay.sdk.m.l.a.f5436a : str;
    }
}
