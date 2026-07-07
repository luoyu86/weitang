package com.chinavisionary.microtang.web;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.NonNull;
import c.e.a.d.q;
import c.e.a.d.x;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseActivity;
import com.chinavisionary.microtang.sign.vo.ResponseFddVo;

/* JADX INFO: loaded from: classes2.dex */
@Route(path = "/webview/webview")
public class WebViewActivity extends BaseActivity {

    @Autowired
    public boolean k;

    @Autowired
    public int l;

    @Autowired
    public String m;

    @Autowired
    public String n;
    public WebFragment o;

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public void U(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public int getLayoutId() {
        return R.layout.activity_content;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public void initView(Bundle bundle) {
        ARouter.getInstance().inject(this);
        if (this.k) {
            ResponseFddVo responseFddVo = new ResponseFddVo();
            responseFddVo.setSignUrl(this.m);
            responseFddVo.setReturnUrl(this.n);
            WebFragment webFragment = WebFragment.getInstance(this.m);
            this.o = webFragment;
            webFragment.setPayFeeType(this.l);
            this.o.setResponseFddVo(responseFddVo);
            this.o.setTitle(x.getString(R.string.title_electron_contract));
            Y(this.o, R.id.flayout_content);
        } else {
            q.d(getClass().getCanonicalName(), "initView else");
            this.o = WebFragment.getInstance(this.f6477e);
            Intent intent = getIntent();
            String stringExtra = intent.getStringExtra("titleKey");
            if (x.isNotNull(stringExtra)) {
                this.o.setTitle(stringExtra);
            }
            String stringExtra2 = intent.getStringExtra("content");
            if (x.isNotNull(stringExtra2)) {
                this.o.setHtmlContent(stringExtra2);
            }
            this.o.setIsArticle(intent.getBooleanExtra("isArticle", false));
            Y(this.o, R.id.flayout_content);
        }
        q.d(getClass().getCanonicalName(), "initView");
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.o = null;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        WebFragment webFragment;
        if (keyEvent.getKeyCode() == 4 && (webFragment = this.o) != null && webFragment.onKeyDown(i2, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        q.d(getClass().getCanonicalName(), "onNewIntent");
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(@NonNull Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        q.d(getClass().getCanonicalName(), "onSaveInstanceState");
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        q.d(getClass().getCanonicalName(), "onSaveInstanceState");
    }
}
