package c.e.c.v.f;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.alibaba.fastjson.JSON;
import com.chinavisionary.core.app.config.bo.AppConfigExtVo;
import com.chinavisionary.core.app.net.base.dto.NewResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.PageBo;
import com.chinavisionary.microtang.main.bo.ClickBannerParamBo;
import com.chinavisionary.microtang.main.bo.ProjectVo;
import com.chinavisionary.microtang.main.bo.RequestBannerParamBo;
import com.chinavisionary.microtang.main.bo.ResponseNewBannerItemVo;
import com.chinavisionary.microtang.main.event.EventUpdateCity;
import com.chinavisionary.microtang.main.event.EventUpdateProject;
import com.chinavisionary.microtang.main.model.BannerModel;
import com.chinavisionary.microtang.main.model.NewRoomModel;
import com.chinavisionary.microtang.main.vo.CityItemVo;
import com.chinavisionary.microtang.me.vo.FundNewsVo;
import com.chinavisionary.twlib.open.bo.ResponseOpenDoorVo;
import com.chinavisionary.twlib.open.model.OpenDoorModel;
import com.chinavisionary.twlib.open.model.OpenDoorPwdModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1948a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1949b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public i0 f1950c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public BannerModel f1951d;

    public static /* synthetic */ void h(List list, boolean z, OpenDoorPwdModel openDoorPwdModel) {
        if (c.e.a.d.o.isNotEmpty(list)) {
            try {
                Iterator it = list.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    c.e.e.a.s.e eVar = (c.e.e.a.s.e) it.next();
                    if (eVar != null && eVar.getLockType() != null) {
                        boolean z2 = true;
                        if (eVar.getLockType().intValue() != 1 && c.e.a.d.x.isNotNull(eVar.getAssetInstanceKey())) {
                            String assetInstanceKey = eVar.getAssetInstanceKey();
                            String cacheTimeToAssetKey = c.e.e.a.t.b.getInstance().getCacheTimeToAssetKey(assetInstanceKey);
                            if (cacheTimeToAssetKey != null && !z) {
                                try {
                                    if (Long.valueOf(System.currentTimeMillis()).longValue() - Long.valueOf(Long.parseLong(cacheTimeToAssetKey)).longValue() < c.e.e.a.x.l.getInstance().getMaxIntervalTime()) {
                                        z2 = false;
                                    }
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                            }
                            i2++;
                            if (i2 <= 4 && z2) {
                                openDoorPwdModel.getDoorPwdToCache(assetInstanceKey, "initLockListAndPwdData");
                                try {
                                    Thread.sleep(200L);
                                } catch (Exception e3) {
                                    e3.printStackTrace();
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static /* synthetic */ void i(final boolean z, final OpenDoorPwdModel openDoorPwdModel, NewResponseRowsVo newResponseRowsVo) {
        if (newResponseRowsVo != null) {
            List<c.e.e.a.s.e> rows = newResponseRowsVo.getRows();
            if (z) {
                c.e.e.a.t.b.getInstance().insertRoomList(rows);
                c.e.e.a.u.d.getInstance().setLockResponseVoList(rows);
            }
            if (rows == null || rows.isEmpty()) {
                return;
            }
            final ArrayList arrayList = new ArrayList();
            try {
                List array = JSON.parseArray(JSON.toJSONString(rows), c.e.e.a.s.e.class);
                if (c.e.a.d.o.isNotEmpty(array)) {
                    arrayList.addAll(array);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            new Thread(new Runnable() { // from class: c.e.c.v.f.v
                @Override // java.lang.Runnable
                public final void run() {
                    e0.h(arrayList, z, openDoorPwdModel);
                }
            }).start();
        }
    }

    public static /* synthetic */ void j(ResponseOpenDoorVo responseOpenDoorVo) {
        if (responseOpenDoorVo == null || !responseOpenDoorVo.isSuccess()) {
            return;
        }
        c.e.e.a.u.d.getInstance().putPwdToMap(responseOpenDoorVo);
    }

    public static /* synthetic */ void k(final boolean z, FragmentActivity fragmentActivity) {
        if (z) {
            try {
                List<c.e.e.a.s.e> roomList = c.e.e.a.t.b.getInstance().getRoomList();
                c.e.e.a.u.d.getInstance().setRoomResponseOpenDoorVo(null);
                c.e.e.a.u.d.getInstance().setLockResponseVoList(roomList);
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        final OpenDoorPwdModel openDoorPwdModel = (OpenDoorPwdModel) ViewModelProviders.of(fragmentActivity).get(OpenDoorPwdModel.class);
        OpenDoorModel openDoorModel = (OpenDoorModel) ViewModelProviders.of(fragmentActivity).get(OpenDoorModel.class);
        openDoorModel.getLockListLiveData().observe(fragmentActivity, new Observer() { // from class: c.e.c.v.f.p
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                e0.i(z, openDoorPwdModel, (NewResponseRowsVo) obj);
            }
        });
        openDoorModel.getLockList();
        openDoorPwdModel.getDoorVoMutableLiveData().observe(fragmentActivity, new Observer() { // from class: c.e.c.v.f.u
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                e0.j((ResponseOpenDoorVo) obj);
            }
        });
    }

    public static /* synthetic */ void l(NewRoomModel newRoomModel, NewResponseRowsVo newResponseRowsVo) {
        if (newResponseRowsVo == null || !c.e.a.d.o.isNotEmpty(newResponseRowsVo.getRows())) {
            return;
        }
        CityItemVo cityItemVo = (CityItemVo) newResponseRowsVo.getRows().get(0);
        c.e.a.d.w.getInstance().putString("current_location_key", cityItemVo.getKey());
        c.e.a.d.w.getInstance().putString("current_location_name_key", cityItemVo.getCityName());
        EventUpdateCity eventUpdateCity = new EventUpdateCity();
        eventUpdateCity.setKey(cityItemVo.getKey());
        eventUpdateCity.setTitle(cityItemVo.getCityName());
        g.b.a.c.getDefault().post(eventUpdateCity);
        newRoomModel.getProjectList(cityItemVo.getKey());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void n(int i2, int i3, NewRoomModel newRoomModel, NewResponseRowsVo newResponseRowsVo) {
        ProjectVo projectVo;
        if (newResponseRowsVo != null) {
            List rows = newResponseRowsVo.getRows();
            if (c.e.a.d.o.isNotEmpty(rows) && this.f1948a == null && (projectVo = (ProjectVo) c.e.a.d.o.getFirstElement(rows)) != null && c.e.a.d.x.isNotNull(projectVo.getProjectKey())) {
                this.f1948a = projectVo.getProjectKey();
                String projectName = projectVo.getProjectName();
                c.e.a.d.w.getInstance().putString("selectProjectKey", this.f1948a);
                c.e.a.d.w.getInstance().putString("selectProjectName", projectName);
                EventUpdateProject eventUpdateProject = new EventUpdateProject();
                eventUpdateProject.setKey(this.f1948a);
                eventUpdateProject.setTitle(projectName);
                g.b.a.c.getDefault().postSticky(eventUpdateProject);
            }
        }
        PageBo pageBo = new PageBo();
        pageBo.setPageNumber(i2);
        pageBo.setPage(i3);
        if (c.e.a.d.x.isNotNull(this.f1948a)) {
            newRoomModel.getGroupList(this.f1948a, "initRoomModel mProjectKey is null");
        }
    }

    public static /* synthetic */ void o(h0 h0Var, NewResponseRowsVo newResponseRowsVo) {
        if (newResponseRowsVo != null) {
            f0.getInstance().setModulesBeans(h0Var.getAdapterData(newResponseRowsVo));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void q(String str, NewResponseRowsVo newResponseRowsVo) {
        if (this.f1949b != 0) {
            d(newResponseRowsVo);
        } else {
            e(newResponseRowsVo);
            this.f1951d.getBannerList(c(str, "open"));
        }
    }

    public void a(String str) {
        if (this.f1951d == null || !c.e.a.d.x.isNotNull(str)) {
            return;
        }
        ClickBannerParamBo clickBannerParamBo = new ClickBannerParamBo();
        clickBannerParamBo.setBannerKey(str);
        this.f1951d.recordBannerClick(clickBannerParamBo);
    }

    public final ResponseNewBannerItemVo b(NewResponseRowsVo<ResponseNewBannerItemVo> newResponseRowsVo) {
        if (newResponseRowsVo == null || !c.e.a.d.o.isNotEmpty(newResponseRowsVo.getRows())) {
            return null;
        }
        return newResponseRowsVo.getRows().get(0);
    }

    public final RequestBannerParamBo c(String str, String str2) {
        RequestBannerParamBo requestBannerParamBo = new RequestBannerParamBo();
        requestBannerParamBo.setProjectId(str);
        requestBannerParamBo.setPageCode(str2);
        return requestBannerParamBo;
    }

    public final void d(NewResponseRowsVo<ResponseNewBannerItemVo> newResponseRowsVo) {
        ResponseNewBannerItemVo responseNewBannerItemVoB = b(newResponseRowsVo);
        if (responseNewBannerItemVoB == null) {
            c.e.a.d.w.getInstance().putString("open_door_ad", null);
            return;
        }
        AppConfigExtVo.ADScreen.LockScreenBean lockScreenBean = new AppConfigExtVo.ADScreen.LockScreenBean();
        lockScreenBean.setForwardType(Integer.valueOf(responseNewBannerItemVoB.getLinkForwardType()));
        lockScreenBean.setResource(responseNewBannerItemVoB.getIconUrl());
        lockScreenBean.setTitle(responseNewBannerItemVoB.getTitle());
        lockScreenBean.setHref(responseNewBannerItemVoB.getLinkUrl());
        lockScreenBean.setTimer(Long.valueOf(responseNewBannerItemVoB.getDisplayDuration() * 1000));
        String jSONString = JSON.toJSONString(lockScreenBean);
        c.e.a.d.w.getInstance().putString("open_door_ad", jSONString);
        c.e.a.d.q.d(e0.class.getSimpleName(), "handleOpenDoor json = " + jSONString);
        if (this.f1950c != null) {
            AppConfigExtVo appConfigExtVo = new AppConfigExtVo();
            AppConfigExtVo.ADScreen aDScreen = new AppConfigExtVo.ADScreen();
            aDScreen.setLockScreen(lockScreenBean);
            appConfigExtVo.setAdScreenVo(aDScreen);
            this.f1950c.n(appConfigExtVo);
        }
        String string = c.e.a.d.w.getInstance().getString("open_door_ad", null);
        c.e.a.d.q.d(e0.class.getSimpleName(), "handleOpenDoor adJson = " + string);
    }

    public final void e(NewResponseRowsVo<ResponseNewBannerItemVo> newResponseRowsVo) {
        this.f1949b++;
        ResponseNewBannerItemVo responseNewBannerItemVoB = b(newResponseRowsVo);
        if (responseNewBannerItemVoB == null) {
            c.e.a.d.w.getInstance().putString("splash_ad", null);
            return;
        }
        AppConfigExtVo.ADScreen.SplashScreenBean splashScreenBean = new AppConfigExtVo.ADScreen.SplashScreenBean();
        splashScreenBean.setForwardType(Integer.valueOf(responseNewBannerItemVoB.getLinkForwardType()));
        splashScreenBean.setBaseKey(responseNewBannerItemVoB.getPrimaryKey());
        splashScreenBean.setResource(responseNewBannerItemVoB.getIconUrl());
        splashScreenBean.setTitle(responseNewBannerItemVoB.getTitle());
        splashScreenBean.setHref(responseNewBannerItemVoB.getLinkUrl());
        if (8 == responseNewBannerItemVoB.getLinkForwardType()) {
            responseNewBannerItemVoB.setTargetMiniType(FundNewsVo.TYPE_ALIPAY);
        }
        splashScreenBean.setTargetAppid(responseNewBannerItemVoB.getTargetAppid());
        splashScreenBean.setTargetPath(responseNewBannerItemVoB.getTargetPath());
        splashScreenBean.setTargetMiniType(responseNewBannerItemVoB.getTargetMiniType());
        splashScreenBean.setTimer(Long.valueOf(responseNewBannerItemVoB.getDisplayDuration() * 1000));
        String jSONString = JSON.toJSONString(splashScreenBean);
        c.e.a.d.w.getInstance().putString("splash_ad", jSONString);
        c.e.a.d.q.d(e0.class.getSimpleName(), "handleSplash json = " + jSONString);
        if (this.f1950c != null) {
            AppConfigExtVo appConfigExtVo = new AppConfigExtVo();
            AppConfigExtVo.ADScreen aDScreen = new AppConfigExtVo.ADScreen();
            aDScreen.setSplashScreen(splashScreenBean);
            appConfigExtVo.setAdScreenVo(aDScreen);
            this.f1950c.n(appConfigExtVo);
        }
    }

    public void f(final FragmentActivity fragmentActivity, final boolean z) {
        if (c.e.e.a.x.l.getInstance().isEnableNetworkCache()) {
            new Thread(new Runnable() { // from class: c.e.c.v.f.s
                @Override // java.lang.Runnable
                public final void run() {
                    e0.k(z, fragmentActivity);
                }
            }).start();
        }
    }

    public final void g(FragmentActivity fragmentActivity) {
        this.f1948a = c.e.a.d.w.getInstance().getString("selectProjectKey", null);
        String string = c.e.a.d.w.getInstance().getString("current_location_key", null);
        final h0 h0Var = new h0();
        final NewRoomModel newRoomModel = (NewRoomModel) ViewModelProviders.of(fragmentActivity).get(NewRoomModel.class);
        if (string == null) {
            newRoomModel.getCityResult().observe(fragmentActivity, new Observer() { // from class: c.e.c.v.f.q
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    e0.l(newRoomModel, (NewResponseRowsVo) obj);
                }
            });
            newRoomModel.getCityList();
        }
        final int i2 = 1;
        final int i3 = 20;
        if (this.f1948a == null && c.e.a.d.x.isNotNull(string)) {
            newRoomModel.getProjectList(string);
            newRoomModel.getProjectResult().observe(fragmentActivity, new Observer() { // from class: c.e.c.v.f.o
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f1989a.n(i3, i2, newRoomModel, (NewResponseRowsVo) obj);
                }
            });
        } else {
            PageBo pageBo = new PageBo();
            pageBo.setPageNumber(20);
            pageBo.setPage(1);
            newRoomModel.getGroupList(this.f1948a, "initRoomModel projectKey is not null");
        }
        newRoomModel.getGroupResult().observe(fragmentActivity, new Observer() { // from class: c.e.c.v.f.t
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                e0.o(h0Var, (NewResponseRowsVo) obj);
            }
        });
    }

    public final void r(FragmentActivity fragmentActivity) {
        final String string = c.e.a.d.w.getInstance().getString("selectProjectKey", null);
        BannerModel bannerModel = (BannerModel) ViewModelProviders.of(fragmentActivity).get(BannerModel.class);
        this.f1951d = bannerModel;
        bannerModel.getNewBannerResult().observe(fragmentActivity, new Observer() { // from class: c.e.c.v.f.r
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1996a.q(string, (NewResponseRowsVo) obj);
            }
        });
        this.f1949b = 0;
        this.f1951d.getBannerList(c(string, RequestBannerParamBo.GET_SPLASH_TYPE));
    }

    public void s(FragmentActivity fragmentActivity, boolean z) {
        f0.getInstance().setModulesBeans(null);
        if (z) {
            f(fragmentActivity, true);
        }
        g(fragmentActivity);
        r(fragmentActivity);
    }

    public void setSplashAdLoadManager(i0 i0Var) {
        this.f1950c = i0Var;
    }
}
