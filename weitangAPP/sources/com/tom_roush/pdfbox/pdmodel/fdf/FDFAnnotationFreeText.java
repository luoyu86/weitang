package com.tom_roush.pdfbox.pdmodel.fdf;

import android.util.Log;
import com.tom_roush.fontbox.ttf.HeaderTable;
import com.tom_roush.pdfbox.cos.COSArray;
import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.pdmodel.common.PDRectangle;
import java.io.IOException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Element;

/* JADX INFO: loaded from: classes2.dex */
public class FDFAnnotationFreeText extends FDFAnnotation {
    public static final String SUBTYPE = "FreeText";

    public FDFAnnotationFreeText() {
        this.annot.setName(COSName.SUBTYPE, "FreeText");
    }

    private void initCallout(Element element) {
        String attribute = element.getAttribute("callout");
        if (attribute == null || attribute.isEmpty()) {
            return;
        }
        String[] strArrSplit = attribute.split(",");
        float[] fArr = new float[strArrSplit.length];
        for (int i2 = 0; i2 < strArrSplit.length; i2++) {
            fArr[i2] = Float.parseFloat(strArrSplit[i2]);
        }
        setCallout(fArr);
    }

    private void initFringe(Element element) throws IOException {
        String attribute = element.getAttribute("fringe");
        if (attribute == null || attribute.isEmpty()) {
            return;
        }
        String[] strArrSplit = attribute.split(",");
        if (strArrSplit.length != 4) {
            throw new IOException("Error: wrong amount of numbers in attribute 'fringe'");
        }
        PDRectangle pDRectangle = new PDRectangle();
        pDRectangle.setLowerLeftX(Float.parseFloat(strArrSplit[0]));
        pDRectangle.setLowerLeftY(Float.parseFloat(strArrSplit[1]));
        pDRectangle.setUpperRightX(Float.parseFloat(strArrSplit[2]));
        pDRectangle.setUpperRightY(Float.parseFloat(strArrSplit[3]));
        setFringe(pDRectangle);
    }

    public float[] getCallout() {
        COSArray cOSArray = (COSArray) this.annot.getDictionaryObject(COSName.CL);
        if (cOSArray != null) {
            return cOSArray.toFloatArray();
        }
        return null;
    }

    public String getDefaultAppearance() {
        return this.annot.getString(COSName.DA);
    }

    public String getDefaultStyle() {
        return this.annot.getString(COSName.DS);
    }

    public PDRectangle getFringe() {
        COSArray cOSArray = (COSArray) this.annot.getDictionaryObject(COSName.RD);
        if (cOSArray != null) {
            return new PDRectangle(cOSArray);
        }
        return null;
    }

    public String getJustification() {
        return "" + this.annot.getInt(COSName.Q, 0);
    }

    public String getLineEndingStyle() {
        return this.annot.getNameAsString(COSName.LE);
    }

    public String getRotation() {
        return this.annot.getString(COSName.ROTATE);
    }

    public void setCallout(float[] fArr) {
        COSArray cOSArray = new COSArray();
        cOSArray.setFloatArray(fArr);
        this.annot.setItem(COSName.CL, (COSBase) cOSArray);
    }

    public final void setDefaultAppearance(String str) {
        this.annot.setString(COSName.DA, str);
    }

    public final void setDefaultStyle(String str) {
        this.annot.setString(COSName.DS, str);
    }

    public final void setFringe(PDRectangle pDRectangle) {
        this.annot.setItem(COSName.RD, pDRectangle);
    }

    public final void setJustification(String str) {
        this.annot.setInt(COSName.Q, "centered".equals(str) ? 1 : "right".equals(str) ? 2 : 0);
    }

    public final void setLineEndingStyle(String str) {
        this.annot.setName(COSName.LE, str);
    }

    public final void setRotation(int i2) {
        this.annot.setInt(COSName.ROTATE, i2);
    }

    public FDFAnnotationFreeText(COSDictionary cOSDictionary) {
        super(cOSDictionary);
    }

    public FDFAnnotationFreeText(Element element) throws IOException {
        super(element);
        this.annot.setName(COSName.SUBTYPE, "FreeText");
        setJustification(element.getAttribute("justification"));
        XPath xPathNewXPath = XPathFactory.newInstance().newXPath();
        try {
            setDefaultAppearance(xPathNewXPath.evaluate("defaultappearance", element));
            setDefaultStyle(xPathNewXPath.evaluate("defaultstyle", element));
        } catch (XPathExpressionException unused) {
            Log.d("PdfBox-Android", "Error while evaluating XPath expression");
        }
        initCallout(element);
        String attribute = element.getAttribute("rotation");
        if (attribute != null && !attribute.isEmpty()) {
            setRotation(Integer.parseInt(attribute));
        }
        initFringe(element);
        String attribute2 = element.getAttribute(HeaderTable.TAG);
        if (attribute2 == null || attribute2.isEmpty()) {
            return;
        }
        setLineEndingStyle(attribute2);
    }
}
