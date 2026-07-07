package com.ss.android.ok;

import com.tom_roush.pdfbox.pdmodel.common.PDPageLabelRange;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: classes2.dex */
public class ok implements a {
    private final RandomAccessFile ok;

    public ok(File file) throws FileNotFoundException {
        this.ok = new RandomAccessFile(file, PDPageLabelRange.STYLE_ROMAN_LOWER);
    }

    @Override // com.ss.android.ok.a
    public void a() throws IOException {
        this.ok.close();
    }

    @Override // com.ss.android.ok.a
    public long ok() throws IOException {
        return this.ok.length();
    }

    @Override // com.ss.android.ok.a
    public int ok(byte[] bArr, int i2, int i3) throws IOException {
        return this.ok.read(bArr, i2, i3);
    }

    @Override // com.ss.android.ok.a
    public void ok(long j, long j2) throws IOException {
        this.ok.seek(j);
    }
}
