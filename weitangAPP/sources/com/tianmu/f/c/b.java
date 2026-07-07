package com.tianmu.f.c;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.tianmu.apilib.utils.e;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class b implements com.tianmu.f.b.b {

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tianmu.f.b.a f12019a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f12020b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Context f12021c;

        public a(com.tianmu.f.b.a aVar, String str, Context context) {
            this.f12019a = aVar;
            this.f12020b = str;
            this.f12021c = context;
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            long jCurrentTimeMillis = System.currentTimeMillis();
            FileOutputStream fileOutputStream = null;
            try {
                try {
                } catch (Exception unused) {
                } catch (Throwable th) {
                    th = th;
                }
                if (!TextUtils.isEmpty(this.f12019a.a()) && !TextUtils.isEmpty(this.f12019a.d())) {
                    String strA = com.tianmu.a.a.a.a(this.f12019a.c(), this.f12019a.f(), this.f12019a.e(), e.a(this.f12020b));
                    String strB = b.this.b(this.f12021c, this.f12019a.a());
                    FileOutputStream fileOutputStream2 = new FileOutputStream(strB);
                    try {
                        try {
                            fileOutputStream2.write(Base64.decode(strA, 2));
                            this.f12019a.a(new DexClassLoader(strB, b.this.a(this.f12021c, this.f12019a.d()), null, this.f12021c.getClassLoader()));
                            try {
                                File file = new File(strB);
                                if (file.exists()) {
                                    file.delete();
                                }
                            } catch (Exception unused2) {
                            }
                            Log.i(this.f12019a.b(), "uni finish, all time " + (System.currentTimeMillis() - jCurrentTimeMillis) + "ms");
                            fileOutputStream2.close();
                        } catch (Throwable th2) {
                            th = th2;
                            fileOutputStream = fileOutputStream2;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException unused3) {
                                }
                            }
                            throw th;
                        }
                    } catch (Exception unused4) {
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream == null) {
                        } else {
                            fileOutputStream.close();
                        }
                    }
                }
            } catch (IOException unused5) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(Context context, String str) {
        return context.getCacheDir().getAbsolutePath() + str;
    }

    @Override // com.tianmu.f.b.b
    public void a(com.tianmu.f.b.a aVar, Context context, String str) {
        if (aVar == null || context == null || str == null) {
            return;
        }
        com.tianmu.e.c.a.b().a().execute(new a(aVar, str, context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(Context context, String str) {
        return context.getDir(str, 0).getAbsolutePath();
    }
}
