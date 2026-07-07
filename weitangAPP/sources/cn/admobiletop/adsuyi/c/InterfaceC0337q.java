package cn.admobiletop.adsuyi.c;

import android.graphics.Bitmap;
import android.net.Uri;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: renamed from: cn.admobiletop.adsuyi.c.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public interface InterfaceC0337q {

    /* JADX INFO: renamed from: cn.admobiletop.adsuyi.c.q$a */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final InputStream f4253a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Bitmap f4254b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f4255c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f4256d;

        public a(InputStream inputStream, boolean z, long j) {
            if (inputStream == null) {
                throw new IllegalArgumentException("Stream may not be null.");
            }
            this.f4253a = inputStream;
            this.f4254b = null;
            this.f4255c = z;
            this.f4256d = j;
        }

        @Deprecated
        public Bitmap a() {
            return this.f4254b;
        }

        public long b() {
            return this.f4256d;
        }

        public InputStream c() {
            return this.f4253a;
        }
    }

    /* JADX INFO: renamed from: cn.admobiletop.adsuyi.c.q$b */
    public static class b extends IOException {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f4257a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f4258b;

        public b(String str, int i2, int i3) {
            super(str);
            this.f4257a = x.a(i2);
            this.f4258b = i3;
        }
    }

    a a(Uri uri, int i2);
}
