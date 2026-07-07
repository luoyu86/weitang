package cn.com.heaton.blelibrary.ota;

/* JADX INFO: loaded from: classes.dex */
public interface OtaListener {
    void onChange(byte[] bArr);

    void onWrite();
}
