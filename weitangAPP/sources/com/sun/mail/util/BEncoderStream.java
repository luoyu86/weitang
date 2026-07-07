package com.sun.mail.util;

import androidx.appcompat.widget.ActivityChooserView;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public class BEncoderStream extends BASE64EncoderStream {
    public BEncoderStream(OutputStream outputStream) {
        super(outputStream, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    public static int encodedLength(byte[] bArr) {
        return ((bArr.length + 2) / 3) * 4;
    }
}
