package com.tom_roush.pdfbox.pdmodel.encryption;

import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSBoolean;
import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.pdmodel.common.COSObjectable;

/* JADX INFO: loaded from: classes2.dex */
public class PDCryptFilterDictionary implements COSObjectable {
    public COSDictionary cryptFilterDictionary;

    public PDCryptFilterDictionary() {
        this.cryptFilterDictionary = null;
        this.cryptFilterDictionary = new COSDictionary();
    }

    @Deprecated
    public COSDictionary getCOSDictionary() {
        return this.cryptFilterDictionary;
    }

    public COSName getCryptFilterMethod() {
        return (COSName) this.cryptFilterDictionary.getDictionaryObject(COSName.CFM);
    }

    public int getLength() {
        return this.cryptFilterDictionary.getInt(COSName.LENGTH, 40);
    }

    public boolean isEncryptMetaData() {
        COSBase dictionaryObject = getCOSObject().getDictionaryObject(COSName.ENCRYPT_META_DATA);
        if (dictionaryObject instanceof COSBoolean) {
            return ((COSBoolean) dictionaryObject).getValue();
        }
        return true;
    }

    public void setCryptFilterMethod(COSName cOSName) {
        this.cryptFilterDictionary.setItem(COSName.CFM, (COSBase) cOSName);
    }

    public void setEncryptMetaData(boolean z) {
        getCOSObject().setBoolean(COSName.ENCRYPT_META_DATA, z);
    }

    public void setLength(int i2) {
        this.cryptFilterDictionary.setInt(COSName.LENGTH, i2);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.COSObjectable
    public COSDictionary getCOSObject() {
        return this.cryptFilterDictionary;
    }

    public PDCryptFilterDictionary(COSDictionary cOSDictionary) {
        this.cryptFilterDictionary = null;
        this.cryptFilterDictionary = cOSDictionary;
    }
}
