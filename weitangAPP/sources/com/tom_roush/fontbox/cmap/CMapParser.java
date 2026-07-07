package com.tom_roush.fontbox.cmap;

import com.tom_roush.fontbox.util.Charsets;
import com.tom_roush.pdfbox.android.PDFBoxResourceLoader;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class CMapParser {
    private static final String MARK_END_OF_ARRAY = "]";
    private static final String MARK_END_OF_DICTIONARY = ">>";
    private boolean strictMode;
    private final byte[] tokenParserByteBuffer;

    public static final class LiteralName {
        private String name;

        private LiteralName(String str) {
            this.name = str;
        }
    }

    public static final class Operator {
        private String op;

        private Operator(String str) {
            this.op = str;
        }
    }

    public CMapParser() {
        this.tokenParserByteBuffer = new byte[512];
        this.strictMode = false;
    }

    private void addMappingFrombfrange(CMap cMap, byte[] bArr, List<byte[]> list) {
        Iterator<byte[]> it = list.iterator();
        while (it.hasNext()) {
            cMap.addCharMapping(bArr, createStringFromBytes(it.next()));
            increment(bArr, bArr.length - 1, false);
        }
    }

    private void checkExpectedOperator(Operator operator, String str, String str2) throws IOException {
        if (operator.op.equals(str)) {
            return;
        }
        throw new IOException("Error : ~" + str2 + " contains an unexpected operator : " + operator.op);
    }

    private int createIntFromBytes(byte[] bArr) {
        int i2 = bArr[0] & 255;
        return bArr.length == 2 ? (i2 << 8) + (bArr[1] & 255) : i2;
    }

    private String createStringFromBytes(byte[] bArr) {
        return new String(bArr, bArr.length == 1 ? Charsets.ISO_8859_1 : Charsets.UTF_16BE);
    }

    private boolean increment(byte[] bArr, int i2, boolean z) {
        if (i2 <= 0 || (bArr[i2] & 255) != 255) {
            bArr[i2] = (byte) (bArr[i2] + 1);
        } else {
            if (z) {
                return false;
            }
            bArr[i2] = 0;
            increment(bArr, i2 - 1, z);
        }
        return true;
    }

    private boolean isDelimiter(int i2) {
        return i2 == 37 || i2 == 47 || i2 == 60 || i2 == 62 || i2 == 91 || i2 == 93 || i2 == 123 || i2 == 125 || i2 == 40 || i2 == 41;
    }

    private boolean isWhitespaceOrEOF(int i2) {
        return i2 == -1 || i2 == 32 || i2 == 13 || i2 == 10;
    }

    private void parseBeginbfchar(Number number, PushbackInputStream pushbackInputStream, CMap cMap) throws IOException {
        for (int i2 = 0; i2 < number.intValue(); i2++) {
            Object nextToken = parseNextToken(pushbackInputStream);
            if (nextToken instanceof Operator) {
                checkExpectedOperator((Operator) nextToken, "endbfchar", "bfchar");
                return;
            }
            byte[] bArr = (byte[]) nextToken;
            Object nextToken2 = parseNextToken(pushbackInputStream);
            if (nextToken2 instanceof byte[]) {
                cMap.addCharMapping(bArr, createStringFromBytes((byte[]) nextToken2));
            } else {
                if (!(nextToken2 instanceof LiteralName)) {
                    throw new IOException("Error parsing CMap beginbfchar, expected{COSString or COSName} and not " + nextToken2);
                }
                cMap.addCharMapping(bArr, ((LiteralName) nextToken2).name);
            }
        }
    }

    private void parseBeginbfrange(Number number, PushbackInputStream pushbackInputStream, CMap cMap) throws IOException {
        for (int i2 = 0; i2 < number.intValue(); i2++) {
            Object nextToken = parseNextToken(pushbackInputStream);
            if (nextToken instanceof Operator) {
                checkExpectedOperator((Operator) nextToken, "endbfrange", "bfrange");
                return;
            }
            byte[] bArr = (byte[]) nextToken;
            byte[] bArr2 = (byte[]) parseNextToken(pushbackInputStream);
            int i3 = CMap.toInt(bArr, bArr.length);
            int i4 = CMap.toInt(bArr2, bArr2.length);
            if (i4 < i3) {
                return;
            }
            Object nextToken2 = parseNextToken(pushbackInputStream);
            if (nextToken2 instanceof List) {
                List<byte[]> list = (List) nextToken2;
                if (!list.isEmpty() && list.size() >= i4 - i3) {
                    addMappingFrombfrange(cMap, bArr, list);
                }
            } else if (nextToken2 instanceof byte[]) {
                byte[] bArr3 = (byte[]) nextToken2;
                if (bArr3.length > 0) {
                    if (bArr3.length == 2 && i3 == 0 && i4 == 65535 && bArr3[0] == 0 && bArr3[1] == 0) {
                        for (int i5 = 0; i5 < 256; i5++) {
                            byte b2 = (byte) i5;
                            bArr[0] = b2;
                            bArr[1] = 0;
                            bArr3[0] = b2;
                            bArr3[1] = 0;
                            addMappingFrombfrange(cMap, bArr, 256, bArr3);
                        }
                    } else {
                        addMappingFrombfrange(cMap, bArr, (i4 - i3) + 1, bArr3);
                    }
                }
            }
        }
    }

    private void parseBegincidchar(Number number, PushbackInputStream pushbackInputStream, CMap cMap) throws IOException {
        for (int i2 = 0; i2 < number.intValue(); i2++) {
            Object nextToken = parseNextToken(pushbackInputStream);
            if (nextToken instanceof Operator) {
                checkExpectedOperator((Operator) nextToken, "endcidchar", "cidchar");
                return;
            }
            cMap.addCIDMapping(((Integer) parseNextToken(pushbackInputStream)).intValue(), createIntFromBytes((byte[]) nextToken));
        }
    }

    private void parseBegincidrange(int i2, PushbackInputStream pushbackInputStream, CMap cMap) throws IOException {
        for (int i3 = 0; i3 < i2; i3++) {
            Object nextToken = parseNextToken(pushbackInputStream);
            if (nextToken instanceof Operator) {
                checkExpectedOperator((Operator) nextToken, "endcidrange", "cidrange");
                return;
            }
            byte[] bArr = (byte[]) nextToken;
            int iCreateIntFromBytes = createIntFromBytes(bArr);
            byte[] bArr2 = (byte[]) parseNextToken(pushbackInputStream);
            int iCreateIntFromBytes2 = createIntFromBytes(bArr2);
            int iIntValue = ((Integer) parseNextToken(pushbackInputStream)).intValue();
            if (bArr.length > 2 || bArr2.length > 2) {
                int i4 = (iCreateIntFromBytes2 + iIntValue) - iCreateIntFromBytes;
                while (iIntValue <= i4) {
                    cMap.addCIDMapping(iIntValue, createIntFromBytes(bArr));
                    increment(bArr, bArr.length - 1, false);
                    iIntValue++;
                }
            } else if (iCreateIntFromBytes2 == iCreateIntFromBytes) {
                cMap.addCIDMapping(iIntValue, iCreateIntFromBytes);
            } else {
                cMap.addCIDRange((char) iCreateIntFromBytes, (char) iCreateIntFromBytes2, iIntValue);
            }
        }
    }

    private void parseBegincodespacerange(Number number, PushbackInputStream pushbackInputStream, CMap cMap) throws IOException {
        for (int i2 = 0; i2 < number.intValue(); i2++) {
            Object nextToken = parseNextToken(pushbackInputStream);
            if (nextToken instanceof Operator) {
                checkExpectedOperator((Operator) nextToken, "endcodespacerange", "codespacerange");
                return;
            }
            try {
                cMap.addCodespaceRange(new CodespaceRange((byte[]) nextToken, (byte[]) parseNextToken(pushbackInputStream)));
            } catch (IllegalArgumentException e2) {
                throw new IOException(e2);
            }
        }
    }

    private void parseLiteralName(LiteralName literalName, PushbackInputStream pushbackInputStream, CMap cMap) throws IOException {
        if ("WMode".equals(literalName.name)) {
            Object nextToken = parseNextToken(pushbackInputStream);
            if (nextToken instanceof Integer) {
                cMap.setWMode(((Integer) nextToken).intValue());
                return;
            }
            return;
        }
        if ("CMapName".equals(literalName.name)) {
            Object nextToken2 = parseNextToken(pushbackInputStream);
            if (nextToken2 instanceof LiteralName) {
                cMap.setName(((LiteralName) nextToken2).name);
                return;
            }
            return;
        }
        if ("CMapVersion".equals(literalName.name)) {
            Object nextToken3 = parseNextToken(pushbackInputStream);
            if (nextToken3 instanceof Number) {
                cMap.setVersion(nextToken3.toString());
                return;
            } else {
                if (nextToken3 instanceof String) {
                    cMap.setVersion((String) nextToken3);
                    return;
                }
                return;
            }
        }
        if ("CMapType".equals(literalName.name)) {
            Object nextToken4 = parseNextToken(pushbackInputStream);
            if (nextToken4 instanceof Integer) {
                cMap.setType(((Integer) nextToken4).intValue());
                return;
            }
            return;
        }
        if ("Registry".equals(literalName.name)) {
            Object nextToken5 = parseNextToken(pushbackInputStream);
            if (nextToken5 instanceof String) {
                cMap.setRegistry((String) nextToken5);
                return;
            }
            return;
        }
        if ("Ordering".equals(literalName.name)) {
            Object nextToken6 = parseNextToken(pushbackInputStream);
            if (nextToken6 instanceof String) {
                cMap.setOrdering((String) nextToken6);
                return;
            }
            return;
        }
        if ("Supplement".equals(literalName.name)) {
            Object nextToken7 = parseNextToken(pushbackInputStream);
            if (nextToken7 instanceof Integer) {
                cMap.setSupplement(((Integer) nextToken7).intValue());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.Object parseNextToken(java.io.PushbackInputStream r11) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 560
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tom_roush.fontbox.cmap.CMapParser.parseNextToken(java.io.PushbackInputStream):java.lang.Object");
    }

    private void parseUsecmap(LiteralName literalName, CMap cMap) throws IOException {
        cMap.useCmap(parse(getExternalCMap(literalName.name)));
    }

    private void readUntilEndOfLine(InputStream inputStream, StringBuilder sb) throws IOException {
        int i2 = inputStream.read();
        while (i2 != -1 && i2 != 13 && i2 != 10) {
            sb.append((char) i2);
            i2 = inputStream.read();
        }
    }

    public InputStream getExternalCMap(String str) throws IOException {
        if (PDFBoxResourceLoader.isReady()) {
            return new BufferedInputStream(PDFBoxResourceLoader.getStream("com/tom_roush/fontbox/resources/cmap/" + str));
        }
        InputStream resourceAsStream = getClass().getResourceAsStream("/com/tom_roush/fontbox/resources/cmap/" + str);
        if (resourceAsStream != null) {
            return new BufferedInputStream(resourceAsStream);
        }
        throw new IOException("Error: Could not find referenced cmap stream " + str);
    }

    public CMap parse(File file) throws Throwable {
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                CMap cMap = parse(fileInputStream2);
                fileInputStream2.close();
                return cMap;
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public CMap parsePredefined(String str) throws Throwable {
        InputStream externalCMap;
        try {
            externalCMap = getExternalCMap(str);
        } catch (Throwable th) {
            th = th;
            externalCMap = null;
        }
        try {
            this.strictMode = false;
            CMap cMap = parse(externalCMap);
            if (externalCMap != null) {
                externalCMap.close();
            }
            return cMap;
        } catch (Throwable th2) {
            th = th2;
            if (externalCMap != null) {
                externalCMap.close();
            }
            throw th;
        }
    }

    public CMapParser(boolean z) {
        this.tokenParserByteBuffer = new byte[512];
        this.strictMode = false;
        this.strictMode = z;
    }

    private void addMappingFrombfrange(CMap cMap, byte[] bArr, int i2, byte[] bArr2) {
        for (int i3 = 0; i3 < i2; i3++) {
            cMap.addCharMapping(bArr, createStringFromBytes(bArr2));
            if (!increment(bArr2, bArr2.length - 1, this.strictMode)) {
                return;
            }
            increment(bArr, bArr.length - 1, false);
        }
    }

    public CMap parse(InputStream inputStream) throws IOException {
        PushbackInputStream pushbackInputStream = new PushbackInputStream(inputStream);
        CMap cMap = new CMap();
        Object obj = null;
        while (true) {
            Object nextToken = parseNextToken(pushbackInputStream);
            if (nextToken == null) {
                break;
            }
            if (nextToken instanceof Operator) {
                Operator operator = (Operator) nextToken;
                if (operator.op.equals("endcmap")) {
                    break;
                }
                if (obj != null) {
                    if (operator.op.equals("usecmap") && (obj instanceof LiteralName)) {
                        parseUsecmap((LiteralName) obj, cMap);
                    } else if (obj instanceof Number) {
                        if (!operator.op.equals("begincodespacerange")) {
                            if (!operator.op.equals("beginbfchar")) {
                                if (!operator.op.equals("beginbfrange")) {
                                    if (!operator.op.equals("begincidchar")) {
                                        if (operator.op.equals("begincidrange") && (obj instanceof Integer)) {
                                            parseBegincidrange(((Integer) obj).intValue(), pushbackInputStream, cMap);
                                        }
                                    } else {
                                        parseBegincidchar((Number) obj, pushbackInputStream, cMap);
                                    }
                                } else {
                                    parseBeginbfrange((Number) obj, pushbackInputStream, cMap);
                                }
                            } else {
                                parseBeginbfchar((Number) obj, pushbackInputStream, cMap);
                            }
                        } else {
                            parseBegincodespacerange((Number) obj, pushbackInputStream, cMap);
                        }
                    }
                }
            } else if (nextToken instanceof LiteralName) {
                parseLiteralName((LiteralName) nextToken, pushbackInputStream, cMap);
            }
            obj = nextToken;
        }
        return cMap;
    }
}
