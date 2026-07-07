package c.e.c.u.m;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import c.e.a.d.w;
import c.e.c.m0.o;
import com.alibaba.fastjson.JSON;
import com.chinavisionary.core.app.config.bo.UserInfoVo;
import com.chinavisionary.core.app.event.EventUpdateUserInfoVo;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.app.net.base.dto.ResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.framework.mobile.login.dto.UserSimpleDto;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.login.LoginActivity;
import com.chinavisionary.microtang.login.bo.EventUpdateUserAlertMessage;
import com.chinavisionary.microtang.me.bo.ResponseManagerQrCodeBo;
import com.chinavisionary.microtang.me.model.NewUserOperateModel;
import com.chinavisionary.microtang.me.model.UserOperateModel;
import com.chinavisionary.twlib.open.model.NewOpenDoorModel;
import com.chinavisionary.twlib.open.model.OpenDoorModel;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class i extends g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1874b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BaseFragment f1875c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public OpenDoorModel f1876d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public NewOpenDoorModel f1877e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public UserOperateModel f1878f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public NewUserOperateModel f1879g;

    public i(BaseFragment baseFragment) {
        this.f1875c = baseFragment;
        this.f1876d = (OpenDoorModel) ViewModelProviders.of(baseFragment).get(OpenDoorModel.class);
        if (c.e.a.a.a.getInstance().isH5Model()) {
            this.f1877e = (NewOpenDoorModel) ViewModelProviders.of(baseFragment).get(NewOpenDoorModel.class);
        }
        this.f1878f = (UserOperateModel) ViewModelProviders.of(baseFragment).get(UserOperateModel.class);
        y();
        z();
    }

    public final void d(ResponseManagerQrCodeBo responseManagerQrCodeBo) {
        o.getInstance().setResponseManagerQrCodeBo(responseManagerQrCodeBo);
    }

    public final void e(RequestErrDto requestErrDto) {
        j();
    }

    public final void f(ResponseStateVo responseStateVo) {
        selectRoomAfterReloadUserDetails();
    }

    public final void g(ResponseRowsVo<c.e.e.a.s.d> responseRowsVo) {
        r(responseRowsVo);
    }

    public final void h(UserInfoVo userInfoVo) {
        saveUserDetailsAndCheckIsRent(userInfoVo);
    }

    public final void i(RequestErrDto requestErrDto) {
        a();
        j();
    }

    public final void j() {
        a();
        c(R.string.tip_login_success);
        c.e.c.x.c.a.getInstance().initOftenDevice();
        g.b.a.c.getDefault().post(new EventUpdateUserAlertMessage());
        c.e.a.a.g.a.getAppManager().finishActivity(LoginActivity.class);
    }

    public final void q(c.e.e.a.s.e eVar) {
        OpenDoorModel openDoorModel;
        if (eVar == null || (openDoorModel = this.f1876d) == null) {
            j();
            return;
        }
        NewOpenDoorModel newOpenDoorModel = this.f1877e;
        if (newOpenDoorModel != null) {
            newOpenDoorModel.postSelectRoom(eVar);
        } else {
            openDoorModel.postSelectRoom(eVar);
        }
    }

    public final void r(ResponseRowsVo<c.e.e.a.s.d> responseRowsVo) {
        if (responseRowsVo == null) {
            c.e.c.x.c.a.getInstance().setShowWallet(false);
            j();
            return;
        }
        c.e.c.x.c.a.getInstance().setShowWallet(c.e.a.d.o.isNotEmpty(responseRowsVo.getRows()));
        List<c.e.e.a.s.e> listSignLockToLock = c.e.c.m0.j.getInstance().signLockToLock(responseRowsVo.getRows());
        if (listSignLockToLock == null || listSignLockToLock.isEmpty()) {
            j();
            return;
        }
        c.e.e.a.s.e eVar = listSignLockToLock.get(0);
        q(eVar);
        if (eVar != null) {
            u(eVar.getAssetInstanceName());
            c.e.c.m0.c.getInstance().setRoomKey(eVar.getAssetInstanceKey());
            w.getInstance().putString("room_key", eVar.getAssetInstanceKey());
        }
    }

    public final void s() {
        NewOpenDoorModel newOpenDoorModel = this.f1877e;
        if (newOpenDoorModel != null) {
            newOpenDoorModel.getSignLockList("LoginResultAfterHandler-requestLockList");
            return;
        }
        OpenDoorModel openDoorModel = this.f1876d;
        if (openDoorModel != null) {
            openDoorModel.getSignLockList();
        }
    }

    public void saveUserDetailsAndCheckIsRent(UserInfoVo userInfoVo) {
        if (userInfoVo != null) {
            v(JSON.toJSONString(userInfoVo));
            userInfoVo.isCheckIn();
        }
        x();
        if (this.f1874b) {
            s();
        } else {
            j();
        }
    }

    public void saveUserSimpleAndGetUserDetails(UserSimpleDto userSimpleDto) {
        if (userSimpleDto != null) {
            g.b.a.c.getDefault().post(userSimpleDto);
            w(JSON.toJSONString(userSimpleDto));
        }
        t();
    }

    public void selectRoomAfterReloadUserDetails() {
        this.f1874b = false;
        t();
    }

    public void setNewUserOperateModel(NewUserOperateModel newUserOperateModel) {
        this.f1879g = newUserOperateModel;
        if (newUserOperateModel != null) {
            newUserOperateModel.getUserInfoVoResult().observe(this.f1875c, new f(this));
            this.f1879g.getManagerQrCodeResult().observe(this.f1875c, new Observer() { // from class: c.e.c.u.m.c
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f1869a.d((ResponseManagerQrCodeBo) obj);
                }
            });
            this.f1879g.getErrRequestLiveData().observe(this.f1875c, new a(this));
        }
    }

    public final void t() {
        NewUserOperateModel newUserOperateModel = this.f1879g;
        if (newUserOperateModel != null) {
            newUserOperateModel.getUserInfo();
        } else {
            this.f1878f.getUserInfo();
        }
    }

    public final void u(String str) {
        w.getInstance().putString("current_room_key", str);
    }

    public final void v(String str) {
        w.getInstance().putString("userDetailsInfoKey", str);
    }

    public final void w(String str) {
        w.getInstance().putString("userInfoKey", str);
    }

    public final void x() {
        EventUpdateUserInfoVo eventUpdateUserInfoVo = new EventUpdateUserInfoVo();
        eventUpdateUserInfoVo.setWhatMsg(2);
        g.b.a.c.getDefault().post(eventUpdateUserInfoVo);
    }

    public final void y() {
        this.f1876d.getSignLockListLiveData().observe(this.f1875c, new Observer() { // from class: c.e.c.u.m.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1871a.g((ResponseRowsVo) obj);
            }
        });
        this.f1876d.getRoomSelectLiveData().observe(this.f1875c, new Observer() { // from class: c.e.c.u.m.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1868a.f((ResponseStateVo) obj);
            }
        });
        this.f1876d.getErrRequestLiveData().observe(this.f1875c, new Observer() { // from class: c.e.c.u.m.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1870a.e((RequestErrDto) obj);
            }
        });
        NewOpenDoorModel newOpenDoorModel = this.f1877e;
        if (newOpenDoorModel != null) {
            newOpenDoorModel.getRoomSelectLiveData().observe(this.f1875c, new Observer() { // from class: c.e.c.u.m.b
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f1868a.f((ResponseStateVo) obj);
                }
            });
            this.f1877e.getSignLockListLiveData().observe(this.f1875c, new Observer() { // from class: c.e.c.u.m.e
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f1871a.g((ResponseRowsVo) obj);
                }
            });
            this.f1877e.getErrRequestLiveData().observe(this.f1875c, new Observer() { // from class: c.e.c.u.m.d
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f1870a.e((RequestErrDto) obj);
                }
            });
        }
    }

    public final void z() {
        this.f1878f.getUserInfoVoResult().observe(this.f1875c, new f(this));
        this.f1878f.getErrRequestLiveData().observe(this.f1875c, new a(this));
    }
}
