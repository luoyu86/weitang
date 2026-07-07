package com.ss.android.downloadlib.addownload;

import android.net.Uri;
import android.text.TextUtils;
import com.ss.android.download.api.download.DownloadModel;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class kf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<String, String> f9808a;
    private final ConcurrentHashMap<String, String> ok;

    public static class ok {
        private static kf ok = new kf();
    }

    private String bl(String str) {
        try {
            Uri uri = Uri.parse(str);
            String scheme = uri.getScheme();
            String lastPathSegment = uri.getLastPathSegment();
            if (!TextUtils.equals("https", scheme) || !lastPathSegment.endsWith(".apk")) {
                return null;
            }
            this.ok.put(str, lastPathSegment);
            return lastPathSegment;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static kf ok() {
        return ok.ok;
    }

    public void a(String str) {
        Iterator<Map.Entry<String, String>> it = this.f9808a.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> next = it.next();
            if (TextUtils.equals(next.getValue(), str)) {
                it.remove();
                this.ok.remove(next.getKey());
            }
        }
    }

    private kf() {
        this.ok = new ConcurrentHashMap<>();
        this.f9808a = new ConcurrentHashMap<>();
    }

    public void ok(String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || this.f9808a.containsKey(str2)) {
            return;
        }
        this.f9808a.put(str2, str);
    }

    public String ok(String str) {
        if (TextUtils.isEmpty(str) || this.f9808a.isEmpty() || !this.f9808a.containsKey(str)) {
            return null;
        }
        String strBl = bl(str);
        if (this.ok.containsValue(strBl)) {
            for (Map.Entry<String, String> entry : this.ok.entrySet()) {
                if (TextUtils.equals(entry.getValue(), strBl)) {
                    String str2 = this.f9808a.get(entry.getKey());
                    this.f9808a.put(str, str2);
                    if (!this.ok.containsKey(str)) {
                        this.ok.put(str, strBl);
                    }
                    return str2;
                }
            }
        }
        return this.f9808a.get(str);
    }

    public String ok(DownloadModel downloadModel) {
        String strBl = bl(downloadModel.getDownloadUrl());
        if (strBl == null || TextUtils.isEmpty(strBl)) {
            return null;
        }
        String strN = com.ss.android.socialbase.downloader.q.kf.n(strBl + downloadModel.getPackageName());
        this.f9808a.put(downloadModel.getDownloadUrl(), strN);
        return strN;
    }
}
