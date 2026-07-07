package com.tom_roush.pdfbox.pdmodel.graphics.image;

import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Rect;
import com.tom_roush.pdfbox.cos.COSArray;
import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.filter.DecodeOptions;
import com.tom_roush.pdfbox.filter.DecodeResult;
import com.tom_roush.pdfbox.filter.FilterFactory;
import com.tom_roush.pdfbox.pdmodel.PDResources;
import com.tom_roush.pdfbox.pdmodel.common.COSArrayList;
import com.tom_roush.pdfbox.pdmodel.graphics.color.PDColorSpace;
import com.tom_roush.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class PDInlineImage implements PDImage {
    private final byte[] decodedData;
    private final COSDictionary parameters;
    private final byte[] rawData;
    private final PDResources resources;

    public PDInlineImage(COSDictionary cOSDictionary, byte[] bArr, PDResources pDResources) throws IOException {
        this.parameters = cOSDictionary;
        this.resources = pDResources;
        this.rawData = bArr;
        List<String> filters = getFilters();
        DecodeResult decodeResultDecode = null;
        if (filters == null || filters.isEmpty()) {
            this.decodedData = bArr;
        } else {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
            for (int i2 = 0; i2 < filters.size(); i2++) {
                byteArrayOutputStream.reset();
                decodeResultDecode = FilterFactory.INSTANCE.getFilter(filters.get(i2)).decode(byteArrayInputStream, byteArrayOutputStream, cOSDictionary, i2);
                byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            }
            this.decodedData = byteArrayOutputStream.toByteArray();
        }
        if (decodeResultDecode != null) {
            cOSDictionary.addAll(decodeResultDecode.getParameters());
        }
    }

    private PDColorSpace createColorSpace(COSBase cOSBase) throws IOException {
        if (cOSBase instanceof COSName) {
            return PDColorSpace.create(toLongName(cOSBase), this.resources);
        }
        if (cOSBase instanceof COSArray) {
            COSArray cOSArray = (COSArray) cOSBase;
            if (cOSArray.size() > 1) {
                COSBase cOSBase2 = cOSArray.get(0);
                if (!COSName.I.equals(cOSBase2) && !COSName.INDEXED.equals(cOSBase2)) {
                    throw new IOException("Illegal type of inline image color space: " + cOSBase2);
                }
                COSArray cOSArray2 = new COSArray();
                cOSArray2.addAll(cOSArray);
                cOSArray2.set(0, (COSBase) COSName.INDEXED);
                cOSArray2.set(1, toLongName(cOSArray.get(1)));
                return PDColorSpace.create(cOSArray2, this.resources);
            }
        }
        throw new IOException("Illegal type of object for inline image color space: " + cOSBase);
    }

    private COSBase toLongName(COSBase cOSBase) {
        return COSName.RGB.equals(cOSBase) ? COSName.DEVICERGB : COSName.CMYK.equals(cOSBase) ? COSName.DEVICECMYK : COSName.G.equals(cOSBase) ? COSName.DEVICEGRAY : cOSBase;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.image.PDImage
    public InputStream createInputStream() throws IOException {
        return new ByteArrayInputStream(this.decodedData);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.image.PDImage
    public int getBitsPerComponent() {
        if (isStencil()) {
            return 1;
        }
        return this.parameters.getInt(COSName.BPC, COSName.BITS_PER_COMPONENT, -1);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.COSObjectable
    public COSBase getCOSObject() {
        return this.parameters;
    }

    @Deprecated
    public COSArray getColorKeyMask() {
        COSBase dictionaryObject = this.parameters.getDictionaryObject(COSName.IM, COSName.MASK);
        if (dictionaryObject instanceof COSArray) {
            return (COSArray) dictionaryObject;
        }
        return null;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.image.PDImage
    public PDColorSpace getColorSpace() throws IOException {
        COSBase dictionaryObject = this.parameters.getDictionaryObject(COSName.CS, COSName.COLORSPACE);
        if (dictionaryObject != null) {
            return createColorSpace(dictionaryObject);
        }
        if (isStencil()) {
            return PDDeviceGray.INSTANCE;
        }
        throw new IOException("could not determine inline image color space");
    }

    public byte[] getData() {
        return this.decodedData;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.image.PDImage
    public COSArray getDecode() {
        return (COSArray) this.parameters.getDictionaryObject(COSName.D, COSName.DECODE);
    }

    public List<String> getFilters() {
        COSDictionary cOSDictionary = this.parameters;
        COSName cOSName = COSName.F;
        COSName cOSName2 = COSName.FILTER;
        COSBase dictionaryObject = cOSDictionary.getDictionaryObject(cOSName, cOSName2);
        if (dictionaryObject instanceof COSName) {
            COSName cOSName3 = (COSName) dictionaryObject;
            return new COSArrayList(cOSName3.getName(), cOSName3, this.parameters, cOSName2);
        }
        if (dictionaryObject instanceof COSArray) {
            return COSArrayList.convertCOSNameCOSArrayToList((COSArray) dictionaryObject);
        }
        return null;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.image.PDImage
    public int getHeight() {
        return this.parameters.getInt(COSName.H, COSName.HEIGHT, -1);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.image.PDImage
    public Bitmap getImage() throws IOException {
        return SampledImageReader.getRGBImage(this, null);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.image.PDImage
    public boolean getInterpolate() {
        return this.parameters.getBoolean(COSName.I, COSName.INTERPOLATE, false);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.image.PDImage
    public Bitmap getStencilImage(Paint paint) throws IOException {
        if (isStencil()) {
            return SampledImageReader.getStencilImage(this, paint);
        }
        throw new IllegalStateException("Image is not a stencil");
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.image.PDImage
    public String getSuffix() {
        List<String> filters = getFilters();
        return (filters == null || filters.isEmpty()) ? "png" : (filters.contains(COSName.DCT_DECODE.getName()) || filters.contains(COSName.DCT_DECODE_ABBREVIATION.getName())) ? "jpg" : (filters.contains(COSName.CCITTFAX_DECODE.getName()) || filters.contains(COSName.CCITTFAX_DECODE_ABBREVIATION.getName())) ? "tiff" : "png";
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.image.PDImage
    public int getWidth() {
        return this.parameters.getInt(COSName.W, COSName.WIDTH, -1);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.image.PDImage
    public boolean isEmpty() {
        return this.decodedData.length == 0;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.image.PDImage
    public boolean isStencil() {
        return this.parameters.getBoolean(COSName.IM, COSName.IMAGE_MASK, false);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.image.PDImage
    public void setBitsPerComponent(int i2) {
        this.parameters.setInt(COSName.BPC, i2);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.image.PDImage
    public void setColorSpace(PDColorSpace pDColorSpace) {
        this.parameters.setItem(COSName.CS, pDColorSpace != null ? pDColorSpace.getCOSObject() : null);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.image.PDImage
    public void setDecode(COSArray cOSArray) {
        this.parameters.setItem(COSName.D, (COSBase) cOSArray);
    }

    public void setFilters(List<String> list) {
        this.parameters.setItem(COSName.F, (COSBase) COSArrayList.convertStringListToCOSNameCOSArray(list));
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.image.PDImage
    public void setHeight(int i2) {
        this.parameters.setInt(COSName.H, i2);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.image.PDImage
    public void setInterpolate(boolean z) {
        this.parameters.setBoolean(COSName.I, z);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.image.PDImage
    public void setStencil(boolean z) {
        this.parameters.setBoolean(COSName.IM, z);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.image.PDImage
    public void setWidth(int i2) {
        this.parameters.setInt(COSName.W, i2);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.image.PDImage
    public InputStream createInputStream(DecodeOptions decodeOptions) throws IOException {
        return createInputStream();
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.image.PDImage
    public Bitmap getImage(Rect rect, int i2) throws IOException {
        return SampledImageReader.getRGBImage(this, rect, i2, null);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.image.PDImage
    public InputStream createInputStream(List<String> list) throws IOException {
        List<String> filters = getFilters();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.rawData);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(this.rawData.length);
        for (int i2 = 0; filters != null && i2 < filters.size(); i2++) {
            byteArrayOutputStream.reset();
            if (list.contains(filters.get(i2))) {
                break;
            }
            FilterFactory.INSTANCE.getFilter(filters.get(i2)).decode(byteArrayInputStream, byteArrayOutputStream, this.parameters, i2);
            byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        }
        return byteArrayInputStream;
    }
}
