package anet.channel.strategy;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class ConnHistoryItem implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte f592a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f593b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f594c = 0;

    public void a(boolean z) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - (z ? this.f593b : this.f594c) > 10000) {
            this.f592a = (byte) ((this.f592a << 1) | (!z ? 1 : 0));
            if (z) {
                this.f593b = jCurrentTimeMillis;
            } else {
                this.f594c = jCurrentTimeMillis;
            }
        }
    }

    public boolean b() {
        return (this.f592a & 1) == 1;
    }

    public boolean c() {
        return a() >= 3 && System.currentTimeMillis() - this.f594c <= 300000;
    }

    public boolean d() {
        long j = this.f593b;
        long j2 = this.f594c;
        if (j <= j2) {
            j = j2;
        }
        return j != 0 && System.currentTimeMillis() - j > 86400000;
    }

    public int a() {
        int i2 = 0;
        for (int i3 = this.f592a & 255; i3 > 0; i3 >>= 1) {
            i2 += i3 & 1;
        }
        return i2;
    }
}
