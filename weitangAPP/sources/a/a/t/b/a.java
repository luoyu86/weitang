package a.a.t.b;

/* JADX INFO: loaded from: classes.dex */
public enum a {
    Slow("弱网络", 1),
    Fast("强网络", 5);


    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f229b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f230c;

    a(String str, int i2) {
        this.f229b = str;
        this.f230c = i2;
    }

    public static a valueOfCode(int i2) {
        return i2 == 1 ? Slow : Fast;
    }

    public int getCode() {
        return this.f230c;
    }

    public String getDesc() {
        return this.f229b;
    }
}
