package com.tom_roush.pdfbox.pdmodel.common.filespecification;

import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.cos.COSStream;
import com.tom_roush.pdfbox.pdmodel.PDDocument;
import com.tom_roush.pdfbox.pdmodel.common.PDStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;

/* JADX INFO: loaded from: classes2.dex */
public class PDEmbeddedFile extends PDStream {
    public PDEmbeddedFile(PDDocument pDDocument) {
        super(pDDocument);
        getCOSObject().setName(COSName.TYPE, "EmbeddedFile");
    }

    public String getCheckSum() {
        return getCOSObject().getEmbeddedString("Params", "CheckSum");
    }

    public Calendar getCreationDate() throws IOException {
        return getCOSObject().getEmbeddedDate("Params", "CreationDate");
    }

    public String getMacCreator() {
        COSDictionary cOSDictionary = (COSDictionary) getCOSObject().getDictionaryObject(COSName.PARAMS);
        if (cOSDictionary != null) {
            return cOSDictionary.getEmbeddedString("Mac", "Creator");
        }
        return null;
    }

    public String getMacResFork() {
        COSDictionary cOSDictionary = (COSDictionary) getCOSObject().getDictionaryObject(COSName.PARAMS);
        if (cOSDictionary != null) {
            return cOSDictionary.getEmbeddedString("Mac", "ResFork");
        }
        return null;
    }

    public String getMacSubtype() {
        COSDictionary cOSDictionary = (COSDictionary) getCOSObject().getDictionaryObject(COSName.PARAMS);
        if (cOSDictionary != null) {
            return cOSDictionary.getEmbeddedString("Mac", "Subtype");
        }
        return null;
    }

    public Calendar getModDate() throws IOException {
        return getCOSObject().getEmbeddedDate("Params", "ModDate");
    }

    public int getSize() {
        return getCOSObject().getEmbeddedInt("Params", "Size");
    }

    public String getSubtype() {
        return getCOSObject().getNameAsString(COSName.SUBTYPE);
    }

    public void setCheckSum(String str) {
        getCOSObject().setEmbeddedString("Params", "CheckSum", str);
    }

    public void setCreationDate(Calendar calendar) {
        getCOSObject().setEmbeddedDate("Params", "CreationDate", calendar);
    }

    public void setMacCreator(String str) {
        COSStream cOSObject = getCOSObject();
        COSName cOSName = COSName.PARAMS;
        COSDictionary cOSDictionary = (COSDictionary) cOSObject.getDictionaryObject(cOSName);
        if (cOSDictionary == null && str != null) {
            cOSDictionary = new COSDictionary();
            getCOSObject().setItem(cOSName, (COSBase) cOSDictionary);
        }
        if (cOSDictionary != null) {
            cOSDictionary.setEmbeddedString("Mac", "Creator", str);
        }
    }

    public void setMacResFork(String str) {
        COSStream cOSObject = getCOSObject();
        COSName cOSName = COSName.PARAMS;
        COSDictionary cOSDictionary = (COSDictionary) cOSObject.getDictionaryObject(cOSName);
        if (cOSDictionary == null && str != null) {
            cOSDictionary = new COSDictionary();
            getCOSObject().setItem(cOSName, (COSBase) cOSDictionary);
        }
        if (cOSDictionary != null) {
            cOSDictionary.setEmbeddedString("Mac", "ResFork", str);
        }
    }

    public void setMacSubtype(String str) {
        COSStream cOSObject = getCOSObject();
        COSName cOSName = COSName.PARAMS;
        COSDictionary cOSDictionary = (COSDictionary) cOSObject.getDictionaryObject(cOSName);
        if (cOSDictionary == null && str != null) {
            cOSDictionary = new COSDictionary();
            getCOSObject().setItem(cOSName, (COSBase) cOSDictionary);
        }
        if (cOSDictionary != null) {
            cOSDictionary.setEmbeddedString("Mac", "Subtype", str);
        }
    }

    public void setModDate(Calendar calendar) {
        getCOSObject().setEmbeddedDate("Params", "ModDate", calendar);
    }

    public void setSize(int i2) {
        getCOSObject().setEmbeddedInt("Params", "Size", i2);
    }

    public void setSubtype(String str) {
        getCOSObject().setName(COSName.SUBTYPE, str);
    }

    public PDEmbeddedFile(COSStream cOSStream) {
        super(cOSStream);
    }

    public PDEmbeddedFile(PDDocument pDDocument, InputStream inputStream) throws IOException {
        super(pDDocument, inputStream);
        getCOSObject().setName(COSName.TYPE, "EmbeddedFile");
    }

    public PDEmbeddedFile(PDDocument pDDocument, InputStream inputStream, COSName cOSName) throws IOException {
        super(pDDocument, inputStream, cOSName);
        getCOSObject().setName(COSName.TYPE, "EmbeddedFile");
    }
}
