package com.tom_roush.pdfbox.pdfparser;

import android.util.Log;
import com.tom_roush.pdfbox.contentstream.operator.OperatorName;
import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.cos.COSDocument;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.io.IOUtils;
import com.tom_roush.pdfbox.io.RandomAccessBuffer;
import com.tom_roush.pdfbox.io.RandomAccessFile;
import com.tom_roush.pdfbox.pdmodel.common.PDPageLabelRange;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class FDFParser extends COSParser {
    public FDFParser(String str) throws IOException {
        this(new File(str));
    }

    private void init() {
        String property = System.getProperty(COSParser.SYSPROP_EOFLOOKUPRANGE);
        if (property != null) {
            try {
                setEOFLookupRange(Integer.parseInt(property));
            } catch (NumberFormatException unused) {
                Log.w("PdfBox-Android", "System property com.tom_roush.pdfbox.pdfparser.nonSequentialPDFParser.eofLookupRange does not contain an integer value, but: '" + property + OperatorName.SHOW_TEXT_LINE);
            }
        }
        this.document = new COSDocument();
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0024, code lost:
    
        r2 = null;
        r6 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void initialParse() throws java.lang.Throwable {
        /*
            r8 = this;
            r0 = 0
            r1 = 1
            long r2 = r8.getStartxrefOffset()     // Catch: java.io.IOException -> L1b
            r4 = 0
            r6 = 0
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 <= 0) goto L12
            com.tom_roush.pdfbox.cos.COSDictionary r2 = r8.parseXref(r2)     // Catch: java.io.IOException -> L1b
            goto L24
        L12:
            boolean r2 = r8.isLenient()     // Catch: java.io.IOException -> L1b
            if (r2 == 0) goto L19
            goto L22
        L19:
            r2 = r0
            goto L24
        L1b:
            r2 = move-exception
            boolean r3 = r8.isLenient()
            if (r3 == 0) goto L3a
        L22:
            r2 = r0
            r6 = 1
        L24:
            if (r6 == 0) goto L2a
            com.tom_roush.pdfbox.cos.COSDictionary r2 = r8.rebuildTrailer()
        L2a:
            com.tom_roush.pdfbox.cos.COSBase r2 = r8.parseTrailerValuesDynamically(r2)
            boolean r3 = r2 instanceof com.tom_roush.pdfbox.cos.COSDictionary
            if (r3 == 0) goto L37
            com.tom_roush.pdfbox.cos.COSDictionary r2 = (com.tom_roush.pdfbox.cos.COSDictionary) r2
            r8.parseDictObjects(r2, r0)
        L37:
            r8.initialParseDone = r1
            return
        L3a:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tom_roush.pdfbox.pdfparser.FDFParser.initialParse():void");
    }

    @Override // com.tom_roush.pdfbox.pdfparser.COSParser
    public final boolean isCatalog(COSDictionary cOSDictionary) {
        return cOSDictionary.containsKey(COSName.FDF);
    }

    public void parse() throws IOException {
        try {
            if (!parseFDFHeader()) {
                throw new IOException("Error: Header doesn't contain versioninfo");
            }
            initialParse();
        } catch (Throwable th) {
            COSDocument cOSDocument = this.document;
            if (cOSDocument != null) {
                IOUtils.closeQuietly(cOSDocument);
                this.document = null;
            }
            throw th;
        }
    }

    public FDFParser(File file) throws IOException {
        super(new RandomAccessFile(file, PDPageLabelRange.STYLE_ROMAN_LOWER));
        this.fileLen = file.length();
        init();
    }

    public FDFParser(InputStream inputStream) throws IOException {
        super(new RandomAccessBuffer(inputStream));
        this.fileLen = this.source.length();
        init();
    }
}
