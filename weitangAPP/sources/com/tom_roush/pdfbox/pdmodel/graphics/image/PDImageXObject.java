package com.tom_roush.pdfbox.pdmodel.graphics.image;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.core.view.ViewCompat;
import com.tom_roush.pdfbox.cos.COSArray;
import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.cos.COSInputStream;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.cos.COSObject;
import com.tom_roush.pdfbox.cos.COSStream;
import com.tom_roush.pdfbox.filter.DecodeOptions;
import com.tom_roush.pdfbox.filter.DecodeResult;
import com.tom_roush.pdfbox.io.IOUtils;
import com.tom_roush.pdfbox.pdmodel.PDDocument;
import com.tom_roush.pdfbox.pdmodel.PDResources;
import com.tom_roush.pdfbox.pdmodel.common.PDMetadata;
import com.tom_roush.pdfbox.pdmodel.common.PDStream;
import com.tom_roush.pdfbox.pdmodel.documentinterchange.markedcontent.PDPropertyList;
import com.tom_roush.pdfbox.pdmodel.graphics.PDXObject;
import com.tom_roush.pdfbox.pdmodel.graphics.color.PDColorSpace;
import com.tom_roush.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import com.tom_roush.pdfbox.util.filetypedetector.FileType;
import com.tom_roush.pdfbox.util.filetypedetector.FileTypeDetector;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.SoftReference;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class PDImageXObject extends PDXObject implements PDImage {
    private SoftReference<Bitmap> cachedImage;
    private int cachedImageSubsampling;
    private PDColorSpace colorSpace;
    private final PDResources resources;

    public PDImageXObject(PDDocument pDDocument) throws IOException {
        this(new PDStream(pDDocument), null);
    }

    private Bitmap applyMask(Bitmap bitmap, Bitmap bitmap2, boolean z, boolean z2, float[] fArr) {
        Bitmap bitmapScaleImage = bitmap;
        Bitmap bitmapScaleImage2 = bitmap2;
        if (bitmapScaleImage2 == null) {
            return bitmapScaleImage;
        }
        int iMax = Math.max(bitmap.getWidth(), bitmap2.getWidth());
        int iMax2 = Math.max(bitmap.getHeight(), bitmap2.getHeight());
        if (bitmap2.getWidth() < iMax || bitmap2.getHeight() < iMax2) {
            bitmapScaleImage2 = scaleImage(bitmapScaleImage2, iMax, iMax2, z);
        }
        if (bitmapScaleImage2.getConfig() != Bitmap.Config.ALPHA_8 || !bitmap.isMutable()) {
            bitmapScaleImage2 = bitmapScaleImage2.copy(Bitmap.Config.ALPHA_8, true);
        }
        if (bitmap.getWidth() < iMax || bitmap.getHeight() < iMax2) {
            bitmapScaleImage = scaleImage(bitmapScaleImage, iMax, iMax2, getInterpolate());
        }
        if (bitmapScaleImage.getConfig() != Bitmap.Config.ARGB_8888 || !bitmapScaleImage.isMutable()) {
            bitmapScaleImage = bitmapScaleImage.copy(Bitmap.Config.ARGB_8888, true);
        }
        int[] iArr = new int[iMax];
        int[] iArr2 = new int[iMax];
        if (!z2 && bitmapScaleImage.getByteCount() == bitmapScaleImage2.getByteCount()) {
            int i2 = 0;
            while (i2 < iMax2) {
                int i3 = i2;
                bitmapScaleImage.getPixels(iArr, 0, iMax, 0, i2, iMax, 1);
                bitmapScaleImage2.getPixels(iArr2, 0, iMax, 0, i3, iMax, 1);
                int i4 = 0;
                for (int i5 = iMax; i5 > 0; i5--) {
                    iArr[i4] = (iArr[i4] & ViewCompat.MEASURED_SIZE_MASK) | ((~iArr2[i4]) & (-16777216));
                    i4++;
                }
                bitmapScaleImage.setPixels(iArr, 0, iMax, 0, i3, iMax, 1);
                i2 = i3 + 1;
            }
        } else if (fArr == null) {
            for (int i6 = 0; i6 < iMax2; i6++) {
                int i7 = i6;
                bitmapScaleImage.getPixels(iArr, 0, iMax, 0, i7, iMax, 1);
                bitmapScaleImage2.getPixels(iArr2, 0, iMax, 0, i7, iMax, 1);
                for (int i8 = 0; i8 < iMax; i8++) {
                    if (!z2) {
                        iArr2[i8] = ~iArr2[i8];
                    }
                    iArr[i8] = (iArr[i8] & ViewCompat.MEASURED_SIZE_MASK) | (iArr2[i8] & (-16777216));
                }
                bitmapScaleImage.setPixels(iArr, 0, iMax, 0, i6, iMax, 1);
            }
        } else {
            int iRound = Math.round(fArr[0] * 8355840.0f) * 255;
            int iRound2 = Math.round(fArr[1] * 8355840.0f) * 255;
            int iRound3 = Math.round(fArr[2] * 8355840.0f) * 255;
            int i9 = (iRound / 255) + 16384;
            int i10 = (iRound2 / 255) + 16384;
            int i11 = (iRound3 / 255) + 16384;
            int i12 = 0;
            while (i12 < iMax2) {
                int i13 = i12;
                int i14 = i11;
                int i15 = i10;
                int i16 = i9;
                int i17 = iRound3;
                int i18 = iRound;
                bitmapScaleImage.getPixels(iArr, 0, iMax, 0, i13, iMax, 1);
                bitmapScaleImage2.getPixels(iArr2, 0, iMax, 0, i13, iMax, 1);
                for (int i19 = 0; i19 < iMax; i19++) {
                    int iAlpha = Color.alpha(iArr2[i19]);
                    if (iAlpha == 0) {
                        iArr[i19] = iArr[i19] & ViewCompat.MEASURED_SIZE_MASK;
                    } else {
                        int i20 = iArr[i19];
                        iArr[i19] = Color.argb(iAlpha, clampColor(((((Color.red(i20) * 8355840) - i18) / iAlpha) + i16) >> 15), clampColor(((((Color.green(i20) * 8355840) - iRound2) / iAlpha) + i15) >> 15), clampColor(((((Color.blue(i20) * 8355840) - i17) / iAlpha) + i14) >> 15));
                    }
                }
                bitmapScaleImage.setPixels(iArr, 0, iMax, 0, i13, iMax, 1);
                i12 = i13 + 1;
                i11 = i14;
                i9 = i16;
                i10 = i15;
                iRound3 = i17;
                iRound = i18;
            }
        }
        return bitmapScaleImage;
    }

    private static int clampColor(int i2) {
        if (i2 < 0) {
            return 0;
        }
        if (i2 > 255) {
            return 255;
        }
        return i2;
    }

    public static PDImageXObject createFromByteArray(PDDocument pDDocument, byte[] bArr, String str) throws IOException {
        try {
            FileType fileTypeDetectFileType = FileTypeDetector.detectFileType(bArr);
            if (fileTypeDetectFileType == null) {
                throw new IllegalArgumentException("Image type not supported: " + str);
            }
            if (fileTypeDetectFileType.equals(FileType.JPEG)) {
                return JPEGFactory.createFromByteArray(pDDocument, bArr);
            }
            if (fileTypeDetectFileType.equals(FileType.TIFF)) {
                try {
                    return CCITTFactory.createFromByteArray(pDDocument, bArr);
                } catch (IOException e2) {
                    Log.d("PdfBox-Android", "Reading as TIFF failed, setting fileType to PNG", e2);
                    fileTypeDetectFileType = FileType.PNG;
                }
            }
            if (fileTypeDetectFileType.equals(FileType.BMP) || fileTypeDetectFileType.equals(FileType.GIF) || fileTypeDetectFileType.equals(FileType.PNG)) {
                return LosslessFactory.createFromImage(pDDocument, BitmapFactory.decodeStream(new ByteArrayInputStream(bArr)));
            }
            throw new IllegalArgumentException("Image type " + fileTypeDetectFileType + " not supported: " + str);
        } catch (IOException e3) {
            throw new IOException("Could not determine file type: " + str, e3);
        }
    }

    public static PDImageXObject createFromFile(String str, PDDocument pDDocument) throws IOException {
        return createFromFileByExtension(new File(str), pDDocument);
    }

    public static PDImageXObject createFromFileByContent(File file, PDDocument pDDocument) throws Throwable {
        BufferedInputStream bufferedInputStream;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                bufferedInputStream = new BufferedInputStream(fileInputStream);
            } catch (IOException e2) {
                e = e2;
                bufferedInputStream = null;
            } catch (Throwable th) {
                th = th;
                bufferedInputStream = null;
            }
        } catch (IOException e3) {
            e = e3;
            bufferedInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream = null;
        }
        try {
            FileType fileTypeDetectFileType = FileTypeDetector.detectFileType(bufferedInputStream);
            IOUtils.closeQuietly(fileInputStream);
            IOUtils.closeQuietly(bufferedInputStream);
            if (fileTypeDetectFileType == null) {
                throw new IllegalArgumentException("Image type not supported: " + file.getName());
            }
            if (fileTypeDetectFileType.equals(FileType.JPEG)) {
                FileInputStream fileInputStream3 = new FileInputStream(file);
                PDImageXObject pDImageXObjectCreateFromStream = JPEGFactory.createFromStream(pDDocument, fileInputStream3);
                fileInputStream3.close();
                return pDImageXObjectCreateFromStream;
            }
            if (fileTypeDetectFileType.equals(FileType.TIFF)) {
                try {
                    return CCITTFactory.createFromFile(pDDocument, file);
                } catch (IOException e4) {
                    Log.d("PdfBox-Android", "Reading as TIFF failed, setting fileType to PNG", e4);
                    fileTypeDetectFileType = FileType.PNG;
                }
            }
            if (fileTypeDetectFileType.equals(FileType.BMP) || fileTypeDetectFileType.equals(FileType.GIF) || fileTypeDetectFileType.equals(FileType.PNG)) {
                return LosslessFactory.createFromImage(pDDocument, BitmapFactory.decodeFile(file.getPath()));
            }
            throw new IllegalArgumentException("Image type " + fileTypeDetectFileType + " not supported: " + file.getName());
        } catch (IOException e5) {
            e = e5;
            fileInputStream2 = fileInputStream;
            try {
                throw new IOException("Could not determine file type: " + file.getName(), e);
            } catch (Throwable th3) {
                th = th3;
                IOUtils.closeQuietly(fileInputStream2);
                IOUtils.closeQuietly(bufferedInputStream);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            fileInputStream2 = fileInputStream;
            IOUtils.closeQuietly(fileInputStream2);
            IOUtils.closeQuietly(bufferedInputStream);
            throw th;
        }
    }

    public static PDImageXObject createFromFileByExtension(File file, PDDocument pDDocument) throws Throwable {
        FileInputStream fileInputStream;
        String name = file.getName();
        int iLastIndexOf = name.lastIndexOf(46);
        if (iLastIndexOf == -1) {
            throw new IllegalArgumentException("Image type not supported: " + name);
        }
        String lowerCase = name.substring(iLastIndexOf + 1).toLowerCase();
        if ("jpg".equals(lowerCase) || "jpeg".equals(lowerCase)) {
            FileInputStream fileInputStream2 = null;
            try {
                fileInputStream = new FileInputStream(file);
            } catch (Throwable th) {
                th = th;
            }
            try {
                PDImageXObject pDImageXObjectCreateFromStream = JPEGFactory.createFromStream(pDDocument, fileInputStream);
                IOUtils.closeQuietly(fileInputStream);
                return pDImageXObjectCreateFromStream;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                IOUtils.closeQuietly(fileInputStream2);
                throw th;
            }
        }
        if ("tif".equals(lowerCase) || "tiff".equals(lowerCase)) {
            return CCITTFactory.createFromFile(pDDocument, file);
        }
        if ("gif".equals(lowerCase) || "bmp".equals(lowerCase) || "png".equals(lowerCase)) {
            return LosslessFactory.createFromImage(pDDocument, BitmapFactory.decodeFile(file.getPath()));
        }
        throw new IllegalArgumentException("Image type not supported: " + name);
    }

    private static COSStream createRawStream(PDDocument pDDocument, InputStream inputStream) throws Throwable {
        OutputStream outputStreamCreateRawOutputStream;
        COSStream cOSStreamCreateCOSStream = pDDocument.getDocument().createCOSStream();
        try {
            outputStreamCreateRawOutputStream = cOSStreamCreateCOSStream.createRawOutputStream();
        } catch (Throwable th) {
            th = th;
            outputStreamCreateRawOutputStream = null;
        }
        try {
            IOUtils.copy(inputStream, outputStreamCreateRawOutputStream);
            if (outputStreamCreateRawOutputStream != null) {
                outputStreamCreateRawOutputStream.close();
            }
            return cOSStreamCreateCOSStream;
        } catch (Throwable th2) {
            th = th2;
            if (outputStreamCreateRawOutputStream != null) {
                outputStreamCreateRawOutputStream.close();
            }
            throw th;
        }
    }

    public static PDImageXObject createThumbnail(COSStream cOSStream) throws IOException {
        return new PDImageXObject(new PDStream(cOSStream), null);
    }

    private float[] extractMatte(PDImageXObject pDImageXObject) throws IOException {
        COSBase item = pDImageXObject.getCOSObject().getItem(COSName.MATTE);
        if (!(item instanceof COSArray)) {
            return null;
        }
        float[] floatArray = ((COSArray) item).toFloatArray();
        if (floatArray.length >= getColorSpace().getNumberOfComponents()) {
            return getColorSpace().toRGB(floatArray);
        }
        Log.e("PdfBox-Android", "Image /Matte entry not long enough for colorspace, skipped");
        return null;
    }

    private Bitmap scaleImage(Bitmap bitmap, int i2, int i3, boolean z) {
        return Bitmap.createScaledBitmap(bitmap, i2, i3, !z);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.image.PDImage
    public InputStream createInputStream() throws IOException {
        return getStream().createInputStream();
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.image.PDImage
    public int getBitsPerComponent() {
        if (isStencil()) {
            return 1;
        }
        return getCOSObject().getInt(COSName.BITS_PER_COMPONENT, COSName.BPC);
    }

    public COSArray getColorKeyMask() {
        COSBase dictionaryObject = getCOSObject().getDictionaryObject(COSName.MASK);
        if (dictionaryObject instanceof COSArray) {
            return (COSArray) dictionaryObject;
        }
        return null;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.image.PDImage
    public PDColorSpace getColorSpace() throws IOException {
        PDResources pDResources;
        if (this.colorSpace == null) {
            COSBase item = getCOSObject().getItem(COSName.COLORSPACE, COSName.CS);
            if (item == null) {
                if (isStencil()) {
                    return PDDeviceGray.INSTANCE;
                }
                throw new IOException("could not determine color space");
            }
            COSObject cOSObject = null;
            if ((item instanceof COSObject) && (pDResources = this.resources) != null && pDResources.getResourceCache() != null) {
                cOSObject = (COSObject) item;
                PDColorSpace colorSpace = this.resources.getResourceCache().getColorSpace(cOSObject);
                this.colorSpace = colorSpace;
                if (colorSpace != null) {
                    return colorSpace;
                }
            }
            this.colorSpace = PDColorSpace.create(item, this.resources);
            if (cOSObject != null) {
                this.resources.getResourceCache().put(cOSObject, this.colorSpace);
            }
        }
        return this.colorSpace;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.image.PDImage
    public COSArray getDecode() {
        COSBase dictionaryObject = getCOSObject().getDictionaryObject(COSName.DECODE);
        if (dictionaryObject instanceof COSArray) {
            return (COSArray) dictionaryObject;
        }
        return null;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.image.PDImage
    public int getHeight() {
        return getCOSObject().getInt(COSName.HEIGHT);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.image.PDImage
    public Bitmap getImage() throws IOException {
        return getImage(null, 1);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.image.PDImage
    public boolean getInterpolate() {
        return getCOSObject().getBoolean(COSName.INTERPOLATE, false);
    }

    public PDImageXObject getMask() throws IOException {
        COSStream cOSStream;
        COSStream cOSObject = getCOSObject();
        COSName cOSName = COSName.MASK;
        if ((cOSObject.getDictionaryObject(cOSName) instanceof COSArray) || (cOSStream = getCOSObject().getCOSStream(cOSName)) == null) {
            return null;
        }
        return new PDImageXObject(new PDStream(cOSStream), null);
    }

    public PDMetadata getMetadata() {
        COSStream cOSStream = getCOSObject().getCOSStream(COSName.METADATA);
        if (cOSStream != null) {
            return new PDMetadata(cOSStream);
        }
        return null;
    }

    public Bitmap getOpaqueImage() throws IOException {
        return SampledImageReader.getRGBImage(this, null);
    }

    public PDPropertyList getOptionalContent() {
        COSBase dictionaryObject = getCOSObject().getDictionaryObject(COSName.OC);
        if (dictionaryObject instanceof COSDictionary) {
            return PDPropertyList.create((COSDictionary) dictionaryObject);
        }
        return null;
    }

    public PDImageXObject getSoftMask() throws IOException {
        COSStream cOSStream = getCOSObject().getCOSStream(COSName.SMASK);
        if (cOSStream != null) {
            return new PDImageXObject(new PDStream(cOSStream), null);
        }
        return null;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.image.PDImage
    public Bitmap getStencilImage(Paint paint) throws IOException {
        if (isStencil()) {
            return SampledImageReader.getStencilImage(this, paint);
        }
        throw new IllegalStateException("Image is not a stencil");
    }

    public int getStructParent() {
        return getCOSObject().getInt(COSName.STRUCT_PARENT);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.image.PDImage
    public String getSuffix() {
        List<COSName> filters = getStream().getFilters();
        if (filters == null) {
            return "png";
        }
        if (filters.contains(COSName.DCT_DECODE)) {
            return "jpg";
        }
        if (filters.contains(COSName.JPX_DECODE)) {
            return "jpx";
        }
        if (filters.contains(COSName.CCITTFAX_DECODE)) {
            return "tiff";
        }
        if (filters.contains(COSName.FLATE_DECODE) || filters.contains(COSName.LZW_DECODE) || filters.contains(COSName.RUN_LENGTH_DECODE)) {
            return "png";
        }
        if (filters.contains(COSName.JBIG2_DECODE)) {
            return "jb2";
        }
        Log.w("PdfBox-Android", "getSuffix() returns null, filters: " + filters);
        return null;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.image.PDImage
    public int getWidth() {
        return getCOSObject().getInt(COSName.WIDTH);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.image.PDImage
    public boolean isEmpty() {
        return getStream().getCOSObject().getLength() == 0;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.image.PDImage
    public boolean isStencil() {
        return getCOSObject().getBoolean(COSName.IMAGE_MASK, false);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.image.PDImage
    public void setBitsPerComponent(int i2) {
        getCOSObject().setInt(COSName.BITS_PER_COMPONENT, i2);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.image.PDImage
    public void setColorSpace(PDColorSpace pDColorSpace) {
        getCOSObject().setItem(COSName.COLORSPACE, pDColorSpace != null ? pDColorSpace.getCOSObject() : null);
        this.colorSpace = null;
        this.cachedImage = null;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.image.PDImage
    public void setDecode(COSArray cOSArray) {
        getCOSObject().setItem(COSName.DECODE, (COSBase) cOSArray);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.image.PDImage
    public void setHeight(int i2) {
        getCOSObject().setInt(COSName.HEIGHT, i2);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.image.PDImage
    public void setInterpolate(boolean z) {
        getCOSObject().setBoolean(COSName.INTERPOLATE, z);
    }

    public void setMetadata(PDMetadata pDMetadata) {
        getCOSObject().setItem(COSName.METADATA, pDMetadata);
    }

    public void setOptionalContent(PDPropertyList pDPropertyList) {
        getCOSObject().setItem(COSName.OC, pDPropertyList);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.image.PDImage
    public void setStencil(boolean z) {
        getCOSObject().setBoolean(COSName.IMAGE_MASK, z);
    }

    public void setStructParent(int i2) {
        getCOSObject().setInt(COSName.STRUCT_PARENT, i2);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.image.PDImage
    public void setWidth(int i2) {
        getCOSObject().setInt(COSName.WIDTH, i2);
    }

    public PDImageXObject(PDDocument pDDocument, InputStream inputStream, COSBase cOSBase, int i2, int i3, int i4, PDColorSpace pDColorSpace) throws IOException {
        super(createRawStream(pDDocument, inputStream), COSName.IMAGE);
        this.cachedImageSubsampling = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        getCOSObject().setItem(COSName.FILTER, cOSBase);
        this.resources = null;
        this.colorSpace = null;
        setBitsPerComponent(i4);
        setWidth(i2);
        setHeight(i3);
        setColorSpace(pDColorSpace);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.image.PDImage
    public InputStream createInputStream(DecodeOptions decodeOptions) throws IOException {
        return getStream().createInputStream(decodeOptions);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.image.PDImage
    public Bitmap getImage(Rect rect, int i2) throws IOException {
        SoftReference<Bitmap> softReference;
        Bitmap bitmap;
        if (rect == null && i2 == this.cachedImageSubsampling && (softReference = this.cachedImage) != null && (bitmap = softReference.get()) != null) {
            return bitmap;
        }
        PDImageXObject softMask = getSoftMask();
        PDImageXObject mask = getMask();
        Bitmap bitmapApplyMask = softMask != null ? applyMask(SampledImageReader.getRGBImage(this, rect, i2, getColorKeyMask()), softMask.getOpaqueImage(), softMask.getInterpolate(), true, extractMatte(softMask)) : (mask == null || !mask.isStencil()) ? SampledImageReader.getRGBImage(this, rect, i2, getColorKeyMask()) : applyMask(SampledImageReader.getRGBImage(this, rect, i2, getColorKeyMask()), mask.getOpaqueImage(), mask.getInterpolate(), false, null);
        if (rect == null && i2 <= this.cachedImageSubsampling) {
            this.cachedImageSubsampling = i2;
            this.cachedImage = new SoftReference<>(bitmapApplyMask);
        }
        return bitmapApplyMask;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.image.PDImage
    public InputStream createInputStream(List<String> list) throws IOException {
        return getStream().createInputStream(list);
    }

    public PDImageXObject(PDStream pDStream, PDResources pDResources) throws IOException {
        super(pDStream, COSName.IMAGE);
        this.cachedImageSubsampling = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.resources = pDResources;
        List<COSName> filters = pDStream.getFilters();
        if (filters == null || filters.isEmpty()) {
            return;
        }
        boolean z = true;
        if (COSName.JPX_DECODE.equals(filters.get(filters.size() - 1))) {
            List listAsList = Arrays.asList(COSName.WIDTH, COSName.HEIGHT, COSName.COLORSPACE);
            COSStream cOSObject = pDStream.getCOSObject();
            Iterator it = listAsList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (!cOSObject.containsKey((COSName) it.next())) {
                    break;
                }
            }
            if (z) {
                COSInputStream cOSInputStreamCreateInputStream = null;
                try {
                    cOSInputStreamCreateInputStream = pDStream.createInputStream();
                    DecodeResult decodeResult = cOSInputStreamCreateInputStream.getDecodeResult();
                    pDStream.getCOSObject().addAll(decodeResult.getParameters());
                    this.colorSpace = decodeResult.getJPXColorSpace();
                } finally {
                    IOUtils.closeQuietly(cOSInputStreamCreateInputStream);
                }
            }
        }
    }
}
