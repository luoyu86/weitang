package cn.com.heaton.blelibrary.ble.utils;

/* JADX INFO: loaded from: classes.dex */
public class TlvIntUnit implements ITLVUnit {
    private int length;
    private int tag;
    private int value;

    public TlvIntUnit(int i2, int i3, int i4) {
        this.tag = i2;
        this.length = i4;
        this.value = i3;
    }

    @Override // cn.com.heaton.blelibrary.ble.utils.ITLVUnit
    public byte[] getByte() {
        byte[] bArr = new byte[this.length + 4];
        TlvWrap.writeTag(bArr, this.tag);
        TlvWrap.writeLength(bArr, this.length);
        TlvWrap.writeIntValue(bArr, this.value, this.length);
        return bArr;
    }

    @Override // cn.com.heaton.blelibrary.ble.utils.ITLVUnit
    public int getTag() {
        return this.tag;
    }

    @Override // cn.com.heaton.blelibrary.ble.utils.ITLVUnit
    public int getTotalLength() {
        return this.length + 4;
    }
}
