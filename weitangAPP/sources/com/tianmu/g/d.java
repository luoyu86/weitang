package com.tianmu.g;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes2.dex */
public interface d {

    public static class a implements d {
        @Override // com.tianmu.g.d
        public int a() {
            return 0;
        }

        @Override // com.tianmu.g.d
        public void a(String str, Bitmap bitmap) {
        }

        @Override // com.tianmu.g.d
        public int b() {
            return 0;
        }

        @Override // com.tianmu.g.d
        public Bitmap get(String str) {
            return null;
        }
    }

    static {
        new a();
    }

    int a();

    void a(String str, Bitmap bitmap);

    int b();

    Bitmap get(String str);
}
