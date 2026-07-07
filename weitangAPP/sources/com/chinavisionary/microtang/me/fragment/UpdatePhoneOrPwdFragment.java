package com.chinavisionary.microtang.me.fragment;

import android.os.Message;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.w;
import c.e.a.d.x;
import c.e.c.x.e.h0;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.framework.mobile.login.dto.UserSimpleDto;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.me.bo.NewUpdateDeviceIdVo;
import com.chinavisionary.microtang.me.bo.UpdateDeviceIdVo;
import com.chinavisionary.microtang.me.handler.UpdatePhoneHandle;
import com.chinavisionary.microtang.me.handler.UpdatePwdHandle;
import com.chinavisionary.microtang.me.model.NewUserModel;
import com.chinavisionary.microtang.me.model.UserModel;
import g.b.a.c;

/* JADX INFO: loaded from: classes.dex */
public class UpdatePhoneOrPwdFragment extends BaseFragment<String> {
    public int C;
    public UserModel D;
    public NewUserModel E;
    public UpdatePwdHandle F;
    public UpdatePhoneHandle G;

    @BindView(R.id.tv_confirm)
    public AppCompatButton mConfirmBtn;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;
    public int B = 60;
    public final h0 H = new a();

    public class a implements h0 {
        public a() {
        }

        @Override // c.e.c.x.e.h0
        public View getLayoutView() {
            return UpdatePhoneOrPwdFragment.this.u;
        }

        @Override // c.e.c.x.e.h0
        public void openUpdatePwdFragment() {
            UpdatePhoneOrPwdFragment.this.Q1();
        }

        @Override // c.e.c.x.e.h0
        public void showLoading(int i2) {
            UpdatePhoneOrPwdFragment.super.z0(i2);
        }

        @Override // c.e.c.x.e.h0
        public void showToast(int i2) {
            UpdatePhoneOrPwdFragment.super.F0(i2);
        }
    }

    public static UpdatePhoneOrPwdFragment getInstance(int i2) {
        UpdatePhoneOrPwdFragment updatePhoneOrPwdFragment = new UpdatePhoneOrPwdFragment();
        updatePhoneOrPwdFragment.setType(i2);
        return updatePhoneOrPwdFragment;
    }

    public final void I1(String str) {
        H();
        this.G.startTimer(this.B);
        CoreBaseFragment.c cVar = this.f6488f;
        if (cVar != null) {
            cVar.sendEmptyMessageDelayed(1, 1000L);
        }
    }

    public final void J1(String str) {
        H();
        if (this.C == 3) {
            F0(R.string.tip_update_phone_success);
            c.e.c.u.l.a aVar = new c.e.c.u.l.a();
            aVar.setPhone(this.G.getNewPhone());
            k(aVar);
            n();
            return;
        }
        UpdateDeviceIdVo updateDeviceIdVo = null;
        String string = w.getInstance().getString("device_id_key", null);
        if (x.isNotNull(string)) {
            updateDeviceIdVo = new UpdateDeviceIdVo();
            updateDeviceIdVo.setDeviceid(string);
        }
        if (this.E == null) {
            this.D.doLogout(updateDeviceIdVo);
            return;
        }
        NewUpdateDeviceIdVo newUpdateDeviceIdVo = new NewUpdateDeviceIdVo();
        newUpdateDeviceIdVo.setDeviceid(string);
        this.E.doLogout(newUpdateDeviceIdVo);
    }

    public final void K1(String str) {
        H();
        F0(this.C == 2 ? R.string.tip_update_pwd_success : R.string.tip_update_phone_success);
        c.getDefault().post(new UserSimpleDto());
        m();
        w.getInstance().clear();
        N();
    }

    public final void P1() {
        this.G.performNoLoginUpdatePhone(this.E);
    }

    public final void Q1() {
        d(UpdatePwdFragment.getInstance(2), R.id.flayout_content);
    }

    public final void R1() {
        if (this.C == 3) {
            this.G.noLoginSendSmsCode(this.E);
        } else {
            this.G.sendSmsCode(this.D, this.E);
        }
    }

    public final void S1() {
        if (c.e.a.a.a.getInstance().isH5Model()) {
            NewUserModel newUserModel = (NewUserModel) h(NewUserModel.class);
            this.E = newUserModel;
            newUserModel.getSmsCodeResult().observe(this, new Observer() { // from class: c.e.c.x.d.c2
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f2032a.I1((String) obj);
                }
            });
            this.E.getLogoutLiveData().observe(this, new Observer() { // from class: c.e.c.x.d.d2
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f2036a.K1((String) obj);
                }
            });
            this.E.getUpdateStateLiveData().observe(this, new Observer() { // from class: c.e.c.x.d.a2
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f2024a.J1((String) obj);
                }
            });
            this.E.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.x.d.b2
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f2028a.C((RequestErrDto) obj);
                }
            });
        }
        UserModel userModel = (UserModel) h(UserModel.class);
        this.D = userModel;
        userModel.getSmsCodeResult().observe(this, new Observer() { // from class: c.e.c.x.d.c2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2032a.I1((String) obj);
            }
        });
        this.D.getLogoutLiveData().observe(this, new Observer() { // from class: c.e.c.x.d.d2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2036a.K1((String) obj);
            }
        });
        this.D.getUpdateStateLiveData().observe(this, new Observer() { // from class: c.e.c.x.d.a2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2024a.J1((String) obj);
            }
        });
        this.D.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.x.d.b2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2028a.C((RequestErrDto) obj);
            }
        });
    }

    public final void T1() {
        boolean z = this.C == 2;
        this.mTitleTv.setText(z ? R.string.title_update_passwrod : R.string.title_update_phone);
        this.mConfirmBtn.setText(R.string.title_conform_value);
        this.f6488f = new CoreBaseFragment.c(this);
        UpdatePwdHandle updatePwdHandle = new UpdatePwdHandle(this.H);
        this.F = updatePwdHandle;
        updatePwdHandle.setupShowUpdatePwdView(z);
        UpdatePhoneHandle updatePhoneHandle = new UpdatePhoneHandle(this.H);
        this.G = updatePhoneHandle;
        updatePhoneHandle.setupShowUpdatePhone(z);
        if (this.C == 3) {
            this.mTitleTv.setText(R.string.title_update_phone);
            this.G.showOldPhone();
        }
    }

    public final void U1() {
        this.F.updatePassword(this.D, this.E);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
    }

    public final void V1() {
        this.G.performUpdatePhone(this.D, this.E);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        S1();
        T1();
    }

    public final void W1() {
        if (this.f6488f != null) {
            int i2 = this.B - 1;
            this.B = i2;
            this.G.updateTimer(i2);
            if (this.B > 0) {
                this.f6488f.sendEmptyMessageDelayed(1, 1000L);
            } else {
                this.B = 60;
                this.f6488f.removeMessages(1);
            }
        }
    }

    @OnClick({R.id.tv_back})
    public void backClick(View view) {
        n();
    }

    @OnClick({R.id.tv_confirm})
    public void confirmUpdate() {
        int i2 = this.C;
        if (i2 == 1) {
            V1();
        } else if (i2 == 2) {
            U1();
        } else {
            if (i2 != 3) {
                return;
            }
            P1();
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_update_phone_pwd;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
    }

    @OnClick({R.id.btn_send_sms})
    public void sendSmsCodeClick() {
        R1();
    }

    public final void setType(int i2) {
        this.C = i2;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void z(Message message) {
        if (message.what == 1) {
            W1();
        }
    }
}
