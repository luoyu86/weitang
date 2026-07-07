package g.a.d;

/* JADX INFO: loaded from: classes2.dex */
public interface i extends e {
    @Override // g.a.d.e
    /* synthetic */ int doFinal(byte[] bArr, int i2);

    int doFinal(byte[] bArr, int i2, int i3);

    int doOutput(byte[] bArr, int i2, int i3);

    @Override // g.a.d.e
    /* synthetic */ String getAlgorithmName();

    /* synthetic */ int getByteLength();

    @Override // g.a.d.e
    /* synthetic */ int getDigestSize();

    @Override // g.a.d.e
    /* synthetic */ void reset();

    @Override // g.a.d.e
    /* synthetic */ void update(byte b2);

    @Override // g.a.d.e
    /* synthetic */ void update(byte[] bArr, int i2, int i3);
}
