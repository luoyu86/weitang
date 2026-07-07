package com.tom_roush.pdfbox.pdmodel.fdf;

import android.util.Log;
import com.tencent.mmkv.MMKVContentProvider;
import com.tom_roush.pdfbox.contentstream.operator.OperatorName;
import com.tom_roush.pdfbox.cos.COSArray;
import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSBoolean;
import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.cos.COSNumber;
import com.tom_roush.pdfbox.cos.COSStream;
import com.tom_roush.pdfbox.io.IOUtils;
import com.tom_roush.pdfbox.util.Hex;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* JADX INFO: loaded from: classes2.dex */
public class FDFAnnotationStamp extends FDFAnnotation {
    public static final String SUBTYPE = "Stamp";

    public FDFAnnotationStamp() {
        this.annot.setName(COSName.SUBTYPE, "Stamp");
    }

    private COSArray parseArrayElement(Element element) throws IOException {
        Log.d("PdfBox-Android", "Parse " + element.getAttribute(MMKVContentProvider.KEY) + " Array");
        COSArray cOSArray = new COSArray();
        NodeList childNodes = element.getChildNodes();
        String attribute = element.getAttribute(MMKVContentProvider.KEY);
        if ("BBox".equals(attribute) && childNodes.getLength() < 4) {
            throw new IOException("BBox does not have enough coordinates, only has: " + childNodes.getLength());
        }
        if ("Matrix".equals(attribute) && childNodes.getLength() < 6) {
            throw new IOException("Matrix does not have enough coordinates, only has: " + childNodes.getLength());
        }
        for (int i2 = 0; i2 < childNodes.getLength(); i2++) {
            Node nodeItem = childNodes.item(i2);
            if (nodeItem instanceof Element) {
                Element element2 = (Element) nodeItem;
                String attribute2 = element2.getAttribute(MMKVContentProvider.KEY);
                String attribute3 = element2.getAttribute("VAL");
                Log.d("PdfBox-Android", attribute + " => reading child: " + element2.getTagName() + " with key: " + attribute2);
                if ("INT".equalsIgnoreCase(element2.getTagName()) || "FIXED".equalsIgnoreCase(element2.getTagName())) {
                    Log.d("PdfBox-Android", attribute + " value(" + i2 + "): " + attribute3);
                    cOSArray.add((COSBase) COSNumber.get(attribute3));
                } else if ("NAME".equalsIgnoreCase(element2.getTagName())) {
                    Log.d("PdfBox-Android", attribute + " value(" + i2 + "): " + attribute3);
                    cOSArray.add((COSBase) COSName.getPDFName(attribute3));
                } else if ("BOOL".equalsIgnoreCase(element2.getTagName())) {
                    Log.d("PdfBox-Android", attribute + " value(" + i2 + "): " + attribute3);
                    cOSArray.add((COSBase) COSBoolean.getBoolean(Boolean.parseBoolean(attribute3)));
                } else if ("DICT".equalsIgnoreCase(element2.getTagName())) {
                    Log.d("PdfBox-Android", attribute + " value(" + i2 + "): " + attribute3);
                    cOSArray.add((COSBase) parseDictElement(element2));
                } else if ("STREAM".equalsIgnoreCase(element2.getTagName())) {
                    Log.d("PdfBox-Android", attribute + " value(" + i2 + "): " + attribute3);
                    cOSArray.add((COSBase) parseStreamElement(element2));
                } else if ("ARRAY".equalsIgnoreCase(element2.getTagName())) {
                    Log.d("PdfBox-Android", attribute + " value(" + i2 + "): " + attribute3);
                    cOSArray.add((COSBase) parseArrayElement(element2));
                } else {
                    Log.w("PdfBox-Android", attribute + " => Not handling child element: " + element2.getTagName());
                }
            }
        }
        return cOSArray;
    }

    private COSDictionary parseDictElement(Element element) throws IOException {
        Log.d("PdfBox-Android", "Parse " + element.getAttribute(MMKVContentProvider.KEY) + " Dictionary");
        COSDictionary cOSDictionary = new COSDictionary();
        NodeList childNodes = element.getChildNodes();
        String attribute = element.getAttribute(MMKVContentProvider.KEY);
        for (int i2 = 0; i2 < childNodes.getLength(); i2++) {
            Node nodeItem = childNodes.item(i2);
            if (nodeItem instanceof Element) {
                Element element2 = (Element) nodeItem;
                String attribute2 = element2.getAttribute(MMKVContentProvider.KEY);
                String attribute3 = element2.getAttribute("VAL");
                if ("DICT".equals(element2.getTagName())) {
                    Log.d("PdfBox-Android", attribute + " => Handling DICT element with key: " + attribute2);
                    cOSDictionary.setItem(COSName.getPDFName(attribute2), (COSBase) parseDictElement(element2));
                    Log.d("PdfBox-Android", attribute + " => Set " + attribute2);
                } else if ("STREAM".equals(element2.getTagName())) {
                    Log.d("PdfBox-Android", attribute + " => Handling STREAM element with key: " + attribute2);
                    cOSDictionary.setItem(COSName.getPDFName(attribute2), (COSBase) parseStreamElement(element2));
                } else if ("NAME".equals(element2.getTagName())) {
                    Log.d("PdfBox-Android", attribute + " => Handling NAME element with key: " + attribute2);
                    cOSDictionary.setName(COSName.getPDFName(attribute2), attribute3);
                    Log.d("PdfBox-Android", attribute + " => Set " + attribute2 + ": " + attribute3);
                } else if ("INT".equalsIgnoreCase(element2.getTagName())) {
                    cOSDictionary.setInt(COSName.getPDFName(attribute2), Integer.parseInt(attribute3));
                    Log.d("PdfBox-Android", attribute + " => Set " + attribute2 + ": " + attribute3);
                } else if ("FIXED".equalsIgnoreCase(element2.getTagName())) {
                    cOSDictionary.setFloat(COSName.getPDFName(attribute2), Float.parseFloat(attribute3));
                    Log.d("PdfBox-Android", attribute + " => Set " + attribute2 + ": " + attribute3);
                } else if ("BOOL".equalsIgnoreCase(element2.getTagName())) {
                    cOSDictionary.setBoolean(COSName.getPDFName(attribute2), Boolean.parseBoolean(attribute3));
                    Log.d("PdfBox-Android", attribute + " => Set " + attribute3);
                } else if ("ARRAY".equalsIgnoreCase(element2.getTagName())) {
                    cOSDictionary.setItem(COSName.getPDFName(attribute2), (COSBase) parseArrayElement(element2));
                    Log.d("PdfBox-Android", attribute + " => Set " + attribute2);
                } else {
                    Log.w("PdfBox-Android", attribute + " => NOT handling child element: " + element2.getTagName());
                }
            }
        }
        return cOSDictionary;
    }

    private COSDictionary parseStampAnnotationAppearanceXML(Element element) throws IOException {
        COSDictionary cOSDictionary = new COSDictionary();
        cOSDictionary.setItem(COSName.N, (COSBase) new COSStream());
        Log.d("PdfBox-Android", "Build dictionary for Appearance based on the appearanceXML");
        NodeList childNodes = element.getChildNodes();
        String attribute = element.getAttribute(MMKVContentProvider.KEY);
        Log.d("PdfBox-Android", "Appearance Root - tag: " + element.getTagName() + ", name: " + element.getNodeName() + ", key: " + attribute + ", children: " + childNodes.getLength());
        if (!"AP".equals(element.getAttribute(MMKVContentProvider.KEY))) {
            Log.w("PdfBox-Android", attribute + " => Not handling element: " + element.getTagName() + " with key: " + element.getAttribute(MMKVContentProvider.KEY));
            return cOSDictionary;
        }
        for (int i2 = 0; i2 < childNodes.getLength(); i2++) {
            Node nodeItem = childNodes.item(i2);
            if (nodeItem instanceof Element) {
                Element element2 = (Element) nodeItem;
                if ("STREAM".equalsIgnoreCase(element2.getTagName())) {
                    Log.d("PdfBox-Android", attribute + " => Process " + element2.getAttribute(MMKVContentProvider.KEY) + " item in the dictionary after processing the " + element2.getTagName());
                    cOSDictionary.setItem(element2.getAttribute(MMKVContentProvider.KEY), (COSBase) parseStreamElement(element2));
                    StringBuilder sb = new StringBuilder();
                    sb.append(attribute);
                    sb.append(" => Set ");
                    sb.append(element2.getAttribute(MMKVContentProvider.KEY));
                    Log.d("PdfBox-Android", sb.toString());
                } else {
                    Log.w("PdfBox-Android", attribute + " => Not handling element: " + element2.getTagName());
                }
            }
        }
        return cOSDictionary;
    }

    private COSStream parseStreamElement(Element element) throws IOException {
        Log.d("PdfBox-Android", "Parse " + element.getAttribute(MMKVContentProvider.KEY) + " Stream");
        COSStream cOSStream = new COSStream();
        NodeList childNodes = element.getChildNodes();
        String attribute = element.getAttribute(MMKVContentProvider.KEY);
        for (int i2 = 0; i2 < childNodes.getLength(); i2++) {
            Node nodeItem = childNodes.item(i2);
            if (nodeItem instanceof Element) {
                Element element2 = (Element) nodeItem;
                String attribute2 = element2.getAttribute(MMKVContentProvider.KEY);
                String attribute3 = element2.getAttribute("VAL");
                Log.d("PdfBox-Android", attribute + " => reading child: " + element2.getTagName() + " with key: " + attribute2);
                if ("INT".equalsIgnoreCase(element2.getTagName())) {
                    if (!"Length".equals(attribute2)) {
                        cOSStream.setInt(COSName.getPDFName(attribute2), Integer.parseInt(attribute3));
                        Log.d("PdfBox-Android", attribute + " => Set " + attribute2 + ": " + attribute3);
                    }
                } else if ("FIXED".equalsIgnoreCase(element2.getTagName())) {
                    cOSStream.setFloat(COSName.getPDFName(attribute2), Float.parseFloat(attribute3));
                    Log.d("PdfBox-Android", attribute + " => Set " + attribute2 + ": " + attribute3);
                } else if ("NAME".equalsIgnoreCase(element2.getTagName())) {
                    cOSStream.setName(COSName.getPDFName(attribute2), attribute3);
                    Log.d("PdfBox-Android", attribute + " => Set " + attribute2 + ": " + attribute3);
                } else if ("BOOL".equalsIgnoreCase(element2.getTagName())) {
                    cOSStream.setBoolean(COSName.getPDFName(attribute2), Boolean.parseBoolean(attribute3));
                    Log.d("PdfBox-Android", attribute + " => Set " + attribute3);
                } else if ("ARRAY".equalsIgnoreCase(element2.getTagName())) {
                    cOSStream.setItem(COSName.getPDFName(attribute2), (COSBase) parseArrayElement(element2));
                    Log.d("PdfBox-Android", attribute + " => Set " + attribute2);
                } else if ("DICT".equalsIgnoreCase(element2.getTagName())) {
                    cOSStream.setItem(COSName.getPDFName(attribute2), (COSBase) parseDictElement(element2));
                    Log.d("PdfBox-Android", attribute + " => Set " + attribute2);
                } else if ("STREAM".equalsIgnoreCase(element2.getTagName())) {
                    cOSStream.setItem(COSName.getPDFName(attribute2), (COSBase) parseStreamElement(element2));
                    Log.d("PdfBox-Android", attribute + " => Set " + attribute2);
                } else if ("DATA".equalsIgnoreCase(element2.getTagName())) {
                    Log.d("PdfBox-Android", attribute + " => Handling DATA with encoding: " + element2.getAttribute("ENCODING"));
                    OutputStream outputStreamCreateRawOutputStream = null;
                    if ("HEX".equals(element2.getAttribute("ENCODING"))) {
                        try {
                            outputStreamCreateRawOutputStream = cOSStream.createRawOutputStream();
                            outputStreamCreateRawOutputStream.write(Hex.decodeHex(element2.getTextContent()));
                            Log.d("PdfBox-Android", attribute + " => Data was streamed");
                        } finally {
                        }
                    } else if ("ASCII".equals(element2.getAttribute("ENCODING"))) {
                        try {
                            outputStreamCreateRawOutputStream = cOSStream.createOutputStream();
                            outputStreamCreateRawOutputStream.write(element2.getTextContent().getBytes());
                            Log.d("PdfBox-Android", attribute + " => Data was streamed");
                            IOUtils.closeQuietly(outputStreamCreateRawOutputStream);
                        } finally {
                        }
                    } else {
                        Log.w("PdfBox-Android", attribute + " => Not handling element DATA encoding: " + element2.getAttribute("ENCODING"));
                    }
                } else {
                    Log.w("PdfBox-Android", attribute + " => Not handling child element: " + element2.getTagName());
                }
            }
        }
        return cOSStream;
    }

    public FDFAnnotationStamp(COSDictionary cOSDictionary) {
        super(cOSDictionary);
    }

    public FDFAnnotationStamp(Element element) throws IOException {
        super(element);
        this.annot.setName(COSName.SUBTYPE, "Stamp");
        XPath xPathNewXPath = XPathFactory.newInstance().newXPath();
        Log.d("PdfBox-Android", "Get the DOM Document for the stamp appearance");
        try {
            String strEvaluate = xPathNewXPath.evaluate("appearance", element);
            try {
                byte[] bArrDecodeBase64 = Hex.decodeBase64(strEvaluate);
                if (strEvaluate == null || strEvaluate.isEmpty()) {
                    return;
                }
                Log.d("PdfBox-Android", "Decoded XML: " + new String(bArrDecodeBase64));
                Element documentElement = com.tom_roush.pdfbox.util.XMLUtil.parse(new ByteArrayInputStream(bArrDecodeBase64)).getDocumentElement();
                if ("dict".equalsIgnoreCase(documentElement.getNodeName())) {
                    Log.d("PdfBox-Android", "Generate and set the appearance dictionary to the stamp annotation");
                    this.annot.setItem(COSName.AP, (COSBase) parseStampAnnotationAppearanceXML(documentElement));
                } else {
                    throw new IOException("Error while reading stamp document, root should be 'dict' and not '" + documentElement.getNodeName() + OperatorName.SHOW_TEXT_LINE);
                }
            } catch (IllegalArgumentException e2) {
                Log.e("PdfBox-Android", "Bad base64 encoded appearance ignored", e2);
            }
        } catch (XPathExpressionException e3) {
            Log.e("PdfBox-Android", "Error while evaluating XPath expression for appearance: " + e3);
        }
    }
}
