package com.tianmu.c.g;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.tianmu.TianmuSDK;
import com.tianmu.c.k.e;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static a f11569b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.tianmu.c.g.c.a f11570a;

    /* JADX INFO: renamed from: com.tianmu.c.g.a$a, reason: collision with other inner class name */
    public class RunnableC0205a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f11571a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f11572b;

        public RunnableC0205a(List list, String str) {
            this.f11571a = list;
            this.f11572b = str;
        }

        /* JADX WARN: Removed duplicated region for block: B:31:0x0065  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x006a  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() throws java.lang.Throwable {
            /*
                r11 = this;
                com.tianmu.c.g.a r0 = com.tianmu.c.g.a.this
                com.tianmu.c.g.c.a r0 = r0.a()
                r1 = 0
                android.database.sqlite.SQLiteDatabase r2 = r0.c()     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L46
                r2.beginTransaction()     // Catch: java.lang.Exception -> L3f java.lang.Throwable -> L5d
                r3 = 0
                r4 = 0
            L10:
                java.util.List r5 = r11.f11571a     // Catch: java.lang.Exception -> L3f java.lang.Throwable -> L5d
                int r5 = r5.size()     // Catch: java.lang.Exception -> L3f java.lang.Throwable -> L5d
                if (r4 >= r5) goto L30
                java.util.List r5 = r11.f11571a     // Catch: java.lang.Exception -> L3f java.lang.Throwable -> L5d
                java.lang.Object r5 = r5.get(r4)     // Catch: java.lang.Exception -> L3f java.lang.Throwable -> L5d
                android.content.ContentValues r5 = (android.content.ContentValues) r5     // Catch: java.lang.Exception -> L3f java.lang.Throwable -> L5d
                java.lang.String r6 = r11.f11572b     // Catch: java.lang.Exception -> L3f java.lang.Throwable -> L5d
                long r5 = r2.replace(r6, r1, r5)     // Catch: java.lang.Exception -> L3f java.lang.Throwable -> L5d
                r7 = 0
                int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r9 > 0) goto L2d
                goto L31
            L2d:
                int r4 = r4 + 1
                goto L10
            L30:
                r3 = 1
            L31:
                if (r3 == 0) goto L36
                r2.setTransactionSuccessful()     // Catch: java.lang.Exception -> L3f java.lang.Throwable -> L5d
            L36:
                java.util.List r1 = r11.f11571a
                r1.clear()
                r2.endTransaction()
                goto L59
            L3f:
                r1 = move-exception
                goto L4a
            L41:
                r2 = move-exception
                r10 = r2
                r2 = r1
                r1 = r10
                goto L5e
            L46:
                r2 = move-exception
                r10 = r2
                r2 = r1
                r1 = r10
            L4a:
                r1.printStackTrace()     // Catch: java.lang.Throwable -> L5d
                java.util.List r1 = r11.f11571a
                r1.clear()
                if (r2 == 0) goto L57
                r2.endTransaction()
            L57:
                if (r0 == 0) goto L5c
            L59:
                r0.a()
            L5c:
                return
            L5d:
                r1 = move-exception
            L5e:
                java.util.List r3 = r11.f11571a
                r3.clear()
                if (r2 == 0) goto L68
                r2.endTransaction()
            L68:
                if (r0 == 0) goto L6d
                r0.a()
            L6d:
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tianmu.c.g.a.RunnableC0205a.run():void");
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f11574a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f11575b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String[] f11576c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f11577d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ com.tianmu.c.g.e.c f11578e;

        public b(String str, String str2, String[] strArr, String str3, com.tianmu.c.g.e.c cVar) {
            this.f11574a = str;
            this.f11575b = str2;
            this.f11576c = strArr;
            this.f11577d = str3;
            this.f11578e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tianmu.c.g.c.a aVarA = a.this.a();
            try {
                try {
                    Cursor cursorQuery = aVarA.b().query(this.f11574a, null, this.f11575b, this.f11576c, null, null, this.f11577d);
                    if (cursorQuery != null && cursorQuery.getCount() > 0) {
                        while (cursorQuery.moveToNext()) {
                            this.f11578e.a(cursorQuery);
                        }
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    this.f11578e.a();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    this.f11578e.a();
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

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f11580a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f11581b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String[] f11582c;

        public c(String str, String str2, String[] strArr) {
            this.f11580a = str;
            this.f11581b = str2;
            this.f11582c = strArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tianmu.c.g.c.a aVarA = a.this.a();
            try {
                try {
                    aVarA.b().delete(this.f11580a, this.f11581b, this.f11582c);
                } catch (Exception e2) {
                    e2.printStackTrace();
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

    private a() {
    }

    public static a b() {
        if (f11569b == null) {
            synchronized (a.class) {
                if (f11569b == null) {
                    f11569b = new a();
                }
            }
        }
        return f11569b;
    }

    public synchronized com.tianmu.c.g.c.a a() {
        if (TianmuSDK.getInstance().getContext() != null) {
            try {
                this.f11570a = com.tianmu.c.g.c.a.a(TianmuSDK.getInstance().getContext(), 2);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return this.f11570a;
    }

    public void a(String str, List<ContentValues> list) {
        if (TextUtils.isEmpty(str) || list == null || list.size() <= 0) {
            return;
        }
        e.e().c().execute(new RunnableC0205a(list, str));
    }

    public void a(String str, String str2, String[] strArr, String str3, com.tianmu.c.g.e.c cVar) {
        e.e().c().execute(new b(str, str2, strArr, str3, cVar));
    }

    public void a(String str, String str2, String[] strArr) {
        e.e().c().execute(new c(str, str2, strArr));
    }
}
