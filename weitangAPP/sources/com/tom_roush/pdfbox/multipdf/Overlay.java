package com.tom_roush.pdfbox.multipdf;

import com.tom_roush.harmony.awt.geom.AffineTransform;
import com.tom_roush.pdfbox.cos.COSArray;
import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.cos.COSInputStream;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.cos.COSObject;
import com.tom_roush.pdfbox.cos.COSStream;
import com.tom_roush.pdfbox.io.IOUtils;
import com.tom_roush.pdfbox.pdmodel.PDDocument;
import com.tom_roush.pdfbox.pdmodel.PDPage;
import com.tom_roush.pdfbox.pdmodel.PDPageTree;
import com.tom_roush.pdfbox.pdmodel.PDResources;
import com.tom_roush.pdfbox.pdmodel.common.PDRectangle;
import com.tom_roush.pdfbox.pdmodel.graphics.form.PDFormXObject;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class Overlay implements Closeable {
    private LayoutPage defaultOverlayPage;
    private LayoutPage evenPageOverlayPage;
    private LayoutPage firstPageOverlayPage;
    private LayoutPage lastPageOverlayPage;
    private LayoutPage oddPageOverlayPage;
    private final Set<PDDocument> openDocuments = new HashSet();
    private Map<Integer, LayoutPage> specificPageOverlayPage = new HashMap();
    private Position position = Position.BACKGROUND;
    private String inputFileName = null;
    private PDDocument inputPDFDocument = null;
    private String defaultOverlayFilename = null;
    private PDDocument defaultOverlay = null;
    private String firstPageOverlayFilename = null;
    private PDDocument firstPageOverlay = null;
    private String lastPageOverlayFilename = null;
    private PDDocument lastPageOverlay = null;
    private String allPagesOverlayFilename = null;
    private PDDocument allPagesOverlay = null;
    private String oddPageOverlayFilename = null;
    private PDDocument oddPageOverlay = null;
    private String evenPageOverlayFilename = null;
    private PDDocument evenPageOverlay = null;
    private int numberOfOverlayPages = 0;
    private boolean useAllOverlayPages = false;

    /* JADX INFO: renamed from: com.tom_roush.pdfbox.multipdf.Overlay$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$tom_roush$pdfbox$multipdf$Overlay$Position;

        static {
            int[] iArr = new int[Position.values().length];
            $SwitchMap$com$tom_roush$pdfbox$multipdf$Overlay$Position = iArr;
            try {
                iArr[Position.FOREGROUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tom_roush$pdfbox$multipdf$Overlay$Position[Position.BACKGROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static final class LayoutPage {
        private final COSStream overlayContentStream;
        private final PDRectangle overlayMediaBox;
        private final COSDictionary overlayResources;
        private final short overlayRotation;

        public /* synthetic */ LayoutPage(PDRectangle pDRectangle, COSStream cOSStream, COSDictionary cOSDictionary, short s, AnonymousClass1 anonymousClass1) {
            this(pDRectangle, cOSStream, cOSDictionary, s);
        }

        private LayoutPage(PDRectangle pDRectangle, COSStream cOSStream, COSDictionary cOSDictionary, short s) {
            this.overlayMediaBox = pDRectangle;
            this.overlayContentStream = cOSStream;
            this.overlayResources = cOSDictionary;
            this.overlayRotation = s;
        }
    }

    public enum Position {
        FOREGROUND,
        BACKGROUND
    }

    private void addOriginalContent(COSBase cOSBase, COSArray cOSArray) throws IOException {
        if (cOSBase == null) {
            return;
        }
        if (cOSBase instanceof COSStream) {
            cOSArray.add(cOSBase);
        } else {
            if (cOSBase instanceof COSArray) {
                cOSArray.addAll((COSArray) cOSBase);
                return;
            }
            throw new IOException("Unknown content type: " + cOSBase.getClass().getName());
        }
    }

    private COSStream createCombinedContentStream(COSBase cOSBase) throws IOException {
        List<COSStream> listCreateContentStreamList = createContentStreamList(cOSBase);
        COSStream cOSStreamCreateCOSStream = this.inputPDFDocument.getDocument().createCOSStream();
        OutputStream outputStreamCreateOutputStream = cOSStreamCreateCOSStream.createOutputStream(COSName.FLATE_DECODE);
        Iterator<COSStream> it = listCreateContentStreamList.iterator();
        while (it.hasNext()) {
            COSInputStream cOSInputStreamCreateInputStream = it.next().createInputStream();
            IOUtils.copy(cOSInputStreamCreateInputStream, outputStreamCreateOutputStream);
            outputStreamCreateOutputStream.flush();
            cOSInputStreamCreateInputStream.close();
        }
        outputStreamCreateOutputStream.close();
        return cOSStreamCreateCOSStream;
    }

    private List<COSStream> createContentStreamList(COSBase cOSBase) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (cOSBase == null) {
            return arrayList;
        }
        if (cOSBase instanceof COSStream) {
            arrayList.add((COSStream) cOSBase);
        } else if (cOSBase instanceof COSArray) {
            Iterator<COSBase> it = ((COSArray) cOSBase).iterator();
            while (it.hasNext()) {
                arrayList.addAll(createContentStreamList(it.next()));
            }
        } else {
            if (!(cOSBase instanceof COSObject)) {
                throw new IOException("Unknown content type: " + cOSBase.getClass().getName());
            }
            arrayList.addAll(createContentStreamList(((COSObject) cOSBase).getObject()));
        }
        return arrayList;
    }

    private LayoutPage createLayoutPage(PDPage pDPage) throws IOException {
        COSBase dictionaryObject = pDPage.getCOSObject().getDictionaryObject(COSName.CONTENTS);
        PDResources resources = pDPage.getResources();
        if (resources == null) {
            resources = new PDResources();
        }
        return new LayoutPage(pDPage.getMediaBox(), createCombinedContentStream(dictionaryObject), resources.getCOSObject(), (short) pDPage.getRotation(), null);
    }

    private COSStream createOverlayStream(PDPage pDPage, LayoutPage layoutPage, COSName cOSName) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("q\nq\n");
        PDRectangle pDRectangle = new PDRectangle(layoutPage.overlayMediaBox.getCOSArray());
        if (layoutPage.overlayRotation == 90 || layoutPage.overlayRotation == 270) {
            pDRectangle.setLowerLeftX(layoutPage.overlayMediaBox.getLowerLeftY());
            pDRectangle.setLowerLeftY(layoutPage.overlayMediaBox.getLowerLeftX());
            pDRectangle.setUpperRightX(layoutPage.overlayMediaBox.getUpperRightY());
            pDRectangle.setUpperRightY(layoutPage.overlayMediaBox.getUpperRightX());
        }
        AffineTransform affineTransformCalculateAffineTransform = calculateAffineTransform(pDPage, pDRectangle);
        double[] dArr = new double[6];
        affineTransformCalculateAffineTransform.getMatrix(dArr);
        for (int i2 = 0; i2 < 6; i2++) {
            sb.append(float2String((float) dArr[i2]));
            sb.append(" ");
        }
        sb.append(" cm\n");
        sb.append(" /");
        sb.append(cOSName.getName());
        sb.append(" Do Q\nQ\n");
        return createStream(sb.toString());
    }

    private COSName createOverlayXObject(PDPage pDPage, LayoutPage layoutPage) {
        PDFormXObject pDFormXObject = new PDFormXObject(layoutPage.overlayContentStream);
        pDFormXObject.setResources(new PDResources(layoutPage.overlayResources));
        pDFormXObject.setFormType(1);
        pDFormXObject.setBBox(layoutPage.overlayMediaBox.createRetranslatedRectangle());
        AffineTransform affineTransform = new AffineTransform();
        short s = layoutPage.overlayRotation;
        if (s == 90) {
            affineTransform.translate(0.0d, layoutPage.overlayMediaBox.getWidth());
            affineTransform.rotate(Math.toRadians(-90.0d));
        } else if (s == 180) {
            affineTransform.translate(layoutPage.overlayMediaBox.getWidth(), layoutPage.overlayMediaBox.getHeight());
            affineTransform.rotate(Math.toRadians(-180.0d));
        } else if (s == 270) {
            affineTransform.translate(layoutPage.overlayMediaBox.getHeight(), 0.0d);
            affineTransform.rotate(Math.toRadians(-270.0d));
        }
        pDFormXObject.setMatrix(affineTransform);
        return pDPage.getResources().add(pDFormXObject, "OL");
    }

    private COSStream createStream(String str) throws IOException {
        COSStream cOSStreamCreateCOSStream = this.inputPDFDocument.getDocument().createCOSStream();
        OutputStream outputStreamCreateOutputStream = cOSStreamCreateCOSStream.createOutputStream(str.length() > 20 ? COSName.FLATE_DECODE : null);
        outputStreamCreateOutputStream.write(str.getBytes("ISO-8859-1"));
        outputStreamCreateOutputStream.close();
        return cOSStreamCreateCOSStream;
    }

    private String float2String(float f2) {
        String plainString = new BigDecimal(String.valueOf(f2)).toPlainString();
        if (plainString.indexOf(46) > -1 && !plainString.endsWith(".0")) {
            while (plainString.endsWith("0") && !plainString.endsWith(".0")) {
                plainString = plainString.substring(0, plainString.length() - 1);
            }
        }
        return plainString;
    }

    private LayoutPage getLayoutPage(PDDocument pDDocument) throws IOException {
        return createLayoutPage(pDDocument.getPage(0));
    }

    private Map<Integer, LayoutPage> getLayoutPages(PDDocument pDDocument) throws IOException {
        HashMap map = new HashMap();
        Iterator<PDPage> it = pDDocument.getPages().iterator();
        int i2 = 0;
        while (it.hasNext()) {
            map.put(Integer.valueOf(i2), createLayoutPage(it.next()));
            i2++;
        }
        return map;
    }

    private PDDocument loadPDF(String str) throws IOException {
        return PDDocument.load(new File(str));
    }

    private void loadPDFs() throws IOException {
        String str = this.inputFileName;
        if (str != null) {
            this.inputPDFDocument = loadPDF(str);
        }
        String str2 = this.defaultOverlayFilename;
        if (str2 != null) {
            this.defaultOverlay = loadPDF(str2);
        }
        PDDocument pDDocument = this.defaultOverlay;
        if (pDDocument != null) {
            this.defaultOverlayPage = getLayoutPage(pDDocument);
        }
        String str3 = this.firstPageOverlayFilename;
        if (str3 != null) {
            this.firstPageOverlay = loadPDF(str3);
        }
        PDDocument pDDocument2 = this.firstPageOverlay;
        if (pDDocument2 != null) {
            this.firstPageOverlayPage = getLayoutPage(pDDocument2);
        }
        String str4 = this.lastPageOverlayFilename;
        if (str4 != null) {
            this.lastPageOverlay = loadPDF(str4);
        }
        PDDocument pDDocument3 = this.lastPageOverlay;
        if (pDDocument3 != null) {
            this.lastPageOverlayPage = getLayoutPage(pDDocument3);
        }
        String str5 = this.oddPageOverlayFilename;
        if (str5 != null) {
            this.oddPageOverlay = loadPDF(str5);
        }
        PDDocument pDDocument4 = this.oddPageOverlay;
        if (pDDocument4 != null) {
            this.oddPageOverlayPage = getLayoutPage(pDDocument4);
        }
        String str6 = this.evenPageOverlayFilename;
        if (str6 != null) {
            this.evenPageOverlay = loadPDF(str6);
        }
        PDDocument pDDocument5 = this.evenPageOverlay;
        if (pDDocument5 != null) {
            this.evenPageOverlayPage = getLayoutPage(pDDocument5);
        }
        String str7 = this.allPagesOverlayFilename;
        if (str7 != null) {
            this.allPagesOverlay = loadPDF(str7);
        }
        PDDocument pDDocument6 = this.allPagesOverlay;
        if (pDDocument6 != null) {
            Map<Integer, LayoutPage> layoutPages = getLayoutPages(pDDocument6);
            this.specificPageOverlayPage = layoutPages;
            this.useAllOverlayPages = true;
            this.numberOfOverlayPages = layoutPages.size();
        }
    }

    private void overlayPage(PDPage pDPage, LayoutPage layoutPage, COSArray cOSArray) throws IOException {
        if (pDPage.getResources() == null) {
            pDPage.setResources(new PDResources());
        }
        cOSArray.add((COSBase) createOverlayStream(pDPage, layoutPage, createOverlayXObject(pDPage, layoutPage)));
    }

    private void processPages(PDDocument pDDocument) throws IOException {
        PDPageTree pages = pDDocument.getPages();
        int count = pages.getCount();
        int i2 = 0;
        for (PDPage pDPage : pages) {
            i2++;
            LayoutPage layoutPage = getLayoutPage(i2, count);
            if (layoutPage != null) {
                COSDictionary cOSObject = pDPage.getCOSObject();
                COSName cOSName = COSName.CONTENTS;
                COSBase dictionaryObject = cOSObject.getDictionaryObject(cOSName);
                COSArray cOSArray = new COSArray();
                int i3 = AnonymousClass1.$SwitchMap$com$tom_roush$pdfbox$multipdf$Overlay$Position[this.position.ordinal()];
                if (i3 == 1) {
                    cOSArray.add((COSBase) createStream("q\n"));
                    addOriginalContent(dictionaryObject, cOSArray);
                    cOSArray.add((COSBase) createStream("Q\n"));
                    overlayPage(pDPage, layoutPage, cOSArray);
                } else {
                    if (i3 != 2) {
                        throw new IOException("Unknown type of position:" + this.position);
                    }
                    overlayPage(pDPage, layoutPage, cOSArray);
                    addOriginalContent(dictionaryObject, cOSArray);
                }
                cOSObject.setItem(cOSName, (COSBase) cOSArray);
            }
        }
    }

    public AffineTransform calculateAffineTransform(PDPage pDPage, PDRectangle pDRectangle) {
        AffineTransform affineTransform = new AffineTransform();
        PDRectangle mediaBox = pDPage.getMediaBox();
        affineTransform.translate((mediaBox.getWidth() - pDRectangle.getWidth()) / 2.0f, (mediaBox.getHeight() - pDRectangle.getHeight()) / 2.0f);
        return affineTransform;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        PDDocument pDDocument = this.defaultOverlay;
        if (pDDocument != null) {
            pDDocument.close();
        }
        PDDocument pDDocument2 = this.firstPageOverlay;
        if (pDDocument2 != null) {
            pDDocument2.close();
        }
        PDDocument pDDocument3 = this.lastPageOverlay;
        if (pDDocument3 != null) {
            pDDocument3.close();
        }
        PDDocument pDDocument4 = this.allPagesOverlay;
        if (pDDocument4 != null) {
            pDDocument4.close();
        }
        PDDocument pDDocument5 = this.oddPageOverlay;
        if (pDDocument5 != null) {
            pDDocument5.close();
        }
        PDDocument pDDocument6 = this.evenPageOverlay;
        if (pDDocument6 != null) {
            pDDocument6.close();
        }
        Iterator<PDDocument> it = this.openDocuments.iterator();
        while (it.hasNext()) {
            it.next().close();
        }
        this.openDocuments.clear();
        this.specificPageOverlayPage.clear();
    }

    public String getDefaultOverlayFile() {
        return this.defaultOverlayFilename;
    }

    public String getInputFile() {
        return this.inputFileName;
    }

    public PDDocument overlay(Map<Integer, String> map) throws IOException {
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        loadPDFs();
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            PDDocument pDDocumentLoadPDF = (PDDocument) map2.get(entry.getValue());
            if (pDDocumentLoadPDF == null) {
                pDDocumentLoadPDF = loadPDF(entry.getValue());
                map2.put(entry.getValue(), pDDocumentLoadPDF);
                map3.put(pDDocumentLoadPDF, getLayoutPage(pDDocumentLoadPDF));
                this.openDocuments.add(pDDocumentLoadPDF);
            }
            this.specificPageOverlayPage.put(entry.getKey(), (LayoutPage) map3.get(pDDocumentLoadPDF));
        }
        processPages(this.inputPDFDocument);
        return this.inputPDFDocument;
    }

    public PDDocument overlayDocuments(Map<Integer, PDDocument> map) throws IOException {
        loadPDFs();
        for (Map.Entry<Integer, PDDocument> entry : map.entrySet()) {
            PDDocument value = entry.getValue();
            if (value != null) {
                this.specificPageOverlayPage.put(entry.getKey(), getLayoutPage(value));
            }
        }
        processPages(this.inputPDFDocument);
        return this.inputPDFDocument;
    }

    public void setAllPagesOverlayFile(String str) {
        this.allPagesOverlayFilename = str;
    }

    public void setAllPagesOverlayPDF(PDDocument pDDocument) {
        this.allPagesOverlay = pDDocument;
    }

    public void setDefaultOverlayFile(String str) {
        this.defaultOverlayFilename = str;
    }

    public void setDefaultOverlayPDF(PDDocument pDDocument) {
        this.defaultOverlay = pDDocument;
    }

    public void setEvenPageOverlayFile(String str) {
        this.evenPageOverlayFilename = str;
    }

    public void setEvenPageOverlayPDF(PDDocument pDDocument) {
        this.evenPageOverlay = pDDocument;
    }

    public void setFirstPageOverlayFile(String str) {
        this.firstPageOverlayFilename = str;
    }

    public void setFirstPageOverlayPDF(PDDocument pDDocument) {
        this.firstPageOverlay = pDDocument;
    }

    public void setInputFile(String str) {
        this.inputFileName = str;
    }

    public void setInputPDF(PDDocument pDDocument) {
        this.inputPDFDocument = pDDocument;
    }

    public void setLastPageOverlayFile(String str) {
        this.lastPageOverlayFilename = str;
    }

    public void setLastPageOverlayPDF(PDDocument pDDocument) {
        this.lastPageOverlay = pDDocument;
    }

    public void setOddPageOverlayFile(String str) {
        this.oddPageOverlayFilename = str;
    }

    public void setOddPageOverlayPDF(PDDocument pDDocument) {
        this.oddPageOverlay = pDDocument;
    }

    public void setOverlayPosition(Position position) {
        this.position = position;
    }

    private LayoutPage getLayoutPage(int i2, int i3) {
        LayoutPage layoutPage;
        LayoutPage layoutPage2;
        if (!this.useAllOverlayPages && this.specificPageOverlayPage.containsKey(Integer.valueOf(i2))) {
            return this.specificPageOverlayPage.get(Integer.valueOf(i2));
        }
        if (i2 != 1 || (layoutPage2 = this.firstPageOverlayPage) == null) {
            if (i2 != i3 || (layoutPage = this.lastPageOverlayPage) == null) {
                int i4 = i2 % 2;
                if (i4 != 1 || (layoutPage2 = this.oddPageOverlayPage) == null) {
                    if ((i4 != 0 || (layoutPage = this.evenPageOverlayPage) == null) && (layoutPage = this.defaultOverlayPage) == null) {
                        if (this.useAllOverlayPages) {
                            return this.specificPageOverlayPage.get(Integer.valueOf((i2 - 1) % this.numberOfOverlayPages));
                        }
                        return null;
                    }
                }
            }
            return layoutPage;
        }
        return layoutPage2;
    }
}
