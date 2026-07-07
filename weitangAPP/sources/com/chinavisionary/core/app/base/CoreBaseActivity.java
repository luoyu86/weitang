package com.chinavisionary.core.app.base;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.annotation.IdRes;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import c.e.a.a.b;
import c.e.a.a.e.p;
import c.e.a.d.a0;
import c.e.a.d.q;
import c.e.a.d.w;
import c.e.a.d.x;
import c.j.a.h;
import com.alibaba.android.arouter.launcher.ARouter;
import com.alibaba.fastjson.JSON;
import com.chinavisionary.core.R;
import com.chinavisionary.core.app.config.bo.AppConfigExtVo;
import com.chinavisionary.core.app.config.bo.UserInfoVo;
import com.chinavisionary.microtang.login.bo.NewLoginBo;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class CoreBaseActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f6473a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Unbinder f6474b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AlertDialog f6475c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a f6478f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f6480h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f6481i;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f6476d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f6477e = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c.e.a.a.j.a f6479g = c.e.a.a.j.a.RIGHT;
    public View.OnClickListener j = new View.OnClickListener() { // from class: c.e.a.a.d.d
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.f960a.U(view);
        }
    };

    public static class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<CoreBaseActivity> f6482a;

        public a(CoreBaseActivity coreBaseActivity) {
            if (coreBaseActivity != null) {
                this.f6482a = new WeakReference<>(coreBaseActivity);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            WeakReference<CoreBaseActivity> weakReference = this.f6482a;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.f6482a.get().I(message);
        }

        public void recycler() {
            removeCallbacksAndMessages(null);
            WeakReference<CoreBaseActivity> weakReference = this.f6482a;
            if (weakReference != null) {
                if (weakReference.get() != null) {
                    this.f6482a.clear();
                }
                this.f6482a = null;
            }
        }
    }

    public AppConfigExtVo E() {
        String string = w.getInstance().getString("app_config_info", null);
        if (!x.isNotNull(string)) {
            return null;
        }
        try {
            return (AppConfigExtVo) JSON.parseObject(string, AppConfigExtVo.class);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public final void F() {
        Intent intent = getIntent();
        if (intent != null) {
            this.f6477e = intent.getStringExtra("key");
        }
    }

    public String G() {
        return w.getInstance().getString(NewLoginBo.SMS_LOGIN_NAME, null);
    }

    public UserInfoVo H() {
        String string = w.getInstance().getString("userDetailsInfoKey", null);
        if (x.isNotNull(string)) {
            return (UserInfoVo) JSON.parseObject(string, UserInfoVo.class);
        }
        return null;
    }

    public void I(Message message) {
    }

    public boolean J() {
        return ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }

    public void K() {
        AlertDialog alertDialog;
        if (isFinishing() || (alertDialog = this.f6475c) == null) {
            return;
        }
        alertDialog.dismiss();
        this.f6475c = null;
    }

    public final void L(Bundle bundle) {
        if (getLayoutId() != 0) {
            setContentView(getLayoutId());
            this.f6474b = ButterKnife.bind(this);
        }
        this.f6473a = getApplicationContext();
        initView(bundle);
        if (this.f6476d) {
            c.e.a.a.j.a aVarA0 = a0(this.f6479g);
            if (aVarA0.equals(c.e.a.a.j.a.LEFT)) {
                overridePendingTransition(R.anim.left_in, R.anim.left_out);
            } else if (aVarA0.equals(c.e.a.a.j.a.RIGHT)) {
                overridePendingTransition(R.anim.enter_trans, R.anim.exit_right);
            } else if (aVarA0.equals(c.e.a.a.j.a.TOP)) {
                overridePendingTransition(R.anim.top_in, R.anim.top_out);
            } else if (aVarA0.equals(c.e.a.a.j.a.BOTTOM)) {
                overridePendingTransition(R.anim.bottom_in, 0);
            } else if (aVarA0.equals(c.e.a.a.j.a.SCALE)) {
                overridePendingTransition(R.anim.scale_in, R.anim.scale_out);
            } else if (aVarA0.equals(c.e.a.a.j.a.FADE)) {
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            } else if (aVarA0.equals(c.e.a.a.j.a.ZOOM)) {
                overridePendingTransition(R.anim.zoomin, R.anim.zoomout);
            }
        }
        q.d("BaseActivity", "overridePendingTransition end ：" + (System.currentTimeMillis() - this.f6480h));
    }

    public void M() {
        h.with(this).navigationBarColor(R.color.base_transparent).statusBarDarkFont(true).navigationBarDarkIcon(true).init();
    }

    public boolean N() {
        UserInfoVo userInfoVoH = H();
        return userInfoVoH != null && (userInfoVoH.isValidate() || userInfoVoH.isValidateFaDaDa());
    }

    public boolean O() {
        return w.getInstance().getBoolean("isFirstLoginAppKey", true);
    }

    public boolean P() {
        boolean z = H() != null;
        if (!z && R()) {
            ARouter.getInstance().build("/login/login").navigation();
        }
        return z;
    }

    public boolean Q() {
        return H() != null;
    }

    public final boolean R() {
        Activity activityCurrentActivity = c.e.a.a.g.a.getAppManager().currentActivity();
        if (activityCurrentActivity != null) {
            return true ^ activityCurrentActivity.getClass().getSimpleName().equals("LoginActivity");
        }
        return true;
    }

    public boolean S() {
        UserInfoVo userInfoVoH = H();
        return userInfoVoH != null && userInfoVoH.isCheckIn();
    }

    public final boolean T(View view, MotionEvent motionEvent) {
        if (!(view instanceof EditText)) {
            return false;
        }
        int[] iArr = {0, 0};
        view.getLocationOnScreen(iArr);
        int i2 = iArr[0];
        int i3 = iArr[1];
        return motionEvent.getRawX() <= ((float) i2) || motionEvent.getRawX() >= ((float) (view.getWidth() + i2)) || motionEvent.getRawY() <= ((float) i3) || motionEvent.getRawY() >= ((float) (view.getHeight() + i3));
    }

    public abstract void U(View view);

    public void V(Class cls) {
        Intent intent = new Intent(this, (Class<?>) cls);
        intent.setFlags(268435456);
        startActivity(intent);
    }

    public void W(Class cls, String str) {
        Intent intent = new Intent(this, (Class<?>) cls);
        intent.setFlags(268435456);
        intent.putExtra("key", str);
        startActivity(intent);
    }

    public boolean X(Fragment fragment) {
        FragmentManager supportFragmentManager;
        return (fragment == null || (supportFragmentManager = getSupportFragmentManager()) == null || supportFragmentManager.beginTransaction().remove(fragment).commitAllowingStateLoss() <= -1) ? false : true;
    }

    public void Y(Fragment fragment, @IdRes int i2) {
        FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(i2, fragment, fragment.getClass().getCanonicalName());
        a(fragmentTransactionBeginTransaction);
    }

    public void Z(Fragment fragment, @IdRes int i2, boolean z) {
        FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(i2, fragment, fragment.getClass().getCanonicalName());
        if (z) {
            fragmentTransactionBeginTransaction.addToBackStack(null);
        }
        a(fragmentTransactionBeginTransaction);
    }

    public final void a(FragmentTransaction fragmentTransaction) {
        if (this.f6481i) {
            fragmentTransaction.commitAllowingStateLoss();
        } else {
            fragmentTransaction.commit();
        }
    }

    public c.e.a.a.j.a a0(c.e.a.a.j.a aVar) {
        this.f6479g = aVar;
        return aVar;
    }

    public void b(Fragment fragment, @IdRes int i2, boolean z) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        if (supportFragmentManager != null) {
            FragmentTransaction fragmentTransactionBeginTransaction = supportFragmentManager.beginTransaction();
            fragmentTransactionBeginTransaction.add(i2, fragment, fragment.getClass().getCanonicalName());
            if (!z) {
                fragmentTransactionBeginTransaction.addToBackStack(null);
            }
            a(fragmentTransactionBeginTransaction);
        }
    }

    public final void b0() {
        b.getInstance().setupGradModel(getWindow().getDecorView());
    }

    public <T extends ViewModel> T c(Class<T> cls) {
        return (T) ViewModelProviders.of(this).get(cls);
    }

    public void c0(String str) {
        if (isFinishing()) {
            return;
        }
        p.showAlert(this, null, str, x.getString(R.string.core_lib_title_confirm), x.getString(R.string.core_lib_title_cancel), this.j, true);
    }

    public void d(int i2, String str) {
        if (x.isNotNull(G())) {
            HashMap map = new HashMap();
            map.put("type", String.valueOf(i2));
            map.put("param", str);
        }
    }

    public void d0(String str, String str2, String str3) {
        if (isFinishing()) {
            return;
        }
        p.showAlert(this, str2, str, str3, x.getString(R.string.core_lib_title_cancel), this.j, true);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            if (motionEvent.getAction() == 0 && getCurrentFocus() != null && getCurrentFocus().getWindowToken() != null && T(getCurrentFocus(), motionEvent)) {
                J();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public Fragment e(String str) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        if (supportFragmentManager != null) {
            return supportFragmentManager.findFragmentByTag(str);
        }
        return null;
    }

    public void e0(@StringRes int i2) {
        a0.showToast(this, i2);
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        a aVar = this.f6478f;
        if (aVar != null) {
            aVar.recycler();
            this.f6478f = null;
        }
    }

    public abstract int getLayoutId();

    public abstract void initView(Bundle bundle);

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (this.f6474b == null) {
            this.f6480h = System.currentTimeMillis();
            c.e.a.a.g.a.getAppManager().addActivity(this);
            super.onCreate(bundle);
            F();
            L(bundle);
            M();
            b0();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        c.e.a.a.g.a.getAppManager().finishActivity(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.f6481i = false;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.f6481i = true;
    }

    public void showLoading(@Nullable String str) {
        if (isFinishing()) {
            return;
        }
        this.f6475c = c.e.a.d.p.getInstance().showLoadDialog(this, str);
    }

    public void showToast(String str) {
        if (isFinishing()) {
            return;
        }
        a0.showToast(this, str);
    }
}
