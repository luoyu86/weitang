package com.tianmu.g;

import android.graphics.Bitmap;
import android.net.Uri;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public interface i {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final InputStream f12080a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Bitmap f12081b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f12082c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f12083d;

        public a(InputStream inputStream, boolean z, long j) {
            if (inputStream == null) {
                throw new IllegalArgumentException("Stream may not be null.");
            }
            this.f12080a = inputStream;
            this.f12081b = null;
            this.f12082c = z;
            this.f12083d = j;
        }

        @Deprecated
        public Bitmap a() {
            return this.f12081b;
        }

        public long b() {
            return this.f12083d;
        }

        public InputStream c() {
            return this.f12080a;
        }
    }

    public static class b extends IOException {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f12084a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f12085b;

        public b(String str, int i2, int i3) {
            super(str);
            this.f12084a = p.a(i2);
            this.f12085b = i3;
        }
    }

    a a(Uri uri, int i2);
}
