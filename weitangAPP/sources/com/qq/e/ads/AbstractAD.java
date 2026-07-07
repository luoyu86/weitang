package com.qq.e.ads;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.qq.e.comm.constants.ErrorCode;
import com.qq.e.comm.managers.a;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractAD<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f9515a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f9519e;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f9517c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f9518d = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f9516b = new Handler(Looper.getMainLooper());

    public abstract T a(Context context, POFactory pOFactory, String str, String str2, String str3);

    public final void a(final int i2) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            b(i2);
        } else {
            this.f9516b.post(new Runnable() { // from class: com.qq.e.ads.AbstractAD.2
                @Override // java.lang.Runnable
                public void run() {
                    AbstractAD.this.b(i2);
                }
            });
        }
    }

    public final void a(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            c(context, str, "");
        } else {
            GDTLogger.e("初始化错误：参数错误context或posId为空");
            a(ErrorCode.INIT_ERROR);
        }
    }

    public final void a(Context context, String str, String str2) {
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            c(context, str, str2);
        } else {
            GDTLogger.e("初始化错误：参数错误，context、posId、token 不可为空");
            a(ErrorCode.INIT_ERROR);
        }
    }

    public abstract void a(T t);

    public final void a(String str) {
        GDTLogger.e(getClass().getSimpleName() + ":调用方法 " + str + "异常，广告实例还未初始化");
    }

    public final boolean a() {
        return this.f9519e && this.f9518d;
    }

    public abstract void b(int i2);

    public final boolean b() {
        return this.f9517c;
    }

    public final void c(final Context context, final String str, final String str2) {
        this.f9519e = true;
        if (!a.b().d()) {
            a(ErrorCode.NOT_INIT);
            return;
        }
        final String strA = a.b().a();
        if (com.qq.e.comm.a.a(context)) {
            this.f9518d = true;
            a.f9661g.execute(new Runnable() { // from class: com.qq.e.ads.AbstractAD.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        final POFactory pOFactory = a.b().c().getPOFactory();
                        AbstractAD.this.f9516b.post(new Runnable() { // from class: com.qq.e.ads.AbstractAD.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    POFactory pOFactory2 = pOFactory;
                                    if (pOFactory2 != null) {
                                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                        AbstractAD abstractAD = AbstractAD.this;
                                        abstractAD.f9515a = (T) abstractAD.a(context, pOFactory2, strA, str, str2);
                                        AbstractAD.this.f9517c = true;
                                        AbstractAD abstractAD2 = AbstractAD.this;
                                        T t = abstractAD2.f9515a;
                                        if (t == null) {
                                            abstractAD2.a(ErrorCode.POFACTORY_GET_INTERFACE_ERROR);
                                        } else {
                                            abstractAD2.a(t);
                                        }
                                    } else {
                                        AbstractAD.this.f9517c = true;
                                        AbstractAD.this.a(ErrorCode.PLUGIN_INIT_ERROR);
                                    }
                                } catch (Throwable th) {
                                    GDTLogger.e("初始化错误：初始化广告实例时发生异常", th);
                                    AbstractAD.this.f9517c = true;
                                    AbstractAD.this.a(ErrorCode.INIT_ERROR);
                                }
                            }
                        });
                    } catch (Throwable th) {
                        GDTLogger.e("初始化错误：初始化插件时发生异常", th);
                        AbstractAD.this.f9517c = true;
                        AbstractAD.this.a(ErrorCode.PLUGIN_INIT_ERROR);
                    }
                }
            });
        } else {
            GDTLogger.e("Manifest文件中Activity/Service/Permission的声明有问题或者Permission权限未授予");
            a(ErrorCode.MANIFEST_ERROR);
        }
    }
}
