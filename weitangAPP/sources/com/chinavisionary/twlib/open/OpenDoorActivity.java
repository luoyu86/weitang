package com.chinavisionary.twlib.open;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.o;
import c.e.a.d.w;
import c.e.a.d.y;
import c.e.e.a.r.h;
import c.e.e.a.s.e;
import c.e.e.a.s.f;
import c.e.e.a.x.d;
import c.e.e.a.x.g;
import c.e.e.a.x.i;
import c.e.e.a.x.k;
import c.e.e.a.x.l;
import cn.com.heaton.blelibrary.ble.event.CommandResultEvent;
import cn.com.heaton.blelibrary.ble.event.ConnectionChangedEvent;
import com.alibaba.android.arouter.launcher.ARouter;
import com.alibaba.fastjson.JSON;
import com.chinavisionary.core.app.ad.manager.ADManager;
import com.chinavisionary.core.app.base.CoreBaseActivity;
import com.chinavisionary.core.app.config.bo.AppConfigExtVo;
import com.chinavisionary.core.app.config.bo.UserInfoVo;
import com.chinavisionary.core.app.event.EventOpenLiveCheck;
import com.chinavisionary.core.app.event.EventUnlockSuccess;
import com.chinavisionary.core.app.net.base.dto.NewResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.twlib.R;
import com.chinavisionary.twlib.open.base.TwBaseActivity;
import com.chinavisionary.twlib.open.bo.AlertMessageVo;
import com.chinavisionary.twlib.open.bo.ResponseOpenDoorVo;
import com.chinavisionary.twlib.open.bo.TwLibCheckCreateCommentBo;
import com.chinavisionary.twlib.open.model.NewOpenDoorModel;
import com.chinavisionary.twlib.open.model.OpenDoorModel;
import com.chinavisionary.twlib.open.model.OpenDoorPwdModel;
import g.b.a.m;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class OpenDoorActivity extends TwBaseActivity {
    public volatile boolean A;
    public volatile boolean B;
    public volatile boolean C;
    public f D;
    public c.e.e.a.r.a E;
    public ResponseOpenDoorVo F;
    public c.e.e.a.u.c G;
    public AppConfigExtVo.ADScreen.LockScreenBean H;
    public List<AlertMessageVo> k;
    public d l;
    public OpenDoorModel m;

    @BindView(2431)
    public ImageView mBackImg;

    @BindView(2433)
    public ImageView mBgImg;

    @BindView(2415)
    public FrameLayout mFrameLayout;

    @BindView(2384)
    public LinearLayout mLLprogressBar;

    @BindView(2329)
    public Button mRetryOpenUnlockBtn;

    @BindView(2915)
    public TextView mRoomTitleTv;

    @BindView(2937)
    public TextView mSplitLineTv;

    @BindView(2931)
    public TextView mTimerMsgTv;

    @BindView(2932)
    public TextView mTipMsgTv;

    @BindView(2935)
    public TextView mTitleTv;
    public NewOpenDoorModel n;
    public OpenDoorPwdModel o;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public CoreBaseActivity.a f8777q;
    public String r;
    public String s;
    public String t;
    public int u;
    public String v;
    public boolean w;
    public boolean x;
    public int p = 60;
    public final AtomicBoolean y = new AtomicBoolean(false);
    public final AtomicBoolean z = new AtomicBoolean(false);
    public c.e.e.a.r.d I = new b();
    public Runnable J = new c();

    public class a implements Observer<Integer> {
        public a() {
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(@Nullable Integer num) {
            OpenDoorActivity.this.mLLprogressBar.setVisibility(8);
            OpenDoorActivity.this.mRetryOpenUnlockBtn.setVisibility(0);
            if (num.intValue() == 1) {
                OpenDoorActivity.this.mRetryOpenUnlockBtn.setText("开锁");
                OpenDoorActivity.this.H0();
            } else {
                OpenDoorActivity.this.finish();
                OpenDoorActivity.this.J0("getError");
            }
        }
    }

    public class b implements c.e.e.a.r.d {
        public b() {
        }

        public final void a(String str) {
            if (OpenDoorActivity.this.D != null) {
                String remark = OpenDoorActivity.this.D.getRemark();
                if (k.isNotNull(str)) {
                    OpenDoorActivity.this.D.setFailReason(l.getInstance().getFailedMessage(str));
                    if (remark != null) {
                        OpenDoorActivity.this.D.setRemark(remark + "," + str);
                    } else {
                        OpenDoorActivity.this.D.setRemark(str);
                    }
                } else {
                    OpenDoorActivity.this.D.setFailReason(l.getInstance().getFailedMessage(remark));
                }
                OpenDoorActivity.this.D.setStatus(0);
                OpenDoorActivity.this.D.setOpenDoorEndTime(Long.valueOf(System.currentTimeMillis()));
            }
        }

        @Override // c.e.e.a.r.d
        public void onConnect() {
            OpenDoorActivity.this.y1(k.getString(R.string.tw_lib_tip_ble_connecting), 0);
        }

        @Override // c.e.e.a.r.d
        public void onConnectError(String str) {
            a(str);
            OpenDoorActivity.this.y1(k.getNotNullStr(str, k.getString(R.string.tw_lib_tip_ble_connect_failed)), 9);
        }

        @Override // c.e.e.a.r.d
        public void onScanEnd() {
            if (OpenDoorActivity.this.D != null) {
                OpenDoorActivity.this.D.setScanTime(Long.valueOf(System.currentTimeMillis()));
            }
        }

        @Override // c.e.e.a.r.d
        public void onScanError(String str) {
            a(str);
            OpenDoorActivity.this.y1(k.getNotNullStr(str, k.getString(R.string.tw_lib_tip_ble_scan_error)), 8);
        }

        @Override // c.e.e.a.r.d
        public void onScanStart() {
            OpenDoorActivity.this.y1(k.getString(R.string.tw_lib_tip_ble_scaning), 1);
        }

        @Override // c.e.e.a.r.d
        public void onUnlockFailed(String str) {
            a(str);
            OpenDoorActivity.this.y1(k.getNotNullStr(str, k.getString(R.string.tw_lib_tip_ble_open_lock_failed)), 7);
        }

        @Override // c.e.e.a.r.d
        public void onUnlockPwdFailed(String str) {
            if (OpenDoorActivity.this.D != null) {
                String remark = OpenDoorActivity.this.D.getRemark();
                if (!k.isNotNull(str)) {
                    OpenDoorActivity.this.D.setFailReason(l.getInstance().getFailedMessage(remark));
                    return;
                }
                OpenDoorActivity.this.D.setFailReason(l.getInstance().getFailedMessage(str));
                if (remark == null) {
                    OpenDoorActivity.this.D.setRemark(str);
                    return;
                }
                OpenDoorActivity.this.D.setRemark(remark + "," + str);
            }
        }

        @Override // c.e.e.a.r.d
        public void onUnlockSuccess() {
            if (OpenDoorActivity.this.D != null) {
                OpenDoorActivity.this.D.setStatus(1);
                OpenDoorActivity.this.D.setOpenDoorEndTime(Long.valueOf(System.currentTimeMillis()));
                OpenDoorActivity.this.D.setRemark(k.getString(R.string.tw_lib_tip_open_lock_success));
            }
            OpenDoorActivity.this.y1(k.getString(R.string.tw_lib_tip_open_lock_success), 6);
        }

        @Override // c.e.e.a.r.d
        public void onUnlocking() {
            OpenDoorActivity.this.y1(k.getString(R.string.tw_lib_tip_ble_open_lock), 0);
        }

        @Override // c.e.e.a.r.d
        public void uploadDoorCommands(List<c.m.a.e.a> list) {
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            OpenDoorActivity.this.w1();
            OpenDoorActivity.n0(OpenDoorActivity.this);
            if (OpenDoorActivity.this.p >= 0) {
                OpenDoorActivity.this.G1();
                return;
            }
            OpenDoorActivity.this.p = 60;
            OpenDoorActivity.this.mTimerMsgTv.setText("");
            OpenDoorActivity.this.mTipMsgTv.setText(k.getString(R.string.tw_lib_tip_ble_open_lock_timeout));
            OpenDoorActivity.this.v1();
            OpenDoorActivity.this.t1();
            OpenDoorActivity.this.mRetryOpenUnlockBtn.setVisibility(0);
        }
    }

    private void F() {
        Intent intent = getIntent();
        this.r = intent.getStringExtra("key");
        this.t = intent.getStringExtra("contractKey");
        this.s = intent.getStringExtra("roomNameKey");
        this.v = intent.getStringExtra("assetConfirmDeadline");
        this.w = intent.getBooleanExtra("isFirstOpenDoor", false);
        intent.getStringExtra("responseOpenDoorVo");
        this.x = 1 == intent.getIntExtra("open_type", -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c1(ResponseOpenDoorVo responseOpenDoorVo) {
        try {
            String jSONString = JSON.toJSONString(responseOpenDoorVo);
            String strEncodeToString = Base64.encodeToString(jSONString.getBytes(), 0);
            i.d(getClass().getSimpleName(), "cachePublicRoomPwd pwdJson:" + jSONString + ", encodeJson = " + strEncodeToString);
            c.e.e.a.t.b.getInstance().insertPwd(this.r, strEncodeToString);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: d1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e1() {
        if (this.x && w0() != null) {
            v0(Boolean.FALSE);
        } else if (w0() == null || !l.getInstance().isUseCache(this.r)) {
            this.y.getAndSet(false);
        } else {
            this.y.getAndSet(true);
            if (this.y.get()) {
                v0(Boolean.FALSE);
                i.d("OpenDoorActivity", "getCachePwd isUseCache");
            }
        }
        this.o.getDoorPwd(this.r, "OpenDoorActivity-getDoorPassword");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: f1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g1(NewResponseRowsVo newResponseRowsVo) {
        if (newResponseRowsVo != null) {
            try {
                if (newResponseRowsVo.getRows() != null) {
                    List<e> rows = newResponseRowsVo.getRows();
                    if (o.isNotEmpty(rows)) {
                        for (e eVar : rows) {
                            if (eVar != null && k.isNotNull(eVar.getContractKey()) && eVar.getContractKey().equals(this.t)) {
                                this.w = eVar.isAssetConfirmStatus();
                                this.v = eVar.getAssetConfirmDeadline();
                                i.d("OpenDoorActivity", "getLockRoomStateList isFirstOpenDoor = " + this.w + ", mAssetConfirmDeadline = " + this.v);
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: h1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void i1(String str) {
        this.mTipMsgTv.setText(k.getNotNullStr(str, ""));
        this.mRetryOpenUnlockBtn.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: j1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void k1(RequestErrDto requestErrDto) {
        if (requestErrDto.getCode() >= 500 && requestErrDto.getCode() <= 505 && l.getInstance().isEnableCache() && w0() != null) {
            this.B = true;
            v0(Boolean.TRUE);
            return;
        }
        if (requestErrDto.getCode() == 200) {
            c.e.e.a.t.b.getInstance().delPwd(this.r);
        }
        if (this.y.get()) {
            return;
        }
        final String errMsg = requestErrDto.getErrMsg();
        f openStateLogBo = this.G.getOpenStateLogBo(errMsg, this.r);
        u0(openStateLogBo.getRemark());
        this.o.postDoorPwdRecordLog(openStateLogBo);
        this.mTipMsgTv.post(new Runnable() { // from class: c.e.e.a.e
            @Override // java.lang.Runnable
            public final void run() {
                this.f2365a.i1(errMsg);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: l1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void m1(ResponseOpenDoorVo responseOpenDoorVo, String str, boolean z) {
        if (responseOpenDoorVo != null) {
            i.d(getClass().getSimpleName(), "handleUnLock method = " + str + "isOpenLock = " + z);
            if (z) {
                this.u = responseOpenDoorVo.getSupplierType();
                this.l = this.G.getBleUnlockResponse(responseOpenDoorVo);
                if (c.e.a.a.a.getInstance().isDebug()) {
                    N0();
                }
                c.e.e.a.r.a aVar = this.E;
                if (aVar == null) {
                    this.E = new h(this.u, this.I);
                } else {
                    aVar.release();
                }
                if (this.E != null) {
                    D0();
                }
            }
        }
    }

    public static /* synthetic */ int n0(OpenDoorActivity openDoorActivity) {
        int i2 = openDoorActivity.p;
        openDoorActivity.p = i2 - 1;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: p1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void q1(f fVar) {
        f fVar2 = new f(fVar);
        fVar2.setAppVersion(c.e.a.a.b.getInstance().getAppVersionName());
        String string = this.mTipMsgTv.getText().toString();
        if (k.isNotNull(string) && k.isNullStr(fVar2.getRemark())) {
            fVar2.setRemark(string);
        }
        if (fVar2.getOpenDoorEndTime() == null) {
            fVar2.setOpenDoorEndTime(Long.valueOf(System.currentTimeMillis()));
        }
        if (fVar2.getOpenDoorStartTime() != null && fVar2.getOpenDoorStartTime().longValue() > fVar2.getOpenDoorEndTime().longValue()) {
            fVar2.setOpenDoorStartTime(fVar2.getOpenDoorEndTime());
            fVar2.setOpenDoorEndTime(fVar2.getOpenDoorStartTime());
        }
        fVar2.setAssetInstanceKey(this.r);
        if (fVar2.getStatus().intValue() == 0) {
            u0(fVar2.getFailReason());
            boolean z = fVar2.getOpenDoorEndTime().longValue() - fVar2.getOpenDoorStartTime().longValue() > ((long) 10000);
            boolean z2 = fVar2.getOpenDoorEndTime().longValue() - fVar2.getOpenDoorStartTime().longValue() > ((long) 8000);
            if (string.contains(k.getString(R.string.tw_lib_ble_connect)) || string.contains(k.getString(R.string.tw_lib_tip_ble_scaning)) || z) {
                if (z) {
                    this.G.disableBle();
                }
                if (this.u == 0) {
                    if (z2) {
                        c.e.e.a.x.f.addRecordFailedCount();
                    }
                    fVar2.setFailReason(l.getInstance().getFailedMessage(k.getNotNullStr(fVar2.getFailReason(), "")));
                    c.e.e.a.x.f.addOpenFailedCount();
                }
            }
        } else if (this.u == 0) {
            c.e.e.a.x.f.removeFailedCountRecord();
        }
        if (k.isNotNull(fVar2.getTipMsg())) {
            String failReason = fVar2.getFailReason();
            if (k.isNotNull(failReason)) {
                fVar2.setFailReason(l.getInstance().getFailedMessage(failReason));
            } else {
                fVar2.setFailReason(l.getInstance().getFailedMessage(fVar2.getTipMsg()));
            }
            String remark = fVar2.getRemark();
            if (remark != null) {
                fVar2.setRemark(remark + "," + fVar2.getTipMsg());
            } else {
                fVar2.setRemark(fVar2.getTipMsg());
            }
        }
        i.d(getClass().getSimpleName(), "post door record log");
        this.o.postDoorPwdRecordLog(fVar2);
    }

    public final void A0(NewResponseRowsVo<AlertMessageVo> newResponseRowsVo) {
        if (B0(newResponseRowsVo, true)) {
            finish();
        }
        J0("handleAfterAlertMessage");
    }

    public final void A1() {
        g.b.a.c.getDefault().post(new EventUnlockSuccess());
    }

    public final boolean B0(NewResponseRowsVo<AlertMessageVo> newResponseRowsVo, boolean z) {
        if (newResponseRowsVo == null) {
            return true;
        }
        List<AlertMessageVo> rows = newResponseRowsVo.getRows();
        if (z && o.isNotEmpty(this.k)) {
            if (o.listIsEmpty(rows)) {
                rows = new ArrayList<>();
            }
            rows.addAll(this.k);
        }
        if (!o.isNotEmpty(rows)) {
            return true;
        }
        boolean z2 = true;
        for (AlertMessageVo alertMessageVo : rows) {
            if (alertMessageVo != null) {
                String href = alertMessageVo.getHref();
                if (k.isNotNull(href) && href.contains("http")) {
                    alertMessageVo.setMessageType(5);
                    alertMessageVo.setForwardType(1);
                }
                Bundle bundle = new Bundle();
                bundle.putParcelable("alertMessageVo", alertMessageVo);
                Fragment fragment = (Fragment) ARouter.getInstance().build("/message/window").navigation();
                fragment.setArguments(bundle);
                b(fragment, R.id.frame_layout, alertMessageVo.getForce() == null ? false : alertMessageVo.getForce().booleanValue());
                z2 = false;
            }
        }
        return z2;
    }

    public final void B1() {
        AppConfigExtVo appConfigExtVo = new AppConfigExtVo();
        AppConfigExtVo.ADScreen aDScreen = new AppConfigExtVo.ADScreen();
        aDScreen.setLockScreen(z0());
        appConfigExtVo.setAdScreenVo(aDScreen);
        D1();
        this.H = this.G.setupADScreen(appConfigExtVo, this.mBgImg);
    }

    public final void C0(NewResponseRowsVo<AlertMessageVo> newResponseRowsVo) {
        CoreBaseActivity.a aVar = this.f8777q;
        if (aVar != null) {
            aVar.removeMessages(98100);
        }
        if (B0(newResponseRowsVo, false) && !this.z.get()) {
            H0();
        } else {
            if (this.z.get()) {
                return;
            }
            this.mLLprogressBar.setVisibility(8);
            this.mRetryOpenUnlockBtn.setText("开锁");
            this.mRetryOpenUnlockBtn.setVisibility(0);
        }
    }

    public final void C1() {
        OpenDoorModel openDoorModel = (OpenDoorModel) c(OpenDoorModel.class);
        this.m = openDoorModel;
        openDoorModel.getRoomSelectLiveData().observe(this, new Observer() { // from class: c.e.e.a.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2376a.K0((ResponseStateVo) obj);
            }
        });
        this.m.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.e.a.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2377a.M0((RequestErrDto) obj);
            }
        });
        if (c.e.a.a.a.getInstance().isH5Model()) {
            NewOpenDoorModel newOpenDoorModel = (NewOpenDoorModel) c(NewOpenDoorModel.class);
            this.n = newOpenDoorModel;
            newOpenDoorModel.getRoomSelectLiveData().observe(this, new Observer() { // from class: c.e.e.a.k
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f2376a.K0((ResponseStateVo) obj);
                }
            });
            this.n.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.e.a.l
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f2377a.M0((RequestErrDto) obj);
                }
            });
        }
        OpenDoorPwdModel openDoorPwdModel = (OpenDoorPwdModel) c(OpenDoorPwdModel.class);
        this.o = openDoorPwdModel;
        openDoorPwdModel.getDoorVoMutableLiveData().observe(this, new Observer() { // from class: c.e.e.a.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2367a.Q0((ResponseOpenDoorVo) obj);
            }
        });
        this.o.getOpenDoorResult().observe(this, new Observer() { // from class: c.e.e.a.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2360a.I0((String) obj);
            }
        });
        this.o.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.e.a.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2373a.E0((RequestErrDto) obj);
            }
        });
        this.o.getmAlertMessageVoMutableLiveData().observe(this, new Observer() { // from class: c.e.e.a.p
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2382a.C0((NewResponseRowsVo) obj);
            }
        });
        this.o.getAfterAlertMessageVo().observe(this, new Observer() { // from class: c.e.e.a.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2361a.A0((NewResponseRowsVo) obj);
            }
        });
        this.o.getCheckSignCommentLive().observe(this, new Observer() { // from class: c.e.e.a.n
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2380a.G0((TwLibCheckCreateCommentBo) obj);
            }
        });
        this.o.getCheckCommentLive().observe(this, new Observer() { // from class: c.e.e.a.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2362a.F0((TwLibCheckCreateCommentBo) obj);
            }
        });
        this.o.getError().observe(this, new a());
        if (!k.isNotNull(this.t) || this.w) {
            return;
        }
        y0();
    }

    public final void D0() {
        if (this.G.isEnableBle()) {
            x1();
        } else {
            t0();
        }
    }

    public final void D1() {
        int screenWidth = c.e.a.d.k.getScreenWidth(this.mBgImg.getContext());
        int screenHeight = c.e.a.d.k.getScreenHeight(this.mBgImg.getContext());
        this.mBgImg.getResources().getDimensionPixelSize(R.dimen.dp_86);
        if (screenHeight > 1920 || screenWidth != 1080) {
            this.mBgImg.setScaleType(ImageView.ScaleType.FIT_XY);
        } else {
            this.mBgImg.setScaleType(ImageView.ScaleType.CENTER);
        }
    }

    public final void E0(final RequestErrDto requestErrDto) {
        i.d(getClass().getSimpleName(), "handleGetBlePwdErr");
        if (requestErrDto == null || !k.isNotNull(requestErrDto.getErrMsg())) {
            return;
        }
        if (requestErrDto.getUrl().contains("business/get/secretkey")) {
            new Thread(new Runnable() { // from class: c.e.e.a.m
                @Override // java.lang.Runnable
                public final void run() {
                    this.f2378a.k1(requestErrDto);
                }
            }).start();
            return;
        }
        if (requestErrDto.getUrl().contains("business/create/open/door")) {
            c.e.e.a.t.b.getInstance().insertOpenLog(this.D, G());
            return;
        }
        if (requestErrDto.getUrl().contains("message/bounced/open/doorlock/before")) {
            CoreBaseActivity.a aVar = this.f8777q;
            if (aVar != null) {
                aVar.removeMessages(98100);
            }
            if (this.z.get()) {
                return;
            }
            this.o.getError().postValue(1);
            return;
        }
        if (requestErrDto.getUrl().contains("message/bounced/open/doorlock/after")) {
            this.o.getError().postValue(0);
        } else if (requestErrDto.getUrl().contains("business/comment/sign/popup/data")) {
            G0(null);
        }
    }

    public final void E1() {
        boolean zIsNotNull = k.isNotNull(this.s);
        this.mBackImg.setImageResource(R.mipmap.tw_lib_ic_back_white);
        this.mRoomTitleTv.setVisibility(zIsNotNull ? 0 : 4);
        this.mRoomTitleTv.setText(k.getNotNullStr(this.s, k.getString(R.string.tw_lib_title_open_door)));
        this.mSplitLineTv.setVisibility(4);
        this.G = new c.e.e.a.u.c();
        this.f8777q = new CoreBaseActivity.a(this);
        this.k = l.getInstance().getBillAlertMessageVo();
    }

    public final void F0(TwLibCheckCreateCommentBo twLibCheckCreateCommentBo) {
        Integer userType;
        if (twLibCheckCreateCommentBo != null && twLibCheckCreateCommentBo.isNeedComment() && k.isNotNull(twLibCheckCreateCommentBo.getRentCommentKey())) {
            UserInfoVo userInfoVoH = H();
            if (userInfoVoH != null && (userType = userInfoVoH.getUserType()) != null && userType.intValue() != 3 && k.isNotNull(this.t)) {
                twLibCheckCreateCommentBo.setContractKey(this.t);
            }
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (this.A) {
                return;
            }
            g.b.a.c.getDefault().post(twLibCheckCreateCommentBo);
        }
    }

    public final void F1() {
        this.o.doorlockBefore();
        H1();
    }

    public final void G0(TwLibCheckCreateCommentBo twLibCheckCreateCommentBo) {
        Integer userType;
        if (twLibCheckCreateCommentBo != null && twLibCheckCreateCommentBo.isNeedComment() && k.isNotNull(twLibCheckCreateCommentBo.getRentCommentKey())) {
            UserInfoVo userInfoVoH = H();
            if (userInfoVoH != null && (userType = userInfoVoH.getUserType()) != null && userType.intValue() != 3 && k.isNotNull(this.t) && !this.w) {
                twLibCheckCreateCommentBo.setOpenAssetConfirm(true);
                twLibCheckCreateCommentBo.setAssetConfirmDate(this.v);
                twLibCheckCreateCommentBo.setContractKey(this.t);
            }
            this.A = true;
            g.b.a.c.getDefault().post(twLibCheckCreateCommentBo);
        } else {
            T0();
        }
        this.o.doorlockAfter();
    }

    public final void G1() {
        CoreBaseActivity.a aVar = this.f8777q;
        if (aVar != null) {
            aVar.postAtTime(this.J, SystemClock.uptimeMillis() + 1000);
        }
        this.mTimerMsgTv.setText(k.appendStringToResId(R.string.tw_lib_placeholder_bracket, String.valueOf(this.p)));
    }

    public final void H0() {
        this.mLLprogressBar.setVisibility(0);
        x0();
        this.mRetryOpenUnlockBtn.setVisibility(8);
    }

    public final void H1() {
        this.f8777q.removeMessages(98100);
        this.f8777q.sendEmptyMessageDelayed(98100, 3000L);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public void I(Message message) {
        if (message.what == 98100) {
            this.z.getAndSet(true);
            this.mRetryOpenUnlockBtn.setText("开锁");
            H0();
            i.d(getClass().getSimpleName(), "handlerMessage isTimeoutBefore");
        }
        this.mTipMsgTv.setText((String) message.obj);
        int i2 = message.what;
        if (i2 == 1) {
            I1();
            return;
        }
        switch (i2) {
            case 6:
                P0();
                break;
            case 7:
            case 9:
                R0();
                break;
            case 8:
                R0();
                this.G.disableBle();
                break;
        }
    }

    public final void I0(String str) {
        i.d(getClass().getSimpleName(), "handleOpenDoorLogState result");
    }

    public final void I1() {
        if (this.p < 60) {
            w1();
        }
        G1();
    }

    public final void J0(String str) {
        i.d(getClass().getSimpleName(), "handleOpenSuccessAlert method = " + str);
        A1();
    }

    public final void J1() {
        int i2 = this.u;
        if (i2 == 0 || i2 == 2) {
            L0();
        } else {
            this.mRetryOpenUnlockBtn.setText("重新开锁");
        }
    }

    public final void K0(ResponseStateVo responseStateVo) {
        this.G.sendUpdateSelectRoom(this.s, this.r);
        if (this.w) {
            return;
        }
        EventOpenLiveCheck eventOpenLiveCheck = new EventOpenLiveCheck();
        eventOpenLiveCheck.setContractKey(this.t);
        eventOpenLiveCheck.setFirstOpenUnlock(this.w);
        g.b.a.c.getDefault().post(eventOpenLiveCheck);
    }

    public final void K1() {
        this.B = true;
        this.l.setBluetoothPassword("{\"openDoor\":{\"command\":[\"9A30010FD3D0F485A4192B3C099300BDF3C425D3\",\"9A30020F8C114BA7F4F83FA988A49C789401B53E\",\"9A30030FA8769B1C50A26F9F81784F1A8E503421\",\"9A30040349E2D945\"]},\"setTime\":{\"command\":[\"9A20010fEB104165E307619C24675ADEBA6B45bb\",\"9A20020f77D1DC26147B8591EA19F120CED1E5d2\",\"9A200302033614\"]},\"unexecuteds\":[{\"command\":[\"9A30010fCD0C298474FC35002B3FB7321287C328\",\"9A30020f7851AB09F485C196DC28C69ED65C2F99\",\"9A30030f8A76D010712E0B6D7817860D0B6C368c\",\"9A300403BCB71F23\"],\"commandId\":\"ONE_SELF_CMD_0c8dd79420b448ba982260bd308bb313\"},{\"command\":[\"9A30010f90F9C5C921C35F7161569C572B2B0B60\",\"9A30020f3B51AB09F485C196DC28C69ED65C2Fda\",\"9A30030f8A767D35C7A20412894D447E9DF1543d\",\"9A300403CFA97223\"],\"commandId\":\"ONE_SELF_CMD_0c8dd79420b448ba982260bd308bb313\"},{\"command\":[\"9A30010f589850ECB096FA38891C180534446F31\",\"9A30020f129A457A7BCFBF04C058D2491366F300\",\"9A30030f5A5FB99D97B35CCD9743BBB4EE73FD13\",\"9A3004035CCC3F98\"],\"commandId\":\"ONE_SELF_CMD_c5c3278fe8924b4f8a3b23ec8ccb275e\"},{\"command\":[\"9A30010fF74B3CE33EEB75A2027FB802DC075A19\",\"9A30020f0993042C2AD0C9D0F85CB0390E92ED30\",\"9A30030f490750DAA741969C3AE5501D6A9E85f7\",\"9A300403417E0F07\"],\"commandId\":\"ONE_SELF_CMD_d4cdd8f240054b5ba0c85c8c7920ec28\"},{\"command\":[\"9A30010fC0A3FDF932C98C6B926E4620733BF86f\",\"9A30020fFF93042C2AD0C9D0F85CB0390E92EDc6\",\"9A30030f49076AE8D4B8CA8E3D37A6177ED10Dc1\",\"9A300403EC348D62\"],\"commandId\":\"81676c63ae9946549d2c07cc0d2cbfe4\"},{\"command\":[\"9A30010f5ECC78A0A7A1988EF90FA7D621AD80ef\",\"9A30020f599A457A7BCFBF04C058D2491366F34b\",\"9A30030f5A5FF7B81062128D61B8FE2C1C60B854\",\"9A30040368E477cc\"],\"commandId\":\"12f546c180fe418a8c450cd3f75d4f67\"},{\"command\":[\"9A30010f945A2CE9073DAB7CF530675841012B49\",\"9A30020f1351AB09F485C196DC28C69ED65C2Ff2\",\"9A30030f8A76086C65543CA1CCD15A7B0FC5CF31\",\"9A3004036EE4D865\"],\"commandId\":\"85640cb064554297a065ff4a50f8c967\"}]}");
        this.l.setBluetoothMac("D100AA000010");
        i.d(OpenDoorActivity.class.getSimpleName(), "testDoor mt");
    }

    public final void L0() {
        e eVar = new e();
        eVar.setAssetInstanceKey(this.r);
        eVar.setContractKey(this.t);
        NewOpenDoorModel newOpenDoorModel = this.n;
        if (newOpenDoorModel != null) {
            newOpenDoorModel.postSelectRoom(eVar);
        } else {
            this.m.postSelectRoom(eVar);
        }
    }

    public final void L1() {
        this.B = false;
        this.l.setBluetoothPassword("{\"openDoor\":{\"command\":[\"9A30010FD3D0F485A4192B3C099300BDF3C425D3\",\"9A30020F8C114BA7F4F83FA988A49C789401B53E\",\"9A30030FA8769B1C50A26F9F81784F1A8E503421\",\"9A30040349E2D945\"]},\"setTime\":{\"command\":[\"9A20010FCB34DB50995C5905677C979128086F91\",\"9A20020F779065F590C9C7741E41A0DC31EEABE7\",\"9A2003025BC6BC\"]},\"unexecuteds\":[{\"command\":[\"9A30010fE1DF27CC19B166F0872D5822EDABD596\",\"9A30020f5DAB6068E593C0F21F6C063C3A21CD18\",\"9A30030fA4B86EB1F2B4D6111BC4942D92F2C5bd\",\"9A3004033EA8A504\"]}]}");
        this.l.setBluetoothMac("D100AA000010");
        i.d(OpenDoorActivity.class.getSimpleName(), "testZxDoor");
    }

    public final void M0(RequestErrDto requestErrDto) {
        i.d(getClass().getSimpleName(), "handleSwitchRoomErr");
        if (requestErrDto == null || !requestErrDto.getUrl().contains("houses/swtich")) {
            return;
        }
        finish();
    }

    public final void M1() {
        if (g.b.a.c.getDefault().isRegistered(this)) {
            g.b.a.c.getDefault().unregister(this);
        }
    }

    public final void N0() {
        if (g.getInstance().getTestDoorType() != null) {
            int iIntValue = g.getInstance().getTestDoorType().intValue();
            if (iIntValue == 1) {
                this.u = 1;
                this.l.setBluetoothMac("e0:19:94:f1:ec:fc");
                this.l.setBluetoothPassword("{\"appEkey\":\"3f65f14fbee834682ff90642cad2795c000000000000000000000011111111111000\",\"communityId\":9115,\"devMac\":\"e0:19:94:f1:ec:fc\",\"devName\":\"78栋二楼办公室\",\"devSn\":\"2498882812\",\"devType\":2,\"deviceId\":331632,\"deviceModelValue\":433,\"eKey\":\"3f65f14fbee834682ff90642cad2795c000000000000000000000011111111111000\",\"miniEkey\":\"AC01054ff1653f6834e8be4206f92f5c79d2ca\",\"openMode\":3,\"privilege\":4,\"useCount\":0,\"verified\":1}");
                return;
            }
            if (iIntValue == 2) {
                this.u = 2;
                this.l.setBluetoothMac("1E:98:6C:00:2D:27");
                this.l.setBluetoothCookie("{\"SuperUserKey\":\"4616A27F50B4A77BE6CF027822E97F61E48E7574AB7EC3401749AB799EDCB6B4\",\"SuperDataSecret\":\"ACBC684EFCCCDA5726144FF613F82980\"}");
                this.l.setBluetoothPassword("{\"BluetoothDataSecret\":\"ACBC684EFCCCDA5726144FF613F82980\",\"UnixTimestamp\":1706167323,\"BluetoothUserKey\":\"31E962A53E57E334930814F91FE1D6DCA2530E5538D66E48FEA35DC269162186\"}");
                return;
            }
            if (iIntValue == 3) {
                this.u = 0;
                this.l.setBluetoothMac("00a0507b3691");
                this.l.setBluetoothCookie("7b9cb9635e34478534eabb082ea214c60000004d");
                this.l.setBluetoothPassword("87fb70c649401abd5e30f1228fe9dc50000000ea");
                return;
            }
            if (iIntValue == 4) {
                this.u = 15;
                K1();
            } else {
                if (iIntValue != 5) {
                    return;
                }
                this.u = 16;
                L1();
            }
        }
    }

    public final void N1() {
        if (this.C) {
            return;
        }
        t1();
    }

    public final void O0(final ResponseOpenDoorVo responseOpenDoorVo, final boolean z, final String str) {
        this.mRoomTitleTv.post(new Runnable() { // from class: c.e.e.a.h
            @Override // java.lang.Runnable
            public final void run() {
                this.f2369a.m1(responseOpenDoorVo, str, z);
            }
        });
    }

    public final void O1() {
        if (this.D == null) {
            this.D = new f();
        }
        this.D.setTipMsg(null);
        this.D.setOpenDoorStartTime(Long.valueOf(System.currentTimeMillis()));
        if (this.E != null && this.l != null) {
            if (this.B) {
                this.D.setUserCacheOpenDoor(Boolean.TRUE);
            } else {
                this.D.setUserCacheOpenDoor(null);
            }
            this.E.openDoor(this.l, this, this.D);
        }
        ADManager.getInstance().loadLockInterstitialAd(this);
    }

    public final void P0() {
        w1();
        J1();
        t1();
        this.o.getCheckSignComment();
        String str = this.t;
        if (str != null) {
            this.o.getCheckCreateComment(str);
        }
    }

    public final void Q0(ResponseOpenDoorVo responseOpenDoorVo) {
        boolean z = this.F == null;
        this.B = false;
        if (responseOpenDoorVo != null) {
            if (responseOpenDoorVo.getAdapterModel() != null) {
                Integer doorType = c.e.e.a.u.c.getDoorType(responseOpenDoorVo.getAdapterModel());
                if (doorType == null) {
                    return;
                }
                if (doorType.intValue() == 15 || doorType.intValue() == 16) {
                    responseOpenDoorVo.setBluetoothPassword(responseOpenDoorVo.getResultData());
                }
                responseOpenDoorVo.setSupplierType(doorType.intValue());
            }
            this.u = responseOpenDoorVo.getSupplierType();
            boolean z2 = (this.y.get() || 1 == this.u) ? z : true;
            s0(this.u, responseOpenDoorVo);
            z = z2;
        }
        O0(responseOpenDoorVo, z, "handlerResponseSuccess");
    }

    public final void R0() {
        v1();
        w1();
        this.p = 60;
        this.F = null;
        t1();
        this.mRetryOpenUnlockBtn.setVisibility(0);
    }

    public final void S0() {
        this.mLLprogressBar.setVisibility(0);
        this.mRetryOpenUnlockBtn.setText("开锁");
        this.mRetryOpenUnlockBtn.setVisibility(8);
    }

    public final void T0() {
        Integer userType;
        UserInfoVo userInfoVoH = H();
        if (userInfoVoH == null || (userType = userInfoVoH.getUserType()) == null || userType.intValue() == 3 || !k.isNotNull(this.t) || this.w) {
            return;
        }
        ARouter.getInstance().build("/live_check/live_check").withBoolean("isFinish", true).withString("key", this.t).withBoolean("isShowAlert", this.v != null).withString("showDate", this.v).navigation();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public void U(View view) {
        int id = view.getId();
        if (id == R.id.img_ble_open_door_bg) {
            r0();
        } else if (id == R.id.tv_alert_cancel) {
            r1(k.getString(R.string.tw_lib_tip_ble_need_open_location_function));
        } else if (id == R.id.tv_alert_confirm) {
            this.G.performOpenGPS(this, 1);
        }
    }

    @OnClick({2881})
    public void backClick() {
        finish();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public int getLayoutId() {
        return R.layout.tw_lib_fragment_bluetooth_open_door;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public void initView(Bundle bundle) {
        g.getInstance().setAppContext(this);
        F();
        u1();
        E1();
        B1();
        C1();
        F1();
        S0();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1 && this.G.checkGPSIsOpen(this)) {
            D0();
        } else if (i2 == 2) {
            D0();
        }
    }

    @m
    public void onCommandResult(CommandResultEvent commandResultEvent) {
        i.d(getClass().getSimpleName(), "onCommandResult resultCode:" + commandResultEvent.getResultCode());
        c.e.e.a.r.a aVar = this.E;
        if (aVar != null) {
            aVar.onCommandResult(commandResultEvent);
        }
    }

    @m
    public void onConnectionChanged(ConnectionChangedEvent connectionChangedEvent) {
        i.d(getClass().getSimpleName(), "onConnectionChanged status:" + connectionChangedEvent.getStatus());
        c.e.e.a.r.a aVar = this.E;
        if (aVar != null) {
            aVar.onConnectionChanged(connectionChangedEvent);
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        M1();
        v1();
        this.F = null;
        w1();
        this.f8777q = null;
        this.G.startOpenDoorService(this, this.u, G());
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (18 == i2) {
            if (this.G.isAuthPermission(strArr, iArr)) {
                s1();
            } else {
                r1(k.getString(R.string.tw_lib_tip_open_location_permission));
            }
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (isFinishing()) {
            N1();
        }
    }

    public final void r0() {
        AppConfigExtVo.ADScreen.LockScreenBean lockScreenBean = this.H;
        if (lockScreenBean != null) {
            f0(lockScreenBean.getForwardType(), this.H.getHref(), this.H.getTitle());
        }
    }

    public final void r1(String str) {
        this.mTipMsgTv.setText(str);
        this.mRetryOpenUnlockBtn.setVisibility(0);
    }

    @OnClick({2329})
    public void retryOpenUnlockBtn(View view) {
        H0();
    }

    public final void s0(int i2, final ResponseOpenDoorVo responseOpenDoorVo) {
        if (responseOpenDoorVo != null) {
            y.get().addRunnable(new Runnable() { // from class: c.e.e.a.d
                @Override // java.lang.Runnable
                public final void run() {
                    this.f2363a.c1(responseOpenDoorVo);
                }
            });
        }
    }

    public final void s1() {
        if (!this.G.checkGPSIsOpen(this)) {
            c0(k.getString(R.string.tw_lib_tip_ble_scan_need_open_location));
        } else if (this.G.isEnableBle()) {
            O1();
        } else {
            t0();
        }
    }

    public final void t0() {
        this.mTipMsgTv.setVisibility(0);
        this.mTipMsgTv.setText(R.string.tw_lib_tip_ble_un_enable);
        if (!this.G.getAllPermission(this)) {
            x1();
            return;
        }
        Intent intent = new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE");
        intent.setFlags(268435456);
        startActivityForResult(intent, 2);
    }

    public final void t1() {
        if (this.D != null) {
            this.C = true;
            if (this.B) {
                this.D.setTipMsg(k.getString(R.string.title_server_err_cache_pwd));
            }
            z1(this.D);
        }
    }

    public final void u0(String str) {
        StringBuilder sb = new StringBuilder(3);
        sb.append(G());
        sb.append(str);
        if (k.isNotNull(this.s)) {
            sb.append(this.s);
        }
        d(1, sb.toString());
    }

    public final void u1() {
        if (g.b.a.c.getDefault().isRegistered(this)) {
            return;
        }
        g.b.a.c.getDefault().register(this);
    }

    public final void v0(Boolean bool) {
        ResponseOpenDoorVo responseOpenDoorVoW0 = w0();
        this.F = responseOpenDoorVoW0;
        if (responseOpenDoorVoW0 == null) {
            this.B = false;
        } else {
            i.d("OpenDoorActivity", "getCachePwd handleUnLock");
            O0(this.F, true, "getCachePwd");
        }
    }

    public final void v1() {
        c.e.e.a.r.a aVar = this.E;
        if (aVar != null) {
            aVar.release();
        }
    }

    public final ResponseOpenDoorVo w0() {
        String pwdToAssetKey;
        ResponseOpenDoorVo responseOpenDoorVo;
        Exception e2;
        if (this.r == null || (pwdToAssetKey = c.e.e.a.t.b.getInstance().getPwdToAssetKey(this.r)) == null) {
            return null;
        }
        try {
            responseOpenDoorVo = (ResponseOpenDoorVo) JSON.parseObject(pwdToAssetKey, ResponseOpenDoorVo.class);
            try {
                responseOpenDoorVo.getBluetoothPassword();
            } catch (Exception e3) {
                e2 = e3;
                e2.printStackTrace();
            }
        } catch (Exception e4) {
            responseOpenDoorVo = null;
            e2 = e4;
        }
        ResponseOpenDoorVo responseOpenDoorVo2 = responseOpenDoorVo;
        i.d(getClass().getSimpleName(), "getDoorPassword cache data : " + pwdToAssetKey);
        return responseOpenDoorVo2;
    }

    public final void w1() {
        CoreBaseActivity.a aVar = this.f8777q;
        if (aVar != null) {
            aVar.removeCallbacksAndMessages(null);
        }
    }

    public final void x0() {
        new Thread(new Runnable() { // from class: c.e.e.a.g
            @Override // java.lang.Runnable
            public final void run() {
                this.f2368a.e1();
            }
        }).start();
    }

    public final void x1() {
        if (Build.VERSION.SDK_INT < 23) {
            s1();
            return;
        }
        List<String> allMustPermission = this.G.getAllMustPermission();
        if (this.G.checkAllMustPermission(allMustPermission, this)) {
            s1();
            return;
        }
        String[] strArr = new String[allMustPermission.size()];
        allMustPermission.toArray(strArr);
        ActivityCompat.requestPermissions(this, strArr, 18);
    }

    public final void y0() {
        this.m.getLockStateListLiveData().observe(this, new Observer() { // from class: c.e.e.a.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2381a.g1((NewResponseRowsVo) obj);
            }
        });
        if (k.isNotNull(this.t)) {
            this.m.getLockRoomStateList(this.r, this.t);
        }
    }

    public final void y1(String str, int i2) {
        CoreBaseActivity.a aVar = this.f8777q;
        if (aVar != null) {
            aVar.obtainMessage(i2, str).sendToTarget();
        }
    }

    public final AppConfigExtVo.ADScreen.LockScreenBean z0() {
        String string = w.getInstance().getString("open_door_ad", null);
        if (!k.isNotNull(string)) {
            return null;
        }
        try {
            return (AppConfigExtVo.ADScreen.LockScreenBean) JSON.parseObject(string, AppConfigExtVo.ADScreen.LockScreenBean.class);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public final void z1(final f fVar) {
        y.get().addRunnable(new Runnable() { // from class: c.e.e.a.j
            @Override // java.lang.Runnable
            public final void run() {
                this.f2374a.q1(fVar);
            }
        });
    }
}
