package com.tianmu.d.d;

import android.app.Activity;
import android.content.IntentFilter;
import com.bytedance.pangle.servermanager.AbsServerManager;
import com.tianmu.TianmuSDK;
import com.tianmu.biz.utils.d;
import com.tianmu.biz.utils.o;
import com.tianmu.checkapk.receiver.CacheDownloadApkReceiver;
import com.tianmu.d.c.b;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    public static class b implements com.tianmu.c.g.e.b<com.tianmu.d.a.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f11989a;

        public b(Activity activity) {
            this.f11989a = activity;
        }

        @Override // com.tianmu.c.g.e.b
        public void a() {
        }

        @Override // com.tianmu.c.g.e.b
        public void a(com.tianmu.d.a.a aVar) {
            com.tianmu.d.c.b.a().a(aVar.i());
            if (a.b(aVar.j())) {
                a.b(aVar, this.f11989a);
            }
        }
    }

    public static class c implements com.tianmu.d.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tianmu.d.a.a f11990a;

        public c(com.tianmu.d.a.a aVar) {
            this.f11990a = aVar;
        }

        @Override // com.tianmu.d.b.a
        public void a() {
            com.tianmu.d.a.a aVar = this.f11990a;
            if (aVar != null) {
                a.b(aVar);
            }
        }

        @Override // com.tianmu.d.b.a
        public void b() {
        }

        @Override // com.tianmu.d.b.a
        public void c() {
            com.tianmu.d.a.a aVar = this.f11990a;
            if (aVar != null) {
                a.a(aVar.j());
            }
        }
    }

    public static boolean b(String str) {
        try {
            return new File(str).exists();
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean c(String str) {
        try {
            if (TianmuSDK.getInstance().getNoticeBlockList() != null && str != null) {
                if (TianmuSDK.getInstance().getNoticeBlockList().contains(str)) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    public static void a(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(com.tianmu.d.a.a aVar, Activity activity) {
        com.tianmu.biz.widget.l.a aVar2 = new com.tianmu.biz.widget.l.a(activity);
        aVar2.a(new c(aVar));
        aVar2.a(aVar.b());
        aVar2.show();
    }

    /* JADX INFO: renamed from: com.tianmu.d.d.a$a, reason: collision with other inner class name */
    public static class C0219a implements com.tianmu.c.g.e.a<com.tianmu.d.a.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b.c f11988a;

        public C0219a(b.c cVar) {
            this.f11988a = cVar;
        }

        @Override // com.tianmu.c.g.e.a
        public void a(List<com.tianmu.d.a.a> list) {
            int i2 = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                if (o.b() - list.get(i3).c() > 1800) {
                    com.tianmu.d.c.b.a().a(list.get(i3).i());
                    i2++;
                }
            }
            this.f11988a.a(list.size() - i2);
        }

        @Override // com.tianmu.c.g.e.a
        public void a() {
            this.f11988a.a(0);
        }
    }

    public static void a(b.c cVar) {
        try {
            com.tianmu.d.c.b.a().a(new C0219a(cVar));
        } catch (Exception unused) {
        }
    }

    public static void a(Activity activity) {
        com.tianmu.d.c.b.a().a(new b(activity));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(com.tianmu.d.a.a aVar) {
        com.tianmu.c.h.b.c cVar = new com.tianmu.c.h.b.c(aVar);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addDataScheme(AbsServerManager.PACKAGE_QUERY_BINDER);
        TianmuSDK.getInstance().getContext().registerReceiver(new CacheDownloadApkReceiver(aVar, cVar), intentFilter);
        a(aVar.j(), false);
        cVar.c();
    }

    public static void a(String str, boolean z) {
        try {
            d.a(new File(str), z);
        } catch (Exception unused) {
            a(str);
        }
    }
}
