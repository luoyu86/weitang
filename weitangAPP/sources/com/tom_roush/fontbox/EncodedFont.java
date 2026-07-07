package com.tom_roush.fontbox;

import com.tom_roush.fontbox.encoding.Encoding;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public interface EncodedFont {
    Encoding getEncoding() throws IOException;
}
