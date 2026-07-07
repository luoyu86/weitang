package com.tom_roush.pdfbox.pdmodel.font;

import android.util.Log;
import com.tom_roush.fontbox.FontBoxFont;
import com.tom_roush.fontbox.ttf.OTFParser;
import com.tom_roush.fontbox.ttf.OpenTypeFont;
import com.tom_roush.fontbox.ttf.TTFParser;
import com.tom_roush.fontbox.ttf.TrueTypeCollection;
import com.tom_roush.fontbox.ttf.TrueTypeFont;
import com.tom_roush.fontbox.type1.Type1Font;
import com.tom_roush.fontbox.util.autodetect.FontFileFinder;
import com.tom_roush.pdfbox.android.PDFBoxConfig;
import com.tom_roush.pdfbox.contentstream.operator.OperatorName;
import com.tom_roush.pdfbox.io.IOUtils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.security.AccessControlException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.codec.language.Soundex;

/* JADX INFO: loaded from: classes2.dex */
public final class FileSystemFontProvider extends FontProvider {
    private final FontCache cache;
    private final List<FSFontInfo> fontInfoList = new ArrayList();

    /* JADX INFO: renamed from: com.tom_roush.pdfbox.pdmodel.font.FileSystemFontProvider$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] $SwitchMap$com$tom_roush$pdfbox$pdmodel$font$FontFormat;

        static {
            int[] iArr = new int[FontFormat.values().length];
            $SwitchMap$com$tom_roush$pdfbox$pdmodel$font$FontFormat = iArr;
            try {
                iArr[FontFormat.PFB.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tom_roush$pdfbox$pdmodel$font$FontFormat[FontFormat.TTF.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$tom_roush$pdfbox$pdmodel$font$FontFormat[FontFormat.OTF.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static class FSFontInfo extends FontInfo {
        private final CIDSystemInfo cidSystemInfo;
        private final File file;
        private final FontFormat format;
        private final int macStyle;
        private final PDPanoseClassification panose;
        private final FileSystemFontProvider parent;
        private final String postScriptName;
        private final int sFamilyClass;
        private final int ulCodePageRange1;
        private final int ulCodePageRange2;
        private final int usWeightClass;

        private OpenTypeFont getOTFFont(String str, File file) {
            try {
                if (!file.getName().toLowerCase().endsWith(".ttc")) {
                    OpenTypeFont openTypeFont = new OTFParser(false, true).parse(file);
                    if (PDFBoxConfig.isDebugEnabled()) {
                        Log.d("PdfBox-Android", "Loaded " + str + " from " + file);
                    }
                    return openTypeFont;
                }
                TrueTypeCollection trueTypeCollection = new TrueTypeCollection(file);
                try {
                    TrueTypeFont fontByName = trueTypeCollection.getFontByName(str);
                    if (fontByName != null) {
                        return (OpenTypeFont) fontByName;
                    }
                    trueTypeCollection.close();
                    throw new IOException("Font " + str + " not found in " + file);
                } catch (IOException e2) {
                    Log.e("PdfBox-Android", e2.getMessage(), e2);
                    trueTypeCollection.close();
                    return null;
                }
            } catch (IOException e3) {
                Log.w("PdfBox-Android", "Could not load font file: " + file, e3);
                return null;
            }
        }

        private TrueTypeFont getTrueTypeFont(String str, File file) {
            try {
                TrueTypeFont trueTypeFont = readTrueTypeFont(str, file);
                if (PDFBoxConfig.isDebugEnabled()) {
                    Log.d("PdfBox-Android", "Loaded " + str + " from " + file);
                }
                return trueTypeFont;
            } catch (IOException e2) {
                Log.w("PdfBox-Android", "Could not load font file: " + file, e2);
                return null;
            }
        }

        /* JADX WARN: Not initialized variable reg: 2, insn: 0x0033: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:10:0x0033 */
        private Type1Font getType1Font(String str, File file) throws Throwable {
            FileInputStream fileInputStream;
            Closeable closeable;
            Closeable closeable2 = null;
            try {
                try {
                    fileInputStream = new FileInputStream(file);
                } catch (IOException e2) {
                    e = e2;
                    fileInputStream = null;
                } catch (Throwable th) {
                    th = th;
                    IOUtils.closeQuietly(closeable2);
                    throw th;
                }
                try {
                    Type1Font type1FontCreateWithPFB = Type1Font.createWithPFB(fileInputStream);
                    if (PDFBoxConfig.isDebugEnabled()) {
                        Log.d("PdfBox-Android", "Loaded " + str + " from " + file);
                    }
                    IOUtils.closeQuietly(fileInputStream);
                    return type1FontCreateWithPFB;
                } catch (IOException e3) {
                    e = e3;
                    Log.w("PdfBox-Android", "Could not load font file: " + file, e);
                    IOUtils.closeQuietly(fileInputStream);
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                closeable2 = closeable;
                IOUtils.closeQuietly(closeable2);
                throw th;
            }
        }

        private TrueTypeFont readTrueTypeFont(String str, File file) throws IOException {
            if (!file.getName().toLowerCase().endsWith(".ttc")) {
                return new TTFParser(false, true).parse(file);
            }
            TrueTypeCollection trueTypeCollection = new TrueTypeCollection(file);
            try {
                TrueTypeFont fontByName = trueTypeCollection.getFontByName(str);
                if (fontByName != null) {
                    return fontByName;
                }
                trueTypeCollection.close();
                throw new IOException("Font " + str + " not found in " + file);
            } catch (IOException e2) {
                trueTypeCollection.close();
                throw e2;
            }
        }

        @Override // com.tom_roush.pdfbox.pdmodel.font.FontInfo
        public CIDSystemInfo getCIDSystemInfo() {
            return this.cidSystemInfo;
        }

        @Override // com.tom_roush.pdfbox.pdmodel.font.FontInfo
        public int getCodePageRange1() {
            return this.ulCodePageRange1;
        }

        @Override // com.tom_roush.pdfbox.pdmodel.font.FontInfo
        public int getCodePageRange2() {
            return this.ulCodePageRange2;
        }

        @Override // com.tom_roush.pdfbox.pdmodel.font.FontInfo
        public int getFamilyClass() {
            return this.sFamilyClass;
        }

        @Override // com.tom_roush.pdfbox.pdmodel.font.FontInfo
        public synchronized FontBoxFont getFont() {
            FontBoxFont type1Font;
            FontBoxFont font = this.parent.cache.getFont(this);
            if (font != null) {
                return font;
            }
            int i2 = AnonymousClass2.$SwitchMap$com$tom_roush$pdfbox$pdmodel$font$FontFormat[this.format.ordinal()];
            if (i2 == 1) {
                type1Font = getType1Font(this.postScriptName, this.file);
            } else if (i2 == 2) {
                type1Font = getTrueTypeFont(this.postScriptName, this.file);
            } else {
                if (i2 != 3) {
                    throw new RuntimeException("can't happen");
                }
                type1Font = getOTFFont(this.postScriptName, this.file);
            }
            if (type1Font != null) {
                this.parent.cache.addFont(this, type1Font);
            }
            return type1Font;
        }

        @Override // com.tom_roush.pdfbox.pdmodel.font.FontInfo
        public FontFormat getFormat() {
            return this.format;
        }

        @Override // com.tom_roush.pdfbox.pdmodel.font.FontInfo
        public int getMacStyle() {
            return this.macStyle;
        }

        @Override // com.tom_roush.pdfbox.pdmodel.font.FontInfo
        public PDPanoseClassification getPanose() {
            return this.panose;
        }

        @Override // com.tom_roush.pdfbox.pdmodel.font.FontInfo
        public String getPostScriptName() {
            return this.postScriptName;
        }

        @Override // com.tom_roush.pdfbox.pdmodel.font.FontInfo
        public int getWeightClass() {
            return this.usWeightClass;
        }

        @Override // com.tom_roush.pdfbox.pdmodel.font.FontInfo
        public String toString() {
            return super.toString() + " " + this.file;
        }

        private FSFontInfo(File file, FontFormat fontFormat, String str, CIDSystemInfo cIDSystemInfo, int i2, int i3, int i4, int i5, int i6, byte[] bArr, FileSystemFontProvider fileSystemFontProvider) {
            this.file = file;
            this.format = fontFormat;
            this.postScriptName = str;
            this.cidSystemInfo = cIDSystemInfo;
            this.usWeightClass = i2;
            this.sFamilyClass = i3;
            this.ulCodePageRange1 = i4;
            this.ulCodePageRange2 = i5;
            this.macStyle = i6;
            this.panose = (bArr == null || bArr.length < 10) ? null : new PDPanoseClassification(bArr);
            this.parent = fileSystemFontProvider;
        }
    }

    public static final class FSIgnored extends FSFontInfo {
        private FSIgnored(File file, FontFormat fontFormat, String str) {
            super(file, fontFormat, str, null, 0, 0, 0, 0, 0, null, null);
        }
    }

    public FileSystemFontProvider(FontCache fontCache) throws Throwable {
        this.cache = fontCache;
        if (PDFBoxConfig.getFontLoadLevel() == PDFBoxConfig.FontLoadLevel.NONE) {
            return;
        }
        if (PDFBoxConfig.getFontLoadLevel() == PDFBoxConfig.FontLoadLevel.MINIMUM) {
            try {
                addTrueTypeFont(new File("/system/fonts/DroidSans.ttf"));
                addTrueTypeFont(new File("/system/fonts/DroidSans-Bold.ttf"));
                addTrueTypeFont(new File("/system/fonts/DroidSansMono.ttf"));
                return;
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        try {
            if (PDFBoxConfig.isDebugEnabled()) {
                Log.d("PdfBox-Android", "Will search the local system for fonts");
            }
            List<URI> listFind = new FontFileFinder().find();
            ArrayList arrayList = new ArrayList(listFind.size());
            Iterator<URI> it = listFind.iterator();
            while (it.hasNext()) {
                arrayList.add(new File(it.next()));
            }
            if (PDFBoxConfig.isDebugEnabled()) {
                Log.d("PdfBox-Android", "Found " + arrayList.size() + " fonts on the local system");
            }
            List<FSFontInfo> listLoadDiskCache = loadDiskCache(arrayList);
            if (listLoadDiskCache != null && !listLoadDiskCache.isEmpty()) {
                this.fontInfoList.addAll(listLoadDiskCache);
                return;
            }
            Log.w("PdfBox-Android", "Building on-disk font cache, this may take a while");
            scanFonts(arrayList);
            saveDiskCache();
            Log.w("PdfBox-Android", "Finished building on-disk font cache, found " + this.fontInfoList.size() + " fonts");
        } catch (AccessControlException e3) {
            Log.e("PdfBox-Android", "Error accessing the file system", e3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void addTrueTypeCollection(final java.io.File r7) throws java.lang.Throwable {
        /*
            r6 = this;
            r0 = 0
            com.tom_roush.fontbox.ttf.TrueTypeCollection r1 = new com.tom_roush.fontbox.ttf.TrueTypeCollection     // Catch: java.lang.Throwable -> L14 java.io.IOException -> L16
            r1.<init>(r7)     // Catch: java.lang.Throwable -> L14 java.io.IOException -> L16
            com.tom_roush.pdfbox.pdmodel.font.FileSystemFontProvider$1 r0 = new com.tom_roush.pdfbox.pdmodel.font.FileSystemFontProvider$1     // Catch: java.io.IOException -> L12 java.lang.Throwable -> L34
            r0.<init>()     // Catch: java.io.IOException -> L12 java.lang.Throwable -> L34
            r1.processAllFonts(r0)     // Catch: java.io.IOException -> L12 java.lang.Throwable -> L34
        Le:
            r1.close()
            goto L33
        L12:
            r0 = move-exception
            goto L1a
        L14:
            r7 = move-exception
            goto L36
        L16:
            r1 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
        L1a:
            java.lang.String r2 = "PdfBox-Android"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L34
            r3.<init>()     // Catch: java.lang.Throwable -> L34
            java.lang.String r4 = "Could not load font file: "
            r3.append(r4)     // Catch: java.lang.Throwable -> L34
            r3.append(r7)     // Catch: java.lang.Throwable -> L34
            java.lang.String r7 = r3.toString()     // Catch: java.lang.Throwable -> L34
            android.util.Log.w(r2, r7, r0)     // Catch: java.lang.Throwable -> L34
            if (r1 == 0) goto L33
            goto Le
        L33:
            return
        L34:
            r7 = move-exception
            r0 = r1
        L36:
            if (r0 == 0) goto L3b
            r0.close()
        L3b:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tom_roush.pdfbox.pdmodel.font.FileSystemFontProvider.addTrueTypeCollection(java.io.File):void");
    }

    private void addTrueTypeFont(File file) throws Throwable {
        try {
            if (file.getPath().toLowerCase().endsWith(".otf")) {
                addTrueTypeFontImpl(new OTFParser(false, true).parse(file), file);
            } else {
                addTrueTypeFontImpl(new TTFParser(false, true).parse(file), file);
            }
        } catch (IOException e2) {
            Log.w("PdfBox-Android", "Could not load font file: " + file, e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Not initialized variable reg: 23, insn: 0x015d: MOVE (r1 I:??[OBJECT, ARRAY]) = (r23 I:??[OBJECT, ARRAY]), block:B:42:0x015a */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0109  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void addTrueTypeFontImpl(com.tom_roush.fontbox.ttf.TrueTypeFont r25, java.io.File r26) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 577
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tom_roush.pdfbox.pdmodel.font.FileSystemFontProvider.addTrueTypeFontImpl(com.tom_roush.fontbox.ttf.TrueTypeFont, java.io.File):void");
    }

    private void addType1Font(File file) throws Throwable {
        FileInputStream fileInputStream;
        String str;
        Type1Font type1FontCreateWithPFB;
        FileInputStream fileInputStream2 = new FileInputStream(file);
        try {
            type1FontCreateWithPFB = Type1Font.createWithPFB(fileInputStream2);
        } catch (IOException e2) {
            e = e2;
            fileInputStream = fileInputStream2;
            str = "PdfBox-Android";
        } catch (Throwable th) {
            th = th;
            fileInputStream = fileInputStream2;
            fileInputStream.close();
            throw th;
        }
        if (type1FontCreateWithPFB.getName() == null) {
            this.fontInfoList.add(new FSIgnored(file, FontFormat.PFB, "*skipnoname*"));
            Log.w("PdfBox-Android", "Missing 'name' entry for PostScript name in font " + file);
            fileInputStream2.close();
            return;
        }
        if (type1FontCreateWithPFB.getName().contains("|")) {
            this.fontInfoList.add(new FSIgnored(file, FontFormat.PFB, "*skippipeinname*"));
            Log.w("PdfBox-Android", "Skipping font with '|' in name " + type1FontCreateWithPFB.getName() + " in file " + file);
            fileInputStream2.close();
            return;
        }
        fileInputStream = fileInputStream2;
        str = "PdfBox-Android";
        try {
            try {
                this.fontInfoList.add(new FSFontInfo(file, FontFormat.PFB, type1FontCreateWithPFB.getName(), null, -1, -1, 0, 0, -1, null, this));
                if (PDFBoxConfig.isDebugEnabled()) {
                    Log.d(str, "PFB: '" + type1FontCreateWithPFB.getName() + "' / '" + type1FontCreateWithPFB.getFamilyName() + "' / '" + type1FontCreateWithPFB.getWeight() + OperatorName.SHOW_TEXT_LINE);
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream.close();
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            Log.w(str, "Could not load font file: " + file, e);
        }
        fileInputStream.close();
    }

    private File getDiskCacheFile() {
        String property = System.getProperty("pdfbox.fontcache");
        if ((property == null || !new File(property).isDirectory() || !new File(property).canWrite()) && ((property = System.getProperty("user.home")) == null || !new File(property).isDirectory() || !new File(property).canWrite())) {
            property = System.getProperty("java.io.tmpdir");
        }
        return new File(property, ".pdfbox.cache");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v13 */
    private List<FSFontInfo> loadDiskCache(List<File> list) throws Throwable {
        File diskCacheFile;
        ?? Exists;
        ?? r3;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        CIDSystemInfo cIDSystemInfo;
        int i2;
        int i3;
        byte[] bArr;
        HashSet hashSet = new HashSet(list.size());
        Iterator<File> it = list.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().getAbsolutePath());
        }
        ArrayList arrayList = new ArrayList();
        char c2 = 0;
        try {
            diskCacheFile = getDiskCacheFile();
        } catch (SecurityException unused) {
            diskCacheFile = null;
        }
        try {
            Exists = diskCacheFile.exists();
        } catch (SecurityException unused2) {
            Exists = 0;
        }
        try {
            if (Exists != 0) {
                try {
                    bufferedReader = new BufferedReader(new FileReader(diskCacheFile));
                    while (true) {
                        try {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            }
                            String[] strArrSplit = line.split("\\|", 10);
                            if (strArrSplit.length < 10) {
                                try {
                                    Log.w("PdfBox-Android", "Incorrect line '" + line + "' in font disk cache is skipped");
                                } catch (IOException e2) {
                                    e = e2;
                                    Log.w("PdfBox-Android", "Error loading font cache, will be re-built", e);
                                    IOUtils.closeQuietly(bufferedReader);
                                    return null;
                                }
                            } else {
                                String str = strArrSplit[c2];
                                FontFormat fontFormatValueOf = FontFormat.valueOf(strArrSplit[1]);
                                if (strArrSplit[2].length() > 0) {
                                    String[] strArrSplit2 = strArrSplit[2].split("-");
                                    cIDSystemInfo = new CIDSystemInfo(strArrSplit2[c2], strArrSplit2[1], Integer.parseInt(strArrSplit2[2]));
                                } else {
                                    cIDSystemInfo = null;
                                }
                                int i4 = strArrSplit[3].length() > 0 ? (int) Long.parseLong(strArrSplit[3], 16) : -1;
                                int i5 = strArrSplit[4].length() > 0 ? (int) Long.parseLong(strArrSplit[4], 16) : -1;
                                int i6 = (int) Long.parseLong(strArrSplit[5], 16);
                                int i7 = (int) Long.parseLong(strArrSplit[6], 16);
                                if (strArrSplit[7].length() > 0) {
                                    bufferedReader2 = bufferedReader;
                                    try {
                                        i2 = (int) Long.parseLong(strArrSplit[7], 16);
                                    } catch (IOException e3) {
                                        e = e3;
                                        bufferedReader = bufferedReader2;
                                        Log.w("PdfBox-Android", "Error loading font cache, will be re-built", e);
                                        IOUtils.closeQuietly(bufferedReader);
                                        return null;
                                    } catch (Throwable th) {
                                        th = th;
                                        r3 = bufferedReader2;
                                        IOUtils.closeQuietly(r3);
                                        throw th;
                                    }
                                } else {
                                    bufferedReader2 = bufferedReader;
                                    i2 = -1;
                                }
                                char c3 = '\b';
                                if (strArrSplit[8].length() > 0) {
                                    byte[] bArr2 = new byte[10];
                                    int i8 = 0;
                                    for (int i9 = 10; i8 < i9; i9 = 10) {
                                        String str2 = strArrSplit[c3];
                                        int i10 = i8 * 2;
                                        bArr2[i8] = (byte) (Integer.parseInt(str2.substring(i10, i10 + 2), 16) & 255);
                                        i8++;
                                        i7 = i7;
                                        c3 = '\b';
                                    }
                                    i3 = i7;
                                    bArr = bArr2;
                                } else {
                                    i3 = i7;
                                    bArr = null;
                                }
                                File file = new File(strArrSplit[9]);
                                if (file.exists()) {
                                    arrayList.add(new FSFontInfo(file, fontFormatValueOf, str, cIDSystemInfo, i4, i5, i6, i3, i2, bArr, this));
                                } else {
                                    Log.d("PdfBox-Android", "Font file " + file.getAbsolutePath() + " not found, skipped");
                                }
                                hashSet.remove(file.getAbsolutePath());
                                bufferedReader = bufferedReader2;
                                c2 = 0;
                            }
                        } catch (IOException e4) {
                            e = e4;
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedReader2 = bufferedReader;
                        }
                    }
                    IOUtils.closeQuietly(bufferedReader);
                } catch (IOException e5) {
                    e = e5;
                    bufferedReader = null;
                } catch (Throwable th3) {
                    th = th3;
                    r3 = 0;
                }
            }
            if (hashSet.isEmpty()) {
                return arrayList;
            }
            Log.w("PdfBox-Android", "New fonts found, font cache will be re-built");
            return null;
        } catch (Throwable th4) {
            th = th4;
            r3 = Exists;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    private void saveDiskCache() throws Throwable {
        ?? r2 = 0;
        BufferedWriter bufferedWriter = null;
        try {
            try {
                BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(getDiskCacheFile()));
                try {
                    Iterator<FSFontInfo> it = this.fontInfoList.iterator();
                    while (it.hasNext()) {
                        FSFontInfo next = it.next();
                        bufferedWriter2.write(next.postScriptName.trim());
                        bufferedWriter2.write("|");
                        bufferedWriter2.write(next.format.toString());
                        bufferedWriter2.write("|");
                        if (next.cidSystemInfo != null) {
                            bufferedWriter2.write(next.cidSystemInfo.getRegistry() + Soundex.SILENT_MARKER + next.cidSystemInfo.getOrdering() + Soundex.SILENT_MARKER + next.cidSystemInfo.getSupplement());
                        }
                        bufferedWriter2.write("|");
                        if (next.usWeightClass > -1) {
                            bufferedWriter2.write(Integer.toHexString(next.usWeightClass));
                        }
                        bufferedWriter2.write("|");
                        if (next.sFamilyClass > -1) {
                            bufferedWriter2.write(Integer.toHexString(next.sFamilyClass));
                        }
                        bufferedWriter2.write("|");
                        bufferedWriter2.write(Integer.toHexString(next.ulCodePageRange1));
                        bufferedWriter2.write("|");
                        bufferedWriter2.write(Integer.toHexString(next.ulCodePageRange2));
                        bufferedWriter2.write("|");
                        if (next.macStyle > -1) {
                            bufferedWriter2.write(Integer.toHexString(next.macStyle));
                        }
                        bufferedWriter2.write("|");
                        if (next.panose != null) {
                            byte[] bytes = next.panose.getBytes();
                            for (int i2 = 0; i2 < 10; i2++) {
                                String hexString = Integer.toHexString(bytes[i2]);
                                if (hexString.length() == 1) {
                                    bufferedWriter2.write(48);
                                }
                                bufferedWriter2.write(hexString);
                            }
                        }
                        bufferedWriter2.write("|");
                        bufferedWriter2.write(next.file.getAbsolutePath());
                        bufferedWriter2.newLine();
                    }
                    IOUtils.closeQuietly(bufferedWriter2);
                    r2 = it;
                } catch (IOException e2) {
                    e = e2;
                    bufferedWriter = bufferedWriter2;
                    Log.w("PdfBox-Android", "Could not write to font cache", e);
                    Log.w("PdfBox-Android", "Installed fonts information will have to be reloaded for each start");
                    Log.w("PdfBox-Android", "You can assign a directory to the 'pdfbox.fontcache' property");
                    IOUtils.closeQuietly(bufferedWriter);
                    r2 = bufferedWriter;
                } catch (Throwable th) {
                    th = th;
                    r2 = bufferedWriter2;
                    IOUtils.closeQuietly(r2);
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
            } catch (SecurityException unused) {
                IOUtils.closeQuietly(null);
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private void scanFonts(List<File> list) throws Throwable {
        for (File file : list) {
            try {
                String lowerCase = file.getPath().toLowerCase();
                if (lowerCase.endsWith(".ttf") || lowerCase.endsWith(".otf")) {
                    addTrueTypeFont(file);
                } else if (lowerCase.endsWith(".ttc") || lowerCase.endsWith(".otc")) {
                    addTrueTypeCollection(file);
                } else if (lowerCase.endsWith(".pfb")) {
                    addType1Font(file);
                }
            } catch (IOException e2) {
                Log.w("PdfBox-Android", "Error parsing font " + file.getPath(), e2);
            }
        }
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.FontProvider
    public List<? extends FontInfo> getFontInfo() {
        return this.fontInfoList;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.FontProvider
    public String toDebugString() {
        StringBuilder sb = new StringBuilder();
        for (FSFontInfo fSFontInfo : this.fontInfoList) {
            sb.append(fSFontInfo.getFormat());
            sb.append(": ");
            sb.append(fSFontInfo.getPostScriptName());
            sb.append(": ");
            sb.append(fSFontInfo.file.getPath());
            sb.append('\n');
        }
        return sb.toString();
    }
}
