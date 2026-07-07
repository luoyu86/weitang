package com.tom_roush.pdfbox.pdmodel.documentinterchange.logicalstructure;

import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.cos.COSStream;
import com.tom_roush.pdfbox.pdmodel.common.COSObjectable;
import com.tom_roush.pdfbox.pdmodel.graphics.PDXObject;
import com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDAnnotationUnknown;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class PDObjectReference implements COSObjectable {
    public static final String TYPE = "OBJR";
    private final COSDictionary dictionary;

    public PDObjectReference() {
        COSDictionary cOSDictionary = new COSDictionary();
        this.dictionary = cOSDictionary;
        cOSDictionary.setName(COSName.TYPE, TYPE);
    }

    public COSObjectable getReferencedObject() {
        PDXObject pDXObjectCreateXObject;
        COSBase dictionaryObject = getCOSObject().getDictionaryObject(COSName.OBJ);
        if (!(dictionaryObject instanceof COSDictionary)) {
            return null;
        }
        try {
            if ((dictionaryObject instanceof COSStream) && (pDXObjectCreateXObject = PDXObject.createXObject(dictionaryObject, null)) != null) {
                return pDXObjectCreateXObject;
            }
            COSDictionary cOSDictionary = (COSDictionary) dictionaryObject;
            PDAnnotation pDAnnotationCreateAnnotation = PDAnnotation.createAnnotation(dictionaryObject);
            if (pDAnnotationCreateAnnotation instanceof PDAnnotationUnknown) {
                if (COSName.ANNOT.equals(cOSDictionary.getDictionaryObject(COSName.TYPE))) {
                }
            }
            return pDAnnotationCreateAnnotation;
        } catch (IOException unused) {
        }
        return null;
    }

    public void setReferencedObject(PDAnnotation pDAnnotation) {
        getCOSObject().setItem(COSName.OBJ, pDAnnotation);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.COSObjectable
    public COSDictionary getCOSObject() {
        return this.dictionary;
    }

    public void setReferencedObject(PDXObject pDXObject) {
        getCOSObject().setItem(COSName.OBJ, pDXObject);
    }

    public PDObjectReference(COSDictionary cOSDictionary) {
        this.dictionary = cOSDictionary;
    }
}
