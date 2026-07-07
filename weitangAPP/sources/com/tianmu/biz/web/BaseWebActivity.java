package com.tianmu.biz.web;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.tianmu.biz.utils.s0;
import com.tianmu.c.f.l;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseWebActivity extends FragmentActivity implements DownloadListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.tianmu.biz.web.a f10910a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f10911b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WebView f10912c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FrameLayout f10913d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f10914e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public RelativeLayout f10915f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public RelativeLayout f10916g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ProgressBar f10917h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LinearLayout f10918i;
    public FrameLayout j;
    private boolean k;
    public View l;
    private TextView m;

    public class a extends com.tianmu.c.l.a {
        public a() {
        }

        @Override // com.tianmu.c.l.a
        public void onSingleClick(View view) {
            BaseWebActivity.this.finish();
        }
    }

    private void d() {
        a aVar = new a();
        RelativeLayout relativeLayout = this.f10915f;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(aVar);
        }
    }

    public abstract com.tianmu.biz.web.a a();

    public void a(int i2, int i3) {
        TextView textView = this.f10914e;
        if (textView != null) {
            textView.setText(i2);
        }
        TextView textView2 = this.m;
        if (textView2 != null) {
            textView2.setVisibility(0);
            this.m.setText(i3);
        }
    }

    public abstract b b();

    public void c() {
        WebView webView;
        if (!this.k || (webView = this.f10912c) == null) {
            return;
        }
        this.k = false;
        try {
            webView.loadUrl(getWebUrl());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public abstract String getWebUrl();

    public void initData() {
        this.k = true;
        this.f10910a = a();
        b bVarB = b();
        this.f10911b = bVarB;
        d.a(this.f10912c, bVarB, this.f10910a, this);
    }

    public void initView() {
        this.f10918i = (LinearLayout) findViewById(l.f11418b);
        this.j = (FrameLayout) findViewById(l.f11419c);
        this.l = findViewById(l.f11420d);
        FrameLayout frameLayout = (FrameLayout) findViewById(l.f11421e);
        this.f10913d = (FrameLayout) findViewById(l.f11422f);
        try {
            WebView webView = new WebView(getApplicationContext());
            this.f10912c = webView;
            frameLayout.addView(webView, new FrameLayout.LayoutParams(-1, -1));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (this.f10912c == null) {
            s0.a("设备暂不支持WebView");
            finish();
            return;
        }
        this.f10914e = (TextView) findViewById(l.f11423g);
        this.f10915f = (RelativeLayout) findViewById(l.f11424h);
        this.f10916g = (RelativeLayout) findViewById(l.f11425i);
        this.f10917h = (ProgressBar) findViewById(l.j);
        this.m = (TextView) findViewById(l.k);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        com.tianmu.biz.web.a aVar = this.f10910a;
        if (aVar != null) {
            aVar.a(i2, i3, intent);
        }
        super.onActivityResult(i2, i3, intent);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        com.tianmu.biz.web.a aVar = this.f10910a;
        if (aVar == null || !aVar.a()) {
            WebView webView = this.f10912c;
            if (webView == null || !webView.canGoBack()) {
                super.onBackPressed();
            } else {
                this.f10912c.goBack();
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(l.f11417a);
        initView();
        d();
        initData();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        FrameLayout frameLayout = this.f10913d;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        d.b(this.f10912c);
        this.f10912c = null;
        b bVar = this.f10911b;
        if (bVar != null) {
            bVar.a();
            this.f10911b = null;
        }
        com.tianmu.biz.web.a aVar = this.f10910a;
        if (aVar != null) {
            aVar.b();
            this.f10910a = null;
        }
        super.onDestroy();
    }
}
