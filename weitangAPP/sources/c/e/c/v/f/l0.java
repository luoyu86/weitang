package c.e.c.v.f;

import androidx.fragment.app.FragmentActivity;
import com.alibaba.sdk.android.push.CloudPushService;
import com.alibaba.sdk.android.push.CommonCallback;
import com.alibaba.sdk.android.push.noonesdk.PushServiceFactory;
import com.chinavisionary.microtang.me.bo.NewUpdateDeviceIdVo;
import com.chinavisionary.microtang.me.bo.UpdateDeviceIdVo;
import com.chinavisionary.microtang.me.model.NewUserModel;
import com.chinavisionary.microtang.me.model.UserModel;

/* JADX INFO: loaded from: classes.dex */
public class l0 {

    public class a implements CommonCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CloudPushService f1983a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ UserModel f1984b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ NewUserModel f1985c;

        public a(CloudPushService cloudPushService, UserModel userModel, NewUserModel newUserModel) {
            this.f1983a = cloudPushService;
            this.f1984b = userModel;
            this.f1985c = newUserModel;
        }

        @Override // com.alibaba.sdk.android.push.CommonCallback
        public void onFailed(String str, String str2) {
            c.e.a.d.q.e(b0.class.getSimpleName(), "init cloudchannel failed -- errorcode:" + str + " -- errorMessage:" + str2);
        }

        @Override // com.alibaba.sdk.android.push.CommonCallback
        public void onSuccess(String str) {
            c.e.a.d.q.i(b0.class.getSimpleName(), "init cloudchannel success device id :" + this.f1983a.getDeviceId());
            c.e.a.d.w.getInstance().putString("device_id_key", this.f1983a.getDeviceId());
            l0.this.b(this.f1984b, this.f1985c, this.f1983a.getDeviceId());
        }
    }

    public final void b(UserModel userModel, NewUserModel newUserModel, String str) {
        new UpdateDeviceIdVo().setDeviceid(str);
        c.e.a.d.q.d(l0.class.getSimpleName(), "postDeviceId device id :" + str);
        if (newUserModel != null) {
            NewUpdateDeviceIdVo newUpdateDeviceIdVo = new NewUpdateDeviceIdVo();
            newUpdateDeviceIdVo.setDeviceid(str);
            newUserModel.postPushDeviceId(newUpdateDeviceIdVo);
        }
    }

    public void c(UserModel userModel, NewUserModel newUserModel, FragmentActivity fragmentActivity) {
        String string = c.e.a.d.w.getInstance().getString("device_id_key", null);
        c.e.a.d.q.d(l0.class.getSimpleName(), "deviceId :" + string);
        if (!c.e.a.d.x.isNullStr(string)) {
            b(userModel, newUserModel, string);
        } else {
            CloudPushService cloudPushService = PushServiceFactory.getCloudPushService();
            cloudPushService.register(fragmentActivity.getApplicationContext(), new a(cloudPushService, userModel, newUserModel));
        }
    }
}
