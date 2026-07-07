package com.tom_roush.pdfbox.pdmodel.fixup;

import com.tom_roush.pdfbox.pdmodel.PDDocument;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractFixup implements PDDocumentFixup {
    public PDDocument document;

    public AbstractFixup(PDDocument pDDocument) {
        this.document = pDDocument;
    }
}
