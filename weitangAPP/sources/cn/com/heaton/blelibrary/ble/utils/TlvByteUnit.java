package cn.com.heaton.blelibrary.ble.utils;

/* JADX INFO: loaded from: classes.dex */
public class TlvByteUnit implements ITLVUnit {
    private int tag;
    private byte[] value;

    public TlvByteUnit(int i2, byte[] bArr) {
        this.tag = i2;
        this.value = bArr;
    }

    @Override // cn.com.heaton.blelibrary.ble.utils.ITLVUnit
    public byte[] getByte() {
        byte[] bArr = new byte[getTotalLength()];
        TlvWrap.writeTag(bArr, this.tag);
        TlvWrap.writeLength(bArr, this.value.length);
        TlvWrap.writeByteArrayValue(bArr, this.value);
        return bArr;
    }

    @Override // cn.com.heaton.blelibrary.ble.utils.ITLVUnit
    public int getTag() {
        return this.tag;
    }

    @Override // cn.com.heaton.blelibrary.ble.utils.ITLVUnit
    public int getTotalLength() {
        return this.value.length + 4;
    }
}
