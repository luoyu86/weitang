package com.chinavisionary.microtang.base;

import android.net.Uri;
import android.os.Build;
import android.view.View;
import androidx.lifecycle.Observer;
import c.e.a.a.a;
import c.e.a.d.w;
import c.e.a.d.x;
import c.e.a.d.z;
import c.e.c.g.n;
import c.e.c.m0.h;
import c.e.c.v.d.b;
import com.alibaba.fastjson.JSON;
import com.alibaba.sdk.android.man.MANHitBuilders;
import com.alibaba.sdk.android.man.MANService;
import com.alibaba.sdk.android.man.MANServiceProvider;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.app.config.bo.UserInfoVo;
import com.chinavisionary.core.app.net.base.dto.NewResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.app.net.base.dto.ResponseUploadImgVo;
import com.chinavisionary.core.app.net.base.dto.TokenInvalidBo;
import com.chinavisionary.core.app.net.base.dto.UploadResponseDto;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.auth.vo.RequestIDCardBo;
import com.chinavisionary.microtang.community.vo.ActivityConstantVo;
import com.chinavisionary.microtang.login.bo.NewLoginBo;
import com.chinavisionary.microtang.main.bo.ClickBannerParamBo;
import com.chinavisionary.microtang.main.bo.RequestBannerParamBo;
import com.chinavisionary.microtang.main.bo.ResponseBannerItemVo;
import com.chinavisionary.microtang.main.bo.ResponseNewBannerItemVo;
import com.chinavisionary.microtang.main.model.BannerModel;
import com.chinavisionary.microtang.main.vo.CityItemVo;
import com.chinavisionary.microtang.main.vo.RoomModelVo;
import com.chinavisionary.microtang.me.vo.IDHeadImageVo;
import com.chinavisionary.microtang.web.bridge.BridgeWebViewActivity;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseFragment<T> extends CoreBaseFragment<T> {
    public BannerModel A;

    public final void A1(String str) {
        if (isDetached() || this.f6487e == null) {
            return;
        }
        n.getInstance().showAlertBig(this.f6487e, null, str, x.getString(R.string.title_confirm), x.getString(R.string.title_cancel), this.y, false);
    }

    public final void B1(String str, String str2) {
        if (isDetached() || this.f6487e == null) {
            return;
        }
        n.getInstance().showAlertBig(this.f6487e, str2, str, x.getString(R.string.title_confirm), x.getString(R.string.title_cancel), this.y, false);
    }

    public final void C1(String str, String str2, Boolean bool, View.OnClickListener onClickListener) {
        if (isDetached() || this.f6487e == null) {
            return;
        }
        n.getInstance().showAlertBig(this.f6487e, str2, str, x.getString(R.string.title_confirm), x.getString(R.string.title_cancel), onClickListener, bool.booleanValue());
    }

    public final void D1(String str, String str2, String str3, View.OnClickListener onClickListener) {
        if (isDetached() || this.f6487e == null) {
            return;
        }
        n.getInstance().showAlertBig(this.f6487e, str2, str, str3, x.getString(R.string.title_cancel), onClickListener, true);
    }

    public final String N0() {
        return w.getInstance().getString("current_location_key", null);
    }

    public final String O0() {
        return w.getInstance().getString("current_location_name_key", getString(R.string.title_sz));
    }

    public void P0() {
        this.A.getConstantList();
    }

    public CityItemVo Q0() {
        CityItemVo cityItemVo = new CityItemVo();
        String string = w.getInstance().getString("current_location_key", "");
        String string2 = w.getInstance().getString("current_location_name_key", x.getString(R.string.title_sz));
        cityItemVo.setKey(string);
        cityItemVo.setCityName(string2);
        return cityItemVo;
    }

    public final String R0() {
        return w.getInstance().getString("selectProjectKey", null);
    }

    public final String S0() {
        return w.getInstance().getString("selectProjectName", x.getString(R.string.title_sz));
    }

    public final void T0(RequestIDCardBo requestIDCardBo, UploadResponseDto uploadResponseDto, IDHeadImageVo iDHeadImageVo) {
        try {
            String backFile = iDHeadImageVo.getBackFile();
            String faceFile = iDHeadImageVo.getFaceFile();
            String selfFile = iDHeadImageVo.getSelfFile();
            if (requestIDCardBo != null && uploadResponseDto != null && x.isNotNull(backFile) && x.isNotNull(faceFile) && x.isNotNull(selfFile)) {
                MANHitBuilders.MANCustomHitBuilder mANCustomHitBuilder = new MANHitBuilders.MANCustomHitBuilder("auth_failed");
                mANCustomHitBuilder.setDurationOnEvent(6000L);
                mANCustomHitBuilder.setEventPage("IDFragmentPage");
                String idCardFrontSideResourceKey = requestIDCardBo.getIdCardFrontSideResourceKey();
                String idCardBackSideResourceKey = requestIDCardBo.getIdCardBackSideResourceKey();
                String personPhotoResourceKey = requestIDCardBo.getPersonPhotoResourceKey();
                if (x.isNotNull(idCardFrontSideResourceKey) && x.isNotNull(idCardBackSideResourceKey) && x.isNotNull(personPhotoResourceKey)) {
                    List<ResponseUploadImgVo> uploadSuccessList = uploadResponseDto.getUploadSuccessList();
                    if (uploadSuccessList != null && !uploadSuccessList.isEmpty()) {
                        for (ResponseUploadImgVo responseUploadImgVo : uploadSuccessList) {
                            if (responseUploadImgVo != null && x.isNotNull(responseUploadImgVo.getKey())) {
                                String key = responseUploadImgVo.getKey();
                                String sourceUrl = responseUploadImgVo.getSourceUrl();
                                if (x.isNotNull(key) && x.isNotNull(sourceUrl)) {
                                    String lastPathSegment = Uri.parse(sourceUrl).getLastPathSegment();
                                    if (idCardFrontSideResourceKey.equals(key)) {
                                        mANCustomHitBuilder.setProperty("faceKeySourceUrl", lastPathSegment + "+" + key);
                                    }
                                    if (idCardBackSideResourceKey.equals(key)) {
                                        mANCustomHitBuilder.setProperty("backKeySourceUrl", lastPathSegment + "+" + key);
                                    }
                                    if (personPhotoResourceKey.equals(key)) {
                                        mANCustomHitBuilder.setProperty("selfKeySourceUrl", lastPathSegment + "+" + key);
                                    }
                                }
                            }
                        }
                    }
                    mANCustomHitBuilder.setProperty("faceKey", idCardFrontSideResourceKey);
                    mANCustomHitBuilder.setProperty("backKey", idCardBackSideResourceKey);
                    mANCustomHitBuilder.setProperty("selfKey", personPhotoResourceKey);
                }
                mANCustomHitBuilder.setProperty("backPath", backFile);
                mANCustomHitBuilder.setProperty("facePath", faceFile);
                mANCustomHitBuilder.setProperty("selfPath", selfFile);
                mANCustomHitBuilder.setProperty("product", "id click");
                if (O()) {
                    mANCustomHitBuilder.setProperty(NewLoginBo.SMS_LOGIN_NAME, s());
                }
                MANServiceProvider.getService().getMANAnalytics().getDefaultTracker().send(mANCustomHitBuilder.build());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void U0(RoomModelVo.ModulesBean modulesBean) {
    }

    public final void V0(String str) {
        if (a.getInstance().isDebug()) {
            return;
        }
        try {
            MANHitBuilders.MANCustomHitBuilder mANCustomHitBuilder = new MANHitBuilders.MANCustomHitBuilder("Banner");
            mANCustomHitBuilder.setDurationOnEvent(6000L);
            mANCustomHitBuilder.setEventPage("click");
            if (x.isNotNull(str)) {
                mANCustomHitBuilder.setProperty("banner_name", str);
            }
            mANCustomHitBuilder.setProperty("project_name", S0());
            if (O()) {
                mANCustomHitBuilder.setProperty(NewLoginBo.SMS_LOGIN_NAME, s());
            }
            mANCustomHitBuilder.setProperty("time", z.getTime(Long.valueOf(System.currentTimeMillis()), z.f1243d));
            if (O()) {
                mANCustomHitBuilder.setProperty(NewLoginBo.SMS_LOGIN_NAME, s());
                UserInfoVo userInfoVoW = w();
                if (userInfoVoW != null) {
                    mANCustomHitBuilder.setProperty("name", userInfoVoW.getNickname());
                }
            }
            MANServiceProvider.getService().getMANAnalytics().getDefaultTracker().send(mANCustomHitBuilder.build());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void W0(NewResponseRowsVo<ResponseNewBannerItemVo> newResponseRowsVo) {
        U0(b.getBanner(newResponseRowsVo));
    }

    public final void X0(int i2) {
        if (a.getInstance().isDebug()) {
            return;
        }
        try {
            MANHitBuilders.MANCustomHitBuilder mANCustomHitBuilder = new MANHitBuilders.MANCustomHitBuilder("setup_ad_time");
            mANCustomHitBuilder.setDurationOnEvent(1000L);
            mANCustomHitBuilder.setEventPage("event");
            mANCustomHitBuilder.setProperty("title", "adTime=" + i2);
            mANCustomHitBuilder.setProperty("event", "setup_ad_time");
            if (O()) {
                mANCustomHitBuilder.setProperty(NewLoginBo.SMS_LOGIN_NAME, s());
            }
            MANServiceProvider.getService().getMANAnalytics().getDefaultTracker().send(mANCustomHitBuilder.build());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void Y0(String str, String str2) {
        try {
            MANHitBuilders.MANCustomHitBuilder mANCustomHitBuilder = new MANHitBuilders.MANCustomHitBuilder("click_comment");
            mANCustomHitBuilder.setDurationOnEvent(1000L);
            mANCustomHitBuilder.setEventPage("comment");
            if (x.isNotNull(str)) {
                mANCustomHitBuilder.setProperty("title", str);
            }
            mANCustomHitBuilder.setProperty("product", "comment click");
            if (x.isNotNull(str2)) {
                mANCustomHitBuilder.setProperty("room", str2);
            }
            mANCustomHitBuilder.setProperty("time", z.getTime(Long.valueOf(System.currentTimeMillis()), z.f1243d));
            if (O()) {
                mANCustomHitBuilder.setProperty(NewLoginBo.SMS_LOGIN_NAME, s());
                UserInfoVo userInfoVoW = w();
                if (userInfoVoW != null) {
                    mANCustomHitBuilder.setProperty("name", userInfoVoW.getNickname());
                }
            }
            MANServiceProvider.getService().getMANAnalytics().getDefaultTracker().send(mANCustomHitBuilder.build());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void Z0(String str) {
        if (a.getInstance().isDebug()) {
            return;
        }
        try {
            MANHitBuilders.MANCustomHitBuilder mANCustomHitBuilder = new MANHitBuilders.MANCustomHitBuilder("CommunityPage");
            mANCustomHitBuilder.setDurationOnEvent(1000L);
            mANCustomHitBuilder.setEventPage("click");
            if (x.isNotNull(str)) {
                mANCustomHitBuilder.setProperty("community_name", str);
            }
            mANCustomHitBuilder.setProperty("project_name", S0());
            mANCustomHitBuilder.setProperty("time", z.getTime(Long.valueOf(System.currentTimeMillis()), z.f1243d));
            if (O()) {
                mANCustomHitBuilder.setProperty(NewLoginBo.SMS_LOGIN_NAME, s());
                UserInfoVo userInfoVoW = w();
                if (userInfoVoW != null) {
                    mANCustomHitBuilder.setProperty("name", userInfoVoW.getNickname());
                }
            }
            MANServiceProvider.getService().getMANAnalytics().getDefaultTracker().send(mANCustomHitBuilder.build());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void a1(ActivityConstantVo activityConstantVo) {
    }

    public final void b1() {
        if (a.getInstance().isDebug()) {
            return;
        }
        try {
            MANHitBuilders.MANCustomHitBuilder mANCustomHitBuilder = new MANHitBuilders.MANCustomHitBuilder("click_custom_lock_sort");
            mANCustomHitBuilder.setDurationOnEvent(6000L);
            mANCustomHitBuilder.setEventPage("lockSortPage");
            mANCustomHitBuilder.setProperty("click", "custom lock click");
            if (O()) {
                mANCustomHitBuilder.setProperty(NewLoginBo.SMS_LOGIN_NAME, s());
            }
            MANServiceProvider.getService().getMANAnalytics().getDefaultTracker().send(mANCustomHitBuilder.build());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void c1(Integer num, String str, String str2) {
        if (this.f6487e != null) {
            if (num == null) {
                num = 0;
            }
            h.getInstance().handleForwardToType(this.f6487e, num.intValue(), str, str2);
        }
    }

    public final void d1(String str) {
        if (a.getInstance().isDebug() || !x.isNotNull(str)) {
            return;
        }
        try {
            MANHitBuilders.MANCustomHitBuilder mANCustomHitBuilder = new MANHitBuilders.MANCustomHitBuilder("Function");
            mANCustomHitBuilder.setDurationOnEvent(1000L);
            mANCustomHitBuilder.setEventPage("click");
            if (x.isNotNull(str)) {
                mANCustomHitBuilder.setProperty("title", str);
            }
            mANCustomHitBuilder.setProperty("project_name", S0());
            if (O()) {
                mANCustomHitBuilder.setProperty(NewLoginBo.SMS_LOGIN_NAME, s());
            }
            mANCustomHitBuilder.setProperty("time", z.getTime(Long.valueOf(System.currentTimeMillis()), z.f1243d));
            if (O()) {
                mANCustomHitBuilder.setProperty(NewLoginBo.SMS_LOGIN_NAME, s());
                UserInfoVo userInfoVoW = w();
                if (userInfoVoW != null) {
                    mANCustomHitBuilder.setProperty("name", userInfoVoW.getNickname());
                }
            }
            MANServiceProvider.getService().getMANAnalytics().getDefaultTracker().send(mANCustomHitBuilder.build());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void e0() {
        if (a.getInstance().isDebug() || this.f6487e == null) {
            return;
        }
        try {
            MANService service = MANServiceProvider.getService();
            String notNullStr = x.getNotNullStr(s(), "");
            service.getMANAnalytics().updateUserAccount(notNullStr, notNullStr);
            HashMap map = new HashMap();
            map.put("pageName", getClass().getSimpleName());
            service.getMANPageHitHelper().updatePageProperties(map);
            service.getMANPageHitHelper().pageAppear(this.f6487e);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void e1(String str, String str2, boolean z) {
        if (a.getInstance().isDebug()) {
            return;
        }
        try {
            MANHitBuilders.MANCustomHitBuilder mANCustomHitBuilder = new MANHitBuilders.MANCustomHitBuilder("ProductPage");
            mANCustomHitBuilder.setDurationOnEvent(1000L);
            mANCustomHitBuilder.setEventPage("incrementPage");
            if (x.isNotNull(str)) {
                mANCustomHitBuilder.setProperty("product_name", str);
            }
            String str3 = z ? "是" : "否";
            mANCustomHitBuilder.setProperty("project_name", S0());
            mANCustomHitBuilder.setProperty("product_type", str2);
            mANCustomHitBuilder.setProperty("has_order", str3);
            mANCustomHitBuilder.setProperty("time", z.getTime(Long.valueOf(System.currentTimeMillis()), z.f1243d));
            if (O()) {
                mANCustomHitBuilder.setProperty(NewLoginBo.SMS_LOGIN_NAME, s());
                UserInfoVo userInfoVoW = w();
                if (userInfoVoW != null) {
                    mANCustomHitBuilder.setProperty("name", userInfoVoW.getNickname());
                }
            }
            MANServiceProvider.getService().getMANAnalytics().getDefaultTracker().send(mANCustomHitBuilder.build());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void f0() {
        if (a.getInstance().isDebug() || this.f6487e == null) {
            return;
        }
        try {
            MANService service = MANServiceProvider.getService();
            String notNullStr = x.getNotNullStr(s(), "");
            service.getMANAnalytics().updateUserAccount(notNullStr, notNullStr);
            service.getMANPageHitHelper().pageDisAppear(this.f6487e);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void f1(String str) {
        if (a.getInstance().isDebug() || !x.isNotNull(str)) {
            return;
        }
        try {
            MANHitBuilders.MANCustomHitBuilder mANCustomHitBuilder = new MANHitBuilders.MANCustomHitBuilder("LoginPage");
            mANCustomHitBuilder.setDurationOnEvent(1000L);
            mANCustomHitBuilder.setEventPage("event");
            mANCustomHitBuilder.setProperty("project_name", S0());
            TokenInvalidBo tokenInvalidBo = (TokenInvalidBo) JSON.parseObject(str, TokenInvalidBo.class);
            if (x.isNotNull(tokenInvalidBo.getErrMsg())) {
                mANCustomHitBuilder.setProperty(MediationConstant.KEY_REASON, String.valueOf(tokenInvalidBo.getErrCode()));
            }
            if (x.isNotNull(tokenInvalidBo.getInterfaceUrl())) {
                mANCustomHitBuilder.setProperty("path", tokenInvalidBo.getInterfaceUrl());
            }
            if (x.isNotNull(tokenInvalidBo.getToken())) {
                mANCustomHitBuilder.setProperty("token", tokenInvalidBo.getToken());
            }
            mANCustomHitBuilder.setProperty("time", z.getTime(Long.valueOf(System.currentTimeMillis()), z.f1243d));
            mANCustomHitBuilder.setProperty("event", "login_failed");
            if (x.isNotNull(s())) {
                mANCustomHitBuilder.setProperty(NewLoginBo.SMS_LOGIN_NAME, s());
            }
            MANServiceProvider.getService().getMANAnalytics().getDefaultTracker().send(mANCustomHitBuilder.build());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void g1(String str) {
        if (a.getInstance().isDebug()) {
            return;
        }
        try {
            MANHitBuilders.MANCustomHitBuilder mANCustomHitBuilder = new MANHitBuilders.MANCustomHitBuilder("click_do_login_sms");
            mANCustomHitBuilder.setDurationOnEvent(1000L);
            mANCustomHitBuilder.setEventPage("do_login_sms");
            mANCustomHitBuilder.setProperty("time", z.getTime(Long.valueOf(System.currentTimeMillis()), z.f1243d));
            mANCustomHitBuilder.setProperty("phone_system", Build.MANUFACTURER + ":" + Build.BRAND + ":" + Build.MODEL);
            mANCustomHitBuilder.setProperty(NewLoginBo.SMS_LOGIN_NAME, str);
            MANServiceProvider.getService().getMANAnalytics().getDefaultTracker().send(mANCustomHitBuilder.build());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void h1(String str) {
        if (a.getInstance().isDebug()) {
            return;
        }
        try {
            MANHitBuilders.MANCustomHitBuilder mANCustomHitBuilder = new MANHitBuilders.MANCustomHitBuilder("OftenLockOpen");
            mANCustomHitBuilder.setDurationOnEvent(1000L);
            mANCustomHitBuilder.setEventPage("often_lock_open");
            mANCustomHitBuilder.setProperty("time", z.getTime(Long.valueOf(System.currentTimeMillis()), z.f1243d));
            mANCustomHitBuilder.setProperty("phone_system", Build.MANUFACTURER + ":" + Build.BRAND + ":" + Build.MODEL);
            mANCustomHitBuilder.setProperty("room_name", str);
            if (O()) {
                mANCustomHitBuilder.setProperty(NewLoginBo.SMS_LOGIN_NAME, s());
                UserInfoVo userInfoVoW = w();
                if (userInfoVoW != null) {
                    mANCustomHitBuilder.setProperty("name", userInfoVoW.getNickname());
                }
            }
            MANServiceProvider.getService().getMANAnalytics().getDefaultTracker().send(mANCustomHitBuilder.build());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void i1(NewResponseRowsVo<ResponseBannerItemVo> newResponseRowsVo) {
        U0(b.newBannerToModule(newResponseRowsVo));
    }

    public final void j1(String str) {
        if (a.getInstance().isDebug()) {
            return;
        }
        try {
            MANHitBuilders.MANCustomHitBuilder mANCustomHitBuilder = new MANHitBuilders.MANCustomHitBuilder("click_product");
            mANCustomHitBuilder.setDurationOnEvent(6000L);
            mANCustomHitBuilder.setEventPage("productPage");
            if (x.isNotNull(str)) {
                mANCustomHitBuilder.setProperty("title", str);
            }
            mANCustomHitBuilder.setProperty("product", "product click");
            if (O()) {
                mANCustomHitBuilder.setProperty(NewLoginBo.SMS_LOGIN_NAME, s());
            }
            MANServiceProvider.getService().getMANAnalytics().getDefaultTracker().send(mANCustomHitBuilder.build());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void k1(String str, String str2) {
        if (a.getInstance().isDebug()) {
            return;
        }
        try {
            MANHitBuilders.MANCustomHitBuilder mANCustomHitBuilder = new MANHitBuilders.MANCustomHitBuilder("Shred");
            mANCustomHitBuilder.setDurationOnEvent(1000L);
            mANCustomHitBuilder.setEventPage("lockSortPage");
            mANCustomHitBuilder.setProperty("click", "custom lock click");
            mANCustomHitBuilder.setProperty("shared_name", str);
            mANCustomHitBuilder.setProperty("shared_type", str2);
            mANCustomHitBuilder.setProperty("time", z.getTime(Long.valueOf(System.currentTimeMillis()), z.f1243d));
            if (O()) {
                mANCustomHitBuilder.setProperty(NewLoginBo.SMS_LOGIN_NAME, s());
                UserInfoVo userInfoVoW = w();
                if (userInfoVoW != null) {
                    mANCustomHitBuilder.setProperty("name", userInfoVoW.getNickname());
                }
            }
            MANServiceProvider.getService().getMANAnalytics().getDefaultTracker().send(mANCustomHitBuilder.build());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean l1() {
        return w.getInstance().getBoolean("isFirstLoginAppKey", true);
    }

    public boolean m1() {
        if (N()) {
            if (Q()) {
                return true;
            }
            F0(R.string.title_rent_buy);
        }
        return false;
    }

    public final void q1() {
        c0(BridgeWebViewActivity.class, c.e.c.r.a.getIdCardCertificate());
    }

    public final void r1(String str) {
        c0(BridgeWebViewActivity.class, c.e.c.r.a.getRentSignRoom(str));
    }

    public final void s1(String str) {
        c0(BridgeWebViewActivity.class, c.e.c.r.a.getReserveRoom(str));
    }

    public final void t1(String str) {
        c0(BridgeWebViewActivity.class, c.e.c.r.a.getSignRoom(str));
    }

    public void u1(String str) {
        if (this.A != null) {
            ClickBannerParamBo clickBannerParamBo = new ClickBannerParamBo();
            clickBannerParamBo.setBannerKey(str);
            this.A.recordBannerClick(clickBannerParamBo);
        }
    }

    public void v1(String str) {
        if (this.A != null) {
            RequestBannerParamBo requestBannerParamBo = new RequestBannerParamBo();
            requestBannerParamBo.setProjectId(R0());
            requestBannerParamBo.setPageCode(str);
            this.A.getBannerList(requestBannerParamBo);
        }
    }

    public void w1(String str) {
        if (this.A != null) {
            RequestBannerParamBo requestBannerParamBo = new RequestBannerParamBo();
            requestBannerParamBo.setPageCode(str);
            this.A.getBannerList(requestBannerParamBo);
        }
    }

    public void x1(CityItemVo cityItemVo) {
        c.e.a.a.i.b.getInstance().setCityName(cityItemVo.getCityName());
        w.getInstance().putString("current_location_key", cityItemVo.getKey());
        w.getInstance().putString("current_location_name_key", cityItemVo.getCityName());
    }

    public final String y1(Long l) {
        if (l.longValue() <= 0) {
            return x.getString(R.string.title_pay_time_out);
        }
        return x.getString(R.string.title_pay_surplus_second) + z.getSurplusDateToTime(l);
    }

    public void z1() {
        BannerModel bannerModel = (BannerModel) h(BannerModel.class);
        this.A = bannerModel;
        bannerModel.getNewBannerResult().observe(this, new Observer() { // from class: c.e.c.i.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1541a.W0((NewResponseRowsVo) obj);
            }
        });
        this.A.getBannerResult().observe(this, new Observer() { // from class: c.e.c.i.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1540a.i1((NewResponseRowsVo) obj);
            }
        });
        this.A.getConstantResult().observeForever(new Observer() { // from class: c.e.c.i.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1542a.a1((ActivityConstantVo) obj);
            }
        });
        this.A.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.i.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1539a.C((RequestErrDto) obj);
            }
        });
    }
}
