package com.tianmu.d.c;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Handler;
import android.os.Looper;
import com.tianmu.biz.utils.d;
import com.tianmu.biz.utils.o;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile b f11978c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Handler f11979a = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<com.tianmu.d.a.a> f11980b;

    /* JADX INFO: renamed from: com.tianmu.d.c.b$b, reason: collision with other inner class name */
    public class C0218b implements com.tianmu.c.g.e.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tianmu.d.a.a[] f11984a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tianmu.c.g.e.b f11985b;

        /* JADX INFO: renamed from: com.tianmu.d.c.b$b$a */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C0218b c0218b = C0218b.this;
                com.tianmu.d.a.a[] aVarArr = c0218b.f11984a;
                if (aVarArr[0] != null) {
                    c0218b.f11985b.a(aVarArr[0]);
                } else {
                    c0218b.f11985b.a();
                }
            }
        }

        public C0218b(com.tianmu.d.a.a[] aVarArr, com.tianmu.c.g.e.b bVar) {
            this.f11984a = aVarArr;
            this.f11985b = bVar;
        }

        @Override // com.tianmu.c.g.e.c
        public void a(Cursor cursor) {
            this.f11984a[0] = b.this.a(cursor);
        }

        @Override // com.tianmu.c.g.e.c
        public void a() {
            if (b.this.f11979a == null || this.f11985b == null) {
                return;
            }
            b.this.f11979a.post(new a());
        }
    }

    public interface c {
        void a(int i2);
    }

    public class a implements com.tianmu.c.g.e.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tianmu.c.g.e.a f11981a;

        /* JADX INFO: renamed from: com.tianmu.d.c.b$a$a, reason: collision with other inner class name */
        public class RunnableC0217a implements Runnable {
            public RunnableC0217a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (b.this.f11980b == null || b.this.f11980b.isEmpty()) {
                    a.this.f11981a.a();
                } else {
                    a aVar = a.this;
                    aVar.f11981a.a(b.this.f11980b);
                }
            }
        }

        public a(com.tianmu.c.g.e.a aVar) {
            this.f11981a = aVar;
        }

        @Override // com.tianmu.c.g.e.c
        public void a(Cursor cursor) {
            if (b.this.f11980b == null) {
                b.this.f11980b = new ArrayList();
            }
            com.tianmu.d.a.a aVarA = b.this.a(cursor);
            if (aVarA != null) {
                b.this.f11980b.add(aVarA);
            }
        }

        @Override // com.tianmu.c.g.e.c
        public void a() {
            if (b.this.f11979a == null || this.f11981a == null) {
                return;
            }
            b.this.f11979a.post(new RunnableC0217a());
        }
    }

    public static b a() {
        if (f11978c == null) {
            synchronized (b.class) {
                if (f11978c == null) {
                    f11978c = new b();
                }
            }
        }
        return f11978c;
    }

    public void a(com.tianmu.c.g.e.a<com.tianmu.d.a.a> aVar) {
        this.f11980b = new ArrayList();
        com.tianmu.c.g.a.b().a("download_apk", null, null, null, new a(aVar));
    }

    public void a(com.tianmu.c.g.e.b<com.tianmu.d.a.a> bVar) {
        com.tianmu.c.g.a.b().a("download_apk", null, null, "create_time desc limit 1", new C0218b(new com.tianmu.d.a.a[1], bVar));
    }

    public void a(com.tianmu.d.a.a aVar) {
        ArrayList arrayList = new ArrayList();
        ContentValues contentValues = new ContentValues();
        contentValues.put("package_name", aVar.i());
        contentValues.put("path", aVar.j());
        contentValues.put("name", aVar.f());
        contentValues.put("cover", aVar.b());
        contentValues.put("click_id", aVar.a());
        contentValues.put("scheme", aVar.k());
        contentValues.put("starts", aVar.m());
        contentValues.put("ends", aVar.e());
        contentValues.put("opens", aVar.h());
        contentValues.put("create_time", Long.valueOf(o.b()));
        arrayList.add(contentValues);
        com.tianmu.c.g.a.b().a("download_apk", arrayList);
    }

    public void a(String str) {
        com.tianmu.c.g.a.b().a("download_apk", "package_name=?", new String[]{str});
    }

    public void a(String str, String str2) {
        com.tianmu.c.h.a.b bVarB = com.tianmu.c.h.d.a.c().b(str);
        if (bVarB != null) {
            a().a(new com.tianmu.d.a.a(d.b(str2), bVarB.h(), bVarB.f(), bVarB.a(), bVarB.b(), bVarB.i(), bVarB.k(), bVarB.e(), bVarB.g()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.tianmu.d.a.a a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            com.tianmu.d.a.a aVar = new com.tianmu.d.a.a();
            aVar.g(cursor.getString(cursor.getColumnIndexOrThrow("path")));
            aVar.f(cursor.getString(cursor.getColumnIndexOrThrow("package_name")));
            aVar.d(cursor.getString(cursor.getColumnIndexOrThrow("name")));
            aVar.b(cursor.getString(cursor.getColumnIndexOrThrow("cover")));
            aVar.h(cursor.getString(cursor.getColumnIndexOrThrow("scheme")));
            aVar.a(cursor.getString(cursor.getColumnIndexOrThrow("click_id")));
            aVar.i(cursor.getString(cursor.getColumnIndexOrThrow("starts")));
            aVar.c(cursor.getString(cursor.getColumnIndexOrThrow("ends")));
            aVar.e(cursor.getString(cursor.getColumnIndexOrThrow("opens")));
            aVar.a(cursor.getInt(cursor.getColumnIndexOrThrow("create_time")));
            return aVar;
        } catch (Exception unused) {
            return null;
        }
    }
}
