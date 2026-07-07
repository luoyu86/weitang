package com.ss.android.downloadlib.addownload.compliance;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.sdk.openadsdk.R;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class AppDetailInfoActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TextView f9786a;
    private LinearLayout bl;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private List<Pair<String, String>> f9787h;
    private long kf;
    private long n;
    private ImageView ok;
    private RecyclerView s;

    public class ok extends RecyclerView.Adapter<Object> {
        private ok() {
        }
    }

    private void a() {
        this.ok = (ImageView) findViewById(R.id.iv_detail_back);
        this.f9786a = (TextView) findViewById(R.id.tv_empty);
        this.s = (RecyclerView) findViewById(R.id.permission_list);
        this.bl = (LinearLayout) findViewById(R.id.ll_download);
        if (this.f9787h.isEmpty()) {
            this.s.setVisibility(8);
            this.f9786a.setVisibility(0);
        } else {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            linearLayoutManager.setOrientation(1);
            this.s.setLayoutManager(linearLayoutManager);
            this.s.setAdapter(new ok());
        }
        this.ok.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.AppDetailInfoActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.ok("lp_app_detail_click_close", AppDetailInfoActivity.this.kf);
                AppDetailInfoActivity.this.finish();
            }
        });
        this.bl.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.AppDetailInfoActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.ok("lp_app_detail_click_download", AppDetailInfoActivity.this.kf);
                a.ok().a(AppDetailInfoActivity.this.kf);
                com.ss.android.socialbase.appdownloader.bl.ok((Activity) AppDetailInfoActivity.this);
                com.ss.android.socialbase.appdownloader.bl.ok(a.ok().a());
            }
        });
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        h.ok("lp_app_detail_click_close", this.kf);
        super.onBackPressed();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.ttdownloader_activity_app_detail_info);
        if (ok()) {
            a();
        } else {
            com.ss.android.socialbase.appdownloader.bl.ok((Activity) this);
        }
    }

    public static void ok(Activity activity, long j) {
        Intent intent = new Intent(activity, (Class<?>) AppDetailInfoActivity.class);
        intent.putExtra("app_info_id", j);
        activity.startActivity(intent);
    }

    private boolean ok() {
        this.n = getIntent().getLongExtra("app_info_id", 0L);
        com.ss.android.downloadlib.addownload.a.a aVarOk = bl.ok().ok(this.n);
        if (aVarOk == null) {
            return false;
        }
        this.kf = aVarOk.f9767a;
        this.f9787h = aVarOk.p;
        return true;
    }
}
