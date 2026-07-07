package com.taobao.accs.utl;

import com.taobao.accs.utl.k;

/* JADX INFO: loaded from: classes2.dex */
public class i implements k.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c[] f10480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f10481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String[] f10482c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long[] f10483d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f10484e;

    public static class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f10485a;

        public a(String str) {
            this.f10485a = str;
        }

        @Override // com.taobao.accs.utl.i.c
        public boolean a(String str) {
            return (str == null || !str.contains(this.f10485a) || str.contains(" #$%")) ? false : true;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final i f10486a = new i();

        private b() {
        }
    }

    public interface c {
        boolean a(String str);
    }

    public static i a() {
        return b.f10486a;
    }

    private void b(String str) {
        int i2 = this.f10484e % 5;
        this.f10482c[i2] = str + " #$%";
        this.f10483d[i2] = System.currentTimeMillis() / 1000;
        this.f10484e = i2 + 1;
    }

    private i() {
        this.f10481b = 5;
        this.f10482c = new String[5];
        this.f10483d = new long[5];
        this.f10484e = 0;
        for (int i2 = 0; i2 < 5; i2++) {
            this.f10482c[i2] = null;
            this.f10483d[i2] = 0;
        }
        this.f10480a = new c[]{new a("send msg time out"), new a("errorCode::"), new a("errorId::"), new a("TNET_JNI_ERR_LOAD_SO_FAIL")};
    }

    @Override // com.taobao.accs.utl.k.a
    public void a(String str) {
        try {
            if (a(str, this.f10480a)) {
                b(str);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private boolean a(String str, c[] cVarArr) {
        for (c cVar : cVarArr) {
            if (cVar.a(str)) {
                return true;
            }
        }
        return false;
    }

    public String b() {
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis() / 1000);
        sb.append(" ");
        try {
            int i2 = ((this.f10484e - 1) % 5) + 5;
            for (int i3 = 0; i3 < 5; i3++) {
                int i4 = (i2 - i3) % 5;
                if (this.f10482c[i4] == null) {
                    break;
                }
                sb.append(this.f10483d[i4]);
                sb.append(" ");
                sb.append(this.f10482c[i4]);
                sb.append(" ");
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return sb.toString();
    }
}
