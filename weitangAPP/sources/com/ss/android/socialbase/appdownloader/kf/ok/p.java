package com.ss.android.socialbase.appdownloader.kf.ok;

/* JADX INFO: loaded from: classes2.dex */
public class p extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f9939a;
    public int bl;
    public Throwable ok;

    public p(String str, h hVar, Throwable th) {
        String str2;
        String str3;
        StringBuilder sb = new StringBuilder();
        String str4 = "";
        if (str == null) {
            str2 = "";
        } else {
            str2 = str + " ";
        }
        sb.append(str2);
        if (hVar == null) {
            str3 = "";
        } else {
            str3 = "(position:" + hVar.s() + ") ";
        }
        sb.append(str3);
        if (th != null) {
            str4 = "caused by: " + th;
        }
        sb.append(str4);
        super(sb.toString());
        this.f9939a = -1;
        this.bl = -1;
        if (hVar != null) {
            this.f9939a = hVar.bl();
            this.bl = hVar.kf();
        }
        this.ok = th;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        if (this.ok == null) {
            super.printStackTrace();
            return;
        }
        synchronized (System.err) {
            System.err.println(super.getMessage() + "; nested exception is:");
            this.ok.printStackTrace();
        }
    }
}
