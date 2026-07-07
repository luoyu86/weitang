package com.bytedance.sdk.openadsdk.multipro;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.sdk.openadsdk.ITTProvider;
import com.bytedance.sdk.openadsdk.TTAdSdk;

/* JADX INFO: loaded from: classes.dex */
public class TTMultiProvider extends ContentProvider {
    private ITTProvider ok() {
        if (TTAdSdk.getAdManager() != null) {
            return (ITTProvider) TTAdSdk.getAdManager().getExtra(ITTProvider.class, null);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        if (ok() != null) {
            return ok().delete(uri, str, strArr);
        }
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return ok() != null ? ok().getType(uri) : "";
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        if (ok() != null) {
            return ok().insert(uri, contentValues);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        if (ok() != null) {
            return ok().query(uri, strArr, str, strArr2, str2);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        if (ok() != null) {
            return ok().update(uri, contentValues, str, strArr);
        }
        return 0;
    }
}
