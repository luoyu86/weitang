package com.tianmu.c.g.f;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Handler;
import android.os.Looper;
import androidx.core.app.NotificationCompat;
import com.tianmu.biz.utils.o;
import com.tianmu.c.g.e.b;
import com.tianmu.c.g.e.c;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile a f11595b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Handler f11596a = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: com.tianmu.c.g.f.a$a, reason: collision with other inner class name */
    public class C0206a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tianmu.c.g.d.a[] f11597a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f11598b;

        /* JADX INFO: renamed from: com.tianmu.c.g.f.a$a$a, reason: collision with other inner class name */
        public class RunnableC0207a implements Runnable {
            public RunnableC0207a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C0206a c0206a = C0206a.this;
                com.tianmu.c.g.d.a[] aVarArr = c0206a.f11597a;
                if (aVarArr[0] != null) {
                    c0206a.f11598b.a(aVarArr[0]);
                } else {
                    c0206a.f11598b.a();
                }
            }
        }

        public C0206a(com.tianmu.c.g.d.a[] aVarArr, b bVar) {
            this.f11597a = aVarArr;
            this.f11598b = bVar;
        }

        @Override // com.tianmu.c.g.e.c
        public void a(Cursor cursor) {
            this.f11597a[0] = a.this.a(cursor);
        }

        @Override // com.tianmu.c.g.e.c
        public void a() {
            if (a.this.f11596a == null || this.f11598b == null) {
                return;
            }
            a.this.f11596a.post(new RunnableC0207a());
        }
    }

    public void b(String str) {
        com.tianmu.c.g.a.b().a("download_app_info", "path=?", new String[]{str});
    }

    public static a a() {
        if (f11595b == null) {
            synchronized (a.class) {
                if (f11595b == null) {
                    f11595b = new a();
                }
            }
        }
        return f11595b;
    }

    public void a(b<com.tianmu.c.g.d.a> bVar, String str) {
        com.tianmu.c.g.a.b().a("download_app_info", "package_name=?", new String[]{str}, null, new C0206a(new com.tianmu.c.g.d.a[1], bVar));
    }

    public void a(com.tianmu.c.g.d.a aVar) {
        ArrayList arrayList = new ArrayList();
        ContentValues contentValues = new ContentValues();
        contentValues.put("key", aVar.e());
        contentValues.put("package_name", aVar.h());
        contentValues.put("path", aVar.i());
        contentValues.put("name", aVar.f());
        contentValues.put("cover", aVar.b());
        contentValues.put("click_id", aVar.a());
        contentValues.put("scheme", aVar.k());
        contentValues.put("start_downloads", aVar.m());
        contentValues.put("downloadeds", aVar.c());
        contentValues.put("start_installs", aVar.n());
        contentValues.put("installeds", aVar.d());
        contentValues.put("opens", aVar.g());
        contentValues.put(NotificationCompat.CATEGORY_PROGRESS, Integer.valueOf(aVar.j()));
        contentValues.put("size", Long.valueOf(aVar.l()));
        contentValues.put("create_time", Long.valueOf(o.b()));
        arrayList.add(contentValues);
        com.tianmu.c.g.a.b().a("download_app_info", arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.tianmu.c.g.d.a a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            com.tianmu.c.g.d.a aVar = new com.tianmu.c.g.d.a();
            aVar.e(cursor.getString(cursor.getColumnIndexOrThrow("key")));
            aVar.i(cursor.getString(cursor.getColumnIndexOrThrow("path")));
            aVar.f(cursor.getString(cursor.getColumnIndexOrThrow("name")));
            aVar.b(cursor.getString(cursor.getColumnIndexOrThrow("cover")));
            aVar.h(cursor.getString(cursor.getColumnIndexOrThrow("package_name")));
            aVar.a(cursor.getString(cursor.getColumnIndexOrThrow("click_id")));
            aVar.j(cursor.getString(cursor.getColumnIndexOrThrow("scheme")));
            aVar.k(cursor.getString(cursor.getColumnIndexOrThrow("start_downloads")));
            aVar.c(cursor.getString(cursor.getColumnIndexOrThrow("downloadeds")));
            aVar.l(cursor.getString(cursor.getColumnIndexOrThrow("start_installs")));
            aVar.d(cursor.getString(cursor.getColumnIndexOrThrow("installeds")));
            aVar.g(cursor.getString(cursor.getColumnIndexOrThrow("opens")));
            aVar.b(cursor.getInt(cursor.getColumnIndexOrThrow(NotificationCompat.CATEGORY_PROGRESS)));
            aVar.a(cursor.getLong(cursor.getColumnIndexOrThrow("size")));
            aVar.a(cursor.getInt(cursor.getColumnIndexOrThrow("create_time")));
            return aVar;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public void a(String str) {
        com.tianmu.c.g.a.b().a("download_app_info", "package_name=?", new String[]{str});
    }
}
