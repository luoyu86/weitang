package com.tom_roush.pdfbox.pdmodel.common;

import android.util.Log;
import com.tom_roush.pdfbox.cos.COSArray;
import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.cos.COSDocument;
import com.tom_roush.pdfbox.cos.COSInputStream;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.cos.COSNull;
import com.tom_roush.pdfbox.cos.COSStream;
import com.tom_roush.pdfbox.filter.DecodeOptions;
import com.tom_roush.pdfbox.filter.FilterFactory;
import com.tom_roush.pdfbox.io.IOUtils;
import com.tom_roush.pdfbox.pdmodel.PDDocument;
import com.tom_roush.pdfbox.pdmodel.common.filespecification.PDFileSpecification;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class PDStream implements COSObjectable {
    private final COSStream stream;

    public PDStream(PDDocument pDDocument) {
        this.stream = pDDocument.getDocument().createCOSStream();
    }

    private List<Object> internalGetDecodeParams(COSName cOSName, COSName cOSName2) throws IOException {
        COSBase dictionaryObject = this.stream.getDictionaryObject(cOSName, cOSName2);
        if (dictionaryObject instanceof COSDictionary) {
            return new COSArrayList(COSDictionaryMap.convertBasicTypesToMap((COSDictionary) dictionaryObject), dictionaryObject, this.stream, cOSName);
        }
        if (!(dictionaryObject instanceof COSArray)) {
            return null;
        }
        COSArray cOSArray = (COSArray) dictionaryObject;
        ArrayList arrayList = new ArrayList(cOSArray.size());
        for (int i2 = 0; i2 < cOSArray.size(); i2++) {
            COSBase object = cOSArray.getObject(i2);
            if (object instanceof COSDictionary) {
                arrayList.add(COSDictionaryMap.convertBasicTypesToMap((COSDictionary) object));
            } else {
                Log.w("PdfBox-Android", "Expected COSDictionary, got " + object + ", ignored");
            }
        }
        return new COSArrayList(arrayList, cOSArray);
    }

    @Deprecated
    public void addCompression() {
        if (getFilters() == null) {
            if (this.stream.getLength() <= 0) {
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(COSName.FLATE_DECODE);
                setFilters(arrayList);
                return;
            }
            OutputStream outputStreamCreateOutputStream = null;
            try {
                try {
                    byte[] byteArray = IOUtils.toByteArray(this.stream.createInputStream());
                    outputStreamCreateOutputStream = this.stream.createOutputStream(COSName.FLATE_DECODE);
                    outputStreamCreateOutputStream.write(byteArray);
                } catch (IOException e2) {
                    throw new RuntimeException(e2);
                }
            } finally {
                IOUtils.closeQuietly(outputStreamCreateOutputStream);
            }
        }
    }

    public COSInputStream createInputStream() throws IOException {
        return this.stream.createInputStream();
    }

    public OutputStream createOutputStream() throws IOException {
        return this.stream.createOutputStream();
    }

    public List<Object> getDecodeParms() throws IOException {
        return internalGetDecodeParams(COSName.DECODE_PARMS, COSName.DP);
    }

    public int getDecodedStreamLength() {
        return this.stream.getInt(COSName.DL);
    }

    public PDFileSpecification getFile() throws IOException {
        return PDFileSpecification.createFS(this.stream.getDictionaryObject(COSName.F));
    }

    public List<Object> getFileDecodeParams() throws IOException {
        return internalGetDecodeParams(COSName.F_DECODE_PARMS, null);
    }

    public List<String> getFileFilters() {
        COSStream cOSStream = this.stream;
        COSName cOSName = COSName.F_FILTER;
        COSBase dictionaryObject = cOSStream.getDictionaryObject(cOSName);
        if (dictionaryObject instanceof COSName) {
            COSName cOSName2 = (COSName) dictionaryObject;
            return new COSArrayList(cOSName2.getName(), cOSName2, this.stream, cOSName);
        }
        if (dictionaryObject instanceof COSArray) {
            return COSArrayList.convertCOSNameCOSArrayToList((COSArray) dictionaryObject);
        }
        return null;
    }

    public List<COSName> getFilters() {
        COSBase filters = this.stream.getFilters();
        if (filters instanceof COSName) {
            COSName cOSName = (COSName) filters;
            return new COSArrayList(cOSName, cOSName, this.stream, COSName.FILTER);
        }
        if (filters instanceof COSArray) {
            return ((COSArray) filters).toList();
        }
        return null;
    }

    public int getLength() {
        return this.stream.getInt(COSName.LENGTH, 0);
    }

    public PDMetadata getMetadata() {
        COSBase dictionaryObject = this.stream.getDictionaryObject(COSName.METADATA);
        if (dictionaryObject != null) {
            if (dictionaryObject instanceof COSStream) {
                return new PDMetadata((COSStream) dictionaryObject);
            }
            if (!(dictionaryObject instanceof COSNull)) {
                throw new IllegalStateException("Expected a COSStream but was a " + dictionaryObject.getClass().getSimpleName());
            }
        }
        return null;
    }

    @Deprecated
    public COSStream getStream() {
        return this.stream;
    }

    public void setDecodeParms(List<?> list) {
        this.stream.setItem(COSName.DECODE_PARMS, (COSBase) COSArrayList.converterToCOSArray(list));
    }

    public void setDecodedStreamLength(int i2) {
        this.stream.setInt(COSName.DL, i2);
    }

    public void setFile(PDFileSpecification pDFileSpecification) {
        this.stream.setItem(COSName.F, pDFileSpecification);
    }

    public void setFileDecodeParams(List<?> list) {
        this.stream.setItem(COSName.F_DECODE_PARMS, (COSBase) COSArrayList.converterToCOSArray(list));
    }

    public void setFileFilters(List<String> list) {
        this.stream.setItem(COSName.F_FILTER, (COSBase) COSArrayList.convertStringListToCOSNameCOSArray(list));
    }

    public void setFilters(List<COSName> list) {
        this.stream.setItem(COSName.FILTER, (COSBase) COSArrayList.converterToCOSArray(list));
    }

    public void setMetadata(PDMetadata pDMetadata) {
        this.stream.setItem(COSName.METADATA, pDMetadata);
    }

    public byte[] toByteArray() throws Throwable {
        COSInputStream cOSInputStreamCreateInputStream;
        try {
            cOSInputStreamCreateInputStream = createInputStream();
            try {
                byte[] byteArray = IOUtils.toByteArray(cOSInputStreamCreateInputStream);
                if (cOSInputStreamCreateInputStream != null) {
                    cOSInputStreamCreateInputStream.close();
                }
                return byteArray;
            } catch (Throwable th) {
                th = th;
                if (cOSInputStreamCreateInputStream != null) {
                    cOSInputStreamCreateInputStream.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            cOSInputStreamCreateInputStream = null;
        }
    }

    public COSInputStream createInputStream(DecodeOptions decodeOptions) throws IOException {
        return this.stream.createInputStream(decodeOptions);
    }

    public OutputStream createOutputStream(COSName cOSName) throws IOException {
        return this.stream.createOutputStream(cOSName);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.COSObjectable
    public COSStream getCOSObject() {
        return this.stream;
    }

    public PDStream(COSDocument cOSDocument) {
        this.stream = cOSDocument.createCOSStream();
    }

    public InputStream createInputStream(List<String> list) throws IOException {
        InputStream inputStreamCreateRawInputStream = this.stream.createRawInputStream();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        List<COSName> filters = getFilters();
        if (filters != null) {
            for (int i2 = 0; i2 < filters.size(); i2++) {
                COSName cOSName = filters.get(i2);
                if (list != null && list.contains(cOSName.getName())) {
                    break;
                }
                try {
                    FilterFactory.INSTANCE.getFilter(cOSName).decode(inputStreamCreateRawInputStream, byteArrayOutputStream, this.stream, i2);
                    IOUtils.closeQuietly(inputStreamCreateRawInputStream);
                    inputStreamCreateRawInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                    byteArrayOutputStream.reset();
                } catch (Throwable th) {
                    IOUtils.closeQuietly(inputStreamCreateRawInputStream);
                    throw th;
                }
            }
        }
        return inputStreamCreateRawInputStream;
    }

    public PDStream(COSStream cOSStream) {
        this.stream = cOSStream;
    }

    public PDStream(PDDocument pDDocument, InputStream inputStream) throws IOException {
        this(pDDocument, inputStream, (COSBase) null);
    }

    public PDStream(PDDocument pDDocument, InputStream inputStream, COSName cOSName) throws IOException {
        this(pDDocument, inputStream, (COSBase) cOSName);
    }

    public PDStream(PDDocument pDDocument, InputStream inputStream, COSArray cOSArray) throws IOException {
        this(pDDocument, inputStream, (COSBase) cOSArray);
    }

    private PDStream(PDDocument pDDocument, InputStream inputStream, COSBase cOSBase) throws IOException {
        OutputStream outputStreamCreateOutputStream = null;
        try {
            COSStream cOSStreamCreateCOSStream = pDDocument.getDocument().createCOSStream();
            this.stream = cOSStreamCreateCOSStream;
            outputStreamCreateOutputStream = cOSStreamCreateCOSStream.createOutputStream(cOSBase);
            IOUtils.copy(inputStream, outputStreamCreateOutputStream);
        } finally {
            if (outputStreamCreateOutputStream != null) {
                outputStreamCreateOutputStream.close();
            }
            inputStream.close();
        }
    }
}
