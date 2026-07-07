package com.tom_roush.pdfbox.pdmodel.fdf;

import android.util.Log;
import com.tom_roush.fontbox.ttf.HeaderTable;
import com.tom_roush.harmony.awt.AWTColor;
import com.tom_roush.pdfbox.cos.COSArray;
import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.cos.COSName;
import java.io.IOException;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Element;

/* JADX INFO: loaded from: classes2.dex */
public class FDFAnnotationPolyline extends FDFAnnotation {
    public static final String SUBTYPE = "Polyline";

    public FDFAnnotationPolyline() {
        this.annot.setName(COSName.SUBTYPE, SUBTYPE);
    }

    private void initStyles(Element element) {
        String attribute = element.getAttribute(HeaderTable.TAG);
        if (attribute != null && !attribute.isEmpty()) {
            setStartPointEndingStyle(attribute);
        }
        String attribute2 = element.getAttribute("tail");
        if (attribute2 != null && !attribute2.isEmpty()) {
            setEndPointEndingStyle(attribute2);
        }
        String attribute3 = element.getAttribute("interior-color");
        if (attribute3 != null && attribute3.length() == 7 && attribute3.charAt(0) == '#') {
            setInteriorColor(new AWTColor(Integer.parseInt(attribute3.substring(1, 7), 16)));
        }
    }

    private void initVertices(Element element) throws IOException {
        try {
            String strEvaluate = XPathFactory.newInstance().newXPath().evaluate("vertices[1]", element);
            if (strEvaluate == null || strEvaluate.isEmpty()) {
                throw new IOException("Error: missing element 'vertices'");
            }
            String[] strArrSplit = strEvaluate.split(",|;");
            float[] fArr = new float[strArrSplit.length];
            for (int i2 = 0; i2 < strArrSplit.length; i2++) {
                fArr[i2] = Float.parseFloat(strArrSplit[i2]);
            }
            setVertices(fArr);
        } catch (XPathExpressionException unused) {
            Log.d("PdfBox-Android", "Error while evaluating XPath expression for polyline vertices");
        }
    }

    public String getEndPointEndingStyle() {
        COSArray cOSArray = (COSArray) this.annot.getDictionaryObject(COSName.LE);
        return cOSArray != null ? cOSArray.getName(1) : "None";
    }

    public AWTColor getInteriorColor() {
        COSArray cOSArray = (COSArray) this.annot.getDictionaryObject(COSName.IC);
        if (cOSArray != null) {
            float[] floatArray = cOSArray.toFloatArray();
            if (floatArray.length >= 3) {
                return new AWTColor(floatArray[0], floatArray[1], floatArray[2]);
            }
        }
        return null;
    }

    public String getStartPointEndingStyle() {
        COSArray cOSArray = (COSArray) this.annot.getDictionaryObject(COSName.LE);
        return cOSArray != null ? cOSArray.getName(0) : "None";
    }

    public float[] getVertices() {
        COSArray cOSArray = (COSArray) this.annot.getDictionaryObject(COSName.VERTICES);
        if (cOSArray != null) {
            return cOSArray.toFloatArray();
        }
        return null;
    }

    public void setEndPointEndingStyle(String str) {
        if (str == null) {
            str = "None";
        }
        COSDictionary cOSDictionary = this.annot;
        COSName cOSName = COSName.LE;
        COSArray cOSArray = (COSArray) cOSDictionary.getDictionaryObject(cOSName);
        if (cOSArray != null) {
            cOSArray.setName(1, str);
            return;
        }
        COSArray cOSArray2 = new COSArray();
        cOSArray2.add((COSBase) COSName.getPDFName("None"));
        cOSArray2.add((COSBase) COSName.getPDFName(str));
        this.annot.setItem(cOSName, (COSBase) cOSArray2);
    }

    public void setInteriorColor(AWTColor aWTColor) {
        COSArray cOSArray = null;
        if (aWTColor != null) {
            float[] rGBColorComponents = aWTColor.getRGBColorComponents(null);
            cOSArray = new COSArray();
            cOSArray.setFloatArray(rGBColorComponents);
        }
        this.annot.setItem(COSName.IC, (COSBase) cOSArray);
    }

    public void setStartPointEndingStyle(String str) {
        if (str == null) {
            str = "None";
        }
        COSDictionary cOSDictionary = this.annot;
        COSName cOSName = COSName.LE;
        COSArray cOSArray = (COSArray) cOSDictionary.getDictionaryObject(cOSName);
        if (cOSArray != null) {
            cOSArray.setName(0, str);
            return;
        }
        COSArray cOSArray2 = new COSArray();
        cOSArray2.add((COSBase) COSName.getPDFName(str));
        cOSArray2.add((COSBase) COSName.getPDFName("None"));
        this.annot.setItem(cOSName, (COSBase) cOSArray2);
    }

    public void setVertices(float[] fArr) {
        COSArray cOSArray = new COSArray();
        cOSArray.setFloatArray(fArr);
        this.annot.setItem(COSName.VERTICES, (COSBase) cOSArray);
    }

    public FDFAnnotationPolyline(COSDictionary cOSDictionary) {
        super(cOSDictionary);
    }

    public FDFAnnotationPolyline(Element element) throws IOException {
        super(element);
        this.annot.setName(COSName.SUBTYPE, SUBTYPE);
        initVertices(element);
        initStyles(element);
    }
}
