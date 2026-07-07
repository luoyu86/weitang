package anet.channel.monitor;

/* JADX INFO: loaded from: classes.dex */
public enum NetworkSpeed {
    Slow("弱网络", 1),
    Fast("强网络", 5);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f496b;

    NetworkSpeed(String str, int i2) {
        this.f495a = str;
        this.f496b = i2;
    }

    public static NetworkSpeed valueOfCode(int i2) {
        return i2 == 1 ? Slow : Fast;
    }

    public int getCode() {
        return this.f496b;
    }

    public String getDesc() {
        return this.f495a;
    }
}
