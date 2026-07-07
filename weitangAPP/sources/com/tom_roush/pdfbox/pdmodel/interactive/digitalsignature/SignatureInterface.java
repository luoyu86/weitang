package com.tom_roush.pdfbox.pdmodel.interactive.digitalsignature;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public interface SignatureInterface {
    byte[] sign(InputStream inputStream) throws IOException;
}
