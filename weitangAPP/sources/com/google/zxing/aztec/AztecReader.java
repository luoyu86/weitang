package com.google.zxing.aztec;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.aztec.decoder.Decoder;
import com.google.zxing.aztec.detector.Detector;
import com.google.zxing.common.DecoderResult;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class AztecReader implements Reader {
    @Override // com.google.zxing.Reader
    public Result decode(BinaryBitmap binaryBitmap) throws NotFoundException, FormatException {
        return decode(binaryBitmap, null);
    }

    @Override // com.google.zxing.Reader
    public void reset() {
    }

    @Override // com.google.zxing.Reader
    public Result decode(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        ResultPointCallback resultPointCallback;
        AztecDetectorResult aztecDetectorResultDetect = new Detector(binaryBitmap.getBlackMatrix()).detect();
        ResultPoint[] points = aztecDetectorResultDetect.getPoints();
        if (map != null && (resultPointCallback = (ResultPointCallback) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK)) != null) {
            for (ResultPoint resultPoint : points) {
                resultPointCallback.foundPossibleResultPoint(resultPoint);
            }
        }
        DecoderResult decoderResultDecode = new Decoder().decode(aztecDetectorResultDetect);
        Result result = new Result(decoderResultDecode.getText(), decoderResultDecode.getRawBytes(), points, BarcodeFormat.AZTEC);
        List<byte[]> byteSegments = decoderResultDecode.getByteSegments();
        if (byteSegments != null) {
            result.putMetadata(ResultMetadataType.BYTE_SEGMENTS, byteSegments);
        }
        String eCLevel = decoderResultDecode.getECLevel();
        if (eCLevel != null) {
            result.putMetadata(ResultMetadataType.ERROR_CORRECTION_LEVEL, eCLevel);
        }
        return result;
    }
}
