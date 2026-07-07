package cn.com.heaton.blelibrary.ble.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class TlvArrayUnit implements ITLVUnit {
    public List<ITLVUnit> lst = new ArrayList();
    public int tag;

    public TlvArrayUnit(int i2) {
        this.tag = i2;
    }

    public void addOrReplaceUnit(ITLVUnit iTLVUnit) {
        ITLVUnit next;
        Iterator<ITLVUnit> it = this.lst.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (next.getTag() != 0 && next.getTag() == iTLVUnit.getTag()) {
                break;
            }
        }
        if (next != null) {
            this.lst.remove(next);
        }
        addUnit(iTLVUnit);
    }

    public void addUnit(ITLVUnit iTLVUnit) {
        this.lst.add(iTLVUnit);
    }

    @Override // cn.com.heaton.blelibrary.ble.utils.ITLVUnit
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
        TlvWrap.writeLength(bArr, totalLength - 4);
        return bArr;
    }

    @Override // cn.com.heaton.blelibrary.ble.utils.ITLVUnit
    public int getTag() {
        return this.tag;
    }

    @Override // cn.com.heaton.blelibrary.ble.utils.ITLVUnit
    public int getTotalLength() {
        Iterator<ITLVUnit> it = this.lst.iterator();
        int totalLength = 0;
        while (it.hasNext()) {
            totalLength += it.next().getTotalLength();
        }
        return totalLength + 4;
    }
}
