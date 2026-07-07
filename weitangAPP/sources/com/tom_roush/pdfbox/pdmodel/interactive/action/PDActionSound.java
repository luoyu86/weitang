package com.tom_roush.pdfbox.pdmodel.interactive.action;

import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSBoolean;
import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.cos.COSNumber;
import com.tom_roush.pdfbox.cos.COSStream;

/* JADX INFO: loaded from: classes2.dex */
public class PDActionSound extends PDAction {
    public static final String SUB_TYPE = "Sound";

    public PDActionSound() {
        setSubType("Sound");
    }

    public boolean getMix() {
        COSBase dictionaryObject = this.action.getDictionaryObject(COSName.MIX);
        if (dictionaryObject instanceof COSBoolean) {
            return ((COSBoolean) dictionaryObject).getValue();
        }
        return false;
    }

    public boolean getRepeat() {
        COSBase dictionaryObject = this.action.getDictionaryObject(COSName.REPEAT);
        if (dictionaryObject instanceof COSBoolean) {
            return ((COSBoolean) dictionaryObject).getValue();
        }
        return false;
    }

    @Deprecated
    public String getS() {
        return this.action.getNameAsString(COSName.S);
    }

    public COSStream getSound() {
        COSBase dictionaryObject = this.action.getDictionaryObject(COSName.SOUND);
        if (dictionaryObject instanceof COSStream) {
            return (COSStream) dictionaryObject;
        }
        return null;
    }

    public boolean getSynchronous() {
        COSBase dictionaryObject = this.action.getDictionaryObject(COSName.SYNCHRONOUS);
        if (dictionaryObject instanceof COSBoolean) {
            return ((COSBoolean) dictionaryObject).getValue();
        }
        return false;
    }

    public float getVolume() {
        COSBase dictionaryObject = this.action.getDictionaryObject(COSName.VOLUME);
        if (!(dictionaryObject instanceof COSNumber)) {
            return 1.0f;
        }
        float fFloatValue = ((COSNumber) dictionaryObject).floatValue();
        if (fFloatValue < -1.0f || fFloatValue > 1.0f) {
            return 1.0f;
        }
        return fFloatValue;
    }

    public void setMix(boolean z) {
        this.action.setBoolean(COSName.MIX, z);
    }

    public void setRepeat(boolean z) {
        this.action.setBoolean(COSName.REPEAT, z);
    }

    @Deprecated
    public void setS(String str) {
        this.action.setName(COSName.S, str);
    }

    public void setSound(COSStream cOSStream) {
        this.action.setItem(COSName.SOUND, (COSBase) cOSStream);
    }

    public void setSynchronous(boolean z) {
        this.action.setBoolean(COSName.SYNCHRONOUS, z);
    }

    public void setVolume(float f2) {
        if (f2 < -1.0f || f2 > 1.0f) {
            throw new IllegalArgumentException("volume outside of the range −1.0 to 1.0");
        }
        this.action.setFloat(COSName.VOLUME, f2);
    }

    public PDActionSound(COSDictionary cOSDictionary) {
        super(cOSDictionary);
    }
}
