package com.tom_roush.pdfbox.pdmodel.fdf;

import android.util.Log;
import com.tom_roush.pdfbox.cos.COSArray;
import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.cos.COSName;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* JADX INFO: loaded from: classes2.dex */
public class FDFAnnotationInk extends FDFAnnotation {
    public static final String SUBTYPE = "Ink";

    public FDFAnnotationInk() {
        this.annot.setName(COSName.SUBTYPE, "Ink");
    }

    public List<float[]> getInkList() {
        COSArray cOSArray = (COSArray) this.annot.getDictionaryObject(COSName.INKLIST);
        if (cOSArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<COSBase> it = cOSArray.iterator();
        while (it.hasNext()) {
            arrayList.add(((COSArray) it.next()).toFloatArray());
        }
        return arrayList;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void setInkList(List<float[]> list) {
        COSArray cOSArray = new COSArray();
        for (float[] fArr : list) {
            COSArray cOSArray2 = new COSArray();
            cOSArray2.setFloatArray(fArr);
            cOSArray.add((COSBase) cOSArray2);
        }
        this.annot.setItem(COSName.INKLIST, (COSBase) cOSArray);
    }

    public FDFAnnotationInk(COSDictionary cOSDictionary) {
        super(cOSDictionary);
    }

    public FDFAnnotationInk(Element element) throws IOException {
        super(element);
        this.annot.setName(COSName.SUBTYPE, "Ink");
        try {
            NodeList nodeList = (NodeList) XPathFactory.newInstance().newXPath().evaluate("inklist/gesture", element, XPathConstants.NODESET);
            if (nodeList.getLength() != 0) {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < nodeList.getLength(); i2++) {
                    Node nodeItem = nodeList.item(i2);
                    if (nodeItem instanceof Element) {
                        String[] strArrSplit = nodeItem.getFirstChild().getNodeValue().split(",|;");
                        float[] fArr = new float[strArrSplit.length];
                        for (int i3 = 0; i3 < strArrSplit.length; i3++) {
                            fArr[i3] = Float.parseFloat(strArrSplit[i3]);
                        }
                        arrayList.add(fArr);
                    }
                }
                setInkList(arrayList);
                return;
            }
            throw new IOException("Error: missing element 'gesture'");
        } catch (XPathExpressionException unused) {
            Log.d("PdfBox-Android", "Error while evaluating XPath expression for inklist gestures");
        }
    }
}
