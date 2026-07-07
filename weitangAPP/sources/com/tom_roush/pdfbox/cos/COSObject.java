package com.tom_roush.pdfbox.cos;

import com.alipay.sdk.m.u.i;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class COSObject extends COSBase implements COSUpdateInfo {
    private COSBase baseObject;
    private int generationNumber;
    private boolean needToBeUpdated;
    private long objectNumber;

    public COSObject(COSBase cOSBase) throws IOException {
        setObject(cOSBase);
    }

    @Override // com.tom_roush.pdfbox.cos.COSBase
    public Object accept(ICOSVisitor iCOSVisitor) throws IOException {
        COSBase object = getObject();
        return object != null ? object.accept(iCOSVisitor) : COSNull.NULL.accept(iCOSVisitor);
    }

    public COSBase getDictionaryObject(COSName cOSName) {
        COSBase cOSBase = this.baseObject;
        if (cOSBase instanceof COSDictionary) {
            return ((COSDictionary) cOSBase).getDictionaryObject(cOSName);
        }
        return null;
    }

    public int getGenerationNumber() {
        return this.generationNumber;
    }

    public COSBase getItem(COSName cOSName) {
        COSBase cOSBase = this.baseObject;
        if (cOSBase instanceof COSDictionary) {
            return ((COSDictionary) cOSBase).getItem(cOSName);
        }
        return null;
    }

    public COSBase getObject() {
        return this.baseObject;
    }

    public long getObjectNumber() {
        return this.objectNumber;
    }

    @Override // com.tom_roush.pdfbox.cos.COSUpdateInfo
    public boolean isNeedToBeUpdated() {
        return this.needToBeUpdated;
    }

    public void setGenerationNumber(int i2) {
        this.generationNumber = i2;
    }

    @Override // com.tom_roush.pdfbox.cos.COSUpdateInfo
    public void setNeedToBeUpdated(boolean z) {
        this.needToBeUpdated = z;
    }

    public final void setObject(COSBase cOSBase) throws IOException {
        this.baseObject = cOSBase;
    }

    public void setObjectNumber(long j) {
        this.objectNumber = j;
    }

    public String toString() {
        return "COSObject{" + this.objectNumber + ", " + this.generationNumber + i.f5699d;
    }
}
