package com.tom_roush.pdfbox.pdfparser;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import androidx.recyclerview.widget.RecyclerView;
import com.tom_roush.pdfbox.contentstream.operator.OperatorName;
import com.tom_roush.pdfbox.cos.COSArray;
import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.cos.COSDocument;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.cos.COSNull;
import com.tom_roush.pdfbox.cos.COSNumber;
import com.tom_roush.pdfbox.cos.COSObject;
import com.tom_roush.pdfbox.cos.COSObjectKey;
import com.tom_roush.pdfbox.cos.COSStream;
import com.tom_roush.pdfbox.io.IOUtils;
import com.tom_roush.pdfbox.io.RandomAccessRead;
import com.tom_roush.pdfbox.pdfparser.XrefTrailerResolver;
import com.tom_roush.pdfbox.pdmodel.encryption.AccessPermission;
import com.tom_roush.pdfbox.pdmodel.encryption.DecryptionMaterial;
import com.tom_roush.pdfbox.pdmodel.encryption.PDEncryption;
import com.tom_roush.pdfbox.pdmodel.encryption.PublicKeyDecryptionMaterial;
import com.tom_roush.pdfbox.pdmodel.encryption.SecurityHandler;
import com.tom_roush.pdfbox.pdmodel.encryption.StandardDecryptionMaterial;
import com.tom_roush.pdfbox.util.Charsets;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class COSParser extends BaseParser {
    private static final int DEFAULT_TRAIL_BYTECOUNT = 2048;
    private static final String FDF_DEFAULT_VERSION = "1.0";
    private static final String FDF_HEADER = "%FDF-";
    private static final long MINIMUM_SEARCH_OFFSET = 6;
    private static final String PDF_DEFAULT_VERSION = "1.4";
    private static final String PDF_HEADER = "%PDF-";
    private static final int STREAMCOPYBUFLEN = 8192;
    private static final int STRMBUFLEN = 2048;
    public static final String SYSPROP_EOFLOOKUPRANGE = "com.tom_roush.pdfbox.pdfparser.nonSequentialPDFParser.eofLookupRange";
    public static final String SYSPROP_PARSEMINIMAL = "com.tom_roush.pdfbox.pdfparser.nonSequentialPDFParser.parseMinimal";
    public static final String TMP_FILE_PREFIX = "tmpPDF";
    private static final int X = 120;
    private AccessPermission accessPermission;
    private Map<COSObjectKey, Long> bfSearchCOSObjectKeyOffsets;
    private List<Long> bfSearchXRefStreamsOffsets;
    private List<Long> bfSearchXRefTablesOffsets;
    private PDEncryption encryption;
    public long fileLen;
    public boolean initialParseDone;
    private boolean isLenient;
    private String keyAlias;
    private InputStream keyStoreInputStream;
    private Long lastEOFMarker;
    private String password;
    private int readTrailBytes;
    public SecurityHandler securityHandler;
    public final RandomAccessRead source;
    private final byte[] streamCopyBuf;
    private final byte[] strmBuf;
    private long trailerOffset;
    private boolean trailerWasRebuild;
    public XrefTrailerResolver xrefTrailerResolver;
    private static final char[] XREF_TABLE = {'x', 'r', 'e', 'f'};
    private static final char[] XREF_STREAM = {'/', 'X', 'R', 'e', 'f'};
    private static final char[] STARTXREF = {'s', 't', 'a', 'r', 't', 'x', 'r', 'e', 'f'};
    private static final byte[] ENDSTREAM = {101, 110, 100, 115, 116, 114, 101, 97, 109};
    private static final byte[] ENDOBJ = {101, 110, 100, 111, 98, 106};
    public static final char[] EOF_MARKER = {'%', '%', 'E', 'O', 'F'};
    public static final char[] OBJ_MARKER = {'o', 'b', 'j'};
    private static final char[] TRAILER_MARKER = {'t', 'r', 'a', 'i', 'l', 'e', 'r'};
    private static final char[] OBJ_STREAM = {'/', 'O', 'b', 'j', 'S', 't', 'm'};

    public COSParser(RandomAccessRead randomAccessRead) {
        super(new RandomAccessSource(randomAccessRead));
        this.strmBuf = new byte[2048];
        this.keyStoreInputStream = null;
        this.password = "";
        this.keyAlias = null;
        this.isLenient = true;
        this.initialParseDone = false;
        this.trailerWasRebuild = false;
        this.bfSearchCOSObjectKeyOffsets = null;
        this.lastEOFMarker = null;
        this.bfSearchXRefTablesOffsets = null;
        this.bfSearchXRefStreamsOffsets = null;
        this.encryption = null;
        this.securityHandler = null;
        this.readTrailBytes = 2048;
        this.xrefTrailerResolver = new XrefTrailerResolver();
        this.streamCopyBuf = new byte[8192];
        this.source = randomAccessRead;
    }

    private void addExcludedToList(COSName[] cOSNameArr, COSDictionary cOSDictionary, Set<Long> set) {
        if (cOSNameArr != null) {
            for (COSName cOSName : cOSNameArr) {
                COSBase item = cOSDictionary.getItem(cOSName);
                if (item instanceof COSObject) {
                    set.add(Long.valueOf(getObjectId((COSObject) item)));
                }
            }
        }
    }

    private void addNewToList(Queue<COSBase> queue, Collection<COSBase> collection, Set<Long> set) {
        Iterator<COSBase> it = collection.iterator();
        while (it.hasNext()) {
            addNewToList(queue, it.next(), set);
        }
    }

    private void bfSearchForLastEOFMarker() throws IOException {
        if (this.lastEOFMarker == null) {
            long position = this.source.getPosition();
            this.source.seek(6L);
            while (!this.source.isEOF()) {
                if (isString(EOF_MARKER)) {
                    long position2 = this.source.getPosition();
                    this.source.seek(5 + position2);
                    try {
                        skipSpaces();
                        if (!isString(XREF_TABLE)) {
                            readObjectNumber();
                            readGenerationNumber();
                        }
                    } catch (IOException unused) {
                        this.lastEOFMarker = Long.valueOf(position2);
                    }
                }
                this.source.read();
            }
            this.source.seek(position);
            if (this.lastEOFMarker == null) {
                this.lastEOFMarker = Long.valueOf(RecyclerView.FOREVER_NS);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x029d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void bfSearchForObjStreams() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 702
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tom_roush.pdfbox.pdfparser.COSParser.bfSearchForObjStreams():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00c5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void bfSearchForObjects() throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 299
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tom_roush.pdfbox.pdfparser.COSParser.bfSearchForObjects():void");
    }

    private boolean bfSearchForTrailer(COSDictionary cOSDictionary) throws IOException {
        COSObject cOSObject;
        COSDictionary cOSDictionaryRetrieveCOSDictionary;
        COSDictionary cOSDictionaryRetrieveCOSDictionary2;
        long position = this.source.getPosition();
        this.source.seek(6L);
        while (true) {
            boolean z = false;
            if (this.source.isEOF()) {
                this.source.seek(position);
                return false;
            }
            char[] cArr = TRAILER_MARKER;
            if (isString(cArr)) {
                RandomAccessRead randomAccessRead = this.source;
                randomAccessRead.seek(randomAccessRead.getPosition() + ((long) cArr.length));
                try {
                    skipSpaces();
                    COSDictionary cOSDictionary2 = parseCOSDictionary();
                    COSName cOSName = COSName.ROOT;
                    COSObject cOSObject2 = cOSDictionary2.getCOSObject(cOSName);
                    boolean z2 = (cOSObject2 == null || (cOSDictionaryRetrieveCOSDictionary2 = retrieveCOSDictionary(cOSObject2)) == null || !isCatalog(cOSDictionaryRetrieveCOSDictionary2)) ? false : true;
                    COSName cOSName2 = COSName.INFO;
                    COSObject cOSObject3 = cOSDictionary2.getCOSObject(cOSName2);
                    if (cOSObject3 != null && (cOSDictionaryRetrieveCOSDictionary = retrieveCOSDictionary(cOSObject3)) != null && isInfo(cOSDictionaryRetrieveCOSDictionary)) {
                        z = true;
                    }
                    if (z2 && z) {
                        cOSDictionary.setItem(cOSName, (COSBase) cOSObject2);
                        cOSDictionary.setItem(cOSName2, (COSBase) cOSObject3);
                        COSName cOSName3 = COSName.ENCRYPT;
                        if (cOSDictionary2.containsKey(cOSName3) && (cOSObject = cOSDictionary2.getCOSObject(cOSName3)) != null && retrieveCOSDictionary(cOSObject) != null) {
                            cOSDictionary.setItem(cOSName3, (COSBase) cOSObject);
                        }
                        COSName cOSName4 = COSName.ID;
                        if (!cOSDictionary2.containsKey(cOSName4)) {
                            break;
                        }
                        COSBase item = cOSDictionary2.getItem(cOSName4);
                        if (!(item instanceof COSArray)) {
                            break;
                        }
                        cOSDictionary.setItem(cOSName4, item);
                        break;
                    }
                } catch (IOException unused) {
                }
            }
            this.source.read();
        }
        return true;
    }

    private long bfSearchForXRef(long j, boolean z) throws IOException {
        List<Long> list;
        if (!z) {
            bfSearchForXRefTables();
        }
        bfSearchForXRefStreams();
        long jSearchNearestValue = (z || (list = this.bfSearchXRefTablesOffsets) == null) ? -1L : searchNearestValue(list, j);
        List<Long> list2 = this.bfSearchXRefStreamsOffsets;
        long jSearchNearestValue2 = list2 != null ? searchNearestValue(list2, j) : -1L;
        if (jSearchNearestValue > -1 && jSearchNearestValue2 > -1) {
            if (Math.abs(j - jSearchNearestValue) > Math.abs(j - jSearchNearestValue2)) {
                this.bfSearchXRefStreamsOffsets.remove(Long.valueOf(jSearchNearestValue2));
                return jSearchNearestValue2;
            }
            this.bfSearchXRefTablesOffsets.remove(Long.valueOf(jSearchNearestValue));
            return jSearchNearestValue;
        }
        if (jSearchNearestValue > -1) {
            this.bfSearchXRefTablesOffsets.remove(Long.valueOf(jSearchNearestValue));
            return jSearchNearestValue;
        }
        if (jSearchNearestValue2 <= -1) {
            return -1L;
        }
        this.bfSearchXRefStreamsOffsets.remove(Long.valueOf(jSearchNearestValue2));
        return jSearchNearestValue2;
    }

    private void bfSearchForXRefStreams() throws IOException {
        if (this.bfSearchXRefStreamsOffsets == null) {
            this.bfSearchXRefStreamsOffsets = new ArrayList();
            long position = this.source.getPosition();
            this.source.seek(6L);
            char[] charArray = " obj".toCharArray();
            while (!this.source.isEOF()) {
                if (isString(XREF_STREAM)) {
                    long position2 = this.source.getPosition();
                    boolean z = false;
                    long position3 = -1;
                    for (int i2 = 1; i2 < 40 && !z; i2++) {
                        long j = position2 - ((long) (i2 * 10));
                        if (j > 0) {
                            this.source.seek(j);
                            int i3 = 0;
                            while (true) {
                                if (i3 >= 10) {
                                    break;
                                }
                                if (isString(charArray)) {
                                    long j2 = j - 1;
                                    this.source.seek(j2);
                                    if (BaseParser.isDigit(this.source.peek())) {
                                        long j3 = j2 - 1;
                                        this.source.seek(j3);
                                        if (isSpace()) {
                                            long j4 = j3 - 1;
                                            this.source.seek(j4);
                                            int i4 = 0;
                                            while (j4 > 6 && isDigit()) {
                                                j4--;
                                                this.source.seek(j4);
                                                i4++;
                                            }
                                            if (i4 > 0) {
                                                this.source.read();
                                                position3 = this.source.getPosition();
                                            }
                                        }
                                    }
                                    Log.d("PdfBox-Android", "Fixed reference for xref stream " + position2 + " -> " + position3);
                                    z = true;
                                } else {
                                    j++;
                                    this.source.read();
                                    i3++;
                                }
                            }
                        }
                    }
                    if (position3 > -1) {
                        this.bfSearchXRefStreamsOffsets.add(Long.valueOf(position3));
                    }
                    this.source.seek(position2 + 5);
                }
                this.source.read();
            }
            this.source.seek(position);
        }
    }

    private void bfSearchForXRefTables() throws IOException {
        if (this.bfSearchXRefTablesOffsets == null) {
            this.bfSearchXRefTablesOffsets = new ArrayList();
            long position = this.source.getPosition();
            this.source.seek(6L);
            while (!this.source.isEOF()) {
                if (isString(XREF_TABLE)) {
                    long position2 = this.source.getPosition();
                    this.source.seek(position2 - 1);
                    if (isWhitespace()) {
                        this.bfSearchXRefTablesOffsets.add(Long.valueOf(position2));
                    }
                    this.source.seek(position2 + 4);
                }
                this.source.read();
            }
            this.source.seek(position);
        }
    }

    private long calculateXRefFixedOffset(long j, boolean z) throws IOException {
        if (j < 0) {
            Log.e("PdfBox-Android", "Invalid object offset " + j + " when searching for a xref table/stream");
            return 0L;
        }
        long jBfSearchForXRef = bfSearchForXRef(j, z);
        if (jBfSearchForXRef <= -1) {
            Log.e("PdfBox-Android", "Can't find the object xref table/stream at offset " + j);
            return 0L;
        }
        Log.d("PdfBox-Android", "Fixed reference for xref table/stream " + j + " -> " + jBfSearchForXRef);
        return jBfSearchForXRef;
    }

    private int checkPagesDictionary(COSDictionary cOSDictionary, Set<COSObject> set) {
        COSBase dictionaryObject = cOSDictionary.getDictionaryObject(COSName.KIDS);
        int iCheckPagesDictionary = 0;
        if (dictionaryObject instanceof COSArray) {
            COSArray cOSArray = (COSArray) dictionaryObject;
            for (COSBase cOSBase : cOSArray.toList()) {
                if (cOSBase instanceof COSObject) {
                    COSObject cOSObject = (COSObject) cOSBase;
                    if (!set.contains(cOSObject)) {
                        COSBase object = cOSObject.getObject();
                        if (object == null || object.equals(COSNull.NULL)) {
                            Log.w("PdfBox-Android", "Removed null object " + cOSBase + " from pages dictionary");
                            cOSArray.remove(cOSBase);
                        } else if (object instanceof COSDictionary) {
                            COSDictionary cOSDictionary2 = (COSDictionary) object;
                            COSName cOSName = cOSDictionary2.getCOSName(COSName.TYPE);
                            if (COSName.PAGES.equals(cOSName)) {
                                set.add(cOSObject);
                                iCheckPagesDictionary += checkPagesDictionary(cOSDictionary2, set);
                            } else if (COSName.PAGE.equals(cOSName)) {
                                iCheckPagesDictionary++;
                            }
                        }
                    }
                }
                cOSArray.remove(cOSBase);
            }
        }
        cOSDictionary.setInt(COSName.COUNT, iCheckPagesDictionary);
        return iCheckPagesDictionary;
    }

    private long checkXRefOffset(long j) throws IOException {
        if (!this.isLenient) {
            return j;
        }
        this.source.seek(j);
        skipSpaces();
        if (this.source.peek() == 120 && isString(XREF_TABLE)) {
            return j;
        }
        if (j > 0) {
            return checkXRefStreamOffset(j) ? j : calculateXRefFixedOffset(j, false);
        }
        return -1L;
    }

    private boolean checkXRefStreamOffset(long j) throws IOException {
        if (!this.isLenient || j == 0) {
            return true;
        }
        this.source.seek(j - 1);
        if (!isWhitespace(this.source.read())) {
            return false;
        }
        skipSpaces();
        if (!isDigit()) {
            return false;
        }
        try {
            readObjectNumber();
            readGenerationNumber();
            readExpectedString(OBJ_MARKER, true);
            COSDictionary cOSDictionary = parseCOSDictionary();
            this.source.seek(j);
            return "XRef".equals(cOSDictionary.getNameAsString(COSName.TYPE));
        } catch (IOException unused) {
            this.source.seek(j);
            return false;
        }
    }

    private void checkXrefOffsets() throws IOException {
        if (this.isLenient) {
            Map<COSObjectKey, Long> xrefTable = this.xrefTrailerResolver.getXrefTable();
            if (validateXrefOffsets(xrefTable)) {
                return;
            }
            bfSearchForObjects();
            Map<COSObjectKey, Long> map = this.bfSearchCOSObjectKeyOffsets;
            if (map == null || map.isEmpty()) {
                return;
            }
            Log.d("PdfBox-Android", "Replaced read xref table with the results of a brute force search");
            xrefTable.clear();
            xrefTable.putAll(this.bfSearchCOSObjectKeyOffsets);
        }
    }

    private COSObject compareCOSObjects(COSObject cOSObject, Long l, COSObject cOSObject2, Long l2) {
        return cOSObject2 != null ? cOSObject2.getObjectNumber() == cOSObject.getObjectNumber() ? cOSObject2.getGenerationNumber() < cOSObject.getGenerationNumber() ? cOSObject : cOSObject2 : (l2 == null || l.longValue() <= l2.longValue()) ? cOSObject2 : cOSObject : cOSObject;
    }

    private COSObjectKey findObjectKey(COSObjectKey cOSObjectKey, long j) throws IOException {
        if (j < 6) {
            return null;
        }
        try {
            this.source.seek(j);
            if (cOSObjectKey.getNumber() == readObjectNumber()) {
                int generationNumber = readGenerationNumber();
                readExpectedString(OBJ_MARKER, true);
                if (generationNumber == cOSObjectKey.getGeneration()) {
                    return cOSObjectKey;
                }
                if (this.isLenient && generationNumber > cOSObjectKey.getGeneration()) {
                    return new COSObjectKey(cOSObjectKey.getNumber(), generationNumber);
                }
            }
        } catch (IOException e2) {
            Log.d("PdfBox-Android", "No valid object at given location " + j + " - ignoring", e2);
        }
        return null;
    }

    private COSNumber getLength(COSBase cOSBase, COSName cOSName) throws IOException {
        if (cOSBase == null) {
            return null;
        }
        if (cOSBase instanceof COSNumber) {
            return (COSNumber) cOSBase;
        }
        if (!(cOSBase instanceof COSObject)) {
            throw new IOException("Wrong type of length object: " + cOSBase.getClass().getSimpleName());
        }
        COSObject cOSObject = (COSObject) cOSBase;
        COSBase object = cOSObject.getObject();
        if (object == null) {
            long position = this.source.getPosition();
            parseObjectDynamically(cOSObject, COSName.OBJ_STM.equals(cOSName));
            this.source.seek(position);
            object = cOSObject.getObject();
        }
        if (object == null) {
            throw new IOException("Length object content was not read.");
        }
        if (COSNull.NULL == object) {
            Log.w("PdfBox-Android", "Length object (" + cOSObject.getObjectNumber() + " " + cOSObject.getGenerationNumber() + ") not found");
            return null;
        }
        if (object instanceof COSNumber) {
            return (COSNumber) object;
        }
        throw new IOException("Wrong type of referenced length object " + cOSObject + ": " + object.getClass().getSimpleName());
    }

    private long getObjectId(COSObject cOSObject) {
        return (cOSObject.getObjectNumber() << 32) | ((long) cOSObject.getGenerationNumber());
    }

    private boolean isInfo(COSDictionary cOSDictionary) {
        if (cOSDictionary.containsKey(COSName.PARENT) || cOSDictionary.containsKey(COSName.A) || cOSDictionary.containsKey(COSName.DEST)) {
            return false;
        }
        return cOSDictionary.containsKey(COSName.MOD_DATE) || cOSDictionary.containsKey(COSName.TITLE) || cOSDictionary.containsKey(COSName.AUTHOR) || cOSDictionary.containsKey(COSName.SUBJECT) || cOSDictionary.containsKey(COSName.KEYWORDS) || cOSDictionary.containsKey(COSName.CREATOR) || cOSDictionary.containsKey(COSName.PRODUCER) || cOSDictionary.containsKey(COSName.CREATION_DATE);
    }

    private boolean isString(byte[] bArr) throws IOException {
        if (this.source.peek() != bArr[0]) {
            return false;
        }
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        int i2 = this.source.read(bArr2, 0, length);
        while (i2 < length) {
            int i3 = this.source.read(bArr2, i2, length - i2);
            if (i3 < 0) {
                break;
            }
            i2 += i3;
        }
        boolean zEquals = Arrays.equals(bArr, bArr2);
        this.source.rewind(i2);
        return zEquals;
    }

    private void parseDictionaryRecursive(COSObject cOSObject) throws IOException {
        parseObjectDynamically(cOSObject, true);
        if (!(cOSObject.getObject() instanceof COSDictionary)) {
            throw new IOException("Dictionary object expected at offset " + this.source.getPosition());
        }
        for (COSBase cOSBase : ((COSDictionary) cOSObject.getObject()).getValues()) {
            if (cOSBase instanceof COSObject) {
                COSObject cOSObject2 = (COSObject) cOSBase;
                if (cOSObject2.getObject() == null) {
                    parseDictionaryRecursive(cOSObject2);
                }
            }
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void parseFileObject(Long l, COSObjectKey cOSObjectKey, COSObject cOSObject) throws IOException {
        COSBase cOSBase;
        this.source.seek(l.longValue());
        long objectNumber = readObjectNumber();
        int generationNumber = readGenerationNumber();
        readExpectedString(OBJ_MARKER, true);
        if (objectNumber != cOSObjectKey.getNumber() || generationNumber != cOSObjectKey.getGeneration()) {
            throw new IOException("XREF for " + cOSObjectKey.getNumber() + ":" + cOSObjectKey.getGeneration() + " points to wrong object: " + objectNumber + ":" + generationNumber + " at offset " + l);
        }
        skipSpaces();
        COSBase dirObject = parseDirObject();
        String string = readString();
        if (string.equals(BaseParser.STREAM_STRING)) {
            this.source.rewind(string.getBytes(Charsets.ISO_8859_1).length);
            if (!(dirObject instanceof COSDictionary)) {
                throw new IOException("Stream not preceded by dictionary (offset: " + l + ").");
            }
            COSStream cOSStream = parseCOSStream((COSDictionary) dirObject);
            SecurityHandler securityHandler = this.securityHandler;
            if (securityHandler != null) {
                securityHandler.decryptStream(cOSStream, cOSObjectKey.getNumber(), cOSObjectKey.getGeneration());
            }
            skipSpaces();
            string = readLine();
            cOSBase = cOSStream;
            if (!string.startsWith(BaseParser.ENDOBJ_STRING)) {
                cOSBase = cOSStream;
                if (string.startsWith(BaseParser.ENDSTREAM_STRING)) {
                    string = string.substring(9).trim();
                    cOSBase = cOSStream;
                    if (string.length() == 0) {
                        string = readLine();
                        cOSBase = cOSStream;
                    }
                }
            }
        } else {
            SecurityHandler securityHandler2 = this.securityHandler;
            cOSBase = dirObject;
            if (securityHandler2 != null) {
                securityHandler2.decrypt(dirObject, cOSObjectKey.getNumber(), cOSObjectKey.getGeneration());
                cOSBase = dirObject;
            }
        }
        cOSObject.setObject(cOSBase);
        if (string.startsWith(BaseParser.ENDOBJ_STRING)) {
            return;
        }
        if (!this.isLenient) {
            throw new IOException("Object (" + objectNumber + ":" + generationNumber + ") at offset " + l + " does not end with 'endobj' but with '" + string + OperatorName.SHOW_TEXT_LINE);
        }
        Log.w("PdfBox-Android", "Object (" + objectNumber + ":" + generationNumber + ") at offset " + l + " does not end with 'endobj' but with '" + string + OperatorName.SHOW_TEXT_LINE);
    }

    private boolean parseHeader(String str, String str2) throws IOException {
        String line = readLine();
        if (!line.contains(str)) {
            line = readLine();
            while (!line.contains(str) && (line.length() <= 0 || !Character.isDigit(line.charAt(0)))) {
                line = readLine();
            }
        }
        if (!line.contains(str)) {
            this.source.seek(0L);
            return false;
        }
        int iIndexOf = line.indexOf(str);
        if (iIndexOf > 0) {
            line = line.substring(iIndexOf);
        }
        if (line.startsWith(str)) {
            if (!line.matches(str + "\\d.\\d")) {
                if (line.length() < str.length() + 3) {
                    line = str + str2;
                    Log.d("PdfBox-Android", "No version found, set to " + str2 + " as default.");
                } else {
                    String str3 = line.substring(str.length() + 3, line.length()) + "\n";
                    line = line.substring(0, str.length() + 3);
                    this.source.rewind(str3.getBytes(Charsets.ISO_8859_1).length);
                }
            }
        }
        float f2 = -1.0f;
        try {
            String[] strArrSplit = line.split("-");
            if (strArrSplit.length == 2) {
                f2 = Float.parseFloat(strArrSplit[1]);
            }
        } catch (NumberFormatException e2) {
            Log.d("PdfBox-Android", "Can't parse the header version.", e2);
        }
        if (f2 < 0.0f) {
            if (!this.isLenient) {
                throw new IOException("Error getting header version: " + line);
            }
            f2 = 1.7f;
        }
        this.document.setVersion(f2);
        this.source.seek(0L);
        return true;
    }

    private void parseObjectStream(int i2) throws IOException {
        COSBase objectDynamically = parseObjectDynamically(i2, 0, true);
        if (objectDynamically instanceof COSStream) {
            try {
                PDFObjectStreamParser pDFObjectStreamParser = new PDFObjectStreamParser((COSStream) objectDynamically, this.document);
                try {
                    pDFObjectStreamParser.parse();
                    for (COSObject cOSObject : pDFObjectStreamParser.getObjects()) {
                        COSObjectKey cOSObjectKey = new COSObjectKey(cOSObject);
                        Long l = this.xrefTrailerResolver.getXrefTable().get(cOSObjectKey);
                        if (l != null && l.longValue() == (-i2)) {
                            this.document.getObjectFromPool(cOSObjectKey).setObject(cOSObject.getObject());
                        }
                    }
                } catch (IOException e2) {
                    if (!this.isLenient) {
                        throw e2;
                    }
                    Log.d("PdfBox-Android", "Stop reading object stream " + i2 + " due to an exception", e2);
                }
            } catch (IOException e3) {
                if (!this.isLenient) {
                    throw e3;
                }
                Log.e("PdfBox-Android", "object stream " + i2 + " could not be parsed due to an exception", e3);
            }
        }
    }

    private long parseStartXref() throws IOException {
        if (!isString(STARTXREF)) {
            return -1L;
        }
        readString();
        skipSpaces();
        return readLong();
    }

    private boolean parseTrailer() throws IOException {
        this.trailerOffset = this.source.getPosition();
        if (this.isLenient) {
            int iPeek = this.source.peek();
            while (iPeek != 116 && BaseParser.isDigit(iPeek)) {
                if (this.source.getPosition() == this.trailerOffset) {
                    Log.w("PdfBox-Android", "Expected trailer object at offset " + this.trailerOffset + ", keep trying");
                }
                readLine();
                iPeek = this.source.peek();
            }
        }
        if (this.source.peek() != 116) {
            return false;
        }
        long position = this.source.getPosition();
        String line = readLine();
        if (!line.trim().equals("trailer")) {
            if (!line.startsWith("trailer")) {
                return false;
            }
            this.source.seek(position + ((long) 7));
        }
        skipSpaces();
        this.xrefTrailerResolver.setTrailer(parseCOSDictionary());
        skipSpaces();
        return true;
    }

    private long parseXrefObjStream(long j, boolean z) throws IOException {
        long objectNumber = readObjectNumber();
        this.document.setHighestXRefObjectNumber(Math.max(this.document.getHighestXRefObjectNumber(), objectNumber));
        readGenerationNumber();
        readExpectedString(OBJ_MARKER, true);
        COSDictionary cOSDictionary = parseCOSDictionary();
        COSStream cOSStream = parseCOSStream(cOSDictionary);
        parseXrefStream(cOSStream, j, z);
        cOSStream.close();
        return cOSDictionary.getLong(COSName.PREV);
    }

    private void parseXrefStream(COSStream cOSStream, long j, boolean z) throws IOException {
        if (z) {
            this.xrefTrailerResolver.nextXrefObj(j, XrefTrailerResolver.XRefType.STREAM);
            this.xrefTrailerResolver.setTrailer(cOSStream);
        }
        new PDFXrefStreamParser(cOSStream, this.document, this.xrefTrailerResolver).parse();
    }

    private void prepareDecryption() throws IOException {
        COSBase item;
        DecryptionMaterial standardDecryptionMaterial;
        if (this.encryption != null || (item = this.document.getTrailer().getItem(COSName.ENCRYPT)) == null || (item instanceof COSNull)) {
            return;
        }
        if (item instanceof COSObject) {
            parseDictionaryRecursive((COSObject) item);
        }
        try {
            try {
                this.encryption = new PDEncryption(this.document.getEncryptionDictionary());
                if (this.keyStoreInputStream != null) {
                    KeyStore keyStore = KeyStore.getInstance("PKCS12");
                    keyStore.load(this.keyStoreInputStream, this.password.toCharArray());
                    standardDecryptionMaterial = new PublicKeyDecryptionMaterial(keyStore, this.keyAlias, this.password);
                } else {
                    standardDecryptionMaterial = new StandardDecryptionMaterial(this.password);
                }
                SecurityHandler securityHandler = this.encryption.getSecurityHandler();
                this.securityHandler = securityHandler;
                securityHandler.prepareForDecryption(this.encryption, this.document.getDocumentID(), standardDecryptionMaterial);
                this.accessPermission = this.securityHandler.getCurrentAccessPermission();
            } catch (IOException e2) {
                throw e2;
            } catch (Exception e3) {
                throw new IOException("Error (" + e3.getClass().getSimpleName() + ") while creating security handler for decryption", e3);
            }
        } finally {
            InputStream inputStream = this.keyStoreInputStream;
            if (inputStream != null) {
                IOUtils.closeQuietly(inputStream);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void readUntilEndStream(java.io.OutputStream r12) throws java.io.IOException {
        /*
            r11 = this;
            byte[] r0 = com.tom_roush.pdfbox.pdfparser.COSParser.ENDSTREAM
            r1 = 0
            r2 = 0
        L4:
            com.tom_roush.pdfbox.io.RandomAccessRead r3 = r11.source
            byte[] r4 = r11.strmBuf
            int r5 = 2048 - r2
            int r3 = r3.read(r4, r2, r5)
            if (r3 <= 0) goto L7b
            int r3 = r3 + r2
            int r4 = r3 + (-5)
            r5 = r2
        L14:
            if (r2 >= r3) goto L5e
            int r6 = r2 + 5
            r7 = 1
            if (r5 != 0) goto L2b
            if (r6 >= r4) goto L2b
            byte[] r8 = r11.strmBuf
            r8 = r8[r6]
            r9 = 116(0x74, float:1.63E-43)
            if (r8 > r9) goto L29
            r9 = 97
            if (r8 >= r9) goto L2b
        L29:
            r2 = r6
            goto L5c
        L2b:
            byte[] r6 = r11.strmBuf
            r6 = r6[r2]
            r8 = r0[r5]
            if (r6 != r8) goto L3b
            int r5 = r5 + 1
            int r6 = r0.length
            if (r5 != r6) goto L5c
            int r2 = r2 + 1
            goto L5e
        L3b:
            r0 = 3
            if (r5 != r0) goto L47
            byte[] r0 = com.tom_roush.pdfbox.pdfparser.COSParser.ENDOBJ
            r8 = r0[r5]
            if (r6 != r8) goto L47
            int r5 = r5 + 1
            goto L5c
        L47:
            r0 = 101(0x65, float:1.42E-43)
            if (r6 != r0) goto L4d
            r0 = 1
            goto L57
        L4d:
            r0 = 110(0x6e, float:1.54E-43)
            if (r6 != r0) goto L56
            r0 = 7
            if (r5 != r0) goto L56
            r0 = 2
            goto L57
        L56:
            r0 = 0
        L57:
            byte[] r5 = com.tom_roush.pdfbox.pdfparser.COSParser.ENDSTREAM
            r10 = r5
            r5 = r0
            r0 = r10
        L5c:
            int r2 = r2 + r7
            goto L14
        L5e:
            int r2 = r2 - r5
            int r2 = java.lang.Math.max(r1, r2)
            if (r2 <= 0) goto L6a
            byte[] r4 = r11.strmBuf
            r12.write(r4, r1, r2)
        L6a:
            int r4 = r0.length
            if (r5 != r4) goto L74
            com.tom_roush.pdfbox.io.RandomAccessRead r0 = r11.source
            int r3 = r3 - r2
            r0.rewind(r3)
            goto L7b
        L74:
            byte[] r2 = r11.strmBuf
            java.lang.System.arraycopy(r0, r1, r2, r1, r5)
            r2 = r5
            goto L4
        L7b:
            r12.flush()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tom_roush.pdfbox.pdfparser.COSParser.readUntilEndStream(java.io.OutputStream):void");
    }

    private void readValidStream(OutputStream outputStream, COSNumber cOSNumber) throws IOException {
        long jLongValue = cOSNumber.longValue();
        while (jLongValue > 0) {
            int i2 = jLongValue > PlaybackStateCompat.ACTION_PLAY_FROM_URI ? 8192 : (int) jLongValue;
            int i3 = this.source.read(this.streamCopyBuf, 0, i2);
            if (i3 <= 0) {
                throw new IOException("read error at offset " + this.source.getPosition() + ": expected " + i2 + " bytes, but read() returns " + i3);
            }
            outputStream.write(this.streamCopyBuf, 0, i3);
            jLongValue -= (long) i3;
        }
    }

    private COSDictionary retrieveCOSDictionary(COSObject cOSObject) throws IOException {
        COSObjectKey cOSObjectKey = new COSObjectKey(cOSObject);
        Long l = this.bfSearchCOSObjectKeyOffsets.get(cOSObjectKey);
        if (l == null) {
            return null;
        }
        long position = this.source.getPosition();
        COSDictionary cOSDictionaryRetrieveCOSDictionary = retrieveCOSDictionary(cOSObjectKey, l.longValue());
        this.source.seek(position);
        return cOSDictionaryRetrieveCOSDictionary;
    }

    private boolean searchForTrailerItems(COSDictionary cOSDictionary) throws IOException {
        COSObject objectFromPool;
        COSObject cOSObjectCompareCOSObjects = null;
        COSObject cOSObjectCompareCOSObjects2 = null;
        Long value = null;
        Long value2 = null;
        for (Map.Entry<COSObjectKey, Long> entry : this.bfSearchCOSObjectKeyOffsets.entrySet()) {
            COSDictionary cOSDictionaryRetrieveCOSDictionary = retrieveCOSDictionary(entry.getKey(), entry.getValue().longValue());
            if (cOSDictionaryRetrieveCOSDictionary != null) {
                if (isCatalog(cOSDictionaryRetrieveCOSDictionary)) {
                    COSObject objectFromPool2 = this.document.getObjectFromPool(entry.getKey());
                    cOSObjectCompareCOSObjects = compareCOSObjects(objectFromPool2, entry.getValue(), cOSObjectCompareCOSObjects, value);
                    if (cOSObjectCompareCOSObjects == objectFromPool2) {
                        value = entry.getValue();
                    }
                } else if (isInfo(cOSDictionaryRetrieveCOSDictionary) && (cOSObjectCompareCOSObjects2 = compareCOSObjects((objectFromPool = this.document.getObjectFromPool(entry.getKey())), entry.getValue(), cOSObjectCompareCOSObjects2, value2)) == objectFromPool) {
                    value2 = entry.getValue();
                }
            }
        }
        if (cOSObjectCompareCOSObjects != null) {
            cOSDictionary.setItem(COSName.ROOT, (COSBase) cOSObjectCompareCOSObjects);
        }
        if (cOSObjectCompareCOSObjects2 != null) {
            cOSDictionary.setItem(COSName.INFO, (COSBase) cOSObjectCompareCOSObjects2);
        }
        return cOSObjectCompareCOSObjects != null;
    }

    private long searchNearestValue(List<Long> list, long j) {
        int size = list.size();
        Long lValueOf = null;
        int i2 = -1;
        for (int i3 = 0; i3 < size; i3++) {
            long jLongValue = j - list.get(i3).longValue();
            if (lValueOf == null || Math.abs(lValueOf.longValue()) > Math.abs(jLongValue)) {
                lValueOf = Long.valueOf(jLongValue);
                i2 = i3;
            }
        }
        if (i2 > -1) {
            return list.get(i2).longValue();
        }
        return -1L;
    }

    private boolean validateStreamLength(long j) throws IOException {
        long position = this.source.getPosition();
        long j2 = position + j;
        boolean z = false;
        if (j2 > this.fileLen) {
            Log.w("PdfBox-Android", "The end of the stream is out of range, using workaround to read the stream, stream start position: " + position + ", length: " + j + ", expected end position: " + j2);
        } else {
            this.source.seek(j2);
            skipSpaces();
            if (isString(ENDSTREAM)) {
                z = true;
            } else {
                Log.w("PdfBox-Android", "The end of the stream doesn't point to the correct offset, using workaround to read the stream, stream start position: " + position + ", length: " + j + ", expected end position: " + j2);
            }
            this.source.seek(position);
        }
        return z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean validateXrefOffsets(Map<COSObjectKey, Long> map) throws IOException {
        if (map == 0) {
            return true;
        }
        HashMap map2 = new HashMap();
        for (Map.Entry entry : map.entrySet()) {
            COSObjectKey cOSObjectKey = (COSObjectKey) entry.getKey();
            Long l = (Long) entry.getValue();
            if (l != null && l.longValue() >= 0) {
                COSObjectKey cOSObjectKeyFindObjectKey = findObjectKey(cOSObjectKey, l.longValue());
                if (cOSObjectKeyFindObjectKey == null) {
                    Log.d("PdfBox-Android", "Stop checking xref offsets as at least one (" + cOSObjectKey + ") couldn't be dereferenced");
                    return false;
                }
                if (cOSObjectKeyFindObjectKey != cOSObjectKey) {
                    map2.put(cOSObjectKey, cOSObjectKeyFindObjectKey);
                }
            }
        }
        for (Map.Entry entry2 : map2.entrySet()) {
            map.put(entry2.getValue(), map.remove(entry2.getKey()));
        }
        return true;
    }

    public void checkPages(COSDictionary cOSDictionary) {
        if (!this.trailerWasRebuild || cOSDictionary == null) {
            return;
        }
        COSBase dictionaryObject = cOSDictionary.getDictionaryObject(COSName.PAGES);
        if (dictionaryObject instanceof COSDictionary) {
            checkPagesDictionary((COSDictionary) dictionaryObject, new HashSet());
        }
    }

    public AccessPermission getAccessPermission() throws IOException {
        if (this.document != null) {
            return this.accessPermission;
        }
        throw new IOException("You must parse the document first before calling getAccessPermission()");
    }

    public COSDocument getDocument() throws IOException {
        COSDocument cOSDocument = this.document;
        if (cOSDocument != null) {
            return cOSDocument;
        }
        throw new IOException("You must parse the document first before calling getDocument()");
    }

    public PDEncryption getEncryption() throws IOException {
        if (this.document != null) {
            return this.encryption;
        }
        throw new IOException("You must parse the document first before calling getEncryption()");
    }

    public final long getStartxrefOffset() throws IOException {
        try {
            long j = this.fileLen;
            int i2 = this.readTrailBytes;
            if (j < i2) {
                i2 = (int) j;
            }
            byte[] bArr = new byte[i2];
            long j2 = j - ((long) i2);
            this.source.seek(j2);
            int i3 = 0;
            while (i3 < i2) {
                int i4 = i2 - i3;
                int i5 = this.source.read(bArr, i3, i4);
                if (i5 < 1) {
                    throw new IOException("No more bytes to read for trailing buffer, but expected: " + i4);
                }
                i3 += i5;
            }
            this.source.seek(0L);
            char[] cArr = EOF_MARKER;
            int iLastIndexOf = lastIndexOf(cArr, bArr, i2);
            if (iLastIndexOf >= 0) {
                i2 = iLastIndexOf;
            } else {
                if (!this.isLenient) {
                    throw new IOException("Missing end of file marker '" + new String(cArr) + OperatorName.SHOW_TEXT_LINE);
                }
                Log.d("PdfBox-Android", "Missing end of file marker '" + new String(cArr) + OperatorName.SHOW_TEXT_LINE);
            }
            int iLastIndexOf2 = lastIndexOf(STARTXREF, bArr, i2);
            if (iLastIndexOf2 >= 0) {
                return j2 + ((long) iLastIndexOf2);
            }
            throw new IOException("Missing 'startxref' marker.");
        } catch (Throwable th) {
            this.source.seek(0L);
            throw th;
        }
    }

    public boolean isCatalog(COSDictionary cOSDictionary) {
        return COSName.CATALOG.equals(cOSDictionary.getCOSName(COSName.TYPE));
    }

    public boolean isLenient() {
        return this.isLenient;
    }

    public int lastIndexOf(char[] cArr, byte[] bArr, int i2) {
        int length = cArr.length - 1;
        char c2 = cArr[length];
        while (true) {
            int i3 = length;
            while (true) {
                i2--;
                if (i2 < 0) {
                    return -1;
                }
                if (bArr[i2] == c2) {
                    i3--;
                    if (i3 < 0) {
                        return i2;
                    }
                    c2 = cArr[i3];
                } else if (i3 < length) {
                    break;
                }
            }
            c2 = cArr[length];
        }
    }

    public COSStream parseCOSStream(COSDictionary cOSDictionary) throws IOException {
        COSStream cOSStreamCreateCOSStream = this.document.createCOSStream(cOSDictionary);
        readString();
        skipWhiteSpaces();
        COSName cOSName = COSName.LENGTH;
        COSNumber length = getLength(cOSDictionary.getItem(cOSName), cOSDictionary.getCOSName(COSName.TYPE));
        if (length == null) {
            if (!this.isLenient) {
                throw new IOException("Missing length for stream.");
            }
            Log.w("PdfBox-Android", "The stream doesn't provide any stream length, using fallback readUntilEnd, at offset " + this.source.getPosition());
        }
        if (length == null || !validateStreamLength(length.longValue())) {
            OutputStream outputStreamCreateRawOutputStream = cOSStreamCreateCOSStream.createRawOutputStream();
            try {
                readUntilEndStream(new EndstreamOutputStream(outputStreamCreateRawOutputStream));
                outputStreamCreateRawOutputStream.close();
                if (length != null) {
                    cOSStreamCreateCOSStream.setItem(cOSName, (COSBase) length);
                }
            } catch (Throwable th) {
                outputStreamCreateRawOutputStream.close();
                if (length != null) {
                    cOSStreamCreateCOSStream.setItem(COSName.LENGTH, (COSBase) length);
                }
                throw th;
            }
        } else {
            OutputStream outputStreamCreateRawOutputStream2 = cOSStreamCreateCOSStream.createRawOutputStream();
            try {
                readValidStream(outputStreamCreateRawOutputStream2, length);
                outputStreamCreateRawOutputStream2.close();
                cOSStreamCreateCOSStream.setItem(cOSName, (COSBase) length);
            } catch (Throwable th2) {
                outputStreamCreateRawOutputStream2.close();
                cOSStreamCreateCOSStream.setItem(COSName.LENGTH, (COSBase) length);
                throw th2;
            }
        }
        String string = readString();
        if (string.equals(BaseParser.ENDOBJ_STRING) && this.isLenient) {
            Log.w("PdfBox-Android", "stream ends with 'endobj' instead of 'endstream' at offset " + this.source.getPosition());
            this.source.rewind(ENDOBJ.length);
        } else if (string.length() > 9 && this.isLenient && string.startsWith(BaseParser.ENDSTREAM_STRING)) {
            Log.w("PdfBox-Android", "stream ends with '" + string + "' instead of 'endstream' at offset " + this.source.getPosition());
            this.source.rewind(string.substring(9).getBytes(Charsets.ISO_8859_1).length);
        } else if (!string.equals(BaseParser.ENDSTREAM_STRING)) {
            throw new IOException("Error reading stream, expected='endstream' actual='" + string + "' at offset " + this.source.getPosition());
        }
        return cOSStreamCreateCOSStream;
    }

    /* JADX WARN: Code restructure failed: missing block: B:112:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x01bc, code lost:
    
        throw new java.io.IOException(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x01ce, code lost:
    
        if (r2.isEmpty() == false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x01d1, code lost:
    
        r5 = ((java.util.List) r2.remove(r2.firstKey())).iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x01e3, code lost:
    
        if (r5.hasNext() == false) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x01e5, code lost:
    
        r7 = (com.tom_roush.pdfbox.cos.COSObject) r5.next();
        r8 = parseObjectDynamically(r7, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x01ef, code lost:
    
        if (r8 == null) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x01f1, code lost:
    
        r7.setObject(r8);
        addNewToList(r1, r8, r4);
        r3.add(java.lang.Long.valueOf(getObjectId(r7)));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void parseDictObjects(com.tom_roush.pdfbox.cos.COSDictionary r19, com.tom_roush.pdfbox.cos.COSName... r20) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 515
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tom_roush.pdfbox.pdfparser.COSParser.parseDictObjects(com.tom_roush.pdfbox.cos.COSDictionary, com.tom_roush.pdfbox.cos.COSName[]):void");
    }

    public boolean parseFDFHeader() throws IOException {
        return parseHeader(FDF_HEADER, "1.0");
    }

    public final COSBase parseObjectDynamically(COSObject cOSObject, boolean z) throws IOException {
        return parseObjectDynamically(cOSObject.getObjectNumber(), cOSObject.getGenerationNumber(), z);
    }

    public boolean parsePDFHeader() throws IOException {
        return parseHeader(PDF_HEADER, PDF_DEFAULT_VERSION);
    }

    public COSBase parseTrailerValuesDynamically(COSDictionary cOSDictionary) throws IOException {
        for (COSBase cOSBase : cOSDictionary.getValues()) {
            if (cOSBase instanceof COSObject) {
                parseObjectDynamically((COSObject) cOSBase, false);
            }
        }
        COSObject cOSObject = cOSDictionary.getCOSObject(COSName.ROOT);
        if (cOSObject != null) {
            return cOSObject.getObject();
        }
        throw new IOException("Missing root object specification in trailer.");
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0117, code lost:
    
        throw new java.io.IOException("Expected trailer object at offset " + r17.source.getPosition());
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x013a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.tom_roush.pdfbox.cos.COSDictionary parseXref(long r18) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 401
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tom_roush.pdfbox.pdfparser.COSParser.parseXref(long):com.tom_roush.pdfbox.cos.COSDictionary");
    }

    public boolean parseXrefTable(long j) throws IOException {
        if (this.source.peek() != 120 || !readString().trim().equals("xref")) {
            return false;
        }
        String string = readString();
        this.source.rewind(string.getBytes(Charsets.ISO_8859_1).length);
        this.xrefTrailerResolver.nextXrefObj(j, XrefTrailerResolver.XRefType.TABLE);
        if (string.startsWith("trailer")) {
            Log.w("PdfBox-Android", "skipping empty xref table");
            return false;
        }
        do {
            String line = readLine();
            String[] strArrSplit = line.split("\\s");
            if (strArrSplit.length != 2) {
                Log.w("PdfBox-Android", "Unexpected XRefTable Entry: " + line);
                return false;
            }
            try {
                long j2 = Long.parseLong(strArrSplit[0]);
                try {
                    int i2 = Integer.parseInt(strArrSplit[1]);
                    skipSpaces();
                    int i3 = 0;
                    while (true) {
                        if (i3 >= i2 || this.source.isEOF() || isEndOfName((char) this.source.peek()) || this.source.peek() == 116) {
                            break;
                        }
                        String line2 = readLine();
                        String[] strArrSplit2 = line2.split("\\s");
                        if (strArrSplit2.length < 3) {
                            Log.w("PdfBox-Android", "invalid xref line: " + line2);
                            break;
                        }
                        if (strArrSplit2[strArrSplit2.length - 1].equals(OperatorName.ENDPATH)) {
                            try {
                                long j3 = Long.parseLong(strArrSplit2[0]);
                                if (j3 > 0) {
                                    this.xrefTrailerResolver.setXRef(new COSObjectKey(j2, Integer.parseInt(strArrSplit2[1])), j3);
                                }
                            } catch (NumberFormatException e2) {
                                throw new IOException(e2);
                            }
                        } else if (!strArrSplit2[2].equals(OperatorName.FILL_NON_ZERO)) {
                            throw new IOException("Corrupt XRefTable Entry - ObjID:" + j2);
                        }
                        j2++;
                        skipSpaces();
                        i3++;
                    }
                    skipSpaces();
                } catch (NumberFormatException unused) {
                    Log.w("PdfBox-Android", "XRefTable: invalid number of objects: " + line);
                    return false;
                }
            } catch (NumberFormatException unused2) {
                Log.w("PdfBox-Android", "XRefTable: invalid ID for the first object: " + line);
                return false;
            }
        } while (isDigit());
        return true;
    }

    public final COSDictionary rebuildTrailer() throws Throwable {
        COSDictionary trailer;
        bfSearchForObjects();
        if (this.bfSearchCOSObjectKeyOffsets != null) {
            this.xrefTrailerResolver.reset();
            this.xrefTrailerResolver.nextXrefObj(0L, XrefTrailerResolver.XRefType.TABLE);
            for (Map.Entry<COSObjectKey, Long> entry : this.bfSearchCOSObjectKeyOffsets.entrySet()) {
                this.xrefTrailerResolver.setXRef(entry.getKey(), entry.getValue().longValue());
            }
            this.xrefTrailerResolver.setStartxref(0L);
            trailer = this.xrefTrailerResolver.getTrailer();
            getDocument().setTrailer(trailer);
            boolean z = false;
            if (!bfSearchForTrailer(trailer) && !searchForTrailerItems(trailer)) {
                bfSearchForObjStreams();
                searchForTrailerItems(trailer);
                z = true;
            }
            prepareDecryption();
            if (!z) {
                bfSearchForObjStreams();
            }
        } else {
            trailer = null;
        }
        this.trailerWasRebuild = true;
        return trailer;
    }

    public COSDictionary retrieveTrailer() throws IOException {
        boolean zIsLenient;
        COSDictionary xref = null;
        try {
            long startxrefOffset = getStartxrefOffset();
            if (startxrefOffset > -1) {
                xref = parseXref(startxrefOffset);
                zIsLenient = false;
            } else {
                zIsLenient = isLenient();
            }
        } catch (IOException e2) {
            if (!isLenient()) {
                throw e2;
            }
            zIsLenient = true;
        }
        if (xref != null && xref.getItem(COSName.ROOT) == null) {
            zIsLenient = isLenient();
        }
        if (zIsLenient) {
            return rebuildTrailer();
        }
        prepareDecryption();
        Map<COSObjectKey, Long> map = this.bfSearchCOSObjectKeyOffsets;
        if (map == null || map.isEmpty()) {
            return xref;
        }
        bfSearchForObjStreams();
        return xref;
    }

    public void setEOFLookupRange(int i2) {
        if (i2 > 15) {
            this.readTrailBytes = i2;
        }
    }

    public void setLenient(boolean z) {
        if (this.initialParseDone) {
            throw new IllegalArgumentException("Cannot change leniency after parsing");
        }
        this.isLenient = z;
    }

    private void addNewToList(Queue<COSBase> queue, COSBase cOSBase, Set<Long> set) {
        if (cOSBase instanceof COSObject) {
            if (set.add(Long.valueOf(getObjectId((COSObject) cOSBase)))) {
                queue.add(cOSBase);
            }
        } else if ((cOSBase instanceof COSDictionary) || (cOSBase instanceof COSArray)) {
            queue.add(cOSBase);
        }
    }

    public COSBase parseObjectDynamically(long j, int i2, boolean z) throws IOException {
        Map<COSObjectKey, Long> map;
        COSObjectKey cOSObjectKey = new COSObjectKey(j, i2);
        COSObject objectFromPool = this.document.getObjectFromPool(cOSObjectKey);
        if (objectFromPool.getObject() == null) {
            Long l = this.document.getXrefTable().get(cOSObjectKey);
            if (l == null && this.isLenient && (map = this.bfSearchCOSObjectKeyOffsets) != null && (l = map.get(cOSObjectKey)) != null) {
                Log.d("PdfBox-Android", "Set missing offset " + l + " for object " + cOSObjectKey);
                this.document.getXrefTable().put(cOSObjectKey, l);
            }
            if (z && (l == null || l.longValue() <= 0)) {
                throw new IOException("Object must be defined and must not be compressed object: " + cOSObjectKey.getNumber() + ":" + cOSObjectKey.getGeneration());
            }
            if (l == null && this.isLenient && this.bfSearchCOSObjectKeyOffsets == null) {
                bfSearchForObjects();
                Map<COSObjectKey, Long> map2 = this.bfSearchCOSObjectKeyOffsets;
                if (map2 != null && !map2.isEmpty()) {
                    Log.d("PdfBox-Android", "Add all new read objects from brute force search to the xref table");
                    Map<COSObjectKey, Long> xrefTable = this.document.getXrefTable();
                    for (Map.Entry<COSObjectKey, Long> entry : this.bfSearchCOSObjectKeyOffsets.entrySet()) {
                        COSObjectKey key = entry.getKey();
                        if (!xrefTable.containsKey(key)) {
                            xrefTable.put(key, entry.getValue());
                        }
                    }
                    l = xrefTable.get(cOSObjectKey);
                }
            }
            if (l == null) {
                objectFromPool.setObject(COSNull.NULL);
            } else if (l.longValue() > 0) {
                parseFileObject(l, cOSObjectKey, objectFromPool);
            } else {
                parseObjectStream((int) (-l.longValue()));
            }
        }
        return objectFromPool.getObject();
    }

    private COSDictionary retrieveCOSDictionary(COSObjectKey cOSObjectKey, long j) throws IOException {
        if (j < 0) {
            COSObject objectFromPool = this.document.getObjectFromPool(cOSObjectKey);
            if (objectFromPool.getObject() == null) {
                parseObjectStream((int) (-j));
            }
            COSBase object = objectFromPool.getObject();
            if (object instanceof COSDictionary) {
                return (COSDictionary) object;
            }
            return null;
        }
        this.source.seek(j);
        readObjectNumber();
        readGenerationNumber();
        readExpectedString(OBJ_MARKER, true);
        if (this.source.peek() != 60) {
            return null;
        }
        try {
            return parseCOSDictionary();
        } catch (IOException unused) {
            Log.d("PdfBox-Android", "Skipped object " + cOSObjectKey + ", either it's corrupt or not a dictionary");
            return null;
        }
    }

    private boolean isString(char[] cArr) throws IOException {
        long position = this.source.getPosition();
        int length = cArr.length;
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                z = true;
                break;
            }
            if (this.source.read() != cArr[i2]) {
                break;
            }
            i2++;
        }
        this.source.seek(position);
        return z;
    }

    public COSParser(RandomAccessRead randomAccessRead, String str, InputStream inputStream, String str2) {
        super(new RandomAccessSource(randomAccessRead));
        this.strmBuf = new byte[2048];
        this.keyStoreInputStream = null;
        this.password = "";
        this.keyAlias = null;
        this.isLenient = true;
        this.initialParseDone = false;
        this.trailerWasRebuild = false;
        this.bfSearchCOSObjectKeyOffsets = null;
        this.lastEOFMarker = null;
        this.bfSearchXRefTablesOffsets = null;
        this.bfSearchXRefStreamsOffsets = null;
        this.encryption = null;
        this.securityHandler = null;
        this.readTrailBytes = 2048;
        this.xrefTrailerResolver = new XrefTrailerResolver();
        this.streamCopyBuf = new byte[8192];
        this.source = randomAccessRead;
        this.password = str;
        this.keyAlias = str2;
        this.keyStoreInputStream = inputStream;
    }
}
