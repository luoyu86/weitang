package com.tom_roush.pdfbox.pdmodel.font;

import com.tom_roush.fontbox.ttf.CmapLookup;
import com.tom_roush.fontbox.ttf.CmapSubtable;
import com.tom_roush.fontbox.ttf.GlyphTable;
import com.tom_roush.fontbox.ttf.HeaderTable;
import com.tom_roush.fontbox.ttf.HorizontalHeaderTable;
import com.tom_roush.fontbox.ttf.HorizontalMetricsTable;
import com.tom_roush.fontbox.ttf.IndexToLocationTable;
import com.tom_roush.fontbox.ttf.MaximumProfileTable;
import com.tom_roush.fontbox.ttf.TTFParser;
import com.tom_roush.fontbox.ttf.TTFSubsetter;
import com.tom_roush.fontbox.ttf.TrueTypeFont;
import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.cos.COSInputStream;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.io.IOUtils;
import com.tom_roush.pdfbox.pdmodel.PDDocument;
import com.tom_roush.pdfbox.pdmodel.common.PDStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public abstract class TrueTypeEmbedder implements Subsetter {
    private static final String BASE25 = "BCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int ITALIC = 1;
    private static final int OBLIQUE = 512;

    @Deprecated
    public final CmapSubtable cmap;
    public final CmapLookup cmapLookup;
    private final PDDocument document;
    private final boolean embedSubset;
    public PDFontDescriptor fontDescriptor;
    private final Set<Integer> subsetCodePoints = new HashSet();
    public TrueTypeFont ttf;

    public TrueTypeEmbedder(PDDocument pDDocument, COSDictionary cOSDictionary, TrueTypeFont trueTypeFont, boolean z) throws IOException {
        this.document = pDDocument;
        this.embedSubset = z;
        this.ttf = trueTypeFont;
        this.fontDescriptor = createFontDescriptor(trueTypeFont);
        if (!isEmbeddingPermitted(trueTypeFont)) {
            throw new IOException("This font does not permit embedding");
        }
        if (!z) {
            InputStream originalData = trueTypeFont.getOriginalData();
            byte[] bArr = new byte[4];
            originalData.mark(4);
            if (originalData.read(bArr) == 4 && new String(bArr).equals("ttcf")) {
                originalData.close();
                throw new IOException("Full embedding of TrueType font collections not supported");
            }
            if (originalData.markSupported()) {
                originalData.reset();
            } else {
                originalData.close();
                originalData = trueTypeFont.getOriginalData();
            }
            PDStream pDStream = new PDStream(pDDocument, originalData, COSName.FLATE_DECODE);
            pDStream.getCOSObject().setLong(COSName.LENGTH1, trueTypeFont.getOriginalDataSize());
            this.fontDescriptor.setFontFile2(pDStream);
        }
        cOSDictionary.setName(COSName.BASE_FONT, trueTypeFont.getName());
        this.cmap = trueTypeFont.getUnicodeCmap();
        this.cmapLookup = trueTypeFont.getUnicodeCmapLookup();
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.tom_roush.pdfbox.pdmodel.font.PDFontDescriptor createFontDescriptor(com.tom_roush.fontbox.ttf.TrueTypeFont r11) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 394
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tom_roush.pdfbox.pdmodel.font.TrueTypeEmbedder.createFontDescriptor(com.tom_roush.fontbox.ttf.TrueTypeFont):com.tom_roush.pdfbox.pdmodel.font.PDFontDescriptor");
    }

    private boolean isSubsettingPermitted(TrueTypeFont trueTypeFont) throws IOException {
        return trueTypeFont.getOS2Windows() == null || (trueTypeFont.getOS2Windows().getFsType() & 256) != 256;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.Subsetter
    public void addToSubset(int i2) {
        this.subsetCodePoints.add(Integer.valueOf(i2));
    }

    public void buildFontFile2(InputStream inputStream) throws IOException {
        COSInputStream cOSInputStreamCreateInputStream;
        PDStream pDStream = new PDStream(this.document, inputStream, COSName.FLATE_DECODE);
        try {
            cOSInputStreamCreateInputStream = pDStream.createInputStream();
        } catch (Throwable th) {
            th = th;
            cOSInputStreamCreateInputStream = null;
        }
        try {
            TrueTypeFont embedded = new TTFParser().parseEmbedded(cOSInputStreamCreateInputStream);
            this.ttf = embedded;
            if (!isEmbeddingPermitted(embedded)) {
                throw new IOException("This font does not permit embedding");
            }
            if (this.fontDescriptor == null) {
                this.fontDescriptor = createFontDescriptor(this.ttf);
            }
            IOUtils.closeQuietly(cOSInputStreamCreateInputStream);
            pDStream.getCOSObject().setLong(COSName.LENGTH1, this.ttf.getOriginalDataSize());
            this.fontDescriptor.setFontFile2(pDStream);
        } catch (Throwable th2) {
            th = th2;
            IOUtils.closeQuietly(cOSInputStreamCreateInputStream);
            throw th;
        }
    }

    public abstract void buildSubset(InputStream inputStream, String str, Map<Integer, Integer> map) throws IOException;

    public PDFontDescriptor getFontDescriptor() {
        return this.fontDescriptor;
    }

    public String getTag(Map<Integer, Integer> map) {
        long jHashCode = map.hashCode();
        StringBuilder sb = new StringBuilder();
        while (true) {
            long j = jHashCode / 25;
            sb.append(BASE25.charAt((int) (jHashCode % 25)));
            if (j == 0 || sb.length() >= 6) {
                break;
            }
            jHashCode = j;
        }
        while (sb.length() < 6) {
            sb.insert(0, 'A');
        }
        sb.append('+');
        return sb.toString();
    }

    @Deprecated
    public TrueTypeFont getTrueTypeFont() {
        return this.ttf;
    }

    public boolean isEmbeddingPermitted(TrueTypeFont trueTypeFont) throws IOException {
        if (trueTypeFont.getOS2Windows() == null) {
            return true;
        }
        short fsType = trueTypeFont.getOS2Windows().getFsType();
        return ((fsType & 15) == 2 || (fsType & 512) == 512) ? false : true;
    }

    public boolean needsSubset() {
        return this.embedSubset;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.Subsetter
    public void subset() throws IOException {
        if (!isSubsettingPermitted(this.ttf)) {
            throw new IOException("This font does not permit subsetting");
        }
        if (!this.embedSubset) {
            throw new IllegalStateException("Subsetting is disabled");
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(HeaderTable.TAG);
        arrayList.add(HorizontalHeaderTable.TAG);
        arrayList.add(IndexToLocationTable.TAG);
        arrayList.add(MaximumProfileTable.TAG);
        arrayList.add("cvt ");
        arrayList.add("prep");
        arrayList.add(GlyphTable.TAG);
        arrayList.add(HorizontalMetricsTable.TAG);
        arrayList.add("fpgm");
        arrayList.add("gasp");
        TTFSubsetter tTFSubsetter = new TTFSubsetter(this.ttf, arrayList);
        tTFSubsetter.addAll(this.subsetCodePoints);
        Map<Integer, Integer> gIDMap = tTFSubsetter.getGIDMap();
        String tag = getTag(gIDMap);
        tTFSubsetter.setPrefix(tag);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        tTFSubsetter.writeToStream(byteArrayOutputStream);
        buildSubset(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()), tag, gIDMap);
        this.ttf.close();
    }
}
