package cn.admobiletop.adsuyi.a.f;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f3251a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f3252b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ h f3253c;

    public f(h hVar, List list, String str) {
        this.f3253c = hVar;
        this.f3251a = list;
        this.f3252b = str;
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x006a: MOVE (r10 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:37:0x006a */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() throws java.lang.Throwable {
        /*
            r11 = this;
            cn.admobiletop.adsuyi.a.f.h r0 = r11.f3253c
            cn.admobiletop.adsuyi.a.f.a.a r0 = r0.a()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r0.c()     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            r2.beginTransaction()     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L47
            r3 = 0
            r4 = 0
        L10:
            java.util.List r5 = r11.f3251a     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L47
            int r5 = r5.size()     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L47
            if (r4 >= r5) goto L30
            java.util.List r5 = r11.f3251a     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L47
            java.lang.Object r5 = r5.get(r4)     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L47
            android.content.ContentValues r5 = (android.content.ContentValues) r5     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L47
            java.lang.String r6 = r11.f3252b     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L47
            long r5 = r2.replace(r6, r1, r5)     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L47
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
            r2.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L47
        L36:
            java.util.List r1 = r11.f3251a     // Catch: java.lang.Exception -> L66
            r1.clear()     // Catch: java.lang.Exception -> L66
            boolean r1 = r2.inTransaction()     // Catch: java.lang.Exception -> L66
            if (r1 == 0) goto L66
            r2.endTransaction()     // Catch: java.lang.Exception -> L66
            goto L66
        L45:
            r1 = move-exception
            goto L6a
        L47:
            r1 = move-exception
            goto L4f
        L49:
            r2 = move-exception
            goto L6d
        L4b:
            r2 = move-exception
            r10 = r2
            r2 = r1
            r1 = r10
        L4f:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L45
            java.util.List r1 = r11.f3251a     // Catch: java.lang.Exception -> L63
            r1.clear()     // Catch: java.lang.Exception -> L63
            if (r2 == 0) goto L64
            boolean r1 = r2.inTransaction()     // Catch: java.lang.Exception -> L63
            if (r1 == 0) goto L64
            r2.endTransaction()     // Catch: java.lang.Exception -> L63
            goto L64
        L63:
        L64:
            if (r0 == 0) goto L69
        L66:
            r0.a()
        L69:
            return
        L6a:
            r10 = r2
            r2 = r1
            r1 = r10
        L6d:
            java.util.List r3 = r11.f3251a     // Catch: java.lang.Exception -> L7e
            r3.clear()     // Catch: java.lang.Exception -> L7e
            if (r1 == 0) goto L7f
            boolean r3 = r1.inTransaction()     // Catch: java.lang.Exception -> L7e
            if (r3 == 0) goto L7f
            r1.endTransaction()     // Catch: java.lang.Exception -> L7e
            goto L7f
        L7e:
        L7f:
            if (r0 == 0) goto L84
            r0.a()
        L84:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.admobiletop.adsuyi.a.f.f.run():void");
    }
}
