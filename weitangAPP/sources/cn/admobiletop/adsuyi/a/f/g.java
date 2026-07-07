package cn.admobiletop.adsuyi.a.f;

import android.database.Cursor;

/* JADX INFO: loaded from: classes.dex */
public class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3254a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f3255b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String[] f3256c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f3257d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ cn.admobiletop.adsuyi.a.f.c.a f3258e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ h f3259f;

    public g(h hVar, String str, String str2, String[] strArr, String str3, cn.admobiletop.adsuyi.a.f.c.a aVar) {
        this.f3259f = hVar;
        this.f3254a = str;
        this.f3255b = str2;
        this.f3256c = strArr;
        this.f3257d = str3;
        this.f3258e = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        cn.admobiletop.adsuyi.a.f.a.a aVarA = this.f3259f.a();
        try {
            try {
                Cursor cursorQuery = aVarA.b().query(this.f3254a, null, this.f3255b, this.f3256c, null, null, this.f3257d);
                if (cursorQuery != null && cursorQuery.getCount() > 0) {
                    while (cursorQuery.moveToNext()) {
                        this.f3258e.a(cursorQuery);
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                this.f3258e.onFinish();
            } catch (Exception e2) {
                e2.printStackTrace();
                this.f3258e.onFinish();
                if (aVarA == null) {
                    return;
                }
            }
            aVarA.a();
        } catch (Throwable th) {
            if (aVarA != null) {
                aVarA.a();
            }
            throw th;
        }
    }
}
