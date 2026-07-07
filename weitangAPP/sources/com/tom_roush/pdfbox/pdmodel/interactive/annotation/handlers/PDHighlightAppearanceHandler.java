package com.tom_roush.pdfbox.pdmodel.interactive.annotation.handlers;

import com.tom_roush.pdfbox.pdmodel.PDDocument;
import com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDAnnotation;

/* JADX INFO: loaded from: classes2.dex */
public class PDHighlightAppearanceHandler extends PDAbstractAppearanceHandler {
    public PDHighlightAppearanceHandler(PDAnnotation pDAnnotation) {
        super(pDAnnotation);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.interactive.annotation.handlers.PDAppearanceHandler
    public void generateAppearanceStreams() throws Throwable {
        generateNormalAppearance();
        generateRolloverAppearance();
        generateDownAppearance();
    }

    @Override // com.tom_roush.pdfbox.pdmodel.interactive.annotation.handlers.PDAppearanceHandler
    public void generateDownAppearance() {
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x018d A[Catch: all -> 0x0287, TryCatch #2 {all -> 0x0287, blocks: (B:25:0x0148, B:26:0x014b, B:28:0x0150, B:30:0x015e, B:32:0x016c, B:34:0x017a, B:36:0x0186, B:37:0x018a, B:48:0x01c5, B:50:0x01d8, B:55:0x021f, B:57:0x0236, B:62:0x0279, B:58:0x024f, B:60:0x0259, B:61:0x0272, B:51:0x01f3, B:53:0x01ff, B:54:0x0218, B:38:0x018d, B:40:0x019b, B:42:0x01a7, B:44:0x01b3, B:46:0x01bf), top: B:91:0x0148 }] */
    @Override // com.tom_roush.pdfbox.pdmodel.interactive.annotation.handlers.PDAppearanceHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void generateNormalAppearance() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 690
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tom_roush.pdfbox.pdmodel.interactive.annotation.handlers.PDHighlightAppearanceHandler.generateNormalAppearance():void");
    }

    @Override // com.tom_roush.pdfbox.pdmodel.interactive.annotation.handlers.PDAppearanceHandler
    public void generateRolloverAppearance() {
    }

    public PDHighlightAppearanceHandler(PDAnnotation pDAnnotation, PDDocument pDDocument) {
        super(pDAnnotation, pDDocument);
    }
}
