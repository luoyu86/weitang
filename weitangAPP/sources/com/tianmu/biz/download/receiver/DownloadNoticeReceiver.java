package com.tianmu.biz.download.receiver;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tianmu.ad.activity.DownloadListActivity;
import com.tianmu.biz.download.service.DownloadNoticeService;
import com.tianmu.biz.utils.k;
import com.tianmu.c.h.d.d;
import com.tianmu.c.h.e.a;

/* JADX INFO: loaded from: classes2.dex */
public class DownloadNoticeReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private DownloadNoticeService f10836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10837b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f10838c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f10839d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f10840e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f10841f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f10842g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f10843h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f10844i;
    private final String j;
    private final String k;
    private final String l;
    private final String m;
    private final String n;
    private final String o;

    public DownloadNoticeReceiver(DownloadNoticeService downloadNoticeService, String str, Service service) {
        this.f10836a = downloadNoticeService;
        String str2 = str + ".tianmu.action.download.failed";
        this.f10837b = str2;
        String str3 = str + ".tianmu.action.download.success";
        this.f10838c = str3;
        String str4 = str + ".tianmu.action.download.installed";
        this.f10839d = str4;
        String str5 = str + ".tianmu.action.download.loading";
        this.f10840e = str5;
        String str6 = str + ".tianmu.action.download.opened";
        this.f10841f = str6;
        String str7 = str + ".tianmu.action.download.idel";
        this.f10842g = str7;
        String str8 = str + ".tianmu.action.download.pause";
        this.f10843h = str8;
        String str9 = str + ".tianmu.action.download.start";
        this.f10844i = str9;
        String str10 = str + ".tianmu.action.download.stop";
        this.j = str10;
        String str11 = str + ".tianmu.action.download.progress.update";
        this.k = str11;
        String str12 = str + ".tianmu.action.download.notice.click";
        this.l = str12;
        String str13 = str + ".tianmu.action.download.notice.stop.click";
        this.m = str13;
        String str14 = str + ".tianmu.action.download.notice.start.click";
        this.n = str14;
        String str15 = str + ".tianmu.action.download.notice.pause.click";
        this.o = str15;
        service.registerReceiver(this, a.a(str3, str4, str2, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15));
        k.a(this, str3, str4, str2, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15);
    }

    public void a() {
        k.a(this);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        DownloadNoticeService downloadNoticeService;
        String action = intent.getAction();
        String stringExtra = intent.getStringExtra("extraCurrentAdKey");
        String stringExtra2 = intent.getStringExtra("extraAppPackageName");
        if (!TextUtils.isEmpty(stringExtra2)) {
            stringExtra = stringExtra2;
        }
        if (TextUtils.isEmpty(action)) {
            return;
        }
        if (this.f10837b.equals(action)) {
            DownloadNoticeService downloadNoticeService2 = this.f10836a;
            if (downloadNoticeService2 != null) {
                downloadNoticeService2.h(stringExtra);
                return;
            }
            return;
        }
        if (this.f10838c.equals(action)) {
            DownloadNoticeService downloadNoticeService3 = this.f10836a;
            if (downloadNoticeService3 != null) {
                downloadNoticeService3.b(stringExtra);
                return;
            }
            return;
        }
        if (this.f10839d.equals(action) || this.f10841f.equalsIgnoreCase(action) || this.f10842g.equals(action)) {
            return;
        }
        if (this.f10840e.equals(action)) {
            DownloadNoticeService downloadNoticeService4 = this.f10836a;
            if (downloadNoticeService4 != null) {
                downloadNoticeService4.a(stringExtra);
                return;
            }
            return;
        }
        if (this.f10843h.equals(action)) {
            DownloadNoticeService downloadNoticeService5 = this.f10836a;
            if (downloadNoticeService5 != null) {
                downloadNoticeService5.d(stringExtra);
                return;
            }
            return;
        }
        if (this.f10844i.equals(action)) {
            DownloadNoticeService downloadNoticeService6 = this.f10836a;
            if (downloadNoticeService6 != null) {
                downloadNoticeService6.f(stringExtra);
                return;
            }
            return;
        }
        if (this.j.equals(action)) {
            DownloadNoticeService downloadNoticeService7 = this.f10836a;
            if (downloadNoticeService7 != null) {
                downloadNoticeService7.h(stringExtra);
                return;
            }
            return;
        }
        if (this.k.equals(action)) {
            if (d.c().a(stringExtra) == null) {
                this.f10836a.a(stringExtra);
            }
            long longExtra = intent.getLongExtra("extraCurPos", 0L);
            long longExtra2 = intent.getLongExtra("extraMaxPos", 0L);
            int i2 = longExtra2 != 0 ? (int) ((longExtra / (longExtra2 * 1.0f)) * 100.0f) : 0;
            DownloadNoticeService downloadNoticeService8 = this.f10836a;
            if (downloadNoticeService8 != null) {
                downloadNoticeService8.a(stringExtra, i2);
                return;
            }
            return;
        }
        if (this.l.equals(action)) {
            Intent intent2 = new Intent(context, (Class<?>) DownloadListActivity.class);
            intent2.setFlags(268435456);
            context.startActivity(intent2);
            return;
        }
        if (this.m.equals(action)) {
            DownloadNoticeService downloadNoticeService9 = this.f10836a;
            if (downloadNoticeService9 != null) {
                downloadNoticeService9.g(stringExtra);
                return;
            }
            return;
        }
        if (this.n.equals(action)) {
            DownloadNoticeService downloadNoticeService10 = this.f10836a;
            if (downloadNoticeService10 != null) {
                downloadNoticeService10.e(stringExtra);
                return;
            }
            return;
        }
        if (!this.o.equals(action) || (downloadNoticeService = this.f10836a) == null) {
            return;
        }
        downloadNoticeService.c(stringExtra);
    }
}
