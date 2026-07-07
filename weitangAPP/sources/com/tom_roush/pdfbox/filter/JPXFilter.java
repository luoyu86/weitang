package com.tom_roush.pdfbox.filter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import com.gemalto.jp2.JP2Decoder;
import com.gemalto.jp2.JP2Encoder;
import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.io.IOUtils;
import com.tom_roush.pdfbox.pdmodel.graphics.color.PDJPXColorSpace;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class JPXFilter extends Filter {
    private static final int CACHE_SIZE = 1024;

    private Bitmap readJPX(InputStream inputStream, DecodeOptions decodeOptions, DecodeResult decodeResult) throws IOException {
        try {
            Class.forName("com.gemalto.jp2.JP2Decoder");
            Bitmap bitmapDecode = new JP2Decoder(inputStream).decode();
            COSDictionary parameters = decodeResult.getParameters();
            if (!parameters.getBoolean(COSName.IMAGE_MASK, false)) {
                parameters.setItem(COSName.DECODE, (COSBase) null);
            }
            parameters.setInt(COSName.WIDTH, bitmapDecode.getWidth());
            parameters.setInt(COSName.HEIGHT, bitmapDecode.getHeight());
            if (!parameters.containsKey(COSName.COLORSPACE) && Build.VERSION.SDK_INT > 26) {
                decodeResult.setColorSpace(new PDJPXColorSpace(bitmapDecode.getColorSpace()));
            }
            return bitmapDecode;
        } catch (ClassNotFoundException unused) {
            throw new MissingImageReaderException("Cannot read JPX image: JP2Android is not installed.");
        }
    }

    @Override // com.tom_roush.pdfbox.filter.Filter
    public DecodeResult decode(InputStream inputStream, OutputStream outputStream, COSDictionary cOSDictionary, int i2, DecodeOptions decodeOptions) throws IOException {
        DecodeResult decodeResult = new DecodeResult(new COSDictionary());
        decodeResult.getParameters().addAll(cOSDictionary);
        Bitmap jpx = readJPX(inputStream, decodeOptions, decodeResult);
        int width = jpx.getWidth() * jpx.getHeight();
        int[] iArr = new int[width];
        jpx.getPixels(iArr, 0, jpx.getWidth(), 0, 0, jpx.getWidth(), jpx.getHeight());
        byte[] bArr = new byte[3072];
        int i3 = 0;
        for (int i4 = 0; i4 < width; i4++) {
            if (i3 + 3 >= 3072) {
                outputStream.write(bArr, 0, i3);
                i3 = 0;
            }
            int i5 = iArr[i4];
            bArr[i3] = (byte) Color.red(i5);
            bArr[i3 + 1] = (byte) Color.green(i5);
            bArr[i3 + 2] = (byte) Color.blue(i5);
            i3 += 3;
        }
        outputStream.write(bArr, 0, i3);
        return decodeResult;
    }

    @Override // com.tom_roush.pdfbox.filter.Filter
    public void encode(InputStream inputStream, OutputStream outputStream, COSDictionary cOSDictionary) throws IOException {
        IOUtils.copy(new ByteArrayInputStream(new JP2Encoder(BitmapFactory.decodeStream(inputStream)).encode()), outputStream);
        outputStream.flush();
    }

    @Override // com.tom_roush.pdfbox.filter.Filter
    public DecodeResult decode(InputStream inputStream, OutputStream outputStream, COSDictionary cOSDictionary, int i2) throws IOException {
        return decode(inputStream, outputStream, cOSDictionary, i2, DecodeOptions.DEFAULT);
    }
}
