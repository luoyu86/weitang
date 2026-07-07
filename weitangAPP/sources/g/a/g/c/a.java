package g.a.g.c;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {
    public static int bitPermuteStep(int i2, int i3, int i4) {
        int i5 = i3 & ((i2 >>> i4) ^ i2);
        return i2 ^ (i5 ^ (i5 << i4));
    }

    public static long bitPermuteStep(long j, long j2, int i2) {
        long j3 = j2 & ((j >>> i2) ^ j);
        return j ^ (j3 ^ (j3 << i2));
    }

    public static int bitPermuteStepSimple(int i2, int i3, int i4) {
        return ((i2 >>> i4) & i3) | ((i2 & i3) << i4);
    }

    public static long bitPermuteStepSimple(long j, long j2, int i2) {
        return ((j >>> i2) & j2) | ((j & j2) << i2);
    }
}
