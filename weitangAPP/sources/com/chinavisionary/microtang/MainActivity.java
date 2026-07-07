package com.chinavisionary.microtang;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.g;
import c.e.a.d.h;
import c.e.a.d.j;
import c.e.a.d.q;
import c.e.a.d.u;
import c.e.a.d.v;
import c.e.a.d.w;
import c.e.a.d.x;
import c.e.c.m0.k;
import c.e.c.m0.o;
import c.e.c.m0.p;
import c.e.c.v.f.b0;
import c.e.c.v.f.y;
import c.e.c.v.f.z;
import c.e.e.a.x.f;
import c.e.e.a.x.l;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.chinavisionary.core.app.base.CoreBaseActivity;
import com.chinavisionary.core.app.config.bo.AppConfigExtVo;
import com.chinavisionary.core.app.config.bo.AppUpdateVo;
import com.chinavisionary.core.app.config.bo.UserInfoVo;
import com.chinavisionary.core.app.event.EventOpenLiveCheck;
import com.chinavisionary.core.app.event.EventPageAppearBo;
import com.chinavisionary.core.app.event.EventProductPayVo;
import com.chinavisionary.core.app.event.EventUnlockSuccess;
import com.chinavisionary.core.app.event.EventUpdateSelectRoom;
import com.chinavisionary.core.app.event.EventUpdateUserInfoVo;
import com.chinavisionary.core.app.net.version.model.AppVersionModel;
import com.chinavisionary.core.scan.EventScanResultVo;
import com.chinavisionary.core.weight.banner.NoScrollViewPager;
import com.chinavisionary.microtang.app.EventApp;
import com.chinavisionary.microtang.auth.IDAuthActivity;
import com.chinavisionary.microtang.base.BaseActivity;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.base.TabFragmentAdapter;
import com.chinavisionary.microtang.bill.event.EventRentBill;
import com.chinavisionary.microtang.comment.CommentActivity;
import com.chinavisionary.microtang.login.bo.EventUpdateUserAlertMessage;
import com.chinavisionary.microtang.main.bo.EventUpdateAlertVo;
import com.chinavisionary.microtang.main.event.EventBadgeMsgVo;
import com.chinavisionary.microtang.main.event.EventUpdateAliYunOss;
import com.chinavisionary.microtang.main.fragments.AppAlertFragment;
import com.chinavisionary.microtang.main.fragments.NotKeepRentFragment;
import com.chinavisionary.microtang.main.fragments.VersionUpdateFragment;
import com.chinavisionary.microtang.me.event.EventLoginSuccessSwitchProject;
import com.chinavisionary.microtang.me.event.EventShowNotKeepRent;
import com.chinavisionary.microtang.me.model.NewUserModel;
import com.chinavisionary.microtang.me.model.NewUserOperateModel;
import com.chinavisionary.microtang.me.model.UserModel;
import com.chinavisionary.microtang.me.model.UserOperateModel;
import com.chinavisionary.microtang.me.vo.EventSwitchRoomVo;
import com.chinavisionary.microtang.open.event.EventOpenDoorList;
import com.chinavisionary.microtang.open.event.EventUpdateRoomCache;
import com.chinavisionary.microtang.open.fragment.OpenRoomListFragment;
import com.chinavisionary.microtang.push.event.EventReadPushMessageVo;
import com.chinavisionary.microtang.sign.vo.EventSwitchToMeVo;
import com.chinavisionary.microtang.vo.EventUpdateRentState;
import com.chinavisionary.microtang.vo.EventWxMiniBack;
import com.chinavisionary.microtang.vo.ExitAppEvent;
import com.chinavisionary.microtang.vo.InitAuthSuccessVo;
import com.chinavisionary.paymentlibrary.PayTypeActivity;
import com.chinavisionary.paymentlibrary.vo.EventPayStateVo;
import com.chinavisionary.twlib.open.bo.TwLibCheckCreateCommentBo;
import com.chinavisionary.twlib.open.service.OpenDoorService;
import com.google.android.material.tabs.TabLayout;
import g.b.a.m;
import g.b.a.r;

/* JADX INFO: loaded from: classes.dex */
public class MainActivity extends BaseActivity implements ViewPager.OnPageChangeListener {
    public static int k = 2;
    public static int l = 1;
    public static long m = 180;

    @BindView(R.id.btn_open_wx)
    public Button mButton;

    @BindView(R.id.frame_layout_ad)
    public LinearLayout mFrameLayoutAd;

    @BindView(R.id.img_open_lock)
    public ImageView mOpenLockImg;

    @BindView(R.id.rlayout_open_lock)
    public RelativeLayout mRelativeLayout;

    @BindView(R.id.tab_layout)
    public TabLayout mTabLayout;

    @BindView(R.id.tab_view_page)
    public NoScrollViewPager mViewPager;
    public long p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f6780q;
    public String r;
    public CoreBaseActivity.a s;
    public b0 t;
    public e v;
    public boolean w;
    public AppAlertFragment x;
    public int n = 1;
    public long o = 0;
    public volatile boolean u = false;
    public final y y = new a();
    public final z z = new b();

    public class a implements y {
        public a() {
        }

        @Override // c.e.c.v.f.y
        public String getScanResult() {
            return MainActivity.this.r;
        }

        @Override // c.e.c.v.f.y
        public boolean isLoginState() {
            return MainActivity.this.Q();
        }

        @Override // c.e.c.v.f.y
        public boolean isNetworkConnectRequest() {
            return MainActivity.this.w;
        }

        @Override // c.e.c.v.f.y
        public boolean isRent() {
            return MainActivity.this.S();
        }

        @Override // c.e.c.v.f.y
        public void unRegisterNetworkReceive() {
            MainActivity.this.X0();
        }
    }

    public class b implements z {
        public b() {
        }

        @Override // c.e.c.v.f.z
        public void addFragmentIsAddBackStack(BaseFragment baseFragment, boolean z) {
            MainActivity.this.b(baseFragment, R.id.constraint_main_content, z);
            q.d(b.class.getSimpleName(), "handlerAppVersionUpdate addFragmentIsAddBackStack isAddBackStack = " + z);
        }

        @Override // c.e.c.v.f.z
        public FragmentActivity getCurrentActivity() {
            return MainActivity.this;
        }

        @Override // c.e.c.v.f.z
        public void handleAdClickMonitor(String str, String str2) {
            MainActivity.this.t.clickBannerRecord(str2);
            MainActivity.this.f0(str);
        }

        @Override // c.e.c.v.f.z
        public void handleForward(int i2, String str, String str2) {
            MainActivity.this.g0(i2, str, str2);
        }
    }

    public class c implements TabLayout.OnTabSelectedListener {
        public c() {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            MainActivity.this.t.getBadgeCount();
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.e.c.m0.c.getInstance().setLateFeeAlertMessageVo(null);
            MainActivity.this.t.updateBillAlertMessage();
        }
    }

    public class e extends BroadcastReceiver {
        public e() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (k.isNetworkAvailabe(MainActivity.this)) {
                MainActivity.this.w = true;
                if (MainActivity.this.t != null) {
                    MainActivity.this.t.updateAppVersion();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: I0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void J0() {
        G0();
        String string = w.getInstance().getString("selectProjectKey", null);
        if (x.isNotNull(string)) {
            c.e.a.a.b.getInstance().setProjectKey(string);
        }
        o.getInstance().initData();
        Y0();
        U0();
        A0();
        c.e.a.d.b0.getInstance().sendAppErr();
        T0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: K0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void L0() {
        g.b.a.c.getDefault().post(new EventApp());
        this.t.updateAppConfigAndUserInfo();
        q.d(getClass().getSimpleName(), "delayedPushInit end :" + (System.currentTimeMillis() - this.p));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: M0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void N0() {
        Fragment fragmentE = e(AppAlertFragment.class.getCanonicalName());
        String simpleName = getClass().getSimpleName();
        StringBuilder sb = new StringBuilder();
        sb.append("eventUpdateAlert fragment is empty = ");
        sb.append(fragmentE == null);
        q.d(simpleName, sb.toString());
        X(fragmentE);
        this.t.updateAlertMessage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: O0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void P0() {
        d0(x.getString(R.string.alert_content_notification_msg), x.getString(R.string.alert_title_enable_notification), x.getString(R.string.alert_confirm_goto_setup));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: Q0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void R0() {
        if (Q()) {
            this.t.getOnlyRefreshUserInfo();
        }
    }

    public final void A0() {
        this.s.postDelayed(new Runnable() { // from class: c.e.c.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f1400a.L0();
            }
        }, m);
    }

    public final AppConfigExtVo.ADScreen.SplashScreenBean B0() {
        String string = w.getInstance().getString("splash_ad", null);
        if (!x.isNotNull(string)) {
            return null;
        }
        try {
            return (AppConfigExtVo.ADScreen.SplashScreenBean) JSON.parseObject(string, AppConfigExtVo.ADScreen.SplashScreenBean.class);
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public final void C0() {
        if (P()) {
            Y0();
            if (S()) {
                if (N()) {
                    b(OpenRoomListFragment.getInstance("1"), R.id.constraint_main_content, false);
                } else {
                    e0(R.string.tip_unlock_need_auth);
                    V(IDAuthActivity.class);
                }
            }
        }
    }

    public final void D0(AppUpdateVo appUpdateVo, int i2) {
        if (appUpdateVo != null) {
            int version = appUpdateVo.getVersion();
            int minVersion = appUpdateVo.getMinVersion();
            boolean zIsForceUpdate = appUpdateVo.isForceUpdate();
            boolean z = i2 < minVersion;
            if (i2 < version || z) {
                if (z) {
                    zIsForceUpdate = true;
                }
                b(VersionUpdateFragment.getInstance(appUpdateVo.getRemark(), appUpdateVo.getDownloadUrl(), zIsForceUpdate), R.id.constraint_main_content, zIsForceUpdate);
            }
        }
    }

    public final void E0(boolean z) {
        if (!w.getInstance().getBoolean("isFirstLoginAppKey", true)) {
            g.getInstance().setArgentPrivate(!"18688948873".equals(G()));
            if (g.getInstance().isEnableSplashAd() && z) {
                this.t.hiedSplashAd();
                this.mFrameLayoutAd.setVisibility(0);
                V0();
            }
        }
    }

    public final void F0() {
        AppConfigExtVo appConfigExtVoE = E();
        if (appConfigExtVoE != null && B0() != null) {
            m = 700L;
            c.e.c.m0.c.getInstance().setAppConfigExtVo(appConfigExtVoE);
        }
        y0();
        String string = w.getInstance().getString("Token", "");
        String string2 = w.getInstance().getString("room_key", "");
        String string3 = w.getInstance().getString(com.alipay.sdk.m.p.e.o, "");
        boolean z = w.getInstance().getBoolean("ble_scan", false);
        u.getInstance().initData();
        c.e.c.n.c.a.getInstance().initActivityConstantData();
        f.setScan(z);
        j.getInstance().setPublicKey(string3);
        c.e.c.m0.c.getInstance().setRoomKey(string2);
        c.e.a.a.b.getInstance().setToken(string);
        c.e.c.p.b.getInstance().init(getApplicationContext());
        UserInfoVo userInfoVoH = H();
        if (userInfoVoH != null) {
            if (x.isNotNull(userInfoVoH.getPersonName())) {
                c.e.a.a.b.getInstance().setUserName(userInfoVoH.getPersonName());
            } else {
                c.e.a.a.b.getInstance().setUserName(userInfoVoH.getNickname());
            }
            c.e.a.a.b.getInstance().setUserKey(userInfoVoH.getUserKey());
            c.e.c.x.c.a.getInstance().initOftenDevice();
        }
        l.getInstance().setEnableCache(w.getInstance().getBoolean("is_enable_cache_key", l.getInstance().isEnableCache()));
        this.t.initView(appConfigExtVoE);
        E0(true);
    }

    public final void G0() {
        TabFragmentAdapter tabFragmentAdapter = new TabFragmentAdapter(getSupportFragmentManager(), this.t.getFragments());
        this.mViewPager.setOffscreenPageLimit(this.n);
        this.mViewPager.setAdapter(tabFragmentAdapter);
        this.mViewPager.setNoScroll(true);
        this.mViewPager.addOnPageChangeListener(this);
        this.mTabLayout.setupWithViewPager(this.mViewPager);
        this.t.setupTab(this.mTabLayout);
        this.mViewPager.setCurrentItem(S() ? this.n : 0);
        this.mTabLayout.addOnTabSelectedListener(new c());
    }

    public final void H0() {
        if (c.e.a.a.a.getInstance().isNewVersionModel()) {
            k = 4;
            l = 2;
            this.n = 5;
        }
        c.e.e.a.t.b.getInstance();
        g.b.a.c.getDefault().register(this);
        p.getInstance().setActivity(this);
        this.s = new CoreBaseActivity.a(this);
        this.t = new b0(this.z, this.y);
        F0();
        q.d(getClass().getSimpleName(), "initViewAndData end time :" + (System.currentTimeMillis() - this.p));
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public void I(Message message) {
        NoScrollViewPager noScrollViewPager = this.mViewPager;
        if (noScrollViewPager != null) {
            int i2 = message.what;
            int i3 = k;
            if (i2 == i3) {
                noScrollViewPager.setCurrentItem(i3);
            } else {
                noScrollViewPager.setCurrentItem(this.f6780q);
            }
        }
    }

    public final void S0() {
        IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        this.v = new e();
        getApplicationContext().registerReceiver(this.v, intentFilter);
    }

    public final synchronized void T0() {
        if (Q()) {
            boolean z = w.getInstance().getBoolean("request_enable_notify", false);
            if (!c.e.c.e0.a.a.getInstance().requestNotificationEnabled(this) && !z) {
                w.getInstance().putBoolean("request_enable_notify", true);
                runOnUiThread(new Runnable() { // from class: c.e.c.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f1418a.P0();
                    }
                });
            }
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public void U(View view) {
        if (view.getId() == R.id.tv_alert_confirm) {
            c.e.c.e0.a.a.getInstance().requestNotification(this);
        }
    }

    public final void U0() {
        NewUserModel newUserModel;
        NewUserOperateModel newUserOperateModel;
        if (c.e.a.a.a.getInstance().isH5Model()) {
            NewUserModel newUserModel2 = (NewUserModel) c(NewUserModel.class);
            newUserOperateModel = (NewUserOperateModel) c(NewUserOperateModel.class);
            newUserModel = newUserModel2;
        } else {
            newUserModel = null;
            newUserOperateModel = null;
        }
        this.t.setModel(newUserModel, newUserOperateModel, (UserModel) c(UserModel.class), (AppVersionModel) c(AppVersionModel.class), (UserOperateModel) c(UserOperateModel.class), G());
        this.t.loadAliYunOssResource("setupUserModel");
    }

    public final void V0() {
        getWindow().setFlags(1024, 1024);
    }

    public final void W0(int i2) {
        if (i2 != l) {
            this.f6780q = i2;
            this.t.updateSelectTabToPosition(i2);
        } else {
            CoreBaseActivity.a aVar = this.s;
            aVar.sendMessageDelayed(aVar.obtainMessage(), 2000L);
            C0();
        }
    }

    public final void X0() {
        if (k.isNetworkAvailabe(this)) {
            if (this.v != null) {
                getApplicationContext().unregisterReceiver(this.v);
                this.v = null;
            }
            AppAlertFragment appAlertFragment = this.x;
            if (appAlertFragment != null) {
                X(appAlertFragment);
                q.d(getClass().getSimpleName(), "remove");
                this.x = null;
            }
            g.b.a.c.getDefault().post(new c.e.c.v.b.a());
        }
    }

    public final void Y0() {
        ImageView imageView = this.mOpenLockImg;
        if (imageView != null) {
            imageView.setImageResource(S() ? R.mipmap.ic_open_lock : R.mipmap.ic_open_lock_un_auth);
        }
    }

    public final void Z0() {
        this.s.postDelayed(new Runnable() { // from class: c.e.c.e
            @Override // java.lang.Runnable
            public final void run() {
                this.f1427a.R0();
            }
        }, 500L);
    }

    @m
    public void eventCheckCreateCommentBo(TwLibCheckCreateCommentBo twLibCheckCreateCommentBo) {
        if (twLibCheckCreateCommentBo != null && twLibCheckCreateCommentBo.isNeedComment() && x.isNotNull(twLibCheckCreateCommentBo.getRentCommentKey())) {
            Intent intent = new Intent(this, (Class<?>) CommentActivity.class);
            intent.setFlags(268435456);
            intent.putExtra("key", twLibCheckCreateCommentBo.getRentCommentKey());
            intent.putExtra("isOpenAssetConfirm", twLibCheckCreateCommentBo.isOpenAssetConfirm());
            intent.putExtra("contractKey", twLibCheckCreateCommentBo.getContractKey());
            intent.putExtra("assetConfirmTime", twLibCheckCreateCommentBo.getAssetConfirmDate());
            startActivity(intent);
            if (x.isNotNull(twLibCheckCreateCommentBo.getMessageKey())) {
                c.e.c.z.c.a.checkIsClearNotify(twLibCheckCreateCommentBo.getMessageKey());
            }
        }
    }

    @m
    public void eventOpenDoorList(EventOpenDoorList eventOpenDoorList) {
    }

    @m(threadMode = r.BACKGROUND)
    public void eventPageAppear(EventPageAppearBo eventPageAppearBo) {
        k0(eventPageAppearBo);
        q.d(getClass().getSimpleName(), "eventPageAppear getPageName = " + eventPageAppearBo.getPageName());
    }

    @m
    public void eventPayStateVo(EventPayStateVo eventPayStateVo) {
        if (eventPayStateVo != null && eventPayStateVo.isSuccess() && eventPayStateVo.isHasRentFee() && x.isNotNull(eventPayStateVo.getBillKey())) {
            q.d(getClass().getSimpleName(), "eventPayStateVo getIsNeedComment getBillKey :" + eventPayStateVo.getBillKey());
            this.s.postDelayed(new d(), 1000L);
        }
    }

    @m(sticky = true, threadMode = r.ASYNC)
    public void eventReadMessageKey(EventReadPushMessageVo eventReadPushMessageVo) {
        this.t.postReadMsgKey(eventReadPushMessageVo.getMessageKey());
    }

    @m(threadMode = r.MAIN)
    public void eventScanResult(EventScanResultVo eventScanResultVo) {
        if (eventScanResultVo != null) {
            String result = eventScanResultVo.getResult();
            this.r = result;
            if (x.isNotNull(result)) {
                if (this.r.split("cvdata_separator").length != 2) {
                    g0(1, this.r, null);
                } else if (P()) {
                    this.t.updateAppConfig();
                } else {
                    e0(R.string.tip_login_use_scan_pay);
                }
            }
        }
    }

    @m(threadMode = r.MAIN)
    public void eventSwitchToMe(EventSwitchToMeVo eventSwitchToMeVo) {
        this.s.obtainMessage(k).sendToTarget();
    }

    @m(threadMode = r.MAIN)
    public void eventUnlockSuccess(EventUnlockSuccess eventUnlockSuccess) {
    }

    @m
    public void eventUnlockSuccess(EventRentBill eventRentBill) {
        if (eventRentBill != null) {
            this.t.getIsNeedComment(eventRentBill.getBillKey());
        }
    }

    @m(threadMode = r.MAIN)
    public void eventUpdateAlert(EventUpdateAlertVo eventUpdateAlertVo) {
        if (this.t != null) {
            this.s.postDelayed(new Runnable() { // from class: c.e.c.a
                @Override // java.lang.Runnable
                public final void run() {
                    this.f1317a.N0();
                }
            }, 2000L);
        }
    }

    @m(threadMode = r.MAIN)
    public void eventUpdateAlertMessage(EventUpdateUserAlertMessage eventUpdateUserAlertMessage) {
        if (eventUpdateUserAlertMessage != null) {
            this.t.updateCacheLockList();
            this.t.updateAppVersion();
            this.t.updateAlertMessage();
            this.t.updateSelectProject();
            this.t.getBadgeCount();
        }
    }

    @m(threadMode = r.BACKGROUND)
    public void eventUpdateAliYunOss(EventUpdateAliYunOss eventUpdateAliYunOss) {
    }

    @m(threadMode = r.MAIN)
    public void eventUpdateRentState(EventUpdateRentState eventUpdateRentState) {
        if (eventUpdateRentState != null) {
            Y0();
            T0();
        }
    }

    @m
    public void eventUpdateRoomCache(EventUpdateRoomCache eventUpdateRoomCache) {
        this.t.updateCacheLockList();
    }

    @m(threadMode = r.MAIN)
    public void eventUpdateSwitchRoom(EventUpdateSelectRoom eventUpdateSelectRoom) {
        if (eventUpdateSelectRoom != null) {
            this.t.updateAlertMessage();
        }
    }

    @m(threadMode = r.MAIN)
    public void eventUpdateUserInfo(EventUpdateUserInfoVo eventUpdateUserInfoVo) {
        if (eventUpdateUserInfoVo != null) {
            Y0();
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @m(threadMode = r.MAIN)
    public void initEMASSdk(InitAuthSuccessVo initAuthSuccessVo) {
        E0(false);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public void initView(Bundle bundle) {
        this.p = System.currentTimeMillis();
        if (!this.u) {
            this.u = true;
            H0();
            z0();
        }
        q.d(getClass().getSimpleName(), "initView");
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        CoreBaseActivity.a aVar = this.s;
        if (aVar != null) {
            aVar.recycler();
            this.s = null;
        }
        stopService(new Intent(this, (Class<?>) OpenDoorService.class));
        c.e.e.a.u.d.getInstance().recycler();
        if (g.b.a.c.getDefault().isRegistered(this)) {
            g.b.a.c.getDefault().unregister(this);
        }
        c.e.c.p.b.getInstance().closeDb();
        c.e.e.a.t.b.getInstance().closeDb();
        c.e.a.d.c0.d.getInstance().recyclerCache(this);
        c.e.a.a.g.a.getAppManager().finishAllActivity();
        c.e.a.d.y.get().shutDownThreadPool();
        v.getInstance().clearActionMap();
        p.getInstance().release();
    }

    @m
    public void onEventWxMiniBack(EventWxMiniBack eventWxMiniBack) {
        Intent intent = new Intent(this, (Class<?>) PayTypeActivity.class);
        intent.setFlags(268435456);
        intent.putExtra("only_start", true);
        startActivity(intent);
        q.d(getClass().getSimpleName(), "onEventWxMiniBack");
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            int backStackEntryCount = getSupportFragmentManager().getBackStackEntryCount();
            if (backStackEntryCount == 0) {
                if (S()) {
                    Intent intent = new Intent("android.intent.action.MAIN");
                    intent.setFlags(67108864);
                    intent.addCategory("android.intent.category.HOME");
                    startActivity(intent);
                    return true;
                }
                System.out.println("Exit App - finish");
                i0(new ExitAppEvent());
                finish();
            }
            if (backStackEntryCount == 2 && w.getInstance().getBoolean("isInitAppKey", true)) {
                i0(new ExitAppEvent());
                System.out.println("Exit App - postEventBus");
                System.exit(0);
            }
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.t.getBadgeCount();
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i2, float f2, int i3) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i2) {
        W0(i2);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (18 == i2) {
            this.t.handlerPermissions(iArr);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        q.d("MainActivity", "onResume");
        if (k.isNetworkAvailabe(this)) {
            x0();
            Z0();
            if (c.e.c.m0.c.getInstance().isUpdateAppAlertMessage() && Q()) {
                this.t.updateAlertMessage();
                return;
            }
            return;
        }
        this.t.getBadgeCount();
        if (!Q() || this.x != null) {
            e0(R.string.tip_network_unavailable);
            return;
        }
        S0();
        AppAlertFragment appAlertFragment = AppAlertFragment.getInstance(this.t.getNetworkAlertMessage());
        this.x = appAlertFragment;
        w0(appAlertFragment);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        q.d("MainActivity", "onStop");
    }

    @m(sticky = true, threadMode = r.MAIN)
    public void registerEventBadgeMsg(EventBadgeMsgVo eventBadgeMsgVo) {
        b0 b0Var = this.t;
        if (b0Var != null) {
            b0Var.updateMeBadge(eventBadgeMsgVo);
        }
        int badgeNumber = eventBadgeMsgVo.getBadgeNumber();
        if (eventBadgeMsgVo.isShowPaint()) {
            badgeNumber = 0;
        }
        h.setCount(badgeNumber, this);
    }

    @m(threadMode = r.BACKGROUND)
    public void registerEventSwitchRoomVo(EventSwitchRoomVo eventSwitchRoomVo) {
        b0 b0Var = this.t;
        if (b0Var != null) {
            b0Var.updateAlertMessage();
        }
        T0();
        q.d(MainActivity.class.getSimpleName(), "registerEventSwitchRoomVo requestData");
    }

    @m(threadMode = r.BACKGROUND)
    public void registerSwitchProject(EventLoginSuccessSwitchProject eventLoginSuccessSwitchProject) {
        b0 b0Var = this.t;
        if (b0Var != null) {
            b0Var.switchProjectId();
        }
    }

    @m
    public void showThankLatterFragment(EventShowNotKeepRent eventShowNotKeepRent) {
        b(NotKeepRentFragment.getInstance(), R.id.constraint_main_content, false);
    }

    @OnClick({R.id.rlayout_open_lock})
    public void unlock() {
        C0();
    }

    @m(threadMode = r.MAIN)
    public void unlockUpdateUserInfo(EventOpenLiveCheck eventOpenLiveCheck) {
        this.t.updateOpenLiveEvent(eventOpenLiveCheck);
    }

    @m(threadMode = r.MAIN)
    public void updateBuyCart(EventProductPayVo eventProductPayVo) {
        q.d(getClass().getSimpleName(), "on eventProductPayVo");
        this.f6780q = 3;
        Message messageObtainMessage = this.s.obtainMessage();
        messageObtainMessage.what = this.f6780q;
        this.s.sendMessageDelayed(messageObtainMessage, 300L);
    }

    public final void w0(BaseFragment baseFragment) {
        b(baseFragment, R.id.constraint_main_content, true);
    }

    public final void x0() {
        String string = w.getInstance().getString("app_info", null);
        if (!x.isNotNull(string)) {
            q.d(getClass().getSimpleName(), "checkUpdateApps updateAppInfo is null = " + string);
            return;
        }
        try {
            AppUpdateVo appUpdateVo = (AppUpdateVo) JSON.parseObject(string, AppUpdateVo.class);
            D0(appUpdateVo, c.e.a.a.b.getInstance().getAppVersion());
            q.d(getClass().getSimpleName(), "checkUpdateApps updateAppInfo = " + string + ",appUpdateVo:" + appUpdateVo.getVersionCode());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void y0() {
        if (c.e.a.a.b.getInstance().getAppVersion() < 154) {
            w.getInstance().clear();
        }
    }

    public final void z0() {
        this.s.postDelayed(new Runnable() { // from class: c.e.c.b
            @Override // java.lang.Runnable
            public final void run() {
                this.f1380a.J0();
            }
        }, m);
    }
}
