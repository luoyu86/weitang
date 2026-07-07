package cn.com.heaton.blelibrary.ble.utils;

/* JADX INFO: loaded from: classes.dex */
public class CommandTlv extends TlvArrayUnit {
    public CommandTlv(int i2, int i3) {
        super((i2 * 256) + i3);
    }

    @Override // cn.com.heaton.blelibrary.ble.utils.TlvArrayUnit, cn.com.heaton.blelibrary.ble.utils.ITLVUnit
    public byte[] getByte() {
        int totalLength = getTotalLength();
        byte[] bArr = new byte[totalLength];
        int i2 = 4;
        for (ITLVUnit iTLVUnit : this.lst) {
            byte[] bArr2 = iTLVUnit.getByte();
            int totalLength2 = iTLVUnit.getTotalLength();
            System.arraycopy(bArr2, 0, bArr, i2, totalLength2);
            i2 += totalLength2;
        }
        TlvWrap.writeTag(bArr, this.tag);
        TlvWrap.writeLength(bArr, (totalLength - 1) - 4);
        return bArr;
    }

    @Override // cn.com.heaton.blelibrary.ble.utils.TlvArrayUnit, cn.com.heaton.blelibrary.ble.utils.ITLVUnit
    public int getTotalLength() {
        return super.getTotalLength() + 1;
    }
}
