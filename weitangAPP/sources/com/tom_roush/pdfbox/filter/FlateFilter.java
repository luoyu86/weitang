package com.tom_roush.pdfbox.filter;

import android.util.Log;
import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.io.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;

/* JADX INFO: loaded from: classes2.dex */
public final class FlateFilter extends Filter {
    private void decompress(InputStream inputStream, OutputStream outputStream) throws DataFormatException, IOException {
        byte[] bArr = new byte[2048];
        inputStream.read();
        inputStream.read();
        int i2 = inputStream.read(bArr);
        if (i2 > 0) {
            Inflater inflater = new Inflater(true);
            inflater.setInput(bArr, 0, i2);
            byte[] bArr2 = new byte[1024];
            boolean z = false;
            while (true) {
                try {
                    try {
                        int iInflate = inflater.inflate(bArr2);
                        if (iInflate == 0) {
                            if (inflater.finished() || inflater.needsDictionary() || inputStream.available() == 0) {
                                break;
                            } else {
                                inflater.setInput(bArr, 0, inputStream.read(bArr));
                            }
                        } else {
                            outputStream.write(bArr2, 0, iInflate);
                            z = true;
                        }
                    } catch (DataFormatException e2) {
                        if (!z) {
                            throw e2;
                        }
                        Log.w("PdfBox-Android", "FlateFilter: premature end of stream due to a DataFormatException");
                    }
                } finally {
                    inflater.end();
                }
            }
        }
        outputStream.flush();
    }

    @Override // com.tom_roush.pdfbox.filter.Filter
    public DecodeResult decode(InputStream inputStream, OutputStream outputStream, COSDictionary cOSDictionary, int i2) throws IOException {
        try {
            decompress(inputStream, Predictor.wrapPredictor(outputStream, getDecodeParams(cOSDictionary, i2)));
            return new DecodeResult(cOSDictionary);
        } catch (DataFormatException e2) {
            Log.e("PdfBox-Android", "FlateFilter: stop reading corrupt stream due to a DataFormatException");
            throw new IOException(e2);
        }
    }

    @Override // com.tom_roush.pdfbox.filter.Filter
    public void encode(InputStream inputStream, OutputStream outputStream, COSDictionary cOSDictionary) throws IOException {
        Deflater deflater = new Deflater(Filter.getCompressionLevel());
        DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(outputStream, deflater);
        IOUtils.copy(inputStream, deflaterOutputStream);
        deflaterOutputStream.close();
        outputStream.flush();
        deflater.end();
    }
}
