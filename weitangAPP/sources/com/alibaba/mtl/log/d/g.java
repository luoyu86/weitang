package com.alibaba.mtl.log.d;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static g f4561a = new g();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private a f61a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private b f62a;

    public class a implements Comparator<String> {
        private a() {
        }

        @Override // java.util.Comparator
        public int compare(String str, String str2) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return 0;
            }
            return str.compareTo(str2);
        }
    }

    public class b implements Comparator<String> {
        private b() {
        }

        @Override // java.util.Comparator
        public int compare(String str, String str2) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return 0;
            }
            return str.compareTo(str2) * (-1);
        }
    }

    private g() {
        this.f62a = new b();
        this.f61a = new a();
    }

    public static g a() {
        return f4561a;
    }

    public String[] a(String[] strArr, boolean z) {
        Comparator comparator = z ? this.f61a : this.f62a;
        if (comparator == null || strArr == null || strArr.length <= 0) {
            return null;
        }
        Arrays.sort(strArr, comparator);
        return strArr;
    }
}
