package com.tom_roush.pdfbox.pdfwriter;

import android.util.Log;
import com.tom_roush.pdfbox.contentstream.operator.OperatorName;
import com.tom_roush.pdfbox.cos.COSArray;
import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSBoolean;
import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.cos.COSDocument;
import com.tom_roush.pdfbox.cos.COSFloat;
import com.tom_roush.pdfbox.cos.COSInteger;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.cos.COSNull;
import com.tom_roush.pdfbox.cos.COSNumber;
import com.tom_roush.pdfbox.cos.COSObject;
import com.tom_roush.pdfbox.cos.COSObjectKey;
import com.tom_roush.pdfbox.cos.COSStream;
import com.tom_roush.pdfbox.cos.COSString;
import com.tom_roush.pdfbox.cos.COSUpdateInfo;
import com.tom_roush.pdfbox.cos.ICOSVisitor;
import com.tom_roush.pdfbox.io.IOUtils;
import com.tom_roush.pdfbox.io.RandomAccessInputStream;
import com.tom_roush.pdfbox.io.RandomAccessRead;
import com.tom_roush.pdfbox.pdfparser.BaseParser;
import com.tom_roush.pdfbox.pdfparser.PDFXRefStream;
import com.tom_roush.pdfbox.pdmodel.PDDocument;
import com.tom_roush.pdfbox.pdmodel.encryption.SecurityHandler;
import com.tom_roush.pdfbox.pdmodel.fdf.FDFDocument;
import com.tom_roush.pdfbox.pdmodel.interactive.digitalsignature.COSFilterInputStream;
import com.tom_roush.pdfbox.pdmodel.interactive.digitalsignature.SignatureInterface;
import com.tom_roush.pdfbox.util.Charsets;
import com.tom_roush.pdfbox.util.Hex;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.SequenceInputStream;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.apache.commons.codec.net.URLCodec;

/* JADX INFO: loaded from: classes2.dex */
public class COSWriter implements ICOSVisitor, Closeable {
    public static final byte[] ARRAY_CLOSE;
    public static final byte[] ARRAY_OPEN;
    public static final byte[] COMMENT;
    public static final byte[] DICT_CLOSE;
    public static final byte[] DICT_OPEN;
    public static final byte[] ENDOBJ;
    public static final byte[] ENDSTREAM;
    public static final byte[] EOF;
    public static final byte[] GARBAGE;
    public static final byte[] OBJ;
    public static final byte[] REFERENCE;
    public static final byte[] SPACE;
    public static final byte[] STARTXREF;
    public static final byte[] STREAM;
    public static final byte[] TRAILER;
    public static final byte[] VERSION;
    public static final byte[] XREF;
    public static final byte[] XREF_FREE;
    public static final byte[] XREF_USED;
    private final Set<COSBase> actualsAdded;
    private COSArray byteRangeArray;
    private long byteRangeLength;
    private long byteRangeOffset;
    private COSObjectKey currentObjectKey;
    private FDFDocument fdfDocument;
    private final NumberFormat formatXrefGeneration;
    private final NumberFormat formatXrefOffset;
    private byte[] incrementPart;
    private RandomAccessRead incrementalInput;
    private OutputStream incrementalOutput;
    private boolean incrementalUpdate;
    private final Map<COSObjectKey, COSBase> keyObject;
    private long number;
    private final Map<COSBase, COSObjectKey> objectKeys;
    private final Deque<COSBase> objectsToWrite;
    private final Set<COSBase> objectsToWriteSet;
    private OutputStream output;
    private PDDocument pdDocument;
    private boolean reachedSignature;
    private SignatureInterface signatureInterface;
    private long signatureLength;
    private long signatureOffset;
    private COSStandardOutputStream standardOutput;
    private long startxref;
    private boolean willEncrypt;
    private final Set<COSBase> writtenObjects;
    private final List<COSWriterXRefEntry> xRefEntries;

    static {
        Charset charset = Charsets.US_ASCII;
        DICT_OPEN = "<<".getBytes(charset);
        DICT_CLOSE = ">>".getBytes(charset);
        SPACE = new byte[]{32};
        COMMENT = new byte[]{URLCodec.ESCAPE_CHAR};
        VERSION = "PDF-1.4".getBytes(charset);
        GARBAGE = new byte[]{-10, -28, -4, -33};
        EOF = "%%EOF".getBytes(charset);
        REFERENCE = "R".getBytes(charset);
        XREF = "xref".getBytes(charset);
        XREF_FREE = OperatorName.FILL_NON_ZERO.getBytes(charset);
        XREF_USED = OperatorName.ENDPATH.getBytes(charset);
        TRAILER = "trailer".getBytes(charset);
        STARTXREF = "startxref".getBytes(charset);
        OBJ = "obj".getBytes(charset);
        ENDOBJ = BaseParser.ENDOBJ_STRING.getBytes(charset);
        ARRAY_OPEN = "[".getBytes(charset);
        ARRAY_CLOSE = "]".getBytes(charset);
        STREAM = BaseParser.STREAM_STRING.getBytes(charset);
        ENDSTREAM = BaseParser.ENDSTREAM_STRING.getBytes(charset);
    }

    public COSWriter(OutputStream outputStream) {
        Locale locale = Locale.US;
        this.formatXrefOffset = new DecimalFormat("0000000000", DecimalFormatSymbols.getInstance(locale));
        this.formatXrefGeneration = new DecimalFormat("00000", DecimalFormatSymbols.getInstance(locale));
        this.startxref = 0L;
        this.number = 0L;
        this.objectKeys = new Hashtable();
        this.keyObject = new HashMap();
        this.xRefEntries = new ArrayList();
        this.objectsToWriteSet = new HashSet();
        this.objectsToWrite = new LinkedList();
        this.writtenObjects = new HashSet();
        this.actualsAdded = new HashSet();
        this.currentObjectKey = null;
        this.pdDocument = null;
        this.fdfDocument = null;
        this.willEncrypt = false;
        this.incrementalUpdate = false;
        this.reachedSignature = false;
        setOutput(outputStream);
        setStandardOutput(new COSStandardOutputStream(this.output));
    }

    private void addObjectToWrite(COSBase cOSBase) {
        COSObjectKey cOSObjectKey;
        COSBase object = cOSBase instanceof COSObject ? ((COSObject) cOSBase).getObject() : cOSBase;
        if (this.writtenObjects.contains(cOSBase) || this.objectsToWriteSet.contains(cOSBase) || this.actualsAdded.contains(object)) {
            return;
        }
        if (object != null && (cOSObjectKey = this.objectKeys.get(object)) != null) {
            COSBase cOSBase2 = this.keyObject.get(cOSObjectKey);
            if (!isNeedToBeUpdated(cOSBase) && !isNeedToBeUpdated(cOSBase2)) {
                return;
            }
        }
        this.objectsToWrite.add(cOSBase);
        this.objectsToWriteSet.add(cOSBase);
        if (object != null) {
            this.actualsAdded.add(object);
        }
    }

    private void doWriteIncrement() throws IOException {
        IOUtils.copy(new RandomAccessInputStream(this.incrementalInput), this.incrementalOutput);
        this.incrementalOutput.write(((ByteArrayOutputStream) this.output).toByteArray());
    }

    private void doWriteObjects() throws IOException {
        while (this.objectsToWrite.size() > 0) {
            COSBase cOSBaseRemoveFirst = this.objectsToWrite.removeFirst();
            this.objectsToWriteSet.remove(cOSBaseRemoveFirst);
            doWriteObject(cOSBaseRemoveFirst);
        }
    }

    private void doWriteSignature() throws IOException {
        long length = this.incrementalInput.length();
        long j = this.signatureOffset;
        long j2 = this.signatureLength + j;
        long pos = (getStandardOutput().getPos() - (this.signatureLength + length)) - (this.signatureOffset - length);
        String str = "0 " + j + " " + j2 + " " + pos + "]";
        int i2 = 0;
        this.byteRangeArray.set(0, (COSBase) COSInteger.ZERO);
        this.byteRangeArray.set(1, (COSBase) COSInteger.get(j));
        this.byteRangeArray.set(2, (COSBase) COSInteger.get(j2));
        this.byteRangeArray.set(3, (COSBase) COSInteger.get(pos));
        if (str.length() > this.byteRangeLength) {
            throw new IOException("Can't write new byteRange '" + str + "' not enough space: byteRange.length(): " + str.length() + ", byteRangeLength: " + this.byteRangeLength);
        }
        ByteArrayOutputStream byteArrayOutputStream = (ByteArrayOutputStream) this.output;
        byteArrayOutputStream.flush();
        this.incrementPart = byteArrayOutputStream.toByteArray();
        byte[] bytes = str.getBytes(Charsets.ISO_8859_1);
        while (true) {
            long j3 = i2;
            if (j3 >= this.byteRangeLength) {
                break;
            }
            if (i2 >= bytes.length) {
                this.incrementPart[(int) ((this.byteRangeOffset + j3) - length)] = 32;
            } else {
                this.incrementPart[(int) ((this.byteRangeOffset + j3) - length)] = bytes[i2];
            }
            i2++;
        }
        if (this.signatureInterface != null) {
            writeExternalSignature(this.signatureInterface.sign(getDataToSign()));
        }
    }

    private void doWriteXRefInc(COSDocument cOSDocument, long j) throws IOException {
        if (cOSDocument.isXRefStream() || j != -1) {
            PDFXRefStream pDFXRefStream = new PDFXRefStream(cOSDocument);
            Iterator<COSWriterXRefEntry> it = getXRefEntries().iterator();
            while (it.hasNext()) {
                pDFXRefStream.addEntry(it.next());
            }
            COSDictionary trailer = cOSDocument.getTrailer();
            if (this.incrementalUpdate) {
                trailer.setLong(COSName.PREV, cOSDocument.getStartXref());
            } else {
                trailer.removeItem(COSName.PREV);
            }
            pDFXRefStream.addTrailerInfo(trailer);
            pDFXRefStream.setSize(getNumber() + 2);
            setStartxref(getStandardOutput().getPos());
            doWriteObject(pDFXRefStream.getStream());
        }
        if (cOSDocument.isXRefStream() && j == -1) {
            return;
        }
        COSDictionary trailer2 = cOSDocument.getTrailer();
        trailer2.setLong(COSName.PREV, cOSDocument.getStartXref());
        if (j != -1) {
            COSName cOSName = COSName.XREF_STM;
            trailer2.removeItem(cOSName);
            trailer2.setLong(cOSName, getStartxref());
        }
        doWriteXRefTable();
        doWriteTrailer(cOSDocument);
    }

    private void doWriteXRefTable() throws IOException {
        addXRefEntry(COSWriterXRefEntry.getNullEntry());
        Collections.sort(getXRefEntries());
        setStartxref(getStandardOutput().getPos());
        getStandardOutput().write(XREF);
        getStandardOutput().writeEOL();
        Long[] xRefRanges = getXRefRanges(getXRefEntries());
        int length = xRefRanges.length;
        if (length % 2 == 0) {
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3 += 2) {
                long jLongValue = xRefRanges[i3 + 1].longValue();
                writeXrefRange(xRefRanges[i3].longValue(), jLongValue);
                int i4 = 0;
                while (i4 < jLongValue) {
                    writeXrefEntry(this.xRefEntries.get(i2));
                    i4++;
                    i2++;
                }
            }
        }
    }

    private COSObjectKey getObjectKey(COSBase cOSBase) {
        COSBase object = cOSBase instanceof COSObject ? ((COSObject) cOSBase).getObject() : cOSBase;
        COSObjectKey cOSObjectKey = this.objectKeys.get(cOSBase);
        if (cOSObjectKey == null && object != null) {
            cOSObjectKey = this.objectKeys.get(object);
        }
        if (cOSObjectKey == null) {
            setNumber(getNumber() + 1);
            cOSObjectKey = new COSObjectKey(getNumber(), 0);
            this.objectKeys.put(cOSBase, cOSObjectKey);
            if (object != null) {
                this.objectKeys.put(object, cOSObjectKey);
            }
        }
        return cOSObjectKey;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean isNeedToBeUpdated(COSBase cOSBase) {
        if (cOSBase instanceof COSUpdateInfo) {
            return ((COSUpdateInfo) cOSBase).isNeedToBeUpdated();
        }
        return false;
    }

    private void prepareIncrement(PDDocument pDDocument) {
        if (pDDocument != null) {
            try {
                COSDocument document = pDDocument.getDocument();
                Set<COSObjectKey> setKeySet = document.getXrefTable().keySet();
                long highestXRefObjectNumber = pDDocument.getDocument().getHighestXRefObjectNumber();
                for (COSObjectKey cOSObjectKey : setKeySet) {
                    COSBase object = document.getObjectFromPool(cOSObjectKey).getObject();
                    if (object != null && cOSObjectKey != null && !(object instanceof COSNumber)) {
                        this.objectKeys.put(object, cOSObjectKey);
                        this.keyObject.put(cOSObjectKey, object);
                    }
                    if (cOSObjectKey != null) {
                        long number = cOSObjectKey.getNumber();
                        if (number > highestXRefObjectNumber) {
                            highestXRefObjectNumber = number;
                        }
                    }
                }
                setNumber(highestXRefObjectNumber);
            } catch (IOException e2) {
                Log.e("PdfBox-Android", e2.getMessage(), e2);
            }
        }
    }

    private void setOutput(OutputStream outputStream) {
        this.output = outputStream;
    }

    private void setStandardOutput(COSStandardOutputStream cOSStandardOutputStream) {
        this.standardOutput = cOSStandardOutputStream;
    }

    public static void writeString(COSString cOSString, OutputStream outputStream) throws IOException {
        writeString(cOSString.getBytes(), cOSString.getForceHexForm(), outputStream);
    }

    private void writeXrefEntry(COSWriterXRefEntry cOSWriterXRefEntry) throws IOException {
        String str = this.formatXrefOffset.format(cOSWriterXRefEntry.getOffset());
        String str2 = this.formatXrefGeneration.format(cOSWriterXRefEntry.getKey().getGeneration());
        COSStandardOutputStream standardOutput = getStandardOutput();
        Charset charset = Charsets.ISO_8859_1;
        standardOutput.write(str.getBytes(charset));
        COSStandardOutputStream standardOutput2 = getStandardOutput();
        byte[] bArr = SPACE;
        standardOutput2.write(bArr);
        getStandardOutput().write(str2.getBytes(charset));
        getStandardOutput().write(bArr);
        getStandardOutput().write(cOSWriterXRefEntry.isFree() ? XREF_FREE : XREF_USED);
        getStandardOutput().writeCRLF();
    }

    private void writeXrefRange(long j, long j2) throws IOException {
        COSStandardOutputStream standardOutput = getStandardOutput();
        String strValueOf = String.valueOf(j);
        Charset charset = Charsets.ISO_8859_1;
        standardOutput.write(strValueOf.getBytes(charset));
        getStandardOutput().write(SPACE);
        getStandardOutput().write(String.valueOf(j2).getBytes(charset));
        getStandardOutput().writeEOL();
    }

    public void addXRefEntry(COSWriterXRefEntry cOSWriterXRefEntry) {
        getXRefEntries().add(cOSWriterXRefEntry);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (getStandardOutput() != null) {
            getStandardOutput().close();
        }
        OutputStream outputStream = this.incrementalOutput;
        if (outputStream != null) {
            outputStream.close();
        }
    }

    public void doWriteBody(COSDocument cOSDocument) throws IOException {
        COSDictionary trailer = cOSDocument.getTrailer();
        COSDictionary cOSDictionary = trailer.getCOSDictionary(COSName.ROOT);
        COSDictionary cOSDictionary2 = trailer.getCOSDictionary(COSName.INFO);
        COSDictionary cOSDictionary3 = trailer.getCOSDictionary(COSName.ENCRYPT);
        if (cOSDictionary != null) {
            addObjectToWrite(cOSDictionary);
        }
        if (cOSDictionary2 != null) {
            addObjectToWrite(cOSDictionary2);
        }
        doWriteObjects();
        this.willEncrypt = false;
        if (cOSDictionary3 != null) {
            addObjectToWrite(cOSDictionary3);
        }
        doWriteObjects();
    }

    public void doWriteHeader(COSDocument cOSDocument) throws IOException {
        String str;
        if (this.fdfDocument != null) {
            str = "%FDF-" + cOSDocument.getVersion();
        } else {
            str = "%PDF-" + cOSDocument.getVersion();
        }
        getStandardOutput().write(str.getBytes(Charsets.ISO_8859_1));
        getStandardOutput().writeEOL();
        getStandardOutput().write(COMMENT);
        getStandardOutput().write(GARBAGE);
        getStandardOutput().writeEOL();
    }

    public void doWriteObject(COSBase cOSBase) throws IOException {
        this.writtenObjects.add(cOSBase);
        this.currentObjectKey = getObjectKey(cOSBase);
        addXRefEntry(new COSWriterXRefEntry(getStandardOutput().getPos(), cOSBase, this.currentObjectKey));
        COSStandardOutputStream standardOutput = getStandardOutput();
        String strValueOf = String.valueOf(this.currentObjectKey.getNumber());
        Charset charset = Charsets.ISO_8859_1;
        standardOutput.write(strValueOf.getBytes(charset));
        COSStandardOutputStream standardOutput2 = getStandardOutput();
        byte[] bArr = SPACE;
        standardOutput2.write(bArr);
        getStandardOutput().write(String.valueOf(this.currentObjectKey.getGeneration()).getBytes(charset));
        getStandardOutput().write(bArr);
        getStandardOutput().write(OBJ);
        getStandardOutput().writeEOL();
        cOSBase.accept(this);
        getStandardOutput().writeEOL();
        getStandardOutput().write(ENDOBJ);
        getStandardOutput().writeEOL();
    }

    public void doWriteTrailer(COSDocument cOSDocument) throws IOException {
        getStandardOutput().write(TRAILER);
        getStandardOutput().writeEOL();
        COSDictionary trailer = cOSDocument.getTrailer();
        Collections.sort(getXRefEntries());
        trailer.setLong(COSName.SIZE, getXRefEntries().get(getXRefEntries().size() - 1).getKey().getNumber() + 1);
        if (!this.incrementalUpdate) {
            trailer.removeItem(COSName.PREV);
        }
        if (!cOSDocument.isXRefStream()) {
            trailer.removeItem(COSName.XREF_STM);
        }
        trailer.removeItem(COSName.DOC_CHECKSUM);
        COSArray cOSArray = trailer.getCOSArray(COSName.ID);
        if (cOSArray != null) {
            cOSArray.setDirect(true);
        }
        trailer.accept(this);
    }

    public InputStream getDataToSign() throws IOException {
        RandomAccessRead randomAccessRead;
        if (this.incrementPart == null || (randomAccessRead = this.incrementalInput) == null) {
            throw new IllegalStateException("PDF not prepared for signing");
        }
        int length = (int) (this.signatureOffset - randomAccessRead.length());
        int i2 = ((int) this.signatureLength) + length;
        return new SequenceInputStream(new RandomAccessInputStream(this.incrementalInput), new COSFilterInputStream(this.incrementPart, new int[]{0, length, i2, this.incrementPart.length - i2}));
    }

    public long getNumber() {
        return this.number;
    }

    public Map<COSBase, COSObjectKey> getObjectKeys() {
        return this.objectKeys;
    }

    public OutputStream getOutput() {
        return this.output;
    }

    public COSStandardOutputStream getStandardOutput() {
        return this.standardOutput;
    }

    public long getStartxref() {
        return this.startxref;
    }

    public List<COSWriterXRefEntry> getXRefEntries() {
        return this.xRefEntries;
    }

    public Long[] getXRefRanges(List<COSWriterXRefEntry> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<COSWriterXRefEntry> it = list.iterator();
        long j = -2;
        long j2 = 1;
        while (it.hasNext()) {
            long number = it.next().getKey().getNumber();
            if (number == j + 1) {
                j2++;
            } else if (j != -2) {
                arrayList.add(Long.valueOf((j - j2) + 1));
                arrayList.add(Long.valueOf(j2));
                j2 = 1;
            }
            j = number;
        }
        if (list.size() > 0) {
            arrayList.add(Long.valueOf((j - j2) + 1));
            arrayList.add(Long.valueOf(j2));
        }
        return (Long[]) arrayList.toArray(new Long[arrayList.size()]);
    }

    public void setNumber(long j) {
        this.number = j;
    }

    public void setStartxref(long j) {
        this.startxref = j;
    }

    @Override // com.tom_roush.pdfbox.cos.ICOSVisitor
    public Object visitFromArray(COSArray cOSArray) throws IOException {
        getStandardOutput().write(ARRAY_OPEN);
        Iterator<COSBase> it = cOSArray.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            COSBase next = it.next();
            if (next instanceof COSDictionary) {
                if (next.isDirect()) {
                    visitFromDictionary((COSDictionary) next);
                } else {
                    addObjectToWrite(next);
                    writeReference(next);
                }
            } else if (next instanceof COSObject) {
                COSBase object = ((COSObject) next).getObject();
                if (this.willEncrypt || this.incrementalUpdate || (object instanceof COSDictionary) || object == null) {
                    addObjectToWrite(next);
                    writeReference(next);
                } else {
                    object.accept(this);
                }
            } else if (next == null) {
                COSNull.NULL.accept(this);
            } else {
                next.accept(this);
            }
            i2++;
            if (it.hasNext()) {
                if (i2 % 10 == 0) {
                    getStandardOutput().writeEOL();
                } else {
                    getStandardOutput().write(SPACE);
                }
            }
        }
        getStandardOutput().write(ARRAY_CLOSE);
        getStandardOutput().writeEOL();
        return null;
    }

    @Override // com.tom_roush.pdfbox.cos.ICOSVisitor
    public Object visitFromBoolean(COSBoolean cOSBoolean) throws IOException {
        cOSBoolean.writePDF(getStandardOutput());
        return null;
    }

    @Override // com.tom_roush.pdfbox.cos.ICOSVisitor
    public Object visitFromDictionary(COSDictionary cOSDictionary) throws IOException {
        if (!this.reachedSignature) {
            COSBase item = cOSDictionary.getItem(COSName.TYPE);
            if (COSName.SIG.equals(item) || COSName.DOC_TIME_STAMP.equals(item)) {
                this.reachedSignature = true;
            }
        }
        getStandardOutput().write(DICT_OPEN);
        getStandardOutput().writeEOL();
        for (Map.Entry<COSName, COSBase> entry : cOSDictionary.entrySet()) {
            COSBase value = entry.getValue();
            if (value != null) {
                entry.getKey().accept(this);
                getStandardOutput().write(SPACE);
                if (value instanceof COSDictionary) {
                    COSDictionary cOSDictionary2 = (COSDictionary) value;
                    if (!this.incrementalUpdate) {
                        COSName cOSName = COSName.XOBJECT;
                        COSBase item2 = cOSDictionary2.getItem(cOSName);
                        if (item2 != null && !cOSName.equals(entry.getKey())) {
                            item2.setDirect(true);
                        }
                        COSName cOSName2 = COSName.RESOURCES;
                        COSBase item3 = cOSDictionary2.getItem(cOSName2);
                        if (item3 != null && !cOSName2.equals(entry.getKey())) {
                            item3.setDirect(true);
                        }
                    }
                    if (cOSDictionary2.isDirect()) {
                        visitFromDictionary(cOSDictionary2);
                    } else {
                        addObjectToWrite(cOSDictionary2);
                        writeReference(cOSDictionary2);
                    }
                } else if (value instanceof COSObject) {
                    COSBase object = ((COSObject) value).getObject();
                    if (this.willEncrypt || this.incrementalUpdate || (object instanceof COSDictionary) || object == null) {
                        addObjectToWrite(value);
                        writeReference(value);
                    } else {
                        object.accept(this);
                    }
                } else if (this.reachedSignature && COSName.CONTENTS.equals(entry.getKey())) {
                    this.signatureOffset = getStandardOutput().getPos();
                    value.accept(this);
                    this.signatureLength = getStandardOutput().getPos() - this.signatureOffset;
                } else if (this.reachedSignature && COSName.BYTERANGE.equals(entry.getKey())) {
                    this.byteRangeArray = (COSArray) entry.getValue();
                    this.byteRangeOffset = getStandardOutput().getPos() + 1;
                    value.accept(this);
                    this.byteRangeLength = (getStandardOutput().getPos() - 1) - this.byteRangeOffset;
                    this.reachedSignature = false;
                } else {
                    value.accept(this);
                }
                getStandardOutput().writeEOL();
            }
        }
        getStandardOutput().write(DICT_CLOSE);
        getStandardOutput().writeEOL();
        return null;
    }

    @Override // com.tom_roush.pdfbox.cos.ICOSVisitor
    public Object visitFromDocument(COSDocument cOSDocument) throws IOException {
        if (this.incrementalUpdate) {
            getStandardOutput().writeCRLF();
        } else {
            doWriteHeader(cOSDocument);
        }
        doWriteBody(cOSDocument);
        COSDictionary trailer = cOSDocument.getTrailer();
        long j = trailer != null ? trailer.getLong(COSName.XREF_STM) : -1L;
        if (this.incrementalUpdate || cOSDocument.isXRefStream()) {
            doWriteXRefInc(cOSDocument, j);
        } else {
            doWriteXRefTable();
            doWriteTrailer(cOSDocument);
        }
        getStandardOutput().write(STARTXREF);
        getStandardOutput().writeEOL();
        getStandardOutput().write(String.valueOf(getStartxref()).getBytes(Charsets.ISO_8859_1));
        getStandardOutput().writeEOL();
        getStandardOutput().write(EOF);
        getStandardOutput().writeEOL();
        if (!this.incrementalUpdate) {
            return null;
        }
        if (this.signatureOffset == 0 || this.byteRangeOffset == 0) {
            doWriteIncrement();
            return null;
        }
        doWriteSignature();
        return null;
    }

    @Override // com.tom_roush.pdfbox.cos.ICOSVisitor
    public Object visitFromFloat(COSFloat cOSFloat) throws IOException {
        cOSFloat.writePDF(getStandardOutput());
        return null;
    }

    @Override // com.tom_roush.pdfbox.cos.ICOSVisitor
    public Object visitFromInt(COSInteger cOSInteger) throws IOException {
        cOSInteger.writePDF(getStandardOutput());
        return null;
    }

    @Override // com.tom_roush.pdfbox.cos.ICOSVisitor
    public Object visitFromName(COSName cOSName) throws IOException {
        cOSName.writePDF(getStandardOutput());
        return null;
    }

    @Override // com.tom_roush.pdfbox.cos.ICOSVisitor
    public Object visitFromNull(COSNull cOSNull) throws IOException {
        cOSNull.writePDF(getStandardOutput());
        return null;
    }

    @Override // com.tom_roush.pdfbox.cos.ICOSVisitor
    public Object visitFromStream(COSStream cOSStream) throws Throwable {
        Throwable th;
        InputStream inputStreamCreateRawInputStream;
        if (this.willEncrypt) {
            this.pdDocument.getEncryption().getSecurityHandler().encryptStream(cOSStream, this.currentObjectKey.getNumber(), this.currentObjectKey.getGeneration());
        }
        try {
            visitFromDictionary(cOSStream);
            getStandardOutput().write(STREAM);
            getStandardOutput().writeCRLF();
            inputStreamCreateRawInputStream = cOSStream.createRawInputStream();
        } catch (Throwable th2) {
            th = th2;
            inputStreamCreateRawInputStream = null;
        }
        try {
            IOUtils.copy(inputStreamCreateRawInputStream, getStandardOutput());
            getStandardOutput().writeCRLF();
            getStandardOutput().write(ENDSTREAM);
            getStandardOutput().writeEOL();
            if (inputStreamCreateRawInputStream != null) {
                inputStreamCreateRawInputStream.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (inputStreamCreateRawInputStream != null) {
                inputStreamCreateRawInputStream.close();
            }
            throw th;
        }
    }

    @Override // com.tom_roush.pdfbox.cos.ICOSVisitor
    public Object visitFromString(COSString cOSString) throws IOException {
        if (this.willEncrypt) {
            this.pdDocument.getEncryption().getSecurityHandler().encryptString(cOSString, this.currentObjectKey.getNumber(), this.currentObjectKey.getGeneration());
        }
        writeString(cOSString, getStandardOutput());
        return null;
    }

    public void write(COSDocument cOSDocument) throws IOException {
        write(new PDDocument(cOSDocument));
    }

    public void writeExternalSignature(byte[] bArr) throws IOException {
        if (this.incrementPart == null || this.incrementalInput == null) {
            throw new IllegalStateException("PDF not prepared for setting signature");
        }
        byte[] bytes = Hex.getBytes(bArr);
        if (bytes.length > this.signatureLength - 2) {
            throw new IOException("Can't write signature, not enough space");
        }
        System.arraycopy(bytes, 0, this.incrementPart, ((int) (this.signatureOffset - this.incrementalInput.length())) + 1, bytes.length);
        IOUtils.copy(new RandomAccessInputStream(this.incrementalInput), this.incrementalOutput);
        this.incrementalOutput.write(this.incrementPart);
        this.incrementPart = null;
    }

    public void writeReference(COSBase cOSBase) throws IOException {
        COSObjectKey objectKey = getObjectKey(cOSBase);
        COSStandardOutputStream standardOutput = getStandardOutput();
        String strValueOf = String.valueOf(objectKey.getNumber());
        Charset charset = Charsets.ISO_8859_1;
        standardOutput.write(strValueOf.getBytes(charset));
        COSStandardOutputStream standardOutput2 = getStandardOutput();
        byte[] bArr = SPACE;
        standardOutput2.write(bArr);
        getStandardOutput().write(String.valueOf(objectKey.getGeneration()).getBytes(charset));
        getStandardOutput().write(bArr);
        getStandardOutput().write(REFERENCE);
    }

    public static void writeString(byte[] bArr, OutputStream outputStream) throws IOException {
        writeString(bArr, false, outputStream);
    }

    private static void writeString(byte[] bArr, boolean z, OutputStream outputStream) throws IOException {
        boolean z2;
        if (z) {
            z2 = true;
        } else {
            for (byte b2 : bArr) {
                if (b2 < 0 || b2 == 13 || b2 == 10) {
                    z2 = false;
                    break;
                }
            }
            z2 = true;
        }
        if (z2 && !z) {
            outputStream.write(40);
            for (int i2 : bArr) {
                if (i2 != 40 && i2 != 41 && i2 != 92) {
                    outputStream.write(i2);
                } else {
                    outputStream.write(92);
                    outputStream.write(i2);
                }
            }
            outputStream.write(41);
            return;
        }
        outputStream.write(60);
        Hex.writeHexBytes(bArr, outputStream);
        outputStream.write(62);
    }

    public void write(PDDocument pDDocument) throws IOException {
        write(pDDocument, null);
    }

    public void write(PDDocument pDDocument, SignatureInterface signatureInterface) throws IOException {
        Long lValueOf = Long.valueOf(pDDocument.getDocumentId() == null ? System.currentTimeMillis() : pDDocument.getDocumentId().longValue());
        this.pdDocument = pDDocument;
        this.signatureInterface = signatureInterface;
        if (this.incrementalUpdate) {
            prepareIncrement(pDDocument);
        }
        boolean z = true;
        if (pDDocument.isAllSecurityToBeRemoved()) {
            this.willEncrypt = false;
            pDDocument.getDocument().getTrailer().removeItem(COSName.ENCRYPT);
        } else if (this.pdDocument.getEncryption() != null) {
            if (!this.incrementalUpdate) {
                SecurityHandler securityHandler = this.pdDocument.getEncryption().getSecurityHandler();
                if (securityHandler.hasProtectionPolicy()) {
                    securityHandler.prepareDocumentForEncryption(this.pdDocument);
                } else {
                    throw new IllegalStateException("PDF contains an encryption dictionary, please remove it with setAllSecurityToBeRemoved() or set a protection policy with protect()");
                }
            }
            this.willEncrypt = true;
        } else {
            this.willEncrypt = false;
        }
        COSDocument document = this.pdDocument.getDocument();
        COSDictionary trailer = document.getTrailer();
        COSArray cOSArray = null;
        COSBase dictionaryObject = trailer.getDictionaryObject(COSName.ID);
        if (dictionaryObject instanceof COSArray) {
            cOSArray = (COSArray) dictionaryObject;
            if (cOSArray.size() == 2) {
                z = false;
            }
        }
        if (cOSArray != null && cOSArray.size() == 2) {
            z = false;
        }
        if (z || this.incrementalUpdate) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
                messageDigest.update(Long.toString(lValueOf.longValue()).getBytes(Charsets.ISO_8859_1));
                COSDictionary cOSDictionary = trailer.getCOSDictionary(COSName.INFO);
                if (cOSDictionary != null) {
                    Iterator<COSBase> it = cOSDictionary.getValues().iterator();
                    while (it.hasNext()) {
                        messageDigest.update(it.next().toString().getBytes(Charsets.ISO_8859_1));
                    }
                }
                COSString cOSString = z ? new COSString(messageDigest.digest()) : (COSString) cOSArray.get(0);
                COSString cOSString2 = z ? cOSString : new COSString(messageDigest.digest());
                COSArray cOSArray2 = new COSArray();
                cOSArray2.add((COSBase) cOSString);
                cOSArray2.add((COSBase) cOSString2);
                trailer.setItem(COSName.ID, (COSBase) cOSArray2);
            } catch (NoSuchAlgorithmException e2) {
                throw new RuntimeException(e2);
            }
        }
        document.accept(this);
    }

    public COSWriter(OutputStream outputStream, RandomAccessRead randomAccessRead) throws IOException {
        Locale locale = Locale.US;
        this.formatXrefOffset = new DecimalFormat("0000000000", DecimalFormatSymbols.getInstance(locale));
        this.formatXrefGeneration = new DecimalFormat("00000", DecimalFormatSymbols.getInstance(locale));
        this.startxref = 0L;
        this.number = 0L;
        this.objectKeys = new Hashtable();
        this.keyObject = new HashMap();
        this.xRefEntries = new ArrayList();
        this.objectsToWriteSet = new HashSet();
        this.objectsToWrite = new LinkedList();
        this.writtenObjects = new HashSet();
        this.actualsAdded = new HashSet();
        this.currentObjectKey = null;
        this.pdDocument = null;
        this.fdfDocument = null;
        this.willEncrypt = false;
        this.incrementalUpdate = false;
        this.reachedSignature = false;
        setOutput(new ByteArrayOutputStream());
        setStandardOutput(new COSStandardOutputStream(this.output, randomAccessRead.length()));
        this.incrementalInput = randomAccessRead;
        this.incrementalOutput = outputStream;
        this.incrementalUpdate = true;
    }

    public void write(FDFDocument fDFDocument) throws IOException {
        this.fdfDocument = fDFDocument;
        this.willEncrypt = false;
        fDFDocument.getDocument().accept(this);
    }

    public COSWriter(OutputStream outputStream, RandomAccessRead randomAccessRead, Set<COSDictionary> set) throws IOException {
        this(outputStream, randomAccessRead);
        this.objectsToWrite.addAll(set);
    }
}
