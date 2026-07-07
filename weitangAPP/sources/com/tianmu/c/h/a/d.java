package com.tianmu.c.h.a;

import android.text.TextUtils;
import com.tianmu.TianmuSDK;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c f11621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.tianmu.c.h.b.b f11622b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f11623c;

    public d(c cVar, com.tianmu.c.h.b.b bVar, long j) {
        this.f11621a = cVar;
        this.f11622b = bVar;
        this.f11623c = j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0186: MOVE (r0 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:86:0x0186 */
    /* JADX WARN: Removed duplicated region for block: B:118:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0178 A[Catch: IOException -> 0x0174, TryCatch #2 {IOException -> 0x0174, blocks: (B:75:0x0170, B:79:0x0178, B:81:0x017d), top: B:99:0x0170 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x017d A[Catch: IOException -> 0x0174, TRY_LEAVE, TryCatch #2 {IOException -> 0x0174, blocks: (B:75:0x0170, B:79:0x0178, B:81:0x017d), top: B:99:0x0170 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0170 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r14v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v3, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r14v5 */
    /* JADX WARN: Type inference failed for: r14v6, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r14v8, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r14v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(java.io.File r13, java.lang.String r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 414
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tianmu.c.h.a.d.a(java.io.File, java.lang.String):void");
    }

    private String b() {
        try {
            return com.tianmu.c.h.b.a.a(this.f11621a.f(), TianmuSDK.getInstance().getContext());
        } catch (Exception unused) {
            return null;
        }
    }

    private void c() {
        c cVar = this.f11621a;
        if (cVar == null || cVar.i() <= 0) {
            return;
        }
        com.tianmu.c.g.d.a aVar = new com.tianmu.c.g.d.a();
        aVar.h(this.f11621a.c());
        aVar.i(b());
        aVar.a(this.f11621a.i());
        com.tianmu.c.g.f.a.a().a(aVar);
    }

    public boolean a(int i2) {
        return 301 == i2 || 302 == i2 || 303 == i2;
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        String strB = b();
        if (TextUtils.isEmpty(strB)) {
            return;
        }
        File file = new File(strB);
        if (file.exists() && file.length() == this.f11623c) {
            com.tianmu.biz.utils.d.a(this.f11621a.f(), false);
            return;
        }
        if (file.exists() && this.f11621a.i() > 0 && this.f11621a.e() == this.f11621a.i()) {
            com.tianmu.biz.utils.d.a(this.f11621a.f(), false);
            return;
        }
        if (file.exists() && file.length() == this.f11621a.e() && this.f11621a.e() != 0) {
            this.f11621a.a(file.length());
        } else {
            file.delete();
            this.f11621a.a(0L);
        }
        this.f11621a.l();
        a(file, this.f11621a.g());
    }

    public c a() {
        return this.f11621a;
    }
}
