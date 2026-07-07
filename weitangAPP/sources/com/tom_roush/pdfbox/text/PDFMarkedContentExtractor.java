package com.tom_roush.pdfbox.text;

import com.tom_roush.pdfbox.contentstream.operator.markedcontent.BeginMarkedContentSequence;
import com.tom_roush.pdfbox.contentstream.operator.markedcontent.BeginMarkedContentSequenceWithProperties;
import com.tom_roush.pdfbox.contentstream.operator.markedcontent.DrawObject;
import com.tom_roush.pdfbox.contentstream.operator.markedcontent.EndMarkedContentSequence;
import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.pdmodel.PDPage;
import com.tom_roush.pdfbox.pdmodel.documentinterchange.markedcontent.PDMarkedContent;
import com.tom_roush.pdfbox.pdmodel.graphics.PDXObject;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class PDFMarkedContentExtractor extends LegacyPDFStreamEngine {
    private final Map<String, List<TextPosition>> characterListMapping;
    private final Deque<PDMarkedContent> currentMarkedContents;
    private final List<PDMarkedContent> markedContents;
    private boolean suppressDuplicateOverlappingText;

    public PDFMarkedContentExtractor() throws IOException {
        this(null);
    }

    private boolean within(float f2, float f3, float f4) {
        return f3 > f2 - f4 && f3 < f2 + f4;
    }

    @Override // com.tom_roush.pdfbox.contentstream.PDFStreamEngine
    public void beginMarkedContentSequence(COSName cOSName, COSDictionary cOSDictionary) {
        PDMarkedContent pDMarkedContentCreate = PDMarkedContent.create(cOSName, cOSDictionary);
        if (this.currentMarkedContents.isEmpty()) {
            this.markedContents.add(pDMarkedContentCreate);
        } else {
            PDMarkedContent pDMarkedContentPeek = this.currentMarkedContents.peek();
            if (pDMarkedContentPeek != null) {
                pDMarkedContentPeek.addMarkedContent(pDMarkedContentCreate);
            }
        }
        this.currentMarkedContents.push(pDMarkedContentCreate);
    }

    @Override // com.tom_roush.pdfbox.contentstream.PDFStreamEngine
    public void endMarkedContentSequence() {
        if (this.currentMarkedContents.isEmpty()) {
            return;
        }
        this.currentMarkedContents.pop();
    }

    public List<PDMarkedContent> getMarkedContents() {
        return this.markedContents;
    }

    public boolean isSuppressDuplicateOverlappingText() {
        return this.suppressDuplicateOverlappingText;
    }

    @Override // com.tom_roush.pdfbox.text.LegacyPDFStreamEngine, com.tom_roush.pdfbox.contentstream.PDFStreamEngine
    public /* bridge */ /* synthetic */ void processPage(PDPage pDPage) throws IOException {
        super.processPage(pDPage);
    }

    @Override // com.tom_roush.pdfbox.text.LegacyPDFStreamEngine
    public void processTextPosition(TextPosition textPosition) {
        boolean z;
        boolean z2 = false;
        if (this.suppressDuplicateOverlappingText) {
            String unicode = textPosition.getUnicode();
            float x = textPosition.getX();
            float y = textPosition.getY();
            List<TextPosition> arrayList = this.characterListMapping.get(unicode);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.characterListMapping.put(unicode, arrayList);
            }
            float width = (textPosition.getWidth() / unicode.length()) / 3.0f;
            Iterator<TextPosition> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                TextPosition next = it.next();
                String unicode2 = next.getUnicode();
                float x2 = next.getX();
                float y2 = next.getY();
                if (unicode2 != null && within(x2, x, width) && within(y2, y, width)) {
                    z = true;
                    break;
                }
            }
            if (!z) {
                arrayList.add(textPosition);
                z2 = true;
            }
        } else {
            z2 = true;
        }
        if (z2) {
            ArrayList arrayList2 = new ArrayList();
            if (arrayList2.isEmpty()) {
                arrayList2.add(textPosition);
            } else {
                TextPosition textPosition2 = (TextPosition) arrayList2.get(arrayList2.size() - 1);
                if (textPosition.isDiacritic() && textPosition2.contains(textPosition)) {
                    textPosition2.mergeDiacritic(textPosition);
                } else if (textPosition2.isDiacritic() && textPosition.contains(textPosition2)) {
                    textPosition.mergeDiacritic(textPosition2);
                    arrayList2.remove(arrayList2.size() - 1);
                    arrayList2.add(textPosition);
                } else {
                    arrayList2.add(textPosition);
                }
            }
            if (this.currentMarkedContents.isEmpty()) {
                return;
            }
            this.currentMarkedContents.peek().addText(textPosition);
        }
    }

    public void setSuppressDuplicateOverlappingText(boolean z) {
        this.suppressDuplicateOverlappingText = z;
    }

    public void xobject(PDXObject pDXObject) {
        if (this.currentMarkedContents.isEmpty()) {
            return;
        }
        this.currentMarkedContents.peek().addXObject(pDXObject);
    }

    public PDFMarkedContentExtractor(String str) throws IOException {
        this.suppressDuplicateOverlappingText = true;
        this.markedContents = new ArrayList();
        this.currentMarkedContents = new ArrayDeque();
        this.characterListMapping = new HashMap();
        addOperator(new BeginMarkedContentSequenceWithProperties());
        addOperator(new BeginMarkedContentSequence());
        addOperator(new EndMarkedContentSequence());
        addOperator(new DrawObject());
    }
}
