package com.qq.e.comm.adevent;

import com.qq.e.comm.util.GDTLogger;

/* JADX INFO: loaded from: classes2.dex */
public class ADEvent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9644a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object[] f9645b;

    public ADEvent(int i2, Object... objArr) {
        this.f9644a = i2;
        this.f9645b = objArr;
        if (i2 < 100) {
            a("EventId 错误" + i2);
        }
    }

    public final void a(String str) {
        GDTLogger.e(str);
    }

    public <T> T getParam(int i2, Class<T> cls) {
        Object[] objArr;
        if (cls == null || (objArr = this.f9645b) == null || objArr.length <= i2) {
            return null;
        }
        T t = (T) objArr[i2];
        if (t == null) {
            GDTLogger.e("ADEvent 参数为空,type:" + this.f9644a);
            return null;
        }
        if (cls.isInstance(objArr[i2])) {
            return t;
        }
        GDTLogger.e("ADEvent" + this.f9644a + " 参数类型错误,期望类型" + cls.getName() + "实际类型 " + t.getClass().getName());
        return null;
    }

    public <T> T getParam(Class<T> cls) {
        return (T) getParam(0, cls);
    }

    public int getType() {
        return this.f9644a;
    }
}
