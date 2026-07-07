package com.google.zxing;

import com.google.zxing.common.BitMatrix;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface Writer {
    BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i2, int i3) throws WriterException;

    BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i2, int i3, Map<EncodeHintType, ?> map) throws WriterException;
}
