package c.e.c.v.f;

import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.chinavisionary.core.app.config.bo.AppConfigExtVo;
import com.chinavisionary.core.app.config.bo.AppUpdateVo;
import com.chinavisionary.core.app.config.bo.UserInfoVo;
import com.chinavisionary.core.app.event.EventOpenLiveCheck;
import com.chinavisionary.core.app.net.base.dto.NewResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.app.net.version.model.AppVersionModel;
import com.chinavisionary.core.app.oss.bo.AliYunOssResultVo;
import com.chinavisionary.core.app.oss.bo.AliYunTokenConfigBo;
import com.chinavisionary.core.app.oss.bo.BucketBo;
import com.chinavisionary.microtang.comment.CommentActivity;
import com.chinavisionary.microtang.comment.model.CommentModel;
import com.chinavisionary.microtang.comment.vo.CheckCreateCommentBo;
import com.chinavisionary.microtang.main.bo.ResponseAliYunOssBo;
import com.chinavisionary.microtang.main.event.EventBadgeMsgVo;
import com.chinavisionary.microtang.main.event.EventOssUpdateSuccess;
import com.chinavisionary.microtang.main.model.NewRoomModel;
import com.chinavisionary.microtang.me.bo.ResponseManagerQrCodeBo;
import com.chinavisionary.microtang.me.model.NewUserModel;
import com.chinavisionary.microtang.me.model.NewUserOperateModel;
import com.chinavisionary.microtang.me.model.UserModel;
import com.chinavisionary.microtang.me.model.UserOperateModel;
import com.chinavisionary.microtang.msg.model.MsgModel;
import com.chinavisionary.microtang.msg.vo.BadgeCountVo;
import com.chinavisionary.twlib.open.bo.AlertMessageVo;
import com.chinavisionary.twlib.open.model.OpenDoorPwdModel;
import com.google.android.material.tabs.TabLayout;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public y f1932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FragmentActivity f1933b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f1934c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f1935d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public UserModel f1938g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public NewUserModel f1939h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public NewUserOperateModel f1940i;
    public MsgModel j;
    public AppVersionModel k;
    public UserOperateModel l;
    public NewRoomModel m;
    public a0 o;
    public d0 p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public i0 f1941q;
    public c0 r;
    public CommentModel t;
    public z u;
    public e0 v;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f1936e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f1937f = false;
    public volatile boolean w = false;
    public j0 n = new j0();
    public l0 s = new l0();

    public class a implements c.e.a.a.i.c.a {
        public a() {
        }

        @Override // c.e.a.a.i.c.a
        public void onFailed(String str) {
            b0.this.w = false;
            c.e.a.d.q.d(a.class.getSimpleName(), "onFailed errMsg = " + str);
        }

        @Override // c.e.a.a.i.c.a
        public void onSuccess(List<AliYunOssResultVo> list) {
            c.e.c.p.b.getInstance().insertPicData(list);
            c.e.a.a.i.b.getInstance().setList(list);
            b0.this.w = false;
            b0.this.H();
            c.e.a.d.q.d(a.class.getSimpleName(), "onSuccess");
        }
    }

    public b0(z zVar, y yVar) {
        this.f1932a = yVar;
        this.u = zVar;
        this.f1933b = zVar.getCurrentActivity();
        this.o = new a0(zVar);
        this.p = new d0(this.f1933b);
        this.r = new c0(zVar);
        this.f1941q = new i0(zVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void B(RequestErrDto requestErrDto) {
        this.w = false;
    }

    public static /* synthetic */ void D(String str, OpenDoorPwdModel openDoorPwdModel) {
        List<c.e.e.a.s.f> allOpenLog = c.e.e.a.t.b.getInstance().getAllOpenLog(str);
        if (!c.e.a.d.o.isNotEmpty(allOpenLog)) {
            c.e.a.d.q.d(b0.class.getSimpleName(), "log is null");
            return;
        }
        c.e.e.a.s.b bVar = new c.e.e.a.s.b();
        bVar.setRecords(allOpenLog);
        openDoorPwdModel.postBatchDoorPwdRecordLog(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void x(ResponseAliYunOssBo responseAliYunOssBo) {
        if (!c.e.a.d.x.isNotNull(responseAliYunOssBo.getBucketName()) || !c.e.a.d.x.isNotNull(responseAliYunOssBo.getAccessKeyId()) || !c.e.a.d.x.isNotNull(responseAliYunOssBo.getSecretKeyId()) || !c.e.a.d.x.isNotNull(responseAliYunOssBo.getSecurityToken()) || !c.e.a.d.x.isNotNull(responseAliYunOssBo.getEndpoint())) {
            c.e.a.d.q.d(b0.class.getSimpleName(), "getAliYunOss param is empty");
            return;
        }
        c.e.a.a.i.a aVar = new c.e.a.a.i.a(c.e.a.a.b.getInstance().getContext());
        AliYunTokenConfigBo aliYunTokenConfigBo = new AliYunTokenConfigBo();
        aliYunTokenConfigBo.setAccessKeyId(responseAliYunOssBo.getAccessKeyId());
        aliYunTokenConfigBo.setSecretKeyId(responseAliYunOssBo.getSecretKeyId());
        aliYunTokenConfigBo.setSecurityToken(responseAliYunOssBo.getSecurityToken());
        aliYunTokenConfigBo.setEndpoint(responseAliYunOssBo.getEndpoint().trim());
        BucketBo bucketBo = new BucketBo();
        bucketBo.setBucketName(responseAliYunOssBo.getBucketName());
        bucketBo.setCallback(new a());
        c.e.a.d.q.d(b0.class.getSimpleName(), "getAliYunOss");
        aVar.getAliYunOssUrl(aliYunTokenConfigBo, bucketBo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void z(ResponseAliYunOssBo responseAliYunOssBo) {
        if (responseAliYunOssBo != null) {
            c.e.a.d.q.d(b0.class.getSimpleName(), "loadAliYunOssResource getAliYunOssAuthResult methodName = initModel ");
            c(responseAliYunOssBo);
        }
    }

    public final void E(AppConfigExtVo appConfigExtVo) {
        if (appConfigExtVo != null) {
            c.e.a.d.g.getInstance().setupAppConfig(appConfigExtVo);
            c.e.a.d.w.getInstance().putString("app_config_info", JSON.toJSONString(appConfigExtVo));
        }
    }

    public final void F(String str) {
        c.e.a.d.w.getInstance().putString("userDetailsInfoKey", str);
    }

    public final void G(BadgeCountVo badgeCountVo) {
        EventBadgeMsgVo eventBadgeMsgVo = new EventBadgeMsgVo();
        eventBadgeMsgVo.setShow(badgeCountVo.isShowNumber());
        eventBadgeMsgVo.setShowPaint(badgeCountVo.isShowPoint());
        eventBadgeMsgVo.setBadgeNumber(badgeCountVo.getUnreadCount());
        g.b.a.c.getDefault().postSticky(eventBadgeMsgVo);
        c.e.a.d.q.d(b0.class.getSimpleName(), "sendUpdateBadgeEvent getUnreadCount :" + badgeCountVo.getUnreadCount());
    }

    public final void H() {
        EventOssUpdateSuccess eventOssUpdateSuccess = new EventOssUpdateSuccess();
        eventOssUpdateSuccess.setMethodName("sendUpdateSuccessOss");
        g.b.a.c.getDefault().post(eventOssUpdateSuccess);
    }

    public final void I(final String str) {
        if (this.f1932a.isLoginState() && c.e.c.m0.k.isNetworkAvailabe(this.f1933b)) {
            c.e.a.d.q.d(b0.class.getSimpleName(), "setupOpenDoorPwdModel");
            final OpenDoorPwdModel openDoorPwdModel = (OpenDoorPwdModel) ViewModelProviders.of(this.f1933b).get(OpenDoorPwdModel.class);
            c.e.a.d.y.get().addRunnable(new Runnable() { // from class: c.e.c.v.f.b
                @Override // java.lang.Runnable
                public final void run() {
                    b0.D(str, openDoorPwdModel);
                }
            });
        }
    }

    public final void J() {
        if (this.f1932a != null) {
            e0 e0Var = new e0();
            this.v = e0Var;
            e0Var.setSplashAdLoadManager(this.f1941q);
            this.v.s(this.f1933b, this.f1932a.isRent());
        }
    }

    public final void K() {
        this.s.c(this.f1938g, this.f1939h, this.f1933b);
    }

    public final void L(AppConfigExtVo appConfigExtVo) {
        if (appConfigExtVo != null) {
            boolean zIsEnableEmergencyLock = appConfigExtVo.isEnableEmergencyLock();
            c.e.e.a.x.l.getInstance().setEnableCache(zIsEnableEmergencyLock);
            c.e.a.d.w.getInstance().putBoolean("is_enable_cache_key", zIsEnableEmergencyLock);
        }
    }

    public final void c(final ResponseAliYunOssBo responseAliYunOssBo) {
        c.e.a.d.y.get().addRunnable(new Runnable() { // from class: c.e.c.v.f.f
            @Override // java.lang.Runnable
            public final void run() {
                this.f1952a.x(responseAliYunOssBo);
            }
        });
    }

    public void clickBannerRecord(String str) {
        e0 e0Var = this.v;
        if (e0Var != null) {
            e0Var.a(str);
        }
    }

    public final AppConfigExtVo.ADScreen.SplashScreenBean d() {
        String string = c.e.a.d.w.getInstance().getString("splash_ad", null);
        if (!c.e.a.d.x.isNotNull(string)) {
            return null;
        }
        try {
            return (AppConfigExtVo.ADScreen.SplashScreenBean) JSON.parseObject(string, AppConfigExtVo.ADScreen.SplashScreenBean.class);
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public final void e(AppConfigExtVo appConfigExtVo) {
        if (appConfigExtVo != null) {
            c.e.c.m0.c.getInstance().setAppConfigExtVo(appConfigExtVo);
            appConfigExtVo.setAdScreenVo(null);
            if (c.e.a.d.x.isNotNull(this.f1932a.getScanResult())) {
                h(appConfigExtVo, this.f1932a.getScanResult());
            }
            E(appConfigExtVo);
            L(appConfigExtVo);
        }
    }

    public final void f(CheckCreateCommentBo checkCreateCommentBo) {
        if (checkCreateCommentBo != null && checkCreateCommentBo.isNeedComment() && c.e.a.d.x.isNotNull(checkCreateCommentBo.getRentCommentKey())) {
            Intent intent = new Intent(this.f1933b, (Class<?>) CommentActivity.class);
            intent.setFlags(268435456);
            intent.putExtra("key", checkCreateCommentBo.getRentCommentKey());
            this.f1933b.startActivity(intent);
            if (c.e.a.d.x.isNotNull(checkCreateCommentBo.getMessageKey())) {
                c.e.c.z.c.a.checkIsClearNotify(checkCreateCommentBo.getMessageKey());
                postReadMsgKey(checkCreateCommentBo.getMessageKey());
            }
        }
    }

    public final void g(ResponseManagerQrCodeBo responseManagerQrCodeBo) {
        c.e.c.m0.o.getInstance().setResponseManagerQrCodeBo(responseManagerQrCodeBo);
    }

    public void getBadgeCount() {
        if (this.j == null || !this.f1932a.isLoginState()) {
            return;
        }
        this.j.getMsgCount();
    }

    public List<Fragment> getFragments() {
        return this.n.a();
    }

    public void getIsNeedComment(String str) {
        this.t.getCheckCreateComment(str);
    }

    public void getIsNeedSignComment() {
        this.t.getCheckSignComment();
    }

    public AlertMessageVo getNetworkAlertMessage() {
        return this.o.c();
    }

    public void getOnlyRefreshUserInfo() {
        this.f1936e = true;
        NewUserOperateModel newUserOperateModel = this.f1940i;
        if (newUserOperateModel != null) {
            newUserOperateModel.getUserInfo();
        }
    }

    public void getUserInfo() {
        this.f1936e = false;
        NewUserOperateModel newUserOperateModel = this.f1940i;
        if (newUserOperateModel != null) {
            newUserOperateModel.getUserInfo();
        }
    }

    public final void h(AppConfigExtVo appConfigExtVo, String str) {
        this.r.b(appConfigExtVo, str);
    }

    public void handlerPermissions(int[] iArr) {
        this.p.a(iArr);
    }

    public void hiedSplashAd() {
        this.f1941q.hiedSplashImg();
    }

    public final void i(UserInfoVo userInfoVo) {
        Integer userType;
        if (userInfoVo != null) {
            if (c.e.a.d.x.isNotNull(userInfoVo.getPersonName())) {
                c.e.a.a.b.getInstance().setUserName(userInfoVo.getPersonName());
            } else {
                c.e.a.a.b.getInstance().setUserName(userInfoVo.getNickname());
            }
            c.e.a.a.b.getInstance().setUserKey(userInfoVo.getUserKey());
            F(JSON.toJSONString(userInfoVo));
        }
        if (!c.e.a.d.x.isNotNull(this.f1935d)) {
            if (this.f1936e) {
                return;
            }
            this.l.getAlertMessage(null);
        } else {
            if (userInfoVo == null || (userType = userInfoVo.getUserType()) == null) {
                return;
            }
            userType.intValue();
        }
    }

    public void initView(AppConfigExtVo appConfigExtVo) {
        this.o.i(appConfigExtVo);
        L(appConfigExtVo);
        this.f1941q.o(d());
        J();
    }

    public final void j(NewResponseRowsVo<AlertMessageVo> newResponseRowsVo) {
        this.o.d(newResponseRowsVo, this.f1937f);
        this.f1932a.unRegisterNetworkReceive();
        this.f1937f = false;
    }

    public final void k(AppUpdateVo appUpdateVo) {
        UserOperateModel userOperateModel;
        this.o.f(appUpdateVo, c.e.a.a.b.getInstance().getAppVersion(this.f1933b));
        if (this.f1932a.isLoginState() && this.f1932a.isNetworkConnectRequest() && (userOperateModel = this.l) != null) {
            userOperateModel.getAlertMessage(null);
        }
    }

    public final void l(NewResponseRowsVo<AlertMessageVo> newResponseRowsVo) {
        this.o.d(newResponseRowsVo, true);
        this.f1937f = false;
    }

    public void loadAliYunOssResource(String str) {
    }

    public final void m(NewResponseRowsVo<AlertMessageVo> newResponseRowsVo) {
        if (newResponseRowsVo == null || !c.e.a.d.o.isNotEmpty(newResponseRowsVo.getRows())) {
            return;
        }
        for (int i2 = 0; i2 < newResponseRowsVo.getRows().size(); i2++) {
            this.o.g(newResponseRowsVo.getRows().get(i2));
        }
    }

    public final void n() {
        MsgModel msgModel = (MsgModel) ViewModelProviders.of(this.f1933b).get(MsgModel.class);
        this.j = msgModel;
        msgModel.getMsgCountLiveData().observe(this.f1933b, new Observer() { // from class: c.e.c.v.f.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1980a.G((BadgeCountVo) obj);
            }
        });
        this.t = (CommentModel) ViewModelProviders.of(this.f1933b).get(CommentModel.class);
        NewRoomModel newRoomModel = (NewRoomModel) ViewModelProviders.of(this.f1933b).get(NewRoomModel.class);
        this.m = newRoomModel;
        newRoomModel.getAliYunOssAuthResult().observe(this.f1933b, new Observer() { // from class: c.e.c.v.f.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1982a.z((ResponseAliYunOssBo) obj);
            }
        });
        this.m.getErrRequestLiveData().observe(this.f1933b, new Observer() { // from class: c.e.c.v.f.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1926a.B((RequestErrDto) obj);
            }
        });
        this.t.getCheckCreateCommentLive().observeForever(new Observer() { // from class: c.e.c.v.f.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1956a.f((CheckCreateCommentBo) obj);
            }
        });
        this.t.getCheckSignCommentLive().observeForever(new Observer() { // from class: c.e.c.v.f.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1956a.f((CheckCreateCommentBo) obj);
            }
        });
        this.l.getAlertMessageList().observe(this.f1933b, new Observer() { // from class: c.e.c.v.f.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1943a.j((NewResponseRowsVo) obj);
            }
        });
        this.l.getCancelContractResult().observe(this.f1933b, new Observer() { // from class: c.e.c.v.f.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1945a.m((NewResponseRowsVo) obj);
            }
        });
        this.l.getBillAlertMessageList().observe(this.f1933b, new Observer() { // from class: c.e.c.v.f.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1947a.l((NewResponseRowsVo) obj);
            }
        });
        this.l.getAppConfigLiveData().observe(this.f1933b, new Observer() { // from class: c.e.c.v.f.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1963a.e((AppConfigExtVo) obj);
            }
        });
        NewUserOperateModel newUserOperateModel = this.f1940i;
        if (newUserOperateModel != null) {
            newUserOperateModel.getUserInfoVoResult().observe(this.f1933b, new Observer() { // from class: c.e.c.v.f.j
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f1976a.i((UserInfoVo) obj);
                }
            });
            this.f1940i.getManagerQrCodeResult().observe(this.f1933b, new Observer() { // from class: c.e.c.v.f.h
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f1958a.g((ResponseManagerQrCodeBo) obj);
                }
            });
        }
        this.k.getUpdateVoMutableLiveData().observe(this.f1933b, new Observer() { // from class: c.e.c.v.f.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1987a.k((AppUpdateVo) obj);
            }
        });
        updateAppVersion();
    }

    public void postReadMsgKey(String str) {
        getBadgeCount();
    }

    public void setModel(NewUserModel newUserModel, NewUserOperateModel newUserOperateModel, UserModel userModel, AppVersionModel appVersionModel, UserOperateModel userOperateModel, String str) {
        this.f1939h = newUserModel;
        this.f1940i = newUserOperateModel;
        this.f1938g = userModel;
        this.k = appVersionModel;
        this.l = userOperateModel;
        n();
        I(str);
    }

    public void setupTab(TabLayout tabLayout) {
        this.n.d(tabLayout);
    }

    public void switchProjectId() {
        NewUserModel newUserModel = this.f1939h;
        if (newUserModel != null) {
            newUserModel.postSwitchProject();
        }
    }

    public void updateAlertMessage() {
        UserOperateModel userOperateModel = this.l;
        if (userOperateModel != null) {
            this.f1937f = false;
            userOperateModel.getAlertMessage(null);
        }
    }

    public void updateAppConfig() {
        UserOperateModel userOperateModel = this.l;
        if (userOperateModel != null) {
            userOperateModel.getAppConfig();
        }
    }

    public void updateAppConfigAndUserInfo() {
        updateAppConfig();
        if (this.f1932a.isLoginState()) {
            K();
            getUserInfo();
            getBadgeCount();
        }
    }

    public void updateAppVersion() {
        AppVersionModel appVersionModel = this.k;
        if (appVersionModel != null) {
            appVersionModel.getAppVersion();
        }
    }

    public void updateBillAlertMessage() {
        UserOperateModel userOperateModel = this.l;
        if (userOperateModel != null) {
            this.f1937f = true;
            userOperateModel.getOnlyBillAlertMessage(null);
        }
    }

    public void updateCacheLockList() {
        y yVar = this.f1932a;
        if (yVar == null || !yVar.isRent() || c.e.a.d.v.getInstance().isRepeatedlyAction("updateCacheLockList", 60000)) {
            return;
        }
        new e0().f(this.f1933b, false);
    }

    public void updateMeBadge(EventBadgeMsgVo eventBadgeMsgVo) {
        j0 j0Var = this.n;
        if (j0Var != null) {
            j0Var.e(eventBadgeMsgVo);
        }
    }

    public void updateOpenLiveEvent(EventOpenLiveCheck eventOpenLiveCheck) {
        this.f1934c = eventOpenLiveCheck.isFirstOpenUnlock();
        this.f1935d = eventOpenLiveCheck.getContractKey();
        getUserInfo();
    }

    public void updateSelectProject() {
    }

    public void updateSelectTabToPosition(int i2) {
        this.n.f(i2);
    }
}
