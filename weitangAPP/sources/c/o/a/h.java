package c.o.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.android.arouter.utils.Consts;

/* JADX INFO: loaded from: classes2.dex */
public class h implements c.o.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2973a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2974b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f2975c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final d f2976d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public final String f2977e;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2978a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2979b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f2980c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public d f2981d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Nullable
        public String f2982e;

        @NonNull
        public h build() {
            if (this.f2981d == null) {
                this.f2981d = new e();
            }
            return new h(this);
        }

        @NonNull
        public b logStrategy(@Nullable d dVar) {
            this.f2981d = dVar;
            return this;
        }

        @NonNull
        public b methodCount(int i2) {
            this.f2978a = i2;
            return this;
        }

        @NonNull
        public b methodOffset(int i2) {
            this.f2979b = i2;
            return this;
        }

        @NonNull
        public b showThreadInfo(boolean z) {
            this.f2980c = z;
            return this;
        }

        @NonNull
        public b tag(@Nullable String str) {
            this.f2982e = str;
            return this;
        }

        public b() {
            this.f2978a = 2;
            this.f2979b = 0;
            this.f2980c = true;
            this.f2982e = "PRETTY_LOGGER";
        }
    }

    @NonNull
    public static b newBuilder() {
        return new b();
    }

    @Nullable
    public final String a(@Nullable String str) {
        if (j.d(str) || j.b(this.f2977e, str)) {
            return this.f2977e;
        }
        return this.f2977e + "-" + str;
    }

    public final String b(@NonNull String str) {
        j.a(str);
        return str.substring(str.lastIndexOf(Consts.DOT) + 1);
    }

    public final int c(@NonNull StackTraceElement[] stackTraceElementArr) {
        j.a(stackTraceElementArr);
        for (int i2 = 5; i2 < stackTraceElementArr.length; i2++) {
            String className = stackTraceElementArr[i2].getClassName();
            if (!className.equals(g.class.getName()) && !className.equals(f.class.getName())) {
                return i2 - 1;
            }
        }
        return -1;
    }

    public final void d(int i2, @Nullable String str) {
        e(i2, str, "└────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
    }

    public final void e(int i2, @Nullable String str, @NonNull String str2) {
        j.a(str2);
        this.f2976d.log(i2, str, str2);
    }

    public final void f(int i2, @Nullable String str, @NonNull String str2) {
        j.a(str2);
        for (String str3 : str2.split(System.getProperty("line.separator"))) {
            e(i2, str, "│ " + str3);
        }
    }

    public final void g(int i2, @Nullable String str) {
        e(i2, str, "├┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄");
    }

    public final void h(int i2, @Nullable String str, int i3) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (this.f2975c) {
            e(i2, str, "│ Thread: " + Thread.currentThread().getName());
            g(i2, str);
        }
        int iC = c(stackTrace) + this.f2974b;
        if (i3 + iC > stackTrace.length) {
            i3 = (stackTrace.length - iC) - 1;
        }
        String str2 = "";
        while (i3 > 0) {
            int i4 = i3 + iC;
            if (i4 < stackTrace.length) {
                str2 = str2 + "   ";
                e(i2, str, "│ " + str2 + b(stackTrace[i4].getClassName()) + Consts.DOT + stackTrace[i4].getMethodName() + "  (" + stackTrace[i4].getFileName() + ":" + stackTrace[i4].getLineNumber() + ")");
            }
            i3--;
        }
    }

    public final void i(int i2, @Nullable String str) {
        e(i2, str, "┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
    }

    @Override // c.o.a.b
    public void log(int i2, @Nullable String str, @NonNull String str2) {
        j.a(str2);
        String strA = a(str);
        i(i2, strA);
        h(i2, strA, this.f2973a);
        byte[] bytes = str2.getBytes();
        int length = bytes.length;
        if (length <= 4000) {
            if (this.f2973a > 0) {
                g(i2, strA);
            }
            f(i2, strA, str2);
            d(i2, strA);
            return;
        }
        if (this.f2973a > 0) {
            g(i2, strA);
        }
        for (int i3 = 0; i3 < length; i3 += 4000) {
            f(i2, strA, new String(bytes, i3, Math.min(length - i3, 4000)));
        }
        d(i2, strA);
    }

    public h(@NonNull b bVar) {
        j.a(bVar);
        this.f2973a = bVar.f2978a;
        this.f2974b = bVar.f2979b;
        this.f2975c = bVar.f2980c;
        this.f2976d = bVar.f2981d;
        this.f2977e = bVar.f2982e;
    }
}
