package com.tom_roush.pdfbox.pdfparser;

import android.util.Log;
import com.tom_roush.pdfbox.contentstream.PDContentStream;
import com.tom_roush.pdfbox.contentstream.operator.OperatorName;
import com.tom_roush.pdfbox.cos.COSStream;
import com.tom_roush.pdfbox.io.RandomAccessBuffer;
import com.tom_roush.pdfbox.pdmodel.common.PDStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class PDFStreamParser extends BaseParser {
    private static final int MAX_BIN_CHAR_TEST_LENGTH = 10;
    private final byte[] binCharTestArr;
    private final List<Object> streamObjects;

    @Deprecated
    public PDFStreamParser(PDStream pDStream) throws IOException {
        super(new InputStreamSource(pDStream.createInputStream()));
        this.streamObjects = new ArrayList(100);
        this.binCharTestArr = new byte[10];
    }

    private boolean hasNextSpaceOrReturn() throws IOException {
        return isSpaceOrReturn(this.seqSource.peek());
    }

    private boolean hasNoFollowingBinData(SequentialSource sequentialSource) throws IOException {
        int i2 = sequentialSource.read(this.binCharTestArr, 0, 10);
        boolean z = true;
        if (i2 > 0) {
            int i3 = -1;
            int i4 = -1;
            for (int i5 = 0; i5 < i2; i5++) {
                byte b2 = this.binCharTestArr[i5];
                if ((b2 != 0 && b2 < 9) || (b2 > 10 && b2 < 32 && b2 != 13)) {
                    z = false;
                    break;
                }
                if (i3 == -1 && b2 != 0 && b2 != 9 && b2 != 32 && b2 != 10 && b2 != 13) {
                    i3 = i5;
                } else if (i3 != -1 && i4 == -1 && (b2 == 0 || b2 == 9 || b2 == 32 || b2 == 10 || b2 == 13)) {
                    i4 = i5;
                }
            }
            if (i4 != -1 && i3 != -1) {
                String str = new String(this.binCharTestArr, i3, i4 - i3);
                if (!OperatorName.RESTORE.equals(str) && !OperatorName.END_MARKED_CONTENT.equals(str) && !"S".equals(str)) {
                    z = false;
                }
            }
            if (i2 == 10) {
                int i6 = (i3 == -1 || i4 != -1) ? i4 : 10;
                if (i6 != -1 && i3 != -1 && i6 - i3 > 3) {
                    z = false;
                }
            }
            sequentialSource.unread(this.binCharTestArr, 0, i2);
        }
        if (!z) {
            Log.w("PdfBox-Android", "ignoring 'EI' assumed to be in the middle of inline image at stream offset " + sequentialSource.getPosition());
        }
        return z;
    }

    private boolean isSpaceOrReturn(int i2) {
        return i2 == 10 || i2 == 13 || i2 == 32;
    }

    public List<Object> getTokens() {
        return this.streamObjects;
    }

    public void parse() throws IOException {
        while (true) {
            Object nextToken = parseNextToken();
            if (nextToken == null) {
                return;
            } else {
                this.streamObjects.add(nextToken);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:121:0x01fb, code lost:
    
        r0 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object parseNextToken() throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 588
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tom_roush.pdfbox.pdfparser.PDFStreamParser.parseNextToken():java.lang.Object");
    }

    public String readOperator() throws IOException {
        skipSpaces();
        StringBuilder sb = new StringBuilder(4);
        int iPeek = this.seqSource.peek();
        while (iPeek != -1 && !isWhitespace(iPeek) && !isClosing(iPeek) && iPeek != 91 && iPeek != 60 && iPeek != 40 && iPeek != 47 && (iPeek < 48 || iPeek > 57)) {
            char c2 = (char) this.seqSource.read();
            int iPeek2 = this.seqSource.peek();
            sb.append(c2);
            if (c2 == 'd' && (iPeek2 == 48 || iPeek2 == 49)) {
                sb.append((char) this.seqSource.read());
                iPeek = this.seqSource.peek();
            } else {
                iPeek = iPeek2;
            }
        }
        return sb.toString();
    }

    @Deprecated
    public PDFStreamParser(COSStream cOSStream) throws IOException {
        super(new InputStreamSource(cOSStream.createInputStream()));
        this.streamObjects = new ArrayList(100);
        this.binCharTestArr = new byte[10];
    }

    public PDFStreamParser(PDContentStream pDContentStream) throws IOException {
        super(new InputStreamSource(pDContentStream.getContents()));
        this.streamObjects = new ArrayList(100);
        this.binCharTestArr = new byte[10];
    }

    public PDFStreamParser(byte[] bArr) throws IOException {
        super(new RandomAccessSource(new RandomAccessBuffer(bArr)));
        this.streamObjects = new ArrayList(100);
        this.binCharTestArr = new byte[10];
    }
}
