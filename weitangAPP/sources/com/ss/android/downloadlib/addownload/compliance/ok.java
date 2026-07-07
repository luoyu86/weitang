package com.ss.android.downloadlib.addownload.compliance;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.R;
import com.ss.android.downloadlib.addownload.compliance.s;
import com.ss.android.downloadlib.addownload.r;
import com.ss.android.downloadlib.guide.install.ClipImageView;
import com.ss.android.downloadlib.h.j;

/* JADX INFO: loaded from: classes2.dex */
public class ok extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TextView f9803a;
    private TextView bl;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ClipImageView f9804h;
    private final com.ss.android.downloadlib.addownload.a.a j;
    private final long k;
    private TextView kf;
    private TextView n;
    private TextView ok;
    private LinearLayout p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Activity f9805q;
    private long r;
    private TextView s;

    public ok(@NonNull Activity activity, long j) {
        super(activity);
        this.f9805q = activity;
        this.k = j;
        this.j = bl.ok().get(Long.valueOf(j));
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        com.ss.android.socialbase.appdownloader.bl.ok(this.f9805q);
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.j == null) {
            dismiss();
            return;
        }
        requestWindowFeature(1);
        setContentView(R.layout.ttdownloader_dialog_appinfo);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(R.drawable.ttdownloader_bg_transparent);
        }
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        this.r = this.j.f9767a;
        ok();
        h.a("lp_app_dialog_show", this.r);
        setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.ss.android.downloadlib.addownload.compliance.ok.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                h.ok("lp_app_dialog_cancel", ok.this.r);
            }
        });
    }

    private void ok() {
        this.ok = (TextView) findViewById(R.id.tv_app_name);
        this.f9803a = (TextView) findViewById(R.id.tv_app_version);
        this.bl = (TextView) findViewById(R.id.tv_app_developer);
        this.s = (TextView) findViewById(R.id.tv_app_detail);
        this.n = (TextView) findViewById(R.id.tv_app_privacy);
        this.kf = (TextView) findViewById(R.id.tv_give_up);
        this.f9804h = (ClipImageView) findViewById(R.id.iv_app_icon);
        this.p = (LinearLayout) findViewById(R.id.ll_download);
        this.ok.setText(j.ok(this.j.n, "--"));
        this.f9803a.setText("版本号：" + j.ok(this.j.kf, "--"));
        this.bl.setText("开发者：" + j.ok(this.j.f9768h, "应用信息正在完善中"));
        this.f9804h.setRoundRadius(j.ok(r.getContext(), 8.0f));
        this.f9804h.setBackgroundColor(Color.parseColor("#EBEBEB"));
        s.ok().ok(this.k, new s.ok() { // from class: com.ss.android.downloadlib.addownload.compliance.ok.2
            @Override // com.ss.android.downloadlib.addownload.compliance.s.ok
            public void ok(Bitmap bitmap) {
                if (bitmap != null) {
                    ok.this.f9804h.setImageBitmap(bitmap);
                } else {
                    h.ok(8, ok.this.r);
                }
            }
        });
        this.s.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.ok.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.ok().ok(ok.this.f9805q);
                AppDetailInfoActivity.ok(ok.this.f9805q, ok.this.k);
                h.ok("lp_app_dialog_click_detail", ok.this.r);
            }
        });
        this.n.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.ok.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.ok().ok(ok.this.f9805q);
                AppPrivacyPolicyActivity.ok(ok.this.f9805q, ok.this.k);
                h.ok("lp_app_dialog_click_privacy", ok.this.r);
            }
        });
        this.kf.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.ok.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ok.this.dismiss();
                h.ok("lp_app_dialog_click_giveup", ok.this.r);
            }
        });
        this.p.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.ok.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.ok("lp_app_dialog_click_download", ok.this.r);
                a.ok().a(ok.this.r);
                ok.this.dismiss();
            }
        });
    }
}
