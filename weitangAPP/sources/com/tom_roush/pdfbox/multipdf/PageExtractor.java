package com.tom_roush.pdfbox.multipdf;

import android.util.Log;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.pdmodel.PDDocument;
import com.tom_roush.pdfbox.pdmodel.PDPage;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class PageExtractor {
    private int endPage;
    private final PDDocument sourceDocument;
    private int startPage;

    public PageExtractor(PDDocument pDDocument) {
        this.startPage = 1;
        this.sourceDocument = pDDocument;
        this.endPage = pDDocument.getNumberOfPages();
    }

    public PDDocument extract() throws IOException {
        PDDocument pDDocument = new PDDocument();
        pDDocument.setDocumentInformation(this.sourceDocument.getDocumentInformation());
        pDDocument.getDocumentCatalog().setViewerPreferences(this.sourceDocument.getDocumentCatalog().getViewerPreferences());
        for (int i2 = this.startPage; i2 <= this.endPage; i2++) {
            PDPage page = this.sourceDocument.getPage(i2 - 1);
            PDPage pDPageImportPage = pDDocument.importPage(page);
            if (page.getResources() != null && !page.getCOSObject().containsKey(COSName.RESOURCES)) {
                pDPageImportPage.setResources(page.getResources());
                Log.i("PdfBox-Android", "Done in PageExtractor");
            }
        }
        return pDDocument;
    }

    public int getEndPage() {
        return this.endPage;
    }

    public int getStartPage() {
        return this.startPage;
    }

    public void setEndPage(int i2) {
        this.endPage = i2;
    }

    public void setStartPage(int i2) {
        this.startPage = i2;
    }

    public PageExtractor(PDDocument pDDocument, int i2, int i3) {
        this.startPage = 1;
        this.sourceDocument = pDDocument;
        this.startPage = i2;
        this.endPage = i3;
    }
}
