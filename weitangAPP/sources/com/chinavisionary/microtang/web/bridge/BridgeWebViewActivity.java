package com.chinavisionary.microtang.web.bridge;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.NonNull;
import c.e.a.d.q;
import c.e.a.d.x;
import c.e.b.c.a.a;
import c.e.b.c.d.n;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseActivity;
import com.chinavisionary.microtang.push.event.EventReadPushMessageVo;
import com.chinavisionary.microtang.web.event.EventReloadEnterpriseAuth;
import com.chinavisionary.microtang.web.event.EventReloadEnterpriseNotify;
import g.b.a.c;

/* JADX INFO: loaded from: classes2.dex */
public class BridgeWebViewActivity extends BaseActivity {
    public boolean k;
    public int l;
    public String m;
    public String n;
    public boolean o;
    public boolean p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f8719q;
    public boolean r;
    public BridgeWebFragment s;

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
        a.isShowNavBar(this);
        this.o = getIntent().getBooleanExtra("is_finish_send_event", false);
        if (this.k) {
            n nVar = new n();
            nVar.setSignUrl(this.m);
            nVar.setReturnUrl(this.n);
            BridgeWebFragment bridgeWebFragment = BridgeWebFragment.getInstance(this.m);
            this.s = bridgeWebFragment;
            bridgeWebFragment.setPayFeeType(this.l);
            this.s.setResponseFddVo(nVar);
            this.s.setTitle(x.getString(R.string.title_electron_contract));
            Y(this.s, R.id.flayout_content);
        } else {
            q.d(getClass().getCanonicalName(), "initView else");
            this.p = c.e.c.r.a.getMyMessageActivity().equals(this.f6477e);
            this.f8719q = c.e.c.r.a.getEnterpriseCertificate().equals(this.f6477e);
            boolean zContains = true;
            if (x.isNotNull(this.f6477e)) {
                this.r = this.f6477e.contains("process/sign/step?assetKey=");
                zContains = true ^ this.f6477e.contains("https://www.v5kf.com/public/chat/chat?sid=194326&entry=5&ref=link&accountid=2f71603018c2c");
            }
            BridgeWebFragment bridgeWebFragment2 = BridgeWebFragment.getInstance(this.f6477e);
            this.s = bridgeWebFragment2;
            bridgeWebFragment2.setShowTitle(zContains);
            Intent intent = getIntent();
            String stringExtra = intent.getStringExtra("titleKey");
            if (x.isNotNull(stringExtra)) {
                this.s.setTitle(stringExtra);
            }
            String stringExtra2 = intent.getStringExtra("content");
            if (x.isNotNull(stringExtra2)) {
                this.s.setHtmlContent(stringExtra2);
            }
            this.s.setIsArticle(intent.getBooleanExtra("isArticle", false));
            Y(this.s, R.id.flayout_content);
        }
        q.d(getClass().getCanonicalName(), "initView isOpenMsgWeb = " + this.p);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        q.d("BridgeWebViewActivity", "onActivityResult requestCode = " + i2 + ", resultCode = " + i3);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.s = null;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        BridgeWebFragment bridgeWebFragment;
        if (keyEvent.getKeyCode() == 4 && (bridgeWebFragment = this.s) != null && bridgeWebFragment.onKeyDown(i2, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (isFinishing()) {
            if (this.p) {
                c.getDefault().post(new EventReadPushMessageVo());
            }
            if (this.o) {
                if (this.f8719q) {
                    c.getDefault().post(new EventReloadEnterpriseAuth());
                }
                if (this.r) {
                    c.getDefault().post(new EventReloadEnterpriseNotify());
                }
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        BridgeWebFragment bridgeWebFragment = this.s;
        if (bridgeWebFragment != null) {
            bridgeWebFragment.onRequestPermissionsResult(i2, strArr, iArr);
        }
    }
}
