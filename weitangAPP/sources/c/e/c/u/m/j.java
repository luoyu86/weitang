package c.e.c.u.m;

import android.content.Context;
import c.e.a.d.q;
import c.e.a.d.w;
import c.e.a.d.x;
import c.e.a.d.y;
import com.alibaba.sdk.android.push.CloudPushService;
import com.alibaba.sdk.android.push.CommonCallback;
import com.alibaba.sdk.android.push.noonesdk.PushServiceFactory;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.login.bo.NewLoginBo;
import com.chinavisionary.microtang.me.bo.NewUpdateDeviceIdVo;
import com.chinavisionary.microtang.me.bo.UpdateDeviceIdVo;
import com.chinavisionary.microtang.me.model.NewUserModel;
import com.chinavisionary.microtang.me.model.UserModel;

/* JADX INFO: loaded from: classes.dex */
public class j extends g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public UserModel f1880b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public NewUserModel f1881c;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f1882a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f1883b;

        /* JADX INFO: renamed from: c.e.c.u.m.j$a$a, reason: collision with other inner class name */
        public class C0030a implements CommonCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ CloudPushService f1885a;

            public C0030a(CloudPushService cloudPushService) {
                this.f1885a = cloudPushService;
            }

            @Override // com.alibaba.sdk.android.push.CommonCallback
            public void onFailed(String str, String str2) {
                q.e(j.class.getSimpleName(), "errorcode:" + str + ",errorMessage:" + str2);
            }

            @Override // com.alibaba.sdk.android.push.CommonCallback
            public void onSuccess(String str) {
                String deviceId = this.f1885a.getDeviceId();
                w.getInstance().putString("device_id_key", deviceId);
                a aVar = a.this;
                j.this.f(deviceId, aVar.f1883b);
            }
        }

        public a(Context context, boolean z) {
            this.f1882a = context;
            this.f1883b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            String string = w.getInstance().getString("device_id_key", null);
            if (!x.isNullStr(string) || this.f1882a == null) {
                j.this.f(string, this.f1883b);
                return;
            }
            CloudPushService cloudPushService = PushServiceFactory.getCloudPushService();
            if (cloudPushService != null) {
                cloudPushService.register(this.f1882a.getApplicationContext(), new C0030a(cloudPushService));
            }
        }
    }

    public j(UserModel userModel) {
        this.f1880b = userModel;
    }

    public final NewLoginBo e(String str, String str2) {
        NewLoginBo newLoginBo = new NewLoginBo();
        if (!c.e.a.a.a.getInstance().isAdmin()) {
            newLoginBo.setIdentityType(NewLoginBo.LOGIN_NAME);
        }
        newLoginBo.setIdentifier(x.trimAll(str));
        newLoginBo.setCredential(str2);
        return newLoginBo;
    }

    public final void f(String str, boolean z) {
        new UpdateDeviceIdVo().setDeviceid(str);
        NewUpdateDeviceIdVo newUpdateDeviceIdVo = new NewUpdateDeviceIdVo();
        newUpdateDeviceIdVo.setDeviceid(str);
        if (z) {
            this.f1881c.postPushDeviceId(newUpdateDeviceIdVo);
        } else {
            this.f1881c.delPushDeviceId(newUpdateDeviceIdVo);
        }
    }

    public void performPwdLogin(String str, String str2) {
        b(R.string.tip_login_loading);
        this.f1881c.doLogin(e(str, str2));
    }

    public void setNewUserModel(NewUserModel newUserModel) {
        this.f1881c = newUserModel;
    }

    public void updateDeviceId(Context context, boolean z) {
        y.get().addRunnable(new a(context, z));
    }
}
