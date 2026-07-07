package com.chinavisionary.core.app.base;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import c.e.a.d.a0;
import c.e.a.d.g;
import c.e.a.d.p;
import c.e.a.d.q;
import c.e.a.d.v;
import c.e.a.d.w;
import c.e.a.d.x;
import com.alibaba.android.arouter.launcher.ARouter;
import com.alibaba.fastjson.JSON;
import com.alipay.sdk.m.p.e;
import com.bumptech.glide.Glide;
import com.chinavisionary.core.R;
import com.chinavisionary.core.app.adapter.BaseRecyclerAdapter;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.app.config.bo.AppConfigExtVo;
import com.chinavisionary.core.app.config.bo.UserInfoVo;
import com.chinavisionary.core.app.dialog.AlertParamVo;
import com.chinavisionary.core.app.event.EventPageAppearBo;
import com.chinavisionary.core.app.net.base.dto.NewResponseStateVo;
import com.chinavisionary.core.app.net.base.dto.PageBo;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.core.weight.BaseRecyclerView;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.login.bo.NewLoginBo;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class CoreBaseFragment<T> extends Fragment {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f6484b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f6485c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Context f6486d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Activity f6487e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c f6488f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Unbinder f6489g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AlertDialog f6490h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f6491i;
    public AppConfigExtVo o;
    public int p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f6492q;
    public BaseRecyclerView r;
    public BaseSwipeRefreshLayout s;
    public BaseRecyclerAdapter<T> t;
    public View u;
    public d v;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6483a = 1;
    public boolean j = false;
    public boolean k = true;
    public boolean l = true;
    public boolean m = true;
    public boolean n = true;
    public BaseRecyclerView.f w = new a();
    public Runnable x = new Runnable() { // from class: c.e.a.a.d.a
        @Override // java.lang.Runnable
        public final void run() {
            this.f957a.T();
        }
    };
    public View.OnClickListener y = new View.OnClickListener() { // from class: c.e.a.a.d.c
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.f959a.V(view);
        }
    };
    public View.OnTouchListener z = new View.OnTouchListener() { // from class: c.e.a.a.d.b
        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            return CoreBaseFragment.U(view, motionEvent);
        }
    };

    public class a implements BaseRecyclerView.f {
        public a() {
        }

        @Override // com.chinavisionary.core.weight.BaseRecyclerView.f
        public void onLoadFirstAndLastPosition(int i2, int i3) {
            CoreBaseFragment coreBaseFragment = CoreBaseFragment.this;
            if (coreBaseFragment.v == null || !coreBaseFragment.n) {
                return;
            }
            coreBaseFragment.p = i2;
            CoreBaseFragment.this.f6492q = i3;
            CoreBaseFragment.this.v.updatePosition(i2, i3);
        }

        @Override // com.chinavisionary.core.weight.BaseRecyclerView.f
        public void onLoadMore() {
            CoreBaseFragment.this.y();
        }

        @Override // com.chinavisionary.core.weight.BaseRecyclerView.f
        public void onRefresh() {
            CoreBaseFragment.this.J();
        }

        @Override // com.chinavisionary.core.weight.BaseRecyclerView.f
        public void onStartScroll() {
            CoreBaseFragment.this.X();
        }

        @Override // com.chinavisionary.core.weight.BaseRecyclerView.f
        public void onStopScroll() {
            CoreBaseFragment.this.Z();
        }

        @Override // com.chinavisionary.core.weight.BaseRecyclerView.f
        public void onStartScroll(int i2, int i3) {
            CoreBaseFragment.this.Y(i2, i3);
            CoreBaseFragment coreBaseFragment = CoreBaseFragment.this;
            if (coreBaseFragment.v == null || coreBaseFragment.n) {
                return;
            }
            int[] position = coreBaseFragment.r.getPosition();
            CoreBaseFragment.this.v.updatePosition(position[0], position[1]);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EditText f6494a;

        public b(EditText editText) {
            this.f6494a = editText;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((InputMethodManager) this.f6494a.getContext().getSystemService("input_method")).showSoftInput(this.f6494a, 0);
        }
    }

    public static class c extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<CoreBaseFragment> f6496a;

        public c(CoreBaseFragment coreBaseFragment) {
            if (coreBaseFragment != null) {
                this.f6496a = new WeakReference<>(coreBaseFragment);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            WeakReference<CoreBaseFragment> weakReference = this.f6496a;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.f6496a.get().z(message);
        }

        public void recycler() {
            removeCallbacksAndMessages(null);
            WeakReference<CoreBaseFragment> weakReference = this.f6496a;
            if (weakReference != null) {
                weakReference.get();
                this.f6496a = null;
            }
        }
    }

    public interface d {
        void updatePosition(int i2, int i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void T() {
        this.t.setFirstLastPosition(0, 0);
    }

    public static /* synthetic */ boolean U(View view, MotionEvent motionEvent) {
        return true;
    }

    public static Bundle q(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("key", str);
        return bundle;
    }

    public final boolean A(NewResponseStateVo newResponseStateVo, @StringRes int i2, @StringRes int i3) {
        H();
        if (newResponseStateVo == null) {
            F0(i3);
            return false;
        }
        boolean zIsSuccess = newResponseStateVo.isSuccess();
        if (newResponseStateVo.isSuccess()) {
            F0(i2);
            return zIsSuccess;
        }
        G0(newResponseStateVo.getMessage());
        return zIsSuccess;
    }

    public final void A0(@StringRes int i2, boolean z) {
        if (isDetached()) {
            return;
        }
        H();
        this.f6490h = p.getInstance().showLoadDialog(this.f6486d, getString(i2), z);
    }

    public final void B() {
        H();
        int i2 = this.f6483a;
        if (i2 > 1) {
            this.f6483a = i2 - 1;
        } else {
            c();
        }
    }

    public final void B0(String str) {
        if (isDetached()) {
            return;
        }
        H();
        this.f6490h = p.getInstance().showLoadDialog(this.f6486d, str);
    }

    public final void C(RequestErrDto requestErrDto) {
        H();
        if (requestErrDto != null) {
            boolean zContains = true;
            q.d(this.f6485c, "handleResponseErr url = " + requestErrDto.getUrl() + "msg : " + requestErrDto.getErrMsg());
            if (x.isNotNull(requestErrDto.getUrl())) {
                zContains = true ^ requestErrDto.getUrl().contains(RequestErrDto.GET_ORDER_IS_TICKET_URL);
                if (requestErrDto.getUrl().contains(RequestErrDto.GET_SPACE_GOODS_PWD_ROOM_LIST_URL)) {
                    zContains = false;
                }
                if (requestErrDto.getUrl().contains(RequestErrDto.GET_CONSTANT_URL)) {
                    zContains = false;
                }
                if (requestErrDto.getUrl().contains(RequestErrDto.GET_CANCEL_ACCOUNT_URL)) {
                    zContains = false;
                }
            }
            if (zContains) {
                G0(requestErrDto.getErrMsg());
            }
        }
        I0();
    }

    public final void C0() {
        if (isDetached() || this.f6487e == null) {
            return;
        }
        H();
        this.f6490h = c.e.a.a.e.p.showMapAlert(this.f6487e, this.y);
    }

    public final void D(List<T> list) {
        E(list, true);
    }

    public final void D0(String str, boolean z) {
        if (isDetached() || this.f6487e == null) {
            return;
        }
        H();
        this.f6490h = c.e.a.a.e.p.showAlert(this.f6487e, null, str, x.getString(R.string.core_lib_title_confirm), x.getString(R.string.core_lib_title_cancel), this.y, z, true, 0);
    }

    public final void E(List<T> list, boolean z) {
        if (z) {
            H();
        }
        I0();
        int size = 0;
        if (list != null) {
            size = list.size();
            if (this.f6483a == 1) {
                this.t.initListData(list);
            } else {
                this.t.appendDataToList(list);
            }
        } else if (this.f6483a == 1) {
            this.t.initListData(null);
        }
        G(size);
    }

    public final void E0(EditText editText) {
        editText.postDelayed(new b(editText), 500L);
    }

    public final boolean F(ResponseStateVo responseStateVo, @StringRes int i2, @StringRes int i3) {
        H();
        if (responseStateVo == null) {
            F0(i3);
            return false;
        }
        boolean zIsSuccess = responseStateVo.isSuccess();
        if (responseStateVo.isSuccess()) {
            F0(i2);
            return zIsSuccess;
        }
        G0(responseStateVo.getMessage());
        return zIsSuccess;
    }

    public final void F0(@StringRes int i2) {
        if (this.f6487e == null || isDetached()) {
            return;
        }
        a0.showToast(this.f6487e, i2);
    }

    public final void G(int i2) {
        q.d(this.f6485c, "handlerShowFooter size = " + i2);
        if (!this.l || this.t == null) {
            return;
        }
        q.d(this.f6485c, "handlerShowFooter isAddLoadMore ");
        this.t.setIsShowFooterView(i2 >= 20);
    }

    public final void G0(String str) {
        if (TextUtils.isEmpty(str) || this.f6487e == null || isDetached()) {
            return;
        }
        a0.showToast(this.f6487e, str);
    }

    public final void H() {
        AlertDialog alertDialog = this.f6490h;
        if (alertDialog != null) {
            alertDialog.dismiss();
            this.f6490h = null;
        }
    }

    public void H0() {
        c cVar = this.f6488f;
        if (cVar != null) {
            try {
                cVar.removeMessages(209988331);
                this.f6488f.sendEmptyMessageDelayed(209988331, 30000L);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void I() {
        InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService("input_method");
        if (inputMethodManager == null || getActivity().getCurrentFocus() == null || getActivity().getCurrentFocus().getWindowToken() == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 2);
    }

    public final void I0() {
        J0();
        a0();
    }

    public final void J() {
        if (this.t != null) {
            this.f6483a = 1;
            j0();
        }
    }

    public void J0() {
        c cVar = this.f6488f;
        if (cVar != null) {
            try {
                cVar.removeMessages(209988331);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final boolean K(Class cls) {
        FragmentManager fragmentManager;
        return (cls == null || (fragmentManager = getFragmentManager()) == null || fragmentManager.findFragmentByTag(cls.getCanonicalName()) == null) ? false : true;
    }

    public final void K0(Fragment fragment, @IdRes int i2) {
        x(false, fragment, i2, true);
    }

    public boolean L() {
        UserInfoVo userInfoVoW = w();
        if (userInfoVoW != null) {
            return userInfoVoW.isValidate();
        }
        return false;
    }

    public final void L0(Object obj) {
        if (g.b.a.c.getDefault().isRegistered(obj)) {
            g.b.a.c.getDefault().unregister(obj);
        }
    }

    public boolean M() {
        UserInfoVo userInfoVoW = w();
        if (userInfoVoW != null) {
            return userInfoVoW.isValidateFaDaDa();
        }
        return false;
    }

    public final boolean M0(View view) {
        return !v.getInstance().isRepeatedlyAction(view.getId());
    }

    public final boolean N() {
        boolean zO = O();
        if (!zO && P() && this.f6487e != null) {
            ARouter.getInstance().build("/login/login").navigation();
        }
        return zO;
    }

    public boolean O() {
        return w() != null;
    }

    public final boolean P() {
        try {
            Activity activityCurrentActivity = c.e.a.a.g.a.getAppManager().currentActivity();
            if (activityCurrentActivity != null) {
                return true ^ activityCurrentActivity.getClass().getSimpleName().equals("LoginActivity");
            }
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return true;
        }
    }

    public final boolean Q() {
        UserInfoVo userInfoVoW = w();
        return userInfoVoW != null && userInfoVoW.isCheckIn();
    }

    public boolean R() {
        UserInfoVo userInfoVoW = w();
        if (userInfoVoW != null) {
            return userInfoVoW.roomIsSelfOperated();
        }
        return true;
    }

    public abstract void V(View view);

    public abstract void W();

    public void X() {
        Activity activity = this.f6487e;
        if (activity == null || activity.isDestroyed() || Glide.with(this.f6487e).isPaused()) {
            return;
        }
        c.e.a.d.c0.d.getInstance().stopLoadImage(this.f6487e);
    }

    public void Y(int i2, int i3) {
    }

    public void Z() {
        Activity activity = this.f6487e;
        if (activity == null || activity.isDestroyed()) {
            return;
        }
        c.e.a.d.c0.d.getInstance().startLoadImage(this.f6487e);
    }

    public void a0() {
        BaseSwipeRefreshLayout baseSwipeRefreshLayout = this.s;
        if (baseSwipeRefreshLayout != null) {
            baseSwipeRefreshLayout.setRefreshing(false);
        }
    }

    public void b0(Class<? extends Activity> cls, Map<String, String> map) {
        if (this.f6487e != null) {
            Intent intent = new Intent(this.f6487e, cls);
            intent.setFlags(268435456);
            if (map != null && !map.isEmpty()) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (x.isNotNull(entry.getKey()) && x.isNotNull(entry.getValue())) {
                        intent.putExtra(entry.getKey(), entry.getValue());
                    }
                }
            }
            startActivity(intent);
        }
    }

    public final void c() {
        BaseRecyclerAdapter<T> baseRecyclerAdapter = this.t;
        if (baseRecyclerAdapter != null) {
            baseRecyclerAdapter.addDataToList(null);
        }
    }

    public void c0(Class<? extends Activity> cls, String str) {
        if (this.f6487e != null) {
            Intent intent = new Intent(this.f6487e, cls);
            intent.setFlags(268435456);
            if (str != null) {
                intent.putExtra("key", str);
            }
            startActivity(intent);
        }
    }

    public final void d(Fragment fragment, @IdRes int i2) {
        e(fragment, i2, true);
    }

    public final void d0(Class<? extends Activity> cls) {
        if (this.f6487e == null || !isAdded()) {
            return;
        }
        c0(cls, null);
    }

    public final void e(Fragment fragment, @IdRes int i2, boolean z) {
        x(true, fragment, i2, z);
    }

    public abstract void e0();

    public final void f(String str) {
        Activity activity = this.f6487e;
        if (activity == null || ContextCompat.checkSelfPermission(activity, "android.permission.CALL_PHONE") != 0) {
            requestPermissions(new String[]{"android.permission.CALL_PHONE"}, 200);
            return;
        }
        Intent intent = new Intent("android.intent.action.CALL");
        intent.setData(Uri.parse("tel:" + str));
        this.f6487e.startActivity(intent);
    }

    public abstract void f0();

    public final void g() {
        w.getInstance().clear();
    }

    public final void g0() {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            try {
                fragmentManager.popBackStack();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void getBundle(Bundle bundle) {
    }

    @LayoutRes
    public abstract int getLayoutId();

    public final <D extends ViewModel> D h(Class<D> cls) {
        return (D) ViewModelProviders.of(this).get(cls);
    }

    public final void h0(Object obj) {
        if (g.b.a.c.getDefault().isRegistered(obj)) {
            return;
        }
        g.b.a.c.getDefault().register(obj);
    }

    public final void i(String str) {
        q.d(getClass().getSimpleName(), str);
    }

    public final void i0(Fragment fragment) {
        FragmentManager fragmentManager;
        if (fragment == null || !fragment.isAdded() || (fragmentManager = getFragmentManager()) == null) {
            return;
        }
        fragmentManager.beginTransaction().remove(fragment).commitAllowingStateLoss();
    }

    public final String j(String str) {
        if (x.isNotNull(str)) {
            try {
                return c.e.a.d.d0.c.decryptByPublicKey(str, w.getInstance().getString(e.o, ""));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public abstract void j0();

    public final void k(Object obj) {
        g.b.a.c.getDefault().post(obj);
    }

    public final void k0(AppConfigExtVo appConfigExtVo) {
        if (appConfigExtVo != null) {
            this.o = appConfigExtVo;
            g.getInstance().setupAppConfig(appConfigExtVo);
            w.getInstance().putString("app_config_info", JSON.toJSONString(appConfigExtVo));
        }
    }

    public final void l(Object obj) {
        g.b.a.c.getDefault().postSticky(obj);
    }

    public final void l0(String str) {
        if (x.isNotNull(str)) {
            w.getInstance().putString(NewLoginBo.SMS_LOGIN_NAME, str);
        }
    }

    public final void m() {
        Activity activity = this.f6487e;
        if (activity != null) {
            activity.finish();
        }
    }

    public final void m0(String str) {
        w.getInstance().putString("userDetailsInfoKey", str);
    }

    public final void n() {
        if (this.f6487e != null) {
            try {
                if (getFragmentManager() != null) {
                    this.f6487e.onBackPressed();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final void n0(boolean z) {
        EventPageAppearBo eventPageAppearBo = new EventPageAppearBo();
        eventPageAppearBo.setPageName(getClass().getSimpleName());
        eventPageAppearBo.setPageDisAppear(z);
        eventPageAppearBo.setActivity(this.f6487e);
        k(eventPageAppearBo);
    }

    public final AppConfigExtVo o() {
        if (this.o == null) {
            String string = w.getInstance().getString("app_config_info", null);
            if (x.isNotNull(string)) {
                try {
                    this.o = (AppConfigExtVo) JSON.parseObject(string, AppConfigExtVo.class);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        return this.o;
    }

    public final void o0() {
        BaseRecyclerAdapter<T> baseRecyclerAdapter;
        if (this.r == null || (baseRecyclerAdapter = this.t) == null) {
            return;
        }
        this.f6492q = baseRecyclerAdapter.getDefaultLastPosition();
        this.r.setAdapter(this.t);
        q0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        this.f6487e = (Activity) context;
        this.f6486d = context;
        super.onAttach(context);
        p();
        this.f6485c = getClass().getSimpleName();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.u == null && getLayoutId() != -1) {
            View viewInflate = layoutInflater.inflate(getLayoutId(), viewGroup, false);
            this.u = viewInflate;
            this.f6489g = ButterKnife.bind(this, viewInflate);
            this.u.setOnTouchListener(this.z);
            W();
            o0();
        }
        View view = this.u;
        return view == null ? super.onCreateView(layoutInflater, viewGroup, bundle) : view;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        c cVar = this.f6488f;
        if (cVar != null) {
            cVar.recycler();
            this.f6488f = null;
        }
        View view = this.u;
        if (view != null) {
            view.removeCallbacks(this.x);
        }
        f0();
        H();
        q.d("onDestroy");
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.t != null) {
            this.u.postDelayed(this.x, 200L);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        BaseRecyclerAdapter<T> baseRecyclerAdapter = this.t;
        if (baseRecyclerAdapter != null) {
            baseRecyclerAdapter.setFirstLastPosition(this.p, this.f6492q);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.f6491i = false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.f6491i = true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f6485c = getClass().getSimpleName();
        getBundle(getArguments());
        this.j = true;
        e0();
    }

    public final void p() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f6484b = arguments.getString("key", null);
        }
    }

    public void p0(BaseSwipeRefreshLayout baseSwipeRefreshLayout) {
        this.s = baseSwipeRefreshLayout;
        if (baseSwipeRefreshLayout != null) {
            this.r = baseSwipeRefreshLayout.getBaseRecyclerView();
        }
    }

    public final void q0() {
        if (this.k) {
            this.r.setOnRecyclerScrollListener(this.w);
        }
    }

    public final PageBo r() {
        PageBo pageBo = new PageBo();
        pageBo.setPage(this.f6483a);
        pageBo.setPageNumber(20);
        return pageBo;
    }

    public final void r0(String str, boolean z, View.OnClickListener onClickListener) {
        if (isDetached() || this.f6487e == null) {
            return;
        }
        H();
        this.f6490h = c.e.a.a.e.p.showAlertOnlyConfirm(this.f6487e, null, str, x.getString(R.string.core_lib_title_confirm), x.getString(R.string.core_lib_title_cancel), onClickListener, z);
    }

    public final String s() {
        return w.getInstance().getString(NewLoginBo.SMS_LOGIN_NAME, "");
    }

    public final void s0(AlertParamVo alertParamVo) {
        this.f6490h = c.e.a.a.e.p.showBigInputAlert(alertParamVo);
    }

    public final String t() {
        String strS = s();
        if (!x.isNotNull(strS)) {
            return strS;
        }
        StringBuilder sb = new StringBuilder(1);
        sb.append(strS);
        sb.replace(3, 7, "****");
        return sb.toString();
    }

    public final void t0(String str, String str2, Integer num, boolean z, boolean z2) {
        if (isDetached() || this.f6487e == null) {
            return;
        }
        H();
        AlertParamVo alertParamVo = new AlertParamVo();
        alertParamVo.setActivity(this.f6487e);
        alertParamVo.setContentCanIsEmpty(z2);
        alertParamVo.setCancel(x.getString(R.string.core_lib_title_cancel));
        alertParamVo.setConfirm(x.getString(R.string.core_lib_title_confirm));
        alertParamVo.setContent(str2);
        if (z2) {
            alertParamVo.setHintText(x.getString(R.string.title_hint_reason));
        }
        alertParamVo.setTitle(str);
        if (num != null) {
            alertParamVo.setInputType(num.intValue());
        }
        alertParamVo.setOnClickListener(this.y);
        alertParamVo.setCancelable(z);
        s0(alertParamVo);
    }

    public final String u() {
        return w.getInstance().getString("lat_lng_key", null);
    }

    public final void u0(String str) {
        if (isDetached()) {
            return;
        }
        v0(str, true);
    }

    public String v() {
        return w.getInstance().getString("room_key", null);
    }

    public final void v0(String str, boolean z) {
        if (isDetached() || this.f6487e == null) {
            return;
        }
        H();
        this.f6490h = c.e.a.a.e.p.showAlert(this.f6487e, null, str, x.getString(R.string.core_lib_title_confirm), x.getString(R.string.core_lib_title_cancel), this.y, z);
    }

    public final UserInfoVo w() {
        String string = w.getInstance().getString("userDetailsInfoKey", null);
        if (x.isNotNull(string)) {
            return (UserInfoVo) JSON.parseObject(string, UserInfoVo.class);
        }
        return null;
    }

    public final void w0(String str, String str2, String str3, String str4, boolean z, View.OnClickListener onClickListener) {
        if (isDetached() || this.f6487e == null) {
            return;
        }
        H();
        this.f6490h = c.e.a.a.e.p.showAlertTextColor(this.f6487e, str2, str, str4, str3, onClickListener, z);
    }

    public final void x(boolean z, Fragment fragment, @IdRes int i2, boolean z2) {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            String canonicalName = fragment.getClass().getCanonicalName();
            FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
            if (!z) {
                fragmentTransactionBeginTransaction.replace(i2, fragment, canonicalName);
            } else if (fragment.isAdded()) {
                fragmentTransactionBeginTransaction.show(fragment);
            } else {
                fragmentTransactionBeginTransaction.add(i2, fragment, canonicalName);
            }
            if (z2) {
                fragmentTransactionBeginTransaction.addToBackStack(canonicalName);
            }
            if (this.f6491i) {
                fragmentTransactionBeginTransaction.commitAllowingStateLoss();
            } else {
                fragmentTransactionBeginTransaction.commit();
            }
        }
    }

    public final void x0(String str, String str2, Integer num, boolean z) {
        if (isDetached() || this.f6487e == null) {
            return;
        }
        y0(str, str2, num, z, false);
    }

    public final void y() {
        BaseRecyclerAdapter<T> baseRecyclerAdapter;
        if (this.l && (baseRecyclerAdapter = this.t) != null && baseRecyclerAdapter.isShowFooterView()) {
            this.f6483a++;
            j0();
        }
    }

    public final void y0(String str, String str2, Integer num, boolean z, boolean z2) {
        if (isDetached() || this.f6487e == null) {
            return;
        }
        H();
        AlertParamVo alertParamVo = new AlertParamVo();
        alertParamVo.setActivity(this.f6487e);
        alertParamVo.setContentCanIsEmpty(z2);
        alertParamVo.setCancel(x.getString(R.string.core_lib_title_cancel));
        alertParamVo.setConfirm(x.getString(R.string.core_lib_title_confirm));
        alertParamVo.setContent(str2);
        alertParamVo.setTitle(str);
        if (num != null) {
            alertParamVo.setInputType(num.intValue());
        }
        alertParamVo.setOnClickListener(this.y);
        alertParamVo.setCancelable(z);
        this.f6490h = c.e.a.a.e.p.showInputAlert(alertParamVo);
    }

    public void z(Message message) {
    }

    public final void z0(@StringRes int i2) {
        if (isDetached()) {
            return;
        }
        try {
            H();
            this.f6490h = p.getInstance().showLoadDialog(this.f6486d, getString(i2));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
