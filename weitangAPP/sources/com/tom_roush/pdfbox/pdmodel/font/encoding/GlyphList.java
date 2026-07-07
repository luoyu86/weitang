package com.tom_roush.pdfbox.pdmodel.font.encoding;

import android.util.Log;
import com.alipay.sdk.m.u.i;
import com.tom_roush.pdfbox.android.PDFBoxResourceLoader;
import com.tom_roush.pdfbox.io.IOUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class GlyphList {
    private static final GlyphList DEFAULT = load("glyphlist.txt", 4281);
    private static final GlyphList ZAPF_DINGBATS = load("zapfdingbats.txt", 201);
    private final Map<String, String> nameToUnicode;
    private final Map<String, String> uniNameToUnicodeCache = new ConcurrentHashMap();
    private final Map<String, String> unicodeToName;

    static {
        try {
            if (System.getProperty("glyphlist_ext") == null) {
            } else {
                throw new UnsupportedOperationException("glyphlist_ext is no longer supported, use GlyphList.DEFAULT.addGlyphs(Properties) instead");
            }
        } catch (SecurityException unused) {
        }
    }

    public GlyphList(InputStream inputStream, int i2) throws IOException {
        this.nameToUnicode = new HashMap(i2);
        this.unicodeToName = new HashMap(i2);
        loadList(inputStream);
    }

    public static GlyphList getAdobeGlyphList() {
        return DEFAULT;
    }

    public static GlyphList getZapfDingbats() {
        return ZAPF_DINGBATS;
    }

    private static GlyphList load(String str, int i2) {
        InputStream resourceAsStream;
        String str2 = "com/tom_roush/pdfbox/resources/glyphlist/" + str;
        try {
            try {
                if (PDFBoxResourceLoader.isReady()) {
                    resourceAsStream = PDFBoxResourceLoader.getStream(str2);
                } else {
                    resourceAsStream = GlyphList.class.getResourceAsStream("/" + str2);
                }
                if (resourceAsStream != null) {
                    GlyphList glyphList = new GlyphList(resourceAsStream, i2);
                    IOUtils.closeQuietly(resourceAsStream);
                    return glyphList;
                }
                throw new IOException("GlyphList '" + str2 + "' not found");
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        } catch (Throwable th) {
            IOUtils.closeQuietly(null);
            throw th;
        }
    }

    private void loadList(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "ISO-8859-1"));
        while (bufferedReader.ready()) {
            try {
                String line = bufferedReader.readLine();
                if (line != null && !line.startsWith("#")) {
                    String[] strArrSplit = line.split(i.f5697b);
                    if (strArrSplit.length < 2) {
                        throw new IOException("Invalid glyph list entry: " + line);
                    }
                    String str = strArrSplit[0];
                    String[] strArrSplit2 = strArrSplit[1].split(" ");
                    if (this.nameToUnicode.containsKey(str)) {
                        Log.w("PdfBox-Android", "duplicate value for " + str + " -> " + strArrSplit[1] + " " + this.nameToUnicode.get(str));
                    }
                    int length = strArrSplit2.length;
                    int[] iArr = new int[length];
                    int length2 = strArrSplit2.length;
                    int i2 = 0;
                    int i3 = 0;
                    while (i2 < length2) {
                        iArr[i3] = Integer.parseInt(strArrSplit2[i2], 16);
                        i2++;
                        i3++;
                    }
                    String str2 = new String(iArr, 0, length);
                    this.nameToUnicode.put(str, str2);
                    boolean z = WinAnsiEncoding.INSTANCE.contains(str) || MacRomanEncoding.INSTANCE.contains(str) || MacExpertEncoding.INSTANCE.contains(str) || SymbolEncoding.INSTANCE.contains(str) || ZapfDingbatsEncoding.INSTANCE.contains(str);
                    if (!this.unicodeToName.containsKey(str2) || z) {
                        this.unicodeToName.put(str2, str);
                    }
                }
            } finally {
                bufferedReader.close();
            }
        }
    }

    public String codePointToName(int i2) {
        String str = this.unicodeToName.get(new String(new int[]{i2}, 0, 1));
        return str == null ? ".notdef" : str;
    }

    public String sequenceToName(String str) {
        String str2 = this.unicodeToName.get(str);
        return str2 == null ? ".notdef" : str2;
    }

    public String toUnicode(String str) {
        if (str == null) {
            return null;
        }
        String str2 = this.nameToUnicode.get(str);
        if (str2 != null) {
            return str2;
        }
        String strValueOf = this.uniNameToUnicodeCache.get(str);
        if (strValueOf == null) {
            if (str.indexOf(46) > 0) {
                strValueOf = toUnicode(str.substring(0, str.indexOf(46)));
            } else if (str.startsWith("uni") && str.length() == 7) {
                int length = str.length();
                StringBuilder sb = new StringBuilder();
                int i2 = 3;
                while (true) {
                    int i3 = i2 + 4;
                    if (i3 > length) {
                        break;
                    }
                    try {
                        int i4 = Integer.parseInt(str.substring(i2, i3), 16);
                        if (i4 <= 55295 || i4 >= 57344) {
                            sb.append((char) i4);
                        } else {
                            Log.w("PdfBox-Android", "Unicode character name with disallowed code area: " + str);
                        }
                        i2 = i3;
                    } catch (NumberFormatException unused) {
                        Log.w("PdfBox-Android", "Not a number in Unicode character name: " + str);
                    }
                    Log.w("PdfBox-Android", "Not a number in Unicode character name: " + str);
                }
                strValueOf = sb.toString();
            } else if (str.startsWith("u") && str.length() == 5) {
                try {
                    int i5 = Integer.parseInt(str.substring(1), 16);
                    if (i5 <= 55295 || i5 >= 57344) {
                        strValueOf = String.valueOf((char) i5);
                    } else {
                        Log.w("PdfBox-Android", "Unicode character name with disallowed code area: " + str);
                    }
                } catch (NumberFormatException unused2) {
                    Log.w("PdfBox-Android", "Not a number in Unicode character name: " + str);
                }
            }
            if (strValueOf != null) {
                this.uniNameToUnicodeCache.put(str, strValueOf);
            }
        }
        return strValueOf;
    }

    public GlyphList(GlyphList glyphList, InputStream inputStream) throws IOException {
        this.nameToUnicode = new HashMap(glyphList.nameToUnicode);
        this.unicodeToName = new HashMap(glyphList.unicodeToName);
        loadList(inputStream);
    }
}
