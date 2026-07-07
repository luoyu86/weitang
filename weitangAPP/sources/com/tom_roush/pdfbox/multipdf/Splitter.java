package com.tom_roush.pdfbox.multipdf;

import android.util.Log;
import androidx.appcompat.widget.ActivityChooserView;
import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.io.MemoryUsageSetting;
import com.tom_roush.pdfbox.pdmodel.PDDocument;
import com.tom_roush.pdfbox.pdmodel.PDDocumentInformation;
import com.tom_roush.pdfbox.pdmodel.PDPage;
import com.tom_roush.pdfbox.pdmodel.interactive.action.PDAction;
import com.tom_roush.pdfbox.pdmodel.interactive.action.PDActionGoTo;
import com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDAnnotationLink;
import com.tom_roush.pdfbox.pdmodel.interactive.documentnavigation.destination.PDDestination;
import com.tom_roush.pdfbox.pdmodel.interactive.documentnavigation.destination.PDPageDestination;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class Splitter {
    private PDDocument currentDestinationDocument;
    private int currentPageNumber;
    private List<PDDocument> destinationDocuments;
    private PDDocument sourceDocument;
    private int splitLength = 1;
    private int startPage = Integer.MIN_VALUE;
    private int endPage = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private MemoryUsageSetting memoryUsageSetting = null;

    private void createNewDocumentIfNecessary() throws IOException {
        if (splitAtPage(this.currentPageNumber) || this.currentDestinationDocument == null) {
            PDDocument pDDocumentCreateNewDocument = createNewDocument();
            this.currentDestinationDocument = pDDocumentCreateNewDocument;
            this.destinationDocuments.add(pDDocumentCreateNewDocument);
        }
    }

    private void processAnnotations(PDPage pDPage) throws IOException {
        for (PDAnnotation pDAnnotation : pDPage.getAnnotations()) {
            if (pDAnnotation instanceof PDAnnotationLink) {
                PDAnnotationLink pDAnnotationLink = (PDAnnotationLink) pDAnnotation;
                PDDestination destination = pDAnnotationLink.getDestination();
                PDAction action = pDAnnotationLink.getAction();
                if (destination == null && (action instanceof PDActionGoTo)) {
                    destination = ((PDActionGoTo) action).getDestination();
                }
                if (destination instanceof PDPageDestination) {
                    ((PDPageDestination) destination).setPage(null);
                }
            }
            pDAnnotation.setPage(null);
        }
    }

    private void processPages() throws IOException {
        for (PDPage pDPage : this.sourceDocument.getPages()) {
            int i2 = this.currentPageNumber;
            if (i2 + 1 >= this.startPage && i2 + 1 <= this.endPage) {
                processPage(pDPage);
                this.currentPageNumber++;
            } else if (i2 > this.endPage) {
                return;
            } else {
                this.currentPageNumber = i2 + 1;
            }
        }
    }

    public PDDocument createNewDocument() throws IOException {
        PDDocument pDDocument = this.memoryUsageSetting == null ? new PDDocument() : new PDDocument(this.memoryUsageSetting);
        pDDocument.getDocument().setVersion(getSourceDocument().getVersion());
        PDDocumentInformation documentInformation = getSourceDocument().getDocumentInformation();
        if (documentInformation != null) {
            COSDictionary cOSObject = documentInformation.getCOSObject();
            COSDictionary cOSDictionary = new COSDictionary();
            for (COSName cOSName : cOSObject.keySet()) {
                COSBase dictionaryObject = cOSObject.getDictionaryObject(cOSName);
                if (dictionaryObject instanceof COSDictionary) {
                    Log.w("PdfBox-Android", "Nested entry for key '" + cOSName.getName() + "' skipped in document information dictionary");
                    if (this.sourceDocument.getDocumentCatalog().getCOSObject() == this.sourceDocument.getDocumentInformation().getCOSObject()) {
                        Log.w("PdfBox-Android", "/Root and /Info share the same dictionary");
                    }
                } else if (!COSName.TYPE.equals(cOSName)) {
                    cOSDictionary.setItem(cOSName, dictionaryObject);
                }
            }
            pDDocument.setDocumentInformation(new PDDocumentInformation(cOSDictionary));
        }
        pDDocument.getDocumentCatalog().setViewerPreferences(getSourceDocument().getDocumentCatalog().getViewerPreferences());
        return pDDocument;
    }

    public final PDDocument getDestinationDocument() {
        return this.currentDestinationDocument;
    }

    public MemoryUsageSetting getMemoryUsageSetting() {
        return this.memoryUsageSetting;
    }

    public final PDDocument getSourceDocument() {
        return this.sourceDocument;
    }

    public void processPage(PDPage pDPage) throws IOException {
        createNewDocumentIfNecessary();
        PDPage pDPageImportPage = getDestinationDocument().importPage(pDPage);
        if (pDPage.getResources() != null && !pDPage.getCOSObject().containsKey(COSName.RESOURCES)) {
            pDPageImportPage.setResources(pDPage.getResources());
            Log.i("PdfBox-Android", "Resources imported in Splitter");
        }
        processAnnotations(pDPageImportPage);
    }

    public void setEndPage(int i2) {
        if (i2 <= 0) {
            throw new IllegalArgumentException("End page is smaller than one");
        }
        this.endPage = i2;
    }

    public void setMemoryUsageSetting(MemoryUsageSetting memoryUsageSetting) {
        this.memoryUsageSetting = memoryUsageSetting;
    }

    public void setSplitAtPage(int i2) {
        if (i2 <= 0) {
            throw new IllegalArgumentException("Number of pages is smaller than one");
        }
        this.splitLength = i2;
    }

    public void setStartPage(int i2) {
        if (i2 <= 0) {
            throw new IllegalArgumentException("Start page is smaller than one");
        }
        this.startPage = i2;
    }

    public List<PDDocument> split(PDDocument pDDocument) throws IOException {
        this.currentPageNumber = 0;
        this.destinationDocuments = new ArrayList();
        this.sourceDocument = pDDocument;
        processPages();
        return this.destinationDocuments;
    }

    public boolean splitAtPage(int i2) {
        return ((i2 + 1) - Math.max(1, this.startPage)) % this.splitLength == 0;
    }
}
