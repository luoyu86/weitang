package c.p.a.b;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class a implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f3046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f3047b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f3048c;

    public String getBluetoothCookie() {
        return this.f3047b;
    }

    public String getBluetoothMac() {
        return this.f3046a;
    }

    public String getBluetoothPassword() {
        return this.f3048c;
    }

    public void setBluetoothCookie(String str) {
        this.f3047b = str;
    }

    public void setBluetoothMac(String str) {
        this.f3046a = str;
    }

    public void setBluetoothPassword(String str) {
        this.f3048c = str;
    }
}
