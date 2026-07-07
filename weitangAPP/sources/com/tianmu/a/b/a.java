package com.tianmu.a.b;

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
public class a implements com.tianmu.api.iinterface.b {

    /* JADX INFO: renamed from: com.tianmu.a.b.a$a, reason: collision with other inner class name */
    public class RunnableC0180a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tianmu.api.iinterface.a f10543a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f10544b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Context f10545c;

        public RunnableC0180a(com.tianmu.api.iinterface.a aVar, String str, Context context) {
            this.f10543a = aVar;
            this.f10544b = str;
            this.f10545c = context;
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
                if (!TextUtils.isEmpty(this.f10543a.a()) && !TextUtils.isEmpty(this.f10543a.d())) {
                    String strA = com.tianmu.a.a.a.a(this.f10543a.c(), this.f10543a.f(), this.f10543a.e(), e.a(this.f10544b));
                    String strB = a.this.b(this.f10545c, this.f10543a.a());
                    FileOutputStream fileOutputStream2 = new FileOutputStream(strB);
                    try {
                        try {
                            fileOutputStream2.write(Base64.decode(strA, 2));
                            this.f10543a.a(new DexClassLoader(strB, a.this.a(this.f10545c, this.f10543a.d()), null, this.f10545c.getClassLoader()));
                            try {
                                File file = new File(strB);
                                if (file.exists()) {
                                    file.delete();
                                }
                            } catch (Exception unused2) {
                            }
                            Log.i(this.f10543a.b(), "di common finish, all time " + (System.currentTimeMillis() - jCurrentTimeMillis) + "ms");
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

    @Override // com.tianmu.api.iinterface.b
    public void a(com.tianmu.api.iinterface.a aVar, Context context, String str) {
        if (aVar == null || context == null || str == null) {
            return;
        }
        com.tianmu.e.c.a.b().a().execute(new RunnableC0180a(aVar, str, context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(Context context, String str) {
        return context.getDir(str, 0).getAbsolutePath();
    }
}
