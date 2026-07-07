package com.ut.mini.core.sign;

import android.content.Context;
import com.alibaba.mtl.log.b;
import com.alibaba.mtl.log.d.i;
import com.taobao.accs.common.Constants;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class UTSecuritySDKRequestAuthentication implements IUTRequestAuthentication {
    private String ad;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f12363g;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Object f12361b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Object f12362c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Class f12360a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Field f156a = null;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private Field f158b = null;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    private Field f159c = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Method f157a = null;
    private int z = 1;
    private boolean F = false;

    public UTSecuritySDKRequestAuthentication(String str, String str2) {
        this.f12363g = null;
        this.f12363g = str;
        this.ad = str2;
    }

    private synchronized void D() {
        Class<?> cls;
        Method method;
        boolean zBooleanValue;
        if (this.F) {
            return;
        }
        Class<?> cls2 = null;
        try {
            cls = Class.forName("com.alibaba.wireless.security.open.SecurityGuardManager");
        } catch (Throwable th) {
            th = th;
            cls = null;
        }
        try {
            this.f12361b = cls.getMethod("getInstance", Context.class).invoke(null, b.a().getContext());
            this.f12362c = cls.getMethod("getSecureSignatureComp", new Class[0]).invoke(this.f12361b, new Object[0]);
        } catch (Throwable th2) {
            th = th2;
            i.a("initSecurityCheck", th.getMessage());
        }
        if (cls == null) {
            this.F = true;
            return;
        }
        try {
            Class<?> cls3 = Class.forName("com.alibaba.wireless.security.open.SecurityGuardParamContext");
            this.f12360a = cls3;
            this.f156a = cls3.getDeclaredField(Constants.KEY_APP_KEY);
            this.f158b = this.f12360a.getDeclaredField("paramMap");
            this.f159c = this.f12360a.getDeclaredField("requestType");
            try {
                method = cls.getMethod("isOpen", new Class[0]);
            } catch (Throwable th3) {
                i.a("initSecurityCheck", th3.getMessage());
                method = null;
            }
            if (method != null) {
                zBooleanValue = ((Boolean) method.invoke(this.f12361b, new Object[0])).booleanValue();
            } else {
                try {
                    cls2 = Class.forName("com.taobao.wireless.security.sdk.securitybody.ISecurityBodyComponent");
                } catch (Throwable th4) {
                    i.a("initSecurityCheck", th4.getMessage());
                }
                zBooleanValue = cls2 == null;
            }
            this.z = zBooleanValue ? 1 : 12;
            this.f157a = Class.forName("com.alibaba.wireless.security.open.securesignature.ISecureSignatureComponent").getMethod("signRequest", this.f12360a, String.class);
        } catch (Throwable th5) {
            i.a("initSecurityCheck", th5.getMessage());
        }
        this.F = true;
        return;
    }

    @Override // com.ut.mini.core.sign.IUTRequestAuthentication
    public String getAppkey() {
        return this.f12363g;
    }

    public String getAuthCode() {
        return this.ad;
    }

    @Override // com.ut.mini.core.sign.IUTRequestAuthentication
    public String getSign(String str) {
        Class cls;
        if (!this.F) {
            D();
        }
        if (this.f12363g == null) {
            i.a("UTSecuritySDKRequestAuthentication:getSign", "There is no appkey,please check it!");
            return null;
        }
        if (str == null || this.f12361b == null || (cls = this.f12360a) == null || this.f156a == null || this.f158b == null || this.f159c == null || this.f157a == null || this.f12362c == null) {
            return null;
        }
        try {
            Object objNewInstance = cls.newInstance();
            this.f156a.set(objNewInstance, this.f12363g);
            ((Map) this.f158b.get(objNewInstance)).put("INPUT", str);
            this.f159c.set(objNewInstance, Integer.valueOf(this.z));
            return (String) this.f157a.invoke(this.f12362c, objNewInstance, this.ad);
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return null;
        } catch (IllegalArgumentException e3) {
            e3.printStackTrace();
            return null;
        } catch (InstantiationException e4) {
            e4.printStackTrace();
            return null;
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
            return null;
        }
    }
}
