package com.tom_roush.pdfbox.pdfparser;

import android.util.Log;
import androidx.recyclerview.widget.RecyclerView;
import com.tom_roush.pdfbox.contentstream.operator.OperatorName;
import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSBoolean;
import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.cos.COSDocument;
import com.tom_roush.pdfbox.cos.COSInteger;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.cos.COSNull;
import com.tom_roush.pdfbox.cos.COSNumber;
import com.tom_roush.pdfbox.cos.COSObject;
import com.tom_roush.pdfbox.cos.COSObjectKey;
import com.tom_roush.pdfbox.util.Charsets;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseParser {
    public static final int A = 97;
    public static final byte ASCII_CR = 13;
    public static final byte ASCII_LF = 10;
    private static final byte ASCII_NINE = 57;
    private static final byte ASCII_SPACE = 32;
    private static final byte ASCII_ZERO = 48;
    public static final int B = 98;
    public static final int D = 100;
    public static final String DEF = "def";
    public static final int E = 101;
    public static final String ENDOBJ_STRING = "endobj";
    public static final String ENDSTREAM_STRING = "endstream";
    private static final String FALSE = "false";
    private static final long GENERATION_NUMBER_THRESHOLD = 65535;
    public static final int J = 106;
    public static final int M = 109;
    public static final int MAX_LENGTH_LONG = Long.toString(RecyclerView.FOREVER_NS).length();
    public static final int N = 110;
    private static final String NULL = "null";
    public static final int O = 111;
    private static final long OBJECT_NUMBER_THRESHOLD = 10000000000L;
    public static final int R = 114;
    public static final int S = 115;
    public static final String STREAM_STRING = "stream";
    public static final int T = 116;
    private static final String TRUE = "true";
    public COSDocument document;
    public final SequentialSource seqSource;
    private final CharsetDecoder utf8Decoder = Charsets.UTF_8.newDecoder();

    public BaseParser(SequentialSource sequentialSource) {
        this.seqSource = sequentialSource;
    }

    private int checkForEndOfString(int i2) throws IOException {
        byte[] bArr = new byte[3];
        int i3 = this.seqSource.read(bArr);
        if (i3 == 3 && bArr[0] == 13 && ((bArr[1] == 10 && bArr[2] == 47) || bArr[2] == 62 || bArr[1] == 47 || bArr[1] == 62)) {
            i2 = 0;
        }
        if (i3 > 0) {
            this.seqSource.unread(bArr, 0, i3);
        }
        return i2;
    }

    private COSBase getObjectFromPool(COSObjectKey cOSObjectKey) throws IOException {
        COSDocument cOSDocument = this.document;
        if (cOSDocument != null) {
            return cOSDocument.getObjectFromPool(cOSObjectKey);
        }
        throw new IOException("object reference " + cOSObjectKey + " at offset " + this.seqSource.getPosition() + " in content stream");
    }

    private boolean isCR(int i2) {
        return 13 == i2;
    }

    public static boolean isDigit(int i2) {
        return i2 >= 48 && i2 <= 57;
    }

    private static boolean isHexDigit(char c2) {
        return isDigit(c2) || (c2 >= 'a' && c2 <= 'f') || (c2 >= 'A' && c2 <= 'F');
    }

    private boolean isLF(int i2) {
        return 10 == i2;
    }

    private boolean isValidUTF8(byte[] bArr) {
        try {
            this.utf8Decoder.decode(ByteBuffer.wrap(bArr));
            return true;
        } catch (CharacterCodingException unused) {
            return false;
        }
    }

    private boolean parseCOSDictionaryNameValuePair(COSDictionary cOSDictionary) throws IOException {
        COSName cOSName = parseCOSName();
        COSBase cOSDictionaryValue = parseCOSDictionaryValue();
        skipSpaces();
        if (cOSDictionaryValue == null) {
            Log.w("PdfBox-Android", "Bad dictionary declaration at offset " + this.seqSource.getPosition());
            return false;
        }
        if (!(cOSDictionaryValue instanceof COSInteger) || ((COSInteger) cOSDictionaryValue).isValid()) {
            cOSDictionaryValue.setDirect(true);
            cOSDictionary.setItem(cOSName, cOSDictionaryValue);
        } else {
            Log.w("PdfBox-Android", "Skipped out of range number value at offset " + this.seqSource.getPosition());
        }
        return true;
    }

    private COSBase parseCOSDictionaryValue() throws IOException {
        long position = this.seqSource.getPosition();
        COSBase dirObject = parseDirObject();
        skipSpaces();
        if (!(dirObject instanceof COSNumber) || !isDigit()) {
            return dirObject;
        }
        long position2 = this.seqSource.getPosition();
        COSBase dirObject2 = parseDirObject();
        skipSpaces();
        readExpectedChar('R');
        if (!(dirObject instanceof COSInteger)) {
            Log.e("PdfBox-Android", "expected number, actual=" + dirObject + " at offset " + position);
            return COSNull.NULL;
        }
        if (dirObject2 instanceof COSInteger) {
            return getObjectFromPool(new COSObjectKey(((COSInteger) dirObject).longValue(), ((COSInteger) dirObject2).intValue()));
        }
        Log.e("PdfBox-Android", "expected number, actual=" + dirObject + " at offset " + position2);
        return COSNull.NULL;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x005d, code lost:
    
        return com.tom_roush.pdfbox.cos.COSString.parseHex(r0.toString());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.tom_roush.pdfbox.cos.COSString parseCOSHexString() throws java.io.IOException {
        /*
            r5 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
        L5:
            com.tom_roush.pdfbox.pdfparser.SequentialSource r1 = r5.seqSource
            int r1 = r1.read()
            char r2 = (char) r1
            boolean r3 = isHexDigit(r2)
            if (r3 == 0) goto L16
            r0.append(r2)
            goto L5
        L16:
            r2 = 62
            if (r1 != r2) goto L1b
            goto L55
        L1b:
            java.lang.String r3 = "Missing closing bracket for hex string. Reached EOS."
            if (r1 < 0) goto L64
            r4 = 32
            if (r1 == r4) goto L5
            r4 = 10
            if (r1 == r4) goto L5
            r4 = 9
            if (r1 == r4) goto L5
            r4 = 13
            if (r1 == r4) goto L5
            r4 = 8
            if (r1 == r4) goto L5
            r4 = 12
            if (r1 != r4) goto L38
            goto L5
        L38:
            int r1 = r0.length()
            int r1 = r1 % 2
            if (r1 == 0) goto L49
            int r1 = r0.length()
            int r1 = r1 + (-1)
            r0.deleteCharAt(r1)
        L49:
            com.tom_roush.pdfbox.pdfparser.SequentialSource r1 = r5.seqSource
            int r1 = r1.read()
            if (r1 == r2) goto L53
            if (r1 >= 0) goto L49
        L53:
            if (r1 < 0) goto L5e
        L55:
            java.lang.String r0 = r0.toString()
            com.tom_roush.pdfbox.cos.COSString r0 = com.tom_roush.pdfbox.cos.COSString.parseHex(r0)
            return r0
        L5e:
            java.io.IOException r0 = new java.io.IOException
            r0.<init>(r3)
            throw r0
        L64:
            java.io.IOException r0 = new java.io.IOException
            r0.<init>(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tom_roush.pdfbox.pdfparser.BaseParser.parseCOSHexString():com.tom_roush.pdfbox.cos.COSString");
    }

    private COSNumber parseCOSNumber() throws IOException {
        StringBuilder sb = new StringBuilder();
        int i2 = this.seqSource.read();
        while (true) {
            char c2 = (char) i2;
            if (!Character.isDigit(c2) && c2 != '-' && c2 != '+' && c2 != '.' && c2 != 'E' && c2 != 'e') {
                break;
            }
            sb.append(c2);
            i2 = this.seqSource.read();
        }
        if (i2 != -1) {
            this.seqSource.unread(i2);
        }
        return COSNumber.get(sb.toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0090, code lost:
    
        if (r0 != (-1)) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0092, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0093, code lost:
    
        r6.seqSource.unread(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0098, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean readUntilEndOfCOSDictionary() throws java.io.IOException {
        /*
            r6 = this;
            com.tom_roush.pdfbox.pdfparser.SequentialSource r0 = r6.seqSource
            int r0 = r0.read()
        L6:
            r1 = -1
            r2 = 0
            r3 = 1
            if (r0 == r1) goto L90
            r4 = 47
            if (r0 == r4) goto L90
            r4 = 62
            if (r0 == r4) goto L90
            r1 = 101(0x65, float:1.42E-43)
            if (r0 != r1) goto L88
            com.tom_roush.pdfbox.pdfparser.SequentialSource r0 = r6.seqSource
            int r0 = r0.read()
            r4 = 110(0x6e, float:1.54E-43)
            if (r0 != r4) goto L88
            com.tom_roush.pdfbox.pdfparser.SequentialSource r0 = r6.seqSource
            int r0 = r0.read()
            r4 = 100
            if (r0 != r4) goto L88
            com.tom_roush.pdfbox.pdfparser.SequentialSource r0 = r6.seqSource
            int r0 = r0.read()
            r4 = 115(0x73, float:1.61E-43)
            if (r0 != r4) goto L67
            com.tom_roush.pdfbox.pdfparser.SequentialSource r4 = r6.seqSource
            int r4 = r4.read()
            r5 = 116(0x74, float:1.63E-43)
            if (r4 != r5) goto L67
            com.tom_roush.pdfbox.pdfparser.SequentialSource r4 = r6.seqSource
            int r4 = r4.read()
            r5 = 114(0x72, float:1.6E-43)
            if (r4 != r5) goto L67
            com.tom_roush.pdfbox.pdfparser.SequentialSource r4 = r6.seqSource
            int r4 = r4.read()
            if (r4 != r1) goto L67
            com.tom_roush.pdfbox.pdfparser.SequentialSource r1 = r6.seqSource
            int r1 = r1.read()
            r4 = 97
            if (r1 != r4) goto L67
            com.tom_roush.pdfbox.pdfparser.SequentialSource r1 = r6.seqSource
            int r1 = r1.read()
            r4 = 109(0x6d, float:1.53E-43)
            if (r1 != r4) goto L67
            r1 = 1
            goto L68
        L67:
            r1 = 0
        L68:
            if (r1 != 0) goto L83
            r4 = 111(0x6f, float:1.56E-43)
            if (r0 != r4) goto L83
            com.tom_roush.pdfbox.pdfparser.SequentialSource r0 = r6.seqSource
            int r0 = r0.read()
            r4 = 98
            if (r0 != r4) goto L83
            com.tom_roush.pdfbox.pdfparser.SequentialSource r0 = r6.seqSource
            int r0 = r0.read()
            r4 = 106(0x6a, float:1.49E-43)
            if (r0 != r4) goto L83
            r2 = 1
        L83:
            if (r1 != 0) goto L87
            if (r2 == 0) goto L88
        L87:
            return r3
        L88:
            com.tom_roush.pdfbox.pdfparser.SequentialSource r0 = r6.seqSource
            int r0 = r0.read()
            goto L6
        L90:
            if (r0 != r1) goto L93
            return r3
        L93:
            com.tom_roush.pdfbox.pdfparser.SequentialSource r1 = r6.seqSource
            r1.unread(r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tom_roush.pdfbox.pdfparser.BaseParser.readUntilEndOfCOSDictionary():boolean");
    }

    public boolean isClosing() throws IOException {
        return isClosing(this.seqSource.peek());
    }

    public boolean isClosing(int i2) {
        return i2 == 93;
    }

    public boolean isDigit() throws IOException {
        return isDigit(this.seqSource.peek());
    }

    public boolean isEOL() throws IOException {
        return isEOL(this.seqSource.peek());
    }

    public boolean isEndOfName(int i2) {
        return i2 == 32 || i2 == 13 || i2 == 10 || i2 == 9 || i2 == 62 || i2 == 60 || i2 == 91 || i2 == 47 || i2 == 93 || i2 == 41 || i2 == 40 || i2 == 0 || i2 == 12 || i2 == 37;
    }

    public boolean isSpace() throws IOException {
        return isSpace(this.seqSource.peek());
    }

    public boolean isSpace(int i2) {
        return 32 == i2;
    }

    public boolean isWhitespace() throws IOException {
        return isWhitespace(this.seqSource.peek());
    }

    public boolean isWhitespace(int i2) {
        return i2 == 0 || i2 == 9 || i2 == 12 || i2 == 10 || i2 == 13 || i2 == 32;
    }

    public COSBoolean parseBoolean() throws IOException {
        char cPeek = (char) this.seqSource.peek();
        if (cPeek == 't') {
            String str = new String(this.seqSource.readFully(4), Charsets.ISO_8859_1);
            if (str.equals(TRUE)) {
                return COSBoolean.TRUE;
            }
            throw new IOException("Error parsing boolean: expected='true' actual='" + str + "' at offset " + this.seqSource.getPosition());
        }
        if (cPeek != 'f') {
            throw new IOException("Error parsing boolean expected='t or f' actual='" + cPeek + "' at offset " + this.seqSource.getPosition());
        }
        String str2 = new String(this.seqSource.readFully(5), Charsets.ISO_8859_1);
        if (str2.equals(FALSE)) {
            return COSBoolean.FALSE;
        }
        throw new IOException("Error parsing boolean: expected='true' actual='" + str2 + "' at offset " + this.seqSource.getPosition());
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x00db, code lost:
    
        r9.seqSource.read();
        skipSpaces();
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00e3, code lost:
    
        return r3;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.tom_roush.pdfbox.cos.COSArray parseCOSArray() throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 228
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tom_roush.pdfbox.pdfparser.BaseParser.parseCOSArray():com.tom_roush.pdfbox.cos.COSArray");
    }

    public COSDictionary parseCOSDictionary() throws IOException {
        readExpectedChar('<');
        readExpectedChar('<');
        skipSpaces();
        COSDictionary cOSDictionary = new COSDictionary();
        boolean z = false;
        while (!z) {
            skipSpaces();
            char cPeek = (char) this.seqSource.peek();
            if (cPeek == '>') {
                z = true;
            } else if (cPeek != '/') {
                Log.w("PdfBox-Android", "Invalid dictionary, found: '" + cPeek + "' but expected: '/' at offset " + this.seqSource.getPosition());
                if (readUntilEndOfCOSDictionary()) {
                    return cOSDictionary;
                }
            } else if (!parseCOSDictionaryNameValuePair(cOSDictionary)) {
                return cOSDictionary;
            }
        }
        readExpectedChar('>');
        readExpectedChar('>');
        return cOSDictionary;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.tom_roush.pdfbox.cos.COSName parseCOSName() throws java.io.IOException {
        /*
            r8 = this;
            r0 = 47
            r8.readExpectedChar(r0)
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            com.tom_roush.pdfbox.pdfparser.SequentialSource r1 = r8.seqSource
            int r1 = r1.read()
        L10:
            r2 = -1
            if (r1 == r2) goto L9b
            r3 = 35
            if (r1 != r3) goto L89
            com.tom_roush.pdfbox.pdfparser.SequentialSource r3 = r8.seqSource
            int r3 = r3.read()
            com.tom_roush.pdfbox.pdfparser.SequentialSource r4 = r8.seqSource
            int r4 = r4.read()
            char r5 = (char) r3
            boolean r6 = isHexDigit(r5)
            if (r6 == 0) goto L71
            char r6 = (char) r4
            boolean r7 = isHexDigit(r6)
            if (r7 == 0) goto L71
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = java.lang.Character.toString(r5)
            r1.append(r2)
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            r2 = 16
            int r2 = java.lang.Integer.parseInt(r1, r2)     // Catch: java.lang.NumberFormatException -> L54
            r0.write(r2)     // Catch: java.lang.NumberFormatException -> L54
            com.tom_roush.pdfbox.pdfparser.SequentialSource r1 = r8.seqSource
            int r3 = r1.read()
            goto L7e
        L54:
            r0 = move-exception
            java.io.IOException r2 = new java.io.IOException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Error: expected hex digit, actual='"
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = "'"
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1, r0)
            throw r2
        L71:
            if (r4 == r2) goto L80
            if (r3 != r2) goto L76
            goto L80
        L76:
            com.tom_roush.pdfbox.pdfparser.SequentialSource r2 = r8.seqSource
            r2.unread(r4)
            r0.write(r1)
        L7e:
            r1 = r3
            goto L10
        L80:
            java.lang.String r1 = "PdfBox-Android"
            java.lang.String r3 = "Premature EOF in BaseParser#parseCOSName"
            android.util.Log.e(r1, r3)
            r1 = -1
            goto L9b
        L89:
            boolean r3 = r8.isEndOfName(r1)
            if (r3 == 0) goto L90
            goto L9b
        L90:
            r0.write(r1)
            com.tom_roush.pdfbox.pdfparser.SequentialSource r1 = r8.seqSource
            int r1 = r1.read()
            goto L10
        L9b:
            if (r1 == r2) goto La2
            com.tom_roush.pdfbox.pdfparser.SequentialSource r2 = r8.seqSource
            r2.unread(r1)
        La2:
            byte[] r1 = r0.toByteArray()
            boolean r1 = r8.isValidUTF8(r1)
            if (r1 == 0) goto Lb8
            java.lang.String r1 = new java.lang.String
            byte[] r0 = r0.toByteArray()
            java.nio.charset.Charset r2 = com.tom_roush.pdfbox.util.Charsets.UTF_8
            r1.<init>(r0, r2)
            goto Lc3
        Lb8:
            java.lang.String r1 = new java.lang.String
            byte[] r0 = r0.toByteArray()
            java.nio.charset.Charset r2 = com.tom_roush.pdfbox.util.Charsets.WINDOWS_1252
            r1.<init>(r0, r2)
        Lc3:
            com.tom_roush.pdfbox.cos.COSName r0 = com.tom_roush.pdfbox.cos.COSName.getPDFName(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tom_roush.pdfbox.pdfparser.BaseParser.parseCOSName():com.tom_roush.pdfbox.cos.COSName");
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0119 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0020 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.tom_roush.pdfbox.cos.COSString parseCOSString() throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 364
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tom_roush.pdfbox.pdfparser.BaseParser.parseCOSString():com.tom_roush.pdfbox.cos.COSString");
    }

    public COSBase parseDirObject() throws IOException {
        skipSpaces();
        char cPeek = (char) this.seqSource.peek();
        if (cPeek == '(') {
            return parseCOSString();
        }
        if (cPeek == '/') {
            return parseCOSName();
        }
        if (cPeek == '<') {
            int i2 = this.seqSource.read();
            char cPeek2 = (char) this.seqSource.peek();
            this.seqSource.unread(i2);
            return cPeek2 == '<' ? parseCOSDictionary() : parseCOSString();
        }
        if (cPeek == 'R') {
            this.seqSource.read();
            return new COSObject(null);
        }
        if (cPeek == '[') {
            return parseCOSArray();
        }
        if (cPeek == 'f') {
            String str = new String(this.seqSource.readFully(5), Charsets.ISO_8859_1);
            if (str.equals(FALSE)) {
                return COSBoolean.FALSE;
            }
            throw new IOException("expected false actual='" + str + "' " + this.seqSource + "' at offset " + this.seqSource.getPosition());
        }
        if (cPeek == 'n') {
            readExpectedString(NULL);
            return COSNull.NULL;
        }
        if (cPeek == 't') {
            String str2 = new String(this.seqSource.readFully(4), Charsets.ISO_8859_1);
            if (str2.equals(TRUE)) {
                return COSBoolean.TRUE;
            }
            throw new IOException("expected true actual='" + str2 + "' " + this.seqSource + "' at offset " + this.seqSource.getPosition());
        }
        if (cPeek == 65535) {
            return null;
        }
        if (Character.isDigit(cPeek) || cPeek == '-' || cPeek == '+' || cPeek == '.') {
            return parseCOSNumber();
        }
        long position = this.seqSource.getPosition();
        String string = readString();
        if (!string.isEmpty()) {
            if (ENDOBJ_STRING.equals(string) || ENDSTREAM_STRING.equals(string)) {
                this.seqSource.unread(string.getBytes(Charsets.ISO_8859_1));
            } else {
                Log.w("PdfBox-Android", "Skipped unexpected dir object = '" + string + "' at offset " + this.seqSource.getPosition() + " (start offset: " + position + ")");
            }
            return null;
        }
        int iPeek = this.seqSource.peek();
        throw new IOException("Unknown dir object c='" + cPeek + "' cInt=" + ((int) cPeek) + " peek='" + ((char) iPeek) + "' peekInt=" + iPeek + " at offset " + this.seqSource.getPosition() + " (start offset: " + position + ")");
    }

    public void readExpectedChar(char c2) throws IOException {
        char c3 = (char) this.seqSource.read();
        if (c3 == c2) {
            return;
        }
        throw new IOException("expected='" + c2 + "' actual='" + c3 + "' at offset " + this.seqSource.getPosition());
    }

    public void readExpectedString(String str) throws IOException {
        readExpectedString(str.toCharArray(), false);
    }

    public int readGenerationNumber() throws IOException {
        int i2 = readInt();
        if (i2 >= 0 && i2 <= 65535) {
            return i2;
        }
        throw new IOException("Generation Number '" + i2 + "' has more than 5 digits");
    }

    public int readInt() throws IOException {
        skipSpaces();
        StringBuilder stringNumber = readStringNumber();
        try {
            return Integer.parseInt(stringNumber.toString());
        } catch (NumberFormatException e2) {
            this.seqSource.unread(stringNumber.toString().getBytes(Charsets.ISO_8859_1));
            throw new IOException("Error: Expected an integer type at offset " + this.seqSource.getPosition() + ", instead got '" + ((Object) stringNumber) + OperatorName.SHOW_TEXT_LINE, e2);
        }
    }

    public String readLine() throws IOException {
        int i2;
        if (this.seqSource.isEOF()) {
            throw new IOException("Error: End-of-File, expected line");
        }
        StringBuilder sb = new StringBuilder(11);
        while (true) {
            i2 = this.seqSource.read();
            if (i2 == -1 || isEOL(i2)) {
                break;
            }
            sb.append((char) i2);
        }
        if (isCR(i2) && isLF(this.seqSource.peek())) {
            this.seqSource.read();
        }
        return sb.toString();
    }

    public long readLong() throws IOException {
        skipSpaces();
        StringBuilder stringNumber = readStringNumber();
        try {
            return Long.parseLong(stringNumber.toString());
        } catch (NumberFormatException e2) {
            this.seqSource.unread(stringNumber.toString().getBytes(Charsets.ISO_8859_1));
            throw new IOException("Error: Expected a long type at offset " + this.seqSource.getPosition() + ", instead got '" + ((Object) stringNumber) + OperatorName.SHOW_TEXT_LINE, e2);
        }
    }

    public long readObjectNumber() throws IOException {
        long j = readLong();
        if (j >= 0 && j < OBJECT_NUMBER_THRESHOLD) {
            return j;
        }
        throw new IOException("Object Number '" + j + "' has more than 10 digits or is negative");
    }

    public String readString() throws IOException {
        skipSpaces();
        StringBuilder sb = new StringBuilder();
        int i2 = this.seqSource.read();
        while (true) {
            char c2 = (char) i2;
            if (isEndOfName(c2) || i2 == -1) {
                break;
            }
            sb.append(c2);
            i2 = this.seqSource.read();
        }
        if (i2 != -1) {
            this.seqSource.unread(i2);
        }
        return sb.toString();
    }

    public final StringBuilder readStringNumber() throws IOException {
        StringBuilder sb = new StringBuilder();
        do {
            int i2 = this.seqSource.read();
            if (i2 < 48 || i2 > 57) {
                if (i2 != -1) {
                    this.seqSource.unread(i2);
                }
                return sb;
            }
            sb.append((char) i2);
        } while (sb.length() <= MAX_LENGTH_LONG);
        throw new IOException("Number '" + ((Object) sb) + "' is getting too long, stop reading at offset " + this.seqSource.getPosition());
    }

    public void skipSpaces() throws IOException {
        int i2 = this.seqSource.read();
        while (true) {
            if (!isWhitespace(i2) && i2 != 37) {
                break;
            }
            if (i2 == 37) {
                i2 = this.seqSource.read();
                while (!isEOL(i2) && i2 != -1) {
                    i2 = this.seqSource.read();
                }
            } else {
                i2 = this.seqSource.read();
            }
        }
        if (i2 != -1) {
            this.seqSource.unread(i2);
        }
    }

    public void skipWhiteSpaces() throws IOException {
        int i2 = this.seqSource.read();
        while (32 == i2) {
            i2 = this.seqSource.read();
        }
        if (13 != i2) {
            if (10 != i2) {
                this.seqSource.unread(i2);
            }
        } else {
            int i3 = this.seqSource.read();
            if (10 != i3) {
                this.seqSource.unread(i3);
            }
        }
    }

    public boolean isEOL(int i2) {
        return isLF(i2) || isCR(i2);
    }

    public final void readExpectedString(char[] cArr, boolean z) throws IOException {
        skipSpaces();
        for (char c2 : cArr) {
            if (this.seqSource.read() != c2) {
                throw new IOException("Expected string '" + new String(cArr) + "' but missed at character '" + c2 + "' at offset " + this.seqSource.getPosition());
            }
        }
        skipSpaces();
    }

    public String readString(int i2) throws IOException {
        skipSpaces();
        int i3 = this.seqSource.read();
        StringBuilder sb = new StringBuilder(i2);
        while (!isWhitespace(i3) && !isClosing(i3) && i3 != -1 && sb.length() < i2 && i3 != 91 && i3 != 60 && i3 != 40 && i3 != 47) {
            sb.append((char) i3);
            i3 = this.seqSource.read();
        }
        if (i3 != -1) {
            this.seqSource.unread(i3);
        }
        return sb.toString();
    }
}
