package c.e.e.a.r;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import c.e.e.a.x.l;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.intelligoo.sdk.LibDevModel;
import com.intelligoo.sdk.LibInterface;
import com.tom_roush.pdfbox.contentstream.operator.OperatorName;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class b extends c.e.e.a.r.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c.e.e.a.s.f f2385c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LibInterface.ManagerCallback f2386d;

    public class a implements LibInterface.ManagerCallback {
        public a() {
        }

        @Override // com.intelligoo.sdk.LibInterface.ManagerCallback
        public void setResult(int i2, Bundle bundle) {
            String str;
            b.this.f2385c.setOpenDoorEndTime(Long.valueOf(System.currentTimeMillis()));
            b.this.f2385c.setRemark("大门门禁开锁记录");
            if (i2 == 0) {
                b.this.f2385c.setStatus(1);
                b.this.f();
                return;
            }
            b.this.f2385c.setStatus(0);
            b.this.f2385c.setFailReason(l.getInstance().getFailedMessage("code=" + i2));
            b bVar = b.this;
            if (i2 == 48) {
                str = "开锁超时,请重试!";
            } else {
                str = "开锁失败 code=" + i2;
            }
            bVar.h(str);
        }
    }

    public b(d dVar) {
        super(dVar);
        this.f2386d = new a();
    }

    public final LibDevModel e(c.e.e.a.s.c cVar) {
        LibDevModel libDevModel = new LibDevModel();
        libDevModel.devSn = cVar.getDevSn();
        libDevModel.devMac = cVar.getDevMac();
        libDevModel.devType = cVar.getDevType();
        libDevModel.eKey = cVar.geteKey();
        libDevModel.endDate = cVar.getEndDate();
        libDevModel.openType = cVar.getOpenType();
        libDevModel.privilege = cVar.getPrivilege();
        libDevModel.startDate = cVar.getStartDate();
        libDevModel.useCount = cVar.getUseCount();
        libDevModel.verified = cVar.getVerified();
        libDevModel.cardno = "123";
        return libDevModel;
    }

    public final void f() {
        d dVar = this.f2383a;
        if (dVar != null) {
            dVar.onUnlockSuccess();
        }
    }

    public final void g() {
        d dVar = this.f2383a;
        if (dVar != null) {
            dVar.onScanStart();
        }
    }

    public final void h(String str) {
        d dVar = this.f2383a;
        if (dVar != null) {
            dVar.onUnlockFailed(str);
        }
    }

    public final void i(String str, Context context, c.e.e.a.s.f fVar) {
        this.f2385c = fVar;
        fVar.setOpenDoorStartTime(Long.valueOf(System.currentTimeMillis()));
        try {
            LibDevModel libDevModelE = e((c.e.e.a.s.c) JSON.parseObject(str, c.e.e.a.s.c.class));
            libDevModelE.cardno = "123";
            g();
            LibDevModel.openDoor(context, libDevModelE, this.f2386d);
        } catch (JSONException e2) {
            e2.printStackTrace();
            h("json数据格式错误,开门失败");
        }
    }

    @Override // c.e.e.a.r.a
    public void openDoor(c.e.e.a.x.d dVar, Activity activity, c.e.e.a.s.f fVar) {
        i(dVar.getBluetoothPassword(), activity, fVar);
    }

    @Override // c.e.e.a.r.a
    public void release() {
        LibDevModel.stopScan();
        try {
            Method declaredMethod = Class.forName("com.intelligoo.sdk.f").getDeclaredMethod(OperatorName.SET_LINE_DASHPATTERN, new Class[0]);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(null, new Object[0]);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
