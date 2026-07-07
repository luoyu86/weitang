package c.e.c.u.m;

import android.os.Handler;
import android.widget.Button;
import c.e.a.d.w;
import c.e.a.d.x;
import com.chinavisionary.framework.mobile.login.param.SMSSendParam;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.login.bo.NewLoginBo;
import com.chinavisionary.microtang.me.model.NewUserModel;
import com.chinavisionary.microtang.me.model.UserModel;

/* JADX INFO: loaded from: classes.dex */
public class k extends g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1887b = 60;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f1888c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f1889d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1890e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Button f1891f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Handler f1892g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public UserModel f1893h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public NewUserModel f1894i;

    public k(Button button, Handler handler, UserModel userModel) {
        this.f1892g = handler;
        this.f1891f = button;
        this.f1893h = userModel;
        this.f1889d = button.getResources().getColor(R.color.color_white);
        this.f1890e = button.getResources().getColor(R.color.colore757575);
    }

    public final NewLoginBo d(String str, String str2) {
        NewLoginBo newLoginBo = new NewLoginBo();
        newLoginBo.setIdentifier(x.trimAll(str));
        newLoginBo.setCode(x.trimAll(str2));
        return newLoginBo;
    }

    public final void e(boolean z) {
        this.f1887b = 60;
        this.f1888c = false;
        this.f1891f.setEnabled(true);
        this.f1892g.removeMessages(1);
        this.f1892g.sendEmptyMessage(2);
        this.f1891f.setText(R.string.title_retry_send_sms_code);
        c.e.a.a.b.getInstance().setToken(null);
        w.getInstance().remove("Token");
    }

    public final void f(boolean z) {
        if (((Boolean) this.f1891f.getTag()).booleanValue() != z) {
            this.f1891f.setTag(Boolean.valueOf(z));
            this.f1891f.setTextColor(z ? this.f1889d : this.f1890e);
            this.f1891f.setBackgroundResource(z ? R.drawable.login_available_sms_btn_bg_drawable : R.drawable.login_sms_btn_bg_drawable);
        }
    }

    public void handlerStartTimer() {
        c(R.string.tip_sms_code_send_success);
        this.f1888c = true;
        this.f1891f.setEnabled(false);
        this.f1891f.setText(String.format(x.getString(R.string.placeholder_sms_timer), Integer.valueOf(this.f1887b)));
        Button button = this.f1891f;
        button.setTextColor(button.getResources().getColor(R.color.tab_item_select_color));
        this.f1891f.setBackgroundResource(R.drawable.bg_btn_sms_code);
        Handler handler = this.f1892g;
        if (handler != null) {
            handler.sendEmptyMessageDelayed(1, 1000L);
        }
    }

    public boolean isSendSms() {
        return this.f1888c;
    }

    public void performSmsCodeLogin(String str, String str2) {
        if (!this.f1888c) {
            c(R.string.title_please_send_sms_code);
        } else {
            b(R.string.tip_login_loading);
            this.f1894i.doSmsLogin(d(str, str2));
        }
    }

    public void sendSmsCodeToPhone(String str) {
        if (((Boolean) this.f1891f.getTag()).booleanValue()) {
            if (!x.isNotNull(str)) {
                c(R.string.tip_phone_is_empty);
                return;
            }
            b(R.string.tip_get_sms_code_load);
            SMSSendParam sMSSendParam = new SMSSendParam();
            sMSSendParam.setPhone(str);
            this.f1894i.getSmsCode(sMSSendParam);
        }
    }

    public void setNewUserModel(NewUserModel newUserModel) {
        this.f1894i = newUserModel;
    }

    public void setupSendSmsBtnIsEnableToPhone(String str) {
        if (x.isNotNull(str) && x.isMobile(str)) {
            f(true);
        } else {
            f(false);
        }
    }

    public void updateTimer() {
        if (this.f1892g != null) {
            int i2 = this.f1887b - 1;
            this.f1887b = i2;
            if (i2 <= 0) {
                e(false);
            } else {
                this.f1891f.setText(String.format(x.getString(R.string.placeholder_sms_timer), Integer.valueOf(this.f1887b)));
                this.f1892g.sendEmptyMessageDelayed(1, 1000L);
            }
        }
    }
}
