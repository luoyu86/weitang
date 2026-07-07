package com.alipay.android.phone.mrpc.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.Header;

/* JADX INFO: loaded from: classes.dex */
public final class o extends t {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f5100b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f5101c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f5105g;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayList<Header> f5103e = new ArrayList<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Map<String, String> f5104f = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f5102d = "application/x-www-form-urlencoded";

    public o(String str) {
        this.f5100b = str;
    }

    public final String a() {
        return this.f5100b;
    }

    public final void a(String str) {
        this.f5102d = str;
    }

    public final void a(String str, String str2) {
        if (this.f5104f == null) {
            this.f5104f = new HashMap();
        }
        this.f5104f.put(str, str2);
    }

    public final void a(Header header) {
        this.f5103e.add(header);
    }

    public final void a(boolean z) {
        this.f5105g = z;
    }

    public final void a(byte[] bArr) {
        this.f5101c = bArr;
    }

    public final String b(String str) {
        Map<String, String> map = this.f5104f;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public final byte[] b() {
        return this.f5101c;
    }

    public final String c() {
        return this.f5102d;
    }

    public final ArrayList<Header> d() {
        return this.f5103e;
    }

    public final boolean e() {
        return this.f5105g;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || o.class != obj.getClass()) {
            return false;
        }
        o oVar = (o) obj;
        byte[] bArr = this.f5101c;
        if (bArr == null) {
            if (oVar.f5101c != null) {
                return false;
            }
        } else if (!bArr.equals(oVar.f5101c)) {
            return false;
        }
        String str = this.f5100b;
        String str2 = oVar.f5100b;
        if (str == null) {
            if (str2 != null) {
                return false;
            }
        } else if (!str.equals(str2)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        Map<String, String> map = this.f5104f;
        int iHashCode = ((map == null || !map.containsKey("id")) ? 1 : this.f5104f.get("id").hashCode() + 31) * 31;
        String str = this.f5100b;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        return String.format("Url : %s,HttpHeader: %s", this.f5100b, this.f5103e);
    }
}
