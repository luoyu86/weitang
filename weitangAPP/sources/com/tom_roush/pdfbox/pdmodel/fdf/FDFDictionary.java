package com.tom_roush.pdfbox.pdmodel.fdf;

import android.util.Log;
import com.tom_roush.pdfbox.contentstream.operator.OperatorName;
import com.tom_roush.pdfbox.cos.COSArray;
import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.cos.COSStream;
import com.tom_roush.pdfbox.cos.COSString;
import com.tom_roush.pdfbox.pdmodel.common.COSArrayList;
import com.tom_roush.pdfbox.pdmodel.common.COSObjectable;
import com.tom_roush.pdfbox.pdmodel.common.filespecification.PDFileSpecification;
import com.tom_roush.pdfbox.pdmodel.common.filespecification.PDSimpleFileSpecification;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* JADX INFO: loaded from: classes2.dex */
public class FDFDictionary implements COSObjectable {
    private COSDictionary fdf;

    public FDFDictionary() {
        this.fdf = new COSDictionary();
    }

    public List<FDFAnnotation> getAnnotations() throws IOException {
        COSArray cOSArray = (COSArray) this.fdf.getDictionaryObject(COSName.ANNOTS);
        if (cOSArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < cOSArray.size(); i2++) {
            arrayList.add(FDFAnnotation.create((COSDictionary) cOSArray.getObject(i2)));
        }
        return new COSArrayList(arrayList, cOSArray);
    }

    public COSStream getDifferences() {
        return (COSStream) this.fdf.getDictionaryObject(COSName.DIFFERENCES);
    }

    public List<PDFileSpecification> getEmbeddedFDFs() throws IOException {
        COSArray cOSArray = (COSArray) this.fdf.getDictionaryObject(COSName.EMBEDDED_FDFS);
        if (cOSArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < cOSArray.size(); i2++) {
            arrayList.add(PDFileSpecification.createFS(cOSArray.get(i2)));
        }
        return new COSArrayList(arrayList, cOSArray);
    }

    public String getEncoding() {
        String nameAsString = this.fdf.getNameAsString(COSName.ENCODING);
        return nameAsString == null ? "PDFDocEncoding" : nameAsString;
    }

    public List<FDFField> getFields() {
        COSArray cOSArray = (COSArray) this.fdf.getDictionaryObject(COSName.FIELDS);
        if (cOSArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < cOSArray.size(); i2++) {
            arrayList.add(new FDFField((COSDictionary) cOSArray.getObject(i2)));
        }
        return new COSArrayList(arrayList, cOSArray);
    }

    public PDFileSpecification getFile() throws IOException {
        return PDFileSpecification.createFS(this.fdf.getDictionaryObject(COSName.F));
    }

    public COSArray getID() {
        return (COSArray) this.fdf.getDictionaryObject(COSName.ID);
    }

    public FDFJavaScript getJavaScript() {
        COSDictionary cOSDictionary = (COSDictionary) this.fdf.getDictionaryObject(COSName.JAVA_SCRIPT);
        if (cOSDictionary != null) {
            return new FDFJavaScript(cOSDictionary);
        }
        return null;
    }

    public List<FDFPage> getPages() {
        COSArray cOSArray = (COSArray) this.fdf.getDictionaryObject(COSName.PAGES);
        if (cOSArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < cOSArray.size(); i2++) {
            arrayList.add(new FDFPage((COSDictionary) cOSArray.get(i2)));
        }
        return new COSArrayList(arrayList, cOSArray);
    }

    public String getStatus() {
        return this.fdf.getString(COSName.STATUS);
    }

    public String getTarget() {
        return this.fdf.getString(COSName.TARGET);
    }

    public void setAnnotations(List<FDFAnnotation> list) {
        this.fdf.setItem(COSName.ANNOTS, (COSBase) COSArrayList.converterToCOSArray(list));
    }

    public void setDifferences(COSStream cOSStream) {
        this.fdf.setItem(COSName.DIFFERENCES, (COSBase) cOSStream);
    }

    public void setEmbeddedFDFs(List<PDFileSpecification> list) {
        this.fdf.setItem(COSName.EMBEDDED_FDFS, (COSBase) COSArrayList.converterToCOSArray(list));
    }

    public void setEncoding(String str) {
        this.fdf.setName(COSName.ENCODING, str);
    }

    public void setFields(List<FDFField> list) {
        this.fdf.setItem(COSName.FIELDS, (COSBase) COSArrayList.converterToCOSArray(list));
    }

    public void setFile(PDFileSpecification pDFileSpecification) {
        this.fdf.setItem(COSName.F, pDFileSpecification);
    }

    public void setID(COSArray cOSArray) {
        this.fdf.setItem(COSName.ID, (COSBase) cOSArray);
    }

    public void setJavaScript(FDFJavaScript fDFJavaScript) {
        this.fdf.setItem(COSName.JAVA_SCRIPT, fDFJavaScript);
    }

    public void setPages(List<FDFPage> list) {
        this.fdf.setItem(COSName.PAGES, (COSBase) COSArrayList.converterToCOSArray(list));
    }

    public void setStatus(String str) {
        this.fdf.setString(COSName.STATUS, str);
    }

    public void setTarget(String str) {
        this.fdf.setString(COSName.TARGET, str);
    }

    public void writeXML(Writer writer) throws IOException {
        PDFileSpecification file = getFile();
        if (file != null) {
            writer.write("<f href=\"" + file.getFile() + "\" />\n");
        }
        COSArray id = getID();
        if (id != null) {
            COSString cOSString = (COSString) id.getObject(0);
            COSString cOSString2 = (COSString) id.getObject(1);
            writer.write("<ids original=\"" + cOSString.toHexString() + "\" ");
            writer.write("modified=\"" + cOSString2.toHexString() + "\" />\n");
        }
        List<FDFField> fields = getFields();
        if (fields == null || fields.size() <= 0) {
            return;
        }
        writer.write("<fields>\n");
        Iterator<FDFField> it = fields.iterator();
        while (it.hasNext()) {
            it.next().writeXML(writer);
        }
        writer.write("</fields>\n");
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.COSObjectable
    public COSDictionary getCOSObject() {
        return this.fdf;
    }

    public FDFDictionary(COSDictionary cOSDictionary) {
        this.fdf = cOSDictionary;
    }

    public FDFDictionary(Element element) {
        this();
        NodeList childNodes = element.getChildNodes();
        for (int i2 = 0; i2 < childNodes.getLength(); i2++) {
            Node nodeItem = childNodes.item(i2);
            if (nodeItem instanceof Element) {
                Element element2 = (Element) nodeItem;
                if (element2.getTagName().equals(OperatorName.FILL_NON_ZERO)) {
                    PDSimpleFileSpecification pDSimpleFileSpecification = new PDSimpleFileSpecification();
                    pDSimpleFileSpecification.setFile(element2.getAttribute("href"));
                    setFile(pDSimpleFileSpecification);
                } else if (element2.getTagName().equals("ids")) {
                    COSArray cOSArray = new COSArray();
                    String attribute = element2.getAttribute("original");
                    String attribute2 = element2.getAttribute("modified");
                    try {
                        cOSArray.add((COSBase) COSString.parseHex(attribute));
                    } catch (IOException e2) {
                        Log.w("PdfBox-Android", "Error parsing ID entry for attribute 'original' [" + attribute + "]. ID entry ignored.", e2);
                    }
                    try {
                        cOSArray.add((COSBase) COSString.parseHex(attribute2));
                    } catch (IOException e3) {
                        Log.w("PdfBox-Android", "Error parsing ID entry for attribute 'modified' [" + attribute2 + "]. ID entry ignored.", e3);
                    }
                    setID(cOSArray);
                } else if (element2.getTagName().equals("fields")) {
                    NodeList childNodes2 = element2.getChildNodes();
                    ArrayList arrayList = new ArrayList();
                    for (int i3 = 0; i3 < childNodes2.getLength(); i3++) {
                        Node nodeItem2 = childNodes2.item(i3);
                        if ((nodeItem2 instanceof Element) && ((Element) nodeItem2).getTagName().equals("field")) {
                            try {
                                arrayList.add(new FDFField((Element) childNodes2.item(i3)));
                            } catch (IOException e4) {
                                Log.w("PdfBox-Android", "Error parsing field entry [" + nodeItem2.getNodeValue() + "]. Field ignored.", e4);
                            }
                        }
                    }
                    setFields(arrayList);
                } else if (element2.getTagName().equals("annots")) {
                    NodeList childNodes3 = element2.getChildNodes();
                    ArrayList arrayList2 = new ArrayList();
                    for (int i4 = 0; i4 < childNodes3.getLength(); i4++) {
                        Node nodeItem3 = childNodes3.item(i4);
                        if (nodeItem3 instanceof Element) {
                            Element element3 = (Element) nodeItem3;
                            String nodeName = element3.getNodeName();
                            try {
                                if (nodeName.equals("text")) {
                                    arrayList2.add(new FDFAnnotationText(element3));
                                } else if (nodeName.equals("caret")) {
                                    arrayList2.add(new FDFAnnotationCaret(element3));
                                } else if (nodeName.equals("freetext")) {
                                    arrayList2.add(new FDFAnnotationFreeText(element3));
                                } else if (nodeName.equals("fileattachment")) {
                                    arrayList2.add(new FDFAnnotationFileAttachment(element3));
                                } else if (nodeName.equals("highlight")) {
                                    arrayList2.add(new FDFAnnotationHighlight(element3));
                                } else if (nodeName.equals("ink")) {
                                    arrayList2.add(new FDFAnnotationInk(element3));
                                } else if (nodeName.equals("line")) {
                                    arrayList2.add(new FDFAnnotationLine(element3));
                                } else if (nodeName.equals("link")) {
                                    arrayList2.add(new FDFAnnotationLink(element3));
                                } else if (nodeName.equals("circle")) {
                                    arrayList2.add(new FDFAnnotationCircle(element3));
                                } else if (nodeName.equals("square")) {
                                    arrayList2.add(new FDFAnnotationSquare(element3));
                                } else if (nodeName.equals("polygon")) {
                                    arrayList2.add(new FDFAnnotationPolygon(element3));
                                } else if (nodeName.equals("polyline")) {
                                    arrayList2.add(new FDFAnnotationPolyline(element3));
                                } else if (nodeName.equals("sound")) {
                                    arrayList2.add(new FDFAnnotationSound(element3));
                                } else if (nodeName.equals("squiggly")) {
                                    arrayList2.add(new FDFAnnotationSquiggly(element3));
                                } else if (nodeName.equals("stamp")) {
                                    arrayList2.add(new FDFAnnotationStamp(element3));
                                } else if (nodeName.equals("strikeout")) {
                                    arrayList2.add(new FDFAnnotationStrikeOut(element3));
                                } else if (nodeName.equals("underline")) {
                                    arrayList2.add(new FDFAnnotationUnderline(element3));
                                } else {
                                    Log.w("PdfBox-Android", "Unknown or unsupported annotation type '" + nodeName + OperatorName.SHOW_TEXT_LINE);
                                }
                            } catch (IOException e5) {
                                Log.w("PdfBox-Android", "Error parsing annotation information [" + element3.getNodeValue() + "]. Annotation ignored", e5);
                            }
                        }
                    }
                    setAnnotations(arrayList2);
                }
            }
        }
    }
}
