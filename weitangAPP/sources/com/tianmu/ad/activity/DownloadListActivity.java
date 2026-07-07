package com.tianmu.ad.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tianmu.TianmuSDK;
import com.tianmu.ad.adapter.DownloadListAdapter;
import com.tianmu.biz.utils.k;
import com.tianmu.c.f.p;
import com.tianmu.c.h.d.c;
import com.tianmu.c.h.e.a;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class DownloadListActivity extends BaseActivity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private RecyclerView f10556a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LinearLayout f10557b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private DownloadListAdapter f10558c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TianmuDownloadListActivityReceiver f10559d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<Intent> f10560e;

    public class TianmuDownloadListActivityReceiver extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f10562a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f10563b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f10564c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f10565d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f10566e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final String f10567f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final String f10568g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final String f10569h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final String f10570i;
        private final String j;
        private final String k;
        private final String l;
        private final String m;
        private final String n;

        public TianmuDownloadListActivityReceiver(String str) {
            String str2 = str + ".tianmu.action.download.failed";
            this.f10562a = str2;
            String str3 = str + ".tianmu.action.download.success";
            this.f10563b = str3;
            String str4 = str + ".tianmu.action.download.installed";
            this.f10564c = str4;
            String str5 = str + ".tianmu.action.download.loading";
            this.f10565d = str5;
            String str6 = str + ".tianmu.action.download.opened";
            this.f10566e = str6;
            String str7 = str + ".tianmu.action.download.idel";
            this.f10567f = str7;
            String str8 = str + ".tianmu.action.download.pause";
            this.f10568g = str8;
            String str9 = str + ".tianmu.action.download.start";
            this.f10569h = str9;
            String str10 = str + ".tianmu.action.download.stop";
            this.f10570i = str10;
            String str11 = str + ".tianmu.action.download.progress.update";
            this.j = str11;
            String str12 = str + ".tianmu.action.download.notice.click";
            this.k = str12;
            String str13 = str + ".tianmu.action.download.notice.stop.click";
            this.l = str13;
            String str14 = str + ".tianmu.action.download.notice.start.click";
            this.m = str14;
            String str15 = str + ".tianmu.action.download.notice.pause.click";
            this.n = str15;
            DownloadListActivity.this.registerReceiver(this, a.a(str3, str4, str2, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15));
            k.a(this, str3, str4, str2, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            String stringExtra = intent.getStringExtra("extraCurrentAdKey");
            String stringExtra2 = intent.getStringExtra("extraAppPackageName");
            if (!TextUtils.isEmpty(stringExtra2)) {
                stringExtra = stringExtra2;
            }
            if (TextUtils.isEmpty(action)) {
                return;
            }
            if (this.f10562a.equals(action)) {
                DownloadListActivity.this.c(stringExtra);
                return;
            }
            if (this.f10563b.equals(action)) {
                DownloadListActivity.this.c(stringExtra);
                return;
            }
            if (this.f10564c.equals(action) || this.f10566e.equalsIgnoreCase(action)) {
                return;
            }
            if (this.f10567f.equals(action)) {
                DownloadListActivity.this.a(stringExtra, 2);
                return;
            }
            if (this.f10565d.equals(action)) {
                DownloadListActivity.this.a(stringExtra, 2);
                return;
            }
            if (this.f10568g.equals(action)) {
                DownloadListActivity.this.a(stringExtra, 0);
                return;
            }
            if (this.f10569h.equals(action)) {
                DownloadListActivity.this.a(stringExtra, 2);
                return;
            }
            if (this.f10570i.equals(action)) {
                DownloadListActivity.this.c(stringExtra);
                return;
            }
            if (this.j.equals(action)) {
                long longExtra = intent.getLongExtra("extraCurPos", 0L);
                long longExtra2 = intent.getLongExtra("extraMaxPos", 0L);
                DownloadListActivity.this.b(stringExtra, longExtra2 != 0 ? (int) ((longExtra / (longExtra2 * 1.0f)) * 100.0f) : 0);
            } else {
                if (this.k.equals(action) || this.l.equals(action)) {
                    return;
                }
                if (this.m.equals(action)) {
                    DownloadListActivity.this.a(stringExtra, 2);
                } else if (this.n.equals(action)) {
                    DownloadListActivity.this.a(stringExtra, 0);
                }
            }
        }

        public void release() {
            k.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        Intent intentB = b(str);
        if (intentB == null) {
            return;
        }
        DownloadListAdapter downloadListAdapter = this.f10558c;
        if (downloadListAdapter != null) {
            downloadListAdapter.removeData(intentB);
        }
        c.c().e(str);
        b();
    }

    @Override // com.tianmu.ad.activity.BaseActivity
    public void initAdapter() {
        super.initAdapter();
        DownloadListAdapter downloadListAdapter = new DownloadListAdapter();
        this.f10558c = downloadListAdapter;
        this.f10556a.setAdapter(downloadListAdapter);
    }

    @Override // com.tianmu.ad.activity.BaseActivity
    public void initData() {
        super.initData();
        List<Intent> listA = c.c().a();
        this.f10560e = listA;
        this.f10558c.setData(listA);
        this.f10559d = new TianmuDownloadListActivityReceiver(TianmuSDK.getInstance().getContext().getPackageName());
    }

    @Override // com.tianmu.ad.activity.BaseActivity
    public void initListener() {
        super.initListener();
        findViewById(p.f11475d).setOnClickListener(new com.tianmu.c.l.a() { // from class: com.tianmu.ad.activity.DownloadListActivity.1
            @Override // com.tianmu.c.l.a
            public void onSingleClick(View view) {
                DownloadListActivity.this.finish();
            }
        });
    }

    @Override // com.tianmu.ad.activity.BaseActivity
    public void initView() {
        super.initView();
        this.f10557b = (LinearLayout) findViewById(p.f11473b);
        RecyclerView recyclerView = (RecyclerView) findViewById(p.f11474c);
        this.f10556a = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        a("下载列表");
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        TianmuDownloadListActivityReceiver tianmuDownloadListActivityReceiver = this.f10559d;
        if (tianmuDownloadListActivityReceiver != null) {
            unregisterReceiver(tianmuDownloadListActivityReceiver);
        }
        k.a(this.f10559d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, int i2) {
        Intent intentB = b(str);
        if (intentB == null) {
            return;
        }
        intentB.putExtra("downloadProgress", i2);
        DownloadListAdapter downloadListAdapter = this.f10558c;
        if (downloadListAdapter != null) {
            downloadListAdapter.notifyItemChanged(intentB);
        }
    }

    @Override // com.tianmu.ad.activity.BaseActivity
    public int a() {
        return p.f11472a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i2) {
        Intent intentB = b(str);
        if (intentB == null) {
            return;
        }
        intentB.putExtra("downloadState", i2);
        DownloadListAdapter downloadListAdapter = this.f10558c;
        if (downloadListAdapter != null) {
            downloadListAdapter.notifyItemChanged(intentB);
        }
    }

    private Intent b(String str) {
        List<Intent> list = this.f10560e;
        if (list == null || list.size() == 0 || TextUtils.isEmpty(str)) {
            return null;
        }
        for (int i2 = 0; i2 < this.f10560e.size(); i2++) {
            Intent intent = this.f10560e.get(i2);
            String stringExtra = intent.getStringExtra("adKey");
            String stringExtra2 = intent.getStringExtra("appPackageName");
            if (str.equals(stringExtra) || str.equals(stringExtra2)) {
                return intent;
            }
        }
        return null;
    }

    private void b() {
        List<Intent> list = this.f10560e;
        if (list != null && list.size() != 0) {
            this.f10557b.setVisibility(8);
        } else {
            this.f10557b.setVisibility(0);
        }
    }
}
