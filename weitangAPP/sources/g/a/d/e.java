package g.a.d;

/* JADX INFO: loaded from: classes2.dex */
public interface e {
    int doFinal(byte[] bArr, int i2);

    String getAlgorithmName();

    int getDigestSize();

    void reset();

    void update(byte b2);

    void update(byte[] bArr, int i2, int i3);
}
